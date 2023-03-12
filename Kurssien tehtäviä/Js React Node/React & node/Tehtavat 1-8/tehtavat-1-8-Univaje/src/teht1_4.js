import { useState} from 'react';

const Laskuri = () => {

        const [luku, setluku] = useState(0);
        const KasvataButtonClicked = (event) => {  
            setluku(luku + 1);
        }
        const NollaaButtonClicked = (event) => {
            setluku(0);
        }
    return (
            <div>
                <button onClick={(e) => KasvataButtonClicked(e)}>Kasvata</button>
                <button onClick={(e) => NollaaButtonClicked(e)}>Nollaa</button>  
                <Arvo arvo={luku}/>
            </div>
        )
    }
    function Arvo(props){
        let vari; 
        props.arvo > 10 ? vari ={color:'red', fontweight:'bold'} : vari={color:'black', fontweight:'lighter'};
            return (
                <div>
                    <h1 style={vari}> Laskuri on {props.arvo}</h1>
                </div>
            )
        }
    export {
        Laskuri, Arvo  
    }