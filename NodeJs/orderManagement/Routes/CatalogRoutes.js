const {Router} = require('express');
const catController = require('../Controller/catalogController');

router = Router();

router.post('/add', catController.addBook);


module.exports = router ;