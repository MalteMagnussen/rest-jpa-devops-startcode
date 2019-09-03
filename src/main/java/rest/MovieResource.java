package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;
import facades.MovieFacade;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("cinema")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    private static final MovieFacade FACADE = MovieFacade.getMovieFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    // 1.
    @Path("/test")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String hello() {
        return "{\"hello\":\"world\"}";
    }
    
    // 2. 
    @Path("/count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieCount() {
        return "{\"moviecount\":"+FACADE.getMovieCount()+"}";
    }
    
    /**
     * Get Number of Tickets Sold.
     *
     * @param id of the Movie.
     * @return Number of Tickets Sold.
     */
    @Path("/tickets/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getTicketSales(@PathParam("id") int id) {
        return GSON.toJson(FACADE.getTicketSales(id));
    }

    //3.
    /**
     * Get all movies as DTO.
     * @return 
     */
    @Path("/all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllMovies() {
        return GSON.toJson(FACADE.getAllMoviesDTO());
    }
  
    //4.
    @Path("/name/{name}")    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieByName(@PathParam("name") String name) {
        try {
            return GSON.toJson(FACADE.getMovieDTOByName(name));
        } catch (Exception ex) {
            return "{\"errormessage\":\"Movie does not exist\"}";
        }
    }
    
    
    //5. 
    /**
     * Get single movie as DTO
     * @param id
     * @return 
     */
    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieDTOById(@PathParam("id") int id) {
        return GSON.toJson(FACADE.getMovieDTOById(new Long(id)));
    }
}
