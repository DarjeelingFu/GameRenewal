package pers.fxy.world;

import java.util.HashSet;
import java.util.Set;

public class Item extends GameObject{
	private ItemInformation info;
	
	private boolean canTrade;
	
	private float basicValue;
	
	private Set<ItemFeature> features = new HashSet<ItemFeature>();
	
	public Item(ItemInformation info) {
		this.info = info;
		// basicValue = defaultValue;
	}
	
	public Item(ItemInformation info, float value) {
		this(info);
		canTrade = true;
		basicValue = value;
	}
	
	public void addFeature(ItemFeature feature) {
		features.add(feature);
	}
	
	public void removeFeature(ItemFeature feature) {
		features.remove(feature);
	}
	
	public void canTrade(boolean flag) {
		canTrade = flag;
	}
	
	public void setBasicValue(float value) {
		basicValue = value;
	}
}
