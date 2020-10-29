// Modificer løsningen til Opgave 14.3, så kun brugere med et bestemt password kan logge ind på chatserveren.
// FEJL: TJekker ikke for session på alle endpoints - kan løses ved routing (se evt. næste uges opg)

// MONGODB / MONGOOSE
const mongoose = require('mongoose');

const url = 'mongodb://localhost/chatDB';

mongoose.connect(url,
    { useNewUrlParser: true, useUnifiedTopology: true });

const chatBeskedSchema = new mongoose.Schema({
    navn: String,
    rum: String,
    tekst: String,
    nr: Number
});

const ChatBesked = mongoose.model('ChatBesked', chatBeskedSchema);

// Creates 3 dummy messages if db is empty
async function populateDatabase() {
    try {
        if (await isDBEmpty()) {
            await ChatBesked.create({
                navn: 'navn1',
                rum: 'rum1',
                tekst: 'tekst1',
                nr: 0
            });
            await ChatBesked.create({
                navn: 'navn2',
                rum: 'rum1',
                tekst: 'tekst2',
                nr: 1
            });
            await ChatBesked.create({
                navn: 'navn3',
                rum: 'rum2',
                tekst: 'tekst3',
                nr: 2
            });
        }
    } catch (error) {
        console.log(error);
    }
}

// Populate DB (if empty)
populateDatabase();

// Try to find any element in db, if null - db is empty and return true
async function isDBEmpty() {
    return await (ChatBesked.findOne().exec()) == null;
}

async function getChatMessages() {
    return await ChatBesked.find().select('-_id -__v').exec();
}

async function getChatMessagesInRoom(room) {
    return await ChatBesked.find().select('-_id -__v').where('rum').eq(room).exec();
}
async function getRooms() {
    return await ChatBesked.find().select('rum -_id').distinct('rum').exec();
}

// Gets message with highest nr and adds 1 or return 0 if db is empty
async function getNextChatMessageNumber() {
    return (await isDBEmpty()) ? 0 : (await ChatBesked.findOne().sort('-nr').exec()).nr + 1;
}

// EXPRESS
const express = require('express');
const app = express();
const cors = require('cors');

const port = 8080;

app.use(cors());
app.use(express.json());
app.use(express.static(__dirname + '/filer'));

app.get('/beskeder', async (req, res) => {
    res.send(await getChatMessages());
});

app.get('/beskeder/:rum', async (req, res) => {
    const rum = req.params.rum;
    res.send(await getChatMessagesInRoom(rum));
});

app.get('/rum', async (req, res) => {
    res.send(await getRooms());
});

app.post('/besked', async (req, res) => {
    const body = req.body;

    await ChatBesked.create({
        navn: body.navn,
        rum: body.rum,
        tekst: body.tekst,
        nr: await getNextChatMessageNumber()
    });
    res.status(201).send(req.body);
});

app.delete('/besked/:nr', async (req, res) => {
    const nr = parseInt(req.params.nr);
    const deleteInfo = await ChatBesked.deleteOne().where('nr').equals(nr).exec();
    if (deleteInfo.deletedCount == 1)
        res.status(200).send({ resultat: 'Besked slettet!' });
    else
        res.status(404).send();
});

// EXPRESS-SESSION & HBS & CONNECT-MONGODB-SESSION
// Opgave 15.3 fra app.js
const session = require('express-session');
const hbs = require('hbs');
const MongoDBStore = require('connect-mongodb-session')(session);

app.set('view engine', 'hbs');
app.set('views', __dirname + '/templates');

const store = new MongoDBStore({
    uri: url, // MongoDB connection
    collection: 'mySessions' // MongoDB collection
});

// Catch errors
store.on('error', function (error) {
    console.log(error);
});

app.use(session({
    secret: 'hemmelig',
    cookie: {
        maxAge: 1000 * 60 * 10 // 1000 ms * 60 = 10 min * 10 = 10 minutes
    },
    store,
    resave: true,
    saveUninitialized: true
}));

app.post('/login', async (req, res) => {
    const { navn, password } = req.body;
    if (password === '111' && navn) {
        req.session.navn = navn;
        res.status(201).send(['login ok!']);
    } else {
        res.sendStatus(401);
    }
});

app.get('/session', async (req, res) => {
    const navn = req.session.navn;
    if (navn) {
        res.render('velkommen.hbs', { navn });
    } else {
        res.redirect('/ingenAdgang.html');
    }
});

app.get('/logout', (req, res) => {
    req.session.destroy((err) => {
        if (err) {
            console.log(err);
        } else {
            res.redirect('/');
        }
    });
});

// 

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
});