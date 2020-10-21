// Opgave 13.1a
// Lav en Express server svarende til filServer.js.
const express = require('express');
const app = express();
const fs = require('fs').promises;

const port = 8080;

app.use(express.static(__dirname + '/filer'));

app.get('/', async (req, res) => {
    let filnavne = await fs.readdir(__dirname + '/filer');
    let html = genererLinks(filnavne);
    res.send(html);
})

function genererLinks(filnavne) {
    let html = '';
    for (let filnavn of filnavne) {
        html += '<a href="' + filnavn + '">' + filnavn + '</a><br>\n';
    }
    return html;
}

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})