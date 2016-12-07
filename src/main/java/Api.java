import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

 public class Api {

    String url = "http://http://yorkdojoconnect4.azurewebsites.net/api/";

    /**
     * /
     * /api/Register [POST] Register your team and returns your unique player ID. 
     * api/Register?teamName=Winners&password=Secret
     */
    public void register(String teamName, String password) throws UnirestException {
        HttpResponse<JsonNode> jsonResponse = Unirest.post(url + "Register")
            .queryString("teamName", teamName)
               .queryString(password, password)
            .field("last", "Polo")
            .asJson();
    }
    /*


/api/GameState  [GET]
Returns the current state of the game
api/GameState?playerID=1234567


/api/MakeMove  [POST]
Places your piece into a column
api/MakeMove?playerID=1234567&ColumnNumber=2&Password=secret


/api/NewGame  [POST]
Clears the board
api/NewGame?playerID=1234567
     */
}
