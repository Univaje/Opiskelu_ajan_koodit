import { useState } from "react";
import { useHistory } from "react-router-dom";
import "./Register.css";

export const Register = () => {
	const [name, setName] = useState("");
	const [username, setUsername] = useState("");
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const [errorMessage, setErrorMessage] = useState("");

	const history = useHistory();

	const handleNameChange = (e) => {
		setName(e.target.value);
	};

	const handleEmailChange = (e) => {
		setEmail(e.target.value);
	};

	const handlePasswordChange = (e) => {
		setPassword(e.target.value);
	};

	const handleUsernameChange = (e) => {
		setUsername(e.target.value);
	};

	const handleSubmit = async (e) => {
		e.preventDefault();

		const response = await fetch("http://localhost:5000/api/user/MAKEABOMB/", {
			method: "POST",
			headers: {
				"Content-Type": "application/json",
			},
			body: JSON.stringify({
				Name: name,
				Username: username,
				Email: email,
				Password: password,
			}),
		});

		if (response.ok) {
			localStorage.setItem("user", JSON.stringify({ Email: email }));
			history.push("/home"); // Redirect to home page
		} else {
			const data = await response.json();
			console.log(data.message);
			setErrorMessage(data.message);
		}
	};

	return (
		<div className="tausta">
			<div className="register-form">
				<h2>Rekisteröidy</h2>
				<form onSubmit={handleSubmit}>
					<label htmlFor="usernameInput">Käyttäjänimi:</label>
					<input
						id="usernameInput"
						type="text"
						value={username}
						onChange={handleUsernameChange}
						required
					/>
					<label htmlFor="emailInput">Sähköposti:</label>
					<input
						id="emailInput"
						type="email"
						value={email}
						onChange={handleEmailChange}
						required
					/>
					<label htmlFor="nameInput">Nimi:</label>
					<input
						id="nameInput"
						type="text"
						value={name}
						onChange={handleNameChange}
						required
					/>
					<label htmlFor="passwordInput">Salasana:</label>
					<input
						id="passwordInput"
						type="password"
						value={password}
						onChange={handlePasswordChange}
						required
					/>
					<button id="registerBtn" type="submit">
						Rekisteröidy
					</button>
					{errorMessage && <p className="error-message">{errorMessage}</p>}
				</form>
			</div>

		</div>
	);
};
