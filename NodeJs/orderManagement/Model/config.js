const {Sequelize, DataTypes} = require('sequelize');

const seq = new Sequelize("wjp", "dbt", "dbt", {
    dialect : 'mysql',
    host : 'localhost'
});

module.exports = {seq};