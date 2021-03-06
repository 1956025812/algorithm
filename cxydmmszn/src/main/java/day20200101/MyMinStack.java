package day20200101;

import java.util.Stack;

/**
 * 题目：  设计一个有getMin功能的栈
 * 要求：
 * 1. pop、push、getMin的时间复杂度都是o(1)
 * 2. 设计的栈类型可以使用现成的栈结构
 * <p>
 * 思路：
 * 构造一个临时的栈，用来存放最小的数据。
 * push数据的时候与临时栈的栈顶元素做比较，如果小于或等于，就放到临时栈。注意： 小于和等于都要放。
 * pop数据的时候与临时栈的栈顶元素做比较，如果一样，则同步pop
 */
public class MyMinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> tempStack;

    public MyMinStack() {
        this.dataStack = new Stack<>();
        this.tempStack = new Stack<>();
    }

    /**
     * push方法
     *
     * @param data 新数据
     */
    public void push(Integer data) {
        dataStack.push(data);

        if (tempStack.isEmpty()) {
            tempStack.push(data);
        } else {
            if (data <= tempStack.peek()) {
                tempStack.push(data);
            }
        }
    }


    /**
     * pop方法
     *
     * @return 栈顶元素
     */
    public Integer pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("当前栈dataStata没有数据");
        }

        // 如果要pop的元素正好是最小元素，则要同时一起将临时栈的元素pop
        Integer popData = dataStack.peek();
        if (popData.equals(tempStack.peek())) {
            tempStack.pop();
        }

        return dataStack.pop();
    }


    /**
     * pop方法
     *
     * @return 栈的最小元素
     */
    public Integer getMin() {
        if (tempStack.isEmpty()) {
            throw new RuntimeException("当前栈dataStata没有数据");
        }
        return tempStack.pop();
    }


    public static void main(String[] args) {
        MyMinStack myMinStack = new MyMinStack();
        myMinStack.push(3);
        myMinStack.push(2);
        myMinStack.push(3);
        myMinStack.push(6);
        myMinStack.push(1);
        System.out.println(myMinStack.getMin());
        myMinStack.pop();
        System.out.println(myMinStack.getMin());
    }
}



