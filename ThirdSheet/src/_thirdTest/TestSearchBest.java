package _thirdTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;

import _thirdGiven.Document;
import _thirdGiven.FileReader;
import _thirdWork.Index;

public class TestSearchBest {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";

	// Variable containing an instance of PositionalIndex
	private Index index;
	
	// parameterized variables
	private Document inputDocument;
	private ArrayList<Integer> expectedResult;
	
	public TestSearchBest(String inputString, ArrayList<Integer> expectedResult, String message)
			throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));

		this.inputDocument = new Document(inputString, "Query");
		this.expectedResult = expectedResult;
	}

	@Test
	public void testVectorSearch() {
		assertEquals(expectedResult, index.vectorSearch(inputDocument, 7));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{2}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{ "enterprise", new ArrayList<Integer>(Arrays.asList(new Integer[] { 5, 6, 0, 2 })), "Term in multiple documents" },
					{ "half logic", new ArrayList<Integer>(Arrays.asList(new Integer[] { 1, 3, 2 })), "Terms in multiple documents" },
					{ "first officer sulu starship reliant", new ArrayList<Integer>(Arrays.asList(new Integer[] { 6, 5, 1, 4, 0, 2 })), "Long query" },
					{ "doctor marcus engineer", new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 3 })), "One term not in collection" },
					{ "chief engineer first engineer", new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 2, 6, 1, 4 })), "double terms in Query" }
				});
	}
}
