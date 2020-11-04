package dk.eamv.friends.presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UI extends Application {
    public static void Main(String[] args) {
        launch(args);
        System.out.println("sample text");
    }

    @Override
    public void start(Stage pStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UI.fxml"));
    
        Scene scene = new Scene(root, 300, 275);
    
        pStage.setTitle("Friends");
        pStage.setScene(scene);
        pStage.show();
    }
}
