package fr.esipe.pds.ehpaddecision.serversocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.esipe.pds.ehpaddecision.connectionpool.DataSource;

import fr.esipe.pds.ehpaddecision.dao.AbDAO;
import fr.esipe.pds.ehpaddecision.dao.DAOHandler;
import fr.esipe.pds.ehpaddecision.nicetoadd.*;
import fr.esipe.pds.ehpaddecision.enumerations.*;


 /** this class will handle all queries dealing with db
* many reviews should be done and completed */
//TODO remove tests done by sysout


// This class should be able to handle CRUD requests, preparation for serialization and deserialization 
public class ServerHandler implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);
	private Socket socket=null;
	private Connection connection;
		// 	to be able to read client requests
	private BufferedReader queryClient;
		// to be able to response the client
	private PrintWriter answerServer;
	private Object deserializedObject;
	
	
	public ServerHandler(Socket socket, Connection connection){
		this.socket= socket;
		this.connection=connection;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			
			queryClient = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
			answerServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			
			System.out.println("start serveur");
			while (true){
				
				String rq = queryClient.readLine();
				System.out.println(rq);
				
				String outputrq = getDoneQuery(rq);
				answerServer.println(outputrq);
			}
		
		} catch (IOException e) {
			log.error("Sorry, something is wron" + e.getMessage());
			e.printStackTrace();
			try {
				exit();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	private void exit() throws IOException {
			DataSource.putConnection(connection);
			this.connection=null;
			socket.close();	
	}


	
	// All methods to handle client request 
	// At the beginning we should be able to excecute the client request, then send him an answer, depending on what he requests.

	public String getDoneQuery(String jsQuery){		
		String execution = "";
		try {
			System.out.println("Debut1");
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("111111111");
			JsonNode js = mapper.readTree(jsQuery);
			System.out.println(js);
			JsonNode QNode = js.get(JSONExample.INFO.baseExample());
			System.out.println("3333333333");
			System.out.println(QNode);
			String perim = QNode.get(JSONExample.PERIM.baseExample()).textValue();
			System.out.println("4444444444");
			System.out.println(perim);
			Class<?> perimCl = Class.forName(perim);
			System.out.println(perimCl);
			JsonNode seriaObjN = js.get(JSONExample.SERIALIZE.baseExample());
			System.out.println("ON I EST!!!!!!!!!!!!!!");
			System.out.println(seriaObjN);
			Queries siud = Queries.getQueries(QNode.get(JSONExample.QUERY.baseExample()).textValue());
			System.out.println(siud);
			System.out.println("ON Y EST!!!!!!!!!!!!!!");
			switch(siud){
			case SELECT:
				execution = select(perimCl, seriaObjN);
				break;
			case INSERT:
				execution = insert(perimCl, seriaObjN);
				break;
			case UPDATE:
				execution = update(perimCl, seriaObjN);
				break;
			case DELETE:
				execution =  delete(perimCl,  seriaObjN);
				break;
			}

		} 
		catch (Exception e) {
			log.error("Sorry, something is wrong during the execution of the client request :\n" + e.getMessage());
		}
		System.out.println(execution);	
		return execution;
			
	}
	
	
	// this function will handle the insert request, new data
	private String insert(Class<?> perimCl,JsonNode srzdONode) throws Exception{
		System.out.println(" deserialize start ");
		Object deserializedObject = Tools.deserializeObject(srzdONode.toString());
		System.out.println(" deserialize fin ");
		System.out.println(perimCl);
		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		System.out.println(" step 1 start ");
		Object obj = d.create(perimCl.cast(deserializedObject));
		System.out.println(" step 2 start ");
		String result = Tools.serializeObject(perimCl.cast(obj),perimCl, "");
		System.out.println(" step 3 start ");
		
		return result;
	}
	
	// this function will handle the delete request.
	private String delete(Class<?> perimCl, JsonNode srzdONode) throws Exception{
		Object deserObjt = Tools.deserializeObject(srzdONode.toString());
		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		d.delete(perimCl.cast(deserializedObject));
		String result = Tools.serializeObject(null, perimCl, "");
		return result;
	}
	
	// this function will handle the update request. 
	private String update(Class<?> perimCl,JsonNode srzdONode) throws Exception {
		
		
		System.out.println(" deserialize start ");
		Object deserObj = Tools.deserializeObject(srzdONode.toString());
		System.out.println(" deserialize fin ");
		System.out.println(perimCl.toString());
		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		System.out.println("Step10 start");
		d.update(perimCl.cast(deserializedObject));
		String result = Tools.serializeObject(null, perimCl, "");
		System.out.println(result);
		return result;
	}
	

	// this function will handle the select request. 
	private String select(Class<?> perimCl, JsonNode srzdONode) throws Exception {
		System.out.println(perimCl.toString());
		System.out.println("1");
		ObjectMapper mapper = new ObjectMapper();
		String result = "";		
		String getStringJson = srzdONode.get(JSONExample.INFO.baseExample()).textValue();
		List<String> values = null;
		System.out.println(getStringJson);
		if(getStringJson != null && getStringJson.trim().length() > 0) {
			values = mapper.readValue(getStringJson, mapper.getTypeFactory().constructCollectionType(List.class, String.class));
		}
		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		result = Tools.serializeObject(d.find(values), perimCl, "");
		return result;		
	}

}
