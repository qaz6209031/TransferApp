package Calendar;

import com.calendarfx.model.Calendar;
import com.calendarfx.model.CalendarSource;
import com.calendarfx.model.Entry;
import com.calendarfx.view.CalendarView;
import com.calendarfx.view.MonthEntryView;
import com.calendarfx.view.MonthView;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
//import home.model.StudentsModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TimetableController implements Initializable {


    private CalendarView calendar;

    @FXML
    private GridPane pnlHost;
    @FXML
    private JFXButton backbtn;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         loadCalendar();
    }

    private void loadCalendar() {
        calendar = new CalendarView();

        Calendar classes = new Calendar("Classes");
        Calendar smcEvents = new Calendar("SMC events");
        Calendar finals = new Calendar("finals");
        Calendar meetings = new Calendar("meetings");
        
        
        classes.setStyle(Calendar.Style.STYLE7);
        smcEvents.setStyle(Calendar.Style.STYLE2);
        finals.setStyle(Calendar.Style.STYLE1);
        meetings.setStyle(Calendar.Style.STYLE3);
        
        CalendarSource myCalendarSource = new CalendarSource("Calender");
        myCalendarSource.getCalendars().addAll(classes, smcEvents, finals,meetings);

        calendar.getCalendarSources().addAll(myCalendarSource);

        calendar.setRequestedTime(LocalTime.now());


        Thread updateTimeThread = new Thread("Calendar: Update Time Thread") {
            @Override
            public void run() {
                while (true) {
                    Platform.runLater(() -> {
                        calendar.setToday(LocalDate.now());
                        calendar.setTime(LocalTime.now());
                    });

                    try {
                        // update every 10 seconds
                        sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        updateTimeThread.setPriority(Thread.MIN_PRIORITY);
        updateTimeThread.setDaemon(true);
        updateTimeThread.start();

        calendar.showMonthPage();
        pnlHost.getChildren().add(calendar);
    }

    ////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////
    //backbtn action function, direct the user back to the main page////////////
    ////////////////////////////////////////////////////////////////////////////
    
    @FXML
    public void BackToMain(ActionEvent event){
        try{
                Stage stage = (Stage)this.backbtn.getScene().getWindow();
                stage.close();
                MainPage();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    private void MainPage(){
        try{
            Stage userstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/MainPage/Main.fxml"));
            //StudentPlanController studentcontroller = (StudentPlanController)loader.getController();
            Scene scene = new Scene(root);
            userstage.setScene(scene);
            userstage.setTitle("Main Page");
            userstage.setResizable(false);
            userstage.show();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }


}
