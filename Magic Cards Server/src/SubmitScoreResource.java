

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class SubmitScoreResource extends ServerResource {
	private List<String> users = new ArrayList<String>();
	private String status;
	
    @Post
    public JsonRepresentation represent(Representation entity) throws IOException {
    	Game game = GameSingleton.getGameInstance();
    	System.out.println("entity:"+entity);
    	
    	JsonRepresentation represent = new JsonRepresentation(entity);
    	
    	JSONObject jsonobject = represent.getJsonObject();
    	
    	System.out.println("jsonobject.getString(username):"+jsonobject.getString("username"));
    	System.out.println("jsonobject.getString(state):"+jsonobject.getString("score"));
    	System.out.println("jsonobject.getString(userResult):"+jsonobject.getString("userResult"));
    	
    	int score = Integer.parseInt(jsonobject.getString("score"));
    	
    	if(game.getCurrentGameState().toString() == "Game Started State"){
    		game.submitPlayerOneScore(jsonobject.getString("username"), score,jsonobject.getString("userResult"));
    	}
    	else{
    		game.submitPlayerTwoScore(jsonobject.getString("username"), score,jsonobject.getString("userResult"));
    		////////////////
    	}
    	users.add(jsonobject.getString("username"));
    	
    	
    	System.out.println("status:"+status);
    	JSONObject response = new JSONObject();
    	response.put("gameState", game.getCurrentGameState());
    	
        return (new JsonRepresentation(response));
    }
}
