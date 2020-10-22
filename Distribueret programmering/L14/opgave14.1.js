// Lav en lokal database med Mongoose, der jf. Opgave 12.1 indeholder styrke, sted, tidspunkt og koordinater for de hentede jordskælv. 
// Når jordskælvsdata hentes igen, skal kun nye jordskælv tilføjes, så dubletter undgås.
// Udskriv dernæst det største jordskælv samt en sorteret liste af steder.

const fetch = require('node-fetch');
const mongoose = require('mongoose');

const url = 'mongodb://localhost/earthquakesDB';

mongoose.connect(url,
    { useNewUrlParser: true, useUnifiedTopology: true });

const earthquakeSchema = new mongoose.Schema({
    mag: Number,
    place: String,
    time: Number,
    coordinates: [Number]
});

const Earthquakes = mongoose.model('Earthquakes', earthquakeSchema);

// Populate db with data
async function populateDatabase(data) {
    for (const eq of data) {
        await Earthquakes.create({
            mag: eq.properties.mag,
            place: eq.properties.place,
            time: eq.properties.time,
            coordinates: eq.geometry.coordinates
        });
    }
}

// Populates db with NEW data
async function updateDatabase(data) {
    try {

        const maxTime = await getMaxTime();
        const newData = data.filter(eq => eq.properties.time > maxTime);

        await populateDatabase(newData);

    } catch (error) {
        if (error.message === 'Database is empty')
            await populateDatabase(data);
        else
            console.log(error);
    }
    console.log('Database updated');    
}

// Returns time of earthquake with highest time in db
async function getMaxTime() {
    const maxTimeEarthquake = await Earthquakes.findOne().sort('-time').exec();
    if (!maxTimeEarthquake)
        throw new Error('Database is empty');
    return maxTimeEarthquake.tidspunkt;
}

async function getHighestMagnitudeEarthquake() {
    return await Earthquakes.findOne().sort('-mag').exec();
}

async function getSortedListOfPlaces() {
    return await Earthquakes.find().sort('-place').select('place -_id').distinct('place').exec();
}

// Get earthquakes

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}
const earthquakeUrl = 'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson';

async function main() {
    let earthquakes;
    try {
        earthquakes = await get(earthquakeUrl);
        earthquakes = earthquakes.features;

        // await populateDatabase(earthquakes);
        await updateDatabase(earthquakes);

        console.log(await getHighestMagnitudeEarthquake());
        console.log(await getSortedListOfPlaces());
    } catch (fejl) {
        console.log(fejl);
    }
    process.exit();
}

main();