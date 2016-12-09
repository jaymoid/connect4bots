package bot;

import java.util.Random;

import org.json.JSONObject;

public class Board {

    private final Api api;
    private final String password;

    public int[][] matrix = new int[6][7];

    public Board(Api api, String password) {
        this.api = api;
        this.password = password;
    }

    public void addPiece(JSONObject game, String playerId) {

        //Generate random column to add piece
        Random random = new Random();
        int randomColumn = random.nextInt(7);

        //Check if column is full, if true generate another column to add
        if (matrix[0][randomColumn] == CellContent.Empty) {
//			api.`
        }

    }
}
