/*
34. Tee React komponentti <Teht34>, joka tallettaa opiskelijoiden tietoja, opiskelijalla on kentät: id, nimi, aloitusvuosi.
 <Teht34>-komponentin  tehtävä on vain tallettaa data Context:iin  (tai tehtävä 37:n tapauksessa Redux:iin) ja renderöidä  
 <StudentForm>-komponentti.  <StudentForm>-komponentissa on kentät, 
 joiden avulla voidaan lisätä opiskelijoita input type=text, label:t ovat Id, Nimi ja Aloitusvuosi) 
 sekä Lisää-nappi.

Lisäksi sovelluksessa on komponentti <StudentList>, jonka avulla renderöit opiskelijan tiedot table-elementissä 
(näytä kaikki kentät järjestyksessä id, nimi, aloitusvuosi, laita otsikoiksi Nr, Name, Starting year). 
Käytä <StudentList>-komponenttia myös <Teht34>-komponentissa. Toteuta yksittäisen table:n rivin renderöinti omassa komponentissa 
<TableRow>, joka saa props:t id, nimi ja aloitusvuosi (ja renderöi näiden perusteella table:n rivin). StudentForm- 
ja StudentList-komponenteille EI saa viedä yhtään props:ia!

35. Lisää edelliseen tehtävään: opiskelija voidaan poistaa klikkaamalla kullakin opiskelijarivillä olevaa Poista-nappia. 
Poista-napin teksti täytyy olla muodossa "Poista xx", missä xx on poistettavan opiskelijan id. 
Poista-toimintoa varten EI saa viedä props:ia <TableRow>-komponentille ts. poisto-funktio pitää olla Context:ssa!

36. Lisää edelliseen tehtävään: <Teht34>-komponentissa on nappi "Lisää jakso", jota klikkaamalla voidaan lisätä opintojaksoja, 
opintojaksolla on seuraavat kentät: id, nimi, laajuus (input type=text, Label:t ovat Oid, Onimi, Olaajuus). 
Opintojaksot pitää myös tallettaa Context:iin. Toteuta myös komponentti <Opintojakso>, 
joka osaa näyttää talletetut opintojaksot select-elementissä niin että käytät <Opintojakso>-komponenttia 
<StudentForm>-komponentissa (ja <Opintojakso> -komponentille EI saa viedä props:ja). 
Opintojaksot eivät siis liity mitenkään opiskelijan tietoihin!

*/
import React, { useState, useContext } from 'react';

const DataContext = React.createContext({});

export function Teht34() {

    const [students, setStudents] = useState([]);
    const [courses, setcourses] = useState([]);
    const [Oid, OidChanged] = useState('666');
    const [Onimi, OnimiChanged] = useState('Satan');
    const [Olaajuus, OlaajuusChanged] = useState('666');

    const setData = (value) => {
        let temp = value;
        students.push(temp)
        setStoredData({...storedData, students: students});
        console.log(storedData);
    }
    const setCourses = () => {
        courses.push({Oid:Oid,Onimi:Onimi,Olaajuus:Olaajuus})
         setStoredData({ ...storedData, courses: courses})
    }

    const RemoveData = (value) => {
        students.splice(students.findIndex(item => item.id === value),1);
        setStoredData({...storedData, students: students});

    }

    const handleSubmit = (e) => {
        e.preventDefault();
    }
    const initState = {
        students:[], courses : [], setData: setData, setCourses : setCourses, RemoveData : RemoveData
    }

    const [storedData, setStoredData] = useState(initState);    console.log(storedData);
    return (
        <DataContext.Provider value={storedData}>
            <div> 
                <form onSubmit={(e) => handleSubmit(e)}>
                    <label htmlFor="name"></label><br />
                    <label>Oid<input type="text" name="Oid"  onChange={(event) => OidChanged(event.target.value)} /></label><br />
                    <label>Onimi<input type="text" name="Onimi"  onChange={(event) => OnimiChanged(event.target.value)} /></label><br />
                    <label>Olaajuus<input type="text" name="Olaajuus" onChange={(event) => OlaajuusChanged(event.target.value)} /></label><br/>
                    <button onClick={() => setCourses()}>Lisää jakso</button>
                </form>
                <StudentForm />
                <StudentList />
                
            </div>
        </DataContext.Provider>
    )
}

export const StudentForm = () =>{
    const dl = useContext(DataContext);
    const [id, idChanged] = useState('666');
    const [name, nameChanged] = useState('Satan');
    const [startyear, startyearChanged] = useState('666');
    
    const KasitteleLisays = (e) => {
        dl.setData({id: id, nimi: name, startyear: startyear})
        idChanged('');
        nameChanged('');
        startyearChanged('');
    }

    const handleSubmit = (e) => {
        e.preventDefault();
    }

   
    return (
            <div>
                <form onSubmit={(e) => handleSubmit(e)}>
                    <label>Id<input type="text" name="id" value={id} onChange={(event) => idChanged(event.target.value)} /></label><br />
                    <label>Nimi<input type="text" name="name" value={name} onChange={(event) => nameChanged(event.target.value)} /></label><br />
                    <label>Aloitusvuosi<input type="text"value={startyear} name="Startyear" onChange={(event) => startyearChanged(event.target.value)} /></label><br/>
                    <button onClick={() => KasitteleLisays()}>Lisää</button>
                </form>
                <Opintojakso/>
            </div>
    );
}
export const Opintojakso = () => {

    const dl = useContext(DataContext); 
    const kurssit = dl.courses.map((s, index) =>  <option key={index}>{s.Onimi},{s.Olaajuus}</option>)
    return (
        <select>
            {kurssit}
        </select>
    );
}
export function StudentList() {

    const dl = useContext(DataContext);
        const oppilaat = dl.students.map((k, index) => <TableRow key={index} id={k.id} nimi={k.nimi} aloitusvuosi={k.startyear}/>);
    return (
        <table>
        <thead>
            <tr>
                <td>Nr</td>
                <td>Name</td>
                <td>Starting year</td>
                <td>Poista</td>
            </tr>
        </thead>
        <tbody>
            {oppilaat}
        </tbody>
    </table>
    );
}

export function TableRow(props) {
    const dl = useContext(DataContext);
    const kasittelepoisto = (id) =>{
        dl.RemoveData(id)
    }
    return <tr key={props.index}>
        <td>{props.id}</td>
        <td>{props.nimi}</td>
        <td>{props.aloitusvuosi}</td>
        <td><button onClick={() => kasittelepoisto(props.id)}>Poista {props.id}</button></td>
    </tr>
}
