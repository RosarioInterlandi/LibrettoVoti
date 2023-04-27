package it.polito.tdp.libretto.model;

import java.time.LocalDate;

import javafx.util.converter.LocalDateStringConverter;

public class TestLibretto {

	public static void main(String[] args) {
		Libretto lib = new Libretto();
		
		lib.add(new Voto ("Analisi1", 20,  LocalDate.of(2023, 2, 20)));
		lib.add(new Voto ("Analisi2", 21,  LocalDate.of(2023, 2, 21)));
		lib.add(new Voto ("Fisica1", 22,  LocalDate.of(2023, 2, 22)));
		lib.add(new Voto ("Fisica2", 23,  LocalDate.of(2023, 2, 23)));
		lib.add(new Voto ("Tecniche di programmazione", 24,  LocalDate.of(2023, 2, 25)));
		lib.add(new Voto ("Basi Di Dati", 25,  LocalDate.of(2023, 2, 26)));
		lib.add(new Voto ("Chimica", 26,  LocalDate.of(2023, 2, 27)));
		lib.add(new Voto ("Algebra lineare", 27,  LocalDate.of(2023, 2, 28)));
		lib.add(new Voto ("Sistemi elettrici industriali", 28,  LocalDate.of(2023, 3, 29)));
		lib.add(new Voto ("Statistica", 29,  LocalDate.of(2023, 3, 30)));

		lib.stampaVotiUguali(25);
		
		Voto v1=lib.ricercaVotoPerCorso(new Voto("Analisi2", 22,LocalDate.of(2023, 2, 21) ));
		System.out.println(v1);
		
		System.out.println("\nTest duplicato per corso e voto");
		Boolean duplicato1 = lib.esisteDuplicato(new Voto ("Statistica",29, LocalDate.of(2023, 3, 30)));
		System.out.println(duplicato1);
		Boolean duplicato2 = lib.esisteDuplicato(new Voto ("Statistica",30, LocalDate.of(2023, 3, 30)));
		System.out.println(duplicato2);
		
		System.out.println("\nTest conflitto corso-voto");
		Boolean v12 = lib.esisteConflitto(new Voto ("Statistica",29, LocalDate.of(2023, 3, 30)));
		System.out.println(v12);
		Boolean v13 = lib.esisteConflitto(new Voto ("Statistica",30, LocalDate.of(2023, 3, 30)));
		System.out.println(v13);
		
		System.out.println("Test requisito 7:");
		
		System.out.println(lib);
		Libretto migliore = lib.librettoMigliorato();
		System.out.println(migliore);
		
		lib.eliminaVotoMinore(25);
		System.out.println(lib);
	}

}
