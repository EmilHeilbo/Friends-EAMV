package presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class UI extends Application {
    public static void Main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) throws Exception {
        pStage = FXMLLoader.load(getClass().getResource("UI.fxml"));
        pStage.show();
    }
}
