"use client"

import { motion } from "framer-motion"
import "./LoadingState.css"

function LoadingState() {
  return (
    <motion.div
      className="l-state"
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      exit={{ opacity: 0 }}
      transition={{ duration: 0.5 }}
    >
      <div className="l-content">
        <motion.div
          className="l-icon"
          animate={{
            rotate: 360,
            scale: [1, 1.2, 1],
          }}
          transition={{
            rotate: { duration: 2, repeat: Number.POSITIVE_INFINITY, ease: "linear" },
            scale: { duration: 1, repeat: Number.POSITIVE_INFINITY, ease: "easeInOut" },
          }}
        >
          <img src="/logo-white.png" alt="Loading" />
        </motion.div>
        <p>Finding restaurants...</p>
      </div>
    </motion.div>
  )
}

export default LoadingState

