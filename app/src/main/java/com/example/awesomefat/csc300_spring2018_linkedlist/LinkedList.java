package com.example.awesomefat.csc300_spring2018_linkedlist;

/**
 * Created by awesomefat on 1/30/18.
 */

public class LinkedList
{
    private Node head;

    public LinkedList()
    {
        this.head = null;
    }

    public void addFront(int payload)
    {
        //add to front of list
        Node newHead = new Node(payload);
        newHead.setNextNode(this.head);
        this.head = newHead;
    }

    public void display()
    {
        if(this.head == null)
        {
            System.out.println("Empty List");
        }
        else
        {
            //do stuff here

            while(this.head.getNextNode() != null){
                System.out.println(this.head.getPayload());
                this.head = this.head.getNextNode();
            }
            System.out.println(this.head.getPayload());
        }
    }

}
