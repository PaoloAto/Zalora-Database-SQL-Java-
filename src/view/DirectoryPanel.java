package view;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import control.DirectoryController;
import model.Contact;
import view.materialdesign.VerticalFlowLayout;

public class DirectoryPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private List <DirectoryItem> items;
		private DirectoryItem header;
		private DirectoryController controller;
		private AddPersonPanel addPersonalPanel;
		
		public DirectoryPanel (AddPersonPanel adpanel, DirectoryController controller) {
			addPersonalPanel = adpanel;
			header = DirectoryItem.createHeader(this);
			this.controller = controller;
			items = new ArrayList <DirectoryItem> ();
			
			setPreferredSize(new Dimension(880, 700));		
			add(header);
			setLayout(new VerticalFlowLayout(VerticalFlowLayout.LEFT, 
									VerticalFlowLayout.TOP, 0, 0));
		}
		
		public void setItems (List <Contact> directory) {
				if(directory != null) {
				for (int i = 0; i < items.size(); i++) {
					remove(items.get(i));
				}
				
				items.clear();
				
				for (int i = 0; i < directory.size(); i++) {
					items.add(new DirectoryItem(controller, this, addPersonalPanel, directory.get(i)));
				}
				
				for (int i = 0; i < items.size(); i++) {
					add(items.get(i));
				}
			}
		}
	}