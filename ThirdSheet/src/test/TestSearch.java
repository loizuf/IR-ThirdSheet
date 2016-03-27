package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import _thirdGiven.Document;
import _thirdGiven.FileReader;
import _thirdWork.Index;

public class TestSearch {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";

	// Variable containing an instance of PositionalIndex
	private static Index index;
	
	@BeforeClass
	public static void setUpBeforeClass() throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
	}

	@Test
	public void TestAbsentTerm() {
		Document doc = new Document("BAUM", "Query0");
		assertEquals(new ArrayList<Integer>(), index.vectorSearch(doc, 1));
	}

	@Test
	public void TestTermInOneDocument() {
		Document doc = new Document("andreievich", "Query1");
		assertEquals(6, index.vectorSearch(doc, 1).get(0), 0);
	}

	@Test
	public void TestTermInMultipleDocuments() {
		Document doc = new Document("enterprise", "Query2");
		assertEquals(5, index.vectorSearch(doc, 1).get(0), 0);
	}

	@Test
	public void TestTwoTermsOneAbsent() {
		Document doc = new Document("doctor marcus", "Query3");
		assertEquals(2, index.vectorSearch(doc, 1).get(0), 0);
	}

	@Test
	public void TestTwoTermsInDifferentDocuments() {
		Document doc = new Document("half logic", "Query4");
		assertEquals(1, index.vectorSearch(doc, 1).get(0), 0);
	}

	@Test
	public void TestThreeTermsInDifferentDocuments() {
		Document doc = new Document("first officer sulu", "Query5");
		assertEquals(7, index.vectorSearch(doc, 1).get(0), 0);
	}

}
