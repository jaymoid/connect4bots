package bot;

import bot.models.GameStateResponse;
import org.json.JSONObject;

import com.mashape.unirest.http.exceptions.UnirestException;

public class Game {

    private static final String TEAM_NAME = "james";
    private static final String PASSWORD = "123456789";

    public static void main(String[] args) {
        Api api = new Api();

        try {
            String playerId = api.register(TEAM_NAME, PASSWORD);
            System.out.println(String.format("PlayerId: %s", playerId));

            Board board = new Board(api, PASSWORD);

            boolean isGameComplete = false;
            while (!isGameComplete) {
                GameStateResponse gameStateResp = api.gameState(playerId);

                GameState gameState = gameStateResp.getCurrentState();
                
                String yellowPlayerId = gameStateResp.getYellowPlayerID();
                String redPlayerId = gameStateResp.getRedPlayerID();

                switch (gameState) {
                    case GAME_NOT_STARTED:
                        break;
                    case RED_WON:
                        isGameComplete = true;

                        if (redPlayerId.equals(playerId)) {
                            System.out.println("You won");
                        } else {
                            System.out.println("You lost");
                        }
                        break;
                    case YELLOW_WON:
                        isGameComplete = true;

                        if (yellowPlayerId.equals(playerId)) {
                            System.out.println("You won");
                        } else {
                            System.out.println("You lost");
                        }
                        break;
                        
                    case RED_TO_PLAY:
                        if (redPlayerId.equals(playerId)) {
                            board.addPiece(gameNode, playerId);
                        }
                        break;
                    case YELLOW_TO_PLAY:
                        if (yellowPlayerId.equals(playerId)) {
                            board.addPiece(gameNode, playerId);
                        }
                        break;
                    default:
                        break;
                }

            }
        } catch (UnirestException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
