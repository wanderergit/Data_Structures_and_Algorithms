package stacks.implementation;

public class TwoStack {
    int[] st;
    int top1, top2;

    public TwoStack() {
        st = new int[10];
        top2 = 9;
    }

    public void push1(int ele){
        if(top1 >= top2)
            System.out.println("Full");
        else{
            st[top1] = ele;
            top1++;
        }
    }

    public void push2(int ele){
        if(top1 >= top2)
            System.out.println("Full");
        else{
            st[top2] = ele;
            top2--;
        }
    }

    public void printStacks(){
        System.out.println("Stack 1 : ");
        for(int i=0; i<top1; i++){
            System.out.print(st[i]+", ");
        }
        System.out.println("<- TOP");
        System.out.println("Stack 2 : ");
        System.out.print("TOP ->");
        for(int i=top2+1; i<st.length; i++){
            System.out.print(st[i]+", ");
        }
        System.out.println();

    }
}
