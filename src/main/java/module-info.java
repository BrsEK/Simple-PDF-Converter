module com.krinitsky {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.krinitsky to javafx.fxml;
    exports com.krinitsky;
}