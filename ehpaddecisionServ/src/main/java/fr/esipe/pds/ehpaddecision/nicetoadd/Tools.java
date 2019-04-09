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

import fr.esipe.pds.ehpdaddecision.enums.JSONExample;
import fr.esipe.pds.ehpdaddecision.enums.Queries;
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
				
				if(obj instanceof List)
				{
					node.put(JSONExample.LIST.baseExample(), true);				
				}
				else
				{
					node.put(JSONExample.LIST.baseExample(), false);
				}				
				node.putPOJO(JSONExample.INFO.baseExample(), obj);
				log.info("Successful serialization");
				System.out.println(obj.toString());
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
			System.out.println("ERROR " + obj.toString());
			System.out.println("Exception " +e.toString());
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

			JsonNode stringJs = mapper.readTree(objectInJSONString);
			JsonNode perimNode = stringJs.get(JSONExample.PERIM.baseExample());
		
			JsonNode infoNode = stringJs.get(JSONExample.INFO.baseExample());
			
			JsonNode listNode = stringJs.get(JSONExample.LIST.baseExample());

			
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
	
	
	
	/*public static String serializeQuery(Queries queryExample, Class entityClass,String serializedObject, 
			List<String> values)
	{	
	
		
			String objectToJSON = null;

			try {
				if(queryExample == null || entityClass == null)
					throw new IOException("The request type and the entity class cannot be null !");

				objectToJSON = null;

				ObjectMapper mapper = new ObjectMapper();

				ObjectNode rootNode = mapper.createObjectNode();
				ObjectNode requestNode = mapper.createObjectNode();

				if(serializedObject == null)
					serializedObject = "";
				JsonNode serializedObjectNode = mapper.readTree(serializedObject);

				requestNode.put(JSONExample.QUERY.baseExample(), queryExample.toString());		
				requestNode.put(JSONExample.PERIM.baseExample(), entityClass.getName());	

				
				
	
			requestNode.putPOJO(JSONExample.INFO.baseExample(), values);

			rootNode.putPOJO(JSONExample.SERIALIZE.baseExample(), serializedObjectNode);

			objectToJSON = mapper.writeValueAsString(rootNode);
		} catch (IOException e) {
			log.error("An error occurred during the serialization of the request :\n" + e.getMessage());
		}

		return objectToJSON;
	}	
*/

	
	
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
