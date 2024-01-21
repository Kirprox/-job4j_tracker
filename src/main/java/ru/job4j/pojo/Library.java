package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 464);
        Book headFirst = new Book("Head First java", 720);
        Book theCompleteRef = new Book("Java. The Complete Reference", 1300);
        Book algorithm = new Book("Algorithms in Java", 520);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = headFirst;
        books[2] = theCompleteRef;
        books[3] = algorithm;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + ", " + book.getNumOfPages() + " pages");
        }
        System.out.println("Shown rearranging 0 and 3 index");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println(book.getName() + ", " + book.getNumOfPages() + " pages");
        }
        System.out.println("Shown only Clean code name books");
        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println(book.getName() + ", " + book.getNumOfPages() + " pages");
            }
        }
    }
}

