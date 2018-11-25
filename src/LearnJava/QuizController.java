package LearnJava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.ResourceBundle;

public class QuizController extends Controller implements Initializable {

    @FXML
    public Label question1, question2, question3, question4, question5;

    @FXML
    public ToggleGroup ques1, ques2, ques3, ques4, ques5;

    //For question1
    @FXML
    public RadioButton ques1op1, ques1op2, ques1op3, ques1op4;
    //For question2
    @FXML
    public RadioButton ques2op1, ques2op2, ques2op3, ques2op4;
    //For question3
    @FXML
    public RadioButton ques3op1, ques3op2, ques3op3, ques3op4;
    //For question4
    @FXML
    public RadioButton ques4op1, ques4op2, ques4op3, ques4op4;
    //For question5
    @FXML
    public RadioButton ques5op1, ques5op2, ques5op3, ques5op4;

    @FXML
    public Button submit, lessons;
    @FXML
    public Label rightans, wrongans, scorepercent;
    @FXML
    public Label right, wrong, score;

    private boolean q1 = false, q2 = false, q3 = false, q4 = false, q5 = false;
    private int ans;

    String[] answer = new String[5], selectedAnswer = new String[5];

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lessons.setDisable(true);
        switch (LessonsController.PreviousTitle) {
            case "Advanced":
                readQuestion(new File("advancedquiz.txt"));
                break;
            case "Arrays":
                readQuestion(new File("arraysquiz.txt"));
                break;
            case "Basic Concepts":
                readQuestion(new File("basicconceptsquiz.txt"));
                break;
            case "Classes & Objects":
                readQuestion(new File("classesandobjectsquiz.txt"));
                break;
            case "Conditionals & Loops":
                readQuestion(new File("conditionalandloopsquiz.txt"));
                break;
            case "Exceptions":
                readQuestion(new File("exceptionsquiz.txt"));
                break;
            case "FIle Input Output":
                readQuestion(new File("fileioquiz.txt"));
                break;
            case "OOP Concepts":
                readQuestion(new File("oopconceptsquiz.txt"));
                break;
            case "Threads":
                readQuestion(new File("threadsquiz.txt"));
                break;
        }

    }

    private void readQuestion(File file) {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            question1.setText(bufferedReader.readLine());
            ques1op1.setText(bufferedReader.readLine());
            ques1op2.setText(bufferedReader.readLine());
            ques1op3.setText(bufferedReader.readLine());
            ques1op4.setText(bufferedReader.readLine());
            answer[0] = bufferedReader.readLine();

            question2.setText(bufferedReader.readLine());
            ques2op1.setText(bufferedReader.readLine());
            ques2op2.setText(bufferedReader.readLine());
            ques2op3.setText(bufferedReader.readLine());
            ques2op4.setText(bufferedReader.readLine());
            answer[1] = bufferedReader.readLine();

            question3.setText(bufferedReader.readLine());
            ques3op1.setText(bufferedReader.readLine());
            ques3op2.setText(bufferedReader.readLine());
            ques3op3.setText(bufferedReader.readLine());
            ques3op4.setText(bufferedReader.readLine());
            answer[2] = bufferedReader.readLine();

            question4.setText(bufferedReader.readLine());
            ques4op1.setText(bufferedReader.readLine());
            ques4op2.setText(bufferedReader.readLine());
            ques4op3.setText(bufferedReader.readLine());
            ques4op4.setText(bufferedReader.readLine());
            answer[3] = bufferedReader.readLine();

            question5.setText(bufferedReader.readLine());
            ques5op1.setText(bufferedReader.readLine());
            ques5op2.setText(bufferedReader.readLine());
            ques5op3.setText(bufferedReader.readLine());
            ques5op4.setText(bufferedReader.readLine());
            answer[4] = bufferedReader.readLine();

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
        submit.setDisable(true);
    }

    public void AnswerClicked(ActionEvent event) {
        if (ques1op1.isSelected() || ques1op2.isSelected() || ques1op3.isSelected() || ques1op4.isSelected()) {
            if (ques1op1.isSelected()) selectedAnswer[0] = "1";
            else if (ques1op2.isSelected()) selectedAnswer[0] = "2";
            else if (ques1op3.isSelected()) selectedAnswer[0] = "3";
            else if (ques1op4.isSelected()) selectedAnswer[0] = "4";
            q1 = true;
        }
        if (ques2op1.isSelected() || ques2op2.isSelected() || ques2op3.isSelected() || ques2op4.isSelected()) {
            if (ques2op1.isSelected()) selectedAnswer[1] = "1";
            else if (ques2op2.isSelected()) selectedAnswer[1] = "2";
            else if (ques2op3.isSelected()) selectedAnswer[1] = "3";
            else if (ques2op4.isSelected()) selectedAnswer[1] = "4";
            q2 = true;
        }
        if (ques3op1.isSelected() || ques3op2.isSelected() || ques3op3.isSelected() || ques3op4.isSelected()) {
            if (ques3op1.isSelected()) selectedAnswer[2] = "1";
            else if (ques3op2.isSelected()) selectedAnswer[2] = "2";
            else if (ques3op3.isSelected()) selectedAnswer[2] = "3";
            else if (ques3op4.isSelected()) selectedAnswer[2] = "4";
            q3 = true;
        }
        if (ques4op1.isSelected() || ques4op2.isSelected() || ques4op3.isSelected() || ques4op4.isSelected()) {
            if (ques4op1.isSelected()) selectedAnswer[3] = "1";
            else if (ques4op2.isSelected()) selectedAnswer[3] = "2";
            else if (ques4op3.isSelected()) selectedAnswer[3] = "3";
            else if (ques4op4.isSelected()) selectedAnswer[3] = "4";
            q4 = true;
        }
        if (ques5op1.isSelected() || ques5op2.isSelected() || ques5op3.isSelected() || ques5op4.isSelected()) {
            if (ques5op1.isSelected()) selectedAnswer[4] = "1";
            else if (ques5op2.isSelected()) selectedAnswer[4] = "2";
            else if (ques5op3.isSelected()) selectedAnswer[4] = "3";
            else if (ques5op4.isSelected()) selectedAnswer[4] = "4";
            q5 = true;
        }
        if (q1 & q2 & q3 & q4 & q5) {
            submit.setDisable(false);
        }
    }

    public void SubmitClicked(ActionEvent event) throws IOException {
        submit.setDisable(true);
        lessons.setDisable(false);
        ques1op1.setDisable(true);
        ques1op2.setDisable(true);
        ques1op3.setDisable(true);
        ques1op4.setDisable(true);
        ques2op1.setDisable(true);
        ques2op2.setDisable(true);
        ques2op3.setDisable(true);
        ques2op4.setDisable(true);
        ques3op1.setDisable(true);
        ques3op2.setDisable(true);
        ques3op3.setDisable(true);
        ques3op4.setDisable(true);
        ques4op1.setDisable(true);
        ques4op2.setDisable(true);
        ques4op3.setDisable(true);
        ques4op4.setDisable(true);
        ques5op1.setDisable(true);
        ques5op2.setDisable(true);
        ques5op3.setDisable(true);
        ques5op4.setDisable(true);
        checkAnswer();
        right.setText(Integer.toString(ans));
        wrong.setText(Integer.toString(5 - ans));
        score.setText(Integer.toString((ans * 100) / 5) + "%");
        if(LessonsController.guest == false) updateData();
    }

    private void checkAnswer() {
        for (int i = 0; i < 5; i++) {
            if (selectedAnswer[i].equals(answer[i])) ans++;
        }
    }

    public void updateData() throws IOException {
        switch (LessonsController.PreviousTitle) {
            case "Advanced":
                ProfileController.lines[8] = Integer.toString(ans);
                break;
            case "Arrays":
                ProfileController.lines[2] = Integer.toString(ans);
                break;
            case "Basic Concepts":
                ProfileController.lines[0] = Integer.toString(ans);
                break;
            case "Classes & Objects":
                ProfileController.lines[3] = Integer.toString(ans);
                break;
            case "Conditionals & Loops":
                ProfileController.lines[1] = Integer.toString(ans);
                break;
            case "Exceptions":
                ProfileController.lines[5] = Integer.toString(ans);
                break;
            case "FIle Input Output":
                ProfileController.lines[6] = Integer.toString(ans);
                break;
            case "OOP Concepts":
                ProfileController.lines[4] = Integer.toString(ans);
                break;
            case "Threads":
                ProfileController.lines[7] = Integer.toString(ans);
                break;
        }
        Path file = Paths.get("user"+ProfileController.presentUser+".txt");
        Files.write(file, Arrays.asList(ProfileController.lines), Charset.forName("UTF-8"));
    }

    public void BackClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "Topic.fxml", LessonsController.PreviousTitle);
    }

    public void LessonsClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "Lessons.fxml", "Lessons");
    }
}
