import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import App from './App';
//import {Laskuri} from './teht1_4'
//import {Teht6} from './teht5_8'
//import { Teht6 } from './tehtava6';
//import {Kertaus} from './Kertaus';
import App_form from './App_form';
import reportWebVitals from './reportWebVitals';

ReactDOM.render(
  <React.StrictMode>
    <App_form />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
