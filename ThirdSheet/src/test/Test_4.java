package test;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import _thirdGiven.FileReader;
import _thirdWork.Index;

public class Test_4 {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";
	private static final float ERROR_MARGIN = 0.00001f;

	// Variable containing an instance of PositionalIndex
	private static Index index;
		
	// parameterized variables
	private static float[][] vectorInputs;
	private static float[][] expectedResults;

	@BeforeClass
	public static void setUpBeforeClass() throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
		
		fillVariables();
	}

	// assertEquals has 3 arguments: value1, value2, delta. delta is used for a margin of error
	
	@Test
	public void TestNoInput() {
		assertArrayEquals(expectedResults[0], index.normalize(vectorInputs[0]), ERROR_MARGIN);
	}

	@Test
	public void TestInputZero() {
		assertArrayEquals(expectedResults[1], index.normalize(vectorInputs[1]), ERROR_MARGIN);
	}

	@Test
	public void TestInputOne() {
		assertArrayEquals(expectedResults[2], index.normalize(vectorInputs[2]), ERROR_MARGIN);
	}

	@Test
	public void TestInputNotOne() {
		assertArrayEquals(expectedResults[3], index.normalize(vectorInputs[3]), ERROR_MARGIN);
	}

	@Test
	public void TestTwoNumbers() {
		assertArrayEquals(expectedResults[4], index.normalize(vectorInputs[4]), ERROR_MARGIN);
	}

	@Test
	public void TestThreeNumbersTwoEqual() {
		assertArrayEquals(expectedResults[5], index.normalize(vectorInputs[5]), ERROR_MARGIN);
	}

	@Test
	public void TestThreeNumbersAllEqual() {
		assertArrayEquals(expectedResults[6], index.normalize(vectorInputs[6]), ERROR_MARGIN);
	}

	@Test
	public void TestThreeNumbersNonEqual() {
		assertArrayEquals(expectedResults[7], index.normalize(vectorInputs[7]), ERROR_MARGIN);
	}

	// This method sets up the data for the tests
	private static void fillVariables() {

		vectorInputs = new float[][]{
			{},
			{0.0f},
			{1.0f},
			{9.0f},
			{3.0f, 4.0f},
			{3.0f, 5.0f, 3.0f},
			{25.0f, 25.0f, 25.0f},
			{7.0f, 3.0f, 6.0f}
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
