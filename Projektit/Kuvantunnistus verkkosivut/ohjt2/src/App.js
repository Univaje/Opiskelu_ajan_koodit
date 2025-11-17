import React, { useEffect, useState } from "react";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import { Navbar } from "./components/Navbar";
import { Home } from './components/Home';
import { Pictures } from './pages/Pictures';
import { Footer } from './components/Footer';
import { Login } from './pages/Login';
import { Register } from './pages/Register';
import { Omasivu } from './pages/Omasivu';

function App() {
  const [userEmail, setUserEmail] = useState("");
  const [userID, setUserID] = useState("");

  // Retrieve userID from localStorage when the component mounts
  useEffect(() => {
    const user = JSON.parse(localStorage.getItem("user"));
    if (user) {
      setUserID(user._id);
    }
  }, []);

  return (
    <div className="App">
    <Router>
      <Navbar userEmail={userEmail} setUserEmail={setUserEmail} />
        <Switch>
          <Route path="/register" component={Register} />
          <Route path="/login" component={() => <Login setUserEmail={setUserEmail} setUserID={setUserID} />} />
          <Route path="/omasivu" render={() => <Omasivu userID={userID} />} />
          <Route path="/pictures" component={Pictures} />
          <Route path="/" component={Home} />
        </Switch>
    </Router>
    <Footer />
  </div>
  );
}

export default App;
