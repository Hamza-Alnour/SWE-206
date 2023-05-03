module com.example.swe_206 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.swe_206 to javafx.fxml;
    exports com.example.swe_206;
}