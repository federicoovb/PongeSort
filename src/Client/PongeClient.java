/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author violaboros.federico
 */
public class PongeClient {
    
    public static void main(String[] args) {        
        System.out.println("Apertura connessione");
        try {
            while(true){
                Socket server = new Socket("10.1.33.3", 5500);
                InputStream dalServer = server.getInputStream();
                BufferedReader lettore = new BufferedReader(new InputStreamReader(dalServer));

                String risposta = lettore.readLine();
                System.out.println("Risposta del server: " + risposta);

                lettore.close();
                server.close();
                System.out.println("Chiusura connessione"); 
            }
        } catch (IOException ex) {
            Logger.getLogger(PongeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
