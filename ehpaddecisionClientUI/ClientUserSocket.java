package fr.esipe.blondine;

import java.net.InetAddress;
import java.net.Socket;


/**
 * 
 * @author PC-Armel
 *
 */
public abstract class ClientUserSocket implements Runnable {

	private int port;
	private String hostIP;
	private boolean connect = false;
	private SocketTransceiver transceiver;

	/**
	 *
	 * {@code onConnect()}
	 * 
	 * {@code onConnectFailed()}
	 * 
	 * @param hostIP
	 *            IP
	 * @param port
	 * 
	 */
	public void connect(String hostIP, int port) {
		this.hostIP = hostIP;
		this.port = port;
		new Thread(this).start();
	}

	@Override
	public void run() {
		try {
			Socket socket = new Socket(hostIP, port);
			transceiver = new SocketTransceiver(socket) {

				@Override
				public void onReceive(InetAddress addr, String s) {
					ClientUserSocket.this.onReceive(this, s);
				}

				@Override
				public void onDisconnect(InetAddress addr) {
					connect = false;
					ClientUserSocket.this.onDisconnect(this);
				}
			};
			transceiver.start();
			connect = true;
			this.onConnect(transceiver);
		} catch (Exception e) {
			e.printStackTrace();
			this.onConnectFailed();
		}
	}

	/**
	 * {@code onDisconnect()}
	 */
	public void disconnect() {
		if (transceiver != null) {
			transceiver.stop();
			transceiver = null;
		}
	}

	/**
	 * 
	 * @return true
	 */
	public boolean isConnected() {
		return connect;
	}

	/**
	 * Socket
	 * 
	 * @return null
	 */
	public SocketTransceiver getTransceiver() {
		return isConnected() ? transceiver : null;
	}

	/**
	 * 
	 * @param transceiver
	 *            SocketTransceiver
	 */
	public abstract void onConnect(SocketTransceiver transceiver);

	/**
	 * 
	 */
	public abstract void onConnectFailed();

	/**
	 * 
	 * @param transceiver
	 *            SocketTransceiver
	 * @param s
	 * 
	 */
	public abstract void onReceive(SocketTransceiver transceiver, String s);

	/**
	 * 
	 * @param transceiver
	 *            SocketTransceiver
	 */
	public abstract void onDisconnect(SocketTransceiver transceiver);
}
