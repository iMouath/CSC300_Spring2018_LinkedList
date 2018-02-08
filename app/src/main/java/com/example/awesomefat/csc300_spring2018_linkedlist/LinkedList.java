package com.example.awesomefat.csc300_spring2018_linkedlist;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by awesomefat on 1/30/18.
 */

public class LinkedList
{
    private Node head;
    private ViewGroup linkedListContainer;
    private Context theContext;

    public LinkedList(ViewGroup linkedListContainer, Context theContext)
    {
        this.head = null;
        this.linkedListContainer = linkedListContainer;
        this.theContext = theContext;
    }

    public int removeFront()
    {
        //removes the front of the linked list, and updates the interface
        //and ultimately returns the int payload of the node that was removed.
        Node nodeToRemove = this.head;
        if(this.head != null)
        {
            this.head = this.head.getNextNode();
        }
        int payload = nodeToRemove.getPayload();
        nodeToRemove.setNextNode(null);
        this.linkedListContainer.removeViewAt(0); // removes the view at 0
        return payload;
    }

    public int removeEnd()
    {
        //removes the end of the linked list, and updates the interface
        //and ultimately returns the int payload of the node that was removed.
        this.linkedListContainer.removeViewAt(this.linkedListContainer.getChildCount()-1);
        if (this.head == null) //nothing to remove
        {
            return -1;
        }
        else {
            if (this.head.getNextNode() == null) { //2 element list remove last
                Node node = this.head;
                this.head = null;
                return node.getPayload();
            } else { // find end and set it to null
                Node current = this.head;
                Node returnedNode = current.getNextNode();
                while (current.getNextNode() != null && returnedNode.getNextNode() != null) {
                    current = current.getNextNode();
                    returnedNode = current.getNextNode();
                }
                current.setNextNode(null);
                return returnedNode.getPayload();
            }
        }
    }

    public void addFront(int payload)
    {
        Node n = new Node(payload);

        //add to front of list
        if(this.head == null)
        {
            this.head = n;
        }
        else
        {
            //not dealing with the empty list
            n.setNextNode(this.head);
            this.head = n;
        }

        //update the interface
        TextView tv = new TextView(this.theContext);
        tv.setText("" + payload);
        tv.setGravity(Gravity.CENTER);
        this.linkedListContainer.addView(tv,0);
    }

    public void addEnd(int payload)
    {
        if(this.head == null)
        {
            this.addFront(payload);
        }
        else
        {
            this.head.addEnd(payload);
            /*
            Node n = new Node(payload);
            Node currNode = this.head;

            while(currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
            //currnode is sitting at the last node
            currNode.setNextNode(n);
            */

            //update the interface
            TextView tv = new TextView(this.theContext);
            tv.setText("" + payload);
            tv.setGravity(Gravity.CENTER);
            this.linkedListContainer.addView(tv);
        }
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
            this.head.display();
            System.out.println("");
            /*
            String answer = "";
            Node currNode = this.head;
            while(currNode != null)
            {
                answer = answer + currNode.getPayload() + " -> ";
                currNode = currNode.getNextNode();
            }
            System.out.println(answer);
            */

        }
    }
}
