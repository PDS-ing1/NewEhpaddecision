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

import fr.esipe.ehpaddecision.sensorsreferentiel.CurrentUser;
import fr.esipe.ehpaddecision.sensorsreferentiel.DAOHandler;
import fr.esipe.ehpaddecision.sensorsreferentiel.AbDAO;
import fr.esipe.pds.ehpaddecision.connectionpool.DataSource;
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
	
	
	public ServerHandler(Socket socket, Connection connection){
		this.socket= socket;
		this.connection=connection;
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			queryClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			answerServer = new PrintWriter(socket.getOutputStream(), true);
			while (true){
				String rq = queryClient.readLine();
				String outputrq = getExecutedRequest(rq);
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
			DataSource.free(connection);
			this.connection=null;
			socket.close();	
	}


	private String getExecutedRequest(String rq) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// All methods to handle client request 
	// At the beginning we should be able to excecute the client request, then send him an answer, depending on what he requests.

	public String getDoneQuery(String jsQuery) 
	{		
		String execution = "";

		try 
		{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode js = mapper.readTree(jsQuery);
			JsonNode QNode = js.get(JSONExample.());	
			String requestEntity = QNode.get(JSONExample.;
		
			
			Class<?> entityClass = Class.forName(requestEntity);
			JsonNode serializedObjectNode = js.get(JSONExample;
			
			Queries siud = Queries.getRequestType(QNode.get(JSONExample;
			
			switch(siud)
			{
			case SELECT:
				execution = select(entityClass, QNode);
				break;
			case INSERT:
				execution = insert(entityClass, QNode, serializedObjectNode);
				break;
			case UPDATE:
				execution = update(entityClass, QNode, serializedObjectNode);
				break;
			case DELETE:
				execution =  delete(entityClass, QNode, serializedObjectNode);
				break;
			}

		} 
		catch (Exception e) {
		
			log.error("An error occured during the execution of the client request :\n" + e.getMessage());
		}
			return execution;
		

	}
	// this function will handle the insert request, new data
	private String insert(Class<?> entityClass,JsonNode srzdONode){
		Object deserializedObject = Util.deserializeObject(srzdONode.toString());
		AbDAO d = DAOHandler.getDAOHandler(connection, entityClass);
		CurrentUser usr = (CurrentUser) d.create(entityClass.cast(deserializedObject));
		String result = Util.serializeObject(entityClass.cast(usr), LocationSensor, "");
		return result;
	}
	
	// this function will handle the delete request.
	private String delete(Class<?> entityClass, JsonNode dataNode){
		Object deserializedObject = Util.deserializeObject(dataNode.toString());
		AbDAO d = DAOHandler.getDAOHandler(connection, entityClass);
		d.delete(entityClass.cast(deserializedObject));
		String result = Util.serializeObject(null, entityClass, "");
		return result;
	}
	
	

}
