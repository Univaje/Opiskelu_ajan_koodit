//npm run test -s teht13_20.test.js
var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql2');
// 13 ja 14 tehtynä

app.use(bodyParser.json());

var cors = function (req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
}

app.use(cors);



var connection = mysql.createConnection({
    host: 'localhost',
    port: '3306',
    user: 'root',      // ÄLÄ KOSKAAN käytä root:n tunnusta tuotannossa
    password: 'root',
    database: 'student',
    dateStrings: true
});

/*13. Toteuta REST api, jolla voidaan lisätä tietokantaan uusi opiskelija. Rajapinnan osoite on muotoa "/api/student",
 metodi on POST. Rajapintaan tuleva data tulee siis HTTP-body lohkossa JSON-objektina,
  kentät: etunimi, sukunimi, lahiosoite, postinro, postitoimipaikka, typeid, osoiteid. 
  HUOM! Tässä tehtävässä EI tule postitoimipaikka- eikä lahiosoite-kentässä tietoa, 
  joten lue vain postinro- ja osoiteid-kentän tiedot. Eikä tässä tehtävässä tarvitse tarkistaa,
  ovatko osoiteid ja postinro valideja tietokannan avaimia, riittää tarkistaa että osoiteid > 0 ja että postinro EI ole tyhjä. */

app.post('/api/student', (req, res) => {

    let etunimi = req.body.etunimi;
    let sukunimi = req.body.sukunimi;
    let osoiteid = req.body.osoiteid;
    let postinro = req.body.postinro;
    let typeid = req.body.typeid;
    let query = "INSERT INTO student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) VALUES (?,?,?,?,?)";


    //virheidentarkistus
    let errorMsg = [];
    if (!req.body.etunimi) errorMsg.push("etunimi");
    if (!req.body.sukunimi) errorMsg.push("sukunimi");
    if (!req.body.postinro) errorMsg.push("postinro");
    if (req.body.typeid < 0 || req.body.typeid == null) errorMsg.push("typeid");
    if (req.body.osoiteid < 0) errorMsg.push("osoiteid");
    errorMsg.join(',');

    let duplicates = [];
    console.log("query:" + query);

    // 14 -tehtävä
    connection.query("SELECT * from student where 1=1 AND etunimi = ? AND sukunimi = ?", [etunimi, sukunimi], (error, result, fields) => {
        console.log(duplicates.length);
        duplicates = result;
        if (duplicates.length > 0) {
            res.statusCode = 400;
            res.json({ statusid: "NOT OK", message: `Opiskelija ${duplicates[0].etunimi},${duplicates[0].sukunimi} on jo olemassa` });
        }
        else {
            //13 -tehtävä
            connection.query(query, [etunimi, sukunimi, osoiteid, postinro, typeid], function (error, result, fields) {
                if (error || errorMsg.length > 0) {
                    console.log("Virhe", error);
                    res.statusCode = 400;
                    res.json({ statusid: "NOT OK", message: "Pakollisia tietoja puuttuu:" + errorMsg });
                } else {
                    console.log("R:", result);
                    res.statusCode = 201;
                    res.json({ id: result.insertId, etunimi: etunimi, sukunimi: sukunimi, postinro: postinro, typeid: typeid, osoite_osoiteid: osoiteid })

                }
            });
        }
    })
});


// Asiakastyypin lisääminen
// POST + body lohkossa lisättävä JSON-muodossa
app.post('/asiakastyyppi', (req, res) => {

    console.log("/asiakastyyppi. BODY:", req.body);

    let lyhenne = req.body.abbr;
    let selite = req.body.note;

    // Tarkista kentät -> jos virheitä -> palauta validi statuscode ja res.json    

    let query = "INSERT INTO asiakastyyppi (LYHENNE, SELITE) VALUES (?, ?) ";

    // ÄLÄ TEE näin! SQL Injection!
    //let query = "INSERT INTO asiakastyyppi (LYHENNE, SELITE) VALUES ('" + lyhenne + "', '" + selite + "')";

    console.log("query:" + query);
    connection.query(query, [lyhenne, selite], function (error, result, fields) {
        //connection.query(query,  function(error, result, fields){

        if (error) {
            console.log("Virhe", error);
            res.statusCode = 400;
            res.json({ status: "NOT OK", message: "Tekninen virhe!" });
        }
        else {
            console.log("R:", result);
            res.statusCode = 201;
            // Palautetaan juuri lisätty asiakastyyppi kutsujalle! HUOM! Kaikissa REST-rajapinnoissa EI välttämättä tehdä näin
            // ELI ei palauteta välttämättä mitään!
            res.json({ id: result.insertId, abbr: lyhenne, note: selite })
        }
    });
});

