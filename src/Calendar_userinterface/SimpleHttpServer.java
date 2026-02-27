package Calendar_userinterface;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class SimpleHTTPServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        // Webseite
        server.createContext("/", new FileHandler("web/index.html"));

        // CSS
        server.createContext("/style.css", new FileHandler("web/style.css"));

        // JavaScript
        server.createContext("/script.js", new FileHandler("web/script.js"));

        // API Endpoint für Button
        server.createContext("/api/button", new ButtonHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server läuft: http://localhost:8080");
    }

    // ===== Dateien ausliefern =====
    static class FileHandler implements HttpHandler {
        private final String filePath;

        public FileHandler(String filePath) {
            this.filePath = filePath;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            File file = new File(filePath);

            byte[] bytes = Files.readAllBytes(file.toPath());

            exchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = exchange.getResponseBody();
            os.write(bytes);
            os.close();
        }
    }

    // ===== Button Logik =====
    static class ButtonHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {

            if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            System.out.println("Button wurde gedrückt!");

            // 👉 HIER deine Java-Logik
            String response = "Java hat den Button verarbeitet!";

            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}
