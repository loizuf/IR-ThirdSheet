package _secondWork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import _secondGiven.Document;
import _secondGiven.FileReader;

public class MainController {

	/*
	 * LoremIpsumCollectionDirectoryPath - Name des Verzeichnisses das die
	 * Dokumente enthaelt
	 */
	private static final String LOREM_IPSUM_COLLECTION_DIRECTORY_PATH = "collections/lorem";

	public static void main(String[] args) throws IOException {

		// collection - Liste aller Document-Objekte
		ArrayList<Document> collection = FileReader.readCollection(LOREM_IPSUM_COLLECTION_DIRECTORY_PATH);

		// index - Repraesentation des index
		Index index = new Index(collection);

		// breakdown the query into two terms
		String[] query = getQueryTerms();
		
		// search for best results
		ArrayList<Integer> result = index.vectorSearch(query, 10);
		
		postResults(result);
	}

	// Bearbeiten sie Aufgabe 3 hier.
	public static String[] getQueryTerms() {
		// let's get a query from the user via the command line
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a query:");
		String query = scanner.nextLine();
		scanner.close();
		
		// Lets clean up those queryterms
		String[] result = query.split("\\s+");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
			result[i] = result[i].trim().toLowerCase();
		}
		
		return result;
	}

	/*
	 * Diese Methode gibt ausschlieslich die Ergebnisse an den User aus
	 */
	private static void postResults(ArrayList<Integer> result) {
		System.out.println("\n+++++++\n");
		System.out.println("The results are:");
		for (int currentResult : result) {
			System.out.println(currentResult);
		}
	}
}
