package com.example.sms_java.controller;

import com.example.sms_java.dao.StudentDAO;
import com.example.sms_java.model.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class StudentController {

    @FXML
    private TextField regNoField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField courseField;
    @FXML
    private TableView<Student> studentTable;
    @FXML
    private TableColumn<Student, Integer> idColumn;
    @FXML
    private TableColumn<Student, String> regNoColumn;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, String> courseColumn;

    private final StudentDAO dao = new StudentDAO();
    private final ObservableList<Student> students = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        regNoColumn.setCellValueFactory(new PropertyValueFactory<>("regNo"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));

        loadStudents();
    }

    private void loadStudents() {
        students.setAll(dao.getAllStudents());
        studentTable.setItems(students);
    }

    @FXML
    private void onAddStudentClick() {
        String regNo = regNoField.getText();
        String name = nameField.getText();
        String course = courseField.getText();

        if (regNo.isEmpty() || name.isEmpty() || course.isEmpty()) {
            return;
        }

        Student student = new Student(regNo, name, course);
        dao.addStudent(student);
        
        regNoField.clear();
        nameField.clear();
        courseField.clear();
        
        loadStudents();
    }
}

