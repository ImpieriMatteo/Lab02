package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola_e;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleClearText(ActionEvent event) {
    	this.txtResult.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	String text = this.txtParola_e.getText();
    	String[] arrayText = text.split(" ");
    	if(arrayText.length==2) {
    		if(arrayText[0].matches("[a-zA-Z]*") && arrayText[1].matches("[a-zA-Z]*")) {
    			this.model.addWord(arrayText[0].toLowerCase(), arrayText[1].toLowerCase());
    			this.txtResult.setText("New Word add to the Dictionary");
    		}
    		else 
    			this.txtResult.setText("Invalid text entered");
    	}
    	else if(arrayText.length>2)
    		this.txtResult.setText("Invalid text entered");
    	else {
    		if(text.matches("[a-zA-Z]*"))
    			if(model.searchWord(text)==null)
    				this.txtResult.setText("Word not in the Dictionary");
    			else
    				this.txtResult.setText(model.searchWord(text.toLowerCase()));
    		else
    			this.txtResult.setText("Invalid text entered");
    	}
    	this.txtParola_e.clear();
    }
    
	public void setModel(Model model) {
		this.model = model;
	}	
	
    @FXML
    void initialize() {
        assert txtParola_e != null : "fx:id=\"txtParola_e\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
