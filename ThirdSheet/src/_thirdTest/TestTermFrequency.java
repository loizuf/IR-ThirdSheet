package _thirdTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
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
public class TestTermFrequency {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";
	
	// Variable containing an instance of PositionalIndex
	private Index index;
		
	// parameterized variables
	private String inputTerm;
	private Document inputDoc;
	private int expectedResult;

	public TestTermFrequency(String inputTerm, int inputDocID, int expectedResult) throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
		
		this.inputTerm = inputTerm;
		this.inputDoc = index.getDocument(inputDocID);
		this.expectedResult = expectedResult;
	}

	@Test
	public void testPerformANDMerge() {
		assertEquals(expectedResult, index.getTF(inputTerm, inputDoc));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{3}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{"Baum", 1, 0, "term not present"},
					{"chief", 3, 1, "term at the start"},
					{"fingers", 3, 1, "term at the end"},
					{"logic", 1, 1, "term in multiple documents"},
					{"helmsman", 5, 2, "term multiple times in document"},
					{"enterprise", 5, 2, "term multiple times in multiple documents"}
				});
	}

}
