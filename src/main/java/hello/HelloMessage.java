package hello;

public class HelloMessage {
	// Create a resource representation class
	private String name;

	public HelloMessage() {

	}

	public HelloMessage(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}
