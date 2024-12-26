import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class LaunchGame extends Application {
	
	private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        // Load the first scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Menu.fxml"));
        Parent root = loader.load();

        // Pass the primary stage to the controller
        MenuController controller = loader.getController();
        controller.setStage(primaryStage);

        // Set and show the scene
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("O an quan");
        primaryStage.show();
        Image icon = new Image("/icon.png"); 
        primaryStage.getIcons().add(icon);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
