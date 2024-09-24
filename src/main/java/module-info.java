module com.example.atcmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires java.sql;
    requires mysql.connector.java;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires java.persistence;
    requires jakarta.persistence;
    //requires java.xml.bind;

    opens com.example.atcmanagement to javafx.fxml, org.hibernate.orm.core;
    exports com.example.atcmanagement;
}