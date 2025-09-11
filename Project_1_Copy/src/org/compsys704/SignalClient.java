package org.compsys704;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SignalClient implements ActionListener {

	Socket s = new Socket();
    private ObjectOutputStream oos;
    private final int port;
    private final String ip = "127.0.0.1";
    private final String dest;  // signal name
    private final Object object;
    
	public SignalClient(int p, String dest, Object object){
		this.dest = dest;
		this.object = object;
		port = p;
		try {
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);;
		}
	}

    private void connect() throws Exception {
        if (s.isClosed()) {
            s = new Socket();
            s.connect(new InetSocketAddress(ip, port), 10); // 2-second timeout
            oos = new ObjectOutputStream(s.getOutputStream());

			oos.writeObject(dest);
			int resp = s.getInputStream().read();
			if(resp < 0)
				throw new ConnectException("Not thru");
        }
    }
    
    public void send() {
        try {
            connect();
            SignalMessage msg = new SignalMessage(dest, object);
            oos.writeObject(new Object[]{true, object});
            Thread.sleep(50);
            oos.writeObject(new Object[]{false});
            System.out.println("Sent signal: " + dest);
        } catch (Exception ex) {
            System.err.println("Error sending signal: " + ex);
            try { s.close(); } catch (Exception ignored) {}
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	send();
    }
}
