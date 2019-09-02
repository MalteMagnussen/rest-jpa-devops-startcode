/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import entities.Movie;
import facades.MovieFacade;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Malte
 */
public class MakeMovieCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, MovieFacade facade) {

        // Input from HTML form
        String name = request.getParameter("name");
        System.out.println("NAME: " + name);
        String date = request.getParameter("date");
        Date releaseDate = Date.valueOf(date); 
        System.out.println("DATE: " + releaseDate);
        int rating = Integer.parseInt(request.getParameter("rating"));
        System.out.println("RATING: " + rating);
        boolean showing = false;
        if (request.getParameter("showing") != null) {
            showing = true;
        }
        System.out.println("SHOWING: " + showing);
        Long ticketsSold = Long.parseLong(request.getParameter("ticketsSold"));
        System.out.println("TICKETS SOLD: " + ticketsSold);

        request.setAttribute("output",
                "NAME: " + name
                + "\nDATE: " + releaseDate
                + "\nRATING: " + rating
                + "\nSHOWING: " + showing
                + "\nTICKETS SOLD: " + ticketsSold);

        Movie movie = new Movie(name, releaseDate, rating, showing, ticketsSold);

        facade.makeMovie(movie);

        // This is not implemented yet. Target isn't used at all. 
        return "index";
    }

}
