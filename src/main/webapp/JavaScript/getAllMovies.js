/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * <!-- Movie Fields:
 private String name; // Name of the movie.
 private Date releaseDate; // Date the movie was released. 
 private int rating; // Rating of the movie. 1-10.
 private boolean showing; // Is the movie currently showing in cinemas. 
 private long ticketsSold; // INTERNAL INFO - How many tickets sold to this movie. 
 -->
 */

/**
 [
 {
 "id": 1,
 "name": "Terminator",
 "releaseDate": "Jun 16, 2003",
 "viewerRating": 10,
 "available": false
 },
 {
 "id": 2,
 "name": "The Departed",
 "releaseDate": "Jul 22, 1999",
 "viewerRating": 9,
 "available": false
 }
 ]
 */

// URL OF GET ALL REST ENDPOINT
let URL = "/api/cinema/all";

// Get getAllMoviesButton
let getAllMoviesButton = document.getElementById("getAllMoviesButton");

// Get OutPutReceiver
let OutPutReceiver = document.getElementById("OutPutReceiver");

/**
 * Get Table of data.
 * @param {type} data
 * @returns HTML String that makes a table of the given data. 
 */
function getTable(data) {
    // Take objects out of array. 
    let arrayOfObj = Object.values(data);
    // Make Table Header
    returnString = tableHeader(Object.keys(arrayOfObj[0]));

    // Make Table Body
    for (let i = 0; i < arrayOfObj.length; i++) {
        let bodyArray = Object.values(arrayOfObj[i]);
        returnString += tableRow(bodyArray);
    }

    // End Table and Return it 
    return returnString += endOfTable();

}

// Listener for click. If clicked, populate OutPutReceiver with Data. 
getAllMoviesButton.addEventListener("click", function () {
    // DATA OF GET ALL REST ENDPOINT
    fetch(URL)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {
                // Inside this callback, and only here, the response data is available
                OutPutReceiver.innerHTML = getTable(data);
            });
    
});

