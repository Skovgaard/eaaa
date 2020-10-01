// Tag udgangspunkt i opgave11.2.js og lav en webside, der viser en tabel over users.
// Når der klikkes på en user, skal dennes posts vises nederst på websiden i en anden tabel. 
// Løs opgaven med async.

// opgave11.2.js
const userUrl = 'https://jsonplaceholder.typicode.com/users';
const postUrl = 'https://jsonplaceholder.typicode.com/posts?userId=';

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

const body = document.body;

// User table
const usersTable = document.createElement('table');
usersTable.id = 'usersTable';
body.append(usersTable);

// Populate user table
get(userUrl)
    .then(result => { populateTable(usersTable, result); })
    .catch(fejl => console.log(fejl));

// Post table
const postTable = document.createElement('table');
postTable.id = 'postTable';
body.append(postTable);

// Function to populate post table
function getPosts(id) {
    get(postUrl + id)
        .then(result => { populateTable(postTable, result) })
        .catch(fejl => console.log(fejl));
}

// Generic populate table
function populateTable(table, data) {
    console.log(data);

    table.innerHTML = '';
    const thr = document.createElement('tr');
    table.append(thr);

    populateHeaderRow(data[0], thr);

    for (const object of data) {
        const tr = document.createElement('tr');
        table.append(tr);

        populateRows(object, tr);
    }
}

// Build row headers in populate table
function populateHeaderRow(object, tableElement) {
    for (const key in object) {
        if (object.hasOwnProperty(key)) {

            const element = object[key];
            if (typeof element !== 'object') {
                const th = document.createElement('th')
                tableElement.append(th);
                th.append(key);
            }
        }
    }
}

// Populate rows with data in populate table
function populateRows(object, tableElement) {
    for (const key in object) {
        if (object.hasOwnProperty(key)) {

            const element = object[key];
            if (typeof element !== 'object') {
                const td = document.createElement('td');
                tableElement.append(td);
                td.append(element);
            }
        }
    }
    if (tableElement.parentElement.id === 'usersTable') {
        tableElement.onclick = () => getPosts(object.id);
        tableElement.onmouseover = () => {
            const tr = document.getElementsByTagName('tr');
            for (const element of tr) {
                element.className = '';
            }
            tableElement.className = 'focus';
        }
    }
}