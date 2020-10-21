// Lav en Express chatserver svarende til beskrivelsen i Opgave12.2: Der er følgende GET endpoints:
//  • beskeder – alle chatbeskeder
//  • beskeder/:rum – alle chatbeskeder i et givet chatrum
//  • rum – alle anvendte chatrum
// Der er et POST endpoint:
//  • besked – opretter en ny chatbesked
// Et POST request skal have følgende properties:
//  • navn – navn på afsender
//  • rum – navn på det chatrum, hvor beskeden skal vises
//  • tekst – chatbesked
// Der er også et DELETE endpoint:
//  • besked/:nr – sletter chatbeskeden med det givne nr
// Chatserveren skal gemme beskederne i et array.
// En ny beskeder skal gives et nr, der er én større end det hidtil største nr.
// Afprøv chatserveren med chatklienten fra Opgave 12.2

const express = require('express');
const app = express();
const cors = require('cors');

const port = 8080;

const chatBeskeder = [
    { navn: 'navn1', rum: 'rum1', tekst: 'tekst1', nr: 0 },
    { navn: 'navn2', rum: 'rum1', tekst: 'tekst2', nr: 1 },
    { navn: 'navn3', rum: 'rum2', tekst: 'tekst3', nr: 2 }];

let beskedNr = chatBeskeder.length; // Næste besked nr

app.use(cors());
app.use(express.json());

app.get('/beskeder', (req, res) => {
    res.send(chatBeskeder);
});

app.get('/beskeder/:rum', (req, res) => {
    const rum = req.params.rum;
    const rumChatBeskeder = chatBeskeder.filter(besked => besked.rum === rum);
    res.send(rumChatBeskeder);
});

app.get('/rum', (req, res) => {
    const chatrum = chatBeskeder.map(besked => besked.rum);
    const chatrumNoDuplicates = chatrum.filter((item, index) => chatrum.indexOf(item) === index);
    res.send(chatrumNoDuplicates);
});

app.post('/besked', (req, res) => {
    const body = req.body;

    const beskedObj = {
        navn: body.navn,
        rum: body.rum,
        tekst: body.tekst,
        nr: beskedNr++
    };
    chatBeskeder.push(beskedObj);
    res.status(201).send(req.body);
});

app.delete('/besked/:nr', (req, res) => {
    const nr = parseInt(req.params.nr);
    const chatBeskedIndex = chatBeskeder.findIndex(element => element.nr === nr);
    if (chatBeskedIndex !== -1) {
        chatBeskeder.splice(chatBeskedIndex, 1);
        res.status(200).send({ resultat: 'Besked slettet!' });
    } else
        res.status(404).send();
});

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
});