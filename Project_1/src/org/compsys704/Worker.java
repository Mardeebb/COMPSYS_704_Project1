package org.compsys704;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;

public abstract class Worker implements Runnable {
	String signame = null;
	Socket socket = null;
	ObjectInputStream ois = null;
	private Object signalValue;

	public abstract void setSignal(boolean status, Object value);
	
	public void setSignalValue(Object value) {
	    this.signalValue = value;
	}

	public Object getSignalValue() {
	    return signalValue;
	}

	public abstract boolean hasSignal(String sn);

	public void setSocket(Socket s) {
		socket = s;
	}

	public void setObjectInputStream(ObjectInputStream o) {
		ois = o;
	}

	public void setSignalName(String n) {
		signame = n;
	}
	
	long startTime = System.currentTimeMillis();
	boolean elapsed = false;
	
	public boolean initTimeElapsed(){
		if(!elapsed){
			if(System.currentTimeMillis() - startTime > 500){
				elapsed = true;
			}
		}
		return elapsed;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Object[] o = (Object[]) ois.readObject();
				if(initTimeElapsed()) {

	                Boolean status = (Boolean) o[0];
	                Object value = o.length > 1 ? o[1] : null; // second element may carry value
	                if (value == null) {
	                    System.out.println("signal value is null");
	                } else if (value.getClass().isArray()) {
	                    // Handles arrays of primitives or objects
	                    System.out.println("signal: " + Arrays.deepToString(new Object[]{value}).replaceFirst("^\\[\\[", "\\[").replaceFirst("\\]\\]$", "\\]"));
	                } else {
	                    System.out.println("signalVVVVVVVVVVVV: " + value.toString());
	                }

	                setSignal(status, value);

				}
			}
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
				System.exit(1);
			}
		}
	}
}
