/*11. Tee React-komponetti (<ListForm>), jossa käyttäjä voi syöttää nimen, osoitteen ja syntymävuoden
 (input type=text elementin avulla, laita jokaiselle input-kentälle label, jossa on teksti Nimi/osoite/Syntymävuosi).
  Kun käyttäjä painaa Add-nappia (button), lisätään tiedot nappien alla olevaan ul-elementtiin niin että tiedot 
  näkyvät li-elementissä muodossa "Maija,Opistotie,1990". Tyhjennä myös syöttö-kentät Add-napin painamisen jälkeen.

12. Lisää tehtävään 11: tarkista että käyttäjä syöttänyt vähintään 4 merkkiä jokaiseen kenttään 
(jos syötteissä on virheitä, ei tietoja saa lisätä ul-elementtiin). Jos merkkejä on vähemmän, 
näytetään käyttäjälle <p>-elementissä virheteksti muodossa "Virheelliset kentät: nimi,osoite,vuosi" 
(jos virheitä ei ole, ei näytetä mitään ja näytä vain se kenttä, jossa virhe oli). 
Virheiden näyttäminen pitää toteuttaa komponentin <Error> avulla. <Error>-komponentti
saa props:na tiedon syötetyistä kentistä (props:t ovat nimi, osoite, vuosi). 
Virheiden tarkistaminen tehdään vasta kun käyttäjä klikkaa Add-nappia.

13. Lisää tehtävään 11: tarkista ettei nimeä ole jo syötetty aiemmin. 
Jos nimi löytyy jo, näytä punaisella värillä virheteksti "Nimi Liisa on jo syötetty".
 Virheviestin näyttäminen pitää tehdä komponentin <ErrorMessage> avulla, komponentille 
 välitetään vain virheviesti props:na ("message"). Kun käyttäjä muuttaa nimeä ja painaa 
 uudelleen Add-nappia, häviää virheteksti.*/

import { useState } from 'react';

const ListForm = () => {
    const [Lista, setLista] = useState([]);
    const [nimi, setNimi] = useState('');
    const [osoite, setosoite] = useState('');
    const [vuosi, setVuosi] = useState('');
    const [message, setMessage] = useState('');
    const [tst, settst] = useState('');

    function Forlist(tiedot) {
        const purettulista = tiedot.map((data, index) => {
            return <li key={index} >{data.nimi + "," + data.osoite + "," + data.vuosi}</li>
        })
        return (purettulista)
    }

    function samat(listasta, etsittava) {
        console.log(listasta.nimi, etsittava)
        if (listasta.nimi != etsittava) {
            return false
        }
        return true
    }

    const handleSubmit = (event) => {
        event.preventDefault();

        let uusi = { nimi: nimi, osoite: osoite, vuosi: vuosi };

        if (Lista.some(item => samat(item, nimi))) {

            setMessage("Nimi " + nimi + " on jo syötetty")
        }
        else {
            let tarkastelu = Error(uusi)
            console.log(tarkastelu)
            if (tarkastelu == null) {
                setMessage('');
                Lista.push(uusi);
                setLista(Lista);
                console.log(Lista);
                setNimi('');
                setosoite('');
                setVuosi('');
                settst('');
            }
            else {
                settst(<Error nimi={nimi} osoite={osoite} vuosi={vuosi} />)
            }

        }

    }
    return (
        <div>
            <form onSubmit={(e) => handleSubmit(e)}>
                <label>
                    Nimi:
                    <input type="text" value={nimi} onChange={e => setNimi(e.target.value)} />
                </label>
                <br></br>
                <label>
                    osoite:
                    <input type="text" value={osoite} onChange={e => setosoite(e.target.value)} />
                </label>
                <br></br>
                <label>
                    Vuosi:
                    <input type="text" value={vuosi} onChange={e => setVuosi(e.target.value)} />
                </label>
                <br></br>
                <button onClick={(e) => handleSubmit(e)}>Add</button>
                <ul>
                    {Forlist(Lista)}
                </ul>
                <div><ErrorMessage message={message} /></div>
                {tst}
            </form>
        </div>
    )
}
function Error(props) {
    console.log(props);
    let virheet = "";
    let nimi = props.nimi + "";
    let osoite = props.osoite + "";
    let vuosi = props.vuosi + "";
    console.log(virheet, nimi, osoite, vuosi);
    if (nimi.length < 4) {
        virheet = "nimi";

        if (osoite.length < 4)
            virheet += ",osoite";

        if (vuosi.length < 4)
            virheet += ",vuosi";
    }
    else if (osoite.length < 4) {
        virheet = "osoite";
        if (vuosi.length < 4)
            virheet += ",vuosi";
    }
    else if (vuosi.length < 4) {
        virheet = "vuosi";
    }
    console.log(virheet);
    return virheet == "" ? (null) : <p>Virheelliset kentät: {virheet}</p>;
}


function ErrorMessage(props) {
    return (<h2 style={{ color: 'red', fontWeight: 'bold' }} >{props.message}</h2>)
}
export {
    ListForm, Error, ErrorMessage
}