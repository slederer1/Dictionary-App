package test;

import org.junit.jupiter.api.Test;
import lederer.Dictionary;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class TestDictionary {
	private Dictionary dictionary;

	@BeforeEach
	public void setUp() {
		dictionary = new Dictionary();
		// You can initialize your dictionary with some sample data here.
		// For example:
		dictionary.insertWordNode("apple");
		dictionary.insertWordNode("banana");
		dictionary.insertWordNode("cherry");
	}

	@Test
	public void testInsertWordNode() {
		dictionary.insertWordNode("grape");
		dictionary.insertWordNode("fig");

		// Add assertions here to check that the insertions were successful.
		Assertions.assertTrue(dictionary.spellCheck("grape"));
		Assertions.assertTrue(dictionary.spellCheck("fig"));

		// Print the result
		System.out.println("InsertWordNode test: successful");
	}

	@Test
	public void testCheckWord() {
		dictionary.checkWord("banana");

		// Add assertions here to check that the word was removed.
		Assertions.assertFalse(dictionary.spellCheck("banana"));

		// Print the result
		System.out.println("CheckWord test: successful");
	}

	@Test
	public void testSpellCheck() {
		// Add assertions here to check that known words are recognized.
		Assertions.assertTrue(dictionary.spellCheck("apple"));
		Assertions.assertTrue(dictionary.spellCheck("cherry"));

		// Add assertions here to check that unknown words are not recognized.
		Assertions.assertFalse(dictionary.spellCheck("grape"));
		Assertions.assertFalse(dictionary.spellCheck("kiwi"));

		// Print the result
		System.out.println("SpellCheck test: successful");
	}
}
