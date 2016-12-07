package bot;

import org.json.JSONObject;

public class JsonUtils {

	public static int getGameState(JSONObject json) {

		return json.getInt("CurrentState");

	}

	public static String getYellowPlayerId(JSONObject json) {

		return json.getString("YellowPlayerID");

	}

	public static String getRedPlayerId(JSONObject json) {

		return json.getString("RedPlayerID");

	}

}
