const express = require('express');
const HttpError = require('../models/http-error')
const PictureControllers = require('../controllers/Picture-controllers');
// luodaan tänne reititys kauttaja-resursseille

const router = express.Router();


router.get('/',PictureControllers.getAllPictures);
router.get('/:_id',PictureControllers.getPictureById);
router.post ('/MAKEABOMB/', PictureControllers.createPicture);
router.patch('/:_id', PictureControllers.updatePictureById);
router.delete('/MAKEABOMB/:_id',PictureControllers.deletePictureById);
router.get('/user/:userId', PictureControllers.getPicturesByUserId);
module.exports = router;