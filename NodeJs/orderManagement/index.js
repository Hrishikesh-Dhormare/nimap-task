const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');
const env = require('dotenv').config();
const userRoute = require('./Routes/UserRoutes');
const catRoute = require('./Routes/CatalogRoutes');
const orderRoute = require('./Routes/orderRoutes')
const errorHandler = require('./middleware/errorHandler');

const app = express();
const port = process.env.PORT;

app.listen(port,()=>{
    console.log(`App Server runing on ${port}`);
});

app.use(cors());
app.use(bodyParser.json());
app.use(errorHandler);

app.use('/user',userRoute);
app.use('/catalog', catRoute);
// app.use('/order', orderRoute);
