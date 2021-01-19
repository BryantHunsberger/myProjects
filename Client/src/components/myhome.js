import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Link } from "react-router-dom";
import Bootstrap from '../.././node_modules/bootstrap/dist/css/bootstrap.min.css';
import Semantic from 'semantic-ui-css/semantic.min.css';
import Computer from '../assets/myLaptop.png';
import Logo from '../assets/mylogo.png';

class myhome extends React.Component{

    constructor(props){
        super(props);
      
        this.state = {
            screenHeight : '',
            screenWidth : 0,
            rowHeight : '',
            littleScreenHeight : 0,
            littleScreenWidth : 0,
            currentUser : '',
            dot1 : '',
            dot2 : '',
            dot3 : '',
            dotActive : 'false',
            currentDot : 1, 
            barProgress : 0,
            bar : '',
            stage : 1,
            screen : '',
            myicon : '',
            stageTwoMidContent : '',
            stage2ButtonLink : '',
            stage2inputListener : '',
            passwordContent : '',
            usersname : '',
            passwordholder : '',
            currentPassword : '',
            passwordLength : 0,
            rotateNumber : 0,
            timeComplete : 'false',
            timeDistance : 0
        }

        this.changeMyDimensions = this.changeMyDimensions.bind(this);
        this.preStart = this.preStart.bind(this);
        this.doneHovering = this.doneHovering.bind(this);
        this.wordExit = this.wordExit.bind(this);
        this.wordHightlight = this.wordHightlight.bind(this);
        this.turnOnScreen = this.turnOnScreen.bind(this);
        this.getUserName = this.getUserName.bind(this);
        this.littleScreenContent = this.littleScreenContent.bind(this);
        this.dotSelect = this.dotSelect.bind(this);
        this.stageTwo = this.stageTwo.bind(this);
        this.userPressedKey = this.userPressedKey.bind(this);
        this.enterButtonColorChange = this.enterButtonColorChange.bind(this);
        this.enterButtonColorChangeBack = this.enterButtonColorChangeBack.bind(this);
        this.pressedIconLink = this.pressedIconLink.bind(this);
        this.submitName = this.submitName.bind(this);
        this.stagethree = this.stagethree.bind(this);
        this.stageFour = this.stageFour.bind(this);
        this.typePassword = this.typePassword.bind(this);
        this.stageFive = this.stageFive.bind(this);
        this.cardLinks = this.cardLinks.bind(this);
        this.rotateLogo = this.rotateLogo.bind(this);
        this.createTimeBlock = this.createTimeBlock.bind(this);
        this.pagelinkscolorchange = this.pagelinkscolorchange.bind(this);
        this.pagelinkscolorchangerevert = this.pagelinkscolorchangerevert.bind(this);
    }

    componentDidMount()
    {
        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;

        if(getScreenWidth < 775)
        {

            this.setState({screenHeight : getScreenHeight + 'px' , screenWidth : getScreenWidth, rowHeight : getScreenHeight  + 'px'});
        }
        else{
            this.setState({screenHeight : getScreenHeight  + 'px', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 30 + 'px'});
        }

        window.addEventListener('resize', this.changeMyDimensions);
        window.setTimeout(this.turnOnScreen, 1000);
    }


    changeMyDimensions()
    {
        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;
        if(!(document.getElementById('laptop') === null)){
            var theWidth = document.getElementById("laptop").getBoundingClientRect().width;
            var theLength = document.getElementById("laptop").getBoundingClientRect().height;
        }

        if(getScreenWidth < 775)
        {
            this.setState({screenHeight : getScreenHeight + 'px' , screenWidth : getScreenWidth, rowHeight : getScreenHeight + 'px',littleScreenWidth : theWidth * .78, littleScreenHeight : theLength * .87});
        }
        else{
            this.setState({screenHeight : getScreenHeight + 'px', screenWidth : getScreenWidth, rowHeight : getScreenHeight - 30 + 'px',littleScreenWidth : theWidth * .78, littleScreenHeight : theLength * .87});
        }

        if(this.state.stage === 1)
        {
            if(this.state.screen !== ''){
                this.state.screen.style.height = `${theLength * .82}px`;
                this.state.screen.style.width = `${theWidth * .78}px`;
                this.state.screen.style.paddingTop = `${(theLength * .82) / 3}px`;
            }
        }
        else if(this.state.stage === 2)
        {
            this.state.screen.style.height = `${theLength * .82}px`;
            this.state.screen.style.width = `${theWidth * .78}px`;
            this.state.screen.style.paddingTop = '10px';
        }
        else if(this.state.stage === 5)
        {
            this.state.screen.style.height = `${theLength * .82}px`;
            this.state.screen.style.width = `${theWidth * .78}px`;
            this.state.screen.style.paddingTop = '25px';
  
            if(!(document.getElementById('card1') === null) && !(document.getElementById('card2') === null) && !(document.getElementById('card3') === null)){
                document.getElementById('card1').style.maxWidth = `${this.state.littleScreenWidth - 40}px`;
                document.getElementById('card2').style.maxWidth = `${this.state.littleScreenWidth - 40}px`;
                document.getElementById('card3').style.maxWidth = `${this.state.littleScreenWidth - 40}px`;
            }
        }
        else{
            this.state.screen.style.height = `${theLength * .82}px`;
            this.state.screen.style.width = `${theWidth * .78}px`;
            this.state.screen.style.paddingTop = `${this.state.littleScreenHeight / 3}px`;
        }

    }

