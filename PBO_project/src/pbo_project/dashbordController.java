/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package pbo_project;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.chart.XYChart;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * FXML Controller class
 *
 * @author boytr
 */
public class dashbordController implements Initializable {

    @FXML
    private TableColumn<studentData, String> studentGrade_col_final;

    @FXML
    private TextField studentGrade_search;

    @FXML
    private TextField addStudent_search;

    @FXML
    private Button addStudent_updateBtn;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_course;

    @FXML
    private Button studentGrade_btn;

    @FXML
    private AnchorPane main_form;

    @FXML
    private TableColumn<courseData, String> ecourse_col_degree;

    @FXML
    private TableColumn<studentData, String> addStudent_col_studentNum;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_studentNum;

    @FXML
    private Label home_totalMale;

    @FXML
    private AnchorPane studentGrade_form;

    @FXML
    private AnchorPane addStudent_form;

    @FXML
    private Button logout;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_year;

    @FXML
    private TextField studentGrade_firstSem;

    @FXML
    private Label studentGrade_year;

    @FXML
    private AnchorPane home_form;

    @FXML
    private ComboBox<?> addStudent_year;

    @FXML
    private TextField studentGrade_studentNum;

    @FXML
    private TableColumn<courseData,String> ecourse_col_cousre;

    @FXML
    private Button addStudent_btn;

    @FXML
    private Button ecourse_clearBtn;

    @FXML
    private Button studentGrade_clearBtn;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_secondSem;

    @FXML
    private Button studentGrade_updateBtn;

    @FXML
    private TableColumn<courseData, String> ecourse_col_description;

    @FXML
    private LineChart<?, ?> home_totalMaleChart;

    @FXML
    private TableColumn<studentData, String> addStudent_col_year;

    @FXML
    private TextField addStudent_lastName;

    @FXML
    private TableView<studentData> addStudent_tableView;

    @FXML
    private Label home_totalFemale;

    @FXML
    private TableColumn<studentData, String> addStudent_col_lastName;

    @FXML
    private TextField ecourse_course;

    @FXML
    private TableColumn<studentData, String> addStudent_col_status;

    @FXML
    private TextField addStudent_studentNum;

    @FXML
    private TableColumn<studentData, String> studentGrade_col_firstSem;

    @FXML
    private DatePicker addStudent_birthDate;

    @FXML
    private TableColumn<studentData, String> addStudent_col_fristName;

    @FXML
    private ComboBox<?> addStudent_course;

    @FXML
    private TextField studentGrade_secondSem;

    @FXML
    private TableView<studentData> studentGrade_tableView;

    @FXML
    private Label home_totalEnrolled;

    @FXML
    private TableView<courseData> ecourse_tableView;

    @FXML
    private Button close;

    @FXML
    private Button addStudent_clearBtn;

    @FXML
    private Button ecourse_deleteBtn;

    @FXML
    private TextField ecourse_description;

    @FXML
    private BarChart<?, ?> home_totalEnrolledChart;

    @FXML
    private TableColumn<studentData, String> addStudent_col_birthDay;

    @FXML
    private Button addStudent_addBtn;

    @FXML
    private Button ecourse_btn;

    @FXML
    private Label studentGrade_course;

    @FXML
    private TableColumn<studentData, String> addStudent_col_course;

    @FXML
    private TextField addStudent_firstName;

    @FXML
    private Button ecourse_updateBtn;

    @FXML
    private ComboBox<?> addStudent_status;

    @FXML
    private Button addStudent_deleteBtn;

    @FXML
    private AreaChart<?, ?> home_totalFemaleChart;

    @FXML
    private Button home_btn;

    @FXML
    private TableColumn<studentData, String> addStudent_col_gender;

    @FXML
    private ComboBox<?> addStudent_gender;

    @FXML
    private Button ecourse_addBtn;

    @FXML
    private TextField ecourse_degree;

