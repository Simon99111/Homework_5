/*
Реализуйте структуру телефонной книги с помощью HashMap.
Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами, их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

Пример:
Иванов 1231234
Иванов 3456345
Иванов 5676585
Петров 12345
Петров 82332
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;

public class program_1 {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> phone_book = new HashMap<>();
        Scanner sc = new Scanner(System.in, "cp866");
        int input = 0;
        while (input != 3) {
            System.out.print("Выберите действие:\n 1 - добавить фамилию и номер телефона\n 2 - вывести данные\n 3 - выход\n");
            input = Integer.valueOf(sc.nextLine());
            switch (input) {
                case 1:
                    phone_book = AddRecord(phone_book);
                    break;
                case 2:
                    PrintRecords(phone_book);
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }

    public static Map<String, ArrayList<String>> AddRecord(Map<String, ArrayList<String>> phone_book) {
        Scanner sc = new Scanner(System.in, "cp866");
        System.out.print("Фамилия: ");
        String name = sc.nextLine();
        System.out.print("Номер телефона: ");
        String phone = sc.nextLine();
        if (phone_book.containsKey(name)) {
            phone_book.get(name).add(phone);
        } else {
            phone_book.put(name, new ArrayList<String>());
            phone_book.get(name).add(phone);
        }
        return phone_book;
    }

    public static void PrintRecords(Map<String, ArrayList<String>> phone_book) {
        SortedSet<Map.Entry<String, ArrayList<String>>> sort = new TreeSet<Map.Entry<String, ArrayList<String>>>(
                new Comparator<Entry<String, ArrayList<String>>>() {
                    public int compare(Entry<String, ArrayList<String>> arg0,
                            Entry<String, ArrayList<String>> arg1) {
                        if (arg0.getValue().size() < arg1.getValue().size())
                            return 1;
                        else if (arg0.getValue().size() > arg1.getValue().size())
                            return -1;
                        else
                            return 1;
                    }
                });
        sort.addAll(phone_book.entrySet());
        for (Map.Entry<String, ArrayList<String>> item : sort) {
            System.out.println(item.getKey() + " : " + item.getValue() + "\n");
        }
    }

}