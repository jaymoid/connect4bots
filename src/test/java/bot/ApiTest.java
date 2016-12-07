/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author james
 */
public class ApiTest {

    Api api;

    String password = "123";
    String teamName;
    
    public ApiTest() {
        api = new Api();
    }

    /**
     * Test of register method, of class Api.
     */
    @Test
    public void testRegister() throws Exception {
        // REGISTER
        String uniquePlayerID = api.register("unit test - nothing to see here", password);
        assertTrue(!uniquePlayerID.isEmpty());
        assertTrue(uniquePlayerID.contains("-"));
    
        System.out.println("PLAYER ID" + uniquePlayerID);
        
        // GAME STATE
        JsonNode gameState = api.gameState(uniquePlayerID);
        System.out.println("\ngameState:\n" + gameState.toString());
        
        // MAKE MOVE
        JsonNode makeMoveResp = api.makeMove(uniquePlayerID, 3, password);
        System.out.println("\makeMoveResp:\n" + makeMoveResp.toString());
    }

}
