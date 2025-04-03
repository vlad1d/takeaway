import React from "react";
import Card from "./Card.js";
import "./List.css";

function List({ restaurants }) {
    return (
        <main className="list"> {restaurants.map((rest, i) => (<Card key={i} restaurant={rest} index={i} />))}</main>
    );
}

export default List;