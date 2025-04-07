"use client"

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

        <motion.img src="/platequestion.png" className="curr-img" alt="Empty plate"
            animate={{
              y: [0, -10, 0],
              rotate: [0, 5, 0, -5, 0],
            }}
            transition={{
              duration: 5,
              repeat: Number.POSITIVE_INFINITY,
              ease: "easeInOut",
            }}
          />
            <h2>Oops! No restaurants found. </h2>
            <p>Try another postcode?</p>
        </motion.div>
    );
}

export default EmptyState;
