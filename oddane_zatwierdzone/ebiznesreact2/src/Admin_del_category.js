import React from 'react';
import logo from './MateuszDobija.jpg';
import './1.css';
import App from "./App";

class Admin_del_category extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            error: null,
            isLoaded: false,
            data:null,
        };

        this.handleSubmit = this.handleSubmit.bind(this);

    }

    handleSubmit(event) {
        event.preventDefault();
        const data = new FormData(event.target);
        var url = 'http://localhost:9000/delCategory';
        fetch(url, {
            method: 'POST',
            body: data,
        }).then(res => res.json()).then(res => {console.log(res)});
    }

    componentDidMount() {
        this.getData();
    }

    getData() {
        fetch("http://localhost:9000/categories")
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
                <tr key={row.name}>
                    <td> {row.name}</td>
                    <td><form onSubmit={this.handleSubmit}>
                        <input type="hidden" name="name" value={row.name}/>
                        <input type="submit" value="Usuń" />
                    </form></td>
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
                                <th>nazwa kategorii</th>
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


export default Admin_del_category;