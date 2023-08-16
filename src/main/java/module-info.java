module com.codedotorg {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.codedotorg to javafx.fxml;
    exports com.codedotorg;
}
