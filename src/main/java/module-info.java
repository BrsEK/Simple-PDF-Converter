module com.krinitsky {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox;
    requires org.apache.pdfbox.tools;
    requires java.desktop;

    opens com.krinitsky to javafx.fxml;
    exports com.krinitsky;
}