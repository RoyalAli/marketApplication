package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class girisYapController {
    @FXML
    private Button girisYapButton;
    @FXML
    private Button iptalEtButton;

    @FXML
    private TextField kullaniciAdiTextField;
    @FXML
    private PasswordField sifrePasswordField;


    public void setButtons(ActionEvent actionEvent){
        if(actionEvent.getSource() == girisYapButton){
            String kullaniciAdi = kullaniciAdiTextField.getText();
            String sifre = sifrePasswordField.getText();
            if(kullaniciAdi.equals("Admin") && sifre.equals("Admin")) {
                try {
                    Stage closeStage = (Stage) girisYapButton.getScene().getWindow();
                    Stage stage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    stage.setScene(new Scene(root, 1280, 800));
                    stage.setResizable(false);
                    stage.show();
                    closeStage.close();
                }catch (Exception error){
                    error.printStackTrace();
                }
            }
        }else if(actionEvent.getSource() == iptalEtButton){
            Stage closeStage = (Stage) iptalEtButton.getScene().getWindow();
            closeStage.close();
        }
    }
}
