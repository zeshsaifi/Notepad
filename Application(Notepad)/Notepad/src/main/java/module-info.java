module com.example.notepad {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zeeshan.notepad to javafx.fxml;
    exports com.zeeshan.notepad;
}