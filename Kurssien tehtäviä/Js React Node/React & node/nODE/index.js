var http = require("http");
var fs = require("fs");
var util=require('util');


// Luento 24.2.2022
// Node.js:n perusteet

// Tässä tiedostossa on esimerkki miten voidaan rakentaan node.js:n avulla oma web-serveri
// käyttäen vain node:n mukana tulevia kirjastoja (ts. ei asenneta mitään muita paketteja)
// Tämä on kuitenkin työläs tapa eikä mitenkään suositeltava, joten jatkossa tätä tapaa
// EI käytetä. Jatkossa asennetaan express-paketti ja käytetään sitä.

http.createServer(function(request, response){

    // Luetaan html filu ja palautetaan se selaimelle
    // Toki tässä ei ole järkeä, koska filu voidaan lukea suoraankin
    // Tässä oletetaan että serverin alla on hakemisto luento, jossa on tiedosto test.html

    
    fs.readFile("./test.html", function(err, data){
        console.log("luetaan filu")
        response.writeHead(200, {'Content-Type' : 'text/html'});
        response.write(data);
        response.end();    
    }); 

    var x = util.inspect(request);
//    console.log("x : " + x);

/*
    const { headers, url, method } = request;
    console.log("headers : " + JSON.stringify(headers) + ", url:" + url + ", method:" + method);

    if ( url == "/asiakas/123"){
        response.writeHead(200, {'Content-Type' : 'text/plain'});
        response.end("nimi:Maija|osoite:Opistotie 2|ponro:71800");
    }
    else {
        response.end("TYHJAAA");
    }
*/
    /*
    // Alla "täydellistä html:ää"
    response.writeHead(200, {'Content-Type' : 'text/html'});
    
    response.write("<!doctype>")
    response.write("<html><head><title>Eka sivu</title><head>");
    response.write("<body><p>Terve maailma, muista content-type</p></body></html>");
    response.end();    
    */
}).listen(3002);

console.log("Server running at http://localhost:3002");