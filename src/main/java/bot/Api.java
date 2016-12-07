package bot;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Api {

    String url = "http://yorkdojoconnect4.azurewebsites.net/api/";

    /**
     * /api/Register [POST] Register your team and returns your unique player ID. api/Register?teamName=Winners&password=Secret
     */
    public String register(String teamName, String password) throws UnirestException {
        HttpResponse<String> strResponse = Unirest.post(url + "Register")
                .header("accept", "application/json")
                .queryString("teamName", teamName)
                .queryString("password", password)
                .asString();

        return strResponse.getBody().replace("\"", "");
    }

    /**
     * /api/GameState [GET] Returns the current state of the game api/GameState?playerID=1234567F
     */
    public JsonNode gameState(String playerId) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url + "GameState")
                .header("accept", "application/json")
                .queryString("playerID", playerId)
                .asJson();

        return jsonResponse.getBody();
    }

    /**
     * /api/MakeMove [POST] 
     * Places your piece into a column api/MakeMove?playerID=1234567&ColumnNumber=2&Password=secret
     */
    public JsonNode makeMove(String playerId, int columnNumber, String password) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.get(url + "MakeMove")
                .header("accept", "application/json")
                .queryString("playerID", playerId)
                .queryString("ColumnNumber", columnNumber)
                .queryString("Password", password)
                .asJson();
        
        return jsonResponse.getBody();
    }

    public String newGame(String playerId) throws UnirestException {
        HttpResponse<String> strResponse = Unirest.get(url + "MakeMove")
                .header("accept", "application/json")
                .queryString("playerID", playerId)
                .asString();
        
        return strResponse.getBody();
    }
}
