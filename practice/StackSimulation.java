import java.util.ArrayList;
import java.util.List;

enum Status {
    ACTIVE,
    INACTIVE
}

class StackUse<T> {
    List<T> st;
    private int len;
    private int idx = -1;

    StackUse(int len) {
        if (len > 0) {
            this.st = new ArrayList<>(len);
            this.len = len;
        } else {
            System.out.println("Enter Valid number");
        }
    }

    public void push(T num) {
        if (idx + 1 <= len - 1) {
            st.add(++idx, num);
        } else {
            System.out.println("Stack is filled! pop out some elements");
        }

    }

    public void pop() {
        if (idx == -1) {
            System.out.println("We Cannot popup out elements! Stack is Empty");
        } else {
            st.remove(idx--);
        }
    }

    public void logStack() {
        for (int i = 0; i <= idx; i++) {

            System.out.println("ele: " + st.get(i));
        }
    }
}

class StackSimulation {
    public static void main(String args[]) {
        StackUse<Integer> stackList = new StackUse<Integer>(5);
        StackUse<String> stackStringList = new StackUse<String>(4);

        System.out.println("String generics!");
        stackStringList.push("apple");
        stackStringList.push("Mango");
        stackStringList.push(Status.ACTIVE.toString());
        stackStringList.logStack();
        System.out.println();

        System.out.println("Integer generics!");
        stackList.pop();
        stackList.push(5);
        stackList.push(4);
        stackList.push(3);
        stackList.push(5);
        stackList.push(5);
        stackList.push(5);
        stackList.logStack();
        System.out.println();
    }
}
