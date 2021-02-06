package hashtables;

public class SimpleHashTable {

    private Employee[] hashtable;

    public SimpleHashTable(){
        hashtable = new Employee[10];
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        if(occupied(hashedKey)) {
            int stopIndex = hashedKey;
            //this piece of code handles the first probe
            if(hashedKey == hashtable.length-1)
                hashedKey = 0;
            else {
                hashedKey++;
            }
            while(occupied(hashedKey) && hashedKey != stopIndex){
                //this piece of code handles the continuous wrapping after the first wrap.
                hashedKey = hashedKey + 1 % hashtable.length;
            }
        }
        if (occupied(hashedKey))
            System.out.println("Sorry, there's already an employee at position " + hashedKey);
        else
            hashtable[hashedKey] = employee;
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        return hashtable[hashedKey];
    }

    public void printHashtable(){
        for (Employee employee : hashtable) System.out.println(employee);
    }

    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index){
        return hashtable[index] != null;
    }

}
