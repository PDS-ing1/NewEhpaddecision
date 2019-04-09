package fr.esipe.pds.ehpaddecision.serversocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.esipe.pds.ehpaddecision.connectionpool.DataSource;
import fr.esipe.pds.ehpaddecision.nicetoadd.Tools;
import fr.esipe.pds.ehpaddecision.sensorsreferentiel.AbDAO;
import fr.esipe.pds.ehpaddecision.sensorsreferentiel.DAOHandler;
import fr.esipe.pds.ehpaddecision.sensorsreferentiel.Users;
import fr.esipe.pds.ehpdaddecision.enums.JSONExample;
import fr.esipe.pds.ehpdaddecision.enums.Queries;


 // this class will handle all queries dealing with db

public class ServerHandler implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);
	private Socket socket;
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
			queryClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			answerServer = new PrintWriter(socket.getOutputStream(), true);
			while (true){
				
				String rq = queryClient.readLine();
				System.out.println("Je suis la");
				//String outputrq = getDoneQuery(rq);
				System.out.println("Je suis la");
				//answerServer.println(outputrq);
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

	/*public String getDoneQuery(String jsQuery) 
	{		
		String execution = "";
		try 
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode js = mapper.readTree(jsQuery);
			JsonNode QNode = js.get(JSONExample.INFO.baseExample());	
			String perim = QNode.get(JSONExample.PERIM.baseExample()).textValue();
			Class<?> perimCl = Class.forName(perim);
			JsonNode seriaObjN = js.get(JSONExample.SERIALIZE.baseExample());
			Queries siud = Queries.getQueries(QNode.get(JSONExample.QUERY.baseExample()).textValue());
			
			switch(siud)
			{
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
			return execution;
	}
	
	
	// this function will handle the insert request, new data
	private String insert(Class<?> perimCl,JsonNode srzdONode) throws Exception{
		Object deserializedObject = Tools.deserializeObject(srzdONode.toString());
		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		Users usr = (Users) d.create(perimCl.cast(deserializedObject));
		String result = Tools.serializeObject(perimCl.cast(usr),perimCl, "");
		return result;
	}
	
	// this function will handle the delete request.
	/*private String delete(Class<?> perimCl, JsonNode srzdONode) throws Exception{
		Object deserObjt = Tools.deserializeObject(srzdONode.toString());
		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		d.delete(perimCl.cast(deserializedObject));
		String result = Tools.serializeObject(null, perimCl, "");
		return result;
	}*/
	
	
	/*private String update(Class<?> perimCl,JsonNode srzdONode) throws Exception {
		
		Object deserObj = Tools.deserializeObject(srzdONode.toString());		
		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		d.update(perimCl.cast(deserializedObject));
		String result = Tools.serializeObject(null, perimCl, "");
		return result;
	}*/
	
	
	
	
	
	
	
	
	
	/*private String select(Class<?> perimCl, JsonNode srzdONode) throws Exception
	{

		ObjectMapper mapper = new ObjectMapper();
		String result = "";		
		String getStringJson = srzdONode.get(JSONExample.INFO.baseExample()).textValue();
		

		List<String> values = null;
		

		if(getStringJson != null
				&& getStringJson.trim().length() > 0) 
		{
			values = mapper.readValue(getStringJson, mapper.getTypeFactory().constructCollectionType(List.class, String.class));
			

		}

		AbDAO d = DAOHandler.getDAOHandler(connection, perimCl);
		result = Tools.serializeObject(d.find(values), perimCl, "");

		

		return result;		
	}*/

	
	
	

}
