
public class Player {
	private int id;
	private int score;
	
	public Player(int id) {
		this.id = id;
		this.score = 0;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getScore() {
		return score;
	}
	
	public void addScore(int points) {
		score += points;
	}
	
	public void getMove() {
		
	}
}
