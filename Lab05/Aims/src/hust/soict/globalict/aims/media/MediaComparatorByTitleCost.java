package hust.soict.globalict.aims.media;

import java.util.Comparator;
import hust.soict.globalict.aims.media.*;
import java.util.Collections;
public class MediaComparatorByTitleCost implements Comparator<Media> {

	public int compare(Media o1, Media o2) {
     int cmp =  o1.getTitle().compareTo(o2.getTitle());
     if(cmp != 0) {
    	 return cmp;
     }
     else {
     int costComparison = Double.compare(o1.getCost(), o2.getCost());
     return costComparison;
     }
   }
}