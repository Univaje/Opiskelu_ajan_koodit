
// ASENNA ensin tarvittaessa:
// npm install express
// npm install mysql

var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');

let port = 3002;
let hostname = "127.0.0.1";

app.use(bodyParser.json());

var cors = function (req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
}

app.use(cors);


app.get('/savonia', function (req, res) {
    //http://localhost:3000/savonia?nimi=maija&osoite=teku
    let nimi = req.query.nimi;  // ?-merkin jälkeen tuleva data 
    let osoite = req.query.osoite;
    res.statusCode = 200;
    res.setHeader('Content-type', 'text/html');
    res.end("<html><head></head><body><p>TERVE " + nimi + ", " + osoite + "</p></body></html>");
});

/************************************/
var connection = mysql.createConnection({
    host: 'localhost',
    port: '3306',
    user: 'root',      // ÄLÄ KOSKAAN käytä root:n tunnusta tuotannossa
    password: 'root',
    database: 'student',
    dateStrings: true
});
const virhesyotteet = (body) => {

    const { etunimi, sukunimi, lahiosoite, postinro, postitoimipaikka, typeid, osoiteid } = body;
    let Virheet = [];
    if (!etunimi) Virheet.push("etunimi");
    if (!sukunimi) Virheet.push("sukunimi");
    // if ( !lahiosoite ) Virheet.push("lahiosoite");
    if (!postinro) Virheet.push("postinro");
    //if ( !postitoimipaikka ) Virheet.push("postitoimipaikka");
    if (typeid < 0) Virheet.push("typeid");
    if (osoiteid < 0) { Virheet.push("osoiteid") };

    return Virheet;

}

