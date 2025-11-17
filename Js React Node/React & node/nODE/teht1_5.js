
// ASENNA ensin tarvittaessa:
// npm install express
// npm install mysql

var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');

let port = 3004;
let hostname = "127.0.0.1";

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

// REST api -> GET 
app.get('/api/customer', (req,res) => {
    // localhost:3000/asiakastyyppi
    
    console.log("/asiakas. REQ:", req.query);

    let nimi = req.query.nimi;
    let osoite = req.query.osoite;
    let asty = req.query.asty;
  
    

    let query = "SELECT asiakas.*, asiakastyyppi.SELITE as ASTY_SELITE from asiakas LEFT JOIN asiakastyyppi ON asiakas.ASTY_AVAIN=asiakastyyppi.AVAIN WHERE 1=1";
    

    if(nimi) query = query + " AND NIMI LIKE '" + nimi + "%" + "'"
    if(osoite) query = query + " AND OSOITE LIKE '" + osoite + "%" + "'"
    if(asty) query = query +" AND ASTY_AVAIN LIKE '" + asty + "%" + "'"


  
    


    //console.log("query:" + query);
    connection.query(query, [], function(error, result, fields){

        console.log("done")
        if (result < 1 )
        {
            console.log("Virhe", error);
            res.json({data: result,  status : "NOT OK", message: "Virheellinen haku"});
        }
        
        else
        {
            res.statusCode = 200;
            res.json({data: result, status: "OK", message: ""});
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

    let query = "SELECT COUNT(*) AS count FROM asiakas";

    connection.query(query, function(error, result, fields){

    console.log("result:", result);

    console.log("result:", result[0].count);

    console.log("R:", req.url);
    res.statusCode = 404;
    res.json({message: "Osoite oli virheellinen:" + req.url, count: result[0].count});

    });
});
    



console.log("Serveri tulille nyt");

// app.listen(port, hostname, () => {
//   console.log(`Server running at http://${hostname}:${port}/`);
// });

module.exports = app