// index.js
async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

async function getText(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.text();
}

async function generateEarthquakeTable(earthquakes) {
    let template = await getText('/earthquakes.hbs');
    let compiledTemplate = Handlebars.compile(template);
    return compiledTemplate({earthquakes});
}

async function main() {
    try {
        let earthquakes = await get('/earthquakes');
        // let earthquakes = await get('/earthquakes');
        document.body.innerHTML = await generateEarthquakeTable(earthquakes);
    } catch (e) {
        console.log(e.name + ": " + e.message);
    }
}
main();