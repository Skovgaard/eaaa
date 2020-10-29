const express = require('express');
const app = express();
const config = require('./config');
require('hbs');

app.set('view engine', 'hbs');
app.set('views', __dirname + '/templates');

app.use(express.json());
app.use(express.static(__dirname + '/public'));
app.use(require('express-session')(require('./mongodb-session')));
app.use(require('cors')());
app.use('/chat', require('./routes/chat.js'));

app.post('/login', login);

app.get('/logout', logout);

const port = process.env.PORT || config.localPort; // Heroku

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
});

//

async function login(req, res) {
    const { navn, password } = req.body;
    if (password === '111' && navn) {
        req.session.navn = navn;
        res.status(201).send(['login ok!']);
    } else {
        res.sendStatus(401);
    }
}

function logout(req, res) {
    req.session.destroy((err) => {
        if (err) {
            console.log(err);
        } else {
            res.redirect('/');
        }
    });
}

//

module.exports = app; // test