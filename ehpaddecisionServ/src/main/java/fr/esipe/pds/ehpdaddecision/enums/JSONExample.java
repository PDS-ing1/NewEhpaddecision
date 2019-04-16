package fr.esipe.pds.ehpdaddecision.enums;


// this enum could help us to normalize the json messages, like a kind of rules to insert and get done other queries with json
public enum JSONExample {
	
	PERIM("perim"),
	LIST("list"),
	QUERY("query"),
	INFO("info"),
	ERROR("error"), 
	SERIALIZE("serialize");
	
private String baseExample;
	
	JSONExample(String abe)
	{
		this.baseExample = baseExample;
	}
	
	public String baseExample()
	{
		return this.baseExample;
	}
	
}
