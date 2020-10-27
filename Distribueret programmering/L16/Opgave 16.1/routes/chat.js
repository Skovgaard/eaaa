const express = require('express');
const router = express.Router();
const controller = require('../controllers/controller');

// Endpoints

router.use(authenticate);

router.get('/', renderChatClient);

router.get('/beskeder', getBeskeder);

router.get('/beskeder/:rum', getBeskederRum);

router.get('/rum', getRum);

router.post('/besked', postBesked);

router.delete('/besked/:nr', deleteBesked);

// Endpoint functions

function authenticate(req, res, next) {
    const navn = req.session.navn;
    if (!navn)
        res.redirect('/ingenAdgang.html');
    else
        next();
}

async function renderChatClient(req, res) {
    const navn = req.session.navn;
    res.render('chatclient.hbs', { navn });
}

async function getBeskeder(req, res) {
    res.status(200).send(await controller.getChatMessages());
}

async function getBeskederRum(req, res) {
    const rum = req.params.rum;
    res.status(200).send(await controller.getChatMessagesInRoom(rum));
}

async function getRum(req, res) {
    res.status(200).send(await controller.getRooms());
}

async function postBesked(req, res) {
    const body = req.body;
    const result = await controller.createBesked(body);
    res.status(result.statusCode).send(req.body);
}

async function deleteBesked(req, res) {
    const nr = parseInt(req.params.nr);
    const result = await controller.deleteBesked(nr);
    res.status(result.statusCode).send(result.message);
}

//

module.exports = router;