import React from "react";
import "./Footer.css";

function Footer( {show} ) {
    return (
        <footer className="footer">
            {show && (
            <span className="scroll-top" onClick={() => window.scrollTo({ top: 0, behavior: "smooth" })}> ⌃ </span>
            )}
        </footer>
    );
}

export default Footer;