app.post('/api/customer', (req, res) => {

    console.log("/customer. BODY:", req.body);
    var nimi = req.body.nimi;
    var osoite = req.body.osoite;
    var postinro = req.body.postinro;
    var postitmp = req.body.postitmp;
    var asty_avain = req.body.asty_avain;
    //var luontipvm = req.body.luontipvm;

    var errorMsg = [];
    if (req.body.nimi == null) errorMsg.push("nimi");
    if (req.body.osoite == null) errorMsg.push("osoite");
    if (req.body.postinro == null) errorMsg.push("postinro");
    if (req.body.postitmp == null) errorMsg.push("postitmp");
    if (req.body.asty_avain == null) errorMsg.push("asty_avain");

    errorMsg.join(',');



    // http://www-db.deis.unibo.it/courses/TW/DOCS/w3schools/sql/sql_dates.asp.html

    // INSERT INTO asiakas (NIMI, OSOITE, POSTINRO, POSTITMP, ASTY_AVAIN, LUONTIPVM) VALUES ("Olli", "Neulamaki", 70100, "Kuopio", 1, CURDATE());
    var query = "INSERT INTO asiakas (NIMI, OSOITE, POSTINRO, POSTITMP, ASTY_AVAIN, LUONTIPVM) VALUES (?, ?, ?, ?, ?, CURDATE()) ";
    console.log("query:" + query);

    connection.query(query, [nimi, osoite, postinro, postitmp, asty_avain], function (error, result, fields) {

        if (error || errorMsg) {
            console.log("Virhe", error);
            console.log("errormsg", errorMsg);
            res.statusCode = 400;
            res.json({ status: "NOT OK", message: "Pakollisia tietoja puuttuu:" + errorMsg });
        }
        else {
            console.log("R:", result);
            res.statusCode = 201;
            // Palautetaan juuri lisätty asiakastyyppi kutsujalle! HUOM! Kaikissa REST-rajapinnoissa EI välttämättä tehdä näin
            // ELI ei palauteta välttämättä mitään!
            // result.insertId
            res.json({ avain: result.insertId, nimi: nimi, osoite: osoite, postinro: postinro, postitmp: postitmp, asty_avain: asty_avain }); // 
        }
    });

});

// Asiakastyypin poistaminen
// DELETE + param
app.delete('/asiakastyyppi/:id', (req, res) => {

    console.log("/asiakastyyppi. PARAMS:", req.params);

    // HUOM! url:ssa oleva muuttuja löytyy params-muuttujasta, huomaa nimeäminen
    let id = req.params.id;

    let query = "DELETE FROM asiakastyyppi where Avain = ? ";

    console.log("query:" + query);
    connection.query(query, [id], function (error, result, fields) {
        if (error) {
            console.log("Virhe", error);
            res.statusCode = 400;
            res.json({ status: "NOT OK", message: "Tekninen virhe!" });
        }
        else {
            console.log("R:", result);
            res.statusCode = 204;   // 204 -> No content -> riittää palauttaa vain statuskoodi

            // HUOM! Jotain pitää aina palauttaa, jotta node "lopettaa" tämän suorituksen.
            // Jos ao. rivi puuttuu, jää kutsuja odottamaan että jotain palautuu api:sta
            res.json()
        }
    });
});


// Asiakastyypin muuttaminen
// PUT + param + body
app.put('/asiakastyyppi/:id', (req, res) => {

    console.log("/asiakastyyppi. PARAMS:", req.params);
    console.log("/asiakastyyppi. BODY:", req.body);

    let lyhenne = req.body.abbr;
    let selite = req.body.note;

    // HUOM! url:ssa oleva muuttuja löytyy params-muuttujasta, huomaa nimeäminen
    let id = req.params.id;

    let query = "UPDATE asiakastyyppi SET LYHENNE=?, SELITE=? where AVAIN = ? ";

    console.log("query:" + query);
    connection.query(query, [lyhenne, selite, id], function (error, result, fields) {
        if (error) {
            console.log("Virhe", error);
            res.statusCode = 400;
            res.json({ status: "NOT OK", message: "Tekninen virhe!" });
        }
        else {
            console.log("R:", result);
            res.statusCode = 204;   // 204 -> No content -> riittää palauttaa vain statuskoodi

            // HUOM! Jotain pitää aina palauttaa, jotta node "lopettaa" tämän suorituksen.
            // Jos ao. rivi puuttuu, jää kutsuja odottamaan että jotain palautuu api:sta
            res.json()
        }
    });
});

module.exports = app