import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Link } from "react-router-dom";
import Bootstrap from '../.././node_modules/bootstrap/dist/css/bootstrap.min.css';
import Semantic from 'semantic-ui-css/semantic.min.css';
import ProfilePicture from '../assets/brya.png';
import FullBar from './fullnavbar';
import IndianaLogo from '../assets/Indiana.png';

class about extends React.Component{

    constructor(props){
        super(props);
      
        this.state = {
            screenHeight : '',
            screenWidth : 0,
            rowHeight : '',
            pictureWidth : 0,
            pictureHeight : 0,
            chatsize : '',
            chatposition : 0,
            questionMargin : 0,
            whichAnswer : "0",
            chatwordleft : 0,
            chatwordbottom : 0,
            textOption : 0,
            displayOp : 0,
            order : 0,
            iconcircleleft : 0,
            iconcirclebottom : 0,
            currentdot : 0,
            accesspermitted : 'false'
        }

        this.changeMyDimensions = this.changeMyDimensions.bind(this);
        this.buttoncolorchange = this.buttoncolorchange.bind(this);
        this.buttoncolorchangeback = this.buttoncolorchangeback.bind(this);
        this.clickOnWord = this.clickOnWord.bind(this);
        this.submitQuestion = this.submitQuestion.bind(this);
        this.questionsBar = this.questionsBar.bind(this);
        this.reset = this.reset.bind(this);
        this.display = this.display.bind(this);
        this.setDefaultValues = this.setDefaultValues.bind(this);
        this.answerOne = this.answerOne.bind(this);
        this.answerTwo = this.answerTwo.bind(this);
        this.answerThree = this.answerThree.bind(this);
        this.answerFour = this.answerFour.bind(this);
        this.answerFive = this.answerFive.bind(this);
        this.answerSix = this.answerSix.bind(this);
        this.answerSeven = this.answerSeven.bind(this);
        this.answerEight = this.answerEight.bind(this);
        this.answerNine = this.answerNine.bind(this);
        this.answerTen = this.answerTen.bind(this);
        this.answerEleven = this.answerEleven.bind(this);
        this.answerTwelve = this.answerTwelve.bind(this);
        this.answerThirteen = this.answerThirteen.bind(this);
        this.answerFourteen = this.answerFourteen.bind(this);
        this.answerFifteen = this.answerFifteen.bind(this);
        this.answerTwenty = this.answerTwenty.bind(this);
        this.answerTwentyOne = this.answerTwentyOne.bind(this);
        this.answerTwentyTwo = this.answerTwentyTwo.bind(this);
        this.itemOrder = this.itemOrder.bind(this);
        this.myanswer = this.myanswer.bind(this);
        this.dotTransfer = this.dotTransfer.bind(this);
    }

    componentDidMount()
    {
        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;

        window.setInterval(this.dotTransfer, 170);

        if(getScreenWidth < 775)
        {

            this.setState({screenHeight : (getScreenHeight) + 'px' , screenWidth : getScreenWidth, rowHeight : getScreenHeight - 96 + 'px', pictureHeight : 280, pictureWidth : 330, chatsize : '14rem', chatposition : 110, questionMargin : 0, chatwordleft : 272, chatwordbottom : 257, order : 1, iconcirclebottom : 275, iconcircleleft : 275});
        }
        else if(getScreenWidth < 1000)
        {
            this.setState({screenHeight : (getScreenHeight) + 'px', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 96 + 'px', pictureHeight : 370, pictureWidth : 420, chatsize : '14rem', chatposition : 130, questionMargin : 80, chatwordleft : 365, chatwordbottom : 330, order : 1, iconcirclebottom : 345, iconcircleleft : 365});
        }
        else{
            this.setState({screenHeight : (getScreenHeight) + 'px', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 62 + 'px', pictureHeight : 420, pictureWidth : 470, chatsize : '16rem', chatposition : 150, questionMargin : 80, chatwordleft : 430, chatwordbottom : 375, order : 0, iconcirclebottom : 375, iconcircleleft : 415});
        }

        window.addEventListener('resize', this.changeMyDimensions);

    }


