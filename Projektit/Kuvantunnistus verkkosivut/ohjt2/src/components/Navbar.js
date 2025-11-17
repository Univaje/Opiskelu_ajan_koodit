import { useEffect } from "react";
import { Link } from "react-router-dom";
import TopAIlogo from "../images/TopAI-logo.png";
import "./Navbar.css";

export const Navbar = ({ setUserEmail, userEmail }) => {
	useEffect(() => {
		const user = JSON.parse(localStorage.getItem("user"));
		if (user) {
			setUserEmail(user.Email);
		}
	}, [setUserEmail, userEmail]);

	const handleLogout = () => {
		localStorage.removeItem("user");
		setUserEmail("");
	};

	return (
		<nav className="navbar">
			<div className="navbar-logo">
				<Link to="/home">
					<img src={TopAIlogo} alt="Company logo" />
				</Link>
			</div>
			<ul className="navbar-links">
				<li className="nav-item">
					<Link to="/" className="nav-link">
						Etusivu
					</Link>
				</li>
				<li className="nav-item">
					<Link to="/pictures" className="nav-link">
						Kuvat
					</Link>
				</li>
				{userEmail ? (
					<>
						<li className="nav-item">
							<Link to="/omasivu" className="nav-link">
								Omasivu
							</Link>
						</li>
						<li className="nav-item">
							<Link to="/" className="nav-link" onClick={handleLogout}>
								Kirjaudu ulos
							</Link>
						</li>
					</>
				) : (
					<>
						<li className="nav-item">
							<Link to="/login" className="nav-link">
								Kirjaudu
							</Link>
						</li>
						<li className="nav-item">
							<Link to="/register" className="nav-link">
								Rekisteröidy
							</Link>
						</li>
					</>
				)}
			</ul>
		</nav>
	);
};
