package view;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import control.DirectoryController;
import view.materialdesign.MaterialColors;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 1L;
	private DirectoryPanel directory;
	private AddPersonPanel addPerson;
	private JScrollPane scroll;
	
	public void initialize (DirectoryController controller) {

		addPerson = new AddPersonPanel(controller);
		directory = new DirectoryPanel(addPerson, controller);
		scroll = new JScrollPane(directory);
		add(scroll);
		add(addPerson);
		
		setTitle("Connecting Java and MySQL");
		setSize(1310, 700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBackground(MaterialColors.BLUE_ACCENT_1);
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

		pack();
		setVisible(true);
	}

	public DirectoryPanel getDirectoryPanel() {
		return directory;
	}
}


