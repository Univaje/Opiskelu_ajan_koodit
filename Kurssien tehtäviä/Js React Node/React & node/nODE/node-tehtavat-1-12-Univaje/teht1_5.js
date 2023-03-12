var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var mysql = require('mysql');
app.use(bodyParser.json());
var cors = function (req, res, next) {
    res.header('Access-Control-Allow-Origin', '*');
    res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE');
    res.header('Access-Control-Allow-Headers', 'Content-Type');
    next();
}

app.use(cors);


app.get('/api/customer', function (req, res) {
    let nimi = " AND A.nimi LIKE '" + req.query.nimi + "%'";
    let osoite = " AND A.osoite LIKE '" + req.query.osoite + "%'";
    let asty = " AND A.ASTY_AVAIN = " + req.query.asty;
    if (req.query.nimi == undefined) { nimi = ""; }
    if (req.query.osoite == undefined) { osoite = ""; }
    if (req.query.asty == undefined) { asty = ""; }
    console.log("/Customer.Pyyntö oli:", req.query);
    let query = "SELECT A.AVAIN, A.NIMI, A.OSOITE, A.POSTINRO, A.POSTITMP, A.LUONTIPVM, A.ASTY_AVAIN, AT.SELITE as ASTY_SELITE from Asiakas A JOIN asiakastyyppi AT on A.asty_avain = AT.avain  WHERE 1=1";
    query = query + nimi + osoite + asty;
    console.log("queryksi muodostui:" + query);
    connection.query(query, function (error, result, fields) {
        let data = result
        if (error || data.length == 0) {
            res.statusCode = 200;
            console.log("Virhe", result);
            res.json({ status: "NOT OK", message: "Virheellinen haku", data: data });
        }
        else {
            res.statusCode = 200;
            res.json({ status: "OK", message: "", data: data });
        }
    });
});

/************************************/
var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'customer',
    dateStrings: true
});

/*************************************/

app.get('/api/*', function (req, res) {
    console.log("R:", req.url);
    res.statusCode = 404;
    let query = "SELECT COUNT(*) AS Count from Asiakas WHERE 1=1 ";
    console.log("query:" + query);
    connection.query(query, function (error, result, fields) {
        let count = result[0].Count;
        res.json({ message: "Osoite oli virheellinen:" + req.url, count });
    });
});

console.log("Wellcome to the woodoland where the grass is always green");
module.exports = app