app.post('/api/student', (req, response) => {


    const tiedot = virhesyotteet(req.body);
    if (tiedot.length > 0) {
        console.log("virheet" + tiedot);
        response.statusCode = 400;
        response.json({ statusid: "NOT OK", message: "Pakollisia tietoja puuttuu:" + tiedot.join(",") })
        return;
    }


    const { etunimi, sukunimi, lahiosoite, postinro, postitoimipaikka, typeid, osoiteid } = req.body;

    
    let typeidvalidi = "select status from studentype where typeid = ?";
    connection.query(typeidvalidi, [typeid], function (error, result, fields) {
        if (error) {
            response.statusCode = 418;
            response.json({ statusid: "Teepot", message: "Not a coffee pot" });
        }
        else{
            let status = result.length > 0 ? result[0].status : 0;
            if(status == 1){
                response.statusCode = 400;
                response.json({ statusid: "NOT OK", message: "Tyyppi Vanhentunut ei ole käytössä" });
            }
            else{

                  var osoite = osoiteid;
    let query1 = "Select etunimi,sukunimi from student where etunimi = ? AND sukunimi = ?"
    console.log("query: " + query1);
    connection.query(query1, [etunimi, sukunimi], function (error, result, fields) {
        Kanimi = result.length > 0 ? result[0].etunimi : "";
        Kasuku = result.length > 0 ? result[0].sukunimi : "";
        if (error || Kanimi != "" && Kasuku != "") {
            console.log("Virhe", error);
            response.statusCode = 400;
            response.json({ statusid: "NOT OK", message: "Opiskelija " + etunimi + "," + sukunimi + " on jo olemassa" });
        }
        else {
            if (!osoite) {
                console.log("pääsin tänne " + osoite)
                let haeosoiteid = "select idosoite from osoite where lahiosoite = ?"
                connection.query(haeosoiteid, [lahiosoite], function (error, result, fields) {
                    osid = result.length > 0 ? result[0].idosoite : 0
                    console.log("osid on " + osid)
                    if (error) {
                        response.statusCode = 418;
                        response.json({ statusid: "Teepot", message: "Not a coffee pot" });
                    }
                    else {
                        if (osid > 0) {
                            osoite = osid;
                            let query = "INSERT INTO student (etunimi, sukunimi,osoite_idosoite, postinro, typeid ) VALUES (?, ?, ?, ?, ? )";
                            console.log("Query osid" + osoite);
                            connection.query(query, [etunimi, sukunimi, osoite, postinro, typeid,], function (error, result, fields) {
                                if (error) {
                                    console.log("Virhe", error);
                                    response.statusCode = 400;
                                    response.json({ status: "NOT OK", msg: "Tekninen virhe!" });
                                }
                                else {
                                    console.log("Got here")
                                    response.statusCode = 201;
                                    response.json();
                                }
                            });

                        }
                        else {
                            let lisaaosite = "insert into osoite (lahiosoite) values (?)"
                            connection.query(lisaaosite, [lahiosoite], function (error, result, fields) {

                                if (error) {
                                    response.statusCode = 418;
                                    response.json({ statusid: "Teepot", message: "Not a coffee pot" });
                                }
                                else {
                                    console.log("uusi id on " + result.insertId)
                                    osoite = result.insertId;

                                    let varmistaposti = "select postinumero from postinro where postinumero = ?"
                                    connection.query(varmistaposti, [postinro], function (error, result, fields) {
                                        if (error) {
                                            console.log("Virhe", error);
                                            response.statusCode = 418;
                                            response.json({ statusid: "Teepot", message: "Not a coffee pot" });
                                        }
                                        else {
                                            postinr = result.length > 0 ? result[0].postinumero : "";
                                                if (postinr == "") {
                                                    let lisaaposti = "insert into postinro (postinumero,postitoimipaikka) values (?,?)"
                                                    connection.query(lisaaposti, [postinro, postitoimipaikka], function (error, result, fields) {
                                                        if (error) {
                                                            console.log("Virhe", error);
                                                            response.statusCode = 418;
                                                            response.json({ statusid: "Teepot", message: "Not a coffee pot" });
                                                        }
                                                        else{
                                                            let query = "INSERT INTO student (etunimi, sukunimi,osoite_idosoite, postinro, typeid ) VALUES (?, ?, ?, ?, ? )";
                                                        console.log("Query osid" + osoite);
                                                        connection.query(query, [etunimi, sukunimi, osoite, postinro, typeid,], function (error, result, fields) {
                                                            if (error) {
                                                                console.log("Virhe", error);
                                                                response.statusCode = 400;
                                                                response.json({ status: "NOT OK", msg: "Tekninen virhe!" });
                                                            }
                                                            else {
                                                                console.log("Got here")
                                                                response.statusCode = 201;
                                                                response.json();
                                                            }
                                                        });
                                                        }
                                                    });
                                                
                                                }
                                                else{
                                                    let query = "INSERT INTO student (etunimi, sukunimi,osoite_idosoite, postinro, typeid ) VALUES (?, ?, ?, ?, ? )";
                                                    console.log("Query osid" + osoite);
                                                    connection.query(query, [etunimi, sukunimi, osoite, postinro, typeid,], function (error, result, fields) {
                                                        if (error) {
                                                            console.log("Virhe", error);
                                                            response.statusCode = 400;
                                                            response.json({ status: "NOT OK", msg: "Tekninen virhe!" });
                                                        }
                                                        else {
                                                            console.log("Got here")
                                                            response.statusCode = 201;
                                                            response.json();
                                                        }
                                                    }); 
                                                }
                                        }  
                                    });
                                }
                            });
                        }
                    }
                });
            }
            else {
                console.log("ID on " + osoite)
                let query = "INSERT INTO student (etunimi, sukunimi,osoite_idosoite, postinro, typeid ) VALUES (?, ?, ?, ?, ? )";

                connection.query(query, [etunimi, sukunimi, osoite, postinro, typeid,], function (error, result, fields) {
                    if (error) {
                        console.log("Virhe", error);
                        response.statusCode = 400;
                        response.json({ status: "NOT OK", msg: "Tekninen virhe!" });
                    }
                    else {
                        console.log("Got here")
                        response.statusCode = 201;
                        response.json();
                    }
                });

            }
        }
    });
            }
            
        }});



  

});



module.exports = app