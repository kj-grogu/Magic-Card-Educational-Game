

import java.io.IOException;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class ResetGameStateResource extends ServerResource {
	@Get
    public JsonRepresentation represent() throws IOException {
    	Game game = GameSingleton.getGameInstance();
    	game.restart();
    	JSONObject response = new JSONObject();
    	response.put("message", "Game Server Restarted");
    	
        return (new JsonRepresentation(response));
    }
}
