require('should');
const request = require('supertest');
const app = require("../app");

describe('Webserver requests tests', () => {
    it("get('/') does not contain <table>", async () => {
        let response = await request(app)
            .get('/')
            .expect(200)
            .expect('Content-Type', /html/);
        response.text.search(/<table>/).should.be.equal(-1); // ...flot test
    });
    it("get('/') responds with html", function (done) {
        request(app)
            .get('/')
            .set('Accept', 'application/json')
            .expect('Content-Type', /html/)
            .expect(200, done);
    });
    it("get('/chat/beskeder') uden login", async () => {
        let response = await request(app)
            .get('/json')
            .expect(404)
            .expect('Content-Type', /html/);
    });
    // it("get('/chat/beskeder') med login", async () => { // Hmm, hvordan?
    //     let response = await request(app)
    //         .get('/json')
    //         .expect(404)
    //         .expect('Content-Type', /html/);
    // });
    it("get('/xyz')", async () => {
        await request(app)
            .get('/xyz')
            .expect(404)
            .expect('Content-Type', /html/)
    });

    // TODO: Test post?
});