import React from 'react';
import ReactDOM from 'react-dom';
import { BrowserRouter, Route, Link } from "react-router-dom";
import Bootstrap from '../.././node_modules/bootstrap/dist/css/bootstrap.min.css';
import Semantic from 'semantic-ui-css/semantic.min.css';
import Eduform from '../assets/edLogo.png';
import Eduformimage from '../assets/eduform.png';
import Spring from '../assets/spring.png';
import Postgres from '../assets/postgres.png';

// Teacher Pages
import TeacherDashAnnouncement from '../assets/makeannouncementdashboard.svg';
import TeacherCourseNavigation from '../assets/teachercoursenavigation.svg';
import TeacherCreateAnnouncement from '../assets/teachercreateannouncement.svg';
import TeacherCreateAssignment from '../assets/teachercreateassignment.svg';
import TeacherGrading from '../assets/gradeassignments.svg';

// Admin Pages
import CourseDetails from '../assets/coursedetails.svg';
import CreateCourse from '../assets/createcourse.svg';
import UserDetails from '../assets/userdetails.svg';
import VerifyUsers from '../assets/verifyusers.svg';

// Login + Register Pages
import HomePage from '../assets/homepageeduform.svg';
import Corefeatures1 from '../assets/corefeatures1.svg';
import Corefeatures2 from '../assets/corefeatures2.svg';
import LoginPage from '../assets/loginpage.svg';
import RegisterPage from '../assets/registerpage.svg';
import PasswordRecovery from '../assets/passwordrecovery.svg';
import GoogleSignin from '../assets/googlesignin.svg';

// Student Pages
import StudentAssignmentFilter3 from '../assets/assignmentfilter3.svg';
import StudentAssignmentFilter2 from '../assets/assignmentfilter2.svg';
import StudentAssignmentFilter1 from '../assets/assignmentfilter1.svg';
import StudentThemes from '../assets/studentthemes.svg';
import Studenthome2 from '../assets/studenthome2.svg';
import StudentCourses from '../assets/studentcourses.svg';
import StudentCalendar from '../assets/studentcalendar.svg';
import StudentChat from '../assets/studentchat.svg';
import StudentGradeFilter2 from '../assets/studentgradefilter2.svg';
import StudentGradeFilter1 from '../assets/studentgradefilter1.svg';
import StudentAssignments from '../assets/studentassignments.svg';
import StudentNotifications from '../assets/studentnotes.svg';
import StudentDashboardPage from '../assets/studentdash.svg';
import StudentCoursePage from '../assets/testPic.svg';
import StudentGrades from '../assets/studentgrades.svg';
import StudentSingleAssignment from '../assets/singleassignment.svg';
import DinoForm from '../assets/dinoform.svg';
import IUForm from '../assets/iuform.svg';
import BatForm from '../assets/batform.svg';
import StudentGenericCourse from '../assets/studentgenerichome.svg';

class eduform extends React.Component{

