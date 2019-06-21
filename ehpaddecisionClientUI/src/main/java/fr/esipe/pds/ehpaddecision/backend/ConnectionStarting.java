package fr.esipe.pds.ehpaddecision.backend;


// this enum should be removed from this class and kept only in the share package
// TODO remove this class
public enum ConnectionStarting {
	FAIL(-1,"Something is wrong with the connection..."),
	TRYAGAIN(0, "We are facing some issues.. Please try again"),
	WELLDONE(1,"Welcome, you are connected "),
	CONNECTION_PROBLEM(-1, "All resources are used... Please try again later.");

	private int number;
	private String message;
	
	ConnectionStarting(int number, String message) {
		this.number=number;
		this.message=message;
	}
	public int getNumber() {
		return number;
	}

	public String getMessage() {
		return message;
	
	}
}

