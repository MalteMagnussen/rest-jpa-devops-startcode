<%-- 
    Document   : watch
    Created on : Sep 6, 2019, 8:56:06 AM
    Author     : Malte
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Make Movie</title>

        <!--The following tag is the JSTL Expression Language tag-->
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!-- Insert bootstrap CSS - integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">

        <!-- Background stylesheet -->
        <link href="css/BackgroundImage.css" rel="stylesheet" type="text/css">

    </head>
    <body>

        <!-- Page Content -->
        <div class="container">
            <div class="card border-0 shadow my-5">
                <div class="card-body p-5">

                    <!-- 
                    private String name; // Name of the movie.
                    private Date releaseDate; // Date the movie was released. 
                    private int rating; // Rating of the movie. 1-10.
                    private boolean showing; // Is the movie currently showing in cinemas. 
                    private long ticketsSold; // INTERNAL INFO - How many tickets sold to this movie. 
                    -->

                    <!--
                    REST API ENDPOINTS:
                        /api/cinema/all
                        /api/cinema/tickets/{id}
                        /api/cinema/test
                        /api/cinema/{id}
                        /api/cinema/name/{name}
                        /api/cinema/count
                    -->

                    <!-- TODO 
                    
                    Get all movies
                    Get Movie by ID
                    Get Movie by Name
                    Get Number of Movies
                    
                    -->

                    <!-- Button and Input field Container -->
                    <div class="container">

                        <button id="getAllMoviesButton" class="btn btn-primary">Get All Movies</button>

                    </div>

                    <!-- OutPut container -->
                    <div class="container">

                        <per id="OutPutReceiver">

                        </per>

                    </div>


                    <div style="height: 700px"></div>
                </div>
            </div>
        </div>

        <!-- JQUERY JS -->
        <script src="https://code.jquery.com/jquery-3.4.0.min.js" crossorigin="anonymous"></script>
        <!-- BOOTSTRAP JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>

        <!-- My Custom JavaScript -->
        
        <!-- Get All Movies JavaScript -->
        <script src="JavaScript/getAllMovies.js"></script>
        <!-- Fetch JSON helper -->
        <script src="JavaScript/fetchJson.js"></script>
        <!-- Table Helper JavaScript -->
        <script src="JavaScript/tableHelper.js"></script>

    </body>
</html>
