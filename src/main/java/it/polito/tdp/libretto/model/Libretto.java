package it.polito.tdp.libretto.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.libretto.db.VotoDAO;



public class Libretto {
	List<Voto> listaVoti;

	public Libretto() {
		VotoDAO votoDao = new VotoDAO();
		listaVoti = votoDao.listaVoti();
	}

	public boolean add(Voto v) {
		if (esisteDuplicato(v)||esisteConflitto(v))
			throw new IllegalArgumentException("Voto errato" + v);
		VotoDAO votoDAO= new VotoDAO();
		votoDAO.creareVoto(v);
		return listaVoti.add(v);
		
	}

	public void stampaVotiUguali(int valore) {
		for (Voto v : listaVoti) {
			if (v.getVoto() == valore)
				System.out.println(v);
		}
	}

	public Voto ricercaVotoPerCorso(Voto v) {
		for (Voto u : listaVoti) {
			if (u.getCorso().equals(v.getCorso()))
				return u;
		}
		return null;
	}

	public boolean esisteDuplicato(Voto v) {
		for (Voto u : listaVoti) {
			if (u.isDuplicato(v))
				return true;
		}

		return false;
	}

	public boolean esisteConflitto(Voto v) {
		for (Voto u : listaVoti) {
			if (u.isConflitto(v))
				return true;
		}

		return false;
	}

	@Override
	public String toString() {
		String ritorno = "Libretto:\n";
		LinkedList<Voto> listaRitorno = new LinkedList<Voto>(listaVoti);
		Collections.sort(listaRitorno, new comparatorePerOrdineAlfabeticoEVotoDecrescente());
		for (Voto v : listaRitorno)
			ritorno += v + "\n";
		return ritorno;
	}
	
	/**
	 * Metodo "factory" per crear un nuovo libretto con i voti migliorati
	 * @return
	 */
	public Libretto librettoMigliorato() {
		Libretto migliore = new Libretto();
		migliore.listaVoti= new LinkedList<Voto>();
		for (Voto v: this.listaVoti) {
		//	migliore.listaVoti.add(v.clone());
			migliore.listaVoti.add(new Voto(v));
		}
		for (Voto v: migliore.listaVoti) {
			if (v.getVoto()<24&& v.getVoto()>=18) {
				v.setVoto(v.getVoto()+1);
				continue;
			}
			if (v.getVoto()>=24 && v.getVoto()<=28) {
				v.setVoto(v.getVoto()+2);
				continue;
			}
			if (v.getVoto()>28) {
				v.setVoto(30);
			}
		}
		return migliore;
	}
	public void eliminaVotoMinore(int valore) {
		LinkedList<Voto> listaDaEliminare = new LinkedList<Voto>();
		for (Voto v: this.listaVoti) {
			if (v.getVoto()< valore) {
				listaDaEliminare.add(v);
			}
		}
		listaVoti.removeAll(listaDaEliminare);
	}
	
}
