module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports pl.marcinnapierala.passswordManager.launcher;
    opens pl.marcinnapierala.passswordManager.launcher to javafx.fxml;
}