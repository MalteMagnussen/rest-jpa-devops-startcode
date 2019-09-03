package entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
    @NamedQuery(name = "Movie.findAll", query = "SELECT r FROM Movie r"),
    @NamedQuery(name = "Movie.count", query = "SELECT count(r) FROM Movie r")
})
public class Movie implements Serializable {

    // DEFAULT EMPTY CONSTRUCTOR 
    public Movie() {
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID of the movie. 
    private String name; // Name of the movie.
    private Date releaseDate; // Date the movie was released. 
    private int rating; // Rating of the movie. 1-10.
    private boolean showing; // Is the movie currently showing in cinemas. 
    private long ticketsSold; // INTERNAL INFO - How many tickets sold to this movie. 

    public Movie(String name, Date releaseDate, int rating, boolean showing, long ticketsSold) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.showing = showing;
        this.ticketsSold = ticketsSold;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.releaseDate);
        hash = 59 * hash + this.rating;
        hash = 59 * hash + (this.showing ? 1 : 0);
        hash = 59 * hash + (int) (this.ticketsSold ^ (this.ticketsSold >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (this.rating != other.rating) {
            return false;
        }
        if (this.showing != other.showing) {
            return false;
        }
        if (this.ticketsSold != other.ticketsSold) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }

    /**
     * Get the value of ticketsSold
     *
     * @return the value of ticketsSold
     */
    public long getTicketsSold() {
        return ticketsSold;
    }

    /**
     * Set the value of ticketsSold
     *
     * @param ticketsSold new value of ticketsSold
     */
    public void setTicketsSold(long ticketsSold) {
        this.ticketsSold = ticketsSold;
    }

    /**
     * Get the value of showing
     *
     * @return the value of showing
     */
    public boolean isShowing() {
        return showing;
    }

    /**
     * Set the value of showing
     *
     * @param showing new value of showing
     */
    public void setShowing(boolean showing) {
        this.showing = showing;
    }

    /**
     * Get the value of rating
     *
     * @return the value of rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Set the value of rating
     *
     * @param rating new value of rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Get the value of releaseDate
     *
     * @return the value of releaseDate
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * Set the value of releaseDate
     *
     * @param releaseDate new value of releaseDate
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
