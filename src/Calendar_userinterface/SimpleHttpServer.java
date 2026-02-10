package Calendar_userinterface;
import com.sun.net.httpserver.HttpServer;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;

public class SimpleHttpServer {

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(2000), 0);

        // Root + index.html
        server.createContext("/", exchange -> {
            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String path = exchange.getRequestURI().getPath();

            // Only allow "/" or "/index.html"
            if (!path.equals("/") && !path.equals("/index.html")) {
                exchange.sendResponseHeaders(404, -1);
                return;
            }

            Path html = Path.of(System.getProperty("user.dir")+"/src/Calendar_userinterface/", "web", "index.html");

            if (!Files.exists(html)) {
                String msg = "index.html not found at: " + html;
                byte[] response = msg.getBytes();
                exchange.sendResponseHeaders(500, response.length);
                try (OutputStream os = exchange.getResponseBody()) {
                    os.write(response);
                }
                return;
            }

            byte[] response = Files.readAllBytes(html);

            exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
            exchange.sendResponseHeaders(200, response.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        });

        // API endpoint
        server.createContext("/api/today", exchange -> {
            if (!exchange.getRequestMethod().equalsIgnoreCase("GET")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            String json = """
            {
              "message": "API works"
            }
            """;

            byte[] response = json.getBytes();
            exchange.getResponseHeaders().add("Content-Type", "application/json");
            exchange.sendResponseHeaders(200, response.length);

            try (OutputStream os = exchange.getResponseBody()) {
                os.write(response);
            }
        });

        server.start();
        System.out.println("Server running at http://localhost:2000/");
        System.out.println("Looking for web/index.html in: " + System.getProperty("user.dir"));
    }
}
