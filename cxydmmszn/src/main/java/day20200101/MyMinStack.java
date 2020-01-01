package day20200101;

import java.util.Stack;

/**
 * 题目：  设计一个有getMin功能的栈
 * 要求：
 * 1. pop、push、getMin的时间复杂度都是o(1)
 * 2. 设计的栈类型可以使用现成的栈结构
 */
public class MyMinStack {

    private Stack<Integer> stackData;
    private Stack<Integer> statckMin;

    public MyMinStack() {
        this.stackData = new Stack<>();
        this.statckMin = new Stack<>();
    }


    public void push(Integer newNum) {
        this.stackData.push(newNum);

        if(this.statckMin.isEmpty()) {
            this.statckMin.push(newNum);
        } else if(newNum <= this.getMin()) {
            this.statckMin.push(newNum);
        }
    }


    public int pop() {
        if(this.stackData.isEmpty()) {
            throw new RuntimeException("yout statck is empty.");
        }

        int value = this.stackData.pop();
        if(value == this.getMin()) {
            this.statckMin.pop();
        }
        return value;
    }


    public int getMin() {
        if(this.statckMin.isEmpty()) {
            throw new RuntimeException("yout stack is empty.");
        }
        return this.statckMin.peek();
    }


    public static void main(String[] args) {

        MyMinStack myMinStack = new MyMinStack();
        myMinStack.push(4);
        myMinStack.push(3);
        myMinStack.push(2);
        myMinStack.push(6);
        System.out.println(myMinStack);

        int minValue = myMinStack.getMin();
        System.out.println(minValue);

    }


}



