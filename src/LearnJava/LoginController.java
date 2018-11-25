package LearnJava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController extends Controller implements Initializable {

    HashMap<String, String> users = new HashMap<String, String>();

    @FXML
    TextField userName, password, newUserName, newPassword;

    @FXML
    Label report, userReport, passReport;

    @FXML
    Button signUp;

    boolean userOK = false, passOK = false;

    public void LoginClicked(ActionEvent event) throws IOException {
        if (userName.getText().length() == 0) {
            report.setText("Please provide a user name");
        } else if (password.getText().length() == 0) {
            report.setText("Please provide a password");
        } else if (users.containsKey(userName.getText())) {
            if (users.get(userName.getText()).equals(password.getText())) {
                ProfileController.presentUser = userName.getText();
                ChangeScene(event, "Profile.fxml", "User Profile");
            } else {
                report.setText("Password did not match");
            }
        } else {
            report.setText("User name not found");
        }
    }

    public void SignUpClicked(ActionEvent event) throws IOException {
        ProfileController.presentUser = newUserName.getText();
        Files.write(Paths.get("users.txt"), (newUserName.getText() + "\n" + newPassword.getText()+"\n").getBytes(), StandardOpenOption.APPEND);
        creatUserFile();
        ChangeScene(event, "Profile.fxml", "User Profile");
    }

    public void checkUserName() {
        if (newUserName.getText().length() < 3) {
            userReport.setText("User Name must contain at least 3 characters");
            userReport.setTextFill(Color.RED);
            userOK = false;
            signUp.setDisable(true);
        } else if (users.containsKey(newUserName.getText())) {
            userReport.setText("This user Name has already been used");
            userReport.setTextFill(Color.RED);
            userOK = false;
            signUp.setDisable(true);
        } else {
            userReport.setText("OK");
            userReport.setTextFill(Color.GREEN);
            userOK = true;
            if (passOK) signUp.setDisable(false);
        }
    }

    public void checkPassword() {
        if (newPassword.getText().length() < 8) {
            passReport.setText("Password must contain at least 8 characters");
            passReport.setTextFill(Color.RED);
            passOK = false;
            signUp.setDisable(true);
        } else {
            passReport.setText("OK");
            passReport.setTextFill(Color.GREEN);
            passOK = true;
            if (userOK) signUp.setDisable(false);
        }
    }

    public void GuestLoginClicked(ActionEvent event) throws IOException {
        LessonsController.guest = true;
        ChangeScene(event, "Lessons.fxml", "Lessons");
    }


    public void BackClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "WelcomeWindow.fxml", "Learn to code in java");
    }

    private void readUserList() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("users.txt"));
            String key, value;
            while ((key = bufferedReader.readLine()) != null && (value = bufferedReader.readLine()) != null) {
                users.put(key, value);
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

    public void creatUserFile() throws IOException {
        Arrays.fill(ProfileController.lines, "0");
        Path file = Paths.get("user"+newUserName.getText()+".txt");
        Files.write(file, Arrays.asList(ProfileController.lines), Charset.forName("UTF-8"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        readUserList();
        signUp.setDisable(true);
    }
}
