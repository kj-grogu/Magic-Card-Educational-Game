

/**
 * Created by Jayam on 11/15/2016.
 */
public class GameStartedState implements IGameState {

  private Game game;

  public GameStartedState(Game _game) {
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
    return "Game Started State";
  }

  @Override
	public String playerOneGetScore() {
		return null;
	}
  
  @Override
	public String playerTwoGetScore() {
		return null;	
	}
}