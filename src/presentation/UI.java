package presentation;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;

public class UI extends Application {
    private Stage stage;
    private TableView<String> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void start(Stage pStage) throws Exception {
        stage = FXMLLoader.load(getClass().getResource("UI.fxml"));
        tableView = (TableView<String>)((GridPane) stage.getScene().getRoot()).getChildren().get(2);
        tableView.setItems(FXCollections.observableArrayList("Hej", "gfasdf@asdf.coasd", "3345435", "Grp 5", "Sport"));
        stage.show();
    }
}
