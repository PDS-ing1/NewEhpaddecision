package fr.esipe.pds.ehpaddecision.enumerations;

public enum JSONExample {
	
	PERIM("perim"),
	LIST("list"),
	QUERY("query"),
	INFO("info"),
	ERROR("error"), 
	SERIALIZE("serialize");
	
	
private String baseExample;
	
	JSONExample(String baseExample)
	{
		this.baseExample = baseExample;
	}
	
	public String baseExample()
	{
		return this.baseExample;
	}
	
}

	
	
	

