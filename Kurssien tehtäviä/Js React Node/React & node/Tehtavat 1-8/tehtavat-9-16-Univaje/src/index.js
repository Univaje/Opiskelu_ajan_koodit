import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
//import {Cars, Info} from './teht9_10';
import {ListForm} from './teht11_13';
//import {Teht14} from './teht14_16';
import reportWebVitals from './reportWebVitals';
import { Lomake } from './teht16e';

ReactDOM.render(
  <React.StrictMode>
    <Lomake />
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
