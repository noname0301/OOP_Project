import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HelpController {
	private Stage stage;
	
	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	@FXML
    private Button backButton;

	@FXML
	private void initialize() {
		backButton.setFocusTraversable(false);
	}
	
    @FXML
    private void back(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));
        Parent root = loader.load();
        MenuController controller = loader.getController();
        controller.setStage(stage);
        stage.setScene(new Scene(root));
    }
}
