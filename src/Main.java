
import java.util.*;
import java.io.*;

public class Main {

    public static void main (String[] args) throws FileNotFoundException {

        Scanner scan = new Scanner(System.in);
        Scanner file = new Scanner(new File("src/phoneBook.txt"));
        Contacts[] contactInformation =readFromFile(file);

        menu(contactInformation, scan);
    } //end of main

    public static void writeToFile(Contacts[] contacts)throws FileNotFoundException{
        PrintStream out = new PrintStream(new File("src/phoneBook.txt"));
        for (Contacts newContact: contacts)
        {
            out.println(newContact.toString());
        }
    }

    public static Contacts[] readFromFile(Scanner file)throws FileNotFoundException{
        int lineCounter = 0;

        while(file.hasNextLine()) {
            String line = file.nextLine();
            lineCounter++;
        }
        file.close();
        Scanner fileOpen = new Scanner(new File("src/phoneBook.txt"));
        Contacts[] contactInformation = new Contacts[lineCounter];

        int index = 0;
        while(fileOpen.hasNextLine()) {
            String line = fileOpen.nextLine();
            Scanner lineScan = new Scanner(line);

            while(lineScan.hasNext()) {
                String fName = lineScan.next();
                String lName = "";
                while (lineScan.hasNext() && !lineScan.hasNextInt()) {
                    lName += lineScan.next() + " ";
                }
                int pNumber = lineScan.nextInt();
                Contacts newContact = new Contacts(fName, lName, pNumber);
                contactInformation[index] = newContact;
            }
            index++;
        }
       return contactInformation;
    }//end of readFromFile

    public static void menu(Contacts[] allContacts, Scanner scan)throws FileNotFoundException{
        System.out.println("Yo homs, are u ready to get bawlin. \nYoure following options is\n" +
                "1: View contacts\n" +
                "2: Add a contact\n" +
                "3: Edit contacts \n" +
                "4: Delete contacts \n" +
                "5: Shut down");
        int nav = scan.nextInt();
        switch (nav) {
            case 1:
            //View contacts
                showList(allContacts);
            break;

            case 2:
            //add a contact
                addContact(scan, allContacts);


            break;

            case 3:
                //Edit contacs
                break;

            case 4:
                //Delete contacts
                break;

            case 5:
                // Shut down
                System.exit(nav);
                break;

            default:
                break;
        }

    }// end of menu

    public static void showList(Contacts[] arrayContacts) {
        for(Contacts tempContacts:arrayContacts) {
            tempContacts.toPrint();
        }
    }

    public static Contacts[] addContact(Scanner scan, Contacts[]arrayContacts)throws FileNotFoundException{
        //first name
        System.out.println("Hey, lets add a new contact");
        System.out.println("What is your desired first name: ");
        String fName = scan.next();
        String line = scan.nextLine();
        //last name
        System.out.println("What is your desired last name: ");
        String lName = scan.nextLine();
        //line = scan.nextLine();
        //phonenumber
        System.out.println("What is your desired phone number: ");
        int phoneNumber = scan.nextInt();
        Contacts newContact = new Contacts(fName, lName, phoneNumber);
        Contacts[] newPhoneBook= new Contacts[arrayContacts.length+1];
        for (int i = 0; i < arrayContacts.length; i++) {
            newPhoneBook[i] = arrayContacts[i];
        }
        newPhoneBook[arrayContacts.length] = newContact;
        writeToFile(newPhoneBook);
        return newPhoneBook;
    }
} // end of class
