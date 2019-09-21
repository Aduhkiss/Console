package me.atticuszambrana.console.common;

import java.net.*;
import java.io.*;

public class Packet
{
    String _message;
    String _fullRequest;
    RequestType _type;
    String USER_AGENT;
    String SERVER_ADDR;
    
    public Packet(final String message, final RequestType type) {
        this.USER_AGENT = "Mozilla/5.0";
        this.SERVER_ADDR = "https://atticus-console.glitch.me/";
        this._message = message;
        this._fullRequest = String.valueOf(this.SERVER_ADDR) + message;
        this._type = type;
    }
    
    public String getMessage() {
        return this._message;
    }
    
    public RequestType getType() {
        return this._type;
    }
    
    public String Create() throws Exception {
        if (this._type == RequestType.INFINITY) {
            final URL obj = new URL(this._fullRequest);
            final HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", this.USER_AGENT);
            final int responseCode = con.getResponseCode();
            final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            final StringBuffer response = new StringBuffer();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        }
        if (this._type == RequestType.BASIC) {
            final StringBuffer response2 = new StringBuffer();
            new Thread() {
                @Override
                public void run() {
                    try {
                        final URL obj = new URL(Packet.this._message);
                        final HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                        con.setRequestMethod("GET");
                        con.setRequestProperty("User-Agent", Packet.this.USER_AGENT);
                        final int responseCode = con.getResponseCode();
                        final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                        String inputLine;
                        while ((inputLine = in.readLine()) != null) {
                            response2.append(inputLine);
                        }
                        in.close();
                    }
                    catch (Exception ex) {}
                }
            }.start();
            return response2.toString();
        }
        return "Err|InvalidRequestType";
    }
    
    private String Get(final String url) {
        final StringBuffer response = new StringBuffer();
        new Thread() {
            @Override
            public void run() {
                try {
                    final URL obj = new URL(url);
                    final HttpURLConnection con = (HttpURLConnection)obj.openConnection();
                    con.setRequestMethod("GET");
                    con.setRequestProperty("User-Agent", Packet.this.USER_AGENT);
                    final int responseCode = con.getResponseCode();
                    final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                }
                catch (Exception ex) {
                    response.append("Err");
                }
            }
        }.start();
        return response.toString();
    }
    
    public enum RequestType
    {
        INFINITY("INFINITY", 0), 
        BASIC("BASIC", 1);
        
        private RequestType(final String s, final int n) {
        }
    }
}
