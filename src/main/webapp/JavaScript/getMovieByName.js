/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/*
{
  "id": 1,
  "name": "Terminator",
  "releaseDate": "Jun 16, 2003",
  "viewerRating": 10,
  "available": false
}
 */

// Get getIdOfPersonButton
let getNameOfMovieButton = document.getElementById("getNameOfMovieButton");

// Listener for click. If clicked, populate OutPutReceiver with Data. 
getNameOfMovieButton.addEventListener("click", function () {

    // Value of number field with ID. 
    let idOfMovie = document.getElementById("idOfMovie").value;

    // URL OF GET ALL REST ENDPOINT
    let URL = "/devops/api/cinema/name/" + idOfMovie;

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
