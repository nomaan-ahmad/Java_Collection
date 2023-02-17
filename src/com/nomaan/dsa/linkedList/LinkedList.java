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

    // Constructor for the LinkedList class
    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // isEmpty will return if the linked List is empty or not
    public boolean isEmpty() {
        return head == null;
    }

    // add method will add the element at the tail of the linkedList
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

        // If list is empty then we have no other choice to add element at starting
        if (isEmpty()) {
            head = ele;
            tail = ele;

            size++;
            return true;
        }

        // if position == 0 then we are trying to add element at the start of linkedList
        if (pos == 0) {
            ele.next = head;
            head = ele;
            size++;

            return true;
        }

        // Traversing to insert at specified position
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


    // size() method will return current size of the list
    public int size() {
        return size;
    }


    // toString method for the Linked List
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
