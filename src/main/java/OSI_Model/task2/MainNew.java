package OSI_Model.task2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MainNew {
	
	public static void main(String[] args) {
		String host = "netology.homework";
		int port = 8080;
		
		try (Socket socket = new Socket(host, port);
			 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())))
		{
			String s = in.readLine();
			System.out.println(s);
			if (s.equals("Write your name")) {
				out.println("Alexandr");
			}
			String s1 = in.readLine();
			System.out.println(s1);
			if (s1.equals("Are you child?")) {
				out.println("no");
			}
			System.out.println(in.readLine());
			System.out.println(in.readLine());
			System.out.println("buy!!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}