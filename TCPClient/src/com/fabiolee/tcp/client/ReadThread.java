package com.fabiolee.tcp.client;

import java.io.*;
import java.net.Socket;

public class ReadThread implements Runnable {

	private Socket client;

	public ReadThread(Socket client) {
		this.client = client;
	}

	public void run() {
		do {
			try {
				BufferedReader inFromServer = new BufferedReader(
						new InputStreamReader(client.getInputStream()));
				String fromServer = inFromServer.readLine();
				if (fromServer == null || fromServer.equals("Q")
						|| fromServer.equals("q")) {
					client.close();
					break;
				}
				System.out.println((new StringBuilder()).append("RECIEVED:")
						.append(fromServer).append(",FROM:SERVER").toString());
				continue;
			} catch (Exception e) {
			}
			break;
		} while (true);
		System.out.println("THE SERVER IS DISCONNECTED.");
	}
}