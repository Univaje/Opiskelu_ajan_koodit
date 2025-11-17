



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

app.delete('/api/customer/:Teekannu', (req,res) => {
    let id = req.params.Teekannu;
    let query = "DELETE FROM Asiakas WHERE AVAIN = ? ";
    connection.query(query, [id], function(error, result, fields){
        if ( error || result.affectedRows == 0)
        {
            res.statusCode = 404;
            res.json({status : "NOT OK", message : "Poistettavaa asiakasta "+ id +" ei löydy",});
        }
        else
        {
            res.statusCode = 204; 
            res.json();
        }
    });
});

app.post('/api/customer', (req, res) => {
    var virheet =[];
    let nimi = req.body.nimi || "";
    let osoite = req.body.osoite || "";
    let postinro = req.body.postinro || "";
    let postitmp = req.body.postitmp || "";
    let asty_avain = req.body.asty_avain || "";
    if ( nimi == "") {virheet.push("nimi")}
    if ( osoite == "") {virheet.push("osoite")}
    if ( postinro == "") {virheet.push("postinro")}
    if ( postitmp == "") {virheet.push("postitmp")}
    if ( asty_avain == "") {virheet.push("asty_avain")}    
    let query = "INSERT INTO asiakas (NIMI, OSOITE, POSTINRO, POSTITMP, ASTY_AVAIN, LUONTIPVM, MUUTOSPVM ) "+
    "VALUES (?, ?, ?, ?, ?, CURDATE(), NOW() )";
    connection.query(query, [nimi, osoite, postinro, postitmp, asty_avain ], function(error, result, fields){
        
        if (error ) {
            res.statusCode = 400;
            res.json({ status: "NOT OK", message: "Pakollisia tietoja puuttuu:"+virheet.join(",") });
        }
        else {
            res.statusCode = 201;
            res.json({ avain: result.insertId, nimi: nimi,  osoite: osoite, postinro: postinro, postitmp: postitmp, asty_avain: asty_avain });
        }
    });
});

app.put('/api/customer/:Kattila', (req,res) => {
    let iidee = req.params.Kattila || "";
    var virheet =[];
    let query = "";
    let muutospvm = null;
    let nimi = req.body.nimi || "";
    let osoite = req.body.osoite || "";
    let postinro = req.body.postinro || "";
    let postitmp = req.body.postitmp || "";
    let asty_avain = req.body.asty_avain || "";
    if(req.body.muutospvm != null ){
        if (req.body.muutospvm == "") {muutospvm = 0;}
        else {muutospvm = new Date(req.body.muutospvm);
        muutospvm = muutospvm.getTime()/1000;
    }
}
    if ( nimi == "") {virheet.push("nimi")}
    if ( osoite == "") {virheet.push("osoite")}
    if ( postinro == "") {virheet.push("postinro")}
    if ( postitmp == "") {virheet.push("postitmp")}
    if ( asty_avain == "") {virheet.push("asty_avain")}
    if (iidee == NaN  || iidee < 0) {virheet.push("id")}
    if (muutospvm == null)
    {
        query = "UPDATE asiakas SET NIMI=?, OSOITE=?, POSTINRO=?, POSTITMP=?, ASTY_AVAIN=? where AVAIN = ? ";
        connection.query(query, [nimi, osoite, postinro, postitmp, asty_avain, iidee], function(error, result, fields){

            if ( error || result.affectedRows == 0)
            {
                res.statusCode = 400; 
                res.json({ status: "NOT OK", message: "Pakollisia tietoja puuttuu:"+virheet.join(",") });
            }
            else
            {
                res.statusCode = 204;  
                res.json()
            }
        });
    }
    
    else{
    query = "UPDATE asiakas SET NIMI=?, OSOITE=?, POSTINRO=?, POSTITMP=?, ASTY_AVAIN=? where AVAIN = ? AND MUUTOSPVM = FROM_UNIXTIME(?) ";
    connection.query(query, [nimi, osoite, postinro, postitmp, asty_avain, iidee, muutospvm], function(error, result, fields){
        if ( error || result.affectedRows == 0)
        {
            res.statusCode = 400; 
            res.json({ status: "NOT OK", message: "Tietoja ei voi päivittää, tiedot vanhentuneet"});
        }
        else
        {
            res.statusCode = 204; 
            res.json()
        }
    });
}
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

console.log("Wellcome to the woodoland where the grass is always green");
module.exports = app

