import React, { useState } from "react";
import "./App.css";
import { motion } from "framer-motion";
import Header from "./components/Header";
import List from "./restaurant/List";
import Footer from "./components/Footer";
import EmptyState from "./auxiliar/EmptyState";
import Map from "./auxiliar/Map";
import LoadingState from "./auxiliar/LoadingState";

function App() {
  const [restaurants, setRestaurants] = useState([]);
  const [postcode, setPostcode] = useState("");
  const [fetchCompleted, setFetchCompleted] = useState(false);
  const [isLoading, setIsLoading] = useState(false);

  const fetchRestaurants = async () => {
    try {
      setFetchCompleted(false);
      setIsLoading(true);
      const response = await fetch(`${process.env.REACT_APP_BACKEND_API_URL}/restaurants?postcode=${postcode}`);
      if (!response.ok) {
        throw new Error("Failed to fetch restaurants.");
      }

      const data = await response.json();
      setRestaurants(data);
    } catch (error) {
      console.error("Error fetching restaurants:", error);
      setRestaurants([]);
    } finally {
      setIsLoading(false);
      setFetchCompleted(true);
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
      {isLoading ? (
        <LoadingState />
      ) : !fetchCompleted ? (
        <Map />
      ): ( fetchCompleted && restaurants.length === 0 ? <EmptyState /> : <List restaurants={restaurants} />
      )}
      <Footer show={restaurants.length > 0}/>
    </motion.div>
  );
}

export default App;