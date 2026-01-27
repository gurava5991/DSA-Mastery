package StackDataStructures.implementationOfStack;
class StackDS {
    int size;
    int top;
    int[] arr;
    public StackDS(int size , int top ){
        this.size = size;
        this.top = top;
        arr = new int[size];
    }

    public void push(int element) {
        if(top + 1  >= size){
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        arr[top] = element;
    }

    public int pop() {
        if(top == -1)
            return -1;
        int x = arr[top];
        top--;
        return x;
    }

    public int top() {
        if(top == -1)
            return -1;
        return arr[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
public class StackImplementationUsingArray {
    public static void main(String[] args) {
        StackDS st = new StackDS(5,-1);
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60); // Stack Overflow
        System.out.println(st.pop());
        System.out.println(st.top());
        System.out.println(st.size());
        System.out.println(st.isEmpty());

    }
}
/*
Implement a stack using an array
Stack is a linear data structure which works on the principle of LIFO(ListINFirstOut)
Major operation on the stack:
1)push(x)-->Insert an element in the stack.
2)pop()--> Remove and return the topmost element of Stack
3)top() --> returns topmost element of the stack
4)size()--> returns the number of remaining elements in the stack
5)isEmpty()--> returns true if the stack is empty else false.
 */
