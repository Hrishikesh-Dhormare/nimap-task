const {Router} = require('express');
const orderController = require('../Controller/orderController');

router = Router();

router.post('/place', orderController.createOrder);
router.get('/getOrders', orderController.getOrders);


module.exports = router ;