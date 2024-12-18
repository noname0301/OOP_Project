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
    private Button playButton;
	
    @FXML
    void playGame(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Game.fxml"));
        GameController controller = new GameController();
        loader.setController(controller);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
    }
    
}
