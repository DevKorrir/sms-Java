module com.example.sms_java {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.sms_java to javafx.fxml;
    exports com.example.sms_java;
}