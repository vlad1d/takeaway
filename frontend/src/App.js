import React, { useState } from "react";
import "./App.css";
import { motion } from "framer-motion";
import Header from "./components/Header";
import List from "./restaurant/List";
import Footer from "./components/Footer";
import EmptyState from "./auxiliar/EmptyState";
import Map from "./auxiliar/Map";
import LoadingState from "./auxiliar/LoadingState";
import Filter from "./components/Filter";

function App() {
  const [restaurants, setRestaurants] = useState([]);
  const [postcode, setPostcode] = useState("");
  const [fetchCompleted, setFetchCompleted] = useState(false);
  const [isLoading, setIsLoading] = useState(false);
  const [filters, setFilters] = useState({
    cuisine: "",
    minRating: 0,
    sortBy: "rating", // default sort is by rating
  });

  // we do not know the cuisines in advance so we need to get them from the restaurants (unique by different postcodes)
  const allCuisines = restaurants.flatMap((restaurant) => restaurant.cuisines.map((cuisine) => cuisine.name)); // get all cuisines from the restaurants
  const uniqueCuisines = [...new Set(allCuisines)]; // get unique cuisines

  const filteredRestaurants = restaurants
    .filter((restaurant) => {
      // filter by cuisine if a cuisine is selected
      if (filters.cuisine) {
        return restaurant.cuisines.some((c) => c.name === filters.cuisine);
      }
      return true;
    })
    .filter((restaurant) => {
      // filter by minimum rating
      return restaurant.rating.starRating >= filters.minRating;
    })
    .sort((a, b) => {
      // sort by rating or name
      if (filters.sortBy === "rating") {
        return b.rating.starRating - a.rating.starRating;
      }
      if (filters.sortBy === "name") {
        return a.name.localeCompare(b.name);
      }
      return 0;
    });

  const fetchRestaurants = async () => {
    try {
      setFetchCompleted(false);
      setIsLoading(true);
      // get the restaurants from the backend
      const response = await fetch(`${process.env.REACT_APP_BACKEND_API_URL}/restaurants?postcode=${postcode}`);
      if (!response.ok) {
        // error, do not continue
        throw new Error("Failed to fetch restaurants.");
      }
      // parse the response and .json it (for parsing)
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
      ): ( fetchCompleted && restaurants.length === 0 ? <EmptyState /> : (
        <>
          <Filter filters={filters} setFilters={setFilters} cuisines={uniqueCuisines} resultCount={filteredRestaurants.length} totalCount={restaurants.length} />
          <List restaurants={filteredRestaurants} />
        </>

      ))}
      <Footer show={restaurants.length > 0}/>
    </motion.div>
  );
}

export default App;