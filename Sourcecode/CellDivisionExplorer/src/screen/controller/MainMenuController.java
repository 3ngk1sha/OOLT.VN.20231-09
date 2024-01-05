package screen.controller;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.application.Platform;

import cell.Cell;


public class MainMenuController {
	private Cell euCell;
	private Cell proCell;
	
	public MainMenuController(Cell euCell, Cell proCell) {
		this.euCell = euCell;
		this.proCell = proCell;
	}
	
    @FXML
    private Button btnComponent;

    @FXML
    private Button btnDivision;

    @FXML
    private Button btnHelp;

    @FXML
    private Button btnQuit;

    @FXML
    void btnComponentPressed(ActionEvent event) {
    	try {
            final String CELL_TYPE_PATH = "/screen/view/CellTypeMenu.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CELL_TYPE_PATH));
            fxmlLoader.setController(new CellTypeController(euCell, proCell, "Component"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cell Division Explorer");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnDivisionPressed(ActionEvent event) {
    	try {
            final String CELL_TYPE_PATH = "/screen/view/CellTypeMenu.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CELL_TYPE_PATH));
            fxmlLoader.setController(new CellTypeController(euCell, proCell, "Division"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cell Division Explorer");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnHelpPressed(ActionEvent event) {
        try {
            final String HELP_PATH = "/screen/view/HelpMenu.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(HELP_PATH));
            fxmlLoader.setController(new HelpController(euCell, proCell));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cell Division Explorer");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnQuitPressed(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to quit?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){
            Platform.exit();
        }
    }
    
    @FXML
    public void initialize() {
    	final String MAIN_FXML_PATH  = "/screen/view/MainMenu.fxml";
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader();
    		fxmlLoader.setLocation(getClass().getResource(MAIN_FXML_PATH ));
    	} catch (Exception e) {
            e.printStackTrace();
        }
    }

}
