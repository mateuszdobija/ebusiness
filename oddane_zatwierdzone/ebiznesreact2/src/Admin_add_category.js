import React from 'react';
import logo from './MateuszDobija.jpg';
import './1.css';
import App from "./App";

class Admin_add_category extends React.Component {

    constructor(props) {
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);
        var url = 'http://localhost:9000/addCategory';
        fetch(url, {
            method: 'POST',
            body: data,
        }).then(res => res.json()).then(res => {console.log(res)});
    }

    render() {


            return (
                <React.Fragment>
                    <div style={{padding:"15px"}}>
                        Dodaj kategorię
                        <form onSubmit={this.handleSubmit}>
                            <label>
                                name:
                                <input type="text" name="name" />
                            </label>

                            <input type="submit" value="Submit" />
                        </form>
                    </div>

                </React.Fragment>
            )

        }
}


export default Admin_add_category;