package org.compsys704;
import run.BottleTwin;


class OrderDispatcher implements Runnable {
    private EABSBackend backend;
    private BottleTwin currentBottle = null;
    public OrderDispatcher(EABSBackend backend) {
        this.backend = backend;
    }

    
    @Override
    public void run() {
        while (true) {
        	if (currentBottle == null) {
        		currentBottle = backend.takeBottle();
    		    if (currentBottle != null) {
	    		    System.err.println("newBottle from backend" + currentBottle.ID);
    		    }
        	}
        	if(!Caploader.recieveTwin) {
    		    if (currentBottle != null) {
	    		    System.err.println(    		    	Caploader.recieveTwin);

            		SignalClient sc = new SignalClient(10004, "OrchestratorCD.newBottleTwin", currentBottle);
            		sc.send();
            		Caploader.recieveTwin = true;
            		currentBottle = null;
    		    }
        	}
		}
    }
}
