module com.example.datastructures {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.datastructures to javafx.fxml;
    opens com.example.datastructures.controller to javafx.fxml;
    exports com.example.datastructures;
}