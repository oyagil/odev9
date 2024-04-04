package org.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LibraryTest {

    @Test
    public void testSearchBook() {
        try {
            String author = Library.searchBook("1984");
            assertEquals("George Orwell", author);
        } catch (BookNotFoundException | InvalidQueryException e) {
            fail("Hata: " + e.getMessage());
        }
    }

    @Test(expected = BookNotFoundException.class)
    public void testSearchBook_BookNotFound() throws BookNotFoundException, InvalidQueryException {
        Library.searchBook("Harry Potter");
    }

    @Test(expected = InvalidQueryException.class)
    public void testSearchBook_InvalidQuery() throws BookNotFoundException, InvalidQueryException {
        Library.searchBook("");
    }
}
