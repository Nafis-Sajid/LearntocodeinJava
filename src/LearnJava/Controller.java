package LearnJava;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;



public class Controller {

    public void BackClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "WelcomeWindow.fxml", "Learn to code in java");
    }

    public void ChangeScene(ActionEvent event, String fileName, String title) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource(fileName));
        Scene scene = new Scene(parent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle(title);
        window.setScene(scene);
        window.show();
    }

}