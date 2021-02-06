package hashtables;

public class SimpleHashTable {

    private StoredEmployee[] hashtable;

    public SimpleHashTable(){
        hashtable = new StoredEmployee[10];
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
            hashtable[hashedKey] = new StoredEmployee(key, employee);
    }

    public Employee get(String key) {
        int hashedKey = findKey(key);
        if(hashedKey == -1)
            return null;
        return hashtable[hashedKey].employee;
    }

    public void printHashtable(){
        for (StoredEmployee employee : hashtable){
            if (employee == null)
                System.out.println("Empty");
            else
                System.out.println(employee.employee);
        }
    }

    private int hashKey(String key){
        return key.length() % hashtable.length;
    }

    private boolean occupied(int index){
        return hashtable[index] != null;
    }

    private int findKey(String key){
        int hashedKey = hashKey(key);
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)){
            return hashedKey;
        }

        int stopIndex = hashedKey;
        //this piece of code handles the first probe
        if (hashedKey == hashtable.length - 1)
            hashedKey = 0;
        else {
            hashedKey++;
        }
        while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
            //this piece of code handles the continuous wrapping after the first wrap.
            hashedKey = hashedKey + 1 % hashtable.length;
        }
        //either we have seen the whole array or found the key
        if (stopIndex == hashedKey)
            return -1;
        else
            return hashedKey;

    }

}
