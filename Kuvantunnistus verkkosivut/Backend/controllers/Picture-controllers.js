const HttpError = require("../models/http-error");
const Pictures = require("../models/Pictures");
const mongoose = require("mongoose");
const DefaultUser = mongoose.Types.ObjectId("63ef5670593c17ed890947c4");
const DefaultAi = mongoose.Types.ObjectId("63ef5662593c17ed890947c3");

const createdPic = async (req, res, next) => {
	const { PicPath, Answer } = req.body;
	console.log(req.body);
	console.log("TÄS");
	const newid = new mongoose.Types.ObjectId().toHexString();
	const createdPicture = new Pictures({
		PicPath: PicPath,
		Answer: Answer,
		User: DefaultUser, //req.user._id,
		AI: DefaultAi, //req.Ai._id,
		_id: newid,
	});
	try {
		console.log(createdPicture);
		await createdPicture.save();
	} catch (err) {
		const Error = new HttpError("Creator Exploded", 418);
		return next(Error);
	}
	res.status(201).json(createdPicture);
};
const updatePictureById = async (req, res, next) => {
	console.log(req.params._id);
	const { PicPath, Answer } = req.body;
	const PictureID = req.params._id;
	let Picture;
	try {
		Picture = await Pictures.findById(PictureID);
	} catch (err) {
		const error = new HttpError("SPY!!!", 418);
		return next(error);
	}
	if (Picture) {
		(Picture.PicPath = PicPath), (Picture.Answer = Answer);
		//Picture.User = DefaultUser, //req.user._id,
		//Picture.AI = DefaultAi, //req.Ai._id,,
		//Picture._id = PictureID;
		try {
			console.log(Picture);
			await Picture.save();
		} catch (err) {
			const error = new HttpError("We fired the creator", 418);
			return next(error);
		}
	} else {
		const error = new HttpError("Creator doesnt work here", 418);
		return next(error);
	}
	res.json({ Picture: Picture.toObject({ getters: true }) });
};

const deletePictureById = async (req, res, next) => {
	console.log("HERE!");
	const PictureID = req.params._id;
	let Picture;
	try {
		Picture = await Pictures.findById(PictureID);
	} catch (err) {
		const error = new HttpError("We could not kill the creator", 418);
		return next(error);
	}
	if (Picture) {
		try {
			Picture.remove();
		} catch (err) {
			const error = new HttpError("Creator left before we could kill him", 418);
			return next(error);
		}
	} else {
		const error = new HttpError("There is no creator to be killed", 418);
		return next(error);
	}
	res.status(201).json({ message: "JEI! We killed Him!" });
};

const getAllPictures = async (req, res, next) => {
	let Picture;
	try {
		Picture = await Pictures.find();
	} catch (err) {
		const error = new HttpError("The door was locked we couldnt get in", 418);
		return next(error);
	}

	if (!Picture || Picture.length == 0) {
		const error = new HttpError("All Creators died horribly", 404);
		return next(error);
	}
	res.json(Picture);
};

// id haku usernamen ja passwordin avulla
const getPictureById = async (req, res, next) => {
	const PictureId = req.params._id;
	console.log(PictureId);
	console.log(req.params._id);
	console.log("Am i here?");
	let Picture;
	try {
		Picture = await Pictures.findById(PictureId);
	} catch (err) {
		return next(new HttpError("BOOOM!!! creator not found!", 418));
	}
	console.log(Picture + "Objekti");
	if (!Picture) {
		console.log("KOSH!");

		return next(new HttpError("BOOOM!!! user not found!", 418));
	}
	res.json({ Picture });
};

const getPicturesByUserId = async (req, res, next) => {
	const userId = req.params.userId;

	let pictures;
	try {
		pictures = await Pictures.find({ User: userId });
	} catch (err) {
		const error = new HttpError(
			"Fetching pictures failed, please try again",
			500
		);
		return next(error);
	}

	if (!pictures) {
		const error = new HttpError(
			"Could not find any pictures for the specified user ID",
			404
		);
		return next(error);
	}

	res.json({
		pictures: pictures.map((picture) => picture.toObject({ getters: true })),
	});
};

exports.getAllPictures = getAllPictures;
exports.getPictureById = getPictureById;
exports.createPicture = createdPic;
exports.updatePictureById = updatePictureById;
exports.deletePictureById = deletePictureById;
exports.getPicturesByUserId = getPicturesByUserId;