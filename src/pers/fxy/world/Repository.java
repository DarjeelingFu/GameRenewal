package pers.fxy.world;

import java.util.ArrayList;

public class Repository {
	private ArrayList<ItemSet> items = new ArrayList<ItemSet>();
	
	public Repository getItemsOfType() { return null; }
	
	public void add(ItemSet item) {
		int index = -1;
		if((index = items.indexOf(item)) != -1) {
			items.get(index).add(item.getNum());
		} else {
			items.add(item);
		}
	}
	
	public void remove(ItemSet item) {
		int index = -1;
		if((index = items.indexOf(item)) != -1) {
			items.get(index).remove(item.getNum());
		}
	}
}
