package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class AnagrammiController {

	private Model model;
	String parola = "";
	List<String> anagrammi;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField txtParola;

	@FXML
	private Button btnAnagramma;

	@FXML
	private TextFlow txtResult;

	@FXML
	private Button btnReset;

	public void setModel(Model model) {
		this.model = model;
	}

	@FXML
	void doAnagramma(ActionEvent event) {
		txtResult.getChildren().clear();
		parola = txtParola.getText().toLowerCase();
		if (parola == null)
			txtResult.getChildren().add(new Text("Inserire una parola da anagrammare!"));
		anagrammi = new LinkedList<String>();
		anagrammi = model.anagrammaParola(parola);
		for (String s : anagrammi) {
			Text text = new Text(s + "\n");
			if (!model.isContenutaInDizionario(s))
				text.setFill(Color.RED);
			txtResult.getChildren().add(text);
		}
	}

	@FXML
	void doReset(ActionEvent event) {
		txtParola.clear();
		txtResult.getChildren().clear();
	}

	@FXML
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnAnagramma != null : "fx:id=\"btnAnagramma\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Anagrammi.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

	}
}
