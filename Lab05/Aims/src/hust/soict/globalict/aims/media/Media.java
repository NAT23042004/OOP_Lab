package hust.soict.globalict.aims.media;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	
	private static int numofMedias = 0;

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
	public boolean equals(Object obj) {
		try {
	        if (!(obj instanceof Media)) {
	        	   return false;
	        }
			else {
				Media media = (Media) obj;
				return title.equals(media.title) && cost == media.cost;
			}
	    } catch (NullPointerException e) {
	        return false;
	    } catch (ClassCastException e) {
	        return false;
	    }
	}
	
	@Override
	public String toString() {
		return id + " " + title + " - " + category + " : " + "$" + cost;
	}
	
	@Override
	public int compareTo(Media media) {
	    int titleComparison = this.title.compareTo(media.title);
	    if (titleComparison != 0) {
	        return titleComparison;
	    } else {
	        return Float.compare(this.cost, media.cost);
	    }
	}
	public Media() {
		super();
		this.id = numofMedias++;
	} 
	public Media(String title) {
        this.title = title;
		this.id = numofMedias++;
    }
    public Media(String title, String category) {
        this.title = title;
        this.category = category;
        numofMedias++;
		this.id = numofMedias;
    }
    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        numofMedias++;
		this.id = numofMedias;
    }

	public Media(String title, String category, float cost, int id) {
		this.title = title;
		this.category = category;
		this.cost = cost;
        numofMedias++;
		this.id = numofMedias;	
	}
	
	
}
