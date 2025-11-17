import { useState} from 'react';

const AppForm = () => {
    const [buttonPressed, setButtonPressed] = useState(false);
    const [etunimi, setEtunimi] = useState('');

    const buttonClicked = () => {
        setButtonPressed(true);
        console.log("arvo:", buttonPressed)
    } 

    let txt = <h3>Nappia EI klikattu</h3>
    if ( buttonPressed ) txt = <h3>Nappia ON klikattu</h3>

    const renderHeader = () => {

        return buttonPressed ? <p>Tässä on jotain tekstiä</p> : <pre>ButtonPressed oli false</pre>;
    }

    const handleSubmit = (event) => {
        event.preventDefault();
    }

    const etunimiChanged = (event) => {
        setEtunimi(event.target.value)
    }

    return (
        <div>
            <p>Formin käsittelyä</p>
            {
                buttonPressed ?  
                    <div>
                        <h6>Button PRESSED</h6>
                    </div> : 
                    null
                    // <div>
                    //     <h5>Button not pressed</h5>
                    // </div> 
            }
            {txt}
            <h2>{etunimi}</h2>
            {renderHeader()}
            <button onClick={() => buttonClicked()}>Test conditional rendering</button>
            <form onSubmit={(e) => handleSubmit(e)}>
                <label>
                    Name :
                    <input type="text" name="etunimi" value={etunimi}  onChange={(e) => etunimiChanged(e)} />
                    <input type="submit" value="Save" />
                </label>
            </form>
        </div>
    );
} 

export default AppForm;