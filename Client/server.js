const nodemailer = require('nodemailer');

var bodyparser = require('body-parser');

const express = require("express"),
  app = express(),
  port = process.env.PORT || 5000,
  cors = require("cors");

  

app.use(cors());
app.use(bodyparser.json());
app.use(bodyparser.urlencoded({extended : true}));

app.listen(port, () => console.log("Backend server live on " + port));

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


