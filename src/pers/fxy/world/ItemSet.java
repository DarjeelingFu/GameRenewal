package pers.fxy.world;

public class ItemSet extends Item implements GameObject.ObjectSet {
	public ItemSet(ItemInformation info) {
		super(info);
		num = 1;
	}
	
	public ItemSet(ItemInformation info, int num) {
		super(info);
		this.num = num;
	}

	private int num;
	
	@Deprecated
	@Override
	public void addOne() {}

	@Override
	public void add(int num) {
		this.num += num;
	}

	@Deprecated
	@Override
	public void removeOne() {}

	@Override
	public void remove(int num) {
		this.num -= num;
	}
	
	@Override
	public int getNum() { return num; }
	
	@Override
	public void setNum(int num) { this.num = num; }

}
