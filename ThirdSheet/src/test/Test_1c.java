package test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import _thirdGiven.FileReader;
import _thirdWork.Index;

// This tests the document-frequency (NOT IDF, just DF)

public class Test_1c {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";
	
	// Variable containing an instance of PositionalIndex
	private static Index index;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
	}

	@Test
	public void TestAbsentTerm() {
		assertEquals(0, index.getDF("marcus"), 0);
	}

	@Test
	public void TestFirstTerm() {
		assertEquals(1, index.getDF("chief"), 0);
	}

	@Test
	public void TestLastTerm() {
		assertEquals(1, index.getDF("human"), 0);
	}

	@Test
	public void TestFirstDocument() {
		assertEquals(1, index.getDF("kirk"), 0);
	}

	@Test
	public void TestLastDocument() {
		assertEquals(1, index.getDF("sulu"), 0);
	}

	@Test
	public void TestMultipleDocuments() {
		assertEquals(3, index.getDF("logic"), 0);
	}

	@Test
	public void TestMultipleTerm() {
		assertEquals(1, index.getDF("helmsman"), 0);
	}

	@Test
	public void TestMultipleDocumentTerm() {
		assertEquals(4, index.getDF("enterprise"), 0);
	}
}
