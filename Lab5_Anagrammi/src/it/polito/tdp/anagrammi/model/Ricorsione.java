package it.polito.tdp.anagrammi.model;

import java.util.LinkedList;
import java.util.List;

public class Ricorsione {
	private List<String> result;

	public List<String> getAnagrams(String word) {
		result = new LinkedList<String>();

		List<String> letters = new LinkedList<String>();

		for(int i=0; i<word.length(); i++) {
			letters.add(word.substring(i,i+1));

		}

		this.recurse("", letters);

		return result;

		/*String risultato = "";

		for(String s : result) {
			risultato += s+"\n";
		}


		return risultato; // CORREGGERE LA STAMPA (ultimo carattere)*/
	}

	/** 
	 * Funzione ricorsiva per il calcolo degli anagrammi. Riceve la parte
	 * iniziale dell'anagramma che e' gia' stato definito nei livelli
	 * riscorsivi superiori (word), e la lista delle lettere che sono
	 * ancora da anagrammare (letters).
	 * Prende una per una tali lettere, le aggiunge alla parola e lancia
	 * la ricorsione. 
	 * Quando non ci sono piu' lettere da inserire, l'anagramma e' completo.
	 * 
	 * @param word
	 * 			prefisso di parola gia' definito
	 * @param letters
	 * 			lettere ancora da inserire
	 */

	private void recurse(String word, List<String> letters) {

		if(letters.size()==0) {
			// caso terminale: anagramma completo
			if(!result.contains(word))
				result.add(word);
		}
		else {
			// caso normale: do recursion
			for(String letter : letters) {

				List<String> subset = new LinkedList<String>(letters);
				subset.remove(letter); // Rimuovo la lettera corrente
				// per chiamare la ricorsione
				// su quelle che ancora mancano

				recurse(word+letter, subset);
			}
		}

	}
}