    @FXML
    private ImageView addStudent_imageView;

    @FXML
    private AnchorPane ecourse_form;

    @FXML
    private Label username;
    
    
    @FXML
    private Button addStudent_imageBtn;
    
    
    
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;
    private Image image;
    
    
    public void homeDisplayTotalEnroledStudent(){
        
        String sql = "SELECT COUNT(id) FROM student";
        
        connect = database.conectDb();
        
        int countEnrolled = 0;
        
        try{
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                countEnrolled = result.getInt("COUNT(id)");
            }
            
            home_totalEnrolled.setText(String.valueOf(countEnrolled));
            
        }catch (Exception e) {e.printStackTrace();}
    }
    
    public void homeDisplayFemaleEnrolled(){
        
        String sql = "SELECT COUNT(id) FROM student WHERE gender='FEMALE'and status ='Enrolled'";
        
        connect = database.conectDb();
        
        try{
            int countFemale = 0;
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            if(result.next()){
                countFemale = result.getInt("COUNT(id)");
        }
            home_totalFemale.setText(String.valueOf(countFemale));
            
        }catch (Exception e) {e.printStackTrace();}
        
    }
    
    
    public void homeDisplayMaleEnrolled(){
        
        String sql = "SELECT COUNT(id) FROM student WHERE gender='MALE' and status ='Enrolled'";
        
        connect = database.conectDb();
        
        try{
            int countMale = 0;
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            
            if(result.next()){
                countMale = result.getInt("COUNT(id)");
            }
            home_totalMale.setText(String.valueOf(countMale));
            
        }catch (Exception e) {e.printStackTrace();}
    }
    
    public void homeDisplayTotalEnrolledChart(){
        
        home_totalEnrolledChart.getData().clear();
        
        String sql = "SELECT date,COUNT(id) FROM student WHERE status = 'Enrolled'  GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";
        
        connect = database.conectDb();
        
        try{
            XYChart.Series chart = new XYChart.Series(); 
            
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                chart.getData().add(new XYChart.Data(result.getString(1),result.getString(2)));            
            }
            
        home_totalEnrolledChart.getData().add(chart);
            
        }catch (Exception e) {e.printStackTrace();}
    }
    
    
    
public void homeDispalyFemaleEnrolledChart(){
    
    home_totalFemaleChart.getData().clear();
    
    
    String sql = "SELECT date, COUNT(id) FROM student WHERE status = 'Enrolled' and gender = 'Femlae'  GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5 ";
    
    connect = database.conectDb();
    
    
    try{
         XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
            }
            
            home_totalFemaleChart.getData().add(chart);
    }catch (Exception e) {e.printStackTrace();}
}    
     


