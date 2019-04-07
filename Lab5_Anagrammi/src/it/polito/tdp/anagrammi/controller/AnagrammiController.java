package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnAnagrammi;

	@FXML
	private TextArea txtCorretti;

	@FXML
	private TextArea txtErrati;

	@FXML
	private Button btnReset;

	@FXML
	void doAnagrammi(ActionEvent event) {
		txtCorretti.clear();
		txtErrati.clear();
		String word = txtParola.getText().toLowerCase();
		word = word.trim();

		if(word.matches("[a-z]+")) {

			model.riempiListe(word);

			txtCorretti.setText(model.dammiCorrette());
			txtErrati.setText(model.dammiErrate()); 
		}
		else {
			txtCorretti.setText("Inserire solo caratteri alfabetici!");
		}

	}

	@FXML
	void doReset(ActionEvent event) {

		txtParola.clear();
		txtCorretti.clear();
		txtErrati.clear();

	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnAnagrammi != null : "fx:id=\"btnAnagrammi\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	}

	public void setModel(Model model) {
		this.model = model;
	}


}
