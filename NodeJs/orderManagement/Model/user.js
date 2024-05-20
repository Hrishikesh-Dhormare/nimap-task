const {Sequelize, DataTypes} = require('sequelize');
const sequelize = new Sequelize("wjp", "dbt", "dbt", {
    dialect : 'mysql',
    host : 'localhost'
});


const User = sequelize.define('User',{
    userId : {
        type : DataTypes.INTEGER,
        primaryKey : true,
        autoIncrement : true,
    },
    name : {
        type : DataTypes.TEXT,
        allowNull : false,
    },
    email : {
        type : DataTypes.STRING,
        unique : true,
        allowNull : false,
        validate : {
            isEmail : true,
            is : ["^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$"]
        }
    },
    password : {
        type : DataTypes.STRING,
        allowNull : false,
        validate : {
            is : ["^(?=.*[a-z])(?=.*[A-Z]).{8,}$"]
        }
    },
    isAdmin : {
        type : DataTypes.BOOLEAN,
        defaultValue : false,
        allowNull : false
    }
});

sequelize.sync().then(()=>{console.log('Database Connected -User Table')}).catch((err)=>{console.log('Database sync Error',err)});

module.exports = { User};

// is : ["^((([!#$%&'*+\-/=?^_`{|}~\w])|([!#$%&'*+\-/=?^_`{|}~\w][!#$%&'*+\-/=?^_`{|}~\.\w]{0,}[!#$%&'*+\-/=?^_`{|}~\w]))[@]\w+([-.]\w+)*\.\w+([-.]\w+)*)$"],
