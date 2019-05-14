package fr.esipe.blondine.synthese;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author PC-Armel
 *
 */
public abstract class ServerUserSocket implements Runnable {

	private int port;
	private boolean runFlag;
	private List<SocketTransceiver> clients = new ArrayList<SocketTransceiver>();

	/**
	 * 
	 * @param port
	 * 
	 */
	public ServerUserSocket(int port) {
		this.port = port;
	}

	/**
	 * 
	 * {@code onServerStop()}
	 * 
	 */
	public void start() {
		runFlag = true;
		new Thread(this).start();
	}

	/**
	 * 
	 * {@code onServerStop()}
	 * 
	 */
	public void stop() {
		runFlag = false;
	}

	/**
	 * 
	 */
	@Override
	public void run() {
		try {
			final ServerSocket server = new ServerSocket(port);
			while (runFlag) {
				try {
					final Socket socket = server.accept();
					startClient(socket);
				} catch (IOException e) {
					// 
					e.printStackTrace();
					this.onConnectFailed();
				}
			}
			// 
			try {
				for (SocketTransceiver client : clients) {
					client.stop();
				}
				clients.clear();
				server.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			// ServerSocket
			e.printStackTrace();
		}
		this.onServerStop();
	}

	/**
	 * 
	 * @param socket
	 */
	private void startClient(final Socket socket) {
		SocketTransceiver client = new SocketTransceiver(socket) {

			@Override
			public void onReceive(InetAddress addr, String s) {
				ServerUserSocket.this.onReceive(this, s);
			}

			@Override
			public void onDisconnect(InetAddress addr) {
				clients.remove(this);
				ServerUserSocket.this.onDisconnect(this);
			}
		};
		client.start();
		clients.add(client);
		this.onConnect(client);
	}

	/**
	 * 
	 * @param client
	 *            SocketTransceiver
	 */
	public abstract void onConnect(SocketTransceiver client);

	/**
	 * 
	 */
	public abstract void onConnectFailed();

	/**
	 * 
	 * @param client
	 *            SocketTransceiver
	 * @param s
	 * 
	 */
	public abstract void onReceive(SocketTransceiver client, String s);

	/**
	 * 
	 * @param client
	 *            SocketTransceiver
	 */
	public abstract void onDisconnect(SocketTransceiver client);

	/**
	 * 
	 */
	public abstract void onServerStop();
}
