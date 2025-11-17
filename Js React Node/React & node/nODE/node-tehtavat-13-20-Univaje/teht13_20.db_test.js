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

/************************************/
var connection = mysql.createConnection({
    host: 'localhost',
    user: 'root',      // ÄLÄ KOSKAAN käytä root:n tunnusta tuotannossa
    password: 'root',
    database: 'student',
    dateStrings: true
});

const executeSQL = (query, params) => {
    return new Promise((resolve, reject) => {
        connection.query(query, params, function (error, results, fields) {
            error ? reject(error) : resolve(results);
        });
    })
}
module.exports = {

    initializeDatabase: async () => {

        await executeSQL("delete from student", []);
        await executeSQL("delete from studentype", []);
        await executeSQL("delete from postinro", []);
        await executeSQL("delete from osoite", []);

        await executeSQL("insert into studentype (typeid, selite, status) values(1, 'Varsinainen opiskelija', 0)", []);
        await executeSQL("insert into studentype (typeid, selite, status) values(2, 'Avoimen AMK:n opiskelija', 0)", []);
        await executeSQL("insert into studentype (typeid, selite, status) values(3, 'Muu opiskelija', 0)", []);
        await executeSQL("insert into studentype (typeid, selite, status) values(4, 'Vanhentunut', 1)", []);
        await executeSQL("insert into studentype (typeid, selite, status) values(5, 'Väärä', 1)", []);

        await executeSQL("insert into postinro (postinumero, postitoimipaikka) values ('00100','Helsinki')", []);
        await executeSQL("insert into postinro (postinumero, postitoimipaikka) values ('70100','Kuopio')", []);
        await executeSQL("insert into postinro (postinumero, postitoimipaikka) values ('70200','Kajaani 20')", []);
        await executeSQL("insert into postinro (postinumero, postitoimipaikka) values ('71800','Siilinjärvi')", []);

        await executeSQL("insert into osoite(idosoite, lahiosoite) values(1, 'Opistotie 2')", []);
        await executeSQL("insert into osoite(idosoite, lahiosoite) values(2, 'Microkatu 1')", []);
        await executeSQL("insert into osoite(idosoite, lahiosoite) values(3, 'Tekniikkapolku 23')", []);
        await executeSQL("insert into osoite(idosoite, lahiosoite) values(4, 'Kauppakatu 10')", []);

        await executeSQL("insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Kalle', 'Tappinen', 1, '70100', 1)", []);
        await executeSQL("insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Maija', 'Mehiläinen', 1, '70100', 2)", []);
        await executeSQL("insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Liisa', 'Leppänen', 3, '70200', 2)", []);
        await executeSQL("insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Teija', 'Testaaja 13-20', 3, '70100', 1)", []);
        await executeSQL("insert into student (etunimi, sukunimi, osoite_idosoite, postinro, typeid) values ('Maija', 'Makkonen', 2, '00100', 3)", []);
    }

}
