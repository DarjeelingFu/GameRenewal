package pers.fxy.world;

public class Person extends GameObject {
	private PersonInformation info;
	
	public Person(PersonInformation info) {
		this.info = info;
	}
	
	private Repository repository = new Repository();
	
	public Repository getRepository() { return repository; }
	
	public PersonInformation provideInformationTo(Person person) {
		if(person == null) {
			return info;
		} else {
			return null;
		}
	}
	
}
