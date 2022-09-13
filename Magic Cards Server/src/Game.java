


public class Game implements IGame {
  IGameState noPlayerState;
  IGameState onePlayerState;
  IGameState twoPlayerState;
  IGameState gameStartedState;
  IGameState playerOneSubmittedScoreState;
  IGameState playerTwoSubmittedScoreState;
  IGameState gameFinishedState;
  IGameState playerOneReceivedState;
  IGameState state;
  String playerOne;
  String playerTwo;

  int playerOneScore;
  int playerTwoScore;
  
  String playerOneResult;
  String playerTwoResult;
  boolean scoreCalculated;
  String finalScoreBoard;
  int scoreSentToPlayers;
  
  public Game() {
    noPlayerState = new NoPlayerState(this);
    onePlayerState = new OnePlayerState(this);
    twoPlayerState = new TwoPlayerState(this);
    gameStartedState = new GameStartedState(this);
    playerOneSubmittedScoreState = new PlayerOneSubmittedScoreState(this);
    gameFinishedState = new GameFinishedState(this);
    playerOneReceivedState = new PlayerOneReceivedScore(this);
    state = noPlayerState;
    scoreCalculated = false;
    scoreSentToPlayers = 0;
  }
  
  void restart(){
	  this.state = noPlayerState;
	  playerOne = "";
	  playerTwo = "";
	  playerOneScore = 0;
	  playerTwoScore = 0;
	  playerOneResult = "";
	  playerTwoResult = "";
	  scoreCalculated = false;
	  finalScoreBoard = "";
	  scoreSentToPlayers = 0;
  }

  void setState(IGameState state) {
    this.state = state;
  }

  public void addPlayerOne(String playerName) {
    state.addPlayerOne(playerName);
  }

  public void updatePlayerOne(String playerName) {
    playerOne = playerName;
  }

  public void addPlayerTwo(String playerName) {
    playerTwo = playerName;
    state.addPlayerTwo(playerName);
  }

  public void updatePlayerTwo(String playerName) {
    playerTwo = playerName;
  }

  public IGameState getOnePlayerState() {
    return onePlayerState;
  }

  public IGameState getTwoPlayerState() {
    return twoPlayerState;
  }

  public IGameState getGameStartedState() {
    return gameStartedState;
  }

  public IGameState getPlayerOneSubmittedScoreState() {
    return playerOneSubmittedScoreState;
  }

  public IGameState getPlayerTwoSubmittedScoreState() {
    return playerTwoSubmittedScoreState;
  }

  public void submitPlayerOneScore(String playerName, int score, String result) {
    state.submitPlayerOneScore(playerName, score, result);
  }

  public void updatePlayerOneScore(String playerName, int score,String result) {
    playerOne = playerName;
    playerOneScore = score;
    playerOneResult = result;
  }

  @Override
  public void submitPlayerTwoScore(String playerName, int score , String result) {
    state.submitPlayerTwoScore(playerName, score, result);
  }

  public void updatePlayerTwoScore(String playerName, int score, String result) {
    playerTwo = playerName;
    playerTwoScore = score;
    playerTwoResult = result;
  }

  public IGameState getCurrentGameState() {
    return state;
  }

  public void startGame() {
    state.startGame();
    //System.out.println("Game Started");
  }

  public void startingGame(){

  }

  
  public String getGameScroreBoard() {
	  if(!scoreCalculated){
			if(playerOneResult.equals("true") && playerTwoResult.equals("true") ){
			if(playerOneScore > playerTwoScore){
				playerTwoResult = "Winner!!";
				playerOneResult = "Sorry Try Again";
			}
			else{
				playerTwoResult = "Sorry Try Again";
				playerOneResult = "Winner!!";
			}
		}
		else if(playerOneResult.equals("false") && playerTwoResult.equals("false")){
			playerTwoResult = "You Lost...";
			playerOneResult = "You Lost...";
		}
		else if(
				(playerOneResult.equals("false") && playerTwoResult.equals("true"))
				||(playerOneResult.equals("true") && playerTwoResult.equals("false"))
				){
			if(playerOneResult.equals("true")){
				playerTwoResult = "You Lost...";
				playerOneResult = "Winner!!";
			}
			else{
				playerTwoResult = "Winner!!";
				playerOneResult = "You Lost...";
			}
		}
			
	    String scoreBoard = playerOne + "-" + playerOneScore + "-"+ playerOneResult;
	    scoreBoard += ";" + playerTwo + "-" + playerTwoScore + "-"+ playerTwoResult;
	    finalScoreBoard = scoreBoard;
	    scoreCalculated = true;
	    
	}
    return finalScoreBoard;
  }

  public IGameState getGameFinishedState() {
    return gameFinishedState;
  }
  
  public IGameState getPlayerOneReceivedState() {
	    return playerOneReceivedState;
  }
  
 
  
  @Override
	public String playerOneGetScore() {
	  String score= getGameScroreBoard();
	  System.out.println("score foe 1st paleye "+score);
	  setState(getPlayerOneReceivedState());
	  return score;
   }

	@Override
	public String playerTwoGetScore() {
	 String score= getGameScroreBoard();
	 System.out.println("score foe 2nd paleye "+score);
	  restart();
	  return score;
	}

}