import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Link } from "react-router-dom";
import Bootstrap from '../.././node_modules/bootstrap/dist/css/bootstrap.min.css';
import Semantic from 'semantic-ui-css/semantic.min.css';
import ProfilePicture from '../assets/brya.png';
import Java from '../assets/javaLaptop.png';
import Python from '../assets/pythonLaptop.png';
import Eduform from '../assets/eduLaptop.png';
import Quickdraw from '../assets/iuLaptop.png';
import C from '../assets/cLaptop.png';
import Navigation from './fullnavbar.js';
import ComingSoon from '../assets/comingsoon.png';


class projects extends React.Component{

    constructor(props){
        super(props);

        this.state = {
            screenHeight : 0
        }

        this.changeMyDimensions = this.changeMyDimensions.bind(this);
        this.buttoncolorchange = this.buttoncolorchange.bind(this);
        this.clickiudraw = this.clickiudraw.bind(this);
        this.buttoncolorchangeback = this.buttoncolorchangeback.bind(this);
    }

    componentDidMount()
    {
        var getScreenHeight = window.innerHeight;

        this.setState({screenHeight : getScreenHeight});

        window.addEventListener('resize', this.changeMyDimensions);

    }


    changeMyDimensions()
    {
        var getScreenHeight = window.innerHeight;

        this.setState({screenHeight : getScreenHeight});
    }

    buttoncolorchange({currentTarget})
    {
        currentTarget.style.backgroundColor = 'white';
        currentTarget.style.color = '#3fc5fc';
    }

    buttoncolorchangeback({currentTarget})
    {
        currentTarget.style.backgroundColor = '#3fc5fc';
        currentTarget.style.color = 'black';
    }

    clickiudraw()
    {
        alert("IU Draw is currently under maintenance!");
    }

    render()
    {

        return(
            <div style={{height: '100%', minHeight: `${this.state.screenHeight}px`,minWidth: '100%',backgroundColor: '#323232'}}>
                <Navigation />
                <div style={{padding: '40px 80px 80px 80px'}} className="container">
                    <h1 className="headers" style={{textAlign: 'center',fontSize: '4rem', color: 'white', paddingTop: '20px'}}>Core Projects</h1>
                    <div className="row">
                        <div className="col-12">
                        <div style={{marginTop: '30px'}} class="card-deck">
                        
                            <div style={{paddingTop: '5px',paddingLeft: '5px', paddingRight: '5px',height: '100%',backgroundColor: '#cbaf87', borderStyle: 'solid', borderColor: '#3fc5fc',borderWidth: '.1rem'}} class="card bg-transparent">
                                <img class="card-img-top" style={{width: '100%', height: '50%'}} src={Eduform} alt="Card image cap"/>
                                <div class="card-body">
                                <h2 style={{color: 'white'}} class="card-title homeChatFont">Eduform <i style={{color: 'gold', marginLeft: '7px',display: 'inline'}} class="fas fa-star"></i></h2>
                                <Link to="/projects/coreproject/eduform" ><button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} style={{borderRadius: '0',textAlign: 'center',border: 'solid', borderColor: 'white', borderWidth: '1px',color: 'black',backgroundColor: '#3fc5fc', fontSize: '1.1rem'}} name="skills" multiple="" class="ui fluid button homeChatFont">View Eduform</button></Link>
                                
                                </div>
                            </div>
                            <div style={{paddingTop: '5px',paddingLeft: '5px', paddingRight: '5px',height: '100%',backgroundColor: '#cbaf87', borderStyle: 'solid', borderColor: '#3fc5fc',borderWidth: '.1rem'}} class="card bg-transparent">
                                <img class="card-img-top" style={{width: '100%', height: '50%'}} src={Quickdraw} alt="Card image cap"/>
                                <div class="card-body">
                                <h2 style={{color: 'white'}} class="card-title homeChatFont">IU Quick Draw <i style={{color: 'gold', marginLeft: '7px',display: 'inline'}} class="fas fa-star"></i></h2>
                                <button onClick={this.clickiudraw} onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} style={{borderRadius: '0',textAlign: 'center',border: 'solid', borderColor: 'white', borderWidth: '1px',color: 'black',backgroundColor: '#3fc5fc', fontSize: '1.1rem'}} name="skills" multiple="" class="ui fluid button homeChatFont">View Quickdraw</button>
                                
                                </div>
                            
                            </div>
                            
                        </div>

                        <div className="row">
                        <div className="col-12">
                        <div style={{marginTop: '30px'}} class="card-deck">
                        
                        <div style={{paddingTop: '5px',paddingLeft: '5px', paddingRight: '5px',height: '100%',backgroundColor: '#cbaf87', borderStyle: 'solid', borderColor: '#3fc5fc',borderWidth: '.1rem'}} class="card bg-transparent">
                            <img class="card-img-top" style={{width: '100%', height: '50%'}} src={ComingSoon} alt="Card image cap"/>
                            <div class="card-body">
                            <h2 style={{color: 'white'}} class="card-title homeChatFont">TransferMe</h2>
        
