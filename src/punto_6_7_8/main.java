package punto_6_7_8;

import clases.Person;

public class main {
    public static void main(String[] args) {
        DoubleList<Integer> numero = new DoubleList<>();
        numero.append(1234);
        numero.append(5233);
        numero.append(9379857);
        numero.append(82375);
        // To navigate the linked list from the last position
        // numero.printBackwards();

        // Show even-numbered cards
        DoubleList<Person> list = new DoubleList<>();
        list.append(new Person("4862028"));
        list.append(new Person("12345678"));
        for (Person s : list) {
            if (list.CalculatePar(s.getLicense()) != false) {
                // Uncomment to see results
                // System.out.println(s.getLicense());
            }
        }
    }
}
