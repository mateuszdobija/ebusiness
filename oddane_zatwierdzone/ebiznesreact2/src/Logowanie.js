import React from 'react';
import logo from './MateuszDobija.jpg';
import './1.css';
import App from "./App";

import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';


class Logowanie extends React.Component {
    render() {
        return(
            <div>
                <a style={{background: '#D14836'}} href="http://localhost:9000/authenticate/google">
                    <img src={process.env.PUBLIC_URL + '/google.png'} alt={'Google'}></img>
                </a>
                <a style={{background: '#00ACED'}} href="http://localhost:9000/authenticate/twitter">
                    <img src={process.env.PUBLIC_URL + '/twitter.png'} alt={'Twitter'}></img>
                </a>

            </div>
        );
    }
}

export default Logowanie;