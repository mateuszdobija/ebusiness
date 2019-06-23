import React from 'react';
import logo from './MateuszDobija.jpg';
import './1.css';
import App from "./App";

class Moj_profil extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            data:null,
        };
    }

    componentDidMount() {
        this.getData();
    }

    getData() {
        fetch("http://localhost:9000/authors")
            .then(res => res.json())
            .then(
                (result) => {
                    // console.log(result)
                    this.setState({
                        isLoaded: true,
                        data: result
                    });
                },
                (error) => {
                    console.log(error)
                }
            )
    }

    renderData() {
        console.log(this.state.data)
        return this.state.data.map((row) => {
            return (
                <tr key={row.id}>
                    <td> {row.id}</td>
                    <td> {row.name}</td>
                    <td> {row.surname}</td>
                    <td> {row.nacionality}</td>
                    <td> {row.birth_date}</td>
                </tr>
            );
        })

    }


    render() {

        if (this.state.isLoaded) {
            return (
                <React.Fragment>
                    <div style={{padding:"15px"}}>

                        <table className="kursy">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>imię</th>
                                <th>nazwisko</th>
                                <th>narodowość</th>
                                <th>data urodzenia</th>
                            </tr>
                            </thead>

                            <tbody>
                            {this.state.isLoaded && this.renderData()}
                            </tbody>
                        </table>
                    </div>

                </React.Fragment>
            )
        } else {
            return (
                <div> loading ... </div>
            )
        }

    }
}

export default Moj_profil;