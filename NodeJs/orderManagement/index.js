const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const env = require('dotenv').config();
const userRoute = require('./Routes/UserRoutes');
const catRoute = require('./Routes/CatalogRoutes');
const orderRoute = require('./Routes/orderRoutes')
const errorHandler = require('./middleware/errorHandler');
const { sequelize} = require('./Model/config');

const app = express();
const port = process.env.PORT;

const syncDB =()=>{
    sequelize.sync().then(()=>{
        console.log("DB Connected");
        app.listen(port,()=>{
            console.log(`App Server runing on ${port}`);
        });
        }).catch((err)=>{console.log("DB Connection Error",err)});
}
syncDB();

app.use(cors());
app.use(bodyParser.json());
app.use(errorHandler);

app.use('/user',userRoute);
app.use('/catalog', catRoute);
app.use('/order', orderRoute);
