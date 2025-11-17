/*
9. Tee React komponentti (<Cars>), jossa käyttäjä voi syöttää automerkkejä input-kenttään (type=text).
Kun käyttäjä painaa Save-nappia (button), lisätään tiedot nappien alla olevaan ul-elementtiin niin että 
tiedot näkyvät li-elementissä (näytä syötetty tieto sellaisenaan, esimerkiksi "Volvo"). 
Tyhjennä syöttökentän (input) arvo Save-napin painamisen jälkeen.
 
10. Lisää edelliseen tehtävään: kun käyttäjä on syöttänyt vähintään 5 nimeä,
 näkyy h2-elementissä teksti "Ainakin 5 nimeä on jo syötetty". 
 Tee tätä varten uusi komponentti (<Info>), joka renderöi em. tekstin. 
 <Info>-komponentille välitetään props:n "count" avulla lukumäärä.
*/
import { useState } from 'react';

const Cars = () => {
    const [Autot, setAutot] = useState([]);
    const [auto, setAuto] = useState('');
    const [Count, setCount] = useState(0);

    const AddCarsClicked = (event) => {
        if (auto != '') {
            setAutot([...Autot, auto]);
            setCount(Count + 1);
            setAuto('');
            console.log("paskaa")
        }
    }

    function Lista(Autot) {
        const lista = Autot.map((n, index) => {
            return <li key={index} >{n}</li>
        })
        return lista
    }

    return (
        <div>
            <input value={auto} type="text" onChange={e => setAuto(e.target.value)} />
            <button onClick={(e) => AddCarsClicked(e)}>Save</button>
            <ul>
                {Lista(Autot)}
            </ul>
            <Info count={Count} />
        </div>
    )
}

function Info(props) {
    return (props.count >= 5 ? <h2>Ainakin 5 nimeä on jo syötetty</h2> : null)
}

export {
    Cars, Info
}