

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class GetScoresResource extends ServerResource {
	private List<String> users = new ArrayList<String>();
	private String status;
	
    @Get
    public JsonRepresentation represent() throws IOException {
    	Game game = GameSingleton.getGameInstance();
    			
    	JSONObject response = new JSONObject();
    	
    	try{
    		System.out.println("current state "+game.getCurrentGameState().toString());
    		if(game.getCurrentGameState().toString()== "Game Finished State")
    		{
    			System.out.println("Game fins satet at get scroe res");
    			response.put("userWithScore", game.playerOneGetScore());
        		return (new JsonRepresentation(response));	
    		}
    		if(game.getCurrentGameState().toString()== "Player One Recieved Score State"){
    			System.out.println("Ssecond request ");
    			response.put("userWithScore", game.playerTwoGetScore());
        		return (new JsonRepresentation(response));	
    		}
    		else{
    			response.put("userWithScore", "fetch score state not reached");
        		return (new JsonRepresentation(response));
    		}
    		
    	}
    	catch (Exception e) {
    		response.put("userWithScore", "Scores still not submitted");
    		return (new JsonRepresentation(response));

		}
    }
}
