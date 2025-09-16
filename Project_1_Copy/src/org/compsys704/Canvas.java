package org.compsys704;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import run.BottleTwin;

public class Canvas extends JPanel {
	BufferedImage arm1;
	BufferedImage arm2;
	BufferedImage p1;
	BufferedImage p2;
	BufferedImage loader;
	BufferedImage cap;
	BufferedImage empty_bottle;
	BufferedImage full_bottle;
	BufferedImage cap_bottle;
	BufferedImage finish_bottle;
	BufferedImage rotary_table;
	BufferedImage finished_bottle;
	BufferedImage conveyor_moving;
	BufferedImage conveyor_static;
	BufferedImage filler_off;
	BufferedImage filler_on;
	BufferedImage LARM, LARM0, LARM1, LARM2, LARM3, LARM4;
	BufferedImage RARM0, RARM1, RARM2, RARM3, RARM4;
	BufferedImage capper_on, capper_off;
	BufferedImage faultToleranceIDLE, faultToleranceON;
    private EABSBackend backend;

    private Map<Integer, Rectangle> clickableAreas = new HashMap<>();
    
    private void showBottleInfo(BottleTwin bottle) {
        // A small popup, you can use JDialog if you want more custom UI
        JOptionPane.showMessageDialog(
            this,
            "Bottle ID: " + bottle.ID +"\nOrder: " + bottle.order + "\nName: " + bottle.name + "\nStatus: " + bottle.status,
            "Bottle Info",
            JOptionPane.INFORMATION_MESSAGE
        );
    }

	public Canvas(EABSBackend backend){
		this.backend = backend;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                for (Map.Entry<Integer, Rectangle> entry : clickableAreas.entrySet()) {
                    if (entry.getValue().contains(p)) {
                        int bottleId = entry.getKey();
                        BottleTwin bottle = backend.getBottleFromID(bottleId);
                        if (bottle != null) {
                            showBottleInfo(bottle);
                        }
                        break;
                    }
                }
            }
        });

		try {
			BufferedImage bi = ImageIO.read(new File("res/arm.png"));
			arm1 = bi.getSubimage(0, 0, 64, 256);
			arm2 = bi.getSubimage(71, 0, 48, 256);
			loader = ImageIO.read(new File("res/loader.png"));
			bi = ImageIO.read(new File("res/pusher.png"));
			p1 = bi.getSubimage(0, 0, 238, 68);
			p2 = bi.getSubimage(238, 0, 172, 68);
			cap = ImageIO.read(new File("res/cap.png"));
			bi = ImageIO.read(new File("res/rt.png"));
			rotary_table = bi.getSubimage(100, 520, 752, 752);
			rotary_table = scaleImage(rotary_table, 300, 300);
			empty_bottle = bi.getSubimage(89, 294, 200, 200);
			empty_bottle = scaleImage(empty_bottle, 80, 80);
			finished_bottle = bi.getSubimage(529, 296, 200, 200);
			finished_bottle = scaleImage(finished_bottle, 80,80);
			bi = ImageIO.read(new File("res/gui.png"));
			conveyor_static = bi.getSubimage(38, 37, 1247, 107);
			conveyor_moving = bi.getSubimage(38, 177, 1247, 107);
			conveyor_moving = scaleImage(conveyor_moving, 800, 70);
			conveyor_static = scaleImage(conveyor_static, 800, 70);
			bi = ImageIO.read(new File("res/filler.png"));
			filler_off = bi.getSubimage(0, 0, 2000, 1685);
			filler_off = scaleImage(filler_off, 170, 170);
			filler_on = bi.getSubimage(1935, 0, 2050, 1685);
			filler_on = scaleImage(filler_on, 170, 170);
			bi = ImageIO.read(new File("res/robot.png"));
			LARM = bi.getSubimage(30,100, 600,250);
			LARM0 = scaleImage(LARM, 200, 100);
			LARM1 = scaleImage(LARM, 140, 70);
			bi = ImageIO.read(new File("res/CapperStates.png"));
			capper_off = bi.getSubimage(195,35, 130,110);
			capper_on = bi.getSubimage(21,35, 183,110);
			bi = ImageIO.read(new File("res/FaultTolerance.png"));
			faultToleranceIDLE = bi.getSubimage(11,20, 270,370);
			faultToleranceIDLE = scaleImage(faultToleranceIDLE, 200, 300);
			faultToleranceON = bi.getSubimage(325,10, 270,380);
			faultToleranceON = scaleImage(faultToleranceON, 200, 300);

			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);;
			}
		}
	 
	
