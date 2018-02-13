package com.example.awesomefat.csc300_spring2018_linkedlist;

import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by awesomefat on 1/30/18.
 */

public class LinkedList
{
    private Node head;
    private ViewGroup linkedListContainer;
    private Context theContext;
    private int count;

    public LinkedList(ViewGroup linkedListContainer, Context theContext)
    {
        this.head = null;
        this.linkedListContainer = linkedListContainer;
        this.theContext = theContext;
        this.count = 0;
    }

    public void addAtIndex(int value, int index)
    {
        //this guy should add a new Node to the list with payload = value at the specified
        //index assuming that index is a legal position in the list.
        if(index == 0)
        {
            this.addFront(value);
        }
        else if(index == this.count)
        {
            this.addEnd(value);
        }
        else
        {
            this.count++;
            Node n = new Node(value);
            Node nodeBefore = this.head;
            Node nodeAt;

            for(int i = 0; i < index-1; i++)
            {
                nodeBefore = nodeBefore.getNextNode();
            }
            nodeAt = nodeBefore.getNextNode();
            n.setNextNode(nodeAt);
            nodeBefore.setNextNode(n);
            TextView tv = new TextView(this.theContext);
            tv.setText("" + value);
            tv.setGravity(Gravity.CENTER);
            this.linkedListContainer.addView(tv,index);
        }


    }

    public void removeAtIndex(int index)
    {
        //is the index out of bounds?
        if(index < 0 || index >= this.count)
        {
            System.err.println("Linked List index out of bounds: " + index);
        }
        else if(index == 0)
        {
            try {
                int value =  this.removeFront();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else if(index == this.count-1)
        {
            try {
                int value = this.removeEnd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            this.count--;
            //we have work to do
            Node nodeBefore = head;
            Node nodeToRemove = null;
            Node nodeAfter = null;

            //position nodeBefore to the node before the node we want to remove
            for(int i = 0; i < index-1; i++)
            {
                nodeBefore = nodeBefore.getNextNode();
            }
            nodeToRemove = nodeBefore.getNextNode();
            nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);
            nodeToRemove.setNextNode(null);
            this.linkedListContainer.removeViewAt(index);
        }
    }


    public int removeFront() throws Exception
    {
        //removes the front of the linked list, and updates the interface
        //and ultimately returns the int payload of the node that was removed.
        if(this.head != null)
        {
            Node node2Remove = this.head;
            this.head = this.head.getNextNode();
            node2Remove.setNextNode(null);
            this.linkedListContainer.removeViewAt(0); // removes the view at 0
            this.count--;
            return node2Remove.getPayload();

        }
        else
        {
            Toast.makeText(this.theContext, "List is Empty", Toast.LENGTH_SHORT).show();
            throw new Exception("Empty List");
        }
    }

    public int removeEnd() throws Exception
    {
        //removes the end of the linked list, and updates the interface
        //and ultimately returns the int payload of the node that was removed.
        if(this.head != null)
        {
            this.count--;
            //traverse the list to find the node right before the last node
            Node node2Remove = this.head;
            while(node2Remove.getNextNode() != null)
            {
                node2Remove = node2Remove.getNextNode();
            }
            //we know that node2Remove points to the very last node
            //find the node that points to node2Remove
            if(node2Remove == this.head)
            {
                //we have a one list
                this.head = null;
            }
            else
            {
                Node prevNode = this.head;
                while(prevNode.getNextNode() != node2Remove)
                {
                    prevNode = prevNode.getNextNode();
                }
                //prevNode points to the node right before node2Remove
                prevNode.setNextNode(null);

            }
            this.linkedListContainer.removeViewAt(this.linkedListContainer.getChildCount()-1);
            return node2Remove.getPayload();
        }
        else
        {
            //we have an empty list
            Toast.makeText(this.theContext,"Empty List", Toast.LENGTH_SHORT).show();
            throw new Exception("Empty List");
        }
    }

    public void addFront(int payload)
    {
        this.count++;
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
        this.count++;
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
            System.out.println("Count: " + this.count);
        }
        else
        {
            //do stuff here
            this.head.display();
            System.out.println("");
            System.out.println("Count: " + this.count);
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
