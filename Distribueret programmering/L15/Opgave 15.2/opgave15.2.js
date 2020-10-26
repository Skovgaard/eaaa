// Modificer løsningen til Opgave 12.1 – så websiden nu genereres med handlebars i browseren.

const express = require('express');
const app = express();
const fetch = require('node-fetch');
const cors = require('cors');


const port = 8080;

app.use(cors());
app.use(express.static(__dirname + '/filer'));

const earthquakeUrl = // https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php 
    'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson';

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

app.get('/earthquakes', async (req, res) => {
    try {
        let earthquakes = await get(earthquakeUrl);
        res.send(earthquakes);
    } catch (e) {
        if (typeof e.message === 'number')
        res.sendStatus(e.message);
        else {
            res.send(e.name + ": " + e.message);
        }
    }
});

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
})