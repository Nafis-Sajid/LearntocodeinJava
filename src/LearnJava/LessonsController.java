package LearnJava;

import javafx.event.ActionEvent;
import java.io.*;

public class LessonsController extends Controller{

    public static String PreviousTitle;
    public static boolean guest = false;

    public void BasicConceptsClicked(ActionEvent event) throws IOException {
        PreviousTitle = "Basic Concepts";
        ChangeScene(event, "Topic.fxml", "Basic Concepts");
    }

    public void ConditionalAndLoopsClicked(ActionEvent event) throws IOException {
        PreviousTitle = "Conditionals & Loops";
        ChangeScene(event, "Topic.fxml", "Conditionals & Loops");
    }

    public void ArraysClicked(ActionEvent event) throws IOException {
        PreviousTitle = "Arrays";
        ChangeScene(event, "Topic.fxml", "Arrays");
    }

    public void ClassesAndObjectsClicked(ActionEvent event) throws IOException {
        PreviousTitle = "Classes & Objects";
        ChangeScene(event, "Topic.fxml", "Classes & Objects");
    }

    public void OOPCOnceptsClicked(ActionEvent event) throws IOException {
        PreviousTitle = "OOP Concepts";
        ChangeScene(event, "Topic.fxml", "OOP Concepts");
    }

    public void ExceptionsCLicked(ActionEvent event) throws IOException {
        PreviousTitle = "Exceptions";
        ChangeScene(event, "Topic.fxml", "Exceptions");
    }

    public void FIleIOClicked(ActionEvent event) throws IOException {
        PreviousTitle = "FIle Input Output";
        ChangeScene(event, "Topic.fxml", "FIle Input Output");
    }

    public void ThreadsClicked(ActionEvent event) throws IOException {
        PreviousTitle = "Threads";
        ChangeScene(event, "Topic.fxml", "Threads");
    }

    public void AdvancedClicked(ActionEvent event) throws IOException {
        PreviousTitle = "Advanced";
        ChangeScene(event, "Topic.fxml", "Advanced");
    }

    public void BackClicked(ActionEvent event) throws IOException {
        if(guest) ChangeScene(event, "WelcomeWindow.fxml", "Learn to code in java");
        else ChangeScene(event, "Profile.fxml", "User Profile");
    }
}
