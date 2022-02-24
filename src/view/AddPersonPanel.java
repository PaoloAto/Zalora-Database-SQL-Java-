package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.DirectoryController;
import model.Contact;
import view.materialdesign.MaterialColors;
import view.materialdesign.MaterialFonts;

public class AddPersonPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JLabel nameLabel;
	private JLabel groupLabel;
	private JLabel mobileNoLabel;
	private JLabel emailLabel;
	
	private JTextField name;
	private JTextField group;
	private JTextField mobileno;
	private JTextField email;
	private JTextField search;
	
	private JButton addButton;
	private JButton searchButton;
	
	private DirectoryController controller;
	private Contact contact;

	private ActionListener add;
	private ActionListener edit;
	
	public Contact toContact () {
		Contact contact = new Contact();
		
		contact.setName(name.getText());
		contact.setGroup(group.getText());
		contact.setEmail(email.getText());
		contact.setMobile(mobileno.getText());
		
		return contact;
	}
	
	public void setContact (Contact contact) {
		this.contact = contact;
		name.setText(contact.getName());
		group.setText(contact.getGroup());
		email.setText(contact.getEmail());
		mobileno.setText(contact.getMobile());
		addButton.setText("UPDATE");
		
		addButton.removeActionListener(add);
		addButton.addActionListener(edit);
	}
	
	public AddPersonPanel (DirectoryController con) {
		this.controller = con;
		setPreferredSize(new Dimension(300, 700));
		setBackground(MaterialColors.BLUE_DARKEN_4);
		
		add = new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controller.addContact(toContact());
				clear();
			}
		};
		
		edit = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
		
				contact.setName(name.getText());
				contact.setGroup(group.getText());
				contact.setEmail(email.getText());
				contact.setMobile(mobileno.getText());
				controller.editContact(contact);
				addButton.setText("ADD");
				clear();
			}
		};
		addButton = new JButton("ADD");
		nameLabel = new JLabel("Name ");
		mobileNoLabel = new JLabel("Mobile # ");
		emailLabel = new JLabel("Email ");
		groupLabel = new JLabel("Group ");
		search = new JTextField(18);
		searchButton = new JButton("SEARCH GROUP");
		
		name = new JTextField(10);
		mobileno = new JTextField(10);
		email = new JTextField(10);
		group = new JTextField(10);
		
		nameLabel.setPreferredSize(new Dimension(100, 20));
		mobileNoLabel.setPreferredSize(new Dimension(100, 20));
		emailLabel.setPreferredSize(new Dimension(100, 20));
		groupLabel.setPreferredSize(new Dimension(100, 20));
		addButton.setPreferredSize(new Dimension(270, 50));
		search.setPreferredSize(new Dimension(300, 30));
		searchButton.setPreferredSize(new Dimension(270, 50));
		
		nameLabel.setFont(MaterialFonts.DATA_FONT());
		mobileNoLabel.setFont(MaterialFonts.DATA_FONT());
		emailLabel.setFont(MaterialFonts.DATA_FONT());
		groupLabel.setFont(MaterialFonts.DATA_FONT());
		addButton.setFont(MaterialFonts.DATA_FONT());
		search.setFont(MaterialFonts.DATA_FONT());
		searchButton.setFont(MaterialFonts.DATA_FONT());
		
		addButton.setForeground(Color.WHITE);
		nameLabel.setForeground(Color.WHITE);
		mobileNoLabel.setForeground(Color.WHITE);
		emailLabel.setForeground(Color.WHITE);
		groupLabel.setForeground(Color.WHITE);
		
		name.setFont(MaterialFonts.DATA_FONT());
		mobileno.setFont(MaterialFonts.DATA_FONT());
		email.setFont(MaterialFonts.DATA_FONT());
		group.setFont(MaterialFonts.DATA_FONT());
		addButton.setFont(MaterialFonts.DATA_FONT());
		
		searchButton.setBackground(MaterialColors.AMBER_DARKEN_2);
		addButton.setBackground(MaterialColors.GREEN_DARKEN_2);
		add(nameLabel);
		add(name);
		
		add(mobileNoLabel);
		add(mobileno);
		
		add(emailLabel);
		add(email);
		
		add(groupLabel);
		add(group);
		
		add(addButton);
		
		add(search);
		add(searchButton); 
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 15, 20));
		
		addButton.addActionListener(add);
		
	}
	
	public void clear () {
		name.setText("");
		mobileno.setText("");
		email.setText("");
		group.setText("");
	}
}