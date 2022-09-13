

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class GridResource extends ServerResource {
	static JSONObject  response;
    @Get
    public JsonRepresentation represent() throws IOException {
    	
    	int grid [][] = new int[6][6];
    	
    	/*for(int i = 0 ; i < 6 ; i++){
    		for(int j = 0 ; j < 6 ; j++){
    			grid [i][j] = (Math.random()<0.5)?0:1;
    			System.out.println("grid [i][j]: "+grid [i][j]);
    		}
    		System.out.println();
    	}*/
    	
    	
    	if(response == null){
    		response = new JSONObject();
        	
        	response.put("r0c0", (Math.random()<0.5)?0:1);
        	response.put("r0c1", (Math.random()<0.5)?0:1);
        	response.put("r0c2", (Math.random()<0.5)?0:1);
        	response.put("r0c3", (Math.random()<0.5)?0:1);
        	response.put("r0c4", (Math.random()<0.5)?0:1);
        	
        	response.put("r1c0", (Math.random()<0.5)?0:1);
        	response.put("r1c1", (Math.random()<0.5)?0:1);
        	response.put("r1c2", (Math.random()<0.5)?0:1);
        	response.put("r1c3", (Math.random()<0.5)?0:1);
        	response.put("r1c4", (Math.random()<0.5)?0:1);
        	
        	response.put("r2c0", (Math.random()<0.5)?0:1);
        	response.put("r2c1", (Math.random()<0.5)?0:1);
        	response.put("r2c2", (Math.random()<0.5)?0:1);
        	response.put("r2c3", (Math.random()<0.5)?0:1);
        	response.put("r2c4", (Math.random()<0.5)?0:1);
        	
        	response.put("r3c0", (Math.random()<0.5)?0:1);
        	response.put("r3c1", (Math.random()<0.5)?0:1);
        	response.put("r3c2", (Math.random()<0.5)?0:1);
        	response.put("r3c3", (Math.random()<0.5)?0:1);
        	response.put("r3c4", (Math.random()<0.5)?0:1);
        	
        	response.put("r4c0", (Math.random()<0.5)?0:1);
        	response.put("r4c1", (Math.random()<0.5)?0:1);
        	response.put("r4c2", (Math.random()<0.5)?0:1);
        	response.put("r4c3", (Math.random()<0.5)?0:1);
        	response.put("r4c4", (Math.random()<0.5)?0:1);
    	}

        return (new JsonRepresentation(response));
    }
}
