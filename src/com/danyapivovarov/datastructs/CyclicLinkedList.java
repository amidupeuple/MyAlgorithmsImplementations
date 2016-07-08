package com.danyapivovarov.datastructs;

import java.util.Random;

/**
 * Created by dpivovar on 06.07.2016.
 */
public class CyclicLinkedList {
    private Node current;

    public void insert(Node node) {
        if (current == null) {
            //empty list case
            current = node;
            current.setNext(node);
        } else {
            Node lastNext = current.getNext();
            current.setNext(node);
            current = node;
            current.setNext(lastNext);
        }
    }

    public String displayList() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("CyclicLinkedList: ");

        if (current != null) {
            Node stopNode = current;
            buffer.append(current.toString() + " ");
            current = current.getNext();
            while (!stopNode.equals(current)) {
                buffer.append(current.toString() + " ");
                current = current.getNext();
            }
        }

        return buffer.toString();
    }

    public Node find(int data) {
        Node result = null;
        if (current == null) {
            return null;
        } else {
            Node stopNode = current;
            if (current.getData().equals(data)) {
                return current;
            }
            current = current.getNext();
            while (!stopNode.equals(current)) {
                if (current.getData().equals(data)) {
                    result = current;
                    break;
                }
                current = current.getNext();
            }
            return result;
        }
    }

    public Node delete() {
        Node result = null;

        if (current == null) {
            return null;
        } else {
            if (current.getNext() == current) {
                //case of one element in list
                result = current;
                current = null;
            } else {
                Node newNext = current.getNext().getNext();
                result = current.getNext();
                current.setNext(newNext);
            }

            return result;
        }
    }

    public boolean isEmpty() {
        return current == null;
    }

    public boolean isOneNode() {
        return current == current.getNext();
    }

    public Node step() {
        current = current.getNext();
        return current;
    }

    public static void main(String[] args) {
        CyclicLinkedList list = new CyclicLinkedList();
        Random random = new Random();

        System.out.println("Before: " + list.displayList());

        for (int i = 0; i < 10; i++) {
            Node<Integer> node = new Node<>(/*random.nextInt(10)*/i);
            list.insert(node);
        }

        System.out.println("After: " + list.displayList());
        System.out.println("Find: " + list.find(0));

        while (!list.isEmpty()) {
            list.delete();
            System.out.println("delete: " + list.displayList());
        }
    }
}
