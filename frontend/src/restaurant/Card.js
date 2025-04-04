import React from "react";
import { motion } from "framer-motion";
import "./Card.css";

function Card({ restaurant }) {
    return (
        <motion.div
            className="card"
            initial={{ scale: 0.95, opacity: 0 }}
            animate={{ scale: 1, opacity: 1 }}
            whileHover={{ scale: 1.02, boxShadow: "0 6px 12px rgba(0,0,0,0.15)" }}
            whileTap={{ scale: 0.99 }}
            transition={{ duration: 0.2 }}
        >
            <div className="info-left">
                <h2>{restaurant.name}</h2>
                <p>{restaurant.address.firstLine}, {restaurant.address.postalCode}</p>
            </div>

            <div className="info-right">
                <span className="rating">{restaurant.rating.starRating} ⭐</span>
                <span>{restaurant.cuisines.map(c => c.name).join(", ")}</span>
            </div>
        </motion.div>
    );
}

export default Card;