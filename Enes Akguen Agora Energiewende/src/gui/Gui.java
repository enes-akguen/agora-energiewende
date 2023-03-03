package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.Controller;

public class Gui extends JFrame {
	private JPanel labelPanel;
	
	private JPanel inputPanel;
	private JLabel startDateLabel;
	private JTextField startDate;
	private JLabel endDateLabel;
	private JTextField endDate;
	
	private Controller controller;
	
	public Gui(Controller controller)
	{
		this.controller = controller;
		setLayout(new BorderLayout());
		
		// Agorameter label
		
		labelPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbcLabels = new GridBagConstraints();
		gbcLabels.fill = GridBagConstraints.HORIZONTAL;
		gbcLabels.insets = new Insets(10,50,0,50);
		
		gbcLabels.gridx = 0;
		gbcLabels.gridy = 0;
		JLabel agorameter = new JLabel("Agorameter");
		agorameter.setFont(new Font("Serif", Font.PLAIN, 70));
		labelPanel.add(agorameter, gbcLabels);
		
		gbcLabels.gridx = 0;
		gbcLabels.gridy = 1;
		JLabel test = new JLabel("Enes Akgün FA-B-02");
		labelPanel.add(test, gbcLabels);
		
		
		// Start- end date fields
		inputPanel = new JPanel(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(10,50,0,50);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel startDateLabel = new JLabel("Startdatum");
		inputPanel.add(startDateLabel, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		startDate = new JTextField("dd.mm.yyyy");
		startDate.setPreferredSize(new Dimension(200, 30));
		inputPanel.add(startDate, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		JLabel endDateLabel = new JLabel("Enddatum");
		inputPanel.add(endDateLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		endDate = new JTextField("dd.mm.yyyy");
		endDate.setPreferredSize(new Dimension(200, 30));
		inputPanel.add(endDate, gbc);
		
		// Persist button
		gbc.gridx = 1;
		gbc.gridy = 2;
		JButton persistButton = new JButton("Persistieren");
		persistButton.setBackground(Color.BLUE);
		persistButton.setForeground(Color.WHITE);
		persistButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			  try {
				controller.persist(startDate.getText(), endDate.getText());
			} catch (ClassNotFoundException e) {
				System.out.println("Ein Fehler beim Persistieren ist aufgetreten");
			}
			}
		});
		inputPanel.add(persistButton, gbc);
		
		// Main layout
		add(labelPanel, BorderLayout.NORTH);
		add(inputPanel, BorderLayout.CENTER);
		
		setSize(1000, 500);
		setResizable(true);
		setVisible(true);
	}
}