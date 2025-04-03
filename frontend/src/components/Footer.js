import React from "react";
import "./Footer.css";

function Footer() {
    return (
        <footer className="footer">
            <span className="scroll-top" onClick={() => window.scrollTo({ top: 0, behavior: "smooth" })}> ⌃ </span>
        </footer>
    );
}

export default Footer;