module com.example.robotix {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires java.sql;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.opencsv;
    requires org.kordamp.bootstrapfx.core;
    requires org.junit.jupiter.api;

    opens com.example.robotix to javafx.fxml;
    exports com.example.robotix;
}