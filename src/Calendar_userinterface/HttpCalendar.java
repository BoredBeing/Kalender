package Calendar_userinterface;
import Calendar_logic.Calendar;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;

import java.net.InetSocketAddress;

public class HttpCalendar {
    private Calendar calendar = new Calendar();
    private HttpServer server;


    public void serverInitiate() throws Exception{
        server = HttpServer.create(new InetSocketAddress(8080),0);
        createallContexts(server);
        server.start();
    }

    public void createallContexts(HttpServer pServer){
        pServer.createContext("/", new HttpHandler() {
            @Override
            public void handle(HttpExchange exchange) throws IOException {

            }
        });
        pServer.createContext("/Calendar", new CalendarHttpHandler());
    }

    public static void main(String[] args) throws Exception {
        HttpCalendar serverCalender = new HttpCalendar();
        serverCalender.serverInitiate();
    }
}
