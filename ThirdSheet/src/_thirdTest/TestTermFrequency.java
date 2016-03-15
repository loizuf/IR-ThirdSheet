package _thirdTest;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.BeforeClass;
import org.junit.Test;

import _thirdGiven.FileReader;
import _thirdWork.Index;

public class TestTermFrequency {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";
	
	// Variable containing an instance of PositionalIndex
	private Index index;

	@BeforeClass
	public void setupBeforeClass() throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
	}

	@Test
	public void TestAbsentTerm() {
		assertEquals(0, index.getTF("Baum", index.getDocument(1)));
	}

	@Test
	public void TestFirstTerm() {
		assertEquals(1, index.getTF("chief", index.getDocument(3)));
	}

	@Test
	public void TestLastTerm() {
		assertEquals(1, index.getTF("fingers", index.getDocument(3)));
	}

	@Test
	public void TestTermInMultipleDocuments() {
		assertEquals(1, index.getTF("logic", index.getDocument(1)));
	}

	@Test
	public void TestTermMultipleTimesInDocument() {
		assertEquals(2, index.getTF("helmsman", index.getDocument(5)));
	}

	@Test
	public void TestTermMultipleTimesInMultipleDocuments() {
		assertEquals(2, index.getTF("enterprise", index.getDocument(5)));
	}
}