    preStart()
    {
        if(!(document.getElementById('startButton') === null)){
            document.getElementById("startButton").style.transform = "scale(1.2,1.2)";
        }
    }

    doneHovering()
    {
        if(!(document.getElementById('startButton') === null)){
            document.getElementById("startButton").style.transform = "none";
        }
    }

    wordHightlight({currentTarget})
    {
        document.getElementById(currentTarget.id).style.color = "white";
    }

    wordExit({currentTarget})
    {
        document.getElementById(currentTarget.id).style.color = "#3fc5fc";
    }

    getUserName()
    {
        let user = document.getElementById("username").value;
        var theLength = document.getElementById("laptop").getBoundingClientRect().height;
        this.setState({currentUser : user});
        document.getElementById("addElement").innerHTML = "";

        let welcomeMessage = document.createElement('h1');
  
        welcomeMessage.textContent = "Welcome " + user + "!";
        welcomeMessage.className = "text-center";
        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").style.paddingTop = `${(theLength * .75) / 2}px`;
            document.getElementById("addElement").appendChild(welcomeMessage);
        }

        window.setTimeout(this.littleScreenContent, 2000);
    }

    littleScreenContent()
    {
        if(!(document.getElementById('screenControl') === null)){
            document.getElementById("screenControl").style.backgroundColor = "black";
        }
        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").innerHTML = "";
        }
        
        let welcomeMessage = document.createElement('p');
  
        welcomeMessage.textContent = "Current User: " + this.state.currentUser;
      
        welcomeMessage.style.textAlign = "left";
        welcomeMessage.style.color = "#3fc5fc";

        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").style.paddingTop = '10px';
            document.getElementById("addElement").style.textAlign = 'left';
            document.getElementById("addElement").appendChild(welcomeMessage);
        }
    }

    turnOnScreen()
    {
        if (!(document.getElementById("laptop") === null))
        {
            var theWidth = document.getElementById("laptop").getBoundingClientRect().width;
            var theLength = document.getElementById("laptop").getBoundingClientRect().height;
         
            this.setState({littleScreenWidth : theWidth * .78, littleScreenHeight : theLength * .87});

            let welcomeMessage = document.createElement('h1');
            let theBreak = document.createElement('br');
            let dot1 = document.createElement('span');
            dot1.textContent = ".";
            dot1.style.color = "#3fc5fc";
            let dot2 = document.createElement('span');
            dot2.textContent = ".";
            dot2.style.color = "#3fc5fc";
            let dot3 = document.createElement('span');
            dot3.textContent = ".";
            dot3.style.color = "#3fc5fc";
            welcomeMessage.textContent = "Powering";
            welcomeMessage.style.marginLeft = "35px";
            welcomeMessage.appendChild(dot1);
            welcomeMessage.appendChild(dot2);
            welcomeMessage.appendChild(dot3);
            welcomeMessage.style.color = "#3fc5fc";
            welcomeMessage.className = "text-center computerfont";

            let name = document.createElement('div');
            name.className = "ui action input text-center";

            let myInput = document.createElement('input');
            myInput.placeholder = "Please Type Your Name ";
            myInput.type = "text";
            myInput.id = "username";

            let savButton = document.createElement("button");
            savButton.className = "ui button";
            savButton.textContent = "Enter";
            savButton.onclick = this.getUserName;
            savButton.style.backgroundColor = "#3fc5fc";
            savButton.style.color = "#a9fffd";

            let bar = document.createElement('div');
            let innerBar = document.createElement('div');
            let label = document.createElement('div');
            innerBar.className = "bar";
            label.className = "label";
            bar.className = "ui indicating progress";
            bar.style.backgroundColor = "black";
            bar.style.width = "92%";
            bar.style.paddingLeft = "25px";
            innerBar.style.backgroundColor = "#3fc5fc";
            innerBar.style.width = "1%";

            this.setState({dot1 : dot1, dot2 : dot2, dot3 : dot3, dotActive : 'true', barProgress : 1, bar : innerBar, screen : document.getElementById("addElement")});
            window.setTimeout(this.dotSelect, 100);

            innerBar.appendChild(label);
            bar.appendChild(innerBar);

            name.appendChild(myInput);
            name.appendChild(savButton);
            document.getElementById("screen").style.width = `${theWidth * .76}px`;
      
            welcomeMessage.style.paddingLeft = '0';
            if(!(document.getElementById('addElement') === null)){
                document.getElementById("addElement").appendChild(welcomeMessage);
                document.getElementById("addElement").appendChild(bar);
                //document.getElementById("addElement").appendChild(theBreak);
                //document.getElementById("addElement").appendChild(name);

                document.getElementById("addElement").style.height = `${theLength * .82}px`;
                document.getElementById("addElement").style.width = `${theWidth * .78}px`;
                document.getElementById("addElement").style.paddingTop = `${(theLength * .82) / 3}px`;
            }
            
        }


        
    }

    dotSelect()
    {
        if(this.state.barProgress >= 100)
        {
            this.state.dotActive = "false";
        }

        if(this.state.dotActive === 'true')
        {
            if(this.state.currentDot === 1)
            {
                this.state.dot2.style.color = 'black';
                this.state.dot3.style.color = 'black';
                this.state.dot1.style.color = '#3fc5fc';
                this.setState({currentDot : 2, barProgress : this.state.barProgress + 3});
                this.state.bar.style.width = this.state.barProgress + "%";
            }
            else if(this.state.currentDot === 2)
            {
                this.state.dot1.style.color = 'black';
                this.state.dot3.style.color = 'black';
                this.state.dot2.style.color = '#3fc5fc';
                this.setState({currentDot : 3, barProgress : this.state.barProgress + 5});
                this.state.bar.style.width = this.state.barProgress + "%";
            }
            else{
                this.state.dot2.style.color = 'black';
                this.state.dot1.style.color = 'black';
                this.state.dot3.style.color = '#3fc5fc';
                this.setState({currentDot : 1, barProgress : this.state.barProgress + 4});
                this.state.bar.style.width = this.state.barProgress + "%";
            }

            window.setTimeout(this.dotSelect, 150);
        }
        else{
            window.setTimeout(this.stageTwo, 50);
        }
    }

    stageTwo()
    {

        if(!(document.getElementById('screenControl') === null)){
            document.getElementById("screenControl").style.backgroundColor = "black";
        }
        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").innerHTML = "";
        }

        let welcomeMessage = document.createElement('h3');
        let askName = document.createElement('h4');

        let buttonLink = document.createElement('button');
        buttonLink.className = "btn btn-primary homeChatFont";
        buttonLink.textContent = "Enter";
     
        buttonLink.style.height = "20px";
        //buttonLink.style.width = "65px";
        buttonLink.style.backgroundColor = "#3fc5fc";
        buttonLink.style.color = "black";
        buttonLink.id = "myEnterButton";
        buttonLink.onmouseover = this.enterButtonColorChange;
        buttonLink.onmouseleave = this.enterButtonColorChangeBack;
        buttonLink.onclick = this.submitName;
 
        buttonLink.style.lineHeight = '9px';
        buttonLink.style.display = 'inline';
    
        let nameAndInput = document.createElement('div');
        let myInput = document.createElement('input');
        myInput.onkeyup = this.userPressedKey;

        this.setState({stage : 2, stageTwoMidContent : nameAndInput, stage2ButtonLink : buttonLink});
  
        welcomeMessage.textContent = "Welcome to Bryant's Command Line";
        welcomeMessage.className = "computerfont";
      
        welcomeMessage.style.textAlign = "left";
        
        myInput.placeholder = "Please Type Name Here!";
        myInput.type = "text";
        myInput.style.fontSize = '1.1rem';
        myInput.className = "computerfont";
     
     
        myInput.style.width = "205px";
        myInput.style.display = "inline";
        myInput.id = "username";
        myInput.style.backgroundColor = "black";
        myInput.style.color = "white";
        myInput.style.border = "none";

        nameAndInput.appendChild(askName);
        nameAndInput.appendChild(myInput);
        nameAndInput.appendChild(buttonLink);
   


        askName.textContent = "User$ ";
        askName.className = "computerfont";
        askName.style.width = "150px";
        askName.style.display = "inline";
        askName.style.textAlign = "left";
   
        askName.style.color = "#3fc5fc";
        welcomeMessage.style.color = "#3fc5fc";

        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").style.paddingTop = '10px';
            document.getElementById("addElement").style.textAlign = 'left';
        
            document.getElementById("addElement").appendChild(welcomeMessage);
            document.getElementById("addElement").appendChild(nameAndInput);
        }
       
    }

    enterButtonColorChange({currentTarget})
    {
        currentTarget.style.backgroundColor = 'white';
    }

    enterButtonColorChangeBack({currentTarget})
    {
        currentTarget.style.backgroundColor = '#3fc5fc';
    }
    
    pressedIconLink()
    {
        // divertion
    }

    userPressedKey(event)
    {
        if(event.keyCode === 13)
        {
            this.state.stageTwoMidContent.removeChild(this.state.stage2ButtonLink);
            if(!(document.getElementById('username') === null)){
                document.getElementById("username").onkeyup = this.pressedIconLink;
                //document.getElementById("addElement").appendChild(nameAndInput);
                document.getElementById("username").placeholder = document.getElementById("username").value;
            }

        let nameAndInput2 = document.createElement('div');
        nameAndInput2.id = "passwordInput";
        nameAndInput2.style.fontSize = '1.3rem';
            
            let askName2 = document.createElement('h4');
            askName2.className = "computerfont";
            askName2.textContent = "Password$ ";
            askName2.style.width = "150px";
            askName2.style.display = "inline";
            askName2.style.textAlign = "left";
            askName2.style.color = "#3fc5fc";
            nameAndInput2.appendChild(askName2);

            if(!(document.getElementById('addElement') === null)){
                document.getElementById("addElement").appendChild(nameAndInput2);
            }

        this.setState({passwordContent : askName2, usersname : document.getElementById("username").value});
        window.setTimeout(this.stagethree, 15);
        }  
    }

    submitName()
    {
        this.state.stageTwoMidContent.removeChild(this.state.stage2ButtonLink);
        if(!(document.getElementById('username') === null)){
            document.getElementById("username").onkeyup = this.pressedIconLink;
            //document.getElementById("addElement").appendChild(nameAndInput);
            
            document.getElementById("username").placeholder = document.getElementById("username").value;
        }

        let nameAndInput2 = document.createElement('div');
        nameAndInput2.id = "passwordInput";
        nameAndInput2.style.fontSize = '1.3rem';
            
        let askName2 = document.createElement('h4');
        askName2.className = "computerfont";
            askName2.textContent = "Password$ ";
            askName2.style.width = "150px";
            askName2.style.display = "inline";
            askName2.style.textAlign = "left";
            askName2.style.color = "#3fc5fc";
            nameAndInput2.appendChild(askName2);

            if(!(document.getElementById('addElement') === null)){
                document.getElementById("addElement").appendChild(nameAndInput2);
            }

        this.setState({passwordContent : askName2, usersname : document.getElementById("username").value});
        window.setTimeout(this.stagethree, 15);
    }

    stagethree()
    {
        let myInput2 = document.createElement('input');
        myInput2.type = "password";
     
        myInput2.style.width = "170px";
        myInput2.style.display = "inline";
        myInput2.id = "password";
        myInput2.style.backgroundColor = "black";
        myInput2.style.color = "white";
        myInput2.style.border = "none";
        //myInput2.style.readonly = 'readonly';

        if(!(document.getElementById('passwordInput') === null)){
            document.getElementById('passwordInput').appendChild(myInput2);
        }

        window.setTimeout(this.typePassword, 15);
    }

    typePassword()
    {
        if(this.state.passwordLength < 12)
        {
            
            let newPassword = "";
            var count;
            for(count = 0; count < this.state.passwordLength; count++)
            {
                newPassword += 'B';
            }

            if(!(document.getElementById('password') === null)){
                document.getElementById("password").value = newPassword;
            }
            
            this.setState({currentPassword : newPassword, passwordLength : this.state.passwordLength + 1});
            
            window.setTimeout(this.typePassword, 150);
        }
        else{
            let timeInfo = document.createElement('div');
            let timeContent = document.createElement('h4');
            timeContent.style.color = '#3fc5fc';

            let timeSpan = document.createElement('p');
            timeSpan.style.color = 'white';
            timeSpan.className = 'computerfont';
            
            timeInfo.appendChild(timeContent);
            timeInfo.append(timeSpan);
            timeContent.textContent = "Current Block$ ";
            timeContent.className = 'computerfont';
            timeContent.style.display = 'inline';
            timeSpan.style.display = 'inline';
            timeSpan.id = "timeblock";

            if(!(document.getElementById('addElement') === null)){
                document.getElementById("addElement").appendChild(timeInfo);
            }

            window.setTimeout(this.createTimeBlock, 10);
        }
    }

    createTimeBlock()
    {
        if(this.state.timeComplete === 'false')
        {
            let currentDate = new Date().getMonth() + '-' + new Date().getDay() + '-' + new Date().getFullYear() + '-' + new Date().getHours() + '-' + new Date().getMinutes() + '-' + new Date().getSeconds();
            let theDate = currentDate.substring(0, this.state.timeDistance);

            if(!(document.getElementById('timeblock') === null)){
                document.getElementById('timeblock').textContent = theDate;
            }

            if(this.state.timeDistance <= 20)
            {
                this.setState({timeDistance : this.state.timeDistance + 1});
            }
            else{
                this.setState({timeComplete : 'true'});
            }

            window.setTimeout(this.createTimeBlock, 100);
            
            
        }
        else{

            let logodiv = document.createElement('div');
            let theLogo = document.createElement('img');
            theLogo.src = Logo;
            theLogo.style.height = '80px';
            theLogo.style.width = '80px';
            theLogo.id = 'startButton2';
            logodiv.style.paddingTop = '45px';
            logodiv.style.textAlign = 'center';
            logodiv.appendChild(theLogo);
            if(!(document.getElementById('addElement') === null)){
                document.getElementById("addElement").appendChild(logodiv);
            }
            
            window.setTimeout(this.rotateLogo, 5);
        }
    }

    rotateLogo()
    {
        if(this.state.rotateNumber < 1)
        {
            if(!(document.getElementById('startButton2') === null)){
                document.getElementById('startButton2').style.transform = 'rotate(360deg)';
                document.getElementById('startButton2').style.transitionDuration = '7s';
            }
            this.setState({rotateNumber : this.state.rotateNumber + 1});
            window.setTimeout(this.rotateLogo, 2000);
        }
        else{
            window.setTimeout(this.stageFour, 10);
        }
    }

    stageFour()
    {

        this.setState({stage : 4});
        if(!(document.getElementById('screenControl') === null)){
            document.getElementById("screenControl").style.backgroundColor = "black";
        }
        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").innerHTML = "";

            document.getElementById("addElement").style.paddingTop = `${this.state.littleScreenHeight / 3}px`;
            document.getElementById("addElement").style.textAlign = 'left';
        }

        let welcomeUser = document.createElement('h2');
        welcomeUser.style.color = "#3fc5fc";

        welcomeUser.textContent = "Welcome " + this.state.usersname + "!";
      
        welcomeUser.style.textAlign = "center";


        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").appendChild(welcomeUser);
        }

        window.setTimeout(this.stageFive, 3000);
    }

    stageFive(){
        if(!(document.getElementById('screenControl') === null)){
            document.getElementById("screenControl").style.backgroundColor = "black";
        }
        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").innerHTML = "";
            document.getElementById("addElement").style.paddingTop = '40px';
        }

        this.setState({stage : 5});

        let cardHolder = document.createElement('div');

        let indCard1 = document.createElement('div');
        indCard1.id = "card1link";
        indCard1.className = "card mb-3 bg-transparent";
        indCard1.style.borderColor = "#3fc5fc";
        indCard1.onclick = this.cardLinks;
        indCard1.onmouseover = this.pagelinkscolorchange;
        indCard1.onmouseleave = this.pagelinkscolorchangerevert;
        indCard1.id = 'card1';
        indCard1.style.marginLeft = '10px';
      
        indCard1.style.color = "#3fc5fc";
        indCard1.style.maxWidth = `${this.state.littleScreenWidth - 40}px`;
        let innerCard1 = document.createElement('div');
        innerCard1.className = 'card-body';

        let innerCard1Row = document.createElement('div');
        innerCard1Row.className = 'row';

        let innerCard1Col = document.createElement('div');
        innerCard1Col.className = 'col-10';

        let innerCard1Col2 = document.createElement('div');
        innerCard1Col2.className = 'col-2';
        innerCard1Col2.style.textAlign = 'center';

        let card1icon = document.createElement('i');
        card1icon.className = "fas fa-project-diagram";
        card1icon.style.fontSize = '1.2rem';

        innerCard1Col2.appendChild(card1icon);

        let card1title = document.createElement('h4');
        card1title.className = 'card-title headers';
        card1title.style.color = "black";
        card1title.textContent = "Projects";
        card1title.style.color = '#3fc5fc';
        card1title.id = 'card1text';
        card1title.style.fontSize = '1.2rem';

        let indCard2 = document.createElement('div');
        indCard2.id = "card2link";
        indCard2.className = "card mb-3 bg-transparent";
        indCard2.style.borderColor = "#3fc5fc";
        indCard2.style.marginLeft = '10px';
        indCard2.onclick = this.cardLinks;
        indCard2.onmouseover = this.pagelinkscolorchange;
        indCard2.onmouseleave = this.pagelinkscolorchangerevert;
        indCard2.id = 'card2';
   
        indCard2.style.color = "#3fc5fc";
        indCard2.style.maxWidth = `${this.state.littleScreenWidth - 40}px`;
        let innerCard2 = document.createElement('div');
        innerCard2.className = 'card-body';

        let innerCard2Row = document.createElement('div');
        innerCard2Row.className = 'row';

        let innerCard2Col = document.createElement('div');
        innerCard2Col.className = 'col-10';

        let innerCard2Col2 = document.createElement('div');
        innerCard2Col2.className = 'col-2';
        innerCard2Col2.style.textAlign = 'center';

        let card2icon = document.createElement('i');
        card2icon.className = "fas fa-address-card";
        card2icon.style.fontSize = '1.2rem';

        innerCard2Col2.appendChild(card2icon);

        let card2title = document.createElement('h4');
        card2title.className = 'card-title headers';
        card2title.style.color = "black";
        card2title.textContent = "About Me";
        card2title.style.color = '#3fc5fc';
        card2title.id = 'card2text';
        card2title.style.fontSize = '1.2rem';

        let indCard3 = document.createElement('div');
        indCard3.id = "card3link";

        indCard3.onclick = this.cardLinks;
        indCard3.className = "card mb-3 bg-transparent";
        indCard3.style.marginLeft = '10px';
        indCard3.style.borderColor = "#3fc5fc";
        //indCard3.style.backgroundColor = "";
        indCard3.onmouseover = this.pagelinkscolorchange;
        indCard3.onmouseleave = this.pagelinkscolorchangerevert;
        indCard3.id = 'card3';
        indCard3.style.color = "#3fc5fc";
        indCard3.style.maxWidth = `${this.state.littleScreenWidth - 40}px`;
        let innerCard3 = document.createElement('div');
        innerCard3.className = 'card-body';
          
        let innerCard3Row = document.createElement('div');
        innerCard3Row.className = 'row';

        let innerCard3Col = document.createElement('div');
        innerCard3Col.className = 'col-10';

        let innerCard3Col2 = document.createElement('div');
        innerCard3Col2.className = 'col-2';
        innerCard3Col2.style.textAlign = 'center';

        let card3icon = document.createElement('i');
        card3icon.className = "fas fa-address-book";
        card3icon.style.fontSize = '1.2rem';

        innerCard3Col2.appendChild(card3icon);

        let card3title = document.createElement('h4');
        card3title.className = 'card-title headers';
        card3title.style.color = "black";
        card3title.textContent = "Contact Me";
        card3title.style.color = '#3fc5fc';
        card3title.id = 'card3text';
        card3title.style.fontSize = '1.2rem';

        innerCard1Col.appendChild(card1title);
        innerCard1Row.appendChild(innerCard1Col);
        innerCard1Row.appendChild(innerCard1Col2);
        innerCard1.appendChild(innerCard1Row);
        indCard1.appendChild(innerCard1);

        innerCard2Col.appendChild(card2title);
        innerCard2Row.appendChild(innerCard2Col);
        innerCard2Row.appendChild(innerCard2Col2);
        innerCard2.appendChild(innerCard2Row);
        indCard2.appendChild(innerCard2);

        innerCard3Col.appendChild(card3title);
        innerCard3Row.appendChild(innerCard3Col);
        innerCard3Row.appendChild(innerCard3Col2);
        innerCard3.appendChild(innerCard3Row);
        indCard3.appendChild(innerCard3);

        cardHolder.appendChild(indCard1);
        cardHolder.appendChild(indCard2);
        cardHolder.appendChild(indCard3);

        if(!(document.getElementById('addElement') === null)){
            document.getElementById("addElement").appendChild(cardHolder);
        }
    }

    cardLinks({currentTarget})
    {
        
        if(currentTarget.id === 'card1')
        {
            this.props.history.push('/projects');
        }
        else if(currentTarget.id === 'card2')
        {
            this.props.history.push('/about');
        }
        else
        {
            this.props.history.push('/contact');
        }
        
    }

    pagelinkscolorchange({currentTarget})
    {
        currentTarget.className = 'card mb-3';
        currentTarget.style.backgroundColor = '#3fc5fc';
        currentTarget.style.color = 'white';
        if(currentTarget.id === 'card3')
        {
            if(!(document.getElementById('card3text') === null)){
                document.getElementById('card3text').style.color = 'white';
            }
        }
        else if(currentTarget.id === 'card2')
        {
            if(!(document.getElementById('card2text') === null)){
                document.getElementById('card2text').style.color = 'white';
            }
        }
        else
        {
            if(!(document.getElementById('card1text') === null)){
                document.getElementById('card1text').style.color = 'white';
            }
        }
    }

    pagelinkscolorchangerevert({currentTarget})
    {
        currentTarget.style.color = '#3fc5fc';
        currentTarget.className = 'card mb-3 bg-transparent';
        if(currentTarget.id === 'card3')
        {
            if(!(document.getElementById('card3text') === null)){
                document.getElementById('card3text').style.color = '#3fc5fc';
            }
        }
        else if(currentTarget.id === 'card2')
        {
            if(!(document.getElementById('card2text') === null)){
                document.getElementById('card2text').style.color = '#3fc5fc';
            }
        }
        else
        {
            if(!(document.getElementById('card1text') === null)){
                document.getElementById('card1text').style.color = '#3fc5fc';
            }
        }
    }
    render()
    {
        return(
  
                <div style={{minHeight: this.state.screenHeight, height: '100%', width: '100%', backgroundColor: '#323232'}} className="container-fluid">
                    <div style={{padding: '15px 15px'}} className="row">
                        <div style={{textAlign: 'center', margin: 'auto', height: this.state.rowHeight}} className="col-md-6 col-sm-12 d-flex justify-content-center align-items-center">
                            <div>
                                <img id="startButton" onMouseLeave={this.doneHovering} onMouseOver={this.preStart} style={{height: '80px', width: '80px'}} src={Logo} />
                                <h1 className="text-center headers" style={{fontSize: '4rem', color: '#3fc5fc'}}><span id="one" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>H</span><span id="two" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>i</span>, <span id="three" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>I</span>'<span id="four" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>m</span> <span id="five" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>B</span><span id="six" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>r</span><span id="seven" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>y</span><span id="eight" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>a</span><span id="nine" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>n</span><span id="ten" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>t</span><span id="eleven" style={{color: '#3fc5fc'}} onMouseOver={this.wordHightlight} onMouseLeave={this.wordExit}>!</span></h1>
                                <h1 className="text-center homeChatFont" style={{color: 'white'}}>I am an Aspiring Software Engineer with a Passion for Web Development.</h1>
                            </div>
                       </div>
                        <div style={{verticalAlign: 'middle', margin: 'auto',textAlign: 'center',height: this.state.rowHeight}} className="col-md-6 col-sm-12 d-flex justify-content-center align-items-center">
                           <img id="laptop" className="img-fluid" src={Computer} />
                            <div id="screenControl" style={{borderRadius: '8px',backgroundColor: 'black', position: 'absolute', width: `${this.state.littleScreenWidth}px`, height: `${this.state.littleScreenHeight}px`, overflow: 'auto', zIndex: '800'}}> 
                                <div id="screen">
                                    <div style={{width: '100%'}} id="addElement" style={{paddingLeft: '10px', paddingTop: '15px'}}>         
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        );
    }
}

export default myhome;