    constructor(props){
        super(props);
      
        this.state = {
            screenWidth : 0,
            maindisplay : 'inline',
            otherdisplay : 'none', 
            screenMargin : 0,
            currentButton : 'button1',
            marginForHeader : 0,
            classNameForHeader : '',
            classNameForLittleScreen : '',
            currentOption : 'studentdash',
            studentOption : 0,
            rowPadding : '60px',
            registerOption : 0,
            adminOption : 0,
            screenHt : 0,
            headerfontsize : '',
            linkfontsize : '',
            teacherOption : 0,
            studentContentOptions : ['The Student Dashboard allows students to view assignments due in the next 2 weeks. Students can also view announcements posted by instructors within the last 2 weeks.','The Student Dashboard allows students to view assignments due in the next 2 weeks. Students can also view announcements posted by instructors within the last 2 weeks.',
            'The Student Courses Page displays all courses that the current student has enrolled in. Each listing will take the student to the main course page for that course when selected',
            'The Student Chat Page permits students and instructors in the same course to communicate. The Chat feature will also notify the instructor and students which users were recently active.',
            'The Course Announcements Page lists every announcement posted by the instructor from commencement of the current term.',
            'The student can query all the announcements for a specific keyword, here the student searches for instances of assignments.',
            "The Course Assignments Page lists all the upcoming and past assignments posted by the instructor. The student can select an assignment to view the assignment's details.",
            "With Eduform's powerful search techniques, the student can query assignments based on date, max points, or keywords.",
            'In this snapshot, the user is searching for instances of the max points attribute.',
            'The student can choose to filter the assignments based on assignment type, as demonstrated in the current image.',
            'The Student Grades Page gives the student the ability to preview their current class grade. Scores that have not yet been graded will be exempt from the total calculation.'
            ,'Students have the capability to filter grade selections by category, the selected category will give a grade calculated by only those assignments of the same category.'
            ,'In this selection, we can preview the total grade for quizzes only, as filtered by the student.',
            'The Custom Themes Page is an exciting feature which allows the current user to alter the current interface of the application. Choosing a theme card will transform Eduform into the corresponding theme image until the user selects Eduform as the default theme again.',
            'Batform is a custom theme which is inspired by the one and only batman. It gives the user a superhero feel and the extra motivation to view and complete their classwork!',
            'IUform is a custom theme created in honor of Indiana University, this theme gives the user an extra sense of pride while navigating Eduform',
            'Dinoform is a custom theme catered to those students who love prehistoric times and would like to extend the historic feel to Eduform.',
            'The Student Calendar is a product of a self-created algorithm which updates everyday and allows the student to view upcoming assignments and information.',
            'The Assignment Page corresponds to a singular assignment or quiz, any instructor posted information for the given assignment will be displayed and available for the student to download, complete, and upload.'],
            studentHeaderOptions : ['Student Dashboard','Student Dashboard','Student Courses','Student Chat','Course Announcements','Course Announcements',
            'Course Assignments','Course Assignments','Course Assignments','Course Assignments','Student Grades',
            'Student Grades','Student Grades','Custom Themes','Custom Themes','Custom Themes','Custom Themes','Student Calendar','Assignment Page'],
            teacherContentOptions : ['The Teacher Dashboard consists of assignments the instructor has created and due in the next 2 weeks. The Teacher Dashboard also contains announcements created by the instructor within the last 2 weeks. ',
            'The instructor has the ability to create announcements specific to the current course page or for any instructor taught course on the dashboard.',
            'Within a selected course page, the instructor can create an assignment for all enrolled students to view and download.',
            'The Grade Assignments feature displays all students enrolled in a course and their corresponding grades for each assignment. The instructor can view student submissions and grade the assignment.',
            'The Course Navigation component redirects the instructor to pages that consists of: All Course Announcements, All Course Assignments, Grading Assignments, and the Chat Feature.'],
            teacherHeaderOptions : ['Teacher Dashboard','Make Announcements','Create Assignments','Grade Assignments','Course Navigation'],
            adminContentOptions : ['The Verify Users Page shows all users who recently registered for Eduform. The Administrator has the power to authenticate a user or to deny the registration request.',
            'The Add Courses Page gives the Administrator permission to create a new course and register it within the system. Respective instructors are assigned by the administrator to teach the new courses.',
            'The Administrator oversees all users registered within the Eduform system, the Administrator can filter users according to teaching or student status.',
            'All courses created and registered by the Administrator are located in the Course Details Page. The Administrator can access all details related to a particular course.'],
            adminHeaderOptions : ['Verify Users','Add Courses','User Details','Course Details'],
            registerHeaderOptions : ['Home Page','Home Page','Home Page','Login','Registration','Google Sign In','Password Recovery'],
            registerContentOptions : ['The Home Page is the official welcome for new visitors, Eduform is a Learning Management System developed in response to Covid-19 that emphasizes virtual education.',"The Core Features component emphasizes Eduform's user interface and personal dashboards. The dashboards comprise of the Administrator, Teacher, and Student Components.",
            "The Search Feature is present in many of Eduform's central components, the search functionality is essential for grouping elements in accordance to type.",
            'The Login Page is the portal for the user to access their profile and dashboard. The user must enter the correct username and password for Eduform to permit access to its content.',
            'For new members, users must fill out the Registration form and select a user type. The new member must wait until the Administrator approves or denies the request.',
            'Google Sign In allows members to seamlessly login to their profiles by using an existing google account.',
            "Eduform members can use the Password Reset Page to recover their account. An access code is sent to the user's email, the user must click the link and follow the instructions to reset their password."]
        }

        this.changeMyDimensions = this.changeMyDimensions.bind(this);
        this.buttoncolorchange = this.buttoncolorchange.bind(this);
        this.buttoncolorchangeback = this.buttoncolorchangeback.bind(this);
        this.mouseoverbutton = this.mouseoverbutton.bind(this);
        this.doneHovering = this.doneHovering.bind(this);
        this.chooseItem = this.chooseItem.bind(this);
        this.getCurrentImage = this.getCurrentImage.bind(this);

        this.getContentInfo = this.getContentInfo.bind(this);
        this.getHeaderInfo = this.getHeaderInfo.bind(this);
        this.menu = this.menu.bind(this);

        this.menu2 = this.menu2.bind(this);
        this.studentOptions = this.studentOptions.bind(this);
        this.teacherOptions = this.teacherOptions.bind(this);
        this.adminOptions = this.adminOptions.bind(this);
        this.registerOptions = this.registerOptions.bind(this);
        this.studentAlt = this.studentAlt.bind(this);
        this.registerAlt = this.registerAlt.bind(this);
        this.adminAlt = this.adminAlt.bind(this);
        this.teacherAlt = this.teacherAlt.bind(this);
        this.faqOptions = this.faqOptions.bind(this);
    }

