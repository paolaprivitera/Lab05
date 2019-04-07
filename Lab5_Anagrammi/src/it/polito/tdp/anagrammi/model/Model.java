package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model {

	List<String> corrette;
	List<String> errate;
	AnagrammaDAO dao = new AnagrammaDAO();
	Ricorsione r;

	public void riempiListe(String word) {
		r = new Ricorsione();
		corrette = new LinkedList<String>();
		errate = new LinkedList<String>();
		
		List<String> soluzioni = new LinkedList<String>(r.getAnagrams(word));

		for(String s : soluzioni) {
			if(dao.isCorrect(s)) {
				corrette.add(s);
			}
			else {
				errate.add(s);
			}
		}

	}

	public String dammiCorrette() {

		String risultatoC = "";

		for(String s : this.corrette) {

			risultatoC += s+"\n";

		}

		return risultatoC;
	}

	public String dammiErrate() {

		String risultatoE = "";

		for(String s : this.errate) {

			risultatoE += s+"\n";

		}

		return risultatoE;
	}

}
