package fr.esipe.pds.ehpaddecision.doublon;
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


public class Tools {

	private static final Logger log = LoggerFactory.getLogger(Tools.class);

	public static String propertiesFileHandler(String propertyName)
	{
		String val = null;
		Properties properties = new Properties();
		try 
		{
			InputStream propertiesFile = Tools.class.getClassLoader().getResourceAsStream("properties.properties");
			properties.load(propertiesFile);
			val = properties.getProperty(propertyName);
			log.info("Properties file well loaded");
			propertiesFile.close();
		} 
		catch (Exception e) 
		{
			log.error("Error when getting the property called " + propertyName, e);
		}
		return val;
	}


	public static String serializeObject(Object obj, Class Class, String message)
	{		
		String JSONobj = null;

		ObjectMapper mapper = new ObjectMapper();
		ObjectNode node = mapper.createObjectNode();
		message = (message == null) ? "" : message;
		node.put(JSONExample.ERROR.baseExample(), message);
		try {

			if(obj != null && Class != null)
			{
				/*
				 * The object can be a list when we are retrieving all of the datas of a table.
				 * This usually happens because of the 'findAll()' method
				 */
				if(obj instanceof List)
				{
					node.put(JSONExample.LIST.baseExample(), true);				
				}
				else
				{
					node.put(JSONExample.LIST.baseExample(), false);
				}

				
				/*
				 * We add the entity name in order to make the deserialization easier
				 * because we will have one deserialization process for all of the entities
				 */
				
				node.putPOJO(JSONExample.INFO.baseExample(), obj);
				log.info("Successful serialization");
			}
			else
			{
				log.error("Sorry no object to serialize found !");				
			}

			JSONobj = mapper.writeValueAsString(node);
		} 
		catch (Exception e) 
		{
			log.error("Sorry, your serialization was wrong : " + e.getStackTrace());
		}			

		return JSONobj;
	}
	
	
	
	
	// this function will be able to convert a json string into a java object 
	public static Object deserializeObject(String objectInJSONString) {

		Object jstObj = null;
		ObjectMapper mapper = new ObjectMapper();

		try {

			if(objectInJSONString == null || objectInJSONString.trim().length() == 0)
				throw new Exception("Sorry, We can't load to serialize, check again!");

			// Converts the String into a JSON Node
			JsonNode stringJs = mapper.readTree(objectInJSONString);
			JsonNode perimNode = stringJs.get(JSONExample.PERIM.baseExample());
			//JSON Node containing the datas of the entity
			JsonNode infoNode = stringJs.get(JSONExample.INFO.baseExample());
			// Node which allows us to know if we have a list of entities (because of the method 'findAll()') or only one
			JsonNode listNode = stringJs.get(JSONExample.LIST.baseExample());

			// Gets the name of the entity we want to deserialize
			String className = perimNode.textValue();
			Class<?> objectClass = Class.forName(className);

			boolean isListOfEntities = listNode.booleanValue();			

			if(isListOfEntities)
				jstObj = mapper.readValue(infoNode.toString(), mapper.getTypeFactory().constructCollectionType(List.class, objectClass));
			else
				jstObj = mapper.readValue(infoNode.toString(), objectClass);

			log.info("Deserialization into Java Object succedeed");

		} catch (Exception e) {
			log.error("Deserialization into Java Object failed : " + e.getMessage());
			e.printStackTrace();
		} 

		return jstObj;		
	}

	public static String jsonNode(JSONExample example, String js)
	{
		String result = "";		

		try 
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode objectFromStringNode = mapper.readTree(js);
			JsonNode dataNode = objectFromStringNode.get(example.baseExample());
			result = dataNode.textValue();			
		} 
		catch (IOException e) 
		{
			log.error(e.getMessage());
		}
			return result;
	}
	
	
	
	
	// this function should be able to reflect pretty line 
	public static String getPrettyJson(String jsString)
	{
		ObjectMapper mapper = new ObjectMapper();
		// indent_ouput display the answer in multiple lines, as a pretty display
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		try 
		{
			JsonNode jsonNode = mapper.readTree(jsString);
			return mapper.writeValueAsString(jsonNode);
		} 
		catch (IOException e) 
		{
			log.error(e.getMessage());
			return "";
		}
	}
	
	
	/**
	 * comments : The Jackson ObjectMapper class (com.fasterxml.jackson.databind.ObjectMapper) is the simplest way 
	 * to parse JSON with Jackson. The Jackson ObjectMapper can parse JSON from a string, stream or file, 
	 * and create a Java object or object graph representing the parsed JSON. 
	 * Parsing JSON into Java objects is also referred to as to deserialize Java objects from JSON.
	 * 
	 */
	 
}
