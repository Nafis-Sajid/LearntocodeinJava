package LearnJava;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TopicController extends Controller implements Initializable{
    @FXML TextArea textArea;

    public void BackClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "Lessons.fxml", "Lessons");
    }

    public void NextClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "Quiz.fxml", "Quiz");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        switch (LessonsController.PreviousTitle) {
            case "Advanced":
                textArea.setText(readFile(new File("advanced.txt")));
                break;
            case "Arrays":
                textArea.setText(readFile(new File("arrays.txt")));
                break;
            case "Basic Concepts":
                textArea.setText(readFile(new File("basicconcepts.txt")));
                break;
            case "Classes & Objects":
                textArea.setText(readFile(new File("classesandobjects.txt")));
                break;
            case "Conditionals & Loops":
                textArea.setText(readFile(new File("conditionalandloops.txt")));
                break;
            case "Exceptions":
                textArea.setText(readFile(new File("exceptions.txt")));
                break;
            case "FIle Input Output":
                textArea.setText(readFile(new File("fileio.txt")));
                break;
            case "OOP Concepts":
                textArea.setText(readFile(new File("oopconcepts.txt")));
                break;
            case "Threads":
                textArea.setText(readFile(new File("threads.txt")));
                break;
        }
    }

    private String readFile(File file){
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuffer.append(String.format("%s\n", text));
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
        return stringBuffer.toString();
    }

}
