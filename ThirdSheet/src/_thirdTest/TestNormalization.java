package _thirdTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import _secondGiven.FileReader;
import _secondWork.Index;

@RunWith(Parameterized.class)
public class TestNormalization {

	// Location of test collection
	private static final String TEST_PATH_2 = "collections/testCollections/second";
	private static final double ERROR_MARGIN = 0.001f;

	// Variable containing an instance of PositionalIndex
	private Index index;
		
	// parameterized variables
	private ArrayList<Integer> vector;
	private ArrayList<Float> expectedResult;

	public TestNormalization(ArrayList<Integer> vector, ArrayList<Float> expectedResult) throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_2));
		
		this.vector = vector;
		this.expectedResult = expectedResult;
	}

	@Test
	public void testNormalize() {
		//assertArrayEquals(expectedResult, round(index.normalize(vector)));
	}
	
	// This method sets up the data for the tests
	// the third variable is used to display a description to the students
	@Parameters (name = "{2}")
	public static List<Object[]> data() {
		return Arrays
				.asList(new Object[][] { 
					{new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 4 })), new ArrayList<Float>(Arrays.asList(new Float[] { 0.6f, 0.8f })), "Two normal Parameters"},
					{new ArrayList<Integer>(Arrays.asList(new Integer[] { 3, 4 })), new ArrayList<Float>(Arrays.asList(new Float[] { 0.6f, 0.8f })), ""},
				});
	}
	
    public static float[] round(float[] d, int decimalPlace) {
    	float[] result = new float[d.length];
    	for (int i = 0; i < d.length; i++) {
            BigDecimal bd = new BigDecimal(Float.toString(d[i]));
            bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
            result[i] = bd.floatValue();
		}
    	return result;

    }

}
