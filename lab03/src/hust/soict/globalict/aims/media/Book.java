package media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
	private List <String> authors = new ArrayList <String>();
    private Book(){

    }
    public void addAuthor(String authorName){
        if (authors.contains(authorName)) System.out.println("Author exists");
		else {
			authors.add(authorName);
			System.out.println("Author added");
		}
    }
    public void removeAuthor(String authorName){
        if (!authors.contains(authorName)) System.out.println("Author does not exists");
		else {
			authors.remove(authorName);
			System.out.println("Author removed");
		}
    }
}
