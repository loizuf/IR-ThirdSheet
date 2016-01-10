package _thirdTest;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import _secondGiven.FileReader;
import _secondWork.Index;

@RunWith(Parameterized.class)
public class TestTF_IDF {

	// Location of test collection
	private static final String TEST_PATH_2 = "collections/testCollections/second";
	
	// Variable containing an instance of PositionalIndex
	private Index index;
		
	// parameterized variables
	private String inputTerm;
	private int inputDocID;
	private int expectedResult;
	
	public TestTF_IDF(String inputTerm, int inputDocID, int expectedResult) throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_2));
		
		this.inputTerm = inputTerm;
		this.inputDocID = inputDocID;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testPerformANDMerge() {
		assertEquals(expectedResult, index.getTF_IDF_Score(inputTerm, inputDocID));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{3}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{"TEST", 0, 0, "test message"}
				});
	}

}
