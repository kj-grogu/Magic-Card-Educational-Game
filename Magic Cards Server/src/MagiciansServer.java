

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;
import org.restlet.data.Protocol;
import org.restlet.Component;

public class MagiciansServer extends Application {

    /**
     * Creates a root Restlet that will receive all incoming calls.
     */
    @Override
    public synchronized Restlet createInboundRoot() {
        // Create a router Restlet that routes each call to a new instance of HelloWorldResource.
        Router router = new Router(getContext());

        // Defines only one route
        router.attach("/addPlayer", AddPlayerResource.class);
        router.attach("/getGameState", GetGameStateResource.class);
        router.attach("/getGrid", GridResource.class);
        router.attach("/submitScore", SubmitScoreResource.class);
        router.attach("/getScores", GetScoresResource.class);
        router.attach("/resetGame", ResetGameStateResource.class);

        return router;
    }
    
    public static void main(String[] args) throws Exception {  
        // Create a new Component.  
        Component component = new Component();  

        // Add a new HTTP server listening on port 8080.  
        component.getServers().add(Protocol.HTTP, 8080);  

        // Attach the sample application.  
        component.getDefaultHost().attach("/restlet",  
            new MagiciansServer());  

        // Start the component.  
        component.start();  
    }  
}