//	@Override
//	public Dimension getPreferredSize() {
//	    return new Dimension(600, 400); // smaller canvas area
//	}
	
	

	private BufferedImage scaleImage(BufferedImage img, int width, int height) {
	    BufferedImage scaled = new BufferedImage(width, height, img.getType());
	    Graphics2D g2d = scaled.createGraphics();
	    g2d.drawImage(img, 0, 0, width, height, null);
	    g2d.dispose();
	    return scaled;
	}
	
	private void drawRotatedImage(Graphics2D g2d, BufferedImage image, int x, int y, double angleDegrees) {
	    int imgWidth = image.getWidth();
	    int imgHeight = image.getHeight();

	    // Save the original transform
	    AffineTransform old = g2d.getTransform();

	    // Move to the image position and rotate around its center
	    g2d.translate(x, y);
	    g2d.rotate(Math.toRadians(angleDegrees), imgWidth / 2.0, imgHeight / 2.0);

	    // Draw the image at (0,0) in the transformed coordinate system
	    g2d.drawImage(image, 0, 0, null);

	    // Restore original transform
	    g2d.setTransform(old);
	}
	
	private void drawBottle(int id, int x, int y, Graphics g) {
		int type = backend.getGUIrep(id);
		if(type == -1) {
			return;
		}
		switch(type){
			case 0:
				g.drawImage(empty_bottle,x, y, null);
		        break;
			case 1:
				g.drawImage(empty_bottle,x, y, null);
		        break;
			case 2:
				g.drawImage(empty_bottle,x, y, null);
		        break;
			case 3:
				g.drawImage(finished_bottle,x, y, null);
		        break;
		}
	    g.setColor(Color.BLACK);
	    g.drawString(String.valueOf(id), x + 20, y + 20); 
        clickableAreas.put(id, new Rectangle(x, y, empty_bottle.getWidth(), empty_bottle.getHeight()));


	}
	
	
	
	@Override
	protected void paintComponent(Graphics g){
		
	    int rotTable_X = 300;
	    int rotTable_Y = 400;
	    int cap_X = 400;
	    int cap_Y = -60;
        clickableAreas.clear(); // reset each repaint

		
		super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    boolean signal1 = TurnTable.capOnBottleAtPos1;  // replace with your actual signal
	    boolean signal2 = TurnTable.bottleAtPos5;
	    int leftImage = robot.leftImage(robot.cmdL);
	    // draw left arm
	    switch(leftImage) {
	    case 0:
	    	g.drawImage(LARM0, 0, 350, null);
	    	break;
	    case 1:
	    	g.drawImage(LARM1, 0, 350, null);
	    	break;
	    	
	    }
	    
	    // capper image
	    if (Capper.capper_lowered) {
	    	g.drawImage(capper_on, 536, 400, null);	
			//System.err.println("Lowered " + Capper.capper_lowered);

	    } else {
			//System.err.println("Lowered " + Capper.capper_lowered);
	    	g.drawImage(capper_off, 550, 400, null);
	    	
	    }
	    
	    // fault tolerance image
	    if (FaultTolerance.faultTolerance_On) {
	    	 g.drawImage(faultToleranceON, 750, 40, null);
	    } else {
	    	g.drawImage(faultToleranceIDLE, 750, 50, null);
	    }
	    	

	    // Draw Signal 1
	    if(signal1) {
	        g2d.setColor(Color.green);
	    } else {
	        g2d.setColor(Color.red);
	    }
	    g2d.drawString("capOnBottleAtPos1", 450, 100); // (x, y) position on panel

	    // Draw Signal 2
	    if(signal2) {
	    	
	        g2d.setColor(Color.green);
	    } else {
	        g2d.setColor(Color.red);
	    }
	    g2d.drawString("bottleAtPos5", 450, 130); // slightly lower y for separation
	    
	    if(Conveyor.moving) {
			g.drawImage(conveyor_moving, rotTable_X + -250, rotTable_Y + 190, null);
	    }else {
			g.drawImage(conveyor_static, rotTable_X + -250, rotTable_Y + 190, null);
	    }
//		System.err.println(Conveyor.posZeroID);

    	drawBottle(Conveyor.posZeroID, rotTable_X + -250, rotTable_Y + 190, g);
    	drawBottle(Conveyor.posOneID, rotTable_X + 0, rotTable_Y + 190, g);
    	drawBottle(Conveyor.posFiveID, rotTable_X + 250, rotTable_Y + 190, g);
    	drawBottle(Conveyor.posSevenID, rotTable_X + 500, rotTable_Y + 190, g);
    	
		if(Filler.filler_on) {
			g.drawImage(filler_on, 75, 75, null);
		}else {		
			g.drawImage(filler_off, 75, 75, null);

		}

	    	
		if(TurnTable.RT_PS == 0) {
			g.drawImage(rotary_table, rotTable_X, rotTable_Y, null);
		}else if(TurnTable.RT_PS == 1){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_Y, 60);
		}else if(TurnTable.RT_PS == 2){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_Y, 120);
		}else if(TurnTable.RT_PS == 3){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_Y, 180);
		}else if(TurnTable.RT_PS == 4){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_Y, 240);
		}else if(TurnTable.RT_PS == 5){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_Y, 300);
		}

		int x_1 = rotTable_X + 5;
		int y_1 = rotTable_Y + 50;
		int x_0 = rotTable_X + 5;
		int y_0 = rotTable_Y + 190;
		int x_2 = rotTable_X + 130;
		int y_2 = rotTable_Y - 20;
		int x_3 = rotTable_X + 250;
		int y_3 = rotTable_Y + 50;
		int x_4 = rotTable_X + 250;
		int y_4 = rotTable_Y + 190;
		int x_5 = rotTable_X + 130;
		int y_5 = rotTable_Y + 260;
		
		for (int i = 0; i < 6; i++) {

			if(TurnTable.RT[i] == 1) {
				switch(i){
					case 0:
						g.drawImage(empty_bottle,x_0, y_0, null);
				        break;
					case 1:
						g.drawImage(empty_bottle,x_1, y_1, null);
				        break;
					case 2:
						g.drawImage(empty_bottle,x_2, y_2, null);
				        break;
					case 3:
						g.drawImage(empty_bottle,x_3, y_3, null);
				        break;
					case 4:
						g.drawImage(empty_bottle,x_4, y_4, null);
				        break;
					case 5:
						g.drawImage(empty_bottle,x_5, y_5, null);
				}
			}
			if(TurnTable.RT[i] == 5) {
				switch(i){
					case 0:
						g.drawImage(finished_bottle,x_0, y_0, null);
				        break;
					case 1:
						g.drawImage(finished_bottle,x_1, y_1, null);
				        break;
					case 2:
						g.drawImage(finished_bottle,x_2, y_2, null);
				        break;
					case 3:
						g.drawImage(finished_bottle,x_3, y_3, null);
				        break;
					case 4:
						g.drawImage(finished_bottle,x_4, y_4, null);
				        break;
					case 5:
						g.drawImage(finished_bottle,x_5, y_5, null);
				}
			}
		}
		g.drawImage(loader, cap_X + 0, cap_Y + 100, null);
		
		if(States.ARM_AT_DEST)
			g.drawImage(arm2, cap_X + 25, cap_Y + 220, null);
		else
			g.drawImage(arm1, cap_X + 25, cap_Y + 220, null);

		
		if(States.GRIPPED){
			if(States.ARM_AT_DEST){
				g.setColor(Color.black);
				g.fillOval(cap_X + 10, cap_Y + 11, 30, 30);
				g.setColor(Color.red);
				g.fillOval(cap_X + 10, cap_Y + 11, 15, 15);
			}
			else{
				g.setColor(Color.black);
				g.fillOval(cap_X + 40, cap_Y + 243, 30, 30);
				g.setColor(Color.red);
				g.fillOval(cap_X + 35, cap_Y + 232, 15, 15);
			}
			g.setColor(Color.black);
		}
//		else{
			if(States.CAP_READY){ // A cap is pushed to the source pos
				g.setColor(Color.black);
				g.fillOval(cap_X + 40, cap_Y + 243, 30, 30);
			}
//		}
		
		if(States.PUSHER_RETRACTED){
			g.drawImage(p1, cap_X + 90, cap_Y + 225, null);
			if(!States.MAG_EMPTY){
				g.setColor(Color.black);
				g.fillOval(cap_X + 154, cap_Y + 243, 30, 30);
			}
		}
		else{
			g.drawImage(p2, cap_X + 90, cap_Y + 225, null);
		}
		
		if(!States.MAG_EMPTY){
			g.drawImage(cap, cap_X + 152, cap_Y + 155, null);
		}

	}
}
