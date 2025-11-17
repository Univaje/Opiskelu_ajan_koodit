import React, { useEffect, useState } from "react";
import ReactLoading from "react-loading";
import "./Omasivu.css";

export const Omasivu = ({ userID }) => {
	const [user, setUser] = useState(null);
	const [isLoading, setIsLoading] = useState(false);
	const [isLoadingPictures, setIsLoadingPictures] = useState(false);
	const [formData, setFormData] = useState({
		Name: "",
		Email: "",
		Username: "",
		Password: "",
	});
	const [formError, setFormError] = useState(null);
	const [isSubmitting, setIsSubmitting] = useState(false);
	const [isEditing, setIsEditing] = useState(false);

	const [userPictures, setUserPictures] = useState([]);

	useEffect(() => {
		const fetchUser = async () => {
			setIsLoading(true);

			try {
				const response = await fetch(
					`http://localhost:5000/api/user/${userID}`
				);

				if (response.ok) {
					const data = await response.json();
					setUser(data.User);
				} else {
					console.log("Error occurred while fetching user data");
				}
			} catch (error) {
				console.log("Error: ", error);
			}

			setIsLoading(false);
		};

		fetchUser();
	}, [userID]);

	useEffect(() => {
		const fetchUserPictures = async () => {
			setIsLoadingPictures(true);
			try {
				const response = await fetch(
					`http://localhost:5000/api/picture/user/${userID}`
				);
				if (response.ok) {
					const data = await response.json();
					setUserPictures(data.pictures);
				} else {
					console.log("Error occurred while fetching user pictures");
				}
			} catch (error) {
				console.log("Error: ", error);
			}
		};

		if (userID) {
			fetchUserPictures();
		}

		setIsLoadingPictures(false);
	}, [userID]);

	const handleInputChange = (event) => {
		setFormData({
			...formData,
			[event.target.name]: event.target.value,
		});
	};

	const handleSubmit = async (event) => {
		event.preventDefault();
		setIsSubmitting(true);

		try {
			const response = await fetch(`http://localhost:5000/api/user/${userID}`, {
				method: "PATCH",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(formData),
			});

			if (response.ok) {
				const data = await response.json();
				setUser(data.Users);
				setFormError(null);
				console.log("User updated successfully");
			} else {
				const data = await response.json();
				setFormError(data.message);
			}
		} catch (error) {
			console.log("Error: ", error);
			setFormError("An error occurred while updating the user");
		}

		setIsSubmitting(false);
		setIsEditing(false);
	};

	const handleEdit = () => {
		setIsEditing(true);
	};

	return (
		<div>
			{isLoading ? (
				<p>Loading user data...</p>
			) : (
				user && (
					<>
						{isEditing ? (
							<div className="box">
								<form onSubmit={handleSubmit}>
									<div>
										<label htmlFor="Name">Nimi:</label>
										<input
											type="text"
											name="Name"
											id="Name"
											placeholder={user.Name}
											value={formData.Name}
											onChange={handleInputChange}
											required
										/>
									</div>
									<div>
										<label htmlFor="Username">Username:</label>
										<input
											type="text"
											name="Username"
											id="Username"
											placeholder={user.Username}
											value={formData.Username}
											onChange={handleInputChange}
											required
										/>
									</div>
									<div>
										<label htmlFor="Email">Email:</label>
										<input
											type="email"
											name="Email"
											id="Email"
											placeholder={user.Email}
											value={formData.Email}
											onChange={handleInputChange}
											required
										/>
									</div>
									<div>
										<label htmlFor="Password">Salasana:</label>
										<input
											type="password"
											name="Password"
											id="Password"
											value={formData.Password}
											onChange={handleInputChange}
											required
										/>
									</div>
									{formError && <p className="error">{formError}</p>}
									<button type="submit" disabled={isSubmitting}>
										Päivitä
									</button>
									<button onClick={() => setIsEditing(false)}>Peruuta</button>
								</form>
							</div>
						) : (
							<>
								<div className="box">
									<h2>Tervetuloa, {user.Username}!</h2>
									<p>ID: {user._id}</p>
									<p>Name: {user.Name}</p>
									<p>Email: {user.Email}</p>
									<button onClick={handleEdit}>Muokkaa tietoja</button>
								</div>
							</>
						)}
					</>
				)
			)}
			<div className="box">
				<h2>Kuvat</h2>
				{isLoadingPictures ? (
					<p>Ladataan kuvia...</p>
				) : (
					<>
						{userPictures.map((picture) => (
							<div className="kuva" key={picture._id}>
								<p>{picture.Answer}</p>
							</div>
						))}
					</>
				)}
			</div>
		</div>
	);
};
