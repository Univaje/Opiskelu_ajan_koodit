const HttpError = require("../models/http-error");
const Users = require("../models/Users");
const mongoose = require("mongoose");

const createdUser = async (req, res, next) => {
	const { Name, Username, Password, Email } = req.body;

	if (!Name || !Username || !Password || !Email) {
		const error = new HttpError("Missing required fields", 400);
		return next(error);
	}

	// Check if username or email already exist in the database
	const existingUser = await Users.findOne({ $or: [{ Username }, { Email }] });

	if (existingUser) {
		const error = new HttpError("Username or email already exists", 422);
		return next(error);
	}

	const newid = new mongoose.Types.ObjectId().toHexString();
	const createdUser = new Users({
		Name: Name,
		Username: Username,
		Password: Password,
		Email: Email,
		_id: newid,
	});
	try {
		console.log(createdUser);
		await createdUser.save();
	} catch (err) {
		const error = new HttpError("Could not create user", 500);
		return next(error);
	}
	res.status(201).json(createdUser);
};

const updateUserById = async (req, res, next) => {
	const { Name, Username, Password, Email } = req.body;
	const userID = req.params._id;

	try {
		const user = await Users.findById(userID);

		if (user) {
			user.Name = Name;
			user.Username = Username;
			user.Password = Password;
			user.Email = Email;

			await user.save();
			console.log(user, "Updated user");

			res.json({ Users: user.toObject({ getters: true }) });
		} else {
			const error = new HttpError("User not found", 404);
			return next(error);
		}
	} catch (err) {
		console.log(err);
		const error = new HttpError("Server error", 500);
		return next(error);
	}
};

const deleteUserById = async (req, res, next) => {
	console.log("HERE!");
	const UserID = req.params._id;
	let User;
	try {
		User = await Users.findById(UserID);
	} catch (err) {
		const error = new HttpError("We could not kill the creator", 418);
		return next(error);
	}
	if (User) {
		try {
			User.remove();
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

const getAllUsers = async (req, res, next) => {
	let User;
	try {
		User = await Users.find();
	} catch (err) {
		const error = new HttpError("The door was locked we couldnt get in", 418);
		return next(error);
	}
	console.log(User);
	if (!User || User.length == 0) {
		const error = new HttpError("All Creators died horribly", 404);
		return next(error);
	}
	res.json(User);
};

// id haku usernamen ja passwordin avulla
const getUserById = async (req, res, next) => {
	const UserId = req.params._id;
	console.log(UserId);
	console.log(req.params._id);
	console.log("You are here");
	let User;
	try {
		User = await Users.findById(UserId);
	} catch (err) {
		console.log("IMHERE");
		return next(new HttpError("BOOOM!!! creator not found!", 418));
	}
	console.log(User + "Objekti");
	if (!User) {
		console.log("KOSH!");

		return next(new HttpError("BOOOM!!! user not found!", 418));
	}
	res.json({ User });
};

exports.getAllUsers = getAllUsers;
exports.getUserById = getUserById;
exports.createdUser = createdUser;
exports.updateUserById = updateUserById;
exports.deleteUserById = deleteUserById;
