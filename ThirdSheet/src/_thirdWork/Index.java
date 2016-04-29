package _thirdWork;

import java.util.ArrayList;

import _thirdGiven.Document;

public class Index {
	
	ArrayList<Document> collection;

	// 1.a
	// Indexiert alle Terme damit wir sie benutzen k�nnen
	public Index(ArrayList<Document> collection) {
		this.collection = collection;
	}
	
	// 1.b
	// Gibt die Termfrequenz f�r dieses Wort in diesem Dokument zur�ck
	// Der return-Typ dieser Methode ist float (obwohl alle Ergebnisse ganzzahlig sind)
	// um unn�tiges casten zu vermeiden
	public float getTF(String term, Document doc) {
		return 0.0f;
		
	}

	// 1.c
	// Gibt die Dokumentenfrequenz dieses Terms zur�ck
	// Der return-Typ dieser Methode ist float (obwohl alle Ergebnisse ganzzahlig sind)
	// um unn�tiges casten zu vermeiden
	public float getDF(String term) {
		return 0.0f;
		
	}
	
	// 1.d
	// Berechnet den TF.IDF f�r diesen Term
	public float getTF_IDF_Score(String term, Document doc) {
		return 0.0f;
		
	}
	
	// 4
	// Normalisiert einen Vektor
	public float[] normalize(float[] vector) {
		return null;
		
	}
	
	// G der Top-k Ergebnisse zur�ck
	// Liste sollte nur Dokumente mit einem Score �ber 0 enthalten
	public ArrayList<Integer> vectorSearch(Document query, int k){
		return null;
		
	}

	// Method needed for Testing. DO NOT DELETE
	public Document getDocument(int documentID){
		return collection.get(documentID);
	}
}
