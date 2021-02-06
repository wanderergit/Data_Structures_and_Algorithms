package stacks;


public class Main {

    public static void main(String[] args) {

        LinkedStack stack = new LinkedStack();
        stack.push(new Employee("jane", "jones", 123));
        stack.push(new Employee("mark", "harris", 342));
        stack.push(new Employee("betty", "Thatcher", 351));
        stack.push(new Employee("sandy", "J", 934));

        stack.printStack();

    }

}