                            </div>
                        </div>
                        <div style={{paddingTop: '5px',paddingLeft: '5px', paddingRight: '5px',height: '100%',backgroundColor: '#cbaf87', borderStyle: 'solid', borderColor: '#3fc5fc',borderWidth: '.1rem'}} class="card bg-transparent">
                            <img class="card-img-top" style={{width: '100%', height: '50%'}} src={ComingSoon} alt="Card image cap"/>
                            <div class="card-body">
                            <h2 style={{color: 'white'}} class="card-title homeChatFont">Bryant's Tech Blog</h2>
   
                            </div>
                        </div>
                        </div>

                        </div>
                        </div>  
                    </div>
                </div>

                <h1 className="headers" style={{paddingTop: '30px', textAlign: 'center',fontSize: '4rem', color: 'white'}}>Smaller Programs I've Worked With</h1>
                    <div className="row">
                        <div className="col-12">
                        <div style={{marginTop: '30px'}} class="card-deck">
                            <div style={{borderWidth: '.1rem', paddingTop: '5px',paddingLeft: '5px', paddingRight: '5px',height: '100%', borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                                <img class="card-img-top" style={{width: '100%', height: '50%'}} src={Java} alt="Card image cap"/>
                                <div class="card-body">
                                <h2 style={{color: 'white'}} class="card-title homeChatFont">Java Programs</h2>
                                <select style={{border: 'solid', borderColor: 'white', borderWidth: '1px', color: 'black',backgroundColor: '#3fc5fc'}} name="skills" multiple="" class="ui fluid dropdown">
                                    <option value="">Multiplayer Dodgeball</option>
                                    <option value="">Project Management System</option>
                                    <option value="node">Basic Java Servlets using Spring Boot</option>
                                    <option value="angular">MVC with Multi-Dimensional Arrays</option>
                                    <option value="css">Knapsack Algorithm</option>
                                    <option value="design">BFS and DFS Algorithms</option>
                                    <option value="ember">Edit Distance with Large Files</option>
                                    <option value="html">Longest Path Algorithms</option>
                                    <option value="ia">Shortest Distance Algorithms</option>
                                    <option value="javascript">Huffman Trees</option>
                                    <option value="mech">BST-AVL-Spanning Tree Algorithms</option>
                                    <option value="meteor">Queues and Heap Algorithms</option>
                                    </select>
                                </div>
                            </div>
                            <div style={{paddingTop: '5px',paddingLeft: '5px', paddingRight: '5px',height: '100%',backgroundColor: '#cbaf87', borderStyle: 'solid', borderColor: '#3fc5fc',borderWidth: '.1rem'}} class="card bg-transparent">
                                <img class="card-img-top" style={{width: '100%', height: '50%'}} src={C} alt="Card image cap"/>
                                <div class="card-body">
                                <h2 style={{color: 'white'}} class="card-title homeChatFont">C/Unix Programs</h2>
                                <select style={{border: 'solid', borderColor: 'white', borderWidth: '1px', color: 'black',backgroundColor: '#3fc5fc'}} name="skills" multiple="" class="ui fluid dropdown">
                                    <option value="airhockey">Air Hockey</option>
                                    <option value="collegestudentsalaries">College Student Salary Analysis</option>
                                    <option value="pokerhands">Poker Hands</option>
                                    <option value="controversialtopics">Controversial Topic Statistics</option>
                                    <option value="fileio">Basic File I/O with Large Files</option>
                                    <option value="forkpipes">Communication with Forks and Pipes</option>
                                    <option value="ia">Multithreads and Basic Calculations</option>
                                    <option value="javascript">Semaphores for Synchronization</option>
                                    <option value="mech">Manipulation of Bits</option>
                                    <option value="meteor">Binary Representations</option>
                                    <option value="node">Reverse Engineering with Assembly</option>
                                    </select>
                                </div>
                            </div>
                            <div style={{paddingTop: '5px',paddingLeft: '5px', paddingRight: '5px',height: '100%',backgroundColor: '#cbaf87', borderStyle: 'solid', borderColor: '#3fc5fc',borderWidth: '.1rem'}} class="card bg-transparent">
                                <img class="card-img-top" style={{width: '100%', height: '50%'}} src={Python} alt="Card image cap"/>
                                <div class="card-body">
                                <h2 style={{color: 'white'}} class="card-title homeChatFont">Python Programs</h2>
                                <select style={{border: 'solid', borderColor: 'white', borderWidth: '1px', color: 'black',backgroundColor: '#3fc5fc'}} name="skills" multiple="" class="ui fluid dropdown">
                                    <option value="">Map Creator with gmplot</option>
                                    <option value="angular">Basic Location Tracker</option>
                                    <option value="css">U.S. Life Expectancy Analysis</option>
                                    <option value="design">Integral Calulator</option>
                                    <option value="ember">Dictionary for Text Files</option>
                                    <option value="html">Currency Translator</option>
                                    <option value="ia">Windchill and Tax Calculator</option>
                                    <option value="javascript">Matplotlib and Quadratic Equations</option>
                                    <option value="mech">Optimization Functions for Heat Loss</option>
                                    </select>
                                </div>
                            </div>
                         
                        </div>
                        </div>

                    </div>
            </div>
            </div>
                    

        );
    }
}

export default projects;