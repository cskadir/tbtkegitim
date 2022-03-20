package kadir.korkmaz.comp;

public class Book implements Comparable<Book> {

    private final String name;
    private final int pageNumber;

    public Book(String name, int pageNum ) {
        this.name = name;
        this.pageNumber = pageNum;

    }

    public String getName() {
        return name;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    @Override
    public int compareTo(Book b2) {
        return (this.getName()).compareTo(b2.getName());
    }


}