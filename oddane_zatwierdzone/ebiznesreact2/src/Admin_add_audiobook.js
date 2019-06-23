import React from 'react';
import logo from './MateuszDobija.jpg';
import './1.css';
import App from "./App";

class Admin_add_audiobook extends React.Component {

    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);
        var url = 'http://localhost:9000/addAudioBook';
        fetch(url, {
            method: 'POST',
            body: data,
        }).then(res => res.json()).then(res => {console.log(res)});
    }

    render() {


            return (
                <React.Fragment>
                    <div style={{padding:"15px"}}>
                        Dodaj eksiążkę
                        <form onSubmit={this.handleSubmit}>
                            <label>
                                isbn:
                                <input type="text" name="isbn" />
                            </label>
                            <label>
                                tytuł:
                                <input type="text" name="title" />
                            </label>
                            <label>
                                id autora:
                                <input type="number" name="author_id" />
                            </label>
                            <label>
                                cena:
                                <input type="number" name="price" />
                            </label>
                            <label>
                                rok:
                                <input type="number" name="year" />
                            </label>
                            <label>
                                język:
                                <input type="text" name="language" />
                            </label>
                            <label>
                                strony:
                                <input type="number" name="pages_number" />
                            </label>
                            <label>
                                kategoria:
                                <input type="text" name="category" />
                            </label>
                            <label>
                                wydawca:
                                <input type="text" name="publisher" />
                            </label>
                            <label>
                                opis:
                                <input type="text" name="description" />
                            </label>
                            <input type="submit" value="Submit" />
                        </form>
                    </div>

                </React.Fragment>
            )

        }
}


export default Admin_add_audiobook;