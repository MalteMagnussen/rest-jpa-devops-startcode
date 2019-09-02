/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import facades.MovieFacade;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Malte
 */
public abstract class Command {
    private static HashMap<String, Command> commands;

    private static void initCommands()
    {
        commands = new HashMap<>();
        commands.put("makeMovie", new MakeMovieCommand()); // Insert a movie into the database.
    }

    public static Command from(HttpServletRequest request)
    {
        String commandName = request.getParameter("command");
        if (commands == null)
        {
            initCommands();
        }
        return commands.get(commandName);
    }

    public abstract String execute(HttpServletRequest request, MovieFacade logic);
}
