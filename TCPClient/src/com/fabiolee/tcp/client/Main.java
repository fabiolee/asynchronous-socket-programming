package com.fabiolee.tcp.client;

import java.io.*;
import java.net.Socket;

public class Main {

	public Main() {
	}

	public static void main(String args[]) {
		Socket client = null;
		try {
			client = new Socket("localhost", 5000);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		ReadThread readThread = new ReadThread(client);
		Thread tRead = new Thread(readThread);
		tRead.setPriority(1);
		tRead.start();
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		PrintWriter outToServer = null;
		try {
			String toServer;
			do {
				System.out.println("SEND(Type Q or q to Quit):");
				toServer = inFromUser.readLine();
				outToServer = new PrintWriter(client.getOutputStream(), true);
				outToServer.println(toServer);
			} while (toServer != null && !"Q".equals(toServer)
					&& !"q".equals(toServer));
			client.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}