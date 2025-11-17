import { useState, useEffect } from 'react';
//import { useTimer } from 'react-timer-hook';

export const Asiakas = () => {

    const [nimi, setName] = useState('');
    const [osoite, setOsoite] = useState('');
    const [ButtonPressed, setButtonPressed] = useState(false);
    const [query, setQuery] = useState('');
    const [poistoquery, setPoistoQuery] = useState('');
    const [muokkausquery, setMuokkausQuery] = useState('');
    const [Lisaysquery, setlisausQuery] = useState([]);
    const [muokID, setMuokID] = useState(0);
    const [ShowLisaa, setShowlisaa] = useState(false);
    const [ShowMuokkaa, SetShowMuokkaa] = useState(false);
    const [asiakkaat, setAsiakkaat] = useState([]);
    const [tyypit, setTyypit] = useState(0)
    const [Valikko, setValikko] = useState('');
    const [FoundData, SetFoundData] = useState(true);
    const [virhe, SetVirhe] = useState('');

    var otsikot = { id: "ID", nimi: "Nimi", osoite: "Osoite", postinumero: "Postinumero", postitoimipaikka: "Postitoimipaikka", puhelinnumero: "Puhelinnumero", tyyppi_id: "Tyyppi ID", tyyppi_selite: "Selite", poista: "Poista", muokkaa: "Muokkaa" };
    var txt = <h3>Tehtävät 18-26</h3>;

    /*
    19. Lisää edelliseen tehtävään hakuehdoksi asiakastyyppi. Hae asiakastyypit alasvetovalikkoon 
    (select -> data-testid="customertypeSelect", option -> data-testid="customertypeOption") kun 
    sovellus käynnistyy ilman että käyttäjän tarvitsee tehdä mitään.
    */
    useEffect(() => {
        const haetyypit = async () => {
            let response = await fetch("http://localhost:3004/asiakastyyppi?");
            let c = await response.json();
            c.unshift({id:0, lyhenne:'VAL', selite:'Valitse'}); 
            var tempping = c.map((x, i) => {
                return <option data-testid="customertypeOption" key={i} value={x.id}>{x.lyhenne}</option>
            });
            setValikko(tempping);

        }
        haetyypit();
    }, []);

    /*
    18. Tee React komponentti (<Asiakas>), jonka avulla voidaan hakea asiakkaita (käyttäen yo:n mukaista REST-rajapintaa).
    Sovelluksessa on hakuehtokentät (input type=text) nimelle (data-testid="nameInput") ja osoitteelle (data-testid="addressInput").
    Kun käyttäjä painaa Hae-nappia (data-testid="searchButton"), haetaan hakuehtojen mukainen data REST-api:sta. 
    Käyttäjä voi antaa minkä tahansa hakuehtojen kombinaation (tai jättää ne kokonaan antamatta). 
    Haettu data näytetään HTML:n table-elementissä (näytä kentät järjestyksessä: Id, Nimi, Osoite, Postinumero, 
    Postitoimipaikka, Puhelinnumero, Tyyppi_id, Tyyppi_selite, Poista, Muokkaa).

    20. Lisää edelliseen tehtävään: kun tietoa haetaan REST-api:sta, näkyy käyttäjälle VAIN teksti "Loading..."  
    (data-testid="loading"). Kun REST-api palauttaa tiedon, piilotetaan em. Loading-teksti ja näytetään käyttäjälle haettu data. 
    Tätä varten laita REST-api:iin "viivettä" pari sekuntia (--delay parametrilla).   
    */

    useEffect(() => {

        const fetchClients = async () => {
            let response = await fetch("http://localhost:3004/asiakas?" + query);
            let c = await response.json();
            setAsiakkaat(c);
            if (asiakkaat.length === 0) {
                SetVirhe(<p data-testid="notFound" >Annetuilla hakuehdoilla ei löytynyt dataa</p>)
                await new Promise((resolve, reject) => setTimeout(resolve,2000));
                SetVirhe('');
            }
            setButtonPressed(false);
        }
        const fetchAll = async () => {
            let response = await fetch("http://localhost:3004/asiakas?");
            let c = await response.json();
            setAsiakkaat(c);
            setButtonPressed(false);
        }
        if (query != '')
            fetchClients();
        else if (ButtonPressed && query == '')
            fetchAll();
    }, [ButtonPressed]);

    const Kasittelekutsu = () => {
        setAsiakkaat([]);
        SetVirhe(<p data-testid="loading">Loading...</p>)
        let haku = [];
        if (nimi != "") haku.push("nimi=" + nimi);
        if (osoite != "") haku.push("osoite=" + osoite);
        if (tyypit != 0) haku.push("tyyppi_id=" + tyypit);
        let temp = haku.join("&&")
        setQuery(temp);
        setButtonPressed(true);
    }

    /*
    23. Lisää edelliseen tehtävään: käyttäjä voi poistaa valitun asiakkaan. Toteuta tämä niin, 
    että jokaisella rivillä on Poista-nappi (data-testid="deleteButton"), jota painamalla data poistetaan kutsumalla REST-api:a. 
    Poistamisen jälkeen asiakas häviää käyttöliittymästä kun haet datan uudelleen REST-api:n kautta. 
    Nimeä Poista-napit niin että nimi on muotoa "Poista id", jossa id on asiakkaan id-kentän arvo (esim. Poista 2).

    24. Lisää edelliseen tehtävään varmistus "Haluatko varmasti poistaa asiakkaan X?". 
    Käytä varmistuksen näyttämiseen confirm-funktiota. X:n tilalla täytyy olla poistettavan asiakkaan nimi.
    */

    const KasittelePoisto = (e) => {
        setPoistoQuery(e.target.value);
    }
    useEffect(() => {
        let text = "Haluatko varmasti poistaa asiakkaan X?";
        const Delete = async () => {
            await fetch("http://localhost:3004/asiakas/" + poistoquery, { method: 'DELETE' });
        }
        if (poistoquery != '') {
            if (window.confirm(text) == true) {
                Delete();
                setPoistoQuery('');
            }
        }
    }, [poistoquery])

    const Asiakkaat = asiakkaat.map((s, i) => {
        return <tr key={s.id}>
            <td>{s.id}</td>
            <td>{s.nimi}</td>
            <td>{s.osoite}</td>
            <td>{s.postinumero}</td>
            <td>{s.postitoimipaikka}</td>
            <td>{s.puhelinnro}</td>
            <td>{s.tyyppi_id}</td>
            <td>{s.tyyppi_selite}</td>
            <td><button data-testid="deleteButton" value={s.id} onClick={(e) => KasittelePoisto(e)}>Poista {s.id}</button></td>
            <td><button data-testid="editButton" value={s.id} onClick={(e) => KasitteleMuokkaus(e)}>Muokkaa asiakasta {s.id}</button></td>
        </tr>
    })

    const Table = <table>
        <thead>
            <tr>
                <th>{otsikot.id}</th>
                <th>{otsikot.nimi}</th>
                <th>{otsikot.osoite}</th>
                <th>{otsikot.postinumero}</th>
                <th>{otsikot.postitoimipaikka}</th>
                <th>{otsikot.puhelinnumero}</th>
                <th>{otsikot.tyyppi_id}</th>
                <th>{otsikot.tyyppi_selite}</th>
                <th>{otsikot.poista}</th>
                <th>{otsikot.muokkaa}</th>
            </tr>
        </thead>
        <tbody>
            {Asiakkaat}
        </tbody>
    </table>;

    const hiddenornot = <div>{txt}
        <form onSubmit={(e) => handleSubmit(e)}>
            <label>
                Nimi:
                <input type="text" data-testid="nameInput" onChange={(e) => setName(e.target.value)} />
            </label>
            <label>
                Osoite:
                <input type="text" data-testid="addressInput" onChange={(e) => setOsoite(e.target.value)} />
            </label>
            <label>Tyyppi:
                <select data-testid="customertypeSelect" onChange={(e) => setTyypit(e.target.value)}>
                    {Valikko}
                </select>
            </label>

        </form><button data-testid="searchButton" onClick={() => Kasittelekutsu()}>Hae</button>
        <button data-testid="addButton" onClick={() => KasitteleLisays()}>Lisää uusi</button>
        </div>;
    /*
    25. Lisää <Asiakas>-komponenttiin: käyttäjä voi myös lisätä uuden asiakkaan. 
    Toteuta tämä niin, että sovelluksessa on nappi "Lisää uusi" (data-testid="addButton"), 
    joka disabloi kaikki muut napit (ja toiminnot) ja näyttää form:n jolla voi lisätä uuden asiakkaan. 
    Form:lla on seuraavat kentät (input type=text): nimi (data-testid="nameEdit"), osoite (data-testid="addresEdit"), 
    puhelin (data-testid="phoneEdit"), lisäksi form:lla on alasvetovalikko asiakastyypille (data-testid="customertypeSelectEdit") 
    ja napit Peruuta (data-testid="cancelButton") ja Tallenna (data-testid="saveButton"). 
    Käytä uuden asiakkaan luomiseen REST-rajapintaa. Hae asiakkaat uudelleen onnistuneen lisäämisen jälkeen 
    jolloin lisätty asiakas näkyy näytöllä (jos hakuehdot olivat "sopivat").
    */

    useEffect(() => {
        const AddNew = async () => {
            const response = await fetch("http://localhost:3004/asiakas", {
                method: 'Post',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(Lisaysquery)
            });
        };

        if (Lisaysquery != '') {
            AddNew();
            setlisausQuery('');
            Kasittelekutsu();
        }
    }, [Lisaysquery])

    const HandleNew = (newQuery) => {
        setlisausQuery(newQuery);
        setShowlisaa(false);
        SetShowMuokkaa(false);
    }
    const KasitteleLisays = () => {
        setAsiakkaat([]);
        SetShowMuokkaa(false);
        setShowlisaa(true);
        SetVirhe('');
        
    }




    
    const HandleUpdate = (UpdateQuery) => {
        setMuokkausQuery(UpdateQuery);
        setShowlisaa(false);
        SetShowMuokkaa(false);

    }
    const HandleBackUp = (backup) => {
        setShowlisaa(backup);
        SetShowMuokkaa(backup);
        Kasittelekutsu();
        
    }
    useEffect(() => {

        const UpdateC = async () => {
            const response = await fetch("http://localhost:3004/asiakas/" + muokID, {
                method: 'Put',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(muokkausquery)
            });
        };


        if (muokkausquery != '') {
            UpdateC();
            Kasittelekutsu();

        }

    }, [muokkausquery]);
    /*
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

    const KasitteleMuokkaus = (e) => {
        setAsiakkaat([]);
        setQuery('');
        setShowlisaa(false);
        SetShowMuokkaa(true);
        SetVirhe('');
        setMuokID(e.target.value);


    }
    

    useEffect(() => {
        if (Asiakkaat.length === 0)
            SetFoundData(false);
        else
            SetFoundData(true);
    }, [Asiakkaat])
    const handleSubmit = (event) => {
        event.preventDefault();
    }

    /*
    21. Lisää edelliseen tehtävään: jos annetuilla hakuehdoilla ei löydy dataa, näytetään käyttäjälle HTML table:n tilalla teksti 
    "Annetuilla hakuehdoilla ei löytynyt dataa" (p-elementti, data-testid="notFound").

    22. Muuta edellistä tehtävää: "Annetuilla hakuehdoilla ei löytynyt dataa" teksti on näkyvissä vain 2s ajan, 
    sen jälkeen teksti häviää pois.
    */

    return (
        <div >
            {ShowMuokkaa | ShowLisaa ? null : hiddenornot}
            {ShowLisaa ? <Uusiformi chaincommand={HandleNew} Valikko={Valikko} backcommand={HandleBackUp} /> : null}
            {ShowMuokkaa ? <Muokkausformi Data={muokID} chaincommand={HandleUpdate} backcommand={HandleBackUp} Valikko={Valikko} /> : null}
            {FoundData ? Table : virhe}
        </div>
    )
}
export const Uusiformi = props => {

    const [NewNimi, SetNewName] = useState('');
    const [NewOsoite, setNewOsoite] = useState('');
    const [NewPuhelin, setNewPuhelin] = useState('');
    const [NewTyypit, setNewTyypit] = useState('');
    const chaincommanmd = props.chaincommand;
    const backcommand = props.backcommand

    const SaveClicked = () => {
        let haku = [];
        if (NewNimi !== "")
            if (NewOsoite !== "")
                if (NewOsoite !== "")
                    if (NewTyypit !== 0)
                        haku = { nimi: NewNimi, osoite: NewOsoite, puhelinnro: NewPuhelin, postinumero: "00000", postitoimipaikka: "None", tyyppi_id: NewTyypit, tyyppi_selite: "1=henkilöasiakas, 2=yritysasiakas, 3=entinen asiakas" }
        chaincommanmd(haku);

    }
    const CancelClicked = () => {
        backcommand(false);
    }
    /*
    25. Lisää <Asiakas>-komponenttiin: käyttäjä voi myös lisätä uuden asiakkaan. 
    Toteuta tämä niin, että sovelluksessa on nappi "Lisää uusi" (data-testid="addButton"), 
    joka disabloi kaikki muut napit (ja toiminnot) ja näyttää form:n jolla voi lisätä uuden asiakkaan. 
    Form:lla on seuraavat kentät (input type=text): nimi (data-testid="nameEdit"), osoite (data-testid="addresEdit"), 
    puhelin (data-testid="phoneEdit"), lisäksi form:lla on alasvetovalikko asiakastyypille (data-testid="customertypeSelectEdit") 
    ja napit Peruuta (data-testid="cancelButton") ja Tallenna (data-testid="saveButton"). 
    Käytä uuden asiakkaan luomiseen REST-rajapintaa. Hae asiakkaat uudelleen onnistuneen lisäämisen jälkeen 
    jolloin lisätty asiakas näkyy näytöllä (jos hakuehdot olivat "sopivat").
    */
    const handleSubmit = (event) => {
        event.preventDefault();
    }

    return <form onSubmit={(e) => handleSubmit(e)}>Lisää uusi:<br />
        <label>
            Nimi:
            <input type="text" data-testid="nameEdit" value={NewNimi} onChange={(e) => SetNewName(e.target.value)} />
        </label><br />
        <label>
            Osoite:
            <input type="text" data-testid="addressEdit" value={NewOsoite} onChange={(e) => setNewOsoite(e.target.value)} />
        </label><br />
        <label>
            Puhelin:
            <input type="text" data-testid="phoneEdit" value={NewPuhelin} onChange={(e) => setNewPuhelin(e.target.value)} />
        </label><br />
        <label>Asiakas tyyppi:
            <select data-testid="customertypeSelectEdit" value={NewTyypit} onChange={(e) => setNewTyypit(e.target.value)}>
                {props.Valikko}
            </select><br />
        </label>
        <button data-testid="saveButton" onClick={() => SaveClicked()}>Tallenna</button>
        <button data-testid="cancelButton" onClick={() => CancelClicked()}>Peruuta</button>

    </form>

}
export function Muokkausformi(props) {

    const [UpdateNimi, SetUpdateName] = useState('');
    const [UpdateOsoite, setUpdateOsoite] = useState('');
    const [Updatepuhelin, setUpdatePuhelin] = useState('');
    const [Updatetyypit, setUpdateTyypit] = useState('');
    const chaincommanmd = props.chaincommand;
    const backcommand = props.backcommand
    const [ID,SetID] = useState(0);
    if (ID != props.Data)
        SetID(props.Data);
    const SaveClicked = () => {
        let paivitus = [];
        if (UpdateNimi !== "")
            if (UpdateOsoite !== "")
                if (Updatepuhelin !== "")
                    if (Updatetyypit !== 0)
                        paivitus = { nimi: UpdateNimi, osoite: UpdateOsoite, puhelinnro: Updatepuhelin, postinumero: props.Data.postinumero, postitoimipaikka: props.Data.postitoimipaikka, tyyppi_id: Updatetyypit, tyyppi_selite: props.Data.tyyppi_selite }
        chaincommanmd(paivitus);
    }

    const CancelClicked = () => {
        backcommand(false);

    }

    useEffect(() => {

        const fetchClient = async () => {
            let response = await fetch("http://localhost:3004/asiakas/" + ID);
            let c = await response.json();
            SetUpdateName(c.nimi);
            setUpdateOsoite(c.osoite);
            setUpdatePuhelin(c.puhelinnro);
            setUpdateTyypit(c.tyyppi_id);
        }

        if (ID != '') {
            fetchClient();
        }

    }, [ID]);
    /*
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
    const handleSubmit = (event) => {
        event.preventDefault();

    }
    return <form onSubmit={(e) => handleSubmit(e)}>Muokkaa Asiakasta:<br />
        <label>
            Nimi:
            <input type="text" data-testid="nameEdit" value={UpdateNimi} onChange={(e) => SetUpdateName(e.target.value)} />
        </label><br />
        <label>
            Osoite:
            <input type="text" data-testid="addressEdit" value={UpdateOsoite} onChange={(e) => setUpdateOsoite(e.target.value)} />
        </label><br />
        <label>
            Puhelin:
            <input type="text" data-testid="phoneEdit" value={Updatepuhelin} onChange={(e) => setUpdatePuhelin(e.target.value)} />
        </label><br />
        <label>Asiakas tyyppi:
            <select data-testid="customertypeSelectEdit" value={Updatetyypit} onChange={(e) => setUpdateTyypit(e.target.value)}>
                {props.Valikko}
            </select><br />
        </label>
        <button data-testid="saveEditButton" onClick={() => SaveClicked()} >Tallenna</button>
        <button data-testid="cancelEditButton" onClick={() => CancelClicked()}>Peruuta</button>


    </form>

}
