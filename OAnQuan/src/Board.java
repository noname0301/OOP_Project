
public class Board {
	private int[] cells;
	
	public Board() {
		cells = new int[12];
		for (int i = 0; i < 12; i++) cells[i] = 5;
		cells[5] = 10;
		cells[11] = 10;
	}
	
	public int[] getCells() {
		return cells;
	}
	
	public int move(int startPos, int direction) {
		int curPos = startPos;
		int score = 0;
		
		while (curPos != 5 && curPos != 11 && cells[curPos] != 0) {
			int num = cells[curPos];
			cells[curPos] = 0;
			for (int i = 0; i < num; i++) {
				curPos = updateCurPos(curPos, direction);
				cells[curPos] += 1;
			}
			curPos = updateCurPos(curPos, direction);
		}
		
		while (curPos != 5 && curPos != 11 && cells[curPos] == 0) {
			curPos = updateCurPos(curPos, direction);
			if (cells[curPos] == 0) break;
			score +=  cells[curPos];
			cells[curPos] = 0;
			curPos = updateCurPos(curPos, direction);
		}

		return score;		
	}
	
	private int updateCurPos(int curPos, int direction) {
		// 0 right 1 left
		if (direction == 0) return (curPos+1) % 12;
		return (curPos-1) < 0 ? 11 : (curPos-1);
	}
	
	public void clearBoard() {
		for (int i = 0; i < 12; i++) cells[i] = 0;
	}
	
	public void addPieces(int player) {
		for (int i = 6*player; i < 5+6*player; i++) cells[i] = 1;
	}
}
