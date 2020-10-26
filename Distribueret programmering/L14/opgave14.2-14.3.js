// Opgave 14.2
// Modificer løsningen til Opgave 13.3, så chatserveren nu gemmer beskederne i en lokal database med Mongoose.
// Opgave 14.3
// Udvid løsningen til Opgave 14.2 ved at tilføje et GET endpoint /, der returnerer .html filen for chatklienten fra Opgave 12.2.

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
    if (!await getDBLength()) { // if falsy (= 0)
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
}

// Bruge findFirst istedet for mere effiktiv?
async function getDBLength() {
    return (await (ChatBesked.find().exec())).length;
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

// Gets message with highest nr and adds 1 if db is not empty
async function getNextChatMessageNumber() {
    if (! await getDBLength()) // if falsy (= 0)
        return 0;
    else
        return (await ChatBesked.findOne().sort('-nr').exec()).nr + 1;
}

async function main() {
    try {
        await populateDatabase();
    } catch (error) {
        console.log(error);
    }
}

main();


// Opgave 13.3 med ændringer
const express = require('express');
const app = express();
const cors = require('cors');

const port = 8080;

app.use(cors());
app.use(express.json());

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

// Opgave 14.3
app.use(express.static(__dirname + '/opgave12.2 - Kasper')); // To automaticly load css and js

// Kan bruge index.html
app.get('/', async (req, res) => {
    res.sendFile(__dirname + '/opgave12.2 - Kasper/opgave12.2.html');
});
//

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
});