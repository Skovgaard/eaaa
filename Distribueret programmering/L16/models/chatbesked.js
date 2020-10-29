const mongoose = require('mongoose');

const chatBeskedSchema = new mongoose.Schema({
    navn: String,
    rum: String,
    tekst: String,
    nr: Number
});

module.exports = mongoose.model('ChatBesked', chatBeskedSchema);