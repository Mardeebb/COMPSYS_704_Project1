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
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import run.BottleTwin;
import java.awt.*;
import javax.swing.*;

class POSPanel extends JPanel {
    private EABSBackend backend;
    private DefaultListModel<String> waitingModel = new DefaultListModel<>();
    private DefaultListModel<String> completedModel = new DefaultListModel<>();
    private JLabel processingLabel = new JLabel("No order processing");
    private int orderNumber=0;


    public POSPanel(EABSBackend backend) {    	
        this.backend = backend;
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.weightx = 1.0;
        c.fill = GridBagConstraints.BOTH;
        

        //-----------------submit order--------------
        JPanel orderPannel = new JPanel();
        orderPannel.setBorder(BorderFactory.createTitledBorder("Order"));
        orderPannel.setLayout(new GridBagLayout());
        GridBagConstraints oc = new GridBagConstraints();
        oc.insets = new Insets(5, 5, 5, 5);
        oc.gridx = 0;
        oc.gridy = 0;
        oc.weightx = 1.0;
        oc.fill = GridBagConstraints.HORIZONTAL;

        // Input field
        JTextField orderIdField = new JTextField("Order"+orderNumber);
        JTextField qtyField = new JTextField("5");
        String[]size= {"100ml", "200ml"};
        JComboBox<String> sizebox = new JComboBox<>(size);
        orderPannel.add(orderIdField,oc);
        oc.gridy++;
        orderPannel.add(qtyField,oc);
        oc.gridy++;
        orderPannel.add(sizebox,oc);
        c.gridy = 0;
        c.weighty = 0.15; // 15% vertical space
        add(orderPannel,c);
        
        JPanel recipePanel = new JPanel();
        recipePanel.setBorder(BorderFactory.createTitledBorder("Select Recipe"));
        GridBagConstraints rc = new GridBagConstraints();
        recipePanel.setLayout(new GridBagLayout());
        rc.insets = new Insets(5,5,5,5);
        rc.gridx = 0;
        rc.gridy = 0;
        rc.fill = GridBagConstraints.HORIZONTAL;
        rc.weightx = 0.5;

        String[] liquids = {"Liquid A", "Liquid B", "Liquid C", "Liquid D", "Liquid E"};
        JComboBox<String> liquid1Box = new JComboBox<>(liquids);
        recipePanel.add(new JLabel("First Liquid:"), rc);
        rc.gridx = 1;
        recipePanel.add(liquid1Box, rc);

        rc.gridx = 0;
        rc.gridy++;
        JSpinner percent1 = new JSpinner(new SpinnerNumberModel(50,0,100,5));
        recipePanel.add(new JLabel("Percentage:"), rc);
        rc.gridx = 1;
        recipePanel.add(percent1, rc);

        rc.gridx = 0;
        rc.gridy++;
        JComboBox<String> liquid2Box = new JComboBox<>(liquids);
        liquid2Box.setSelectedIndex(1); 
        recipePanel.add(new JLabel("Second Liquid:"), rc);
        rc.gridx = 1;
        recipePanel.add(liquid2Box, rc);

        rc.gridx = 0;
        rc.gridy++;
        JSpinner percent2 = new JSpinner(new SpinnerNumberModel(50,0,100,5));
        recipePanel.add(new JLabel("Percentage:"), rc);
        rc.gridx = 1;
        recipePanel.add(percent2, rc);

        // Add recipePanel to main layout
        c.gridy = 1;
        c.weighty = 0.25; // 25% vertical space
        add(recipePanel, c);
        JButton submitBtn = new JButton("Submit Order");
        submitBtn.setPreferredSize(new Dimension(140, 40));
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        btnPanel.add(submitBtn);

        c.gridy = 2;
        c.weighty = 0.05; // small vertical space
        c.fill = GridBagConstraints.NONE;
        c.anchor = GridBagConstraints.CENTER;
        add(btnPanel, c);
        c.fill = GridBagConstraints.BOTH; // restore fill for next components

        submitBtn.addActionListener(e -> {
            String orderId = orderIdField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            int idx1 = liquid1Box.getSelectedIndex();
            int idx2 = liquid2Box.getSelectedIndex();
            int p1 = (Integer) percent1.getValue();
            int p2 = (Integer) percent2.getValue();
            int bottlesize = sizebox.getSelectedIndex();
            boolean sizeSignal = false;
            
            if (bottlesize == 1) {
            	sizeSignal = true;
            }

            if (idx1 == idx2) {
                JOptionPane.showMessageDialog(this,
                        "Please choose two different liquids!",
                        "Invalid selection", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (p1 + p2 != 100) {
                JOptionPane.showMessageDialog(this,
                        "Total percentage must equal 100!",
                        "Invalid percentages", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int[] recipe = new int[5];
            recipe[idx1] = p1;
            recipe[idx2] = p2;
            Order o = new Order(orderId, qty,recipe, sizeSignal);
            backend.enqueueOrder(o);
            orderNumber++;
            orderIdField.setText("Order" + orderNumber);
        });

        //--------------------- order process panel-------------------
        JPanel processPanel = new JPanel(new GridBagLayout());
        processPanel.setBorder(BorderFactory.createTitledBorder("Order Processing"));
        processPanel.setLayout(new GridBagLayout());
        GridBagConstraints pc = new GridBagConstraints();
        pc.insets = new Insets(5,5,5,5);
        pc.gridx = 0;
        pc.gridy = 0;
        pc.fill = GridBagConstraints.BOTH;
        pc.weightx = 1.0;

        processPanel.add(new JLabel("Waiting Orders:"), pc);
        pc.gridy++;
        JList<String> waitingList = new JList<>(waitingModel);
        processPanel.add(new JScrollPane(waitingList), pc);

        pc.gridy++;
        processPanel.add(new JLabel("Sending Order:"), pc);
        pc.gridy++;
        processingLabel.setForeground(Color.BLUE); // text color
        processingLabel.setFont(processingLabel.getFont().deriveFont(Font.ITALIC)); // italic
        processPanel.add(processingLabel, pc);

        pc.gridy++;
        processPanel.add(new JLabel("Sent Orders:"), pc);
        pc.gridy++;
        JList<String> completedList = new JList<>(completedModel);
        processPanel.add(new JScrollPane(completedList), pc);

        // Add processPanel to main layout
        c.gridy = 3;
        c.weighty = 0.55; // 55% vertical space
        add(processPanel, c);

        // Refresh UI every 0.5s
        new Timer(500, e -> refreshUI()).start();
    }

    private void refreshUI() {
        waitingModel.clear();
        for (Order o : backend.getWaitingOrders()) {
            waitingModel.addElement(o.id + " (" + o.getCompletedCount() + "/" + o.bottles.size() + ")");
        }

        Order processing = backend.getProcessingOrder();
        if (processing != null) {
            processingLabel.setText(processing.id + " (" + processing.getCompletedCount() + "/" + processing.bottles.size() + ")");
        } else {
            processingLabel.setText("No order processing");
        }
        
        completedModel.clear();
        for (Order o : backend.getCompletedOrders()) {
            completedModel.addElement(o.id + " (" + o.getCompletedCount() + "/" + o.bottles.size() + ")");
        }
    }
}

public class ABS extends JFrame {
	private JPanel panel;
    private EABSBackend backend = new EABSBackend();

	public ABS() {
//		this.setPreferredSize(new Dimension(200, 300));S

		panel = new Canvas(backend);
		panel.setPreferredSize(new Dimension(1000, 600));
		panel.setBackground(Color.WHITE);
		JButton enable = new JButton("Enable");
		enable.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.ENABLE_SIGNAL, null));
		enable.addActionListener(new SignalClient(10002, "rotaryTablePlantCD.enable", null));
		enable.addActionListener(new SignalClient(10005, "conveyorPlantCD.enable", null));
		enable.addActionListener(new SignalClient(10008, "fillerPlantCD.enable", null));
		enable.addActionListener(new SignalClient(10041, "CapperPlantCD.enable", null));
		enable.addActionListener(new SignalClient(10031, "baxtorRobotPlantCD.enable", null));
		enable.addActionListener(new SignalClient(10004, "OrchestratorCD.enable", null));

		JButton request = new JButton("request");
//		request.addActionListener(new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.REQUEST_SIGNAL, null));
		request.addActionListener(new SignalClient(10004, "OrchestratorCD.request", null));
        POSPanel posPanel = new POSPanel(backend);

		JPanel ss = new JPanel();
		ss.add(enable);
//		ss.add(request);

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		this.add(panel, c);

		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 1.0;  // allow horizontal expansion
		c.weighty = 0.0;  // no vertical weight, stay at bottom
		c.fill = GridBagConstraints.HORIZONTAL; // expand horizontally
		c.anchor = GridBagConstraints.SOUTH;   // stick to bottom
		this.add(ss, c);


		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.1;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.VERTICAL;
		this.add(posPanel, c);

		
		this.setTitle("ABS_roTable");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setSize(1000, 600);
	}

	public static void main(String[] args) {
		ABS cl = new ABS();
//		cl.pack();
		cl.setVisible(true);
        new Thread(new OrderDispatcher(cl.backend)).start();

		SignalServer<SysJWorker> server = new SignalServer<SysJWorker>(Ports.PORT_LOADER_VIZ, SysJWorker.class);
		
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
