import React, { useState, useEffect } from "react";
import { Card } from "react-bootstrap";
import ReactLoading from "react-loading";
import "./Pictures.css";

export const Pictures = () => {
	const [pictures, setPictures] = useState([]);
	const [isLoading, setIsLoading] = useState(true);
	const [imagesLoaded, setImagesLoaded] = useState(false);
	const [error, setError] = useState(null);

	useEffect(() => {
		const fetchPictures = async () => {
			try {
				const response = await fetch("http://localhost:5000/api/picture");
				if (response.ok) {
					const data = await response.json();
					setPictures(data);
				} else {
					setError("Error occurred while fetching pictures");
				}
			} catch (error) {
				setError("Error occurred while fetching pictures");
			}
			setTimeout(() => {
				setIsLoading(false);
			}, 2000);
		};
		fetchPictures();
	}, []);

	const renderCard = (picture) => {
		return (
			<Card key={picture._id} className="my-3 p-3 rounded">
				<Card.Img
					onLoad={() => setImagesLoaded(true)}
					src={picture.PicPath}
					variant="top"
				/>
				<Card.Body>
					<Card.Text>
						<strong>Vastaus:</strong> {picture.Answer}
					</Card.Text>
				</Card.Body>
			</Card>
		);
	};

	return (
		<div>
			<h2>Pictures</h2>
			<div className="main">
				{isLoading ? (
					<ReactLoading
						type={"bars"}
						color={"#000000"}
						height={100}
						width={100}
					/>
				) : pictures.length === 0 ? (
					<p>Kuvia ei löytynyt.</p>
				) : (
					pictures.map((picture) => renderCard(picture))
				)}
				{error && <p>{error}</p>}
			</div>
		</div>
	);
};
