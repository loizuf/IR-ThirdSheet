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

import _thirdGiven.FileReader;
import _thirdWork.Index;

@RunWith(Parameterized.class)
public class TestSearch {

	// Location of test collection
	private static final String TEST_PATH_2 = "collections/testCollections/second";

	// Variable containing an instance of PositionalIndex
	private Index index;
	
	// parameterized variables
	private String[] inputString;
	private ArrayList<Integer> expectedResult;
	
	public TestSearch(String[] inputString, ArrayList<Integer> expectedResult, String message)
			throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_2));

		this.inputString = inputString;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testVectorSearch() {
		assertEquals(expectedResult, index.vectorSearch(inputString, 1));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{2}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{ new String[] {"purple"}, new ArrayList<Integer>(Arrays.asList(new Integer[] { 0 })), "Single Document" },
					{ new String[] {"soylent"}, new ArrayList<Integer>(Arrays.asList(new Integer[] { 2 })), "Term at the start of a Document" },
					{ new String[] {"cook"}, new ArrayList<Integer>(Arrays.asList(new Integer[] { })), "No Document" },
					{ new String[] {"is", "null"}, new ArrayList<Integer>(), "2. Term nicht vorhanden" },
					{ new String[] {"naught", "is"}, new ArrayList<Integer>(), "1. Term nicht vorhanden" },
					{ new String[] {"naught", "null"}, new ArrayList<Integer>(), "Beide Terme nicht vorhanden" },
					{ new String[] {"there", "is"}, new ArrayList<Integer>().add(0), "Match am Anfang" },
					{ new String[] {"the", "sea"}, new ArrayList<Integer>().add(4), "Match am Ende" },
					{ new String[] {"eating", "collars"}, new ArrayList<Integer>().add(5), "Match in der Mitte" },
					{ new String[] {"space", "station"}, new ArrayList<Integer>(Arrays.asList(new Integer[] { 2, 6, 7 })), "Mehrere Matches" },
					{ new String[] {"moon", "moon"}, new ArrayList<Integer>(), "Gleiches Wort" },
					{ new String[] {"there", "is", "no"}, new ArrayList<Integer>().add(0), "3 W�rter, Anfang" },
					{ new String[] {"is", "people", "eating"}, new ArrayList<Integer>().add(1), "3 W�rter, Mitte" },
					{ new String[] {"station", "of", "corn"}, new ArrayList<Integer>().add(2), "3 W�rter, Ende" },
					{ new String[] {"are", "eating", "tree"}, new ArrayList<Integer>(), "2 von 3" },
					{ new String[] {"is", "green", "no"}, new ArrayList<Integer>(), "falsche Reihenfolge" },
					{ new String[] {"are", "people", "collars"}, new ArrayList<Integer>(), "nicht nebeneinander" },
					{ new String[] {"is", "no", "green", "space"}, new ArrayList<Integer>().add(6), "4 W�rter" }
				});
	}

}