    componentDidMount()
    {
        setInterval(this.studentAlt, 4000);
        setInterval(this.registerAlt, 4000);
        setInterval(this.adminAlt, 4000);
        setInterval(this.teacherAlt, 4000);

        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;

        if(getScreenWidth < 900 && getScreenWidth > 650)
        {
            this.setState({headerfontsize : '3rem', linkfontsize : '1.1rem', screenHt : getScreenHeight, screenMargin : 70,screenWidth : getScreenWidth, marginForHeader : getScreenWidth * .09, classNameForLittleScreen : 'sixteen wide stretched column', classNameForHeader : 'sixteen wide stretched column'});
        }
        else if(getScreenWidth <= 650)
        {
            this.setState({headerfontsize : '2.5rem', linkfontsize : '.6rem',screenHt : getScreenHeight,screenMargin : 70,screenWidth : getScreenWidth, marginForHeader : getScreenWidth * .06, classNameForLittleScreen : 'sixteen wide stretched column', classNameForHeader : 'sixteen wide stretched column'});
        }
        else{
            this.setState({headerfontsize : '3rem', linkfontsize : '1.1rem',screenHt : getScreenHeight,screenMargin : 0, screenWidth : getScreenWidth, marginForHeader : 5, classNameForLittleScreen : 'twelve wide stretched column', classNameForHeader : 'four wide stretched column'});
        }
  
        window.addEventListener('resize', this.changeMyDimensions);

    }


    changeMyDimensions()
    {
        
        var getScreenWidth = window.innerWidth;
        var getScreenHeight = window.innerHeight;

        if(getScreenWidth < 900 && getScreenWidth > 650)
        {
            this.setState({headerfontsize : '3rem', linkfontsize : '1.1rem', screenHt : getScreenHeight, screenMargin : 70,screenWidth : getScreenWidth, marginForHeader : getScreenWidth * .09, classNameForLittleScreen : 'sixteen wide stretched column', classNameForHeader : 'sixteen wide stretched column'});
        }
        else if(getScreenWidth <= 650)
        {
            this.setState({headerfontsize : '2.5rem', linkfontsize : '.6rem',screenHt : getScreenHeight,screenMargin : 70,screenWidth : getScreenWidth, marginForHeader : getScreenWidth * .06, classNameForLittleScreen : 'sixteen wide stretched column', classNameForHeader : 'sixteen wide stretched column'});
        }
        else{
            this.setState({headerfontsize : '3rem', linkfontsize : '1.1rem',screenHt : getScreenHeight,screenMargin : 0, screenWidth : getScreenWidth, marginForHeader : 5, classNameForLittleScreen : 'twelve wide stretched column', classNameForHeader : 'four wide stretched column'});
        }

    }

