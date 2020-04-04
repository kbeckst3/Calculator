module calculator{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens sample to javafx.fxml;
    exports sample;
}