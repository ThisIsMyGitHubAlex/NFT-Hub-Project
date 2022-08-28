module nft_hub_project.nft_hub {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens start to javafx.fxml;
    exports start;

    opens controllers to javafx.fxml;
    exports controllers;

}