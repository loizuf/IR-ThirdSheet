package _thirdTest;

import static org.junit.Assert.*;

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
public class TestTF_IDF {

	// Location of test collection
	private static final String TEST_PATH_2 = "collections/testCollections/second";
	
	// Variable containing an instance of PositionalIndex
	private Index index;
		
	// parameterized variables
	private String inputTerm;
	private Document inputDoc;
	private int expectedResult;
	
	// calculation help variable
	float precision = 0.0005f;
	
	public TestTF_IDF(String inputTerm, int inputDocID, int expectedResult) throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_2));
		
		this.inputTerm = inputTerm;
		this.inputDoc = index.getDocument(inputDocID);
		this.expectedResult = expectedResult;
	}

	@Test
	public void testPerformANDMerge() {
		assertTrue(checkRange(index.getTF_IDF_Score(inputTerm, inputDoc), expectedResult));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{3}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{"was", 0, 0.845f, "Term in one document"},
					{"logic", 1, 0.367f, "Term in multiple documents"},
					{"doctor", 2, 1.248f, "Term multiple times in one document"},
					{"and", 0, 0.243f, "Term multiple times in multiple documents"},
					{"and", 1, 0.316f, "Term multiple times in multiple documents"},
					{"and", 3, 0, "Term in other documents"},
					{"TEST", 0, 0, "Term not in collection"}
				});
	}

	// We cant know how the students calculate the probability but we can check
	// if they are in a certain range (and we can do that as precise as we want)
	private boolean checkRange(float value, float bound) {
		
		if(value>=bound-precision && value<=bound + precision){
			return true;
		}
		return false;
	}

}
