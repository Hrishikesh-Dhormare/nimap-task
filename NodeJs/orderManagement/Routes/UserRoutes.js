const {Router} = require('express');
const userController = require('../Controller/UserController');

router = Router();
// middleware that is specific to this router
const timeLog = (req, res, next) => {
    console.log('Time: ', Date.now())
    next()
  }
  router.use(timeLog);

  router.post('/signup',userController.signUp);
  router.get('/login',userController.Login);

module.exports = router;