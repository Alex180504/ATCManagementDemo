package com.example.atcmanagement;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Scene;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import java.util.Objects;

import static com.example.atcmanagement.AuthenticationManager.setRole;
import static com.example.atcmanagement.DBConnect.sessionFactory;


public class LoginController {

    @FXML
    private Button login_btn;
    @FXML
    private PasswordField password_box;
    @FXML
    private TextField login_box;
    @FXML
    private Button forgot_password_btn;
    @FXML
    private Label login_error_lbl;

    @FXML
    protected void initialize() {
        sessionFactory = DBConnect.getSession();
    }
    @FXML
    private void onLoginButtonClick() throws IOException, ClassNotFoundException {
        if (login_box.getText().isEmpty() || password_box.getText().isEmpty()) {
            login_error_lbl.setText("Please enter login credentials");
        }
        else {
            //sessionFactory = DBConnect.getSession();
            String login = login_box.getText();
            String password = password_box.getText();
            if (!checkLogin(login)) {
                login_error_lbl.setText("Incorrect login");
            }
            else if (!checkPassword(login, password)){
                login_error_lbl.setText("Incorrect password");
            }
            else {
                setRoleFromDatabase(login);

                Stage stage;
                Parent root;
                stage = (Stage) forgot_password_btn.getScene().getWindow();
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("home-view.fxml")));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }
    }
    
    @FXML
    private void onForgotPasswordClick() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) forgot_password_btn.getScene().getWindow();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("password-recovery-view.fxml")));
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

    private boolean checkPassword(String login, String password) {
        try (Session session = sessionFactory.openSession()) {
            User key = session.createQuery("FROM User k WHERE k.login = :login AND k.password = :password", User.class)
                    .setParameter("login", login)
                    .setParameter("password", password)
                    .uniqueResult();
            session.close();
            return key != null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private void setRoleFromDatabase(String login) {
        try (Session session = sessionFactory.openSession()) {
            User key = session.createQuery("FROM User WHERE login = :login", User.class)
                    .setParameter("login", login)
                    .uniqueResult();
            session.close();
            if (key != null) {
                String permission = key.getPermissions();
                if (permission.equalsIgnoreCase("owner")) {
                    setRole(AuthenticationManager.user_role.OWNER);
                } else if (permission.equalsIgnoreCase("admin")) {
                    setRole(AuthenticationManager.user_role.ADMIN);
                } else {
                    setRole(AuthenticationManager.user_role.USER);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}