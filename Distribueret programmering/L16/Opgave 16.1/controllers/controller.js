const mongoose = require('mongoose');
const ChatBesked = require('../models/chatbesked');
const config = require('../config');

mongoose.connect(config.databaseURI, { useNewUrlParser: true, useUnifiedTopology: true });

// Try to find any element in db, if null - db is empty and return true
exports.isDBEmpty = async function () {
    return await (ChatBesked.findOne().exec()) == null;
}

exports.getChatMessages = async function () {
    return await ChatBesked.find().select('-_id -__v').exec();
}

exports.getChatMessagesInRoom = async function (room) {
    return await ChatBesked.find().select('-_id -__v').where('rum').eq(room).exec();
}
exports.getRooms = async function () {
    return await ChatBesked.find().select('rum -_id').distinct('rum').exec();
}

// Gets message with highest nr and adds 1 or return 0 if db is empty
exports.getNextChatMessageNumber = async function () {
    return (await module.exports.isDBEmpty()) ? 0 : (await ChatBesked.findOne().sort('-nr').exec()).nr + 1;
}

exports.createBesked = async function (body) {
    const besked = await ChatBesked.create({
        navn: body.navn,
        rum: body.rum,
        tekst: body.tekst,
        nr: await module.exports.getNextChatMessageNumber()
    });
    if (besked)
        return {
            besked,
            statusCode: 201,
        }
    else
        return {
            statusCode: 500,
        }
}

exports.deleteBesked = async function (nr) {
    const deleteInfo = await ChatBesked.deleteOne().where('nr').equals(nr).exec();
    if (deleteInfo.deletedCount == 1)
        return {
            statusCode: 200,
            message: { resultat: 'Besked slettet!' }
        }
    else
        return {
            statusCode: 404,
        }
}

//

// Creates 3 dummy messages if db is empty
exports.populateDatabase = async function () {
    try {
        if (await module.exports.isDBEmpty()) { // TODO: Use own method
            await ChatBesked.create({
                navn: 'navn1',
                rum: 'rum1',
                tekst: 'tekst1',
                nr: 0
            });
            await ChatBesked.create({
                navn: 'navn2',
                rum: 'rum1',
                tekst: 'tekst2',
                nr: 1
            });
            await ChatBesked.create({
                navn: 'navn3',
                rum: 'rum2',
                tekst: 'tekst3',
                nr: 2
            });
        }
    } catch (error) {
        console.log(error);
    }
}

module.exports.populateDatabase();

// Remove/clear data
exports.clearChatBeskeder = async function () {
    await ChatBesked.deleteMany({});
}