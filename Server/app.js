var createError = require('http-errors');
var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var logger = require('morgan');
const nodemailer = require('nodemailer');
const cors = require("cors");

var bodyparser = require('body-parser');

var indexRouter = require('./routes/index');
var usersRouter = require('./routes/users');

var app = express();

// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'jade');

app.use(logger('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));
app.use(express.static(path.join(__dirname, 'build')));


app.get('/*', (req, res) => {
  res.sendFile(path.join(__dirname, 'build', 'index.html'));
});

app.use('/', indexRouter);
app.use('/users', usersRouter);

// catch 404 and forward to error handler
app.use(function(req, res, next) {
  next(createError(404));
});

// error handler
app.use(function(err, req, res, next) {
  // set locals, only providing error in development
  res.locals.message = err.message;
  res.locals.error = req.app.get('env') === 'development' ? err : {};

  // render the error page
  res.status(err.status || 500);
  res.render('error');
});

module.exports = app;



//////////////////////////



  

app.use(cors());
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended : true}));

let usersemail;
let usersname;
let userstext;
let usersheader;
let usersnumber;

app.post("/", (req, res) => {
    userstext = req.body.text;
    usersemail = req.body.email;
    usersname = req.body.name;
    usersheader = req.body.header;
    usersnumber = req.body.number;

    let concattext = "Name: " + usersname + "\nEmail: " + usersemail + "\nNumber: " + usersnumber + "\nMessage: " + userstext;

    const transporter = nodemailer.createTransport({
        service : 'gmail',
        auth: {
            user : "bryantportfolioemail@gmail.com",
            pass : 'fuppyp-qoxwin-7vorMo'
        }
    });

    const options = {
        from: "bryantportfolioemail@gmail.com",
        to: 'Bryant.Hunsberger@gmail.com',
        subject: usersheader,
        text : concattext
    };

    transporter.sendMail(options, function(err, info)
    {
        if(err)
        {
            console.log(err);
            return;
        }
        console.log("sent: " + info.response);
    });
});



