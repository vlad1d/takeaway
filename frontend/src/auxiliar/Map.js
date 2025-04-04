import React from "react";
import { motion } from "framer-motion";
import "./Map.css";

function Map() {
  return (
    <motion.div
      className="map-state"
      initial={{ scale: 0.8, opacity: 0 }}
      animate={{ scale: 1, opacity: 1 }}
      transition={{ duration: 0.6, ease: 'easeOut' }}
    >
      <p className="map-text">Hungry? Let's find food!</p>

      <div className="map-wrapper">
        <img src="/map.png" className="map-img" alt="map of netherlands" />

        <motion.svg
          className="svg-pin"
          width="60"
          height="60"
          viewBox="0 0 30 30"
          fill="red"
          xmlns="http://www.w3.org/2000/svg"
          animate={{ y: [0, -10, 0] }}
          transition={{
            repeat: Infinity, 
            duration: 1.2,
            ease: "easeInOut"
          }}
        >
          <path d="M12 2C8.13 2 5 5.13 5 9c0 5.25 7 13 7 13s7-7.75 7-13c0-3.87-3.13-7-7-7zm0 9.5c-1.38 0-2.5-1.12-2.5-2.5S10.62 6.5 12 6.5 14.5 7.62 14.5 9 13.38 11.5 12 11.5z" />
        </motion.svg>
      </div>
    </motion.div>
  );
}

export default Map;