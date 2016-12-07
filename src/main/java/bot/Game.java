package bot;

import org.json.JSONObject;

import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Game {
	
	private static final String TEAM_NAME = "";
	private static final String PASSWORD = "";

	public static void main(String[] args) {
		Api api = new Api();
		
		try {
			String playerId = api.register(TEAM_NAME, PASSWORD);
			System.out.println(String.format("PlayyerId: %s", playerId));
			
			Board board = new Board(api);
			
			boolean isGameComplete = false;
			while (!isGameComplete) {
				JSONObject gameNode = api.gameState(playerId);
				
				int gameState = JsonUtils.getGameState(gameNode);
				String yellowPlayerId = JsonUtils.getYellowPlayerId(gameNode);
				String redPlayerId = JsonUtils.getYellowPlayerId(gameNode);
				
				switch (gameState) {
				case GameState.GameNotStarted:
					break;
				case GameState.RedWon:
					isGameComplete = true;
					
					if (redPlayerId.equals(playerId)) {
						System.out.println("You won");
					} else {
						System.out.println("You lost");
					}
					break;
				case GameState.YellowWon:
					isGameComplete = true;
					
					if (yellowPlayerId.equals(playerId)) {
						System.out.println("You won");
					} else {
						System.out.println("You lost");
					}
					break;
				case GameState.RedToPlay:
					if (redPlayerId.equals(playerId)) {
						board.addPiece();
					}
					break;
				case GameState.YellowToPlay:
					if (yellowPlayerId.equals(playerId)) {
						board.addPiece();
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
