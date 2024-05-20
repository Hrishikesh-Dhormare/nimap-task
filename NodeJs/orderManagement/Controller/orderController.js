const order = require('../Model/order');

const createOrder = async(req, res, next) => {
    try{
        const data = await order.Order.create(req.body);
        console.log("Order : ", data);
        res.send(data);
    }catch (err) {
        console.log(`Error at OrderController/createOrder due to ${err.message}`);
        next(err); // Passes control to the error-handling middleware
    }
};

module.exports = {createOrder};