public void homeDisplayMaleEnrolledChart(){
    
    home_totalMaleChart.getData().clear();
    
    String sql = "SELECT date, COUNT(id) FROM student WHERE status = 'Enrolled' and gender = 'Female' GROUP BY date ORDER BY TIMESTAMP(date) ASC LIMIT 5";
    
    connect = database.conectDb();
    
    try {
            XYChart.Series chart = new XYChart.Series();

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                chart.getData().add(new XYChart.Data(result.getString(1), result.getInt(2)));
                
               home_totalMaleChart.getData().add(chart);
            }
            }catch (Exception e) {e.printStackTrace();
        }
    
}

    
    
    public void addStudentAdd(){
        
        String insertData = "INSERT INTO student"+
                "(studentNum,year,course,firstName,lastName,gender,birth,status,image,date)"
                +"VALUES(?,?,?,?,?,?,?,?,?,?)";
        
        connect = database.conectDb();
        
          try {
            Alert alert;

            if (addStudent_studentNum.getText().isEmpty()
                    || addStudent_year.getSelectionModel().getSelectedItem() == null
                    || addStudent_course.getSelectionModel().getSelectedItem() == null
                    || addStudent_firstName.getText().isEmpty()
                    || addStudent_lastName.getText().isEmpty()
                    || addStudent_gender.getSelectionModel().getSelectedItem() == null
                    || addStudent_birthDate.getValue() == null
                    || addStudent_status.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
               
                String checkData = "SELECT studentNum FROM student WHERE studentNum = '"
                        + addStudent_studentNum.getText() + "'";

                statement = connect.createStatement();
                result = statement.executeQuery(checkData);

                if (result.next()) {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Student #" + addStudent_studentNum.getText() + " was already exist!");
                    alert.showAndWait();
                } else {
                    prepare = connect.prepareStatement(insertData);
                    prepare.setString(1, addStudent_studentNum.getText());
                    prepare.setString(2, (String) addStudent_year.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String) addStudent_course.getSelectionModel().getSelectedItem());
                    prepare.setString(4, addStudent_firstName.getText());
                    prepare.setString(5, addStudent_lastName.getText());
                    prepare.setString(6, (String) addStudent_gender.getSelectionModel().getSelectedItem());
                    prepare.setString(7, String.valueOf(addStudent_birthDate.getValue()));
                    prepare.setString(8, (String) addStudent_status.getSelectionModel().getSelectedItem());

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");
                    prepare.setString(9, uri);

                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    prepare.setString(10, String.valueOf(sqlDate));

                    prepare.executeUpdate();

                    String insertStudentGrade = "INSERT INTO student_grade (studentNum,year,course,first_sem,second_sem,final) "
                            + "VALUES(?,?,?,?,?,?)";

                    prepare = connect.prepareStatement(insertStudentGrade);
                    prepare.setString(1, addStudent_studentNum.getText());
                    prepare.setString(2, (String) addStudent_year.getSelectionModel().getSelectedItem());
                    prepare.setString(3, (String) addStudent_course.getSelectionModel().getSelectedItem());
                    prepare.setString(4, "0");
                    prepare.setString(5, "0");
                    prepare.setString(6, "0");

                    prepare.executeUpdate();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Added!");
                    alert.showAndWait();

                   
                    addStudentShowListData();
                    addStudentClear();
                }
            }

        } catch (Exception e) {e.printStackTrace();}
        
    }
    
    
    public void addStudentUpdate(){
        
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String updateData = "UPDATE student SET "
                + "year = '" + addStudent_year.getSelectionModel().getSelectedItem()
                + "', course = '" + addStudent_course.getSelectionModel().getSelectedItem()
                + "', firstName = '" + addStudent_firstName.getText()
                + "', lastName = '" + addStudent_lastName.getText()
                + "', gender = '" + addStudent_gender.getSelectionModel().getSelectedItem()
                + "', birth = '" + addStudent_birthDate.getValue()
                + "', status = '" + addStudent_status.getSelectionModel().getSelectedItem()
                + "', image = '" + uri + "' WHERE studentNum = '"
                + addStudent_studentNum.getText() + "'";

        connect = database.conectDb();

        try {
            Alert alert;
            if (addStudent_studentNum.getText().isEmpty()
                    || addStudent_year.getSelectionModel().getSelectedItem() == null
                    || addStudent_course.getSelectionModel().getSelectedItem() == null
                    || addStudent_firstName.getText().isEmpty()
                    || addStudent_lastName.getText().isEmpty()
                    || addStudent_gender.getSelectionModel().getSelectedItem() == null
                    || addStudent_birthDate.getValue() == null
                    || addStudent_status.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student #" + addStudent_studentNum.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                   
                    addStudentShowListData();
                    addStudentClear();

                } else {
                    return;
                } 
            }
        }catch (Exception e) {e.printStackTrace();}                 
    }
    
    public void addStudentDelete(){
        String deleteData = "DELETE FROM student WHERE studentNum = '"
                + addStudent_studentNum.getText() + "'";

        connect = database.conectDb();

        try {
            Alert alert;
            if (addStudent_studentNum.getText().isEmpty()
                    || addStudent_year.getSelectionModel().getSelectedItem() == null
                    || addStudent_course.getSelectionModel().getSelectedItem() == null
                    || addStudent_firstName.getText().isEmpty()
                    || addStudent_lastName.getText().isEmpty()
                    || addStudent_gender.getSelectionModel().getSelectedItem() == null
                    || addStudent_birthDate.getValue() == null
                    || addStudent_status.getSelectionModel().getSelectedItem() == null
                    || getData.path == null || getData.path == "") {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Student #" + addStudent_studentNum.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {

                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    String checkData = "SELECT studentNum FROM student_grade "
                            + "WHERE studentNum = '" + addStudent_studentNum.getText() + "'";

                    prepare = connect.prepareStatement(checkData);
                    result = prepare.executeQuery();
                    if (result.next()) {
                        String deleteGrade = "DELETE FROM student_grade WHERE "
                                + "studentNum = '" + addStudent_studentNum.getText() + "'";

                        statement = connect.createStatement();
                        statement.executeUpdate(deleteGrade);

                    }

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                   
                    addStudentShowListData();
                    addStudentClear();

                } else {
                    return;
                }

            }
        } catch (Exception e) {e.printStackTrace();
        }
    }
    
    
    public void addStudentsSearch() {

        FilteredList<studentData> filter = new FilteredList<>(addStudentListD, e -> true);

        addStudent_search.textProperty().addListener((Observable, oldValue, newValue) -> {

            filter.setPredicate(predicateStudentData -> {

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateStudentData.getStudentNum().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getYear().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getCourse().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getFirstName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getLastName().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getGender().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getBirth().toString().contains(searchKey)) {
                    return true;
                } else if (predicateStudentData.getStatus().toLowerCase().contains(searchKey)) {
                    return true;
                } else {
                    return false;
                }
            });
        });

        SortedList<studentData> sortList = new SortedList<>(filter);

        sortList.comparatorProperty().bind(addStudent_tableView.comparatorProperty());
        addStudent_tableView.setItems(sortList);

    }

    
    public void addStudentClear(){
        addStudent_studentNum.setText("");
        addStudent_year.getSelectionModel().clearSelection();
        addStudent_course.getSelectionModel().clearSelection();
        addStudent_firstName.setText("");
        addStudent_lastName.setText("");
        addStudent_gender.getSelectionModel().clearSelection();
        addStudent_birthDate.setValue(null);
        addStudent_status.getSelectionModel().clearSelection();
        addStudent_imageView.setImage(null);

        getData.path = "";
    }
    
    public void addStudentIsertImage(){
        
        FileChooser open = new FileChooser();
        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File","*jpg","*png"));
        
        File file = open.showOpenDialog(main_form.getScene().getWindow());
        
        
        if(file != null){
            
            image = new Image(file.toURI().toString(),136,155,false,true);
            addStudent_imageView.setImage(image);
            
            
            getData.path = file.getAbsolutePath();
        }
        
    }
    
    
    private String[] yearList = {"First Year", "Second Year", "Third Year", "Fourth Year"};
    public void addStudentYearList(){
        List<String> yearL = new ArrayList<>();
        
        for(String data: yearList){
            yearL.add(data);
        }
        
        ObservableList ObList = FXCollections.observableArrayList(yearL);
        addStudent_year.setItems(ObList);
     }
    
    
    public void addStudentCourseList(){
        
        String listCourse = "SELECT * FROM course";
        
        
        connect = database.conectDb();
        
        try{
            
            ObservableList listC = FXCollections.observableArrayList();
            
            prepare = connect.prepareStatement(listCourse);
            result = prepare.executeQuery();
            
            while(result.next()){
                listC.add(result.getString("course"));
            }
            
            addStudent_course.setItems(listC);
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    
    private String[] genderList = {"Male", "Female", "Others"};
    public void addStudentGenderList(){
        List<String> genderL = new ArrayList<>();
        
        for(String data: genderList){
            genderL.add(data);
        }
        
        ObservableList ObList = FXCollections.observableArrayList(genderL);
        addStudent_gender.setItems(ObList);
    }
    
    private String[] statusList = {"Enrolled", "Not Enrolled", "Inactive"};
    public void addStudentStatusList(){
      List<String> statusL = new ArrayList<>();
        
        for(String data: statusList){
            statusL.add(data);
        }
        
        ObservableList ObList = FXCollections.observableArrayList(statusL);
        addStudent_status.setItems(ObList);
    }
    
    public ObservableList<studentData>addStudentListData(){
        
        ObservableList<studentData>listStudent = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM student";
        
         connect = database.conectDb();
         
         try{
             
            studentData studentD; 
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while(result.next()){
                studentD = new studentData(result.getInt("studentNum")
                        ,result.getString("year")
                        ,result.getString("course")
                        , result.getString("firstName")
                        ,result.getString("lastName")
                        , result.getString("gender")
                        ,result.getDate("birth")
                        ,result.getString("status")
                        ,result.getString("image"));
                
                listStudent.add(studentD);
            }
             
         }catch(Exception e){e.printStackTrace();}
        return listStudent;
    }
    
    
    private ObservableList<studentData>addStudentListD;
    public void addStudentShowListData(){
        addStudentListD = addStudentListData();
        
        addStudent_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        addStudent_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        addStudent_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        addStudent_col_fristName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        addStudent_col_lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addStudent_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        addStudent_col_birthDay.setCellValueFactory(new PropertyValueFactory<>("birth"));
        addStudent_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
        
        addStudent_tableView.setItems(addStudentListD);
    }
    
    
    public void addStudentSelect(){
        studentData studentD = addStudent_tableView.getSelectionModel().getSelectedItem();
        int num = addStudent_tableView.getSelectionModel().getSelectedIndex();
        
        
        if ((num -1 ) < -1){return;}
        
        
        addStudent_studentNum.setText(String.valueOf(studentD.getStudentNum()));
        addStudent_firstName.setText(studentD.getFirstName());
        addStudent_lastName.setText(studentD.getLastName());
        addStudent_birthDate.setValue(LocalDate.parse(String.valueOf(studentD.getBirth())));
        
        String uri = "file:" + studentD.getImage();
        
        image = new Image(uri,136,155,false,true);
        addStudent_imageView.setImage(image);
        
        getData.path = studentD.getImage();
    }
    
    public ObservableList<courseData> avaibleCourseListData(){
        
        ObservableList<courseData>listData = FXCollections.observableArrayList();
        
        String sql = "SELECT * FROM course";
        
        connect = database.conectDb();
        
        try{
            courseData  courseD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();
            
            while (result.next()){
                courseD = new courseData(result.getString("course")
                    , result.getString("description")
                    , result.getString("degree"));
                
                listData.add(courseD);
            }
            
        }catch(Exception e){e.printStackTrace();}
        return listData;
    }
    
    public void availableCourseAdd(){
        
        String isertData = "INSERT INTO course (course,description,degree) VALUE(?,?,?)";
        
        connect = database.conectDb();
        
        try{
            Alert alert;
            
            if(ecourse_course.getText().isEmpty()
                    || ecourse_description.getText().isEmpty()
                    || ecourse_degree.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                
                String checkData = "SELECT course FROM course WHERE course = '" 
                        +ecourse_course.getText()+ "'";
                
                statement = connect.createStatement();
                result = statement.executeQuery(checkData);
                
                if(result.next()){
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Course :" +ecourse_course.getText()+ "was already exist!" );
                    alert.showAndWait();
                }else{
                    prepare = connect.prepareStatement(isertData);
                    prepare.setString(1, ecourse_course.getText());
                    prepare.setString(2, ecourse_description.getText());
                    prepare.setString(3, ecourse_degree.getText());
                    
                    
                    prepare.executeUpdate();
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Susccesfully Added!");
                    alert.showAndWait();
                    
                    availableCourseShowListData();
                    availableCourseClear();
                }
            }
            
        }catch(Exception e){e.printStackTrace();}
    
    }
    
    
    public void availableCourseUpadte(){
        
        String updateData = "UPDATE course SET description = '"
                +ecourse_description.getText()+"',degree = '"
                +ecourse_degree.getText()+"'WHERE course = '"+
                ecourse_course.getText()+"'";
        
        connect = database.conectDb();
        
        try{
            Alert alert;
            
            if(ecourse_course.getText().isEmpty()
                    || ecourse_description.getText().isEmpty()
                    || ecourse_degree.getText().isEmpty()){
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Massage");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            }else{
                
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE course: " +ecourse_course.getText()+ "?");
                Optional<ButtonType> option = alert.showAndWait();
                
                if(option.get().equals(ButtonType.OK)){
                    statement = connect.createStatement();
                    statement.executeLargeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Massage");
                    alert.setHeaderText(null);
                    alert.setContentText("Succesfully Update!");
                    alert.showAndWait();
                    
                    
                    availableCourseShowListData();
                    availableCourseClear();
                }else return;
            }
            
        }catch(Exception e){e.printStackTrace();}
        
    }
    
    public void availableCourseDelete(){
        
String deleteData = "DELETE FROM course WHERE course = '"
                + ecourse_course.getText() + "'";

        connect = database.conectDb();

        try {
            Alert alert;

            if (ecourse_course.getText().isEmpty()
                    || ecourse_description.getText().isEmpty()
                    || ecourse_degree.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to DELETE Course: " + ecourse_course.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(deleteData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted!");
                    alert.showAndWait();

                    
                    availableCourseShowListData();
                    availableCourseClear();
                }else{ 
                    return;
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void availableCourseClear(){
        ecourse_course.setText("");
        ecourse_description.setText("");
        ecourse_degree.setText("");
    }

    public void availableCourseShowListData(){
        
        ecourse_col_cousre.setCellValueFactory(new PropertyValueFactory<>("course"));
        ecourse_col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        ecourse_col_degree.setCellValueFactory(new PropertyValueFactory<>("degree"));
        
        
        ecourse_tableView.setItems(avaibleCourseListData());
    }
    
    public void availabelCourseSelect(){
        courseData courseD = ecourse_tableView.getSelectionModel().getSelectedItem();
        int num = ecourse_tableView.getSelectionModel().getSelectedIndex();
        
        if((num -1) < -1  ){
            return;
        }
        
        ecourse_course.setText(courseD.getCourse());
        ecourse_description.setText(courseD.getDescription());
        ecourse_degree.setText(courseD.getDegree());
        
    }
    
     public ObservableList<studentData> studentGradeListData() {

        ObservableList<studentData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM student_grade";

        connect = database.conectDb();

        try {
            studentData studentD;

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                studentD = new studentData(result.getInt("studentNum"),
                         result.getString("year"),
                         result.getString("course"),
                         result.getDouble("first_sem"),
                         result.getDouble("second_sem"),
                         result.getDouble("final"));

                listData.add(studentD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }
     
     
      private ObservableList<studentData> studentGradeList;

    public void studentGradeShowListData() {
        studentGradeList = studentGradeListData();

        studentGrade_col_studentNum.setCellValueFactory(new PropertyValueFactory<>("studentNum"));
        studentGrade_col_year.setCellValueFactory(new PropertyValueFactory<>("year"));
        studentGrade_col_course.setCellValueFactory(new PropertyValueFactory<>("course"));
        studentGrade_col_firstSem.setCellValueFactory(new PropertyValueFactory<>("firstSem"));
        studentGrade_col_secondSem.setCellValueFactory(new PropertyValueFactory<>("secondSem"));
        studentGrade_col_final.setCellValueFactory(new PropertyValueFactory<>("finals")); 
        studentGrade_tableView.setItems(studentGradeList);

    }
    
    
    public void studentGradeSelect(){
        
        studentData studentD = studentGrade_tableView.getSelectionModel().getSelectedItem();
        int num = studentGrade_tableView.getSelectionModel().getFocusedIndex();
        
        if((num - 1) < -1 ){return;}
        
        studentGrade_studentNum.setText(String.valueOf(studentD.getStudentNum()));
        studentGrade_year.setText(studentD.getYear());
        studentGrade_course.setText(studentD.getCourse());
        studentGrade_firstSem.setText(String.valueOf((studentD.getFirstName())));
        studentGrade_secondSem.setText(String.valueOf(studentD.getSecondSem()));
        
    }
    
    
     public void studentGradeUpdate() {
        double finalCheck1 = 0;
        double finalCheck2 = 0;

        String checkData = "SELECT * FROM student_grade WHERE studentNum = '"
                + studentGrade_studentNum.getText() + "'";

        connect = database.conectDb();

        double finalResult = 0;

        try {

            prepare = connect.prepareStatement(checkData);
            result = prepare.executeQuery();

            if (result.next()) {
                finalCheck1 = result.getDouble("first_sem");
                finalCheck2 = result.getDouble("second_sem");
            }

            if (finalCheck1 == 0 || finalCheck2 == 0) {
                finalResult = 0;
            } else { //LIKE (X+Y)/2 AVE WE NEED TO FIND FOR FINALS
                finalResult = (Double.parseDouble(studentGrade_firstSem.getText())
                        + Double.parseDouble(studentGrade_secondSem.getText()) / 2);
            }

            String updateData = "UPDATE student_grade SET "
                    + " year = '" + studentGrade_year.getText()
                    + "', course = '" + studentGrade_course.getText()
                    + "', first_sem = '" + studentGrade_firstSem.getText()
                    + "', second_sem = '" + studentGrade_secondSem.getText()
                    + "', final = '" + finalResult + "' WHERE studentNum = '"
                    + studentGrade_studentNum.getText() + "'";

            Alert alert;

            if (studentGrade_studentNum.getText().isEmpty()
                    || studentGrade_year.getText().isEmpty()
                    || studentGrade_course.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to UPDATE Student #" + studentGrade_studentNum.getText() + "?");
                Optional<ButtonType> option = alert.showAndWait();

                if (option.get().equals(ButtonType.OK)) {
                    statement = connect.createStatement();
                    statement.executeUpdate(updateData);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Updated!");
                    alert.showAndWait();

                    // TO UPDATE THE TABLEVIEW
                    studentGradeShowListData();
                } else {
                    return;
                }

            }// NOT WE ARE CLOSER TO THE ENDING PART  :) LETS PROCEED TO DASHBOARD FORM 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void studentGradeClear(){
        studentGrade_studentNum.setText("");
        studentGrade_year.setText("");
        studentGrade_course.setText("");
        studentGrade_firstSem.setText("");
        studentGrade_secondSem.setText("");
        
    }
    
    public void studentGradeSearch(){
        
        FilteredList<studentData> filter = new FilteredList<>(studentGradeList, e-> true);
        
        studentGrade_search.textProperty().addListener((observable, oldValue, newValue) ->{
            
            filter.setPredicate(predicateStudentData ->{
                
                if(newValue.isEmpty() || newValue == null ){
                    
                    return true;
                    
                }
                String searchKey = newValue.toLowerCase();
                
                if(predicateStudentData.getStudentNum().toString().contains(searchKey)){
                    return true;
                }else if(predicateStudentData.getYear().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicateStudentData.getCourse().toLowerCase().contains(searchKey)){
                    return true;
                }else if(predicateStudentData.getFristSem().toString().contains(searchKey)){
                    return true;
                }else if(predicateStudentData.getSecondSem().toString().contains(searchKey)){
                    return true;
                }else if(predicateStudentData.getFinals().toString().contains(searchKey)){
                    return true;
                }else return false;
            });
        });
        
        SortedList<studentData> sortList = new SortedList<>(filter);
        
        sortList.comparatorProperty().bind(studentGrade_tableView.comparatorProperty());
        studentGrade_tableView.setItems(sortList);
        
    }
    
    private double x = 0;
    private double y = 0;

    public void logout(){
        try {
            
             
        Alert alert = new Alert(AlertType.CONFIRMATION);   
        alert.setTitle("Confirmation Message");
        alert.setHeaderText(null);
        alert.setContentText("Apakah kamu yakin ingin keluar?");
        
        Optional<ButtonType> option = alert.showAndWait();
        
        if(option.get().equals(ButtonType.OK)){   
       
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();
            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);
                
                  stage.setOpacity(.8);
            });
            
            root.setOnMouseReleased((MouseEvent event) -> {
                    stage.setOpacity(1);
                });

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
            
            logout.getScene().getWindow().hide();
        }else{
            return;
        }
    }catch (Exception e){e.printStackTrace();
    }
    }

    public void close() {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        home_btn.setOnAction(event -> {
            home_form.setVisible(true);
            addStudent_form.setVisible(false);
            ecourse_form.setVisible(false);
            studentGrade_form.setVisible(false);

            home_btn.setStyle("-fx-background-color:#B4CFB0");
            addStudent_btn.setStyle("-fx-background-color:transparent");
            ecourse_btn.setStyle("-fx-background-color:transparent");
            studentGrade_btn.setStyle("-fx-background-color:transparent");
            
            
            homeDisplayTotalEnroledStudent();
            homeDisplayFemaleEnrolled();
            homeDisplayMaleEnrolled();
            homeDisplayMaleEnrolledChart();
            homeDispalyFemaleEnrolledChart();
            homeDisplayTotalEnrolledChart();
        });

        addStudent_btn.setOnAction(event -> {
            home_form.setVisible(false);
            addStudent_form.setVisible(true);
            ecourse_form.setVisible(false);
            studentGrade_form.setVisible(false);

            addStudent_btn.setStyle("-fx-background-color:#B4CFB0");
            home_btn.setStyle("-fx-background-color:transparent");
            ecourse_btn.setStyle("-fx-background-color:transparent");
            studentGrade_btn.setStyle("-fx-background-color:transparent");
            
            addStudentShowListData();
            addStudentYearList();
            addStudentGenderList();
            addStudentStatusList();
            addStudentCourseList();
            addStudentsSearch();
        });

        ecourse_btn.setOnAction(event -> {
            home_form.setVisible(false);
            addStudent_form.setVisible(false);
            ecourse_form.setVisible(true);
            studentGrade_form.setVisible(false);

            ecourse_btn.setStyle("-fx-background-color:#B4CFB0");
            addStudent_btn.setStyle("-fx-background-color:transparent");
            home_btn.setStyle("-fx-background-color:transparent");
            studentGrade_btn.setStyle("-fx-background-color:transparent");
            
            availableCourseShowListData();
        });

        studentGrade_btn.setOnAction(event -> {
            home_form.setVisible(false);
            addStudent_form.setVisible(false);
            ecourse_form.setVisible(false);
            studentGrade_form.setVisible(true);

            studentGrade_btn.setStyle("-fx-background-color:#B4CFB0");
            home_btn.setStyle("-fx-background-color:transparent");
            ecourse_btn.setStyle("-fx-background-color:transparent");
            addStudent_btn.setStyle("-fx-background-color:transparent");
            
            studentGradeShowListData();
            studentGradeSearch();
        });
    }

}
