package net.apispark.webapi.db;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import net.apispark.webapi.representation.Contact;

public class ContactPersistenceTest {
	
	
	@Before
	public void cleanDB(){
		for(Contact c : ContactPersistence.INSTANCE.getContacts()){
			ContactPersistence.INSTANCE.deleteContact(c.getId());
		}
		Assert.assertEquals(0, ContactPersistence.INSTANCE.getContacts().size());
	}
	
	
	
	@Test
	public void added_contact_is_correct(){
		Contact contact = new Contact(null, "Mélyna", "Boniface", null, "F");
		Contact c = ContactPersistence.INSTANCE.addContact(contact);
		Assert.assertNotNull(c.getId());
	}

	@Test 
	public void added_contact_is_well_retrieved_by_id(){
		Contact contact = new Contact("123", "Mélyna", "Boniface", null, "F");
		ContactPersistence.INSTANCE.addContact(contact);
		Contact c2 = ContactPersistence.INSTANCE.getContact("123");
		Assert.assertEquals("123", c2.getId());
		
		
	}
	
	@Test
	public void testList(){
		Contact c1 = new Contact("123", "Mélyna", "Boniface", null, "F");
		ContactPersistence.INSTANCE.addContact(c1);
		Contact c2 = new Contact("1234", "Léa", "Boniface", null, "F");
		ContactPersistence.INSTANCE.addContact(c2);
		Assert.assertEquals(2, ContactPersistence.INSTANCE.getContacts().size());
		
	}
}
