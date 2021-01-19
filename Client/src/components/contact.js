import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Link } from "react-router-dom";
import Bootstrap from '../.././node_modules/bootstrap/dist/css/bootstrap.min.css';
import Semantic from 'semantic-ui-css/semantic.min.css';
import ProfilePicture from '../assets/brya.png';
import Java from '../assets/java.png';
import Python from '../assets/python.jpg';
import Eduform from '../assets/eduform.png';
import Quickdraw from '../assets/draw.png';
import Navigation from './fullnavbar.js';
import Axios from "axios";

class contact extends React.Component{

    constructor(props){
        super(props);

        this.state = {
            screenHeight : '',
            screenWidth : 0,
            rowHeight : '',
            actualScreenHt : 0,
            emailHasErr : 0,
            nameHasErr : 0,
            contentHasErr : 0,
            subHasErr : 0,
            error : '',
        }

        
        this.changeMyDimensions = this.changeMyDimensions.bind(this);
        this.buttoncolorchange = this.buttoncolorchange.bind(this);
        this.buttoncolorchangeback = this.buttoncolorchangeback.bind(this);
        this.checks = this.checks.bind(this);
        this.nameError = this.nameError.bind(this);
        this.emailError = this.emailError.bind(this);

        this.contentError = this.contentError.bind(this);
        this.subjectError = this.subjectError.bind(this);
    }

    componentDidMount()
    {
        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;

        if(getScreenWidth < 775)
        {

            this.setState({actualScreenHt : getScreenHeight, screenHeight : '100%' , screenWidth : getScreenWidth, rowHeight : getScreenHeight  + 'px'});
        }
        else{
            this.setState({actualScreenHt : getScreenHeight, screenHeight : '100%', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 30 + 'px'});
        }

        window.addEventListener('resize', this.changeMyDimensions);

    }


    changeMyDimensions()
    {
        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;
     

        if(getScreenWidth < 775)
        {
            this.setState({actualScreenHt : getScreenHeight,screenHeight : '100%' , screenWidth : getScreenWidth, rowHeight : getScreenHeight + 'px'});
        }
        else{
            this.setState({actualScreenHt : getScreenHeight,screenHeight : '100%', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 30 + 'px'});
        }
    }

    buttoncolorchange({currentTarget})
    {
        currentTarget.style.backgroundColor = 'white';
        currentTarget.style.color = '#3fc5fc';
    }

    buttoncolorchangeback({currentTarget})
    {
        currentTarget.style.backgroundColor = '#3fc5fc';
        currentTarget.style.color = 'white';
    }

    formchecks()
    {
        if(!(document.getElementById('usersname') === null)){
            if(document.getElementById('usersname').value.length > 0)
            {
                document.getElementById('usersname').style.backgroundColor = 'white';
                document.getElementById('nameicon').style.display = 'inline';
            }
            else{
                document.getElementById('usersname').style.backgroundColor = '#3fc5fc';
                document.getElementById('nameicon').style.display = 'none';
            }
        }
        if(!(document.getElementById('usersemail') === null)){
            if(document.getElementById('usersemail').value.includes('@')) 
            {
                document.getElementById('usersemail').style.backgroundColor = 'white';
                document.getElementById('emailicon').style.display = 'inline';
            }
            else{
                document.getElementById('usersemail').style.backgroundColor = '#3fc5fc';
                document.getElementById('emailicon').style.display = 'none';
            }
        }
        if(!(document.getElementById('usersnumber') === null)){
            if(document.getElementById('usersnumber').value.length > 11)
            {
                document.getElementById('usersnumber').style.backgroundColor = 'white';
                document.getElementById('numbericon').style.display = 'inline';
            }
            else{
                document.getElementById('usersnumber').style.backgroundColor = '#3fc5fc';
                document.getElementById('numbericon').style.display = 'none';
            }
        }
        if(!(document.getElementById('userssubject') === null)){
            if(document.getElementById('userssubject').value.length > 0)
            {
                document.getElementById('userssubject').style.backgroundColor = 'white';
                document.getElementById('subjecticon').style.display = 'inline';
            }
            else{
                document.getElementById('userssubject').style.backgroundColor = '#3fc5fc';
                document.getElementById('subjecticon').style.display = 'none';
            }
        }
        if(!(document.getElementById('userstext') === null)){
            if(document.getElementById('userstext').value.length > 5)
            {
                document.getElementById('userstext').style.backgroundColor = 'white';
                document.getElementById('texticon').style.display = 'inline';
            }
            else{
                document.getElementById('userstext').style.backgroundColor = '#3fc5fc';
                document.getElementById('texticon').style.display = 'none';
            }
        }
    }

