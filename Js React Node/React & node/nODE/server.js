
// ASENNA ensin tarvittaessa:
// npm install express
// npm install mysql

var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');

let port = 3004;
let hostname = "127.0.0.1";
let password = "root";
let user ="root";

app.use(bodyParser.json());

console.log("Aloitetaan");

var cors = function (req, res, next)
{
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
}

app.use(cors);


app.get('/api/savonia', function(req, res){
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
    database : 'asiakas',
    dateStrings : true
});

// REST api -> GET 
app.get('/asiakastyyppi', (req,res) => {
    // localhost:3000/asiakastyyppi
    
    console.log("/asiakastyyppi. REQ:", req.query);
    let query = "SELECT AVAIN as id, LYHENNE as abbr , SELITE as note from asiakastyyppi WHERE 1=1 ";
    //let query = "SELECT * from asiakastyyppi WHERE 1=1 AND nimi='x' and osoite='y'";

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

console.log("Serveri tulille nyt");

 /* app.listen(port, hostname, () => {
   console.log(`Server running at http://${hostname}:${port}/`);
 }); */

module.exports = app