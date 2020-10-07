// Tag udgangspunkt i opgave12.1.html, opgave12.1.css og opgave12.1.js.
// Åben earthquakeUrl’en i en browser og undersøg den hentede JSON.
// Lav dernæst en webside, der viser en tabel over den sidst uges jordskælv med en styrke på mindst 5.
// Tabellen skal vise styrke, sted og tidspunkt for hvert jordskælv – sorteret efter styrke.

// opgave12.1.js
const earthquakeUrl = // https://earthquake.usgs.gov/earthquakes/feed/v1.0/geojson.php 
    'https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/4.5_week.geojson';

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

const body = document.body;

// User table
const table = document.createElement('table');
table.id = 'table';
body.append(table);

get(earthquakeUrl)
    .then(result => { generateTable(table, result); })
    .catch(fejl => console.log(fejl));

function generateTable(table, data) {
    console.log(data.features);
    console.log(data.features[0].properties);

    let tempData = data.features.filter(feature => feature.properties.mag >= 5).sort((a, b) => {
        return a.properties.mag - b.properties.mag
    });;

    const thr = document.createElement('tr');
    table.append(thr);

    const th1 = document.createElement('th')
    thr.append(th1);
    th1.append('Styrke');

    const th2 = document.createElement('th')
    thr.append(th2);
    th2.append('Sted');

    const th3 = document.createElement('th')
    thr.append(th3);
    th3.append('Tidspunkt');

    for (const feature of tempData) {
        const tr = document.createElement('tr');
        table.append(tr);

        const td1 = document.createElement('td');
        tr.append(td1);
        td1.append(feature.properties.mag);

        const td2 = document.createElement('td');
        tr.append(td2);
        td2.append(feature.properties.place);

        const td3 = document.createElement('td');
        tr.append(td3);
        td3.append(new Date(feature.properties.time));
    }
}