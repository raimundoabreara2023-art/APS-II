module br.com.agenda_aniver {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.com.agenda_aniver.visao to javafx.fxml;
    opens br.com.agenda_aniver.modelo to javafx.base;

    exports br.com.agenda_aniver;
}