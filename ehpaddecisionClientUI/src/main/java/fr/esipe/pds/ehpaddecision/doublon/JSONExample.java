package fr.esipe.pds.ehpaddecision.doublon;

public enum JSONExample {
	
	PERIM("perim"),
	LIST("list"),
	QUERY_EXAMPLE("query"),
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
