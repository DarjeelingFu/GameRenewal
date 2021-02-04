package pers.fxy.world;

public class ItemInformation implements GameObject.Information {

	@Override
	public void present() {}
	
	private String name;
	private String description;
	
	public ItemInformation(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public String getName() { return name; }
	public String getDescription() { return description; }

}
