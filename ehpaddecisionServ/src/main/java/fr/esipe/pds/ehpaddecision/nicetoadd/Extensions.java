package fr.esipe.pds.ehpaddecision.nicetoadd;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.management.InvalidAttributeValueException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.base.GeneratorBase;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Extensions {

	
	private static final Logger log = LoggerFactory.getLogger(Extensions.class);
	public static String getBalise(String balise)
	{
		String baliseValue = null;
		Properties properties = new Properties();
		try 
		{
			InputStream propertiesFile = Extensions.class.getClassLoader().getResourceAsStream("application.properties");
			properties.load(propertiesFile);
			baliseValue = properties.getProperty(balise);
			propertiesFile.close();
		} 
		catch (Exception e) 
		{
			log.error("Imported the worng balise " + balise, e);
		}
		return baliseValue;
	}	
	
	

	

}
