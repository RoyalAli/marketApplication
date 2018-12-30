package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class urunEkleController {
    @FXML
    private TextField urunIDTextfield;
    @FXML
    private TextField urunAdiTextField;
    @FXML
    private TextField urunTuruTextField;
    @FXML
    private TextField alimFiyatiTextField;
    @FXML
    private TextField satisFiyatiTextField;

    @FXML
    private Button ekleButton;
    @FXML
    private Button iptalEtButton;

    public void setButtons(ActionEvent actionEvent){
        if(actionEvent.getSource()==iptalEtButton){
            Stage closeStage = (Stage) iptalEtButton.getScene().getWindow();
            closeStage.close();
        }else if(actionEvent.getSource()==ekleButton){
            try {
                Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/royalali/Desktop/marketApplication/src/sample/urunler.db");
                Statement statement = connection.createStatement();

                statement.execute("insert into urunler values("+
                        Integer.parseInt(urunIDTextfield.getText())+","+
                        "'"+urunAdiTextField.getText()+"',"+
                        "'"+urunTuruTextField.getText()+"',"+
                        Double.parseDouble(alimFiyatiTextField.getText())+","+
                        Double.parseDouble(satisFiyatiTextField.getText())+
                        ")");

                statement.close();
                connection.close();
            }catch (Exception error){
                error.printStackTrace();
            }
            Stage closeStage = (Stage) ekleButton.getScene().getWindow();
            closeStage.close();
        }
        }
    }
