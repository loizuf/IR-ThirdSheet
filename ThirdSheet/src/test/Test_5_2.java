package test;

import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import _thirdGiven.Document;
import _thirdGiven.FileReader;
import _thirdWork.Index;

// This tests if the result of the search (all results) are correct AND in the correct order

public class Test_5_2 {

	// Location of test collection
	private static final String TEST_PATH_3 = "collections/testCollections/third";

	// Variable containing an instance of PositionalIndex
	private static Index index;
	
	@BeforeClass
	public static void setupBeforeClass() throws FileNotFoundException {
		index = new Index(FileReader.readCollection(TEST_PATH_3));
	}

	@Test
	public void TestOneTermInMultipleDocuments() {
		Document doc = new Document("enterprise", "Query6");
		ArrayList<Integer> arrayList = index.vectorSearch(doc, 7);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 5, 6, 0, 2 }, array);
	}

	@Test
	public void TestTwoTermInMultipleDocuments() {
		Document doc = new Document("half logic", "Query7");
		ArrayList<Integer> arrayList = index.vectorSearch(doc, 7);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 1, 3, 2 }, array);
	}

	@Test
	public void TestLongQuery() {
		Document doc = new Document("first officer sulu starship reliant", "Query8");
		ArrayList<Integer> arrayList = index.vectorSearch(doc, 7);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 6, 5, 1, 4, 0, 2 }, array);
	}

	@Test
	public void TestOneTermAbsent() {
		Document doc = new Document("doctor marcus engineer", "Query9");
		ArrayList<Integer> arrayList = index.vectorSearch(doc, 7);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 2, 3 }, array);
	}

	@Test
	public void TestDoubleTerm() {
		Document doc = new Document("chief engineer first engineer", "Query10");
		ArrayList<Integer> arrayList = index.vectorSearch(doc, 7);
		Integer[] array = arrayList.toArray(new Integer[arrayList.size()]);
		assertArrayEquals(new Integer[] { 3, 2, 6, 1, 4 }, array);
	}
}
