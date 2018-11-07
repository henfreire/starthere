package mainServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

import org.simpleframework.http.core.Container;
import org.simpleframework.http.core.ContainerSocketProcessor;
import org.simpleframework.transport.connect.Connection;
import org.simpleframework.transport.connect.SocketConnection;

public class App {
	private static final int PORT = 7201;
									
	public static void main(String args[]) throws IOException {
		Container container = new AJAXServer();
		ContainerSocketProcessor servidor = new ContainerSocketProcessor(container);
		Connection conexao = new SocketConnection(servidor);
		SocketAddress endereco = new InetSocketAddress(PORT);
		
		conexao.connect(endereco);

		System.out.println("Tecle ENTER para interromper o servidor...");
		System.in.read();

		conexao.close();
		servidor.stop();
	}
}