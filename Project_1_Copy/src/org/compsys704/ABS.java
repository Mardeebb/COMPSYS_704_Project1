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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import run.BottleTwin;

class POSPanel extends JPanel {
    private EABSBackend backend;
    private DefaultListModel<String> waitingModel = new DefaultListModel<>();
    private DefaultListModel<String> completedModel = new DefaultListModel<>();
    private JLabel processingLabel = new JLabel("No order processing");

    public POSPanel(EABSBackend backend) {
        this.backend = backend;
        setLayout(new GridLayout(0,1));

        // Input field
        JTextField orderIdField = new JTextField("Order1");
        JTextField qtyField = new JTextField("5");
        JButton submitBtn = new JButton("Submit Order");

        submitBtn.addActionListener(e -> {
            String orderId = orderIdField.getText();
            int qty = Integer.parseInt(qtyField.getText());
            Order o = new Order(orderId, qty);
            backend.enqueueOrder(o);
        });

        add(orderIdField);
        add(qtyField);
        add(submitBtn);

        // Waiting orders
        add(new JLabel("Waiting Orders:"));
        JList<String> waitingList = new JList<>(waitingModel);
        add(new JScrollPane(waitingList));

        // Processing order
        add(new JLabel("Processing Order:"));
        add(processingLabel);

        // Completed orders
        add(new JLabel("Completed Orders:"));
        JList<String> completedList = new JList<>(completedModel);
        add(new JScrollPane(completedList));

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
            completedModel.addElement(o.id + " (done)");
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
		ss.add(request);

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
		c.weightx = 0;
		c.weighty = 0.2;
		c.fill = GridBagConstraints.NONE;
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
		this.setResizable(false);
	}

	public static void main(String[] args) {
		ABS cl = new ABS();
		cl.pack();
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
