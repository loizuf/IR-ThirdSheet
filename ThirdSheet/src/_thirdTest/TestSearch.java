package _thirdTest;

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
public class TestSearch {

	// Location of test collection
	private static final String TEST_PATH_2 = "collections/testCollections/second";

	// Variable containing an instance of PositionalIndex
	private Index index;
	
	public TestSearch() throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_2));
	}

	@Test
	public void testPerformANDMerge() {
		
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{2}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					
				});
	}

}
