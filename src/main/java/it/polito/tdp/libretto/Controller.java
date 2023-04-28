package it.polito.tdp.libretto;

import it.polito.tdp.libretto.model.Libretto;
import it.polito.tdp.libretto.model.Voto;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	private Libretto model;
    
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Integer> cmbVoto;

    @FXML
    private DatePicker selData;

    @FXML
    private TextField txtCorso;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	String corso = txtCorso.getText();
    	Integer voto = cmbVoto.getValue();
    	LocalDate data = selData.getValue();
    	
    	Voto vote = new Voto(corso, voto, data);
    	this.model.add(vote);
    	
    	txtResult.setText(this.model.toString());
    }

    @FXML
    void initialize() {
        assert cmbVoto != null : "fx:id=\"cmbVoto\" was not injected: check your FXML file 'main.fxml'.";
        assert selData != null : "fx:id=\"selData\" was not injected: check your FXML file 'main.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'main.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'main.fxml'.";
        
        for(int i= 18; i<=30; i++) {
        	cmbVoto.getItems().add(i);
        }
    }

	public void setModel(Libretto model) {
		this.model = model;
	}
	
}