    changeMyDimensions()
    {
        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;

        if(getScreenWidth < 775)
        {

            this.setState({screenHeight : (getScreenHeight) + 'px' , screenWidth : getScreenWidth, rowHeight : getScreenHeight - 96 + 'px', pictureHeight : 280, pictureWidth : 330, chatsize : '14rem', chatposition : 110, questionMargin : 0, chatwordleft : 272, chatwordbottom : 257, order : 1, iconcirclebottom : 275, iconcircleleft : 275});
        }
        else if(getScreenWidth < 1000)
        {
            this.setState({screenHeight : (getScreenHeight) + 'px', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 96 + 'px', pictureHeight : 370, pictureWidth : 420, chatsize : '14rem', chatposition : 130, questionMargin : 80, chatwordleft : 365, chatwordbottom : 330, order : 1, iconcirclebottom : 345, iconcircleleft : 365});
        }
        else{
            this.setState({screenHeight : (getScreenHeight) + 'px', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 62 + 'px', pictureHeight : 420, pictureWidth : 470, chatsize : '16rem', chatposition : 150, questionMargin : 80, chatwordleft : 430, chatwordbottom : 375, order : 0, iconcirclebottom : 375, iconcircleleft : 415});
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

    clickOnWord({currentTarget})
    {
        if(!(document.getElementById('corebutton') === null)){
            document.getElementById('corebutton').innerText = currentTarget.innerText;
            document.getElementById('corebutton').value = currentTarget.id;
        }
        this.setState({displayOp : 0, textOption : 1});
    }

    submitQuestion({currentTarget})
    {
        let currVal = currentTarget.value;
        this.setState({displayOp : 1, accesspermitted : 'true'});
        
        window.setTimeout(() => this.myanswer(currVal), 1000);

        

    }

    myanswer = (value) =>
    {
        this.setState({whichAnswer : value,accesspermitted : 'false'});
    }

    dotTransfer()
    {
        if(this.state.accesspermitted === 'true'){
            if(this.state.currentdot === 0)
            {
                if(!(document.getElementById('dot1') === null) && !(document.getElementById('dot2') === null) && !(document.getElementById('dot3') === null)){
                    document.getElementById('dot1').style.fontSize =  "5rem";
                    document.getElementById('dot2').style.fontSize =  "4rem";
                    document.getElementById('dot3').style.fontSize =  "4rem";
                }
                this.setState({currentdot : 1});
            }
            else if(this.state.currentdot === 1)
            {
                if(!(document.getElementById('dot1') === null) && !(document.getElementById('dot2') === null) && !(document.getElementById('dot3') === null)){
                    document.getElementById('dot2').style.fontSize =  "5rem";
                    document.getElementById('dot3').style.fontSize =  "4rem";
                    document.getElementById('dot1').style.fontSize =  "4rem";
                }
                this.setState({currentdot : 2});
            }
            else{
                if(!(document.getElementById('dot1') === null) && !(document.getElementById('dot2') === null) && !(document.getElementById('dot3') === null)){
                    document.getElementById('dot3').style.fontSize =  "5rem";
                    document.getElementById('dot2').style.fontSize =  "4rem";
                    document.getElementById('dot1').style.fontSize =  "4rem";
                }
                this.setState({currentdot : 0});
            }
        }
    }

    questionsBar()
    {
        return(
        <div style={{marginTop: `${this.state.questionMargin}px`, width: '100%',borderRadius: '10px'}} class="btn-group bg-transparent" role="group" aria-label="Button group with nested dropdown">
        <div class="btn-group" role="group">
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} style={{borderStyle: 'solid', borderColor: '#3fc5fc',fontSize: '1.2rem', color: '#3fc5fc'}} id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle bg-transparent" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Questions
            </button>
            <div style={{backgroundColor: '#3fc5fc', overflow: 'auto', height: '150px'}} class="dropdown-menu" aria-labelledby="btnGroupDrop1">
            <a id="1" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What is your major?</a>
            <a id="2" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">Which courses have you taken?</a>
            <a id="3" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">Which word describes you best?</a>
            <a id="4" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What sets you apart from others?</a>
            <a id="5" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">Tell me an interesting fact</a>
            <a id="6" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">Where are you from?</a>
            <a id="7" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">Where do you see yourself in 10 years?</a>
            <a id="8" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">Favorite Programming Language?</a>
            <a id="9" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What are your greatest strengths?</a>
            <a id="10" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What are you passionate about?</a>
            <a id="11" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What motivates you?</a>
            <a id="12" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">How do you like your coffee?</a>
            <a id="13" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What is your favorite sport?</a>
            <a id="14" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">When do you graduate?</a>
            <a id="15" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">Which city would you like to live in?</a>
            <a id="20" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What is your favorite quote?</a>
            <a id="21" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">How do you work under pressure?</a>
            <a id="22" onClick={this.clickOnWord} style={{fontSize: '1.2rem', borderBottom: 'solid', borderColor: 'black'}} class="dropdown-item" href="#">What technical skills do you have?</a>
            </div>
        </div>
        <button onClick={this.submitQuestion} value="0" id="corebutton" onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} style={{borderStyle: 'solid', borderColor: '#3fc5fc', color: '#3fc5fc', fontSize: '1.2rem',width: '70%'}} type="button" class="btn btn-secondary bg-transparent">Ask Question</button>
    </div>);
    }

