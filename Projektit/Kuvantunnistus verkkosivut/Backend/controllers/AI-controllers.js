const HttpError = require('../models/http-error');
const AIs = require('../models/AI');
const mongoose = require('mongoose');

const createdAI = async(req, res,next) => {
    const {AiName} = req.body;
    console.log(req.body);
    console.log("TÄS");
    const newid = new mongoose.Types.ObjectId().toHexString();
    const createdAI = new AIs({
    AiName: AiName,
    _id: newid
    });
    try {
        console.log(createdAI);
        await createdAI.save();
    }
    catch(err){
        const Error = new HttpError('Creator Exploded',
        418);
        return next(Error);  
    }
    res
        .status(201)
        .json(createdAI);
};
const updateAIById = async(req,res,next) => {
    console.log(req.params._id)
    const {AiName} = req.body;
    const AIID = req.params._id;
    let AI;
    try {
        AI = await AIs.findById(AIID);
    }
    catch (err) {
        const error = new HttpError(
        'SPY!!!',418
        );
    return next(error)
    }
    if(AI) {
        AI.AiName = AiName

    try {
        console.log(AI)
        await AI.save()
        
    } catch (err) {
        const error = new HttpError(
            'We fired the creator',418
        );
        return next(error);
    }
    }
    else{
        const error = new HttpError(
            'Creator doesnt work here',
            418
        );
        return next(error);
    }
    res.json({AI: AI.toObject({getters: true})});
}

const deleteAIById = async (req,res,next) => {
    console.log("HERE!")
    const AIID = req.params._id;
    let AI;
    try {
        AI = await AIs.findById(AIID);
    }
    catch (err) {
        const error = new HttpError(
            'We could not kill the creator',
            418
        );
        return next(error);
    }
    if(AI) {
    try {
        AI.remove();
    } catch (err){
        const error = new HttpError(
            'Creator left before we could kill him',
            418
        );
        return next(error); 
    }
    }
    else{
        const error = new HttpError(
            'There is no creator to be killed',
            418
        );
        return next(error); 
    }
    res
    .status(201)
    .json({message:'JEI! We killed Him!'})
}

const getAllAIs = async (req, res,next) => {
    let AI;
    try {
        AI = await AIs.find();
    }
    catch (err){
        const error = new HttpError(
            'The door was locked we couldnt get in',418
        );
        return next(error);
    }

    if (!AI || AI.length == 0){
        const error = new HttpError(
            'All Creators died horribly',404
        );
        return next(error);
    }
res.json(AI);
}

// id haku usernamen ja passwordin avulla
const getAIById = async (req, res,next) => {
    const AIId = req.params._id;
    console.log(AIId)
    console.log(req.params._id)
    console.log("You are here")
    let AI;
    try {
        AI = await AIs.findById(AIId)
    }
    catch (err){
        return next(new HttpError('BOOOM!!! creator not found!',418))  
    }
    console.log(AI + "Objekti")
    if(!AI) {
        console.log("KOSH!")

        return next(new HttpError('BOOOM!!! user not found!',418))  
    }
    res.json({AI});
}

exports.getAllAIs = getAllAIs;
exports.getAIById = getAIById;
exports.createAI = createdAI;
exports.updateAIById = updateAIById;
exports.deleteAIById = deleteAIById;