    checks = (event) =>
    {
        event.preventDefault();
        let errorCount = 0;

        if(!(document.getElementById('usersname') === null)){
            if(document.getElementById('usersname').value.length < 1)
            {
                errorCount += 1;
                this.setState({nameHasErr : 1});
            }
            else{
                this.setState({nameHasErr : 0});
            }
        }
        if(!(document.getElementById('usersemail') === null)){
            if(document.getElementById('usersemail').value.length < 1)
            {
                errorCount += 1;
                this.setState({emailHasErr : 1});
            }
            else if(document.getElementById('usersemail').value.length >= 1 && (!(document.getElementById('usersemail').value.includes('@')))){
                errorCount += 1;
                this.setState({emailHasErr : 2});
            }
            else{
                this.setState({emailHasErr : 0});
            }
        }
        if(!(document.getElementById('userssubject') === null)){
            if(document.getElementById('userssubject').value.length < 1)
            {
                errorCount += 1;
                this.setState({subHasErr : 1});
            }
            else{
                this.setState({subHasErr : 0});
            }
        }
        if(!(document.getElementById('userstext') === null)){
            if(document.getElementById('userstext').value.length <= 5)
            {
                errorCount += 1;
                this.setState({contentHasErr : 1});
            }
            else{
                this.setState({contentHasErr : 0});
            }
        }

        if(errorCount === 0)
        {

            let username = document.getElementById('usersname').value;
            let useremail = document.getElementById('usersemail').value;
            let userheader = document.getElementById('userssubject').value;
            let usertext = document.getElementById('userstext').value;
            let usernumber = document.getElementById('usersnumber').value;

            let mydata = {
                name : username,
                email : useremail,
                header : userheader,
                text : usertext,
                number : usernumber
            };

            Axios({
                method: "POST",
                url: "http://localhost:5000/",
                headers: {
                  "Content-Type": "application/json"
                },
                data : mydata
              }).then(res => {
                console.log(res.data.message);
              });

            alert("Sent Successfully!");

            document.getElementById('usersname').value = "";
            document.getElementById('usersemail').value = "";
            document.getElementById('userssubject').value = "";
            document.getElementById('userstext').value = "";
            document.getElementById('usersnumber').value = "";

            document.getElementById('mybtn').style.backgroundColor = '#3fc5fc';
            document.getElementById('mybtn').style.color = 'white';

            this.setState({emailHasErr : 0, nameHasErr : 0, subHasErr : 0, contentHasErr : 0});
            this.formchecks();

        }
    }


    emailError()
    {
        if(this.state.emailHasErr === 0)
        {
            return '';
        }
        else if(this.state.emailHasErr === 1)
        {
            return(
            <ul>
                <li style={{color: 'white', fontSize: '1.1rem'}}>Email must contain at least 1 letter</li>
                <li style={{color: 'white', fontSize: '1.1rem'}}>Email must contain '@'</li>
            </ul>
            );
        }
        else{
            return(
            <ul>
                <li style={{color: 'white', fontSize: '1.1rem'}}>Email must contain '@'</li>
            </ul>
            );
        }
    }

    nameError()
    {
        if(this.state.nameHasErr === 0)
        {
            return '';
        }
        else{
            return(
                <ul>
                    <li style={{color: 'white', fontSize: '1.1rem'}}>Name must contain at least 1 letter</li>
                </ul>
            );
        }
    }

    subjectError()
    {
        if(this.state.subHasErr === 0)
        {
            return '';
        }
        else{
            return(
                <ul>
                    <li style={{color: 'white', fontSize: '1.1rem'}}>Please fill out the subject form</li>
                </ul>
            );
        }
    }

    contentError()
    {
        if(this.state.contentHasErr === 0)
        {
            return '';
        }
        else{
            return(
                <ul>
                    <li style={{color: 'white', fontSize: '1.1rem'}}>Please provide at least 6 letters</li>
                </ul>
            );
        }
        
    }

