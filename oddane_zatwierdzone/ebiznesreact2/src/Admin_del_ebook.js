import React from 'react';
import logo from './MateuszDobija.jpg';
import './1.css';
import App from "./App";



class Ebooki extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            data:null,
        };
    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);
        var url = 'http://localhost:9000/delEBook';
        fetch(url, {
            method: 'POST',
            body: data,
            credentials:"include"
        }).then(res => res.json()).then(res => {console.log(res);});
    }

    componentDidMount() {
        this.getData();
    }

    getData() {
        fetch("http://localhost:9000/ebooks")
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
                    <td> {row.isbn}</td>
                    <td> {row.title}</td>
                    <td> {parseFloat(row.price.toFixed(2))}</td>
                    <td> {row.year}</td>
                    <td> {row.language}</td>
                    <td> {row.pages_number}</td>
                    <td> {row.category}</td>
                    <td> {row.publisher}</td>
                    <td><form onSubmit={this.handleSubmit}>
                        <input type="hidden" name="id" value={row.id}/>
                        <input type="submit" value="usuń" />                </form></td>

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
                                <th>isbn</th>
                                <th>tytuł</th>
                                <th>cena</th>
                                <th>rok</th>
                                <th>język</th>
                                <th>l. stron</th>
                                <th>kategoria</th>
                                <th>wydawnictwo</th>
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

export default Ebooki;