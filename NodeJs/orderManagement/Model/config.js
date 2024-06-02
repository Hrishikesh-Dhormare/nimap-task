const {Sequelize, DataTypes} = require('sequelize');

const sequelize = new Sequelize("wjp", "dbt", "dbt", {
    dialect : 'mysql',
    host : 'localhost'
});

module.exports = {sequelize};