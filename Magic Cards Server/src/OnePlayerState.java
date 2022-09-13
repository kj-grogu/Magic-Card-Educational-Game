

public class OnePlayerState implements IGameState {

  private Game game;

  public OnePlayerState(Game _game) {
    this.game = _game;
  }

  public void addPlayerOne(String playerName) {
    System.out.println("In OnePLayer State , one player already added, add player two");
  }

  public void addPlayerTwo(String playerName) {
    System.out.println("In OnePLayer State , adding player two");
    game.updatePlayerTwo(playerName);
    game.setState(game.getTwoPlayerState());
  }

  public void submitPlayerOneScore(String playerName, int score, String result) {
    System.out.println("cannot submit score, in one player added state");
  }

  @Override
  public void submitPlayerTwoScore(String playerName, int score, String result) {
    System.out.println("cannot submit score, in one player added state");
  }

  @Override
  public void startGame() {
    System.out.println("Cannot start game, only one player added");
  }

  @Override
	public String playerOneGetScore() {
		return null;
	}
  
  public String toString() {
    return "OnePlayerState";
  }
  
  @Override
	public String playerTwoGetScore() {
		return null;	
	}
}