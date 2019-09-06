<%-- 
    Document   : index
    Created on : Sep 2, 2019, 5:08:51 PM
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
                    <div class="container">

                        <h1> Make a Movie </h1>

                        <form method="POST" action="FrontController">
                            <input type="hidden" name="command" value="makeMovie">
                            <div class="form-group">
                                <label for="inputName">Name of the movie</label>
                                <input type="text" name="name" class="form-control" id="inputName" placeholder="Enter movie name" required>
                            </div>
                            <div class="form-group">
                                <label for="releaseDate">Release Date</label>
                                <input type="date" name="date" class="form-control" id="releaseDate" required>
                            </div>
                            <div class="form-group">
                                <label for="rating">Rating</label>
                                <input type="int" name="rating" class="form-control" id="rating" min="1" max="10" required>
                                <small id="rating" class="form-text text-muted">int from 1 to 10.</small>
                            </div>
                            <div class="form-group form-check">
                                <input type="checkbox" class="form-check-input" id="showing" name="showing" value="yes">
                                <label class="form-check-label" for="showing">Is movie still showing in theaters?</label>
                            </div>
                            <div class="form-group">
                                <label for="ticketsSold">How many tickets the movie has sold.</label>
                                <input type="Long" name="ticketsSold" class="form-control" id="ticketsSold" required>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                    <div class="container">
                        <h4> REST API ENDPOINTS: <br>
                            /api/cinema/all <br>
                            /api/cinema/tickets/{id} <br>
                            /api/cinema/test <br>
                            /api/cinema/{id} <br>
                            /api/cinema/name/{name} <br>
                            /api/cinema/count <br>
                        </h4>
                    </div>
                    <div class="container">
                        <c:if test="${not empty output}">
                            <h1> OUTPUT </h1>
                            <p>${output}</p>
                        </c:if>
                    </div>
                    <div class="container">
                        GitHub at: https://github.com/MalteMagnussen/rest-jpa-devops-startcode
                    </div>

                    <div style="height: 700px"></div>
                </div>
            </div>
        </div>

        <!-- JQUERY JS -->
        <script src="https://code.jquery.com/jquery-3.4.0.min.js" crossorigin="anonymous"></script>
        <!-- BOOTSTRAP JS -->
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    </body>
</html>
