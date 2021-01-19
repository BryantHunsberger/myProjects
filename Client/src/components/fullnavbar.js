import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Link } from "react-router-dom";
import Bootstrap from '../.././node_modules/bootstrap/dist/css/bootstrap.min.css';
import Semantic from 'semantic-ui-css/semantic.min.css';
import ProfilePicture from '../assets/brya.png';

class fullnavbar extends React.Component{

    constructor(props){
        super(props);

        this.state = {
 
        }

        this.changeMyDimensions = this.changeMyDimensions.bind(this);
        this.buttoncolorchange = this.buttoncolorchange.bind(this);
        this.buttoncolorchangeback = this.buttoncolorchangeback.bind(this);
    }


    componentDidMount()
    {
        var screenWidth = window.innerWidth;
            var screenHeight = window.innerHeight;
        if(screenWidth < 992)
        {
            if(!(document.getElementById("name") === null)){
                document.getElementById("name").style.display = "none";
            }
            if(!(document.getElementById("items") === null)){
                document.getElementById("items").className = "navbar-toggler mr-auto";
            }
        }
        else{
            if(!(document.getElementById("name") === null)){
                document.getElementById("name").style.display = "inline-block";
            }
            if(!(document.getElementById("items") === null)){
                document.getElementById("items").className = "navbar-toggler ml-auto";
            }
        }

        window.addEventListener('resize', this.changeMyDimensions);
    }

    changeMyDimensions()
    {
        var screenWidth = window.innerWidth;
     
        if(screenWidth < 992)
        {
            if(!(document.getElementById("name") === null)){
                document.getElementById("name").style.display = "none";
            }
            if(!(document.getElementById("items") === null)){
                document.getElementById("items").className = "navbar-toggler mr-auto";
            }
        }
        else{
            if(!(document.getElementById("name") === null)){
                document.getElementById("name").style.display = "inline-block";
            }
            if(!(document.getElementById("items") === null)){
                document.getElementById("items").className = "navbar-toggler ml-auto";
            }
        }
    }

    buttoncolorchange({currentTarget})
    {
        currentTarget.style.color = 'white';
    }

    buttoncolorchangeback({currentTarget})
    {
        currentTarget.style.color = '#3fc5fc';
    }

    render(){

        
        return(
            <nav class="navbar navbar-expand-lg">
                <a id="name" className="navbar-brand bryantsname" style={{display: 'inline-block',color: '#3fc5fc'}}><b>Bryant Hunsberger</b></a>
                <button id="items" style={{marginRight: '10px', marginTop: '15px'}} class="navbar-toggler ml-auto" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <i style={{color: '#3fc5fc', fontSize: '3rem'}} class="fa fa-stream"></i>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul style={{fontSize: '1.25rem'}} class="navbar-nav ml-auto homeChatFont">
                    <li class="nav-item">
                        <Link onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} to="/projects" style={{color: '#3fc5fc'}} class="nav-link" href="#">Projects</Link>
                    </li>
                    <li class="nav-item">
                        <Link onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} to="/about" style={{color: '#3fc5fc'}} class="nav-link" href="#">About</Link>
                    </li>
                    <li class="nav-item">
                        <Link onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} to="/contact" style={{color: '#3fc5fc'}} class="nav-link" href="#">Contact</Link>
                    </li>
                    </ul>
                </div>
            </nav>

        );
    }
}

export default fullnavbar;