    render()
    {

        return(
            <div style={{minHeight: `${this.state.actualScreenHt}px`, height: this.state.screenHeight, width: '100%', backgroundColor: '#323232'}} className="container-fluid">
                    <Navigation />
                    <h1 className="headers" style={{textAlign: 'center', fontSize: '4rem', color: 'white', paddingTop: `${this.state.actualScreenHt * .05}px`}}>Contact Me</h1>
                    <div style={{padding: '15px 15px', paddingBottom: '60px'}} className="row">
                        <div style={{textAlign: 'center', margin: 'auto', height: '100%'}} className="col-12 d-flex justify-content-center">
                         
                        <form onSubmit={(e) => this.checks(e)} className="bg-transparent" style={{maxWidth: '1100px', marginTop: '20px', borderStyle: 'solid', borderColor: '#3fc5fc', width: '75%', borderRadius: '25px',paddingTop: '50px',backgroundColor: '#cbaf87',padding: '25px 35px'}}>
                            <div class="form-row">
                                <div style={{textAlign: 'left'}} class="form-group col-md-4">
                                <label className="content" style={{color: 'white', textAlign: 'left', fontSize: '1.2rem'}} for="inputEmail4">Name</label>
                                <i id="nameicon" style={{marginLeft: '10px', display: 'none'}} class="fas fa-check text-success"></i>
                                <input onKeyUp={this.formchecks} style={{backgroundColor: '#3fc5fc', borderStyle: 'solid', borderColor: '#3fc5fc', color: 'black'}} type="text" class="form-control" name="usersname" id="usersname" placeholder="John Doe"/>
                                {this.nameError()}
                                </div>
                                <div style={{textAlign: 'left'}} class="form-group col-md-4">
                                <label className="content" style={{color: 'white',fontSize: '1.2rem'}} for="inputPassword4">Email</label>
                                <i id="emailicon" style={{marginLeft: '10px', display: 'none'}} class="fas fa-check text-success"></i>
                                <input onKeyUp={this.formchecks} style={{backgroundColor: '#3fc5fc', borderStyle: 'solid', borderColor: '#3fc5fc', color: 'black'}} type="email" class="form-control" name="usersemail" id="usersemail" placeholder="jdoe@iu.edu"/>
                                {this.emailError()}
                                </div>
                                <div style={{textAlign: 'left'}} class="form-group col-md-4">
                                <label className="content" style={{color: 'white',fontSize: '1.2rem'}} for="inputPassword4">Phone Number</label>
                                <i id="numbericon" style={{marginLeft: '10px', display: 'none'}} class="fas fa-check text-success"></i>
                                <input onKeyUp={this.formchecks} style={{backgroundColor: '#3fc5fc', borderStyle: 'solid', borderColor: '#3fc5fc', color: 'black'}} type="text" class="form-control" name="usersnumber" id="usersnumber" placeholder="574-932-4562 (optional)"/>
                                </div>
                            </div>
                            <div style={{textAlign: 'left'}} class="form-group">
                                <label className="content" style={{color: 'white',fontSize: '1.2rem'}} for="inputAddress">Subject</label>
                                <i id="subjecticon" style={{marginLeft: '10px', display: 'none'}} class="fas fa-check text-success"></i>
                                <input onKeyUp={this.formchecks} style={{backgroundColor: '#3fc5fc', borderStyle: 'solid', borderColor: '#3fc5fc', color: 'black'}} type="text" class="form-control" name="userssubject" id="userssubject" placeholder="Inquiry on Software Deal" />
                                {this.subjectError()}
                            </div>
                            <div style={{textAlign: 'left'}} class="form-group">
                                <label className="content" style={{color: 'white',fontSize: '1.2rem'}} for="inputAddress2">Message</label>
                                <i id="texticon" style={{marginLeft: '10px', display: 'none'}} class="fas fa-check text-success"></i>
                                <textarea onKeyUp={this.formchecks} style={{backgroundColor: '#3fc5fc', borderStyle: 'solid', borderColor: '#3fc5fc',  color: 'black',height: '200px'}} type="text" name="userstext" class="form-control" id="userstext" placeholder="Enter Message Here..."></textarea>
                                {this.contentError()}
                            </div>
                            
                           
                            <button id="mybtn" onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} style={{fontSize: '1.1rem', marginTop: '16px',borderRadius: '25px',width: '100%',backgroundColor: '#3fc5fc', color:'white'}} type="submit" class="btn content">Send</button>
                            </form>
                       
                         </div>

                     </div>
                </div>
     
        );
    }
}

export default contact;