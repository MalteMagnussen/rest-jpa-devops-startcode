package facades;

import dto.MovieDTO;
import entities.Movie;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
//@Disabled
public class MovieFacadeTest {

    private static EntityManagerFactory emf;
    private static MovieFacade facade;
    private static Movie terminator;
    private static List<Movie> movies = new ArrayList<>();

    public MovieFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
    }

    @AfterAll
    public static void tearDownClass() {

    }

    @BeforeEach
    public void setUp() {
        facade = MovieFacade.getMovieFacade(emf);
        terminator = new Movie("Terminator", Date.valueOf("1984-2-15"), 8, false, 100000);
        movies.add(terminator);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNativeQuery("DELETE FROM MOVIE").executeUpdate();
            em.persist(terminator);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {

    }
    
    @Test
    public void testGetMovieByName() throws Exception {
        //Arrange 
        MovieDTO expResult = new MovieDTO(terminator);
        //Act
        MovieDTO result = facade.getMovieDTOByName("Terminator");
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMovieCount() {
        // Arrange
        Long expResult = 1l;
        // Act
        Long result = facade.getMovieCount();
        // Assert
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetTicketSales() {
        //Arrange
        Long expResult = terminator.getTicketsSold();
        //Act
        Long result = facade.getTicketSales(1);
        //Assert
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetAllMovies() {
        //Arrange
        List<MovieDTO> expResult = new ArrayList<>();
        expResult.add(new MovieDTO(terminator));
        //Act
        List<MovieDTO> result = facade.getAllMoviesDTO();
        //Assert
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testGetMovieDTO() {
        //Arrange 
        MovieDTO expResult = new MovieDTO(terminator);
        //Act
        Long id = 1l;
        MovieDTO result = facade.getMovieDTOById(id);
        //Assert
        assertEquals(expResult, result);
    }

    @org.junit.jupiter.api.Test
    public void testMakeMovie() {
        //Arrange
        Movie terminator2 = new Movie("Terminator 2: Judgment Day", Date.valueOf("1991-11-08"), 9, false, 200000);
        //Act
        Movie result = facade.makeMovie(terminator2);
        //Assert
        assertEquals(terminator2, result);
        // Removing the user again so it doesn't mess up the other tests.
        EntityManager em = emf.createEntityManager();
        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();
            em.remove(em.find(Movie.class, new Long(movies.size() + 1)));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
