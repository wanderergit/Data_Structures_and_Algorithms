package stacks.implementation;


public class Main {

    public static void main(String[] args) {

        ArrayStack st = new ArrayStack();
        st.push(2);
        st.push(23);
        st.push(123);
        st.push(12);
        st.push(0);
        st.printStack();
        System.out.println("Middle Element : " + st.findMiddle());
        st.deleteMiddle();
        st.printStack();
    }

}
