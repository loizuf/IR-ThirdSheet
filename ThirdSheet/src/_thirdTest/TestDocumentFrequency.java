package _thirdTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import _thirdGiven.FileReader;
import _thirdWork.Index;

@RunWith(Parameterized.class)
public class TestDocumentFrequency {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";
	
	// Variable containing an instance of PositionalIndex
	private Index index;
		
	// parameterized variables
	private String inputTerm;
	private int expectedResult;

	public TestDocumentFrequency(String inputTerm, int expectedResult) throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
		
		this.inputTerm = inputTerm;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testPerformANDMerge() {
		assertEquals(expectedResult, index.getIDF(inputTerm));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{2}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{"Baum", 0, "term not present"},
					{"chief", 1, "term at the start of document"},
					{"human", 1, "term at the end of document"},
					{"kirk", 1, "term only in the first document"},
					{"sulu", 1, "term only in the last document"},
					{"logic", 3, "term in multiple documents"},
					{"helmsman", 1, "term multiple times in document"},
					{"enterprise", 4, "term multiple times in multiple documents"}
				});
	}
}
