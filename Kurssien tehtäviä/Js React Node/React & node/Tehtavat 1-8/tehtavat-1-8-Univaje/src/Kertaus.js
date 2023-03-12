import { useState} from 'react';

// function Kertaus(){}
// ES6 arrow syntax 
const Kertaus = () => {

console.log("Kertaus render ...")

    // State muuttujat
    const [nimet, setNimet] = useState([]);
    const [nimi, setNimi] = useState('');

    // Tässä EI siis tarvita event parametria, on vain esimerkin vuoksi
    const lisaaButtonClicked = (event) => {
        // Vaihtoehto 1:
        // let data = nimet;
        // data.push(nimi); // data.push({etunimi : "Keijo", osoite : address});
        // setNimet(data);
        // console.log("Nimet", nimet)

        // Vaihtoehto 2:
        setNimet([...nimet, nimi]); // -> setNimet(['liisa', 'Maija', 'Keijo', nimi])
        console.log("Nimet", nimet)
    }



    // Vaihtoehto b
    const txt = nimi == "" ? <h6>No name</h6> : null;

    // Vaihtoehto c
    let otsikko = null;
    if ( nimi == "" ) otsikko = <h5>Jee, ei ole nimeä</h5>


    return (
        <div>
            {otsikko}
            {txt}
            {
                // Vaihtoehto a
                nimi == "" ? 
                <p>Nimeä ei ole syötetty</p> :
                null
            }            
            <p>Terve maailma henkilö: {nimi}!</p>
            <input type="text" onChange={(e) => setNimi(e.target.value)} />
            <button onClick={(e) => lisaaButtonClicked(e)}>Lisaa</button>

            <Lista data={nimet} otsikko="Minun lista" />
        </div>
    )
}

// Vaihtoehto 1:
//const Otsikko = (param) => <h4>{param.header}</h4> 

// Vaihtoehto 2:
export const Otsikko = (param) => {
    return (<h4>{param.header}</h4>);
}


 function Lista(props){
//const Lista = (props) => {

    const lista = props.data.map((n, index) => {
        return <li key={index}>{n}</li>
    })

    let vari = 'blue';

    return (
        <div>
            <Otsikko header={props.otsikko} />
            <p style={{color : vari}}>Listalla on {lista.length} kpl</p>
            <ul>{lista}</ul>
        </div>
    )
}

// Named export
// Voidaan exportata useampia komponentteja
export {
    Kertaus,
    Lista
}