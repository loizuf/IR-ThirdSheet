package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import _thirdGiven.FileReader;
import _thirdWork.Index;

// This tests the TF_IDF

public class Test_1d {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";
	
	// Variable containing an instance of PositionalIndex
	private static Index index;
	
	// calculation help variable
	float ERROR_MARGIN = 0.001f;
	
	@BeforeClass
	public static void setupBeforeClass() throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
	}

	// assertEquals has 3 arguments: value1, value2, delta. delta is used for a margin of error
	
	@Test
	public void TestTermInOneDocument() {
		assertEquals(0.845f, index.getTF_IDF_Score("iowa", index.getDocument(0)), ERROR_MARGIN);
	}

	@Test
	public void TestTermInMultipleDocuments() {
		assertEquals(0.367f, index.getTF_IDF_Score("logic", index.getDocument(1)), ERROR_MARGIN);
	}

	@Test
	public void TestTermMultipleTimesInOneDocument() {
		assertEquals(1.248f, index.getTF_IDF_Score("doctor", index.getDocument(2)), ERROR_MARGIN);
	}

	@Test
	public void TestTermMultipleTimesInMultipleDocuments1() {
		assertEquals(0.243f, index.getTF_IDF_Score("and", index.getDocument(0)), ERROR_MARGIN);
	}

	@Test
	public void TestTermMultipleTimesInMultipleDocuments2() {
		assertEquals(0.316f, index.getTF_IDF_Score("and", index.getDocument(1)), ERROR_MARGIN);
	}

	@Test
	public void TestTermInOtherDocuments() {
		assertEquals(0f, index.getTF_IDF_Score("and", index.getDocument(3)), ERROR_MARGIN);
	}

	@Test
	public void TestAbsentTerm() {
		assertEquals(0, index.getTF_IDF_Score("BAUM", index.getDocument(1)), ERROR_MARGIN);
	}

}