    buttoncolorchange()
    {
        if(!(document.getElementById('myicon') === null)){
            document.getElementById('myicon').style.color = 'white';
        }
    }

    buttoncolorchangeback()
    {
        if(!(document.getElementById('myicon') === null)){
            document.getElementById('myicon').style.color = '#3fc5fc';
        }
    }

    mouseoverbutton({currentTarget})
    {
        currentTarget.style.transform = "scale(1.05,1.05)";
    }

    doneHovering({currentTarget})
    {
        currentTarget.style.transform = "none";
    }

    chooseItem({currentTarget})
    {
        if(currentTarget.id === 'button1'){
            document.getElementById(this.state.currentButton).className = 'item homeChatFont';
            document.getElementById(this.state.currentButton).style.color = 'black';
            document.getElementById(this.state.currentButton).style.backgroundColor = '#3fc5fc';

            document.getElementById('button1').className = 'item active homeChatFont';
            document.getElementById('button1').style.color = '#3fc5fc';
            document.getElementById('button1').style.backgroundColor = 'white';
 
            this.setState({currentButton : 'button1', currentOption : 'studentdash', maindisplay : 'inline', otherdisplay : 'none', rowPadding : '60px'});
        }
        else if(currentTarget.id === 'button2'){
            document.getElementById(this.state.currentButton).className = 'item homeChatFont';
            document.getElementById(this.state.currentButton).style.color = 'black';
            document.getElementById(this.state.currentButton).style.backgroundColor = '#3fc5fc';

            document.getElementById('button2').className = 'item active homeChatFont';
            document.getElementById('button2').style.color = '#3fc5fc';
            document.getElementById('button2').style.backgroundColor = 'white';
 
            this.setState({currentButton : 'button2', currentOption : 'teacherdash', maindisplay : 'inline', otherdisplay : 'none', rowPadding : '60px'});
        }
        else if(currentTarget.id === 'button3'){
            document.getElementById(this.state.currentButton).className = 'item homeChatFont';
            document.getElementById(this.state.currentButton).style.color = 'black';
            document.getElementById(this.state.currentButton).style.backgroundColor = '#3fc5fc';

            document.getElementById('button3').className = 'item active homeChatFont';
            document.getElementById('button3').style.color = '#3fc5fc';
            document.getElementById('button3').style.backgroundColor = 'white';
  
            this.setState({currentButton : 'button3', currentOption : 'admindash', maindisplay : 'inline', otherdisplay : 'none', rowPadding : '60px'});
        }
        else if(currentTarget.id === 'button4'){
            document.getElementById(this.state.currentButton).className = 'item homeChatFont';
            document.getElementById(this.state.currentButton).style.color = 'black';
            document.getElementById(this.state.currentButton).style.backgroundColor = '#3fc5fc';

            document.getElementById('button4').className = 'item active homeChatFont';
            document.getElementById('button4').style.color = '#3fc5fc';
            document.getElementById('button4').style.backgroundColor = 'white';
 
            this.setState({currentButton : 'button4', currentOption : 'registerdash', maindisplay : 'inline', otherdisplay : 'none', rowPadding : '60px'});
        }
        else
        {
            document.getElementById(this.state.currentButton).className = 'item homeChatFont';
            document.getElementById(this.state.currentButton).style.color = 'black';
            document.getElementById(this.state.currentButton).style.backgroundColor = '#3fc5fc';

            document.getElementById('button5').className = 'item active homeChatFont';
            document.getElementById('button5').style.color = '#3fc5fc';
            document.getElementById('button5').style.backgroundColor = 'white';
 
            this.setState({currentButton : 'button5', currentOption : 'faqdash', maindisplay : 'none', otherdisplay : 'inline', rowPadding : '47px'});
        }
       
    }

