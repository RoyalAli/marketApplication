package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TableView<urunler> tableView;
    @FXML
    private TableColumn<urunler, String> urunIDColumn;
    @FXML
    private TableColumn<urunler, String> urunAdiColumn;
    @FXML
    private TableColumn<urunler, String> urunTuruColumn;
    @FXML
    private TableColumn<urunler, String> alimFiyatiColumn;
    @FXML
    private TableColumn<urunler, String> satisFiyatiColumn;


    @FXML
    private Button yenileButton;
    @FXML
    private Button urunEkleButton;
    @FXML
    private Button barkodOkuyucuButton;
    @FXML
    private Button kapatButton;

    public void setButtons(ActionEvent actionEvent){
        if(actionEvent.getSource()==yenileButton){
            try{
                Stage closeStage = (Stage) yenileButton.getScene().getWindow();
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                stage.setScene(new Scene(root, 1280, 800));
                stage.setResizable(false);
                stage.show();
                closeStage.close();
            }catch (Exception error){
                error.printStackTrace();}
        }else if(actionEvent.getSource()==urunEkleButton){
            try{
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("urunEkle.fxml"));
                stage.setScene(new Scene(root, 500, 380));
                stage.setResizable(false);
                stage.show();
            }catch (Exception error){
                error.printStackTrace();}
        }else if(actionEvent.getSource()==barkodOkuyucuButton){

        }else if(actionEvent.getSource()==kapatButton){
            System.exit(1);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {
        urunIDColumn.setCellValueFactory(new PropertyValueFactory<>("urunID"));
        urunAdiColumn.setCellValueFactory(new PropertyValueFactory<>("urunAdi"));
        urunTuruColumn.setCellValueFactory(new PropertyValueFactory<>("urunTuru"));
        alimFiyatiColumn.setCellValueFactory(new PropertyValueFactory<>("alimFiyati"));
        satisFiyatiColumn.setCellValueFactory(new PropertyValueFactory<>("satisFiyati"));
        tableView.setItems(getUrunler());
    }

    public ObservableList<urunler> getUrunler() {
        ObservableList<urunler> idarecilerinHepsi = FXCollections.observableArrayList();
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:/Users/royalali/Desktop/marketApplication/src/sample/urunler.db");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.execute("select * from urunler");

            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                idarecilerinHepsi.add(new urunler(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getDouble(4), resultSet.getDouble(5)));
            }

            resultSet.close();
            statement.close();
            connection.close();
        }catch (Exception error){
            error.printStackTrace();
        }
        return idarecilerinHepsi;
    }
}