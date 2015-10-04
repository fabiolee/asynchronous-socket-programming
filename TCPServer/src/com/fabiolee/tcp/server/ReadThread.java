package com.fabiolee.tcp.server;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ReadThread implements Runnable {

	private List clients;
	private Socket client;

	public ReadThread(List clients, Socket client) {
		this.clients = clients;
		this.client = client;
	}

	public void run() {
		do {
			try {
				BufferedReader inFromClient = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				String fromClient = inFromClient.readLine();
				if (fromClient == null || fromClient.equals("Q")
						|| fromClient.equals("q")) {
					client.close();
					clients.remove(client);
					break;
				}
				System.out.println((new StringBuilder()).append("RECIEVED:")
						.append(fromClient).append(",FROM:CLIENT ")
						.append(client.getInetAddress()).append(":")
						.append(client.getPort()).toString());
				continue;
			} catch (Exception e) {
			}
			break;
		} while (true);
		System.out.println((new StringBuilder()).append("THE CLIENT ")
				.append(client.getInetAddress()).append(":")
				.append(client.getPort()).append(" IS DISCONNECTED.")
				.toString());
	}
}