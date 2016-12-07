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

    String teamName;
    
    public ApiTest() {
        api = new Api();
    }

    /**
     * Test of register method, of class Api.
     */
    @Test
    public void testRegister() throws Exception {
        String teamName = api.register("unit test - nothing to see here", "123");
        assertTrue(!teamName.isEmpty());
        assertTrue(teamName.contains("-"));
    
        JsonNode gameState = api.gameState(teamName);
        System.out.println(gameState.toString());
    }

}
