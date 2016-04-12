package _thirdWork;

import java.util.ArrayList;

import _thirdGiven.Document;

public class Index {
	
	ArrayList<Document> collection;

	// 1.a
	// Indexiert alle Terme damit wir sie benutzen können
	public Index(ArrayList<Document> collection) {
		this.collection = collection;
	}
	
	// 1.b
	// Gibt die Termfrequenz für dieses Wort in diesem Dokument zurück
	public int getTF(String term, Document doc) {
		return 0;
		
	}

	// 1.c
	// Gibt die Dokumentenfrequenz dieses Terms zurück
	public int getDF(String term) {
		return 0;
		
	}
	
	// 1.d
	// Berechnet den TF.IDF für diesen Term
	public float getTF_IDF_Score(String term, Document doc) {
		return 0;
		
	}
	
	// 4
	// Normalisiert einen Vektor
	public float[] normalize(int[] vector) {
		return null;
		
	}
	
	// G der Top-k Ergebnisse zurück
	// Liste sollte nur Dokumente mit einem Score über 0 enthalten
	public ArrayList<Integer> vectorSearch(Document query, int k){
		return null;
		
	}

	// Method needed for Testing. DO NOT DELETE
	public Document getDocument(int documentID){
		return collection.get(documentID);
	}
}
