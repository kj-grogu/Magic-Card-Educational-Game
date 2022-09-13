
public class PlayerOneReceivedScore implements IGameState {

	  private Game game;

	  public PlayerOneReceivedScore (Game _game) {
	    this.game = _game;
	  }

	  @Override
	  public void addPlayerOne(String playerName) {
	    System.out.println("Game has started, cannot add playerOne");
	  }

	  @Override
	  public void addPlayerTwo(String playerName) {
	    System.out.println("Game has started, cannot add playerTwo");
	  }

	  @Override
	  public void submitPlayerOneScore(String playerName, int score, String result) {
	    System.out.println("Game has started, playerOne submitting score");
	    game.updatePlayerOneScore(playerName, score, result);
	    game.setState(game.getPlayerOneSubmittedScoreState());
	  }

	  @Override
	  public void submitPlayerTwoScore(String playerName, int score, String result) {
	    System.out.println("Game has started, cannot submit player two before");
	  }

	  @Override
	  public void startGame() {

	  }

	  @Override
	  public String toString(){
	    return "Player One Recieved Score State";
	  }

	@Override
	public String playerOneGetScore() {
		String scoreboard = game.getGameScroreBoard();
		game.setState(game.getPlayerOneReceivedState());
		System.out.println("reached palyer on get score...");
		return scoreboard;
	}

	  @Override
		public String playerTwoGetScore() {
			return null;	
		}
}