    pickOption()
    {
        if(this.state.whichAnswer === "0")
        {
            return this.questionsBar();
        }
        else if(this.state.whichAnswer === "1")
        {
            return this.answerOne();
        }
        else if(this.state.whichAnswer === "2")
        {
            return this.answerTwo();
        }
        else if(this.state.whichAnswer === "3")
        {
            return this.answerThree();
        }
        else if(this.state.whichAnswer === "4")
        {
            return this.answerFour();
        }
        else if(this.state.whichAnswer === "5")
        {
            return this.answerFive();
        }
        else if(this.state.whichAnswer === "6")
        {
            return this.answerSix();
        }
        else if(this.state.whichAnswer === "7")
        {
            return this.answerSeven();
        }
        else if(this.state.whichAnswer === "8")
        {
            return this.answerEight();
        }
        else if(this.state.whichAnswer === "9")
        {
            return this.answerNine();
        }
        else if(this.state.whichAnswer === "10")
        {
            return this.answerTen();
        }
        else if(this.state.whichAnswer === "11")
        {
            return this.answerEleven();
        }
        else if(this.state.whichAnswer === "12")
        {
            return this.answerTwelve();
        }
        else if(this.state.whichAnswer === "13")
        {
            return this.answerThirteen();
        }
        else if(this.state.whichAnswer === "14")
        {
            return this.answerFourteen();
        }
        else if(this.state.whichAnswer === "15")
        {
            return this.answerFifteen();
        }
        else if(this.state.whichAnswer === "20")
        {
            return this.answerTwenty();
        }
        else if(this.state.whichAnswer === "21")
        {
            return this.answerTwentyOne();
        }
        else
        {
            return this.answerTwentyTwo();
        }
    }

