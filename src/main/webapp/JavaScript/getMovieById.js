/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 {
 "id": 1,
 "name": "Terminator",
 "releaseDate": "feb. 14, 1984",
 "viewerRating": 8,
 "available": false
 }
 */

// Get getIdOfPersonButton
let getIdOfMovieButton = document.getElementById("getIdOfMovieButton");

/**
 * Get Table of data.
 * @param {type} data
 * @returns HTML String that makes a table of the given data. 
 */
function getIdTable(data) {
    // Make Table Header
    returnString = tableHeader(Object.keys(data));

    // Make the Table Body
    returnString += tableRow(Object.values(data));

    // End Table and Return it 
    return returnString += endOfTable();

}

// Listener for click. If clicked, populate OutPutReceiver with Data. 
getIdOfMovieButton.addEventListener("click", function () {

    // Value of number field with ID. 
    let idOfMovie = document.getElementById("idOfMovie").value;

    // URL OF GET ALL REST ENDPOINT
    let URL = "/devops/api/cinema/" + idOfMovie;

    // DATA OF GET ALL REST ENDPOINT
    fetch(URL)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {

                // Get OutPutReceiver
                let OutPutReceiver = document.getElementById("OutPutReceiver");

                // Inside this callback, and only here, the response data is available
                OutPutReceiver.innerHTML = getIdTable(data);
            });
});

