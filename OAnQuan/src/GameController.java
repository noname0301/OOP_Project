import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class GameController {
	
	private Game game;
	private Button[] buttons;
	private Label[] values;
	private StackPane[] stackPanes;
	
    @FXML
    private Button left0, right0, left1, right1, left2, right2, left3, right3, left4, right4, 
    				left6, right6, left7, right7, left8, right8, left9, right9, left10, right10;
    
    
    
    @FXML
    private StackPane cell0, cell1, cell2, cell3, cell4, cell6, cell7, cell8, cell9, cell10;
    
    @FXML
    private Label value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11;
    
    @FXML
    private Label score1, score2, curTurn, gameOverText, winner;
    
    @FXML
    private Button playAgainButton;
    
    @FXML
    public void initialize() {
    	buttons = new Button[] {left0, right0, left1, right1, left2, right2, left3, right3, left4, right4,
    			left10, right10, left6, right6, left7, right7, left8, right8, left9, right9};
    	values = new Label[] {value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10, value11};
    	stackPanes = new StackPane[] {cell0, cell1, cell2, cell3, cell4, cell6, cell7, cell8, cell9, cell10};
    	
    	
    	game = new Game();
    	gameOverText.setVisible(false);
    	winner.setVisible(false);
    	playAgainButton.setVisible(false);
    	playAgainButton.setFocusTraversable(false);
    	
    	for (Button button : buttons) {
    		button.setVisible(false);
    		button.setFocusTraversable(false);
    		button.setOnAction(e -> handlePlay(e));
    	}
    	
    	handleCurTurn();
    }
    
    @FXML
    private void playAgain() {
    	game = new Game();
    	gameOverText.setVisible(false);
    	winner.setVisible(false);
    	playAgainButton.setVisible(false);
    	
    	
    	for (Button button : buttons) {
    		button.setVisible(false);
    		button.setFocusTraversable(false);
    		button.setOnAction(e -> handlePlay(e));
    	}
    	
    	handleCurTurn();
    	updateValues();
    }
    
    private void handleMouseEntered(MouseEvent event) {
    	Parent parent = (Parent) event.getSource();
    	for (Button button : buttons) {
    		if (parent.getChildrenUnmodifiable().contains(button)) {
    			button.setVisible(true);
    		}
    	}
    	//System.out.println("Mouse entered on: " + event.getSource());
    }
    
    private void handleMouseExited(MouseEvent event) {
    	Parent parent = (Parent) event.getSource();
    	for (Button button : buttons) {
    		if (parent.getChildrenUnmodifiable().contains(button)) {
    			button.setVisible(false);
    		}
    	}
    }
    
    private void handleCurTurn() {
    	for (Button button : buttons) {
    		button.setVisible(false);
    	}
    	int[] avaiMoves = game.getAvaiMoves();
    	for (int i = 0; i < 10; i++) {
    		if (avaiMoves[i] == 1) {
    			stackPanes[i].setOnMouseEntered(e -> handleMouseEntered(e));
    			stackPanes[i].setOnMouseExited(e -> handleMouseExited(e));
    		}
    		else {
    			stackPanes[i].setOnMouseEntered(null);
    			stackPanes[i].setOnMouseExited(null);  
    		}
    	}
    }
    
    public void updateValues() {
    	score1.setText(Integer.toString(game.getPlayerScore(0)));
    	score2.setText(Integer.toString(game.getPlayerScore(1)));
    	curTurn.setText("Player " + Integer.toString(game.getCurTurn() + 1));
    	for (int i = 0; i < 12; i++) {
    		int[] gameBoard = game.getGameBoard().getCells();
    		values[i].setText(Integer.toString(gameBoard[i]));
    	}
    }

    
    public void handlePlay(ActionEvent e) {
    	Parent parent = (Parent) e.getSource();
    	String move = parent.getId();
    	if (move.charAt(0) == 'r') {
    		int cell = Integer.parseInt(move.substring(5));
    		game.playMove(cell, 0);
    	}
    	else {
    		int cell = Integer.parseInt(move.substring(4));
    		game.playMove(cell, 1);
    	}
    	
    	if (game.isGameOver()) gameEnd();
    	else handleCurTurn();
    	updateValues();
    	
    }
    
    public void gameEnd() {
    	for (Button button : buttons) {
    		button.setVisible(false);
    	}
    	for (int i = 0; i < 10; i++) {
			stackPanes[i].setOnMouseEntered(null);
			stackPanes[i].setOnMouseExited(null);
		}
    	gameOverText.setVisible(true);
    	winner.setText(game.gameCondition());
    	winner.setVisible(true);
    	playAgainButton.setVisible(true);
    }
}