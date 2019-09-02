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

    public MovieFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {

    }

    @AfterAll
    public static void tearDownClass() {

    }

    @BeforeEach
    public void setUp() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = MovieFacade.getMovieFacade(emf);
        terminator = new Movie("Terminator", Date.valueOf("1984-2-15"), 8, false, 100000);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
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
    public void testGetTicketSales() {
        //Arrange
        Long expResult = terminator.getTicketsSold();
        //Act
        Long result = facade.getTicketSales(1);
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAllMovies() {
        //Arrange
        List<MovieDTO> expResult = new ArrayList<>();
        expResult.add(new MovieDTO(terminator));
        //Act
        List<MovieDTO> result = facade.getAllMoviesDTO();
        //Assert
        assertEquals(expResult, result);
    }

    @Test
    public void testGetMovieDTO() {
        // Arrange 
        MovieDTO expResult = new MovieDTO(terminator);
        // Act
        MovieDTO result;
        result = facade.getMovieDTOById(1);
        // Assert
        assertEquals(expResult, result);
    }
//Movie terminator2 = new Movie("Terminator 2: Judgment Day", Date.valueOf("1991-11-08"), 9, false, 200000);
}
