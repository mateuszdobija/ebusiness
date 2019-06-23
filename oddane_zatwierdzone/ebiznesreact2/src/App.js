import React from 'react';
import logo from '././MateuszDobija.jpg';
import './App.css';


import { Component } from 'react';
import {
  BrowserRouter as Router,
  Route,
  Link
} from 'react-router-dom';

import Autorzy from './Autorzy';
import Wydawcy from './Wydawcy';
import Kategorie from './Kategorie';
import Ksiazki from './Ksiazki';
import Home from './Home';
import Audiobooki from './Audiobooki';
import Ebooki from './Ebooki';
import Admin_add_book from './Admin_add_book';
import Logowanie from './Logowanie';
import Admin_menu from './Admin_menu';

var logged = <li> <a href="http://localhost:9000/signOut">Wyloguj</a>  </li>;
var unlogged = <li> <Link to="/logowanie">Zaloguj</Link>  </li>;
class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            state:null,
            error: null,
            isLoaded: false,
            data:null,
            loggedIn:null
        };
    }
    componentDidMount() {
        this.getData();
    }

    getData() {
        fetch("http://localhost:9000/isLogged", {credentials:"include"})
            .then(res => res.json())
            .then(
                (result) => {
                    this.setState({loggedIn:logged})

                },
                (error) => {
                    this.setState({loggedIn:unlogged})
                }
            )
    }

    render() {
      return (
          <Router>
              <div className="container">

                  <ul className="menu">
                      <li>
                          <Link to="/">Home</Link>
                      </li>
                      <li>
                          <Link to="/autorzy">Autorzy</Link>
                      </li>
                      <li>
                          <Link to="/kategorie">Kategorie</Link>
                      </li>
                      <li>
                          <Link to="/wydawcy">Wydawcy</Link>
                      </li>
                      <li>
                          <Link to="/ksiazki">Książki</Link>
                      </li>
                      <li>
                          <Link to="/audiobooki">Audiobooki</Link>
                      </li>
                      <li>
                          <Link to="/ebooki">Ebooki</Link>
                      </li>
                      {this.state.loggedIn}
                  </ul>
                  <img className="profilowe" src={logo} alt='Zdjęcie profilowe'/>

                  <Route exact path="/" component={Home}/>
                  <Route path="/autorzy" component={Autorzy}/>
                  <Route path="/wydawcy" component={Wydawcy}/>
                  <Route path="/kategorie" component={Kategorie}/>
                  <Route path="/ksiazki" component={Ksiazki}/>
                  <Route path="/audiobooki" component={Audiobooki}/>
                  <Route path="/ebooki" component={Ebooki}/>
                  <Route path="/logowanie" component={Logowanie}/>
                  <Route path="/Admin_menu" component={Admin_menu}/>

              </div>
          </Router>
      )
  }
}

export default App;
