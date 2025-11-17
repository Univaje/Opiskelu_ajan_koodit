import { useState } from "react";
import { useHistory } from "react-router-dom";
import "./Login.css";

export const Login = ({ setUserEmail, setUserID }) => {
	const [email, setEmail] = useState("");
	const [password, setPassword] = useState("");
	const [errorMessage, setErrorMessage] = useState("");

	const history = useHistory();

	const handleEmailChange = (e) => {
		setEmail(e.target.value);
	};

	const handlePasswordChange = (e) => {
		setPassword(e.target.value);
	};

	const handleRegisterClick = () => {
		history.push("/register"); // navigate to the registration page
	};

	const handleSubmit = async (e) => {
		e.preventDefault();
		try {
			const response = await fetch("http://localhost:5000/api/user/");
			if (response.ok) {
				const data = await response.json();
				const user = data.find(
					(user) => user.Email === email && user.Password === password
				);
				if (user) {
					localStorage.setItem("user", JSON.stringify(user));
					setUserEmail(user.Email);
					setUserID(user._id);
					history.push("/home");
				} else {
					setErrorMessage("Invalid email or password");
				}
			} else {
				setErrorMessage("Error occurred while logging in");
			}
		} catch (error) {
			setErrorMessage("Error: " + error );
		}
	};
	return (
		<div id="tausta">
			<form className="login-form" onSubmit={handleSubmit}>
				<label>Sähköposti:</label>
				<input type="email" value={email} onChange={handleEmailChange} />
				<label>Salasana:</label>
				<input
					type="password"
					value={password}
					onChange={handlePasswordChange}
				/>
				<button id="loginBtn" type="submit">
					Kirjaudu sisään
				</button>
				<p>
					Ei käyttäjää vielä?{" "}
					<span className="register-link" onClick={handleRegisterClick}>
						Rekisteröidy
					</span>
				</p>
				{errorMessage && <p className="error-message">{errorMessage}</p>}
			</form>
		</div>
	);
};
