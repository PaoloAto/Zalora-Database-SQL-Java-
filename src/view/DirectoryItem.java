package view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.DirectoryController;
import model.Contact;
import view.materialdesign.MaterialColors;
import view.materialdesign.MaterialFonts;

public class DirectoryItem extends JPanel {
		private static final long serialVersionUID = 1L;
		private JLabel name;
		private JLabel mobile;
		private JLabel email;
		private JLabel group;
		private JLabel date;
		private JButton delete;
		private JButton edit;
		
		private Contact contact;
		
		private DirectoryController controller;
		
		public DirectoryItem () {
			name = new JLabel();
			mobile = new JLabel();
			email = new JLabel();
			group = new JLabel();
			date = new JLabel();
			delete = new JButton("DELETE");
			edit = new JButton("EDIT");
			name.setPreferredSize(new Dimension(200, 50));
			mobile.setPreferredSize(new Dimension(150, 50));
			email.setPreferredSize(new Dimension(150, 50));
			group.setPreferredSize(new Dimension(100, 50));
			delete.setPreferredSize(new Dimension(100, 40));
			edit.setPreferredSize(new Dimension(100, 40));
			
			name.setForeground(Color.WHITE);
			mobile.setForeground(Color.WHITE);
			email.setForeground(Color.WHITE);
			group.setForeground(Color.WHITE);
			date.setForeground(Color.WHITE);
			delete.setForeground(Color.WHITE);
			edit.setForeground(Color.WHITE);

			name.setFont(MaterialFonts.DATA_FONT().deriveFont(Font.BOLD));
			mobile.setFont(MaterialFonts.DATA_FONT().deriveFont(Font.BOLD));           
			email.setFont(MaterialFonts.DATA_FONT().deriveFont(Font.BOLD));
			group.setFont(MaterialFonts.DATA_FONT().deriveFont(Font.BOLD));
			date.setFont(MaterialFonts.DATA_FONT().deriveFont(Font.BOLD));
			delete.setFont(MaterialFonts.DATA_FONT().deriveFont(Font.BOLD));
			edit.setFont(MaterialFonts.DATA_FONT().deriveFont(Font.BOLD));
			
			delete.setBackground(MaterialColors.RED_DARKEN_1);
			edit.setBackground(MaterialColors.GREEN_DARKEN_1);
			
			add(name);
			add(mobile);
			add(email);
			add(group);
			add(date);
			add(delete);
			add(edit);
			
			setPreferredSize(new Dimension(880, 50));
			setLayout(new FlowLayout(FlowLayout.LEFT, 10, 0));
		}
		
		public void setController (DirectoryController controller) {
			this.controller = controller;
		}
		
		public DirectoryItem(DirectoryController con, DirectoryPanel parent, AddPersonPanel panel, Contact contact) {
			this();
			setController(con);
			this.contact = contact;
			name.setText(contact.getName());                        
			mobile.setText(contact.getMobile());                  
			email.setText(contact.getEmail());                      
			group.setText(contact.getGroup());           
			
			setBackground(MaterialColors.BLUE_LIGHTEN_1); 
			setForeground(MaterialColors.BLUE_DARKEN_4); 
			
			edit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					panel.setContact(contact);
				}
			});
			
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.deleteContact(contact);
				}
			});
		}
		
		public static final DirectoryItem createHeader(DirectoryPanel directoryPanel) {
			DirectoryItem item = new DirectoryItem();
			item.name.setText("NAME");
			item.mobile.setText("MOBILE");
			item.email.setText("EMAIL");
			item.group.setText("GROUP");
			
			item.delete.setVisible(false);
			item.edit.setVisible(false);
			JLabel empty = new JLabel();
			empty.setPreferredSize(new Dimension(200, 50));
			item.add(empty);
			item.add(empty);
			item.setBackground(MaterialColors.BLUE_DARKEN_2);
			
			return item;
		}

		public Contact getData () {
			return contact;
		}
}