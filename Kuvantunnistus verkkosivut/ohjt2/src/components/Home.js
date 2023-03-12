import React, { useState } from "react";
import * as tf from "@tensorflow/tfjs";
import "./Home.css";

export const Home = () => {
	const [image, setImage] = useState(null);
	const [loading, setLoading] = useState(false);

	const handleChange = (e) => {
		setImage(URL.createObjectURL(e.target.files[0]));
	};

	const handleSubmit = async (e) => {
		e.preventDefault();
		setLoading(true);

		// Get the file input element
		const fileInput = document.getElementById("file-input");

		// Check if the file input element exists and has files selected
		if (fileInput && fileInput.files && fileInput.files.length > 0) {
			// Load the model
			const model = await tf.loadLayersModel(
				"http://localhost:5000/model4.json"
			);

			// Load the image data from the file input
			const file = fileInput.files[0];
			const reader = new FileReader();
			reader.onload = async (event) => {
				const img = new Image();
				img.onload = async () => {
					// Preprocess the image
					const tensor = tf.browser
						.fromPixels(img, 1)
						.resizeNearestNeighbor([28, 28])
						.toFloat()
						.div(255.0);
					const input = tensor.reshape([1, 28, 28, 1]);

					// Predict the digit
					const prediction = model.predict(input).dataSync();

					// Find the index of the highest confidence prediction
					const digit = prediction.indexOf(Math.max(...prediction));

					// Log the prediction to the console
					console.log(`Predicted digit: ${digit}`);

					// Cleanup
					tensor.dispose();

					try {
						// Get userdata from localstorage
						const userData = JSON.parse(localStorage.getItem("user"));

						// Send a POST request to the backend to save the answer and other data
						const formData = new FormData();
						formData.append("PicPath", file);
						formData.append("Answer", digit);
						formData.append("UserID", userData._id);
						const response = await fetch(
							"http://localhost:5000/pictures/MAKEABOMB/",
							{
								method: "POST",
								body: formData
							}
						);
						if (response.ok) {
							const data = await response.json();
							console.log("Backend:", data);
						} else {
							console.log(response);
						}
					} catch (error) {
						console.log(error);
					}

					setLoading(false);
				};
				img.src = event.target.result;
			};
			reader.readAsDataURL(file);
		} else {
			console.error("No file selected");
			setLoading(false);
		}
	};

	return (
		<div className="home-container">
			<form onSubmit={handleSubmit}>
				<div className="input-div">
					<input
						type="file"
						name="file"
						id="file-input"
						accept="image/*"
						onChange={handleChange}
					/>
				</div>
				{image && (
					<div className="image-preview">
						<img src={image} alt="Preview" />
						<button
							onClick={() => {
								setImage(null);
								document.querySelector('input[type="file"]').value = "";
							}}
						>
							Poista
						</button>
					</div>
				)}
				<div>
					<button id="homeButton" type="submit" disabled={loading}>
						{loading ? "Uploading..." : "Upload"}
					</button>
				</div>
			</form>
		</div>
	);
};
