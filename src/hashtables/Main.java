package hashtables;

public class Main {
    public static void main(String[] args) {
        SimpleHashTable ht = new SimpleHashTable();
        Employee janeJones = new Employee("jane", "jones", 123);
        Employee johnDoe = new Employee("john", "doe", 231);
        Employee marySmith = new Employee("mary", "smith", 332);
        Employee mikeWilson = new Employee("mike", "wilson", 832);
        Employee billEnd = new Employee("bill", "end", 938);
        
        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Smith", marySmith);
        ht.put("Wilson", mikeWilson);
        ht.put("End", billEnd);

        ht.printHashtable();
    }
}
