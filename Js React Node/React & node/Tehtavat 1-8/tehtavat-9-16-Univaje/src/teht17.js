/*
18. Tee React komponentti (<Asiakas>), jonka avulla voidaan hakea asiakkaita (käyttäen yo:n mukaista REST-rajapintaa).
Sovelluksessa on hakuehtokentät (input type=text) nimelle (data-testid="nameInput") ja osoitteelle (data-testid="addressInput").
Kun käyttäjä painaa Hae-nappia (data-testid="searchButton"), haetaan hakuehtojen mukainen data REST-api:sta. 
Käyttäjä voi antaa minkä tahansa hakuehtojen kombinaation (tai jättää ne kokonaan antamatta). 
Haettu data näytetään HTML:n table-elementissä (näytä kentät järjestyksessä: Id, Nimi, Osoite, Postinumero, 
Postitoimipaikka, Puhelinnumero, Tyyppi_id, Tyyppi_selite, Poista, Muokkaa).
*/
import { useState, useEffect } from 'react';

function AppEffect() {
    const [firstName, setFirstName] = useState('');
    const [savePressed, setSavePressed] = useState(false);
    const [query, setQuery] = useState('');
    const [cars, setCars] = useState([]);
    const [merkki, setMerkki] = useState('');

    // Tämä effect suoritetaan VAIN yhden kerran
    useEffect(() => {
        console.log("Näkyykö tämä muutos?")
    }, []);

console.log("Rendering ....")

    useEffect( () => {
        console.log("useEffect happened ...");

        const fetchCars = async () => {
            console.log("fetchCars alkaa ...");
            let response = await fetch("http://localhost:3004/autot?" + query);
            console.log("fetch called ...", response);
            let c = await response.json();
            console.log("cars = ", c);
            setCars(c);
            console.log("setCars called ...");
        }

        if ( query != '') fetchCars();
        console.log("useEffect called ...");
    }, [query]);
    //}

    const handleFetch = () => {
        let m = "";

        if ( merkki !== "" )
            m = "Merkki=" + merkki;    
        
        setQuery(m);

        // EI NÄIN
        //return <p>Tässä jotain dataa!</p>
    }

    const autot = cars.map((s, i) => {
        return <li key={s.id}>{s.Merkki}, {s.Malli}</li>
    })

    const firstNameChanged = (event) => {
        setFirstName(event.target.value);
    }

    const handleSubmit = (event) => {
        setSavePressed(true);
        event.preventDefault();
    }

    let txt = <h3>Submit NOT handled yet</h3>;
    if ( savePressed ) txt = <h4>Submit handled</h4>

    const renderLabel = () => {
        if ( savePressed ) return <h5>This is function!</h5>
        else return <h5></h5>;
    }

    return (
        <div>
            {renderLabel()}
            <p>Your firstname IS: {firstName}</p>
            {
                savePressed ? 
                <p>Save pressed</p> : null
            }
            <p>Tervetuloa</p>

        
            {txt}
            <form onSubmit={(e) => handleSubmit(e)}>
                <label>
                    Name:
                    <input type="text" name="first_name" value={firstName} onChange={(evt) =>firstNameChanged(evt)}/>
                </label>
                <label>
                    Merkki
                    <input type="text" onChange={(e) => setMerkki(e.target.value)} />
                </label>
                <input type="submit" value="Save" />

            </form>
            <button onClick={() => handleFetch()}>Hae dataa</button>

            <ul>{autot}</ul>
        </div>
    )
}

export default AppEffect;

