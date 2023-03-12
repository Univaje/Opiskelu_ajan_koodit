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
import React, { useState } from 'react';
import { createStore } from "redux";
import { useDispatch, useSelector } from "react-redux";


export function Teht37() {
    const [Oid, OidChanged] = useState();
    const [Onimi, OnimiChanged] = useState('');
    const [Olaajuus, OlaajuusChanged] = useState('');
    const dispatch = useDispatch();
    const handleSubmit = (e) => {
        e.preventDefault();
    }
    const addCourseClicked = () => {
        dispatch(addCourse({Onimi:Onimi, Oid:Oid, Olaajuus:Olaajuus }));
    }
    return (
        <div>
                <form onSubmit={(e) => handleSubmit(e)}>
                    <label htmlFor="name"></label><br />
                    <label>Oid<input type="text" name="Oid" value={Oid} onChange={(event) => OidChanged(event.target.value)} /></label><br />
                    <label>Onimi<input type="text" name="Onimi"value={Onimi}  onChange={(event) => OnimiChanged(event.target.value)} /></label><br />
                    <label>Olaajuus<input type="text" name="Olaajuus"value={Olaajuus} onChange={(event) => OlaajuusChanged(event.target.value)} /></label><br/>
                    <button onClick={() => addCourseClicked()}>Lisää jakso</button>
                </form>
            <StudentForm />
            <StudentList />
        </div>
    );
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////



// ACTION TYPE
const ADD_STUDENT = "ADD_STUDENT";
const DELETE_STUDENT = "DELETE_STUDENT";
const ADD_COURSE = "ADD_COURSE";

// REDUCER
const initialState = {
    courses: [],
    students: []
};

// NOTE! Immutable state! 
// The resulting state is a copy of the current state added with the new data.
function rootReducer(state = initialState, action) {
    if (action.type === ADD_STUDENT) {
        // Create a copy (clone) of current state -> Object.assign
        // Then combine old array with new article
        return Object.assign({}, state, { students: state.students.concat(action.payload) });
    }
    else if (action.type === DELETE_STUDENT) {
        return Object.assign({}, state, { students: state.students.filter(a => a.id !== action.payload.id) });
    }
    else if (action.type === ADD_COURSE) {
        return Object.assign({}, state, { courses: state.courses.concat(action.payload) });
    }

    return state;
};

// STORE
// reducers produce the state of your application.
export const store = createStore(
    rootReducer,
    // Add the following line for Redux DevTools
    window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__()
);

// ACTIONS
// It is a best pratice to wrap every action within a function. 
// Such function is an action creator.
function addStudent(payload) {
    return { type: ADD_STUDENT, payload }
};

function deleteStudent(payload) {
    return { type: DELETE_STUDENT, payload: payload }
};

function addCourse(payload) {
    return { type: ADD_COURSE, payload }
};

//////////////////////////////////////////////////////////////////////////////////////////////////////////
const StudentForm = () => {
    const [id, idChanged] = useState();
    const [name, nameChanged] = useState('');
    const [startyear, startyearChanged] = useState('');
    const dispatch = useDispatch();

    const addStudentClicked = () => {
        dispatch(addStudent({id:id, nimi:name, startyear:startyear }));
    }
    const handleSubmit = (e) => {
        e.preventDefault();
    }
    return (
        <div>
            <div>
                <form onSubmit={(e) => handleSubmit(e)}>
                    <label>Tiedot:</label><br />
                    <label>Id<input type="text" name="id" value={id} onChange={(event) => idChanged(event.target.value)} /></label><br />
                    <label>Nimi<input type="text" name="name" value={name} onChange={(event) => nameChanged(event.target.value)} /></label><br />
                    <label>Aloitusvuosi<input type="text"value={startyear} name="Startyear" onChange={(event) => startyearChanged(event.target.value)} /></label><br/>
                    <button onClick={() => addStudentClicked()}>Lisää</button>
                </form>
                <Opintojakso/>
            </div>
            
            
            
        </div>
    )
}


const StudentList = () => {
    const state = useSelector(state => state);
    const students = state.students || [];
    const dispatch = useDispatch();

    const deleteArticleClicked = (e) => {

        dispatch(deleteStudent({ id: e, nimi: '',startingyear: ''}));
    }
    return (
        <div>
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
                    {students.map((s, i) => <tr key={i}> 
                    <td>{s.id}</td>
                    <td>{s.nimi}</td>
                    <td>{s.startyear}</td>
                    <td><button onClick={(e) => deleteArticleClicked(s.id)}>Poista {s.id}</button></td>
                    </tr>)}
                </tbody>
            </table>
        </div>
    )
}

function Opintojakso() {
    const Kurssit = useSelector(state => state.courses) || [];
    const opintojaksot = Kurssit.map((s, index) => {  
        return <option key={index} value={s.Oid}>{s.Onimi},{s.Olaajuus}</option>});

    return (
        <div>
            <select>
                {opintojaksot}
            </select>
        </div>
    )
}






















