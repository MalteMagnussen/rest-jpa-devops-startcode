package facades;

import dto.MovieDTO;
import entities.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class MovieFacade {

    private static MovieFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private MovieFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static MovieFacade getMovieFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new MovieFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Get Ticket Sales for a Movie by ID. 
     * To be used internally only. 
     * @param id of the Movie.
     * @return Number of Ticket sales as a Long. 
     */
    public Long getTicketSales(int id) {
        EntityManager em = getEntityManager();
        Movie movie = (Movie) em.createNamedQuery("Movie.getById").setParameter("id", id).getSingleResult();
        return movie.getTicketsSold();
    }

    public List<MovieDTO> getAllMovies() {
        EntityManager em = getEntityManager();
        List<Movie> movies = new ArrayList<>();
        movies = em.createNamedQuery("Movie.findAll").getResultList();
        List<MovieDTO> result = new ArrayList<>();
        for (Movie movie: movies) {
            result.add(new MovieDTO(movie));
        }
        return result;
    }
    
    

}
