

public class GameSingleton {
	private static Game gameInstance;
	public static Game getGameInstance(){
		if(gameInstance == null){
			gameInstance = new Game();
		}
		return gameInstance;
	}
}
