import React, { useState, useEffect } from "react";
import "./Footer.css";

export const Footer = () => {
	const [showFooter, setShowFooter] = useState(false);

	useEffect(() => {
		const handleScroll = () => {
			const isScrolledToBottom =
				window.innerHeight + window.scrollY >= document.body.offsetHeight;
			setShowFooter(isScrolledToBottom);
		};
		window.addEventListener("scroll", handleScroll);
		return () => {
			window.removeEventListener("scroll", handleScroll);
		};
	}, []);

	return (
		<div className={`footer ${showFooter ? "show" : "hide"}`}>
			{/* <p>TopAI Oy</p>
			<p>contact@topaihub.com</p>
			<p>VAT no: FI33220659</p>
			<p>© 2023 TopAI Oy</p> */}
		</div>
	);
};
