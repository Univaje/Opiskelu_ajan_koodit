import { useState } from 'react';

    const Lista = () => {
        //muuttujat
        const nimet = [
            {
                etunimi: "Aku", 
                sukunimi: "Ankka", 
                aloitusvuosi: 2021
            },
            { 
                etunimi: "Tupu", 
                sukunimi: "Ankka", 
                aloitusvuosi: 2021 
            },
            { 
                etunimi: "Hupu", 
                sukunimi: "Ankka", 
                aloitusvuosi: 2021 
            },
            { 
                etunimi: "Lupu", 
                sukunimi: "Ankka", 
                aloitusvuosi: 2021 
            },
        ];
        

        return (
            <div>
                <ol>
                    {Listanlapikaunti(nimet)}
                </ol> 
            </div>
        )
    }

    function Listanlapikaunti(LISTA){
            const rivi = LISTA.map((n, index) => {
               return <Rivi key={index} etunimi={n.etunimi} sukunimi={n.sukunimi} aloitusvuosi={n.aloitusvuosi} />   
        })
        return rivi;
    }

    function Rivi(props) {
        return <li>{props.etunimi + ", " + props.sukunimi + ", " + props.aloitusvuosi}</li>
    }
    

    const Teht6 = () => {
        //muuttujat
        const [luku, setluku] = useState(1);
        
            
        const otsikot = { nimi: "Etunimi", osoite : "Osoite",aloitusvuosi : "Aloitusvuosi"}
        const enkku = { nimi: "Firstname", osoite : "Address",aloitusvuosi : "StartingYear"}
        const rivit = [{ nimi: "Aku", osoite: "Ankka", aloitusvuosi: 2021},
            { nimi: "Tupu", osoite: "Ankka", aloitusvuosi: 2021},
            { nimi: "Hupu", osoite: "Ankka", aloitusvuosi: 2021},
            { nimi: "Iines",osoite: "Ankka", aloitusvuosi: 2021},
            { nimi: "Lupu", osoite: "Ankka", aloitusvuosi: 2021},]

            
        const piilotaButtonClicked =(event)=>{

            if( luku == 1){
              setText(null);
                setluku(0);
            }
            else{
                setText(<div> 
                    <Taulukko data={rivit} otsikot={otsikot}/> 
                    <Taulukko data={rivit} otsikot={enkku} />
                 </div>);
                setluku(1); 
            }
        }
        const [text,setText] = useState(<div> 
                        <Taulukko data={rivit} otsikot={otsikot}/> 
                        <Taulukko data={rivit} otsikot={enkku} />
                        </div>);
    return (
        <div>
            {text}
            <button onClick={(e) => piilotaButtonClicked(e)}>Piilota</button>
        </div>
    )
    }

    const Taulukko = (props) => {
        
        return (
            <table>
                <Otsikko otsikot={props.otsikot}/>
                <TauluRivi rivit={props.data}/>
            </table>
            
        )
    }

function Otsikko(props) {
            const otsikot=<tr>
                    <th >{props.otsikot.nimi}</th>
                    <th >{props.otsikot.osoite}</th>
                    <th >{props.otsikot.aloitusvuosi}</th>
                </tr>
            ;
            
            return <thead>{otsikot}</thead>;
    }

    function TauluRivi(props) {
        let x = props.rivit || []
        const tiedot = x.map((data, index) => {
            return <tr key={index}>
                <td>{data.nimi}</td>
                <td>{data.osoite}</td>
                <td>{data.aloitusvuosi}</td>
              </tr>;
            
          })
          return <tbody>{tiedot}</tbody>;
        }





export { Lista, Rivi,Teht6,Taulukko,Otsikko,TauluRivi }

