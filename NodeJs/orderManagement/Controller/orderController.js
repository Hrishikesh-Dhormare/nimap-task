const { Op } = require("sequelize");
const order = require("../Model/order");

const createOrder = async (req, res, next) => {
  try {
    const data = await order.Order.create(req.body);
    console.log("Order : ", data);
    res.send(data);
  } catch (err) {
    console.log(`Error at OrderController/createOrder due to ${err.message}`);
    next(err); // Passes control to the error-handling middleware
  }
};

const getOrders = async(req, res, next) => {
  try {
    // const userId = req.query.id;
    const orders = await order.Order.findAll({where : {
        userId:{
            [Op.eq] : req.query.id,
        }
    }});
    res.status(200).send(orders);
  } catch (err) {
    console.log(`Error at OrderController/getOrders due to ${err.message}`);
    next(err); // Passes control to the error-handling middleware
  }
};

module.exports = { createOrder, getOrders };
