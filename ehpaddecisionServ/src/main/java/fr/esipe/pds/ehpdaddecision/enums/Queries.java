package fr.esipe.pds.ehpdaddecision.enums;
// this enum will help us to call this queries everytime that we need its

public enum Queries {
	INSERT,
	SELECT,
	UPDATE,
	DELETE;
	
	public static Queries getQueries(String query)
	{
		Queries[] values = Queries.values();
		for(Queries value : values)
		{
			if(value.toString().equalsIgnoreCase(query))
				return value;
		}
		return null;
	}

}
