package com.example.atcmanagement;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.example.atcmanagement.DBConnect.sessionFactory;


public class AtcView {
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
    @FXML
    private Button add_atc_btn;
    @FXML
    private Button edit_atc_btn;
    @FXML
    private Button delete_atc_btn;

    private Stage stage;
    private Parent root;


    @FXML
    private TableView<Atc> atcTable;
    @FXML
    private TableColumn<Atc, Integer> idColumn;
    @FXML
    private TableColumn<Atc, String> nameColumn;
    @FXML
    private TableColumn<Atc, String> typeColumn;

    @FXML
    protected void initialize() {
        if (AuthenticationManager.getRole() != AuthenticationManager.user_role.OWNER) {
            script_menu.setDisable(true);
            script_menu.setVisible(false);
            admin_menu.setDisable(true);
            admin_menu.setVisible(false);
        }
        if (AuthenticationManager.getRole() == AuthenticationManager.user_role.USER) {
            add_atc_btn.setDisable(true);
            edit_atc_btn.setDisable(true);
            delete_atc_btn.setDisable(true);
        }

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        List<Atc> atcList = getAllAtcs();
        ObservableList<Atc> observableAtcs = FXCollections.observableArrayList(atcList);
        atcTable.setItems(observableAtcs);
    }

    public List<Atc> getAllAtcs() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Atc", Atc.class).getResultList();
        } finally {
            session.close();
        }
    }

    @FXML
    private void addAtc(ActionEvent actionEvent) throws IOException {
        stage = (Stage) menu_bar.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-atc-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void editAtc(ActionEvent actionEvent) {
    }

    @FXML
    private void deleteAtc(ActionEvent actionEvent) {
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
