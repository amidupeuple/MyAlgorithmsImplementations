package com.danyapivovarov.exercises;

import com.danyapivovarov.datastructs.CyclicLinkedList;
import com.danyapivovarov.datastructs.Node;

/**
 * Created by dpivovar on 06.07.2016.
 */
public class JosephusFlaviusTask {
    private CyclicLinkedList circle;
    private int numberOfDefenders;
    private int step;
    private int startNumber;
    private boolean isInitial = true;

    public CyclicLinkedList getCircle() {
        return circle;
    }

    public JosephusFlaviusTask(int numberOfDefenders, int step, int startNumber) {
        this.numberOfDefenders = numberOfDefenders;
        this.step = step;
        this.startNumber = startNumber;

        circle = new CyclicLinkedList();
        for (int i = 0; i < numberOfDefenders; i++) {
            Node def = new Node(i+1);
            circle.insert(def);
        }

        circle.find(startNumber);
    }

    public Node getKamikadze() {
        Node kamikadze = null;

        for (int i = 0; i < step-1; i++) {
            circle.step();
        }
        kamikadze = circle.delete();
        return kamikadze;
    }


    public static void main(String[] args) {
        JosephusFlaviusTask task = new JosephusFlaviusTask(7, 3, 1);
        System.out.println("Init circle: " + task.getCircle().displayList());

        while (!task.getCircle().isOneNode()) {
            System.out.println("Kamikadze: " + task.getKamikadze());
        }

        System.out.println("Lucky man: " + task.getCircle().displayList());
    }
}
