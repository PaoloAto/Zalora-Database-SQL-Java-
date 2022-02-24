package control;

import model.ContactsDB;
import model.ContactsService;
import view.MainFrame;

public class Main {
	
	public static void main (String [] args) {
		
		MainFrame frame = new MainFrame();
		ContactsService service = new ContactsService(new ContactsDB());
		DirectoryController control = new DirectoryController(service, frame);
		
		control.start();
	}
}
