package com.example.atcmanagement;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Objects;

import static com.example.atcmanagement.DBConnect.sessionFactory;

public class Query1View {

    @FXML
    private Label type_lbl;
    @FXML
    private RadioButton for_selected_atc_radio;
    @FXML
    private RadioButton for_all_radio;
    @FXML
    private RadioButton for_selected_district_radio;
    @FXML
    private RadioButton for_selected_atc_type_radio;
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
    private Label text_box_lbl;
    @FXML
    private TextField text_box;
    @FXML
    private ChoiceBox<String> choice_box;
    @FXML
    private Label error_lbl;
    @FXML
    private Button submit_btn;
    @FXML
    private Button cancel_btn;
    @FXML
    private Label beneficiary_lbl;
    @FXML
    private Label non_beneficiary_lbl;
    @FXML

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

        ToggleGroup tg = new ToggleGroup();
        for_all_radio.setToggleGroup(tg);
        for_selected_atc_radio.setToggleGroup(tg);
        for_selected_atc_type_radio.setToggleGroup(tg);
        for_selected_district_radio.setToggleGroup(tg);

        text_box.setOpacity(0);
        text_box.setDisable(true);
        choice_box.setOpacity(0);
        choice_box.setDisable(true);
        type_lbl.setOpacity(0);
        text_box_lbl.setOpacity(0);

        choice_box.getItems().addAll("City", "Departmental", "Institutional");

    }

    @FXML
    private void submit(ActionEvent actionEvent) {

        if (for_selected_atc_radio.isSelected()) {
            String atcId = text_box.getText();
            if (atcId.isEmpty()) {
                error_lbl.setText("Please enter ATC ID");
            }
            else {
                int idAtc = 0;
                try {
                    idAtc = Integer.parseInt(atcId);
                }
                catch (NumberFormatException e){
                    error_lbl.setText("Please enter valid ATC ID");
                }
                beneficiary_lbl.setText(String.valueOf(getBeneficiaryPercentageForATC(idAtc)));
                non_beneficiary_lbl.setText(String.valueOf(100.00 - getBeneficiaryPercentageForATC(idAtc)));
            }
        }
        else if (for_selected_district_radio.isSelected()) {
            String districtName = text_box.getText();
            if (districtName.isEmpty()) {
                error_lbl.setText("Please enter district name");
            }
            else {
                beneficiary_lbl.setText(String.valueOf(getBeneficiaryPercentageForDistrict(districtName)));
                non_beneficiary_lbl.setText(String.valueOf(100.00 - getBeneficiaryPercentageForDistrict(districtName)));
            }
        }
        else if (for_selected_atc_type_radio.isSelected()) {
            String atcType = choice_box.getValue();
            if (atcType == null || atcType.isEmpty()) {
                error_lbl.setText("Please select ATC type");
            }
            else {
                beneficiary_lbl.setText(String.valueOf(getBeneficiaryPercentageForATCType(atcType)));
                non_beneficiary_lbl.setText(String.valueOf(100.00 - getBeneficiaryPercentageForATCType(atcType)));
            }
        }
        else if (for_all_radio.isSelected()) {
            beneficiary_lbl.setText(String.valueOf(getBeneficiaryPercentageForAllATCs()));
            non_beneficiary_lbl.setText(String.valueOf(100.00 - getBeneficiaryPercentageForAllATCs()));
        }
        else {
            error_lbl.setText("Please select an option");
        }
    }


    private double getBeneficiaryPercentageForAllATCs() {
        try (Session session = sessionFactory.openSession()) {
            String query = "SELECT COUNT(s) FROM Subscriber s WHERE s.isBeneficiary = true";
            long beneficiaryCount = session.createQuery(query, Long.class).getSingleResult();

            query = "SELECT COUNT(s) FROM Subscriber s";
            long totalCount = session.createQuery(query, Long.class).getSingleResult();

            return (beneficiaryCount / (double) totalCount) * 100;
        }
    }

    public double getBeneficiaryPercentageForATC(int atcId) {
        try (Session session = sessionFactory.openSession()) {
            String query = "SELECT COUNT(s) FROM Subscriber s WHERE s.isBeneficiary = true AND s.atc.id = :atcId";
            long beneficiaryCount = session.createQuery(query, Long.class)
                    .setParameter("atcId", atcId)
                    .getSingleResult();

            query = "SELECT COUNT(s) FROM Subscriber s WHERE s.atc.id = :atcId";
            long totalCount = session.createQuery(query, Long.class)
                    .setParameter("atcId", atcId)
                    .getSingleResult();

            return (beneficiaryCount / (double) totalCount) * 100;
        }
    }

    private double getBeneficiaryPercentageForDistrict(String district) {
        try (Session session = sessionFactory.openSession()) {
            String query = "SELECT COUNT(s) FROM Subscriber s WHERE s.isBeneficiary = true AND s.phone.adress.district = :district";
            long beneficiaryCount = session.createQuery(query, Long.class)
                    .setParameter("district", district)
                    .getSingleResult();

            query = "SELECT COUNT(s) FROM Subscriber s WHERE s.phone.adress.district = :district";
            long totalCount = session.createQuery(query, Long.class)
                    .setParameter("district", district)
                    .getSingleResult();

            return (beneficiaryCount / (double) totalCount) * 100;
        }
    }

    private double getBeneficiaryPercentageForATCType(String atcType) {
        try (Session session = sessionFactory.openSession()) {
            String query = "SELECT COUNT(s) FROM Subscriber s WHERE s.isBeneficiary = true AND s.atc.type = :atcType";
            long beneficiaryCount = session.createQuery(query, Long.class)
                    .setParameter("atcType", atcType)
                    .getSingleResult();

            query = "SELECT COUNT(s) FROM Subscriber s WHERE s.atc.type = :atcType";
            long totalCount = session.createQuery(query, Long.class)
                    .setParameter("atcType", atcType)
                    .getSingleResult();

            return (beneficiaryCount / (double) totalCount) * 100;
        }
    }

    @FXML
    private void forSelATC(ActionEvent actionEvent) {
        text_box_lbl.setOpacity(1);
        text_box.setOpacity(1);
        text_box.setDisable(false);
        choice_box.setOpacity(0);
        choice_box.setDisable(true);
        type_lbl.setOpacity(0);
        text_box_lbl.setText("Enter ATC ID:");
    }

    @FXML
    private void forAllATC(ActionEvent actionEvent) {
        text_box_lbl.setOpacity(0);
        text_box.setOpacity(0);
        text_box.setDisable(true);
        choice_box.setOpacity(0);
        choice_box.setDisable(true);
        type_lbl.setOpacity(0);
    }

    @FXML
    private void forSelDistrict(ActionEvent actionEvent) {
        text_box_lbl.setOpacity(1);
        text_box.setOpacity(1);
        text_box.setDisable(false);
        choice_box.setOpacity(0);
        choice_box.setDisable(true);
        type_lbl.setOpacity(0);
        text_box_lbl.setText("Enter district name:");
    }

    @FXML
    private void forSelType(ActionEvent actionEvent) {
        text_box_lbl.setOpacity(0);
        text_box.setOpacity(0);
        text_box.setDisable(true);
        choice_box.setOpacity(1);
        choice_box.setDisable(false);
        type_lbl.setOpacity(1);
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
