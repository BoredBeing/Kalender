package Calendar_userinterface;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.Files;

public class SimpleHttpServer {

    public static void main(String[] args) throws Exception {

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", new StaticHandler());
        server.createContext("/api/button", new ButtonHandler());

        server.setExecutor(null);
        server.start();

        System.out.println("Server läuft auf http://localhost:8080");
    }

    // ===============================
    // Static File Handler
    // ===============================
    static class StaticHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            String path = exchange.getRequestURI().getPath();
            System.out.println("Request: " + path);

            if (path.equals("/")) {
                path = "/index.html";
            }


            File file = new File("home/Tobi/Boring_Projects/java/Calendar/Calendar_userinterface/web/index.html");

            if (!file.exists()) {
                String notFound = "404 Not Found";
                exchange.sendResponseHeaders(404, notFound.length());
                exchange.getResponseBody().write(notFound.getBytes());
                exchange.close();
                return;
            }

            String contentType = getContentType(path);
            exchange.getResponseHeaders().add("Content-Type", contentType);

            byte[] data = Files.readAllBytes(file.toPath());
            exchange.sendResponseHeaders(200, data.length);

            OutputStream os = exchange.getResponseBody();
            os.write(data);
            os.close();
        }

        private String getContentType(String path) {
            if (path.endsWith(".html")) return "text/html";
            if (path.endsWith(".css")) return "text/css";
            if (path.endsWith(".js")) return "application/javascript";
            return "text/plain";
        }
    }

    // ===============================
    // Button API
    // ===============================
    static class ButtonHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {

            System.out.println("API Call: " + exchange.getRequestMethod());

            if (!exchange.getRequestMethod().equalsIgnoreCase("POST")) {
                exchange.sendResponseHeaders(405, -1);
                return;
            }

            // 👉 HIER deine Logik
            System.out.println("Button gedrückt!");

            String response = "Java hat reagiert 👍";

            exchange.getResponseHeaders().add("Content-Type", "text/plain");
            exchange.sendResponseHeaders(200, response.getBytes().length);

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }
}