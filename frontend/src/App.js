import React, { useState } from "react";
import "./App.css";
import { motion } from "framer-motion";
import Header from "./components/Header";
import List from "./restaurant/List";
import Footer from "./components/Footer";

function App() {
  const [restaurants, setRestaurants] = useState([]);
  const [postcode, setPostcode] = useState("");

  const fetchRestaurants = async () => {
    try {
      const response = await fetch(`${process.env.REACT_APP_BACKEND_API_URL}/restaurants?postcode=${postcode}`);
      if (!response.ok) {
        throw new Error("Failed to fetch restaurants.");
      }
      
      const data = await response.json();
      setRestaurants(data);
    } catch (error) {
      console.error("Error fetching restaurants:", error);
    }
  };

  return (
    <motion.div
      className="app"
      initial={{ opacity: 0 }}
      animate={{ opacity: 1 }}
      transition={{ duration: 1 }}
    >
      <Header postcode={postcode} setPostcode={setPostcode} onSearch={fetchRestaurants} />
      <List restaurants={restaurants} />
      <Footer />

    </motion.div>
  );
}

export default App;