    studentAlt()
    {
        if(this.state.studentOption === 18)
        {
            this.setState({studentOption : 0});
        }
        else{
            this.setState({studentOption : this.state.studentOption + 1});
        }
    }

    adminAlt()
    {
        if(this.state.adminOption === 3)
        {
            this.setState({adminOption : 0});
        }
        else{
            this.setState({adminOption : this.state.adminOption + 1});
        }
    }

    registerAlt()
    {
        if(this.state.registerOption === 6)
        {
            this.setState({registerOption : 0});
        }
        else{
            this.setState({registerOption : this.state.registerOption + 1});
        }
    }

    teacherAlt()
    {
        if(this.state.teacherOption === 4)
        {
            this.setState({teacherOption : 0});
        }
        else{
            this.setState({teacherOption : this.state.teacherOption + 1});
        } 
    }

    getCurrentImage()
    {
        if(this.state.currentOption === 'studentdash')
        {
            return this.studentOptions();
        }
        else if(this.state.currentOption === 'teacherdash')
        {
            return this.teacherOptions();
        }
        else if(this.state.currentOption === 'admindash')
        {
            return this.adminOptions();
        }
        else if(this.state.currentOption === 'registerdash'){
            return this.registerOptions();
        }
        else{
            return this.faqOptions();
        }
    }
    faqOptions()
    {
        return '';
    }

    studentOptions()
    {
        if(this.state.studentOption === 0)
        {
            return StudentDashboardPage;
        }
        else if(this.state.studentOption === 1)
        {
            return Studenthome2;
        }
        else if(this.state.studentOption === 2)
        {
            return StudentCourses;
        }
        else if(this.state.studentOption === 3)
        {
            return StudentChat;
        }
        else if(this.state.studentOption === 4)
        {
            return StudentNotifications;
        }
        else if(this.state.studentOption === 5)
        {
            return StudentCoursePage;
        }
        else if(this.state.studentOption === 6)
        {
            return StudentAssignments;
        }
        else if(this.state.studentOption === 7)
        {
            return StudentAssignmentFilter1;
        }
        else if(this.state.studentOption === 8)
        {
            return StudentAssignmentFilter2;
        }
        else if(this.state.studentOption === 9)
        {
            return StudentAssignmentFilter3;
        }
        else if(this.state.studentOption === 10){
            return StudentGrades;
        }
        else if(this.state.studentOption === 11){
            return StudentGradeFilter1;
        }
        else if(this.state.studentOption === 12){
            return StudentGradeFilter2;
        }
        else if(this.state.studentOption === 13)
        {
            return StudentThemes;
        }
        else if(this.state.studentOption === 14)
        {
            return BatForm;
        }
        else if(this.state.studentOption === 15)
        {
            return IUForm;
        }
        else if(this.state.studentOption === 16)
        {
            return DinoForm;
        }
        else if(this.state.studentOption === 17){
            return StudentCalendar;
        }
        else {
            return StudentSingleAssignment;
        }

    }

    getContentInfo()
    {

        if(this.state.currentOption === 'studentdash')
        {
            return this.state.studentContentOptions[this.state.studentOption];
        }
        else if(this.state.currentOption === 'teacherdash')
        {
            return this.state.teacherContentOptions[this.state.teacherOption];
        }
        else if(this.state.currentOption === 'admindash')
        {
            return this.state.adminContentOptions[this.state.adminOption];
        }
        else if(this.state.currentOption === 'registerdash'){
            return this.state.registerContentOptions[this.state.registerOption];
        }
        else
        {
            return '';
        }

    }

    getHeaderInfo()
    {
        if(this.state.currentOption === 'studentdash')
        {
            return this.state.studentHeaderOptions[this.state.studentOption];
        }
        else if(this.state.currentOption === 'teacherdash')
        {
            return this.state.teacherHeaderOptions[this.state.teacherOption];
        }
        else if(this.state.currentOption === 'admindash')
        {
            return this.state.adminHeaderOptions[this.state.adminOption];
        }
        else if(this.state.currentOption === 'registerdash'){
            return this.state.registerHeaderOptions[this.state.registerOption];
        }
        else
        {
            return '';
        }
    }

