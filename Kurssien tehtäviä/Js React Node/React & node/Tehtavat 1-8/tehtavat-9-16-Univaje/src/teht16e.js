import { useState} from 'react';

const VAL=[ "Valitse","Julius Ceasar", "Samuli von Schulman", "Jukka-Pekka"];



 const Valmentaja=({data,valueSelected})=>{

    const perinto = valueSelected;
    return(
        <div>
            <label>
                Valmentaja:
                <select data-testid="valmentajaSelect" onChange={(e)=> perinto(e.target.value)}>         
                { data.map((valmentaja, index) => (
            <option key={index} data-testid="valmentajaOption" onClick={() => valueSelected(valmentaja)}>
             {valmentaja}
             </option>
            ))}
                </select>
            </label>
            <br></br>
        </div>
    )
    
}

const Joukkueet=({joukkueet})=>{
    return(  
        <table>
        <thead>
          <tr>
          <th>id</th>
            <th>Joukkue</th>
            <th>Kotipaikka</th>
            <th>Valmentaja</th>
          </tr>
        </thead>
        <tbody>
          {joukkueet.map((joukkue) => (
            <tr key={joukkue.id}>
              <td>{joukkue.id}</td>  
              <td>{joukkue.joukkue}</td>
              <td>{joukkue.kotipaikka}</td>
              <td>{joukkue.valmentaja}</td>
            </tr>
          ))}
        </tbody>
      </table>
      )
}


function Lomake(){

    const [joukkue, setJoukkue] = useState('');
    const [JOUKKUEET, setJoukkueet] = useState([]);
    const [kotipaikka, setKotipaikka] = useState('');
    const [valmentaja, setValmentaja] = useState('');
    const [id, setId] = useState(0);

    const handleValmentaja=(selectedValmentaja) =>{
        console.log(valmentaja)
        setValmentaja(selectedValmentaja);
        console.log(valmentaja)
    };

    const handleLisaa = () => {
        if (valmentaja != ""){
        setJoukkueet([...JOUKKUEET, {joukkue, kotipaikka, valmentaja, id: id}]);
        setId(id= id+1);
        console.log(JOUKKUEET);
        }; 
        }
    return(
        <div>
            <h1>Heiii maailma</h1>
        
            <label>
                Joukkue:
                <input type="text" value={joukkue} data-testid="joukkue"  onChange={(e) => setJoukkue(e.target.value)} />
            </label>
            <br></br>

            <label>
                Kotipaikka:
                <input type="text" value={kotipaikka} data-testid="kotipaikka" onChange={(e) => setKotipaikka(e.target.value)} />

            </label>
            <br></br>

            <label>
                Id:
                <input type="text" value={id} onChange={(e) => setId(e.target.value)} />
            </label>
            <br></br>
            <Valmentaja data={VAL} valueSelected={(handleValmentaja)}></Valmentaja>
            <button onClick={handleLisaa}>Lisää</button>
            <Joukkueet joukkueet={JOUKKUEET}/>
            
        </div>
    )

}

export{Lomake}