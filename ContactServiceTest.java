import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ContactServiceTest {
    private ContactService service;

    @Before
    public void setUp() {
        service = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        assertEquals("John", service.getContact("12345").getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateContact() {
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact1);
        Contact contact2 = new Contact("12345", "Jane", "Doe", "0987654321", "321 Street");
        service.addContact(contact2);
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteNonExistentContact() {
        service.deleteContact("nonexistent");
    }

    @Test
    public void testUpdateContactFirstName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.updateContactFirstName("12345", "Jane");
        assertEquals("Jane", service.getContact("12345").getFirstName());
    }

    @Test
    public void testUpdateContactLastName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.updateContactLastName("12345", "Smith");
        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    @Test
    public void testUpdateContactPhone() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.updateContactPhone("12345", "0987654321");
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    public void testUpdateContactAddress() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        service.addContact(contact);
        service.updateContactAddress("12345", "456 Avenue");
        assertEquals("456 Avenue", service.getContact("12345").getAddress());
    }
}
