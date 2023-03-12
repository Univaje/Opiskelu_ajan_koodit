const express = require('express');
const HttpError = require('../models/http-error')
const UserControllers = require('../controllers/User-controllers');
// luodaan tänne reititys kauttaja-resursseille

const router = express.Router();


router.get('/',UserControllers.getAllUsers);
router.get('/:_id',UserControllers.getUserById);
router.post ('/MAKEABOMB/', UserControllers.createdUser);
router.patch('/:_id', UserControllers.updateUserById);
router.delete('/MAKEABOMB/:_id',UserControllers.deleteUserById);
module.exports = router;