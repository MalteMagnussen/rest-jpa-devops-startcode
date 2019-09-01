/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Movie;
import java.sql.Date;

/**
 *
 * @author Malte
 */
public class MovieDTO {
    // FIELDS
    private Long id; // ID of the movie. 
    private String name; // Name of the movie.
    private Date releaseDate; // Date the movie was released. 
    private int viewerRating; // Rating of the movie. 1-10.
    private boolean available; // Is the movie currently showing in cinemas. 

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.name = movie.getName();
        this.releaseDate = movie.getReleaseDate();
        this.viewerRating = movie.getRating();
        this.available = movie.isShowing();
                
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getViewerRating() {
        return viewerRating;
    }

    public void setViewerRating(int viewerRating) {
        this.viewerRating = viewerRating;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    
    
}
