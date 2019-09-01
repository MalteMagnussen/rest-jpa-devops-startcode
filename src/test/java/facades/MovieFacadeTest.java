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
    private static Movie terminator = new Movie("Terminator", Date.valueOf("1984-2-15"), 8, false, 100000);
    
    public MovieFacadeTest() {
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = MovieFacade.getMovieFacade(emf);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
//            em.createNamedQuery("RenameMe.deleteAllRows").executeUpdate();
            // em.createQuery("DELETE from RenameMe").executeUpdate();
            em.persist(terminator);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
//        EntityManager em = emf.createEntityManager();
//        try {
//            em.getTransaction().begin();
//            em.remove(terminator);
//            em.getTransaction().commit();
//        } finally {
//            em.close();
//        }
    }
    
    @Test
    public void testGetTicketSales() {
        //Arrange
        Long expResult = terminator.getTicketsSold();
        //Act
        Long result = facade.getTicketSales(1);
        //Assert
        assertEquals(expResult,result);
    }
    
    @Test
    public void testGetAllMovies() {
        //Arrange
        List<MovieDTO> expResult = new ArrayList<>();
        expResult.add(new MovieDTO(terminator));
        //Act
        List<MovieDTO> result = facade.getAllMovies();
        //Assert
        assertEquals(expResult, result);
    }
    
}
