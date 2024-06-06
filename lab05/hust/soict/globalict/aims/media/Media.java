package hust.soict.globalict.aims.media;

import java.util.Comparator;

import hust.soict.globalict.aims.media.Comparator.MediaComparatorByCostTitle;
import hust.soict.globalict.aims.media.Comparator.MediaComparatorByTitleCost;

public abstract class Media {
	
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	public static final Comparator <Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator <Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public Media(String title) {
		super();
		this.title = title;
	}
	
	
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + "]";
	}
	
	public abstract boolean isMatch(String title);
	
	public boolean equals(Object obj) {
		
		if (obj == this) return true;
		
		Media new_m = (Media) obj;
		
		return title.equals(new_m.getTitle());
	}
}

