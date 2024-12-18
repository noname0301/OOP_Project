import java.io.IOException;

import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class GameScreen extends JFrame {
	
	public GameScreen() {
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		this.setSize(1024, 768);
		this.setTitle("O An Quan");
		this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/test.fxml"));
                    GameController controller = new GameController();
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
	}
	public static void main(String[] args) {
		new GameScreen();
	}
}
