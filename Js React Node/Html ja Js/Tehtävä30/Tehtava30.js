function Oppilas(nimi,osoite,spaiva,puhnum){
    
    let Tulosta = function(){
            return "Oppilas : "+nimi+" Osoite : "+ osoite+" Syntymävuosi : "+spaiva+" Puhelin : "+ puhnum;
        }
    let laskeIka = function(){
        spaiva1 = new Date(spaiva);
            return "Oppilaan ikä on :" + Math.round((Date.now()-spaiva1)/31104000000);
    }
    var Obj ={
        nimi : nimi,
        osoite : osoite,
        spaiva : spaiva,
        puhnum : puhnum,
        Tulosta : Tulosta,
        laskeIka : laskeIka
        }
        
    return Obj;
}


var Aku = new Oppilas("Aku","Paratiisitie 13","1973-7-7"," 050-Tyhjantoimittaja");
console.log(Aku);
console.log(Aku.Tulosta());
console.log(Aku.laskeIka());