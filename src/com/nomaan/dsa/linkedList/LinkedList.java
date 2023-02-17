package com.nomaan.dsa.linkedList;

public class LinkedList<X> {

    private int size;
    private Node<X> head;
    private Node<X> tail;
    private static class Node <X>{
        X val;
        Node<X> next;

        Node(X _val) {
            val = _val;
            next = null;
        }

        @Override
        public String toString() {
            return val.toString();
        }
    }

    public LinkedList() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean add(X val) {
        if (!isEmpty())
            if (head.val.getClass() != val.getClass()) return false;

        Node<X> temp = new Node<>(val);

        if (isEmpty()) head = temp;
        else tail.next = temp;
        tail = temp;
        size++;

        return true;
    }

    // If given position which out of linkedList bound then element will be added to the last
    public boolean add(X val, int pos) {
        if (!isEmpty())
            if (head.val.getClass() != val.getClass()) return false;

        Node<X> ele = new Node<>(val);

        if (isEmpty()) {
            head = ele;
            tail = ele;

            size++;
            return true;
        }

        if (pos == 0) {
            ele.next = head;
            head = ele;
            size++;

            return true;
        }

        {
            Node<X> temp = head;
            while (temp != null && --pos > 0) temp = temp.next;

            if (temp == null) {
                tail.next = ele;
                tail = ele;
                size++;

                return true;
            }

            ele.next = temp.next;
            temp.next = ele;
            size++;

            return true;
        }

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (isEmpty()) {
            sb.append("]");
            return sb.toString();
        }

        Node<X> temp = head;

        while (temp.next != null) {
            sb.append(temp.val).append(",");
            temp = temp.next;
        }

        sb.append(temp.val).append("]");
        return sb.toString();
    }
}
