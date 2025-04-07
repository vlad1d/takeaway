import React from "react";
import "./Header.css";
import { motion } from "framer-motion";

function Header({ postcode, setPostcode, onSearch }) {
  return (
        <header className="header">
            <div className="header-left">
                <motion.img
                    src="/logo-white.png"
                    className="logo"
                    alt="justeat logo white"
                    whileHover={{ rotate: 10, scale: 1.1 }}
                    transition={{ duration: 0.3 }}
                /> 
                <h1>Restaurant Finder </h1>
            </div>
            <div className="sbox">
                <input type="text" placeholder="Postcode..." value={postcode} onChange={(e) => setPostcode(e.target.value)} />
                <button className="sbutton" onClick={onSearch}> Search </button>
            </div>
        </header>
    );
}

export default Header;
