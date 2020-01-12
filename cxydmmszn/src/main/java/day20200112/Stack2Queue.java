package day20200112;

import java.util.Stack;

/**
 * 题目：  由俩个栈组成的队列
 * 要求：  编写一个类，用俩个栈实现队列，支持队列的基本操作(add, peek, poll)
 * <p>
 * 思路：
 * 1. 栈是先进后出，队列是先进先出。由俩个栈正好可以模拟队列。
 * 2. 一个栈做push栈，一个栈做pop栈。
 * 3. 入队操作直接将数据放到push栈。
 * 4. 出队操作，如果push栈内数据不为空，则直接使用push栈的pop/peek操作即可；
 * 5. 出队操作，如果push栈内数据为空，则把push栈的数据 全部 挪到push栈中，然后push栈进行出队。
 * <p>
 **/

public class Stack2Queue {

    private Stack<Integer> pushStack;
    private Stack<Integer> popStack;


    public Stack2Queue() {
        this.pushStack = new Stack<>();
        this.popStack = new Stack<>();
    }


    /**
     * add操作
     *
     * @param data
     */
    public void add(Integer data) {
        pushStack.push(data);
    }


    /**
     * peek操作
     *
     * @return 对头元素
     */
    public Integer peek() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("队列内没有元素");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.peek();
    }


    /**
     * poll操作
     *
     * @return
     */
    public Integer poll() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            throw new RuntimeException("队列内没有元素");
        } else if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }

        return popStack.pop();
    }


    public static void main(String[] args) {
        Stack2Queue stack2Queue = new Stack2Queue();
        stack2Queue.add(1);
        stack2Queue.add(2);
        stack2Queue.add(3);
        stack2Queue.add(4);
        stack2Queue.add(5);
        System.out.println(stack2Queue.peek());
        System.out.println(stack2Queue.poll());
    }


}
