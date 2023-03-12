import logo from './logo.svg';
import './App.css';
import { useState} from 'react';

// React komponentti = funktio
// Tässä komponentti on siis LuentoApp
function LuentoApp() {
  
  // State muuttujat! Vain näissä voidaan "säilyttää" data!
  const [nimi, setNimi] = useState('X');
  const [autot, setAutot] = useState([]);

  // HUOM! Tämä on sallittua koska otsikkoa ei päivitetä
  const otsikko = <h4>Eka komponentti</h4>

  // EI toimi perinteinen muuttuja!!!
  //let nimi = "Ei nimeä";

  const paivitaClicked = () => {
    // Huomaa miten state-muuttuja päivitetään    
    //nimi = "Liisa";
    // tässä on vain esimerkkinä if, ei ole tarpeellinen
    if ( nimi != "")  
      setNimi("Liisa");
    console.log("PaivitaClicked kutsuttu")
  }

  const lisaaAutot = () => {
    setAutot(["Opel", "Toyota", "Volvo", "Audi", "Bmw"]);
  }

  console.log("LuentoApp ...");

  const data = autot.map((a, index) => {
    // Huomaa key-attribuutti, on listalla pakollinen React:ssa!
    return <li key={index}>{a}</li>
  });

  // Komponenttissa pitää olla return joka palauttaa renderoitavan html. Voi palauttaa myös null:ia
  // Huomaa tämä kommentti, kommentti on JSX:n ulkopuolella!
  return (
    <div>
      <h1 style={{color: 'red', border : '2px solid blue'}}>Nyt alkaa React</h1>
      <p>JS koodi laitetaan sulkujen sisään</p>
      {otsikko}
      <span>{nimi}</span>
      <br />
      <ul>{data}</ul>
      <p>Hello world!</p>
      {
        // HUOMAA onClick:n syntaksi!!!
      }
      <button onClick={() => paivitaClicked()}>Päivitä</button>
      <button onClick={() => lisaaAutot()}>Lisää autot</button>
      {
        // HUOM! Merkkijonon kanssa EI ole pakko käyttää kaarisulkuja
      }
      <Footer nimi={nimi} osoite={"Teku"} puhelin="no number" oma="xx" />
    </div>
  );
}

// Toinen komponenentti
// Käytetään ES6:n arrow syntaksia
// On sama kuin kirjoittaisit:
// function Footer(props){
//  
//}

// Komponenttien nimet pitää alkaa aina ISOLLA alkukirjaimella
// props-muuttuja sisältää n kpl kenttiä
const Footer = (props) => {

  console.log("props", props)
  return (
    <div>
      <p>This is footer</p>
      <p>Nimi on {props.nimi} ja osoite on {props.osoite}</p>
      <p>Puhlin on {props.puhelin}</p>
      <h6>Oliko postinumero tämä {props.postinro}</h6>
    </div>
  );
}


export default LuentoApp;
