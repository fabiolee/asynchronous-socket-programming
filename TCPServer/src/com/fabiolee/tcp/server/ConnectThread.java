package com.fabiolee.tcp.server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ConnectThread implements Runnable {

	private ServerSocket server;
	private List clients;
	private Socket client;

	public ConnectThread(ServerSocket server, List clients) {
		client = null;
		this.server = server;
		this.clients = clients;
	}

	public void run() {
		try {
			do {
				client = server.accept();
				clients.add(client);
				ReadThread readThread = new ReadThread(clients, client);
				Thread tRead = new Thread(readThread);
				tRead.setPriority(1);
				tRead.start();
				System.out.println((new StringBuilder()).append("THE CLIENT ")
						.append(client.getInetAddress()).append(":")
						.append(client.getPort()).append(" IS CONNECTED.")
						.toString());
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}