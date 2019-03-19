package fr.esipe.pds.client;
import java.io.*; 
import java.util.*; 
import java.net.*; 


public class ClientHandler implements Runnable {

	Scanner scn = new Scanner(System.in);
	private String name;
	final DataInputStream dis;
	final DataOutputStream dos;
	Socket s; 
	boolean isloggedin;
	
	
	//construtor of clientHandler
	public ClientHandler(Socket s, String name, DataInputStream dis, DataOutputStream dos){
		this.s=s;
		this.name=name;
		this.dis=dis;
		this.dos=dos;
		this.isloggedin=true;
	}
	
	
	
	
	@Override
	public void run() {
		String received; 
		while (true){
			try {
				
			}
		}
		
	}
	

}
