const {Router} = require('express');
const orderController = require('../Controller/orderController');

router = Router();

router.post('/place', orderController.createOrder);


module.exports = router ;