    answerOne()
    {
        return (
            <h2 style={{textAlign: 'center', color: 'white'}}><img style={{height: '60px', width: '50px', marginBottom: '7px'}} src={IndianaLogo} /><br/>I am a Computer Science Major with a Specialization in Software Engineering!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerTwo()
    {
        return (
            <h3 style={{color: 'white'}}>
                <span style={{color: '#3fc5fc', fontSize: '1.7rem'}}>Courses</span>
                <ul style={{marginTop: '5px',textAlign: 'left',overflow: 'auto', height: '300px'}}>
                    <li>Software Engineering I (P-465)</li>
                    <li>Engineering for Distributed Systems (P-434)</li>
                    <li>Database Concepts (B-461)</li>
                    <li>Linear Algebra (M-303)</li>
                    <li>Computer Systems Engineering (C-335)</li>
                    <li>Intro to Operating Systems (P-436)</li>
                    <li>Object Oriented Software (C-322)</li>
                    <li>Independent Study (Y-390)</li>
                    <li>Statistical Inference (S-350)</li>
                    <li>Data Structures (C-343)</li>
                    <li>Data Analysis and Mining (B-365)</li>
                    <li>Intro to Software Systems (C-212)</li>
                    <li>C# and .NET (A-290)</li>
                    <li>C and Unix (C-291)</li>
                    <li>Managing Information Tech (V-369)</li>
                    <li>Discrete Structures (C-241)</li>
                    <li>Parasitology (M-375)</li>
                    <li>Animal Behavior (Z-460)</li>
                    <li>Organic Chemistry Lab (C-343)</li>
                    <li>Scientific Scuba (I-270)</li>
                    <li>Statistics for Life Sciences (S-303)</li>
                    <li>Organic Chemistry I (C-341)</li>
                    <li>Calculus (M-211)</li>
                    <li>Spanish II (S-250)</li>
                </ul>
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc', fontSize: '1.3rem'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h3>
        );
    }

    answerThree()
    {
        return (
            <h1 style={{color: 'white'}}>Relentless!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h1>
        );
    }

    answerFour()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}} class="fas fa-brain"></i><br />My mindset for applying my technical knowledge sets me apart from the rest. I refuse to accept mediocrity; my code must be the most efficient, my UI must be ingenious, and I must be the hardest worker in the room.
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerFive()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}} class="fas fa-coffee"></i><br/>I love coffee! I find coffee and technology are a great duo.
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }
    answerSix()
    {
        return (
            <h1 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}} class="fas fa-flag-usa"></i><br />I am from South Bend, Indiana!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h1>
        );
    }

    answerSeven()
    {
        return (
            <h2 style={{color: 'white'}}>In 10 years, I see myself leading a startup company and adding my piece of value to the world!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerEight()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}} class="fab fa-java"></i><br/>My favorite programming language is Java!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerNine()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}} class="fas fa-search"></i><br />I have considerable problem solving skills. On my research team, I devised a plan to integrate Javascript and Django for running my research group's machine vision models with no prior knowledge. In the development of a Learning Management System named Eduform, I devised my own algorithms for many components (View in my projects).
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerTen()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}} class="fas fa-seedling"></i><br/>I am passionate about technology and sustainability, I believe the key to our growth as a species lies in this important fusion.
            
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerEleven()
    {
        return (
            <h2 style={{color: 'white'}}>For me this is simple: Fear of Failure 
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerTwelve()
    {
        return (
            <h2 style={{color: 'white'}}>I like my coffee very strong with vanilla flavoring.
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerThirteen()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}}  class="fas fa-football-ball"></i><br/>Football, Go Bears!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerFourteen()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}}  class="fas fa-user-graduate"></i><br/>I graduate this May 2021!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerFifteen()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}}  class="fas fa-city"></i><br/>I've always wanted to live in New York City or Chicago!
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }


    answerTwenty()
    {
        return (
            <h2 style={{color: 'white'}}><i style={{color: '#3fc5fc', fontSize: '4rem', marginBottom: '7px'}}  class="fas fa-quote-right"></i><br/>I have not failed. I’ve just found 10,000 ways that won’t work - Thomas Edison
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerTwentyOne()
    {
        return (
            <h2 style={{color: 'white'}}>I find that I do my best work in this state. It is in this state of pressure that I am able to transcend my mental barriers as what I had previously perceived as impossible, and make it possible.
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    answerTwentyTwo()
    {
        return (
            <h2 style={{color: 'white'}}>
              <div style={{overflow: 'auto', height: '350px'}} class="ui cards">
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">Java</div>
                    <div style={{color: 'white'}} class="description">
                        2 years
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">Python</div>
                    <div style={{color: 'white'}} class="description">
                        1 year
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">C/Unix</div>
                    <div style={{color: 'white'}} class="description">
                        1 year
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">Javascript</div>
                    <div style={{color: 'white'}} class="description">
                        2 years
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">React</div>
                    <div style={{color: 'white'}} class="description">
                        1.5 years
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">C# and .NET</div>
                    <div style={{color: 'white'}} class="description">
                        6 months
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">Spring Boot</div>
                    <div style={{color: 'white'}} class="description">
                        1 year
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">HTML/CSS</div>
                    <div style={{color: 'white'}} class="description">
                        3 years
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">AWS</div>
                    <div style={{color: 'white'}} class="description">
                        6 months
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">Postgres</div>
                    <div style={{color: 'white'}} class="description">
                        1 year
                    </div>
                    </div>
                </div>
                <div style={{borderStyle: 'solid', borderColor: '#3fc5fc'}} class="card bg-transparent">
                    <div class="content">
                    <div style={{color: '#3fc5fc'}} class="header">Many more...</div>
                    </div>
                </div>
                </div>
            <button onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} onClick={this.reset} style={{paddingTop: '25px',color: '#3fc5fc'}} type="button" class="btn btn-lg btn-block bg-transparent">Return to Questions</button></h2>
        );
    }

    reset()
    {
        this.setState({whichAnswer : "0", textOption : 0, displayOp : 0});
        window.setTimeout(this.setDefaultValues, 100);
    }

    setDefaultValues()
    {
        if(!(document.getElementById('corebutton') === null)){
            document.getElementById('corebutton').value = "0";
            document.getElementById('corebutton').innerText = "Ask Question";
        }
        
    }

    innerText()
    {
        if(this.state.textOption === 0)
        {
            return ("Ask me something!");
        }
        else if(this.state.textOption === 1){
            return ("Hmm, let me think...");
        }
        else{
            return ("My answer is:");
        }
    }

    display()
    {
        if(this.state.displayOp === 0)
        {
            return(
                <div>
                  <div style={{left: `${this.state.pictureWidth - 70}px`, position: 'absolute', bottom: `${this.state.pictureHeight - this.state.chatposition}px`, zIndex: '1000',fontSize: `${this.state.chatsize}`}}><i style={{color: '#3fc5fc'}} class="fas fa-comment"></i></div>
                  <p className="content" style={{left: `${this.state.chatwordleft}px`, position: 'absolute', bottom: `${this.state.chatwordbottom}px`, zIndex: '1200',fontSize: '1.4rem'}}>{this.innerText()}</p>
                  </div>
            );
        }
        else{
            return(
                <div>
                  <div style={{left: `${this.state.pictureWidth - 70}px`, position: 'absolute', bottom: `${this.state.pictureHeight - this.state.chatposition}px`, zIndex: '1000',fontSize: '5rem'}}><i style={{color: '#3fc5fc'}} class="fas fa-comment"></i></div>
                  <p className="content" style={{left: `${this.state.iconcircleleft}px`, position: 'absolute', bottom: `${this.state.iconcirclebottom - 80}px`, zIndex: '1200',fontSize: '1.4rem'}}><span id="dot1" style={{fontSize: '4rem'}}>.</span><span id="dot2" style={{fontSize: '4rem'}}>.</span><span id="dot3" style={{fontSize: '4rem'}}>.</span></p>
                  </div>
            );
        }
    }

    itemOrder()
    {
        if(this.state.order === 0)
        {
            return (
                <div style={{paddingTop: '15px', paddingLeft: '15px', paddingRight: '15px'}} className="row">
                    <div style={{textAlign: 'center', margin: 'auto', height: this.state.rowHeight}} className="col-lg-7 col-md-12 d-flex justify-content-left align-items-end">
                    <img style={{width: `${this.state.pictureWidth}px`, height: `${this.state.pictureHeight}px`}} src={ProfilePicture} />
                    {this.display()}
                </div>
                    <div style={{ padding: '0 50px', verticalAlign: 'middle', margin: 'auto',textAlign: 'center',height: this.state.rowHeight}} className="col-lg-5 col-md-12 d-flex justify-content-center align-items-center">
                    {this.pickOption()}
                    </div>
                </div>
            );
        }
        else{
            return (
                <div style={{paddingTop: '150px',paddingLeft: '15px', paddingRight: '15px'}} className="row">
                   <div style={{ padding: '0 70px', verticalAlign: 'middle', margin: 'auto',textAlign: 'center'}} className="col-lg-5 col-md-12">
                    {this.pickOption()}
                    </div>
                    <div style={{paddingTop: '300px',textAlign: 'center', margin: 'auto'}} className="col-lg-7 col-md-12 d-flex justify-content-left align-items-end">
                    <img style={{width: `${this.state.pictureWidth}px`, height: `${this.state.pictureHeight}px`}} src={ProfilePicture} />
                    {this.display()}
                    </div>
             </div>
            );
        }
    }

    render(){

        return(
            <div style={{minHeight: this.state.screenHeight,height: '100%', width: '100%', backgroundColor: '#323232'}} className="container-fluid">
                <FullBar />
                {this.itemOrder()}
            </div>
        );
    }
}

export default about;