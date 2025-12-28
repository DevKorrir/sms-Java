module com.example.sms_java {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires org.mariadb.jdbc;
    requires java.sql;

    opens com.example.sms_java to javafx.fxml;
    opens com.example.sms_java.model to javafx.base;
    exports com.example.sms_java;
    exports com.example.sms_java.controller;
    opens com.example.sms_java.controller to javafx.fxml;
}