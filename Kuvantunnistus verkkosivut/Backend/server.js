const express = require("express");
const bodyParser = require("body-parser");
const mongoose = require("mongoose");
const Picture = require("./Routes/Picture-routes");
const User = require("./Routes/User-routes");
const AI = require("./Routes/AI-routes");
const HttpError = require("./models/http-error");
const cors = require("cors"); // import cors middleware
mongoose.set("strictQuery", true);
const server = express();

server.use(bodyParser.json());

server.use(cors()); // enable cors middleware for all routes
server.use(express.static("public"));
server.use("/api/Picture", Picture);
server.use("/api/User", User);
server.use("/api/AI", AI);
server.use((req, res, next) => {
	const error = new HttpError("Door was locked", 418);
	throw error;
});
server.use((error, req, res, next) => {
	if (res.headerSent) {
		return next(error);
	}
	res.status(error.code || 500);
	res.json({ message: error.message || "Unknown explosion" });
});

mongoose
	.connect(
		"mongodb+srv://Oppenheimer:ManhattanUser345@cluster0.q9b5wja.mongodb.net/AbombDB?retryWrites=true&w=majority"
	)
	.then(() => {
		server.listen(5000);
	})
	.catch((err) => {
		console.log(err);
	});
