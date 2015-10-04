package com.fabiolee.tcp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main {

	public Main() {
	}

	public static void main(String args[]) {
		ServerSocket server = null;
		List clients = new ArrayList();
		Socket client = null;
		try {
			server = new ServerSocket(5000);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println("TCPServer Waiting for client on port 5000");
		ConnectThread connectThread = new ConnectThread(server, clients);
		Thread tConnect = new Thread(connectThread);
		tConnect.setPriority(1);
		tConnect.start();
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(
				System.in));
		PrintWriter outToClient = null;
		try {
			do {
				String toClient;
				do {
					System.out.println((new StringBuilder())
							.append("CLIENTS SIZE:").append(clients.size())
							.toString());
					Socket c;
					for (Iterator i$ = clients.iterator(); i$.hasNext(); System.out
							.println((new StringBuilder())
									.append("THE CLIENTS ")
									.append(c.getInetAddress()).append(":")
									.append(c.getPort()).append(" IS ONLINE.")
									.toString())) {
						c = (Socket) i$.next();
					}

					System.out.println("SEND(Type Q or q to Quit):");
					toClient = inFromUser.readLine();
					for (int i = clients.size() - 1; i >= 0; i--) {
						client = (Socket) clients.get(i);
						outToClient = new PrintWriter(client.getOutputStream(),
								true);
						outToClient.println(toClient);
						if (toClient == null || "Q".equals(toClient)
								|| "q".equals(toClient)) {
							client.close();
							clients.remove(client);
						}
					}

				} while (toClient != null && !"Q".equals(toClient)
						&& !"q".equals(toClient));
				System.out.println("TCPServer Connection reset");
			} while (true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}