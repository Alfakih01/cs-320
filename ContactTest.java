import static org.junit.Assert.*;
import org.junit.Test;

public class ContactTest {

    @Test
    public void testContactConstruction() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Street");
        assertNotNull(contact);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactIDTooLong() {
        new Contact("12345678901", "John", "Doe", "1234567890", "123 Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactFirstNameTooLong() {
        new Contact("12345", "Johnathan123", "Doe", "1234567890", "123 Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactLastNameTooLong() {
        new Contact("12345", "John", "Doeeeeeeeeee", "1234567890", "123 Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactPhoneNotDigits() {
        new Contact("12345", "John", "Doe", "ABCDEFGHIJ", "123 Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactPhoneWrongLength() {
        new Contact("12345", "John", "Doe", "123456789", "123 Street");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidContactAddressTooLong() {
        new Contact("12345", "John", "Doe", "1234567890", "123 Street North West South East");
    }
}
