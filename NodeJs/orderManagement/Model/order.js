const {Sequelize, DataTypes} = require('sequelize');
const { seq, sequelize }= require('./config');
const {User} = require('./user');
const {Catalog}= require('./catalog');
const {OrderItems} = require('./orderItem');

const Order = sequelize.define('Order', {
    orderId : {
        type : DataTypes.INTEGER,
        primaryKey : true,
        autoIncrement : true
    },
    userId : {
        type : DataTypes.INTEGER, // Order belong to One User 1:1
    },
    bookId : {
        type : DataTypes.INTEGER, // Order hasMany Books 1:n
    },
    quantity : {
        type : DataTypes.INTEGER
    },
    orderDate : {
        type : DataTypes.DATE
    }

});

Order.belongsTo(User, { foreignKey :'userId', as : 'user'});
Order.belongsToMany(Catalog, { through : OrderItems, onDelete: "CASCADE"});


module.exports = { Order};



