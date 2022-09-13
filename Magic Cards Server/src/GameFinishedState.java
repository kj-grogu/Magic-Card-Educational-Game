

/**
 * Created by Jayam on 11/15/2016.
 */
public class GameFinishedState implements IGameState {

  private Game game;

  public GameFinishedState(Game _game) {
    this.game = _game;
  }

  @Override
  public void addPlayerOne(String playerName) {
    System.out.println("Cannot add playerone Game Finshed state");
  }

  @Override
  public void addPlayerTwo(String playerName) {
    System.out.println("Cannot add playertwo Game Finshed state");
  }

  @Override
  public void submitPlayerOneScore(String playerName, int score, String result) {
    System.out.println("Cannot submit playerone score,  Game Finshed state");

  }

  @Override
  public void submitPlayerTwoScore(String playerName, int score, String result) {
    System.out.println("Cannot submit playerone score,  Game Finshed state");

  }

  @Override
  public void startGame() {
    System.out.println("Cannot start game, Game Finshed state");
  }

  @Override
  public String toString(){
    return "Game Finished State";
  }

  @Override
  public String playerOneGetScore() {
	String scoreBoard = game.getGameScroreBoard();
	game.setState(game.getPlayerOneReceivedState());
	return scoreBoard;
  }
  
  @Override
	public String playerTwoGetScore() {
		return null;	
	}
}
