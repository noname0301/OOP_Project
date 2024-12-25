import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MenuController {
	private Stage stage;
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	@FXML
    private Button playButton, helpButton, exitButton;
	
    @FXML
    void playGame(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Game.fxml"));
        GameController controller = new GameController();
        loader.setController(controller);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.centerOnScreen();
    }
    
    @FXML
    private void initialize() {
    	playButton.setFocusTraversable(false);
    	helpButton.setFocusTraversable(false);
    	exitButton.setFocusTraversable(false);
    }
    
    @FXML
    private void openHelp() throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Help.fxml"));
    	HelpController controller = new HelpController();
    	controller.setStage(stage);
        loader.setController(controller);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }
    
    @FXML
    private void exit() {
    	stage.close();
    }
}