    teacherOptions()
    {
        if(this.state.teacherOption === 0)
        {
            return TeacherDashAnnouncement;
        }
        else if(this.state.teacherOption === 1)
        {
            return TeacherCreateAnnouncement;
        }
        else if(this.state.teacherOption === 2)
        {
            return TeacherCreateAssignment;
        }
        else if(this.state.teacherOption === 3){
            return TeacherGrading;
        }
        else
        {
            return TeacherCourseNavigation;
        }
    }

    adminOptions()
    {
        if(this.state.adminOption === 0)
        {
            return VerifyUsers;
        }
        else if(this.state.adminOption === 1)
        {
            return CreateCourse;
        }
        else if(this.state.adminOption === 2)
        {
            return UserDetails;
        }
        else
        {
            return CourseDetails;
        }
    }

    registerOptions()
    {
        if(this.state.registerOption === 0)
        {
            return HomePage;
        }
        else if(this.state.registerOption === 1)
        {
            return Corefeatures1;
        }
        else if(this.state.registerOption === 2){
            return Corefeatures2;
        }
        else if(this.state.registerOption === 3){
            return LoginPage;
        }
        else if(this.state.registerOption === 4){
            return RegisterPage;
        }
        else if(this.state.registerOption === 5){
            return GoogleSignin;
        }
        else
        {
            return PasswordRecovery;
        }
    }

