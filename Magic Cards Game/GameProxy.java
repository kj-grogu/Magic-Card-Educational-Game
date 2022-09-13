import org.restlet.resource.ClientResource;
import org.restlet.representation.Representation ;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.json.JSONArray;
import org.restlet.data.* ;

/**
 * Write a description of class MagicianClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameProxy  
{
    
    /**
     * Constructor for objects of class MagicianClient
     */
    public GameProxy()
    {
    }

    public void addPlayer(String userName)
    {
        try {
                String service_url = "http://35.162.34.185:8080/restlet/addPlayer" ;
                ClientResource afterPlayerAdd = new ClientResource( service_url ); 
                
                JSONObject payload = new JSONObject();
                payload.put("username", userName);
                
                Representation result = afterPlayerAdd.post(new JsonRepresentation(payload), MediaType.APPLICATION_JSON);
                
                JsonRepresentation represent = new JsonRepresentation(result);
                JSONObject jsonobject = represent.getJsonObject();
                
                String gameState = jsonobject.getString("gameState");
                 
                System.out.println("gameState: "+gameState);
          
                //return Item;                     
        } catch ( Exception e ) {
           System.out.println(e) ;
        } 
    }
    
    public String getGameState()
    {
        try {
                String service_url = "http://35.162.34.185:8080/restlet/getGameState" ;
                ClientResource afterPlayerAdd = new ClientResource( service_url ); 
                
                Representation result = afterPlayerAdd.get();
                
                JsonRepresentation represent = new JsonRepresentation(result);
                JSONObject jsonobject = represent.getJsonObject();
                
                String currentGameState = jsonobject.getString("currentGameState");
                 
                System.out.println("currentGameState: "+currentGameState);
          
                return currentGameState;                     
        } catch ( Exception e ) {
           System.out.println(e) ;
           return "Error Occured"+e;
        } 
    }
    
    public JSONObject getGrid()
    {
        try {
            String service_url = "http://35.162.34.185:8080/restlet/getGrid" ;
            ClientResource afterPlayerAdd = new ClientResource( service_url ); 
            
            Representation result = afterPlayerAdd.get();
            
            JsonRepresentation represent = new JsonRepresentation(result);
            JSONObject jsonobject = represent.getJsonObject();
            //JSONArray jsonMainArr =jsonobject.getJSONArray("grid");
                             
            //System.out.println("jsonMainArr: "+jsonMainArr);
      
            return jsonobject; 
        }
        catch ( Exception e ) {
           System.out.println(e) ;
           return null;
        } 
    }
    
     public void submitScore(String username, String score, String userResult)
    {
        try {
            String service_url = "http://35.162.34.185:8080/restlet/submitScore" ;
            ClientResource afterPlayerAdd = new ClientResource( service_url ); 
                
            JSONObject payload = new JSONObject();
            payload.put("username", username);
            payload.put("score", score);
            payload.put("userResult", userResult);
            
            Representation result = afterPlayerAdd.post(new JsonRepresentation(payload), MediaType.APPLICATION_JSON);
            
            JsonRepresentation represent = new JsonRepresentation(result);
            JSONObject jsonobject = represent.getJsonObject();
                             
            String gameState = jsonobject.getString("gameState");
                             
            System.out.println("gameState: "+gameState);
      
        }
        catch ( Exception e ) {
           System.out.println(e) ;
        } 
    }
    
     public String getScores()
    {
        try {
            String service_url = "http://35.162.34.185:8080/restlet/getScores" ;
            ClientResource afterPlayerAdd = new ClientResource( service_url ); 
            
            Representation result = afterPlayerAdd.get();
            
            JsonRepresentation represent = new JsonRepresentation(result);
            JSONObject jsonobject = represent.getJsonObject();
                             
            String userWithScore = jsonobject.getString("userWithScore");
                             
            System.out.println("userWithScore: "+userWithScore);
            return userWithScore;
        }
        catch ( Exception e ) {
           System.out.println(e) ;
           return "Error"+e;
        } 
    }
}