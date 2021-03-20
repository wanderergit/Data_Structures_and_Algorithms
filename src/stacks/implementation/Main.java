package stacks.implementation;


public class Main {

    public static void main(String[] args) {

        TwoStack st = new TwoStack();
        st.push1(2);
        st.push2(23);
        st.push1(123);
        st.push2(12);
        st.push1(0);
        st.printStacks();
    }

}
