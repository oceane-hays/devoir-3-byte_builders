module com.example.robotix {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires com.fasterxml.jackson.databind;


    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires com.opencsv;
    requires org.kordamp.bootstrapfx.core;
    requires org.junit.jupiter.api;

    opens com.example.robotix to com.fasterxml.jackson.databind;
    //opens com.example.robotix to javafx.fxml;
    exports com.example.robotix;
    exports com.example.robotix.Contoller;
    opens com.example.robotix.Contoller to javafx.fxml;
    exports com.example.robotix.Test;
    opens com.example.robotix.Test to javafx.fxml;
}
