const mongoose = require('mongoose');
const User = require('./Users');
const Ai = require('./AI');
const Schema = mongoose.Schema;
const ObjectId = mongoose.Schema.Types.ObjectId;
const ObjectId1 = mongoose.Schema.Types.Buffer;
const PictureScehma = new Schema({
    //Createdate: {type: Date, default: Date.now, required: true},
    PicPath: {type: String, required: true},
    Answer: {type: String, required: true},
    User: { type: ObjectId, ref:'User'},
    AI: {type: ObjectId,ref: 'AI'},
    _id: {type:ObjectId, default:ObjectId},
    
},{versionKey: false })

module.exports = mongoose.model('Pictures', PictureScehma);
