const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const ObjectId = mongoose.Schema.Types.ObjectId;

const AiSchema = new Schema({
    //Createdate: {type: Date, default: Date.now, required: true},
    AiName: {type: String, required: true},
    _id: {type:ObjectId, default:ObjectId},
    
},{versionKey: false })

module.exports = mongoose.model('aiChoice', AiSchema);