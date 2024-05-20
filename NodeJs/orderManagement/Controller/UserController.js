const user = require('../Model/user');

const signUp = async (req, res, next) => {
    try {
        const data = await user.User.create(req.body);
        console.log("User:", data);
        res.send(data);
    } catch (err) {
        console.log(`Error at UserController/signUp due to ${err.message}`);
        next(err); // Passes control to the error-handling middleware
    }
};

const Login = async(req, res,next) => {
    try {
        console.log(req);
        const mail = req.query.email;
        const pass = req.query.password;
        console.log(mail + " "+pass);
        const data = await user.User.findOne({
            where : {
                email : mail,
                password : pass
            }
        });
        if (data) {
            res.status(200).send(" Login successful ");
        } else {
            res.status(401).send('Invalid username or password');
        }
    } catch (err) {
        console.error('Error:', err);
        res.status(500).send('Internal Server Error');
    } 
};


module.exports = { signUp, Login };