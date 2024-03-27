public class Contacts {

    String firstName;
    String lastName;
    int phoneNumber;

    public Contacts(String fName, String lName, int pNumber ) {
        firstName = fName;
        lastName = lName;
        phoneNumber = pNumber;
    }

    public String toString() {
        return (firstName +" " +lastName +" "+phoneNumber);
    }
    public void toPrint() {
         System.out.println("First name: " + firstName + "\nLast name: " + lastName + "\nPhonenumber: " + phoneNumber);
         System.out.println();
    }
}
