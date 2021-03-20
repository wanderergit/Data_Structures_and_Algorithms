package stacks.implementation;


public class Main {

    public static void main(String[] args) {

        ArrayStack st = new ArrayStack(30);
        st.push(1);
        st.push(34);
        st.push(23);
        st.push(-2);
        st.push(38);
        st.printStack();
        st.pop();
        st.pop();
        st.printStack();
    }

}
