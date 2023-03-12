class Oppilas{
 
    /*
    29. Tee Javascript koodi, jossa esittelet luokat Oppilas käyttäen class-määrittelyä 
    (class declaration). Oppilas-luokalla on seuraavat jäsenmuuttujat: nimi, syntymävuosi, osoite, puhelinnumero. 
    
    Oppilas-luokalla on lisäksi metodit:
    - tulosta (tulostaa kaikki jäsenmuuttujien arvot)
    - laskeIka (laskee oppilaan iän syntymävuoden perusteella, 
    riittää laskea vain vuoden tarkkuudella, ei tarvitse pyöristellä mitenkään)

    Käytä tehtävässä gettereitä/settereitä jäsenmuuttujien käsittelyyn, syntymävuosi 
    täytyy olla Javascript:n Date-muodossa. Instantioi luokka ja kutsu sen funktioita jotenkin.
    */ 
    constructor(nimi, syntymavuosi, osoite, puhelinnumero){
        this.nimi = nimi;
        this.syntymavuosi =  syntymavuosi;
        this.osoite = osoite;
        this.puhelinnumero = puhelinnumero;
        this.arvosanat = [];
    }

        set nimi(value){
            if(value.lenght == 0)
                return;
            this._nimi = value;
        }
        set syntymavuosi(value){
                 this._syntymavuosi = new Date(value);
        }
        set osoite(value){
            if(value.lenght == 0)
                return;
            this._osoite = value;
        }
        set puhelinnumero(value){
            if(value.lenght == 0)
                return;
            this._puhelinnumero = value;
        }
        get nimi(){
            return this._nimi;
        }
        get syntymavuosi(){
            return this._syntymavuosi;
        }
        get osoite(){
            return this._osoite;
        }
        get puhelinnumero(){
            return this._puhelinnumero;
        }
        
        tulosta(){
            return "Oppilas : "+this._nimi+" Osoite : "+ this._osoite+" Syntymävuosi : "+this._syntymavuosi+" Puhelin : "+ this._puhelinnumero;
        }
        laskeIka(){
            return "Oppilaan ikä on :" + Math.round((Date.now()-this._syntymavuosi)/31104000000);
        }
        LisaaArvosana(Tulos){
            if (Tulos instanceof Arvosana){
                this.arvosanat.push(Tulos);
            }
        }
        printArvosana(){
            for (var arvosana of this.arvosanat) 
                if(arvosana instanceof Arvosana)    
                    console.log(arvosana.tulostaArvosana());
        }
        /*
        
        32. Lisää edelliseen tehtävään: Oppilas-luokalla on getteri HyvaOppilas ja KurssitLapi. 
        HyvaOppilas palauttaa true, jos oppilaalla on yksikin kurssi arvosanalla 5. KurssitLapi palauttaa true, 
        jos kaikkien kurssien arvosana on vähintään 1. 
        Käytä tehtävässä some() ja every()-metodeja (löytyvät Array-luokalta).
        */
        hyva = function(Arvosanat){
            return (Arvosanat._arvosana > 5 ? true:false); 
        }
        lapi = function(arvo){
            return (arvo._arvosana > 0 ? true: false);
        }
        get HyvaOppilas(){
            return this.arvosanat.some(this.hyva);
        }

        get KurssitLapi(){
            return this.arvosanat.every(this.lapi);
        }
 
        /*
        33. Lisää oppilas-luokalle metodi tulostaArvosanatMuutetullaAsteikolla, joka muuttaa arvosanat asteikolle 0-5
        (logiikalla 1 ja 2 -> 1,
        3-4 -> 2,
        5-6 -> 3,
        7-8 ->4  ja
        9-10 ->5 ). Käytä tehtävässä map() metodia.*/ 

        tulostaArvosanatMuutetullaAsteikolla(){
            var arr = this.arvosanat.map((x) => Math.round(x._arvosana/2));
            for (var tulosta of arr)
                console.log(" Arvosana : "+tulosta);
        }

}
    /*
    31. Lisää tehtävään 29: esittele luokka Arvosana, joka sisältää jäsenmuuttujat seuraaville tiedoille:
    oppiaine, arvosana, suorituspvm (muuttujien tarkoitus lienee arvattavissa).
    Esittele lisäksi Oppilas-luokkaan jäsenmuuttuja, joka pitää sisällään taulukollisen arvosanoja 
    (jokainen taulukon alkio on siis tyyppiä Arvosana). Lisää myös Oppilas-luokkaan metodi LisaaArvosana, 
    joka lisää uuden Arvosana-olion em. taulukkoon. Oppilas-luokalla on myös metodi printArvosana,
    joka tulostaa kaikki ko. oppilaan arvosanat (oppiaine, arvosana, pvm).
    */
class Arvosana{
    constructor(oppiaine, arvosana, suorituspvm){
        this.arvosana = arvosana;
        this.oppiaine = oppiaine;
        this.suorituspvm = suorituspvm;
    }
    set arvosana(value){
        if(value < 0 || value > 10)
            return;
        this._arvosana = value;
    }
    set oppiaine(value){
        if(value.lenght == 0)
            return;
        this._oppiaine = value;
    }
    set suorituspvm(value){
        this._suorituspvm = new Date(value);
    }
    get oppiaine(){
        return this._oppiaine;
    }
    get arvosana(){
        return this._arvosana;
    }
    get suorituspvm(){
        return this._suorituspvm;
    }
    tulostaArvosana(){
        return "Oppiaine : "+this._oppiaine+" Arvosana : "+this._arvosana+" Suorituspäivämäärä :"+this._suorituspvm;
    }
}
var OpiskelijaAku = new Oppilas("Aku","1973-7-7","Paratiisitie 13"," 050-Tyhjantoimittaja");
console.log(OpiskelijaAku);
console.log(OpiskelijaAku.tulosta());
console.log(OpiskelijaAku.laskeIka());
var AkunArvosana = new Arvosana("TRA",3,"1974-9-11");
var AkunArvosana1 = new Arvosana("Web-ohjelmointi",1,"1974-9-11");
var AkunArvosana2 = new Arvosana("Tyhjäntoimitus",10,"1974-9-11");
OpiskelijaAku.LisaaArvosana(AkunArvosana);
OpiskelijaAku.LisaaArvosana(AkunArvosana1);
OpiskelijaAku.LisaaArvosana(AkunArvosana2);
OpiskelijaAku.printArvosana();
var Lapimeni = () =>{
    if (OpiskelijaAku.KurssitLapi)
        console.log("koulu käyty");
    else
        console.log("Uusiksi!");
}
Lapimeni();
var hyvaopiskelija = () =>{
    if (OpiskelijaAku.HyvaOppilas)
        console.log("Hyvä Aku!");
        else 
        console.log("huono Aku!");
}
hyvaopiskelija();
OpiskelijaAku.tulostaArvosanatMuutetullaAsteikolla();
    