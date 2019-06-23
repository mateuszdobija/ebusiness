import React from 'react';
import logo from './MateuszDobija.jpg';
import './1.css';
import App from "./App";


import { Component } from 'react';
import {
    BrowserRouter as Router,
    Route,
    Link
} from 'react-router-dom';



import Admin_add_book from "./Admin_add_book";
import Admin_add_ebook from "./Admin_add_ebook";
import Admin_add_audiobook from "./Admin_add_audiobook";
import Admin_add_category from "./Admin_add_category";
import Admin_add_publisher from "./Admin_add_publisher";

import Admin_del_book from "./Admin_del_book";
import Admin_del_publisher from "./Admin_del_publisher";
import Admin_del_ebook from "./Admin_del_ebook";
import Admin_del_audiobook from "./Admin_del_audiobook";
import Admin_del_category from "./Admin_del_category";


var logged = <li> <a href="http://localhost:9000/signOut">Wyloguj</a>  </li>;
var unlogged = <li> <Link to="/logowanie">Zaloguj</Link>  </li>;

class Admin_menu extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            state:null,
            error: null,
            isLoaded: false,
            data:null,
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
                            <Link to="/Admin_menu/admin_add_book">dodaj książkę</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_add_ebook">dodaj ebook</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_add_audiobook">dodaj audiobook</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_add_category">dodaj kategorię</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_add_publisher">dodaj wydawcę</Link>
                        </li>
                    </ul>
                    <ul className="menu">
                        <li>
                            <Link to="/Admin_menu/admin_del_book">usuń książkę</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_del_ebook">usuń ebook</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_del_audiobook">usuń audiobook</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_del_category">usuń kategorię</Link>
                        </li>
                        <li>
                            <Link to="/Admin_menu/admin_del_publisher">usuń wydawcę</Link>
                        </li>

                    </ul>
                    <Route path="/Admin_menu/admin_add_book" component={Admin_add_book}/>
                    <Route path="/Admin_menu/admin_add_ebook" component={Admin_add_ebook}/>
                    <Route path="/Admin_menu/admin_add_audiobook" component={Admin_add_audiobook}/>
                    <Route path="/Admin_menu/admin_add_category" component={Admin_add_category}/>
                    <Route path="/Admin_menu/admin_add_publisher" component={Admin_add_publisher}/>

                    <Route path="/Admin_menu/admin_del_book" component={Admin_del_book}/>
                    <Route path="/Admin_menu/admin_del_publisher" component={Admin_del_publisher}/>
                    <Route path="/Admin_menu/admin_del_ebook" component={Admin_del_ebook}/>
                    <Route path="/Admin_menu/admin_del_audiobook" component={Admin_del_audiobook}/>
                    <Route path="/Admin_menu/admin_del_category" component={Admin_del_category}/>

                </div>
            </Router>
        )
    }
}

export default Admin_menu;