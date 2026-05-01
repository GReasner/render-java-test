import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws Exception {
        int port = getPort();

        HttpServer server = HttpServer.create(new InetSocketAddress("0.0.0.0", port), 0);

        server.createContext("/", exchange -> {
            String response = "Java server is running on Render.";
            exchange.sendResponseHeaders(200, response.length());

            try (OutputStream output = exchange.getResponseBody()) {
                output.write(response.getBytes());
            }
        });

        server.start();
        System.out.println("Server running on port " + port);
    }

    private static int getPort() {
        String port = System.getenv("PORT");
        return port == null ? 10000 : Integer.parseInt(port);
    }
}
