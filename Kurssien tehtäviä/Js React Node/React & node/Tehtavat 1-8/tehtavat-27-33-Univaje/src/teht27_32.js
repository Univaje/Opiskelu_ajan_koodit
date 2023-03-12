/*
*/ 
import React, { useEffect, useState } from 'react';
import "./teht27_32.css";
import {Link, NavLink, Routes, Route, BrowserRouter as Router, useNavigate, useLocation, Navigate, useParams} from 'react-router-dom'


export const Spa = (props) => {
    const [user, setUser] = useState(null);
    const [Kayttis, setKayttis] = useState(false);
    const LoggingIN = (loggedUser) => { setUser(loggedUser); }
    
    useEffect(() => {

        if(user != null) 
            setKayttis(true); 
    },[user])
    function MouseOver(event) {
        event.target.style.background = 'orchid';
      }
      function MouseOut(event){
        event.target.style.background="";
      }
    return(
        <div>
            {Kayttis ? <h3>{user}</h3> : null }
            
            <NavLink onMouseOver={MouseOver} onMouseOut={MouseOut} style={({ isActive }) => ({
                padding: "10px",
                fontSize: "20px", 
                color: "blueviolet",
                position: "relative",
                display: "block", 
                textAlign:"center", 
                float:"left", 
                height:"100px",
                width:"125px", 
                margin: "1rem 0", 
                textDecoration: "none", 
                color: isActive ? "red" : ""})} 
                to="/">Koti </NavLink>
            <NavLink onMouseOver={MouseOver} onMouseOut={MouseOut} style={({ isActive }) => ({
                padding: "10px", 
                fontSize: "20px",
                color: "blueviolet",
                position: "relative",
                display: "block", 
                textAlign:"center", 
                float:"left", 
                height:"100px",
                width:"125px", 
                margin: "1rem 0", 
                textDecoration: "none", 
                color: isActive ? "red" : ""})} 
                to="/Autot">Autot</NavLink>
            
            <Routes>
                <Route path="/" element={<Koti />}/>
                <Route path="/Error" element={<Error />}/>
                <Route path="/Autot" element=
                {   user ? <Autot /> : <Kirjaudu onLogin={(user) => LoggingIN(user)}/>}/>
                <Route path="*" element={<Error />} />
                <Route path="/Details/*" element={<Details/>}/>
            </Routes>
        </div>
    );
}

export function Error(props)
{
    let location = useLocation();
    let polku = location.pathname;
    let navigate = useNavigate();
    const onClick = () =>
    {
        navigate("/");
    }
    
    return <div className="example"><h3>Yritit navigoida sivulle:{polku} </h3><button onClick={() => onClick()}>Koti-sivulle</button></div>

}

export function Koti(props)
{
    return <div className="example" ><p>Savonia AMK </p> <Aika/></div>
}

export const Aika =()=>{
    var me = "";
    var today = new Date().toLocaleDateString();
    var hour = new Date().getHours();
    hour > 14 && hour < 6 ? me="iltapäivä":me="aamupäivä";
    return <p>{today} {me}</p>
}

export const Kirjaudu = (props) => {
    const [nimi, setNimi] = useState('');
    const [Hetu, setHetu] = useState('');
    let navigate = useNavigate();

    const onClick = (event) =>
    {
        if (nimi && Hetu && props.onLogin != null)
        {
            props.onLogin(nimi +","+ Hetu);
            navigate("/Autot");
            setNimi('');
            setHetu('');
        }
    }

    return (
        <div className="example">
            <h3>Rekisteröidy:</h3>
            <label>Etunimi:<br/><input type="text"  onChange={(e) => setNimi(e.target.value)} /></label><br/>
            <label>Henkilönumero:<br/><input type="text" onChange={(e) => setHetu(e.target.value)} /></label><br/>
            <button onClick={(e) => onClick(e)}>Kirjaudu</button>
        </div>
    );
}

export const Details =(props)=>{
    const [Auto, setAuto] = useState('');
    let location = useLocation();
    useEffect(() => {
        const haeTeksti = () => {   
            let text = location.pathname;
            text = text.replace("%20", " ")
            setAuto(text.substring(text.indexOf(':')+1));
        }
        haeTeksti();
    }, []);
    console.log(props)
    
    return <div className='example'><h6 data-testid="details">Details {Auto}</h6></div>
}

export function Autot() {
    const [Autot, setAutot] = useState([]);
    useEffect(() => {
        const haetyypit = async () => {
            let response = await fetch("http://localhost:3004/autot?");
            let c = await response.json();
            console.log(c);
            var LinkList = c.map((x, i) => {
                return <li key={x.id}><Link to={`/Details/:${x.Merkki}:${x.Malli}`} value="" onClick={(e) => tallennaTiedot(e)}>{x.Merkki},{x.Malli}</Link></li>
            });
            setAutot(LinkList);
        }
        haetyypit();
    }, []);

    const tallennaTiedot = (e) =>{
        console.log(e.target);
    }

    let location = useLocation();
    return <div className='example'>Autot:<br/><ol>{Autot}</ol></div>
}



