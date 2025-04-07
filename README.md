# JustEat Coding Assignment

## Description
This project is a (simple) full-stack application for a food delivery platform similar to Just Eat. It consists of:
- A **Spring Boot backend** that provides an API to fetch restaurant information based on user location (postcode), returning the name of the restaurant, cuisines, ratings, and address. The data is fetched from an external API.
- A **React frontend** that allows users to interact with the platform, search for restaurants, and view the results in a user-friendly interface.

## Running the Application
### Running the Backend
```bash
cd takeaway/backend
./mvnw clean install
./mvnw spring-boot:run
```

### Running the Frontend
```bash
cd takeaway/frontend # or cd ../frontend if in backend directory
npm install
npm start
```

<span style="color:red">Important: For easier setup, the .env file was made available. This should under no circumstances be shared publicly otherwise. </span>


After that, open `http://localhost:3000` in your browser.

## Functionality

### Requirements
The application meets the following requirements:
- All four restaurant data points are displayed in your interface (name, cuisines, rating-as a number and address) <br>
`` All four restaurant data points are displayed in cards upon lookup of a valid postcode in the search bar. ``

### Additional Features
The following additional pages are included for an enhanced user experience:
- Home Page: A landing page with a search bar for users to enter their postcode.
- Loading Page: A simple logo spinner to indicate that the application is fetching data.
- Error Page: A page that displays an error message if the postcode is invalid or if there are no restaurants found.

### Further Improvements
The application could be improved by adding more features such as:
- Restaurant specific pages with more details (e.g. menu, opening hours);
- A favorites feature to save preferred restaurants;
- A more sophisticated search functionality (e.g. search by your location).

The code could be improved by:
- Extending API to support full CRUD functionality;
- Adding more advanced unit tests for the backend components;
- Implementing more detailed error handling;
- Dockerizing the application for easier deployment.

## Assumptions
The following assumptions were made during the development of the application:
- The user is familiar with the concept of food delivery platforms and understands how to use a search bar.
- JavaScript can run in the browser and is supported by the user's device.
- The external API is reliable and returns valid data.
- Ratings are provided strictly in the "starRating" field.
- Displaying the first line, city and postcode of the address field is sufficient for the user.
- The following fields are always present in the API response: `name`, `cuisines`, `rating`, and `address`.

## Contact
    Vlad Ichim | 0681097927 | vladichim17@yahoo.ro

## Appendix
![Frontend Sketch](/frontend/public/sketch.png)