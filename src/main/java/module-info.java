module com.krinitsky {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.pdfbox.tools;
    requires java.desktop;
    requires java.net.http;
    requires org.apache.pdfbox;
    requires net.sf.cssbox.pdf2dom;

    opens com.krinitsky to javafx.fxml;
    exports com.krinitsky;
}