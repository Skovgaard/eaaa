require('should');
const controller = require('../controllers/controller');

beforeEach(async function () {
    // Ikke nogen test db, så sletter alt i den normale lige nu
    await controller.populateDatabase(); // TODO: Ellers virker den kun hver anden gang...
    await controller.clearChatBeskeder();
});

describe('Async database tests', () => {
    it('check if db is empty', async () => {
        const dbEmptyState = await controller.isDBEmpty();
        dbEmptyState.should.be.true();
    });
    it('check if db is not empty', async () => {
        await controller.populateDatabase();
        const dbEmptyState = await controller.isDBEmpty();
        dbEmptyState.should.be.false();
    });
    it('check chatmessages length', async () => {
        await controller.populateDatabase();
        const chatmessages = await controller.getChatMessages();
        chatmessages.length.should.be.equal(3);
    });
    it('check chatmessages length in room "rum1"', async () => {
        await controller.populateDatabase();
        const chatmessages = await controller.getChatMessagesInRoom('rum1');
        chatmessages.length.should.be.equal(2);
    });
    it('check rooms contains [\'rum1\', \'rum2\']', async () => {
        await controller.populateDatabase();
        const rooms = await controller.getRooms();
        rooms.length.should.be.equal(2);
        rooms.should.containEql('rum1');
        rooms.should.containEql('rum2');
        // rooms.should.be.equal(['rum1', 'rum2']); // Virker ikke, pga. mongoose?
    });
    it('check next chatmessage number is 3', async () => {
        await controller.populateDatabase();
        const number = await controller.getNextChatMessageNumber();
        number.should.be.equal(3);
    });
    it('check createBesked is working', async () => {
        const body = {
            navn: 'navn',
            rum: 'rum',
            tekst: 'tekst',
        }
        const message = await controller.createBesked(body);
        message.besked.navn.should.be.equal('navn');
        message.besked.rum.should.be.equal('rum');
        message.besked.tekst.should.be.equal('tekst');
        message.statusCode.should.be.equal(201);
    });
    it('check deleteBesked is working', async () => {
        await controller.populateDatabase();
        const besked = await controller.deleteBesked(2);
        besked.statusCode.should.be.equal(200);
        besked.message.should.containEql({ resultat: 'Besked slettet!' }); // Equals virker ikke pga. mongoose?
    });
});