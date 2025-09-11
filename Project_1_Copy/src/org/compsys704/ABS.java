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
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import run.BottleTwin;

class POSPanel extends JPanel {
    private EABSBackend backend;
    private DefaultListModel<String> ordersModel = new DefaultListModel<>();

    public POSPanel(EABSBackend backend) {
        this.backend = backend;
        setLayout(new GridLayout(0,1));

        JTextField orderIdField = new JTextField("Order1");
        JTextField qtyField = new JTextField("5");
        JButton submitBtn = new JButton("Submit Order");
        JList<String> ordersList = new JList<>(ordersModel);

        submitBtn.addActionListener(e -> {
            String orderId = orderIdField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            Order o = new Order(orderId, qty);
            backend.enqueueOrder(o);
        });

        add(orderIdField);
        add(qtyField);
        add(submitBtn);
        add(new JScrollPane(ordersList));

        // Refresh every second
        new Timer(1000, e -> {
            ordersModel.clear();
            for (Order o : backend.getOrders()) {
                ordersModel.addElement(o.id + " (" + o.getCompletedCount() + "/" + o.bottles.size() + ")");
            }
        }).start();
    }
}

public class ABS extends JFrame {
	private JPanel panel;
	
	public ABS() {
//		this.setPreferredSize(new Dimension(200, 300));
		panel = new Canvas();
		panel.setPreferredSize(new Dimension(1300, 800));
		panel.setBackground(Color.WHITE);
		JButton enable = new JButton("rotaryTableTrigger");
		BottleTwin bottle = new BottleTwin();
		enable.addActionListener(new SignalClient(Ports.PORT_LOADER_PLANT, Ports.ENABLE_SIGNAL, null));
		enable.addActionListener(new SignalClient(10003, "rotaryTableControllerCD.enable", bottle));
		JButton request = new JButton("request");
		request.addActionListener(new SignalClient(Ports.PORT_LOADER_CONTROLLER, Ports.REQUEST_SIGNAL, null));

		JPanel ss = new JPanel();
		ss.add(enable);
		ss.add(request);

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
