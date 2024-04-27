import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (contact == null || contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact already exists or is invalid");
        }
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact does not exist");
        }
        contacts.remove(contactID);
    }

    public void updateContactFirstName(String contactID, String firstName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setFirstName(firstName);
    }

    public void updateContactLastName(String contactID, String lastName) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setLastName(lastName);
    }

    public void updateContactPhone(String contactID, String phone) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setPhone(phone);
    }

    public void updateContactAddress(String contactID, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) throw new IllegalArgumentException("Contact does not exist");
        contact.setAddress(address);
    }
}
