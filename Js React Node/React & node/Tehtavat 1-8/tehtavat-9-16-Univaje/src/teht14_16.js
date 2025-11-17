/*14. Tee React-komponentti <Professional>, jossa käyttäjä voi valita alasvetovalikosta ammatin. 
Komponentti saa props:na ammatit ("ammatit") taulukossa niin että jokainen ammatti on JS-objekti,
 jolla on kentät koodi ja selite (laita koodi option-elementin value-attribuutiksi ja selite näkyviin käyttäjälle).
  Käyttäjä voi lisäksi syöttää nimen (input type=text, laita jokaiselle input-kentälle label, 
    jossa on teksti Nimi/Ammatti). Kun käyttäjä painaa Insert-nappia, lisätään tiedot table-elementtiin 
    niin että elementissä on sarakkeet nimi ja koodi. Table-elementin renderöinti täytyy toteuttaa komponentissa
    <Table>, se saa props:na ("data") taulukollisen JS-objekteja, joilla on kentät nimi ja koodi (valitun ammatin koodi).
    tätä tehtävää varten komponentti <Teht14>, joka antaa <Professional>-komponentille tarvittavat props:t.

15. Muuta tehtävää 14: käyttäjä voi valita checkbox:sta onko hänellä tutkinto suoritettu 
(laita checkbox:lle Label-komponentin avulla label "Tutkinto suoritettu:"). 
Lisää JS-objektiin kenttä tutkinto_suoritettu, jossa 0=ei tutkintoa, 1=tutkinto suoritettu. 
Näytä <Table>-komponentin avulla tämä uusi sarake (tutkinto) niin että sarakkeeseen tulostuu "Tutkinto suoritettu" 
tai "Ei tutkintoa".

16. Muuta edellistä tehtävää: jos käyttäjä valitsee "Tutkinto suoritettu" (label-elementti "Tutkinto:") 
(checkbox siis valittu), tulee näkyviin uusi input-kenttä, johon käyttäjä voi syöttää tutkinnon nimen. 
Tutkinnon nimi täytyy lisätä myös taulukkoon (ja JS-objektiin, kentän nimi on tutkinto).
 */
import { useState } from 'react';

function Professional(props) {
    const [nimi, setNimi] = useState('');
    const [TableList, setTableList] = useState([]);
    const [selected, setSelected] = useState('');
    const [chchecked, setChChecked] = useState(false);
    const [TutkinnonNimi, setTutkinnonNimi] = useState('');
    const [suorite, setSuorite] = useState(0);

    const LisaaTaulukkoonClicked = (event) => {

        console.log(suorite)
        let uusi = { Nimi: nimi, Ammatti: selected, Suoritus: suorite, Tutkinto: TutkinnonNimi }
        TableList.push(uusi)
        setTableList(TableList);
        setNimi('');
        setTutkinnonNimi('');

    }

    const VaihdaTappa = (e) => {
        setSuorite(chchecked == true ? 0 : 1)
        setChChecked(!chchecked);
        
        
        console.log(suorite);
    }
    var ammatit = props.ammatit || [];
    var Valikko = ammatit.map((item, i) => {
        return <option key={i} value={item.koodi}>{item.selite}</option>
    })
    return (
        <div>
            <label>Nimi:
                <input type="text" value={nimi} onChange={(e) => setNimi(e.target.value)} />
            </label>
            <label>Ammatti:
                <select onChange={(e) => setSelected(e.target.value)}>{Valikko}</select>
            </label>
            <br></br>
            <label>Tutkinto suoritettu:
                <label>
                        <input type="checkbox" value={suorite} checked={chchecked} onChange={(e) => VaihdaTappa(e)} />
                </label>
                <br></br>
            </label>
            {chchecked ? 
            <label>Tutkinto:
                <input type="text" value={TutkinnonNimi} onChange={(e) => setTutkinnonNimi(e.target.value)} />
                </label> : null}
            <br></br>
            
            <button onClick={(e) => LisaaTaulukkoonClicked(e)}>Insert</button>
            <Table Data={TableList} />
        </div>
    )
}

const Teht14 = () => {
    const ammatit = [
        { koodi: '-1', selite: '--Valitse--' },
        { koodi: 'teacher', selite: 'Opettaja' },
        { koodi: 'police', selite: 'Poliisi' },
        { koodi: 'doctor', selite: 'Lääkäri' },
        { koodi: 'player', selite: 'Pelaaja' },
        { koodi: 'Arkkitecht', selite: "Arkkitehti" }
    ]
    return <div><Professional ammatit={ammatit} /></div>
}
function Table(props) {
    
    let data = props.Data || [];
    let text = "";
    console.log(data.Suoritus)
    var tiedot = data.map((data, i) => {
        if (data.Suoritus == 1)
            text = "Tutkinto suoritettu";
        else
            text = "Ei tutkintoa";
        return <tr key={i}>
            <td>{data.Nimi}</td>
            <td>{data.Ammatti}</td>
            <td>{text}</td>
            <td>{data.Tutkinto}</td>
        </tr>;
    })
    var otsikot = { Nimi: "Nimi", ammatti: "ammatti", Suoritus: "Suoritus:", Tutkinto: "Tutkinto" };
    return (
        <table>
            <thead>
                <tr>
                    <th>{otsikot.Nimi}</th>
                    <th>{otsikot.ammatti}</th>
                    <th>{otsikot.Suoritus}</th>
                    <th>{otsikot.Tutkinto}</th>
                </tr>
            </thead>
            <tbody>{tiedot}</tbody>
        </table>
    )
}
export { Professional, Teht14, Table }
