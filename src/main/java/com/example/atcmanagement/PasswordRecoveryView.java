package com.example.atcmanagement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.util.Objects;

import static com.example.atcmanagement.DBConnect.sessionFactory;

public class PasswordRecoveryView {
    @FXML
    private Button cancel_btn;
    @FXML
    private Label password_lbl;
    @FXML
    private TextField password_box;
    @FXML
    private TextField login_box;
    @FXML
    private Label login_error_lbl;

    @FXML
    private void passwordLookup(ActionEvent actionEvent) {
        login_error_lbl.setText("");
        if (login_box.getText().isEmpty()) {
            login_error_lbl.setText("Please enter login");
        }
        else {
            String login = login_box.getText();
            if (!checkLogin(login)) {
                login_error_lbl.setText("User does not exist");
            }
            else {
                String password = getPasswordByLogin(login);
                if (password == null || password.length() == 0) {
                    login_error_lbl.setText("Database entry corrupted");
                }
                else {
                    password_lbl.setOpacity(1.0);
                    password_box.setOpacity(1.0);
                    password_box.setText(password);
                }
            }
        }
    }

    @FXML
    private void cancel(ActionEvent actionEvent) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) cancel_btn.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private boolean checkLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            User key = session.createQuery("FROM User WHERE login = :login", User.class)
                    .setParameter("login", login)
                    .uniqueResult();
            session.close();
            return key != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static String getPasswordByLogin(String login) {
        try (Session session = sessionFactory.openSession()) {
            User key = session.createQuery("FROM User WHERE login = :login", User.class)
                    .setParameter("login", login)
                    .uniqueResult();
            session.close();
            if (key != null) {
                return key.getPassword();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
