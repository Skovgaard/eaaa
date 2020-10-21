// Lav en Express server svarene til userServer.js.
const express = require('express');
const app = express();
const fetch = require('node-fetch');

const port = 8080;

const userUrl = 'https://jsonplaceholder.typicode.com/users';

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

function genererTabel(users) {
    let html = '<table>';
    for (user of users) {
        html +=
            '<tr><td>' + user.id +
            '</td><td>' + user.name +
            '</td><td>' + user.company.name +
            '</td></tr>\n';
    }
    html += '</table>';
    return html;
}

app.get('/', async (req, res) => {
    let users = await get(userUrl);
    let html = genererTabel(users);
    res.send(html);
})

app.listen(port, () => {
    console.log(`Example app listening at http://localhost:${port}`)
});