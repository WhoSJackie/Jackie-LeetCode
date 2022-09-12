package com.wang.Leetcode;

public class MyCircularQueue {
        int head;
        int rear;
        int[] arr;
        int size;
        public MyCircularQueue(int k) {
            arr = new int[k+1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = -1;
            }
            head = 0;
            rear = 0;
            size=k+1;
        }

        public boolean enQueue(int value) {
            // 队列满了
            if (isFull()){
                return false;
            }
            arr[rear] = value;
            rear = (rear+1)%(size);
            return true;
        }

        public boolean deQueue() {
            // 队列空的
            if (isEmpty()){
                return false;
            }
            arr[head] = -1;
            head=(head+1)%(size);
            return true;
        }


        public int Front() {
            return arr[head];
        }

        public int Rear() {
            return arr[(rear+size-1)%size];
        }

        public boolean isEmpty() {
            if (rear==head){
                return true;
            }

            return false;
        }

        public boolean isFull() {
            if ((rear+1)%(size)==head){
                return true;
            }
            return false;
        }

    public static void main(String[] args) {
        MyCircularQueue queue = new MyCircularQueue(6);
        queue.enQueue(6);
        queue.Rear();
        queue.Rear();
        queue.deQueue();
        queue.enQueue(5);
        queue.Rear();
        queue.deQueue();
        System.out.println(queue.Front());

    }


}
