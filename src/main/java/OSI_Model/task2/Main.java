package OSI_Model.task2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("server start");
		int port = 8080;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				try (Socket clientSocket = serverSocket.accept();
					 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				)
				{
					out.println("Write your name");
					final String name = in.readLine();
					System.out.println(name);
					out.println("Are you child?");
					String question = in.readLine();
					System.out.println(question);
					if (question.equals("yes")) {
						out.println("Welcome to the kids area, %username%! Let's play!");
					}
					if (question.equals("no")) {
						out.println(String.format("Welcome to the adult zone, %s! Have a good " +
							"rest, or a good working day!", name));
					}
					System.out.printf("New connection accepted. Port: %s.", clientSocket.getPort());
					
					out.printf(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
					
				}
			}
		}
		
	}
	
}
