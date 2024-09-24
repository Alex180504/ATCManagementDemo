package com.example.atcmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static com.example.atcmanagement.DBConnect.sessionFactory;

public class AddAtcView {
    @FXML
    private Button cancel_btn;
    @FXML
    private TextField atc_id_box;
    @FXML
    private TextField atc_name_box;
    @FXML
    private ChoiceBox<String> atc_type_slc;
    @FXML
    private Label error_lbl;
    @FXML
    private Label success_lbl;

    @FXML
    protected void initialize() {
        atc_type_slc.getItems().addAll("City", "Departmental", "Institutional");
        success_lbl.setOpacity(0);
    }
    @FXML
    private void addAtc(ActionEvent actionEvent) {
        success_lbl.setOpacity(0);
        String name = atc_name_box.getText();
        String type = atc_type_slc.getValue();
        String idString = atc_id_box.getText();

        if (name.isEmpty() || type == null || idString.isEmpty()) {
            error_lbl.setText("Please fill in all fields");
        }
        else {
            // Validate if the ID is unique
            try {
                int id = Integer.parseInt(idString);
                if (!isIdUnique(id)) {
                    error_lbl.setText("ATC ID must be unique.");
                    error_lbl.setOpacity(1);
                    success_lbl.setOpacity(0);
                    return;
                }
            } catch (NumberFormatException e) {
                error_lbl.setText("Invalid ATC ID format.");
                error_lbl.setOpacity(1);
                success_lbl.setOpacity(0);
                return;
            }

            error_lbl.setText("");
            success_lbl.setText("ATC added successfully");
            success_lbl.setOpacity(1);

            Atc newAtc = new Atc();
            newAtc.setId(Integer.parseInt(idString));
            newAtc.setName(name);
            newAtc.setType(type);
            saveAtc(newAtc);

            atc_name_box.clear();
            atc_type_slc.getSelectionModel().clearSelection();
        }
    }

    public boolean isIdUnique(int id) {
        Session session = sessionFactory.openSession();
        try {
            Query<Atc> query = session.createQuery("FROM Atc WHERE id = :id");
            query.setParameter("id", id);
            List<Atc> results = query.list();
            return results.isEmpty();
        } finally {
            session.close();
        }
    }

    private void saveAtc(Atc atc) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.persist(atc);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @FXML
    private void cancel (ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) cancel_btn.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("atc-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
