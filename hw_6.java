import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.Scanner;

public class hw_6 {
    public static void main(String[] args) {
        
        HashMap<String,List<Integer>> phoneBook = new HashMap<>();
        addContact(phoneBook, "Иванов", 123654);
        addContact(phoneBook, "Петров", 784512);
        addContact(phoneBook, "Иванов", 789654);
        addContact(phoneBook, "Сидоров", 563358);
        addContact(phoneBook, "Петров", 785213);
        addContact(phoneBook, "Иванов", 456123);
        addContact(phoneBook, "Сидоров", 963258);
        addContact(phoneBook, "Смирнова", 493257);

        printBook(phoneBook);
    }

    public static void addContact(HashMap<String,List<Integer>> phoneBook, String name, Integer number){
        if(phoneBook.containsKey(name)){
            List<Integer> numbers = phoneBook.get(name);
            numbers.add(number);
            
        }
        else{
            List<Integer> numbers = new ArrayList<>();
            numbers.add(number);
            phoneBook.put(name,numbers);
        }
    }


    public static void printBook(HashMap<String, List<Integer>> phoneBook){
        List<Map.Entry<String,List<Integer>>> nameNumbers = new ArrayList<>(phoneBook.entrySet());

        nameNumbers.sort((e1,e2)-> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        
        for (Map.Entry<String,List<Integer>> item : nameNumbers) {
            String name = item.getKey();
            List<Integer> numbers = item.getValue();
            System.out.printf("Контакт " + name + " имеет следующие " + numbers.size() + " номера: \n");
            
            for(Integer number : numbers){
                System.out.println(number);

            }
            System.out.println();
        }
    }
}

