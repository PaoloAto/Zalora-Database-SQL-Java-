package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class ContactsService {
	private ContactsDB connection;
	
	public ContactsService(ContactsDB contactsDB) {
		this.connection = contactsDB;
	}

	public List<Contact> getAll() {
		// Create empty list of contacts
		List <Contact> contacts = new ArrayList <Contact>();
		
		//get connection from db
		Connection cnt = connection.getConnection();
		
		//create string query
		String query = "SELECT * FROM " + Contact.TABLE;
		
		try {
			//create prepare statement
			PreparedStatement ps = cnt.prepareStatement(query);
			//get result and store in result set
			ResultSet rs = ps.executeQuery();
			//transform set to list
			while(rs.next())
			{
				contacts.add(toContact(rs));
			}
			//close all resources]
			ps.close();
			rs.close();
			cnt.close();
			System.out.println("Contact Select Success");
		} catch (SQLException e) {

			System.out.println("Contact Select Failed");
			e.printStackTrace();
		}
		
		return contacts;
	}
	
	public static void main(String [] args)
	{
		ContactsService service = new ContactsService(new ContactsDB());
		List <Contact> contacts = service.getAll();
		for(Contact contact:contacts)
		{
			System.out.println(contact);
		}
	}

	private Contact toContact(ResultSet rs) throws SQLException {
		Contact contact = new Contact ();
		
		contact.setId(rs.getInt(Contact.COL_ID));
		contact.setEmail(rs.getString(Contact.COL_EMAIL));
		contact.setGroup(rs.getString(Contact.COL_GROUP));
		contact.setMobile(rs.getString(Contact.COL_MOBILE));
		contact.setName(rs.getString(Contact.COL_NAME));
		
		
		return contact;
	}

	public void deleteContact(int id) {
		// get a connection
		Connection cnt = connection.getConnection();
		
		//create query
		String query = "DELETE FROM " + Contact.TABLE + " WHERE id = ?";
		
		//created a prepared statement
		try {
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//prepare the values
		ps.setInt(1, id);
		
		//execute the update
		ps.executeUpdate();
		
		//close resources
		ps.close();
		cnt.close();
		System.out.println("[CONTACTS] DELETE SUCCESS");
		}
		catch(SQLException e){
		System.out.println("[CONTACTS] DELETE FAILED");
		e.printStackTrace();
		}
	}

	public void addContact(Contact contact) {
		// get a connection
				Connection cnt = connection.getConnection();
				
				//create query
				String query = "INSERT INTO " + Contact.TABLE + " VALUES (?, ?, ?, ?, ?)";
				
				//created a prepared statement
				try {
				PreparedStatement ps = cnt.prepareStatement(query);
				
				//prepare the values
				ps.setInt(1,Types.NULL);
				ps.setString(2, contact.getName());
				ps.setString(3, contact.getEmail());
				ps.setString(4,contact.getMobile());
				ps.setString(5,contact.getGroup());
				
				//execute the update
				ps.executeUpdate();
				
				//close resources
				ps.close();
				cnt.close();
				System.out.println("[CONTACTS] INSERT SUCCESS");
				}
				catch(SQLException e){
				System.out.println("[CONTACTS] INSERT FAILED");
				e.printStackTrace();
				}
		
	}

	public void updateContact(Contact contact) {
		// get a connection
		Connection cnt = connection.getConnection();
		
		//create query
		String query = "UPDATE " + Contact.TABLE + " SET " + 
	    Contact.COL_NAME + " =?," +
	    Contact.COL_MOBILE + " =?," +
	    Contact.COL_EMAIL + " =?," +
	    Contact.COL_GROUP + " =?" +
	    " WHERE " + Contact.COL_ID + " =?";
		
		//created a prepared statement
		try {
		PreparedStatement ps = cnt.prepareStatement(query);
		
		//prepare the values
		ps.setInt(5,contact.getId());
		ps.setString(1, contact.getName());
		ps.setString(2, contact.getEmail());
		ps.setString(3,contact.getMobile());
		ps.setString(4,contact.getGroup());
		
		//execute the update
		ps.executeUpdate();
		
		//close resources
		ps.close();
		cnt.close();
		System.out.println("[CONTACTS] UPDATE SUCCESS");
		}
		catch(SQLException e){
		System.out.println("[CONTACTS] UPDATE FAILED");
		e.printStackTrace();
		}

		
	}

	public List<Contact> getAllByGroup(String group) {
		// TODO Auto-generated method stub
		return null;
	}

}
