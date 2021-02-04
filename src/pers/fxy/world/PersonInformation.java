package pers.fxy.world;

public class PersonInformation implements GameObject.Information {
	private String name;
	private int age;
	private String hometown;
	// private SocialClass[] classes = null;
	
	public PersonInformation() {}
	
	public PersonInformation(String name, int age, String hometown) {
		this.name = name;
		this.age = age;
		this.hometown = hometown;
	}
	
	public PersonInformation provide() {
		return new PersonInformation(this.name, this.age, this.hometown);
	}
	
	public PersonInformation provideTo(Person person) { return null; }

	@Override
	public void present() {}
}
