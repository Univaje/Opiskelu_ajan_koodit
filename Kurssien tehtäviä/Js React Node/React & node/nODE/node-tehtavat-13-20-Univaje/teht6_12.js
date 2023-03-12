
// ASENNA ensin tarvittaessa:
// npm install express
// npm install mysql

var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');
app.use(bodyParser.json());
var cors = function (req, res, next)
{
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
}

app.use(cors);


app.get('/savonia', function(req, res){
    //http://localhost:3000/savonia?nimi=maija&osoite=teku
    let nimi = req.query.nimi;  // ?-merkin jälkeen tuleva data 
    let osoite = req.query.osoite;
    res.statusCode = 200;
    res.setHeader('Content-type', 'text/html');
    res.end("<html><head></head><body><p>TERVE " + nimi + ", " + osoite + "</p></body></html>");
});

/************************************/
var connection = mysql.createConnection({
    host : 'localhost',
    user : 'root',      // ÄLÄ KOSKAAN käytä root:n tunnusta tuotannossa
    password : '',
    database : 'customer',
    dateStrings : true
});


// Asiakastyypin lisääminen
// POST + body lohkossa lisättävä JSON-muodossa
app.post('/api/customer', (req,res) => {
    
    console.log("/api/customer. BODY:", req.body);

    let nimi = req.body.nimi;
    let osoite = req.body.osoite;
    let postinro = req.body.postinro;
    let postitmp = req.body.postitmp;
    let asty_avain = req.body.asty_avain;
   
    // Tarkista kentät -> jos virheitä -> palauta validi statuscode ja res.json    
    
    let query = "INSERT INTO asiakas (NIMI, OSOITE, POSTINRO, POSTITMP, ASTY_AVAIN, LUONTIPVM) VALUES (?, ?, ?, ?, ?, CURDATE()) ";

    // ÄLÄ TEE näin! SQL Injection!
    //let query = "INSERT INTO asiakastyyppi (LYHENNE, SELITE) VALUES ('" + lyhenne + "', '" + selite + "')";

    console.log("query:" + query);
    connection.query(query, [nimi, osoite, postinro, postitmp, asty_avain], function(error, result, fields){
    //connection.query(query,  function(error, result, fields){
    let lista = [];
    if (!req.body.nimi){
        lista.push("nimi")
    }
    if(!req.body.osoite){
        lista.push("osoite")
    }
    if(!req.body.postinro){
        lista.push("postinro")
    }
    if(!req.body.postitmp){
        lista.push("postitmp")
    }
    if(!req.body.asty_avain){
        lista.push("asty_avain")
    }


        console.log("nimi", nimi);
        if ( error )
        {
            console.log("Virhe", error);
            res.statusCode = 400;
            res.json({status : "NOT OK", message : "Pakollisia tietoja puuttuu:" + lista});
        }
        else
        {
            console.log("R:" , result);
            res.statusCode = 201;
            // Palautetaan juuri lisätty asiakastyyppi kutsujalle! HUOM! Kaikissa REST-rajapinnoissa EI välttämättä tehdä näin
            // ELI ei palauteta välttämättä mitään!
            res.json({avain: result.insertId, nimi : nimi,  osoite : osoite, postinro : postinro, postitmp : postitmp, asty_avain : asty_avain})
        }
    });
});

// Asiakastyypin poistaminen
// DELETE + param
app.delete('/api/customer/:id', (req,res) => {
    
    console.log("/api/customer/:id. PARAMS:", req.params);

    // HUOM! url:ssa oleva muuttuja löytyy params-muuttujasta, huomaa nimeäminen
    let id = req.params.id;
    
    let query = "DELETE FROM asiakas where AVAIN = ? ";
    
    console.log("query:" + query);
   
    connection.query(query, [id], function(error, result, fields){
        
        if ( id >= result.affectedRows)
        {
            console.log("Virhe", error);
            res.statusCode = 404;
            res.json({status : "NOT OK", message : "Poistettavaa asiakasta " + id + " ei löydy"});
        }
        else
        {
            console.log("R:" , result);

            res.statusCode = 204;   // 204 -> No content -> riittää palauttaa vain statuskoodi

            // HUOM! Jotain pitää aina palauttaa, jotta node "lopettaa" tämän suorituksen.
            // Jos ao. rivi puuttuu, jää kutsuja odottamaan että jotain palautuu api:sta
            res.json()
        }
    });
});


// Asiakastyypin muuttaminen
// PUT + param + body
app.put('/api/customer/:id', (req,res) => {
    
    console.log("/asiakastyyppi. PARAMS:", req.params);
    console.log("/asiakastyyppi. BODY:", req.body);

    let nimi = req.body.nimi;
    let osoite = req.body.osoite;
    let postinro = req.body.postinro;
    let postitmp = req.body.postitmp;
    let asty_avain = req.body.asty_avain;

    // HUOM! url:ssa oleva muuttuja löytyy params-muuttujasta, huomaa nimeäminen
    let id = req.params.id;
    
    let query = "UPDATE asiakas SET NIMI=?, OSOITE=?, POSTINRO=?, POSTITMP=?, ASTY_AVAIN=? where AVAIN = ? ";

    console.log("query:" + query);
    connection.query(query, [nimi, osoite, postinro, postitmp, asty_avain, id], function(error, result, fields){
        if ( error )
        {
            console.log("Virhe", error);
            res.statusCode = 400;
            res.json({status : "NOT OK", msg : "Tekninen virhe!"});
        }
        else
        {
            console.log("R:" , result);
            res.statusCode = 204;   // 204 -> No content -> riittää palauttaa vain statuskoodi

            // HUOM! Jotain pitää aina palauttaa, jotta node "lopettaa" tämän suorituksen.
            // Jos ao. rivi puuttuu, jää kutsuja odottamaan että jotain palautuu api:sta
            res.json()
        }
    });
});


// REST api -> GET 
app.get('/asiakastyyppi', (req,res) => {
    // localhost:3000/asiakastyyppi
    
    console.log("/asiakastyyppi. REQ:", req.query);
    let query = "SELECT AVAIN as id, LYHENNE as abbr , SELITE as note from asiakastyyppi WHERE 1=1 ";
    //let query = "SELECT * from asiakastyyppi WHERE 1=1 AND nimi='x' and osoite?";

    console.log("query:" + query);
    connection.query(query, function(error, result, fields){

        console.log("done")
        if ( error )
        {
            console.log("Virhe", error);
            res.json({status : "NOT OK", msg : "Tekninen virhe!"});
        }
        else
        {
            res.statusCode = 200;
            res.json(result);
        }
    });

    console.log("Kysely tehty")
});

/******************************* */
app.get('/test', function(req, res){
    res.statusCode = 200;
    res.setHeader('Content-type', 'text/plain');
    res.end("This is test");
});

app.get('*',function(req, res){
    console.log("R:", req.url);
    res.statusCode = 404;
    res.setHeader('Content-type', 'text/plain');
    res.end("Virheellinen osoite");
});
console.log("Wellcome to the woodoland where the grass is always green");
module.exports = app