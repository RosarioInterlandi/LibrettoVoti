package it.polito.tdp.libretto.model;

import java.time.LocalDate;

public class Voto {
	private String corso;
	private int  voto;
	private LocalDate dataEsame;
	
	public Voto(String corso, int voto, LocalDate dataEsame) {
		super();
		this.corso = corso;
		this.voto = voto;
		this.dataEsame = dataEsame;
	}
	// copy constructor di Voto
	public Voto(Voto v) {
		this.corso= v.corso;
		this.voto = v.voto;
		this.dataEsame = v.dataEsame;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	public LocalDate getDataEsame() {
		return dataEsame;
	}

	public void setDataEsame(LocalDate dataEsame) {
		this.dataEsame = dataEsame;
	}

	@Override
	public String toString() {
		return "Voto [corso=" + corso + ", voto=" + voto + ", dataEsame=" + dataEsame + "]";
	}
	public boolean isDuplicato(Voto altro) {
		return this.getCorso().equals(altro.getCorso())&&
				this.getVoto()==altro.getVoto();
	}
	public boolean isConflitto(Voto altro) {
		return this.getCorso().equals(altro.getCorso())&&
				this.getVoto()!=altro.getVoto();	
	}
	public Voto clone() {
		return new Voto(this.corso,this.voto,this.dataEsame);
	}
	
}
