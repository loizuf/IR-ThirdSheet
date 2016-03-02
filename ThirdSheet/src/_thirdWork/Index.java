package _thirdWork;

import java.util.ArrayList;

import _thirdGiven.Document;

public class Index {
	
	ArrayList<Document> collection;

	// TASK 1 start
	// indexes all the terms so we can use them
	public Index(ArrayList<Document> collection) {
		this.collection = collection;
	}
	
	// returns the tf for this term in this document
	public int getTF(String term, Document doc) {
		return 0;
	}

	// returns the idf for this term in the collection
	public float getIDF(String term) {
		return 0;
	}
	
	// returns the tf.idf score for this term and document
	public float getTF_IDF_Score(String term, Document doc) {
		return 0;
	}
	// TASK 1 end
	
	// TASK 3 start
	// normalizes a vector
	public float[] normalize(int[] vector) {
		return null;
	}
	
	// returns ArrayList of DocId's of the top-k Documents for this Query
	// result should only contain documents with a non-zero score
	public ArrayList<Integer> vectorSearch(Document query, int k){
		return null;
	}
	// TASK 3 end
	
	// Method needed for Testing. DO NOT DELETE
	public Document getDocument(int documentID){
		return collection.get(documentID);
	}
}
