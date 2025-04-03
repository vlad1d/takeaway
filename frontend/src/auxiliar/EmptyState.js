import React from "react";
import { motion } from "framer-motion";
import "./EmptyState.css";

function EmptyState() {
    return (
        <motion.div
            className="curr-state"
            initial={{ scale: 0.8, opacity: 0 }}
            animate={{ scale: 1, opacity: 1 }}
            transition={{ duration: 0.6, ease: 'easeOut' }}
        >
            <p>Oops! No restaurants found.</p>
            <img src="/plate.png" className="curr-img" />
            <p>Try another postcode?</p>
        </motion.div>
    );
}

export default EmptyState;