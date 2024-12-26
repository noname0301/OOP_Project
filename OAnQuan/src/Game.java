
public class Game {
	private Board board;
	private Player[] players;
	private int curPlayer;
	private int rent;
	
	public Game() {
		board = new Board();
		players = new Player[2];
		players[0] = new Player(0);
		players[1] = new Player(1);
		curPlayer = 0;
		rent = 0;
	}
	
	public void playMove(int startPos, int direction) {
		players[curPlayer].addScore(board.move(startPos, direction));
		changeTurn();
	}
	
	public boolean isGameOver() {
		int[] cells = board.getCells();
		if (cells[5] == 0 && cells[11] == 0) {
			for (int i = 0; i < 5; i++) players[0].addScore(board.getCells()[i]);
			for (int i = 6; i < 11; i++) players[1].addScore(board.getCells()[i]);
			board.clearBoard();
			return true;
		}
		return false;
	}
	
	public String gameCondition() {
		if (players[0].getScore() == players[1].getScore()) return "Tie!";
		return players[0].getScore() > players[1].getScore() ? "Player 1 wins!" : "Player 2 wins!";
	}
	
	public Board getGameBoard() {
		return board;
	}
	
	public int getCurTurn() {
		return curPlayer;
	}
	
	public void changeTurn() {
		curPlayer = 1-curPlayer;
	}
	
	public int getPlayerScore(int player) {
		return players[player].getScore();
	}
	
	public int[] getAvaiMoves() {
		int[] moves = new int[10];
		int sum = 0;
		for (int i = 5*curPlayer; i < 5+5*curPlayer; i++) {
			if (board.getCells()[i+curPlayer] != 0) moves[i] = 1;
			sum += board.getCells()[i+curPlayer];
		}
		if (sum == 0) {
			players[curPlayer].addScore(-5);
//			else {
//				players[1-curPlayer].addScore(5-players[curPlayer].getScore());
//				rent += (curPlayer == 1 ? 5-players[curPlayer].getScore() : players[curPlayer].getScore()-5);
//				players[curPlayer].addScore(-players[curPlayer].getScore());
//			}
			board.addPieces(curPlayer);
			for (int i = 5*curPlayer; i < 5+5*curPlayer; i++) moves[i] = 1;
		}
		return moves;
	}
	
	
}