    menu(){
        return(
        <div class="ui five item pointing menu">
            <a id="button1" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{ backgroundColor: 'white', color: '#3fc5fc', fontSize: `${this.state.linkfontsize}`}} class="item active homeChatFont"><b>Student View</b></a>
            <a id="button2" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>Teacher View</b></a>
            <a id="button3" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>Admin View</b></a>
             <a id="button4" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>Register / Login</b></a>
            <a id="button5" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>FAQ</b></a>
       </div>
        );
    }

    menu2()
    {
        return(
            <div class="ui five item pointing menu">
                <a id="button1" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{ backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>Student View</b></a>
                <a id="button2" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>Teacher View</b></a>
                <a id="button3" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>Admin View</b></a>
                 <a id="button4" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: '#3fc5fc', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item homeChatFont"><b>Register / Login</b></a>
                <a id="button5" onClick={this.chooseItem} onMouseLeave={this.doneHovering} onMouseOver={this.mouseoverbutton} style={{backgroundColor: 'white', color: 'black', fontSize: `${this.state.linkfontsize}`}} class="item active homeChatFont"><b>FAQ</b></a>
           </div>
            );
    }

    render()
    {
        return(
            <div style={{minHeight: `${this.state.screenHt + 185}px`, height: '100%', width: '100%', backgroundColor: '#323232'}} className="container-fluid">
                    <div style={{padding: '35px 5px', paddingBottom: `${this.state.rowPadding}`}} className="row">
                        <div style={{textAlign: 'left', margin: 'auto', height: '100%'}} className="col-12 d-flex justify-content-left align-items-center">
                            <Link onMouseOver={this.buttoncolorchange} onMouseLeave={this.buttoncolorchangeback} to="/projects"> <i style={{marginLeft: '5px', display: 'inline', fontSize: '3.5rem', color: '#3fc5fc'}} id="myicon" class="far fa-arrow-alt-circle-left d-flex align-items-bottom"></i></Link>
                            <img class="ui medium rounded image" style={{marginLeft: '20px',height: '70px', width: '70px'}} src={Eduform}/>             
                            <h1 className="headers" style={{paddingLeft: '10px', display: 'inline', fontSize: `${this.state.headerfontsize}`, color: '#3fc5fc'}}>Eduform</h1>
                        </div>
  
                    </div>
                    <div style={{padding: '20px 65px', paddingBottom: '60px'}} className="row">
                       <div style={{display: `${this.state.maindisplay}`}} class="col-12 ui grid">
                            {this.menu()}
                            <div id="littlescreen" style={{height: `${this.state.screenWidth*.30}px`, width: '100%'}} class={`${this.state.classNameForLittleScreen}`}>
                                <div style={{padding: '2px 2px', backgroundColor: 'white'}} class="ui segment">
                                <img style={{ height: '100%', width: '100%', borderRadius: '5px'}} src={this.getCurrentImage()} />
                                </div>
                            </div>
                            <div id="headerinfo" style={{ marginTop: `${this.state.marginForHeader}px`, height: `${this.state.screenWidth*.32}px`, width: '100%'}} class={`${this.state.classNameForHeader}`}>
                                <h2 className="headers" style={{textAlign: 'center', color: '#3fc5fc'}}>{this.getHeaderInfo()}
                                <p className="content" style={{paddingTop: '15px', fontSize: '1.2rem', textAlign: 'left', color: 'white'}}>{this.getContentInfo()}</p></h2>
                                
                            </div>
                             
                          
                        </div>


                        <div style={{ paddingTop: '0',marginTop: '0', display: `${this.state.otherdisplay}`}} className="col-12 ui grid">
                            {this.menu2()}
                            <div id="faqscreen"  className="sixteen wide stretched column ">
                                <h1 className="headers" style={{color: 'white'}}>About Eduform</h1>
                                    <p className="content" style={{paddingLeft: '25px',color: '#3fc5fc', fontSize: '1.2rem'}}>    Eduform is a Learning Management System focused on providing a
                                        virtual classroom that emphasizes creation, sharing, and
                                        communication.<br/>    In a small team, researched and produced five core features to
                                        simplify remote education. These features consisted of filtered
                                        search, class-based chatrooms, elegantly designed dashboards for
                                        teachers, students, and administrators, themes, and security.<br/>    Led the software development team in front-end development and
                                        integration.</p>
                                <h1 className="headers" style={{color: 'white'}}>Tech Stack</h1>
                                <div className="row">

                                    <div style={{marginBottom: '15px'}} className="col-md-2 col-sm-6 d-flex justify-content-center">
                                         <i style={{color: '#3fc5fc', fontSize: '5.5rem'}} class="fab fa-aws"></i><br/>

                                    </div> 
                                    <div style={{marginBottom: '18px'}} className="col-md-2 col-sm-6 d-flex justify-content-center">
                                        <i style={{fontSize: '5.5rem', color: '#3fc5fc'}} class="fab fa-java"></i><br/>
                                  
                                    </div>
                                    <div style={{marginBottom: '18px'}} className="col-md-2 col-sm-6 d-flex justify-content-center">
                                        <i style={{fontSize: '5.5rem', color: '#3fc5fc'}} class="fab fa-react"></i><br/>
                                   
                                    </div>
                                    <div style={{marginBottom: '18px'}} className="col-md-2 col-sm-6 d-flex justify-content-center">
                                        <img style={{height: '75px', width: '75px', borderRadius: '15px'}} src={Spring} /><br/>
                                        
                                    </div>
                                    <div style={{marginBottom: '18px'}} className="col-md-2 col-sm-6 d-flex justify-content-center">
                                        <i style={{fontSize: '5.5rem', color: '#3fc5fc'}} class="fab fa-css3-alt"></i><br/>
                                      
                                    </div>
                                    <div style={{marginBottom: '18px'}} className="col-md-2 col-sm-6 d-flex justify-content-center">
                                    <img style={{height: '80px', width: '70px', borderRadius: '15px'}} src={Postgres} /><br/>
                                      
                                    </div>

                                </div>
                                <h1 className="headers" style={{color: 'white'}}>Duration</h1>
                                <p className="content" style={{paddingLeft: '25px',color: '#3fc5fc', fontSize: '1.2rem'}}>
                                    Eduform was an end-to-end development process spanning nearly 100 days in duration.
                                </p>
                            </div>
                        </div>      
        
                    </div>
            </div>
        );
    }
}

export default eduform;