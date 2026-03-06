package Calendar_userinterface;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;

public class CalendarHttpHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {

        if(!exchange.getRequestMethod().equalsIgnoreCase("GET")) return;
         String uri = exchange.getRequestURI().toString();
         String allParameter = uri.split("?")[1];
         String[] parameter = allParameter.split("&");

    }
}
