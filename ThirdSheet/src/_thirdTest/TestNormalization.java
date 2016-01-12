package _thirdTest;

import java.io.FileNotFoundException;
import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

import _thirdGiven.FileReader;
import _thirdWork.Index;

@RunWith(Parameterized.class)
public class TestNormalization {

	// Location of test collection
	private static final String TEST_PATH_2 = "collections/testCollections/second";
	private static final float ERROR_MARGIN = 0.000001f;

	// Variable containing an instance of PositionalIndex
	private Index index;
		
	// parameterized variables
	private int[][] vectorInputs;
	private float[][] expectedResults;

	public TestNormalization() throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_2));
		
		fillVariables();
		testNormalize();
	}

	@Test
	private void testNormalize() {
		assertArrayEquals("No Input", expectedResults[0], index.normalize(vectorInputs[0]), ERROR_MARGIN);
		assertArrayEquals("Input is '0'", expectedResults[1], index.normalize(vectorInputs[1]), ERROR_MARGIN);
		assertArrayEquals("Input is '1'", expectedResults[2], index.normalize(vectorInputs[2]), ERROR_MARGIN);
		assertArrayEquals("Single number, not '1'", expectedResults[3], index.normalize(vectorInputs[3]), ERROR_MARGIN);
		assertArrayEquals("Two numbers", expectedResults[4], index.normalize(vectorInputs[4]), ERROR_MARGIN);
		assertArrayEquals("Three numbers, two are equal", expectedResults[5], index.normalize(vectorInputs[5]), ERROR_MARGIN);
		assertArrayEquals("Three numbers, all are equal", expectedResults[6], index.normalize(vectorInputs[6]), ERROR_MARGIN);
		assertArrayEquals("Three numbers, none are equal", expectedResults[7], index.normalize(vectorInputs[7]), ERROR_MARGIN);
	}

	// This method sets up the data for the tests
	private void fillVariables() {

		vectorInputs = new int[][]{
			{},
			{0},
			{1},
			{9},
			{3, 4},
			{3, 5, 3},
			{25, 25, 25},
			{7, 3, 6}
		};
		expectedResults = new float[][]{
			{},
			{0},
			{1},
			{1},
			{0.6f, 0.8f},
			{0.457496f, 0.762493f, 0.457496f},
			{0.57735f, 0.57735f, 0.57735f},
			{0.721995f, 0.309426f, 0.618853f}
		};
	}
}
