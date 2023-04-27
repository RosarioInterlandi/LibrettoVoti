package it.polito.tdp.libretto.model;
import java.util.*;

public class LibrettoMigliorato extends Libretto {
	boolean flaggiamigliorato;
	LinkedList<Voto> listaVotiMigliorati;

	public LibrettoMigliorato(LinkedList<Voto> listaVoti) {
		super();
		listaVotiMigliorati = new LinkedList<Voto>();
		flaggiamigliorato = false;
	}
	
	public void incrementaVoti() {
		if (flaggiamigliorato)
			return;
		for (Voto v: listaVotiMigliorati) {
			if (18<=v.getVoto()&& v.getVoto()<24) {
				v.setVoto(v.getVoto()+1);
			}
			else if (28>v.getVoto()&& v.getVoto()>=24) {
				v.setVoto(v.getVoto()+2);
			}
			else if (v.getVoto()>28) {
				v.setVoto(30);
			}
		}
		flaggiamigliorato = true;
	}
	@Override
	public String toString() {
		String ritorno = "Libretto Migliorato:\n";
		for (Voto v: listaVotiMigliorati)
			ritorno += v+"\n";
		return ritorno;
	}
	
}