/*
19. Lisää edelliseen tehtävään hakuehdoksi asiakastyyppi. Hae asiakastyypit alasvetovalikkoon 
(select -> data-testid="customertypeSelect", option -> data-testid="customertypeOption") kun 
sovellus käynnistyy ilman että käyttäjän tarvitsee tehdä mitään.

20. Lisää edelliseen tehtävään: kun tietoa haetaan REST-api:sta, näkyy käyttäjälle VAIN teksti "Loading..."  
(data-testid="loading"). Kun REST-api palauttaa tiedon, piilotetaan em. Loading-teksti ja näytetään käyttäjälle haettu data. 
Tätä varten laita REST-api:iin "viivettä" pari sekuntia (--delay parametrilla).

21. Lisää edelliseen tehtävään: jos annetuilla hakuehdoilla ei löydy dataa, näytetään käyttäjälle HTML table:n tilalla teksti 
"Annetuilla hakuehdoilla ei löytynyt dataa" (p-elementti, data-testid="notFound").

22. Muuta edellistä tehtävää: "Annetuilla hakuehdoilla ei löytynyt dataa" teksti on näkyvissä vain 2s ajan, 
sen jälkeen teksti häviää pois.

23. Lisää edelliseen tehtävään: käyttäjä voi poistaa valitun asiakkaan. Toteuta tämä niin, 
että jokaisella rivillä on Poista-nappi (data-testid="deleteButton"), jota painamalla data poistetaan kutsumalla REST-api:a. 
Poistamisen jälkeen asiakas häviää käyttöliittymästä kun haet datan uudelleen REST-api:n kautta. 
Nimeä Poista-napit niin että nimi on muotoa "Poista id", jossa id on asiakkaan id-kentän arvo (esim. Poista 2).

24. Lisää edelliseen tehtävään varmistus "Haluatko varmasti poistaa asiakkaan X?". 
Käytä varmistuksen näyttämiseen confirm-funktiota. X:n tilalla täytyy olla poistettavan asiakkaan nimi.

25. Lisää <Asiakas>-komponenttiin: käyttäjä voi myös lisätä uuden asiakkaan. 
Toteuta tämä niin, että sovelluksessa on nappi "Lisää uusi" (data-testid="addButton"), 
joka disabloi kaikki muut napit (ja toiminnot) ja näyttää form:n jolla voi lisätä uuden asiakkaan. 
Form:lla on seuraavat kentät (input type=text): nimi (data-testid="nameEdit"), osoite (data-testid="addresEdit"), 
puhelin (data-testid="phoneEdit"), lisäksi form:lla on alasvetovalikko asiakastyypille (data-testid="customertypeSelectEdit") 
ja napit Peruuta (data-testid="cancelButton") ja Tallenna (data-testid="saveButton"). 
Käytä uuden asiakkaan luomiseen REST-rajapintaa. Hae asiakkaat uudelleen onnistuneen lisäämisen jälkeen 
jolloin lisätty asiakas näkyy näytöllä (jos hakuehdot olivat "sopivat").

26. Lisää aiemmin tekemääsi <Asiakas>-komponenttiin: käyttäjä voi myös muokata asiakasta. 
Toteuta tämä niin, että sovelluksessa on nappi "Muokkaa asiakasta xx" 
(jossa xx on asiakkaan id, data-testid="editButton"), joka disabloi kaikki muut napit (ja toiminnot) 
ja näyttää form:n jolla voi muokata valitun asiakkaan tietoja. Form:lla on seuraavat kentät 
(input type=text): nimi, osoite, puhelin, lisäksi form:lla on alasvetovalikko asiakastyypille ja 
napit "Peruuta muokkaus" (data-testid="cancelEditButton") ja "Tallenna muutos" (data-testid="saveEditButton"). 
Käytä asiakkaan muokkaamiseen REST-rajapintaa (PUT metodia). 
Toiminto on toteutettava niin, että ennen kuin muokkaus formi näytetään, 
haetaan asiakkaan tiedot REST-apista GET-metodilla 
(haetaan vain id:llä, url oltava muotoa http://localhost:3004/asiakas/123). 
Hae asiakkaat uudelleen onnistuneen muokkaamisen jälkeen jolloin lisätty asiakas näkyy näytöllä (jos hakuehdot olivat "sopivat"). 
Peruuta-napin painaminen sulkee vain muutos-formin ja enabloi tarvittavat napit.
*/
