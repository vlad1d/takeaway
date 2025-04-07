"use client";

import { motion } from "framer-motion";
import "./Filter.css";

function Filter({ filters, setFilters, cuisines, resultCount, totalCount }) {

  // handle the cuisine change by calling set filters with cuisine value
  const handleCuisineChange = (e) => {
    setFilters({ ...filters, cuisine: e.target.value });
  };

  // handle the rating change by calling set filters with rating value
  const handleRatingChange = (e) => {
    setFilters({ ...filters, minRating: Number.parseFloat(e.target.value) });
  };

  // sort the change by calling set filters with sort value
  const handleSortChange = (e) => {
    setFilters({ ...filters, sortBy: e.target.value });
  };

  // reset the filters
  const clearFilters = () => {
    setFilters({
      cuisine: "",
      minRating: 0,
      sortBy: "rating",
    });
  };

  return (
    <div className="fbar">
      <div className="fhead">
        <h2>Filter Results</h2>
      </div>

      <div className="filters">
        <div className="filter-group">
          <label htmlFor="cuisine">Cuisine:</label>
          <select id="cuisine" value={filters.cuisine} onChange={handleCuisineChange}>
            <option value="">All Cuisines</option>
            {cuisines.map((cuisine, index) => ( <option key={index} value={cuisine}> {cuisine} </option> ))}
          </select>
        </div>
        
        <div className="filter-group">
          <label htmlFor="rating">Min Rating:</label>
          <select id="rating" value={filters.minRating} onChange={handleRatingChange}>
            <option value="0">Any Rating</option>
            <option value="3">3+ Stars</option>
            <option value="4">4+ Stars</option>
          </select>
        </div>

        <div className="filter-group">
          <label htmlFor="sort">Sort By:</label>
          <select id="sort" value={filters.sortBy} onChange={handleSortChange}>
            <option value="rating">Highest Rating</option>
            <option value="name">Name (A-Z)</option>
          </select>
        </div>

        <motion.button
          className="clear-filters"
          onClick={clearFilters}
          whileHover={{ scale: 1.05 }}
          whileTap={{ scale: 0.95 }}
        > Clear Filters </motion.button>
      </div>
    </div> 
  );
}

export default Filter;
