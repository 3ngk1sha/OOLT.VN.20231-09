package screen.controller;

import javafx.scene.Parent;
import javafx.scene.*;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.*;

import java.io.IOException;

import cell.Cell;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class CellTypeController {
	private Cell cell;
	private String menuChoice; 
	
    @FXML
    private Button btnEu;

    @FXML
    private Button btnPro;

    @FXML
    private Button btnBack;

    @FXML
    void btnEuPressed(ActionEvent event) {
    	if (menuChoice.equals("Division")) {
            try {
                final String DIVISION_TYPE_PATH = "/screen/view/DivisionTypeMenu.fxml";
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DIVISION_TYPE_PATH));
                fxmlLoader.setController(new DivisionTypeController(cell, "Eu"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Cell Division Explorer");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void btnProPressed(ActionEvent event) {
        if (menuChoice.equals("Division")) {
            try {
                final String DIVISION_TYPE_PATH = "/screen/view/DivisionTypeMenu.fxml";
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(DIVISION_TYPE_PATH));
                fxmlLoader.setController(new DivisionTypeController(cell, "Pro"));
                Parent root = fxmlLoader.load();
                Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.setTitle("Cell Division Explorer");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void btnBackPressed(ActionEvent event) {
    	try {
            final String MAIN_MENU_PATH = "/screen/view/MainMenu.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(MAIN_MENU_PATH));
            fxmlLoader.setController(new MainMenuController(cell));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cell Division Explorer");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public CellTypeController(Cell cell, String menuChoice) {
    	this.cell = cell;
		this.menuChoice = menuChoice;
	}

}
