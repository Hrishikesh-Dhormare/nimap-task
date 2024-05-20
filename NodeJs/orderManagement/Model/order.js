const {Sequelize, DataTypes} = require('sequelize');
const { seq }= require('./config');
const {User} = require('./user');
const {Catalog}= require('./catalog');

const Order = seq.define('Order', {
    orderId : {
        type : DataTypes.INTEGER,
        primaryKey : true,
        autoIncrement : true
    },
    userId : {
        type : DataTypes.INTEGER,
        references: {         // Order belong to One User 1:1
            model: 'Users',
            key: 'UserId'
          }
    },
    bookId : {
        type : DataTypes.INTEGER,
        references: {         // Order hasMany Books 1:n
            model: 'Catalog',
            key: 'bookId'
        }
    },
    quantity : {
        type : DataTypes.INTEGER
    },
    orderDate : {
        type : DataTypes.DATE
    }

});

Order.belongsTo(User, { foreignKey :'userId', as : 'user'});
Order.hasMany(Catalog, { as : 'catalog'});

// seq.sync({force : true}).then(()=>{console.log('Database Connected -Order Table')}).catch((err)=>{console.log('Database sync Error',err)});

module.exports = { Order};



