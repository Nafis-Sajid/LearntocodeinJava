package LearnJava;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.util.Optional;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;
import static javafx.scene.control.Alert.AlertType.INFORMATION;

public class MainWindowController extends Controller {
    public void InfoClicked(ActionEvent event) {
        Alert Info = new Alert(INFORMATION);
        Info.setTitle("Information");
        Info.setHeaderText("Information");
        Info.setContentText("This program helps you to learn JAVA in a very easy way.\n" +
                "It will provide basic knowledge for JAVA.\n" +
                "We'll try to update this program further more in future.\n" +
                "Feel free to give your opinion about our program.");
        Info.showAndWait();
    }

    public void CreditsClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "Credits.fxml", "Credits");
    }

    public void LetsGoClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "UserLogin.fxml", "User Login");
    }

    public void BackClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "WelcomeWindow.fxml", "Learn to code in java");
    }

    public void ExitClicked(ActionEvent event) {
        Alert ConfirmExit = new Alert(CONFIRMATION);
        ConfirmExit.setTitle("Exit Confirmation");
        ConfirmExit.setHeaderText("You have clicked Exit Button");
        ConfirmExit.setContentText("Are you sure you want to exit?");
        ((Button) ConfirmExit.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
        ((Button) ConfirmExit.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

        Optional<ButtonType> result = ConfirmExit.showAndWait();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
        }
    }
}
