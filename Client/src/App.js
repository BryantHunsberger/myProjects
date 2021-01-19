import React from 'react';
import ReactDOM from 'react-dom';
import './App.css';
import './index.css';
import { BrowserRouter, Route, Link } from "react-router-dom";

import Welcome from "./components/myhome.js";
import Projects from "./components/projects.js";
import About from "./components/about.js";
import Contact from "./components/contact.js";
import Eduform from "./components/eduform.js";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <div>
                    <Route exact path='/' component={Welcome} />
                    <Route exact path='/projects' component={Projects} />
                    <Route exact path='/about' component={About} />
                    <Route exact path='/contact' component={Contact} />
                    <Route exact path='/projects/coreproject/eduform' component={Eduform} />
                </div>
            </BrowserRouter>
        </div>
    );
}

export default App;
