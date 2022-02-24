package control;

import model.Contact;
import model.ContactsService;
import view.MainFrame;

public class DirectoryController {
	private ContactsService service;
	private MainFrame view;
	
	public DirectoryController (ContactsService service, MainFrame frame) {
		this.service = service;
		this.view = frame;
	}
	
	public void deleteContact(Contact contact) {
		service.deleteContact(contact.getId());
		view.getDirectoryPanel().setItems(service.getAll());
		view.revalidate();
		view.repaint();
	}
	
	public void addContact(Contact contact) {
		service.addContact(contact);
		view.getDirectoryPanel().setItems(service.getAll());
		view.revalidate();
		view.repaint();
	}
	
	public void editContact(Contact contact) {
		service.updateContact(contact);
		view.getDirectoryPanel().setItems(service.getAll());
		view.revalidate();
		view.repaint();
	}
	
	public void filterGroup (String group) {
		if(group.equals(""))
			view.getDirectoryPanel().setItems(service.getAllByGroup(group));
		view.revalidate();
		view.repaint();
	}

	public void start() {
		view.initialize(this);
		view.getDirectoryPanel().setItems(service.getAll());
		view.revalidate();
		view.repaint();
	}
}
