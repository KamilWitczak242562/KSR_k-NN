module com.example.knn {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.knn to javafx.fxml;
    exports com.example.knn;
}