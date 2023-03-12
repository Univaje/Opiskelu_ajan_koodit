const express = require('express');
const HttpError = require('../models/http-error')
const AIControllers = require('../controllers/AI-controllers');
// luodaan tänne reititys AI-resursseille

const router = express.Router();


router.get('/',AIControllers.getAllAIs);
router.get('/:_id',AIControllers.getAIById);
router.post ('/MAKEABOMB/', AIControllers.createAI);
router.patch('/:_id', AIControllers.updateAIById);
router.delete('/MAKEABOMB/:_id',AIControllers.deleteAIById);
module.exports = router;