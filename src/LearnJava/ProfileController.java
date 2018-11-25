package LearnJava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import static javafx.scene.control.Alert.AlertType.CONFIRMATION;

public class ProfileController extends Controller implements Initializable {
    public static String presentUser;
    public static String[] lines = new String[9];

    @FXML
    Label displayName, Number;

    public void LessonsClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "Lessons.fxml", "Lessons");
    }

    public void StatisticsClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "UserImprovement.fxml", "User Improvement");
    }

    public void LogoutClicked(ActionEvent event) throws IOException {
        Alert ConfirmLogout = new Alert(CONFIRMATION);
        ConfirmLogout.setTitle("Logout Confirmation");
        ConfirmLogout.setHeaderText("You have clicked Logout");
        ConfirmLogout.setContentText("Are you sure you want to logout?");

        ((Button) ConfirmLogout.getDialogPane().lookupButton(ButtonType.OK)).setText("Yes");
        ((Button) ConfirmLogout.getDialogPane().lookupButton(ButtonType.CANCEL)).setText("No");

        Optional<ButtonType> result = ConfirmLogout.showAndWait();
        if (result.get() == ButtonType.OK) {
            ChangeScene(event, "WelcomeWindow.fxml", "Learn to code in java");
            presentUser = "";
        }
        Path file = Paths.get("user"+presentUser+".txt");
        Files.write(file, Arrays.asList(lines), Charset.forName("UTF-8"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayName.setText(presentUser);
        readData();
    }

    public void readData() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("user" + presentUser + ".txt"));
            for (int i = 0; i < 9; i++) {
                lines[i] = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
