const config = require('./config');
const session = require('express-session');
const MongoDBStore = require('connect-mongodb-session')(session);

const store = new MongoDBStore({
    uri: config.databaseURI, // MongoDB connection string
    collection: 'sessions' // MongoDB collection
});

// Catch errors
store.on('error', function (error) {
    console.log(error);
});

const mongodbSession = {
    secret: 'hemmelig',
    cookie: {
        maxAge: 1000 * 60 * 10 // 1000 ms * 60 = 10 min * 10 = 10 minutes
    },
    store,
    resave: true,
    saveUninitialized: true
}

module.exports = mongodbSession;