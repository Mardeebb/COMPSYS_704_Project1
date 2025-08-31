package org.compsys704;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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

	public Canvas(){
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
			
			
			} catch (IOException e) {
				e.printStackTrace();
				System.exit(1);;
			}
		}
	
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

	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;
	    boolean signal1 = States.capOnBottleAtPos1;  // replace with your actual signal
	    boolean signal2 = States.bottleAtPos5;

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

//		g.drawImage(loader, 0, 100, null);
//		
//		if(States.ARM_AT_DEST)
//			g.drawImage(arm1, 0, 0, null);
//		else
//			g.drawImage(arm2, 30, 0, null);
//		
//		if(States.GRIPPED){
//			if(States.ARM_AT_DEST){
//				g.setColor(Color.black);
//				g.fillOval(10, 11, 30, 30);
//				g.setColor(Color.red);
//				g.fillOval(10, 11, 15, 15);
//
//			}
//			else{
//				g.setColor(Color.black);
//				g.fillOval(40, 243, 30, 30);
//				g.setColor(Color.red);
//				g.fillOval(35, 232, 15, 15);
//			}
//			g.setColor(Color.black);
//		}
////		else{
//			if(States.CAP_READY){ // A cap is pushed to the source pos
//				g.setColor(Color.black);
//				g.fillOval(40, 243, 30, 30);
//			}
////		}
//		
//		if(States.PUSHER_RETRACTED){
//			g.drawImage(p1, 90, 225, null);
//			if(!States.MAG_EMPTY){
//				g.setColor(Color.black);
//				g.fillOval(154, 243, 30, 30);
//			}
//		}
//		else{
//			g.drawImage(p2, 90, 225, null);
//		}
//		
//		if(!States.MAG_EMPTY){
//			g.drawImage(cap, 152, 155, null);
//		}
	    
	    int rotTable_X = 100;
	    int rotTable_y = 100;

	    
		if(States.RT_PS == 0) {
			g.drawImage(rotary_table, rotTable_X, rotTable_y, null);
		}else if(States.RT_PS == 1){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_y, 60);
		}else if(States.RT_PS == 2){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_y, 120);
		}else if(States.RT_PS == 3){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_y, 180);
		}else if(States.RT_PS == 4){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_y, 240);
		}else if(States.RT_PS == 5){
	        drawRotatedImage(g2d, rotary_table, rotTable_X, rotTable_y, 300);
		}
		
		int x_1 = 105;
		int y_1 = 150;
		int x_0 = 105;
		int y_0 = 290;
		int x_2 = 230;
		int y_2 = 80;
		int x_3 = 350;
		int y_3 = 150;
		int x_4 = 350;
		int y_4 = 290;
		int x_5 = 230;
		int y_5 = 360;
		
		for (int i = 0; i < 6; i++) {

			if(States.RT[i] == 1) {
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
			if(States.RT[i] == 5) {
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
	}
}
