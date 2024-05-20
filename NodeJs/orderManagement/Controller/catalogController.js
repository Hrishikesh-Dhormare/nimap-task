const catalog = require('../Model/catalog');

const addBook = async(req, res, next) => {
    try {
        const data = await catalog.Catalog.create(req.body);
        console.log("User:", data);
        res.send(data);
    } catch (err) {
        console.log(`Error at CatalogController/addBook due to ${err.message}`);
        next(err); // Passes control to the error-handling middleware
    }
};

module.exports = { addBook};