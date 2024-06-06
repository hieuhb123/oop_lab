package hust.soict.globalict.aims.media;

import java.util.Comparator;


public class MediaComparatorByCostTitle implements Comparator<Media>{
    public int compare(Media a, Media b) {
        if (a.getCost() == b.getCost()) {
            return a.getTitle().compareTo(b.getTitle());
        }
        return (int)(a.getCost() - b.getCost());
    }
}
