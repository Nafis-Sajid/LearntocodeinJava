package LearnJava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserImprovementController extends Controller implements Initializable {
    @FXML
    BarChart LessonChart;

    @Override
    public void BackClicked(ActionEvent event) throws IOException {
        ChangeScene(event, "Profile.fxml", "User Profile");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setData("Basic", Integer.parseInt(ProfileController.lines[0]));
        setData("Conditionsls", Integer.parseInt(ProfileController.lines[1]));
        setData("Arrays", Integer.parseInt(ProfileController.lines[2]));
        setData("Classes", Integer.parseInt(ProfileController.lines[3]));
        setData("OOP", Integer.parseInt(ProfileController.lines[4]));
        setData("Exception", Integer.parseInt(ProfileController.lines[5]));
        setData("File", Integer.parseInt(ProfileController.lines[6]));
        setData("Thread", Integer.parseInt(ProfileController.lines[7]));
        setData("Advanced", Integer.parseInt(ProfileController.lines[8]));
    }

    private void setData(String topic, int value){
        XYChart.Series set = new XYChart.Series();
        set.getData().add(new XYChart.Data(topic,value*20));
        LessonChart.getData().add(set);
    }
}
