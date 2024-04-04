package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private static Map<String, String> books = new HashMap<>();

    static {
        // Kütüphaneye kitapları ekleyelim
        books.put("1984", "George Orwell");
        books.put("To Kill a Mockingbird", "Harper Lee");
        books.put("The Great Gatsby", "F. Scott Fitzgerald");
    }

    public static String searchBook(String title) throws BookNotFoundException, InvalidQueryException {
        if (title == null || title.isEmpty()) {
            throw new InvalidQueryException("Geçersiz kitap adı");
        }

        String author = books.get(title);
        if (author == null) {
            throw new BookNotFoundException("Kitap bulunamadı: " + title);
        }

        return author;
    }

    public static void main(String[] args) {
        try {
            String author = searchBook("1984");
            System.out.println("Kitabın yazarı: " + author);
        } catch (BookNotFoundException e) {
            System.err.println("Hata: " + e.getMessage());
        } catch (InvalidQueryException e) {
            System.err.println("Hata: " + e.getMessage());
        }
    }
}
