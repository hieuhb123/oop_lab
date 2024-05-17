package hust.soict.globalict.aims.screen.manager;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class mainStore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
        
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "The lion King", "Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		store.addMedia(dvd3);
		
		List <String> author1 = new ArrayList<String>();
		author1.add("Munwind");
		author1.add("Lehau");
		
		List <String> author2 = new ArrayList<String>();
		author2.add("Minh");
		author2.add("Kien");
		
		Book book1 = new Book(3, "LeHau finds his first love", "No hope", 99.99f, author1);
		store.addMedia(book1);
		Book book2 = new Book(4, "We are ones", "The Hunt", 1.1f, author2);
		store.addMedia(book2);
        
		CompactDisc CD1 = new CompactDisc(1, "No hope", "Romantic", 82, "Munwind");
		store.addMedia(CD1);
		
		CompactDisc CD2 = new CompactDisc(1, "No hope 2", "Romantic", 65, "Munwind");
		store.addMedia(CD2);
		
		CompactDisc CD3 = new CompactDisc(1, "No hope 3", "Romantic", 15, "Munwind");
		store.addMedia(CD3);
		
		CompactDisc CD4 = new CompactDisc(1, "No hope 4", "Romantic", 100, "Munwind");
		store.addMedia(CD4);
		
		new StoreManagerScreen(store);
	}

}
