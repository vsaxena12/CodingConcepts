package stack;

public class Stack <V> {

    private int max;
    private int top;
    private V[] array;

    @SuppressWarnings("unchecked")
    public Stack(int max) {
        this.max = max;
        top = -1;
        array = (V[])new Object[max];
    }

    public int getMax() {
        return max;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == max-1;
    }

    public void push(V element) {
        if(isFull()){
            System.out.println("Stack is full!!");
        }
        array[++top] = element;
    }

    public V pop() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return array[top--];
    }

    public V peek() {
        if(isEmpty())
            System.out.println("Stack is empty");
        return array[top];
    }

    public void display() {
        if(isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for(int i=top; i>=0; i--) {
            System.out.println(array[i]+" ");
        }
    }



    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.display();

    }
}
