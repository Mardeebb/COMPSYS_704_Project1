package org.compsys704;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ABS extends JFrame {
	private JPanel panel;
	
	public ABS() {
//		this.setPreferredSize(new Dimension(200, 300));
		panel = new Canvas();
		panel.setPreferredSize(new Dimension(600, 600));
		panel.setBackground(Color.WHITE);
		JButton enable = new JButton("rotaryTableTrigger");
//		enable.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.ENABLE_SIGNAL));
//		enable.addActionListener(e -> {
//		    States.RT_PS++;
//			if(States.RT_PS == 6) {
//				States.RT_PS = 0;
//			}
//		});

		enable.addActionListener(new SignalClient(10003, "RotaryTableControllerCD.enable"));
		
		JPanel ss = new JPanel();
		ss.add(enable);
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		this.add(panel,c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(ss,c);
		
		// Radio buttons
		JPanel pan3 = new JPanel(new GridLayout(0, 2));
		c.gridx = 0;
		c.gridy = 2;
		this.add(pan3,c);
		
		this.setTitle("ABS_roTable");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	public static void main(String[] args) {
		ABS cl = new ABS();
		cl.pack();
		cl.setVisible(true);
		
		SignalServer<GUIWorker> server = new SignalServer<GUIWorker>(Ports.PORT_LOADER_VIZ, GUIWorker.class);
		new Thread(server).start();
		while(true){
			try {
				cl.repaint();
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
