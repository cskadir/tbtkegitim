package kadir.korkmaz.comp;

import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Sadist", 123);
        Book book2 = new Book("Medyum", 98765);
        Book book3 = new Book("Cehennem", 9876);
        Book book4 = new Book("Martin Eden,", 454);
        Book book5 = new Book("Kadirin Çileleri", 123213);

        TreeSet<Book> set1 = new TreeSet<>();
        addBooks(book1, book2, book3, book4, book5, set1);
        TreeSet<Book> set2 = new TreeSet<>(new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getPageNumber() - b2.getPageNumber();
            }
        });
        addBooks(book1, book2, book3, book4, book5, set2);
    }



    private static void addBooks(Book book1, Book book2, Book book3, Book book4, Book book5, TreeSet<Book> set) {
        set.add(book1);
        set.add(book2);
        set.add(book3);
        set.add(book4);
        set.add(book5);

        for (Book book:set) {
            System.out.println("Book Name: "+  book.getName() +"Page: " + book.getPageNumber());
        }
    }
}
