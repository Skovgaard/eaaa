// Tag udgangspunkt i opgave11.1.js og hent samt udskriv data om users.
// Hvis fejl eller exception, skal den udskrives.
// Anvend funktionen get(url) til at hente data på nettet.
// Funktionen bruger fetch(), der er en standard funktion i browseren, og derfor skal koden udføres vha.
// opgave11.1.html.
// Løs opgaven både med og uden async.
// Afprøv programmet med de 3 forskellige userUrl's.

// opgave11.1.js
const userUrl = 'https://jsonplaceholder.typicode.com/users';
// const userUrl = 'https://jsonplaceholder.typicode.com/users/11';
// const userUrl = 'httpz://jsonplaceholder.typicode.com/users';

async function get(url) {
    const respons = await fetch(url);
    if (respons.status !== 200) // OK
        throw new Error(respons.status);
    return await respons.json();
}

get(userUrl).then(
    result => {
        console.log('Async: ');
        console.log(result);
    }
).catch(
    fejl => console.log(fejl)
);

function getPromise(url) {
    return new Promise(function (resolve, reject) {
        return fetch(url).then(respons => {
            if (respons.status !== 200) // OK
                throw new Error(respons.status);
            resolve(respons.json());
            reject('Error');
        }).catch(error => { console.log(error) });
    });
}

getPromise(userUrl).then(
    result => {
        console.log('Promise: ');
        console.log(result);
    }
).catch(
    fejl => console.log(fejl)
);

console.log("Efter begge");