import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.SortedSet;

public class Main
{
    DoublyLinkedList doubleList;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        Main main = new Main();
        main.doubleList = main.loadPhoneData();
        try
        {
            main.promptSearch();
        }
        catch (IndexOutOfBoundsException Error)
        {
            System.out.println("Invalid search option");
            main.promptSearch();
        }

    }

    void promptSearch() {
        System.out.print("Press H:Head Search, T:Tail Search, Q:Quit");
        char option = scanner.nextLine().toLowerCase().charAt(0);

        while(option != 'q')
        {
            searchForItem(option);
            System.out.print("Press H:Head Search, T:Tail Search, Q:Quit");
            option = scanner.nextLine().toLowerCase().charAt(0);
        }
    }
    void searchForItem(char option) {
        if(option == 'h')
        {
            System.out.println("Performing a Head Search. Please enter a name");
            String searchItem = scanner.nextLine();

            SortedSet sortedSet = doubleList.searchHeadFirst(searchItem);
            if (sortedSet.size() != 0) {
                for (Object node : sortedSet) {
                    System.out.println(((PhonebookData) node).toString());
                }
            }
            else {
                System.out.println("No search results found...");
            }
        }
        else if(option == 't')
        {
            System.out.println("Performing a Tail Search. Please enter a name");
            String searchItem = scanner.nextLine();

            SortedSet sortedSet = doubleList.searchTailFirst(searchItem);
            if (sortedSet.size() != 0) {
                for (Object node : sortedSet) {
                    System.out.println(((PhonebookData) node).toString());
                }
            }
            else {
                System.out.println("No search results found...");
            }
        }
        else
        {
            System.out.println("Invalid search option");
        }
    }

    DoublyLinkedList loadPhoneData() throws IOException {

    DoublyLinkedList list = new DoublyLinkedList();

    BufferedReader reader = new BufferedReader(new FileReader("resources/PhonebookData.csv"));
    while(reader.readLine() != null)
    {
        String[] lineData = reader.readLine().split(",");
        if(lineData.length == 2)
        {
            list.addNode(new PhonebookData(lineData[0] , lineData[1]));
        }
        else
        {
            System.out.println("ERROR LOADING DATA FROM CSV FILE!");
        }
    }

    reader.close();
    return list;
}
}
