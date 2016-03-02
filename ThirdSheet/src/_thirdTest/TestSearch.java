package _thirdTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import _thirdGiven.Document;
import _thirdGiven.FileReader;
import _thirdWork.Index;

@RunWith(Parameterized.class)
public class TestSearch {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";

	// Variable containing an instance of PositionalIndex
	private Index index;
	
	// parameterized variables
	private Document inputDocument;
	private ArrayList<Integer> expectedResult;
	
	public TestSearch(String inputString, ArrayList<Integer> expectedResult, String message)
			throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));

		this.inputDocument = new Document(inputString, "Query");
		this.expectedResult = expectedResult;
	}

	@Test
	public void testVectorSearch() {
		assertEquals(expectedResult, index.vectorSearch(inputDocument, 1));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{2}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{ "andreievich", new ArrayList<Integer>().add(6), "Term in one document" },
					{ "enterprise", new ArrayList<Integer>().add(5), "Term in multiple documents" },
					{ "TEST", new ArrayList<Integer>(), "Term not in collection" },
					{ "doctor marcus", new ArrayList<Integer>().add(2), "One term not in collection" },
					{ "half logic", new ArrayList<Integer>().add(1), "Terms in multiple documents" },
					{ "first officer sulu", new ArrayList<Integer>().add(7), "Three terms, all in multiple documents" }
				});
	}

}
