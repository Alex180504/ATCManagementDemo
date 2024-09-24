package com.example.atcmanagement;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

//import static com.example.atcmanagement.DBConnect.sessionFactory;

public class HomeView {

    @FXML
    private MenuItem atc_view_btn;
    @FXML
    private MenuItem subscribers_view_btn;
    @FXML
    private MenuItem phones_view_btn;
    @FXML
    private MenuItem payments_view_btn;
    @FXML
    private MenuItem inter_calls_view_btn;
    @FXML
    private MenuItem conn_requests_view_btn;
    @FXML
    private MenuItem free_numbers_view_btn;
    @FXML
    private MenuItem exit_btn;
    @FXML
    private MenuItem query1_view_btn;
    @FXML
    private MenuItem query2_view_btn;
    @FXML
    private MenuItem query3_view_btn;
    @FXML
    private MenuItem query4_view_btn;
    @FXML
    private MenuItem query5_view_btn;
    @FXML
    private MenuItem query6_view_btn;
    @FXML
    private MenuItem query7_view_btn;
    @FXML
    private MenuItem query8_view_btn;
    @FXML
    private MenuItem query9_view_btn;
    @FXML
    private Menu script_menu;
    @FXML
    private MenuItem script_view_btn;
    @FXML
    private Menu admin_menu;
    @FXML
    private MenuItem users_view_btn;
    @FXML
    private MenuBar menu_bar;

    private Stage stage;
    private Parent root;

    @FXML
    protected void initialize() {
        if (AuthenticationManager.getRole() != AuthenticationManager.user_role.OWNER) {
            script_menu.setDisable(true);
            script_menu.setVisible(false);
            admin_menu.setDisable(true);
            admin_menu.setVisible(false);
        }
    }

    @FXML
    private void atcView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("atc-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void subscribersView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("subscribers-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void phonesView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("phones-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void paymentsView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("payments-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void InterCallsView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("inter-calls-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void connRequestsView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("conn-requests-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void freeNumbersView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("free-numbers-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void exit(ActionEvent actionEvent) {
        Platform.exit();
    }

    @FXML
    private void query1View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query1-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query2View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query2-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query3View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query3-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query4View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query4-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query5View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query5-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query6View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query6-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query7View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query7-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query8View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query8-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void query9View(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("query9-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void scriptView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("script-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void usersView(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("users-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
