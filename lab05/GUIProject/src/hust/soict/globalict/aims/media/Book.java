package hust.soict.globalict.aims.media;

import java.util.ArrayList;

public class Book extends Media{
    
    private ArrayList<String> authors = new ArrayList<String>();

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        for (int i = 0; i < authors.size(); i++) {
            if (this.authors.get(i).equals(authorName)) {
                System.out.println("The author exist!!!");
                return;
            }
        }
        this.authors.add(authorName);
        return;
    }

    public void removeAuthor(String authorName) {
        if (authors.isEmpty()) {
            System.out.println("There\'s none!!!");
            return;
        }
        if (authors.remove(authorName)) {
            System.out.println("The author have been removed!!!");
            return;
        }
        System.out.println("There is no such author!!!");
        return;
    }
}
