import React from "react";
import "./Header.css";

function Header({ postcode, setPostcode, onSearch }) {
    return (
        <header className="header">
            <img src="/logo-white.png" className="logo" alt="justeat logo white"/>
            <h1>Lookup Restaurant :</h1>
            <div className="sbox">
                <input type="text" placeholder="Postcode..." value={postcode} onChange={(e) => setPostcode(e.target.value)} />
                <button className="sbutton" onClick={onSearch}> Search </button>
            </div>
        </header>
    );
}

export default Header;