module com.example.swe_206 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;
    requires javax.mail.api;
    //requires org.springframework;

    opens com.example.swe_206 to javafx.fxml;
    exports com.example.swe_206;
}