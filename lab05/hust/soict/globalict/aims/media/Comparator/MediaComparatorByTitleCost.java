package hust.soict.globalict.aims.media.Comparator;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator <Media>{
	public int compare(Media m1, Media m2) {
		Double cost1 = (double) m1.getCost();
		Double cost2 = (double) m2.getCost();
		String t1 = m1.getTitle();
		String t2 = m2.getTitle();
		int titleDiff = t1.compareTo(t2);
		
		return titleDiff == 0 ? cost1.compareTo(cost2) : titleDiff;  
	}
}

