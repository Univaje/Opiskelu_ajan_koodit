import { useState, useEffect } from 'react';

const Asiakas = () => {
  const [data, setData] = useState([]);
  const [nimiTerm, setNimiTerm] = useState('');
  const [osoiteTerm, setOsoiteTerm] = useState('');
  const [searchResults, setSearchResults] = useState([]);
  const [asiakasTyyppi, setAsiakasTyyppi] = useState(0);
  const [numero, setNumero] = useState(0);
  const [show, setShow] = useState(false);





  useEffect(() => {
    handleSearch();
  }, []);

  const handleSearch = async () => {
    setShow(true);
    const response = await fetch('http://localhost:3004/asiakas')
    setData(await response.json());
    const results = data.filter(item => {
      if (nimiTerm !== '' && osoiteTerm !== '' && asiakasTyyppi !== 0) {
        return (item.nimi.toLowerCase().includes(nimiTerm.toLowerCase()) && item.osoite.toLowerCase().includes(osoiteTerm.toLowerCase()) && (item.tyyppi_id == asiakasTyyppi.valueOf(asiakasTyyppi)))
      }
      else if (osoiteTerm !== '' && asiakasTyyppi !== 0) {
        return (
          item.osoite.toLowerCase().includes(osoiteTerm.toLowerCase()) && (item.tyyppi_id == asiakasTyyppi.valueOf(asiakasTyyppi)))
      }
      else if (nimiTerm !== '' && asiakasTyyppi !== 0) {
        return (item.nimi.toLowerCase().includes(nimiTerm.toLowerCase()) && (item.tyyppi_id == asiakasTyyppi.valueOf(asiakasTyyppi)));
      }
      else if (asiakasTyyppi !== 0) {
        return ((item.tyyppi_id == asiakasTyyppi.valueOf(asiakasTyyppi)));
      }
      else if (nimiTerm !== '' && osoiteTerm !== '') {
        return (item.nimi.toLowerCase().includes(nimiTerm.toLowerCase()) &&
          item.osoite.toLowerCase().includes(osoiteTerm.toLowerCase()))
      }
      else if (osoiteTerm !== '') {
        return (
          item.osoite.toLowerCase().includes(osoiteTerm.toLowerCase()))
      }
      else if (nimiTerm !== '') {
        return (item.nimi.toLowerCase().includes(nimiTerm.toLowerCase()))
      }

      return null;

    });
    setShow(false);
    setSearchResults(results);
    setNimiTerm('');
    setOsoiteTerm('');
    setAsiakasTyyppi(0);
  };
  const Nayta = () => { return (<p data-testid="loading">Loading...</p>) };
  return (
    <div>

      <label>
        Nimi
        <input
          type="text"
          data-testid="nameInput"
          placeholder="Search by name"
          value={nimiTerm}
          onChange={event => setNimiTerm(event.target.value)}
        />
      </label>
      <label>
        Osoite
        <input
          type="text"
          data-testid="addressInput"
          placeholder="Search by address"
          value={osoiteTerm}
          onChange={event => setOsoiteTerm(event.target.value)}
        />
      </label>
      <select data-testid="customertypeSelect" text={"asiakastyyppi"} onChange={event => setAsiakasTyyppi(event.target.value)}>
        <option data-testid="customertypeOption" value={1}>henkilöasiakas</option>
        <option data-testid="customertypeOption" value={2}>yritysasiakas</option>
        <option data-testid="customertypeOption" value={3}>entinen asiakas</option>
      </select>

      <button data-testid="searchButton" onClick={handleSearch}>Search</button>
      {show ? <Nayta /> : null}
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nimi</th>
            <th>Osoite</th>
            <th>Postinumero</th>
            <th>Postitoimipaikka</th>
            <th>Puhelin numero</th>
            <th>Tyyppi_id</th>
            <th>tyyppi_selite</th>
          </tr>
        </thead>
        <tbody>
          {searchResults.length > 0 ? 
          searchResults.map((item, index) => {
              return <tr key={index}>
                <td>{item.id}</td>
                <td>{item.nimi}</td>
                <td>{item.osoite}</td>
                <td>{item.postinumero}</td>
                <td>{item.postitoimipaikka}</td>
                <td>{item.puhelinnro}</td>
                <td>{item.tyyppi_id}</td>
                <td>{item.tyyppi_selite}</td>
              </tr>
            })
            : data.map((item, i) => {
              return <tr key={i}>
                <td>{item.id}</td>
                <td>{item.nimi}</td>
                <td>{item.osoite}</td>
                <td>{item.postinumero}</td>
                <td>{item.postitoimipaikka}</td>
                <td>{item.puhelinnro}</td>
                <td>{item.tyyppi_id}</td>
                <td>{item.tyyppi_selite}</td>
              </tr>
            })}
        </tbody>
      </table>
    </div>
  );
};


export { Asiakas };