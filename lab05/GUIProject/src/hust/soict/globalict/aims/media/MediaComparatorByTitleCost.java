package hust.soict.globalict.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media>{
    public int compare(Media a, Media b) {
        if (a.getTitle().compareTo(b.getTitle()) == 0) {
            return (int)(a.getCost() - b.getCost());
        }
        return a.getTitle().compareTo(b.getTitle());
    }
}
