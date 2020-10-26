// Modificer løsningen til Opgave 13.1 – så websiden nu genereres med hbs på serveren.

const express = require('express');
const app = express();
const fs = require('fs').promises;
const hbs = require('hbs');

const port = 8080;

app.use(express.static(__dirname + '/filer'));

app.set('view engine', 'hbs');
app.set('views', __dirname + '/templates');

app.get('/', async (req, res) => {
    try {
        const filnavne = await fs.readdir(__dirname + '/filer');

        res.render('index.hbs', {
            title: 'Templating - på serveren',
            filnavne
        });
    } catch (e) {
        if (typeof e.message === 'number')
            res.sendStatus(e.message);
        else {
            res.send(e.name + ": " + e.message);
        }
    }
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})