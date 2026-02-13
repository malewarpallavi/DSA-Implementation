///////////////////////////////////////////////////////////////////////////
//                                                                       //
//  File name :     MainQueue.java                                       //
//  Description :   Implementation of a Queue using FIFO                 //
//  Author :        Pallavi Omprakash Malewar                            //
//  Date :          13/02/2026                                           //
//                                                                       //
///////////////////////////////////////////////////////////////////////////


import java.util.Scanner;

class Node
{
    public int data;
    public Node next;
}

class QueueX 
{
    private Node first;
    private int iCount;

    public QueueX()
    {
        this.first = null;
        this.iCount = 0;
    }

    // Insert at Last
    public void enqueue(int iNo)
    {
        Node temp = null;
        Node newn = new Node();

        newn.data = iNo;
        newn.next = null;

        if(this.first == null)
        {
            first = newn;
        }
        else
        {
            temp = first;

            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }
        iCount++;
    }

    // Delete First
    public int dequeue()
    {
        Node temp = first;

        if(this.first == null)
        {
            System.out.println("Queue is Empty.");
            return -1;
        }
        else
        {
            first = first.next;
            iCount--;

            return temp.data;
        }
    }

    public void Display()
    {
        Node temp = first;
        
        if(first == null)
        {
            System.out.println("Queue is Empty.");
            return;
        }
        else
        {
            do
            {
                System.out.print("| " + temp.data + " | -> ");
                temp = temp.next;
            }while(temp != null);

            System.out.println("NULL");     
        }
    }

    public int Count()
    {
        return iCount;
    }

    public void DeleteAll()
    {
        first = null;
        iCount = 0;
        System.out.print("Entire Queue is Deleted.");
    }
}

public class MainQueue
{
    public static void main(String A[])
    {
        QueueX qobj = new QueueX();
        Scanner sobj = new Scanner(System.in);

        int iChoice = 0;
        int iValue = 0;

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("------------------------------------- Queue -------------------------------------");
        System.out.println("---------------------------------------------------------------------------------");

        while(true)
        {

            System.out.println("---------------------------------------------------------------------------------");
            System.out.println("---------------------------- Please Select the Option ---------------------------");
            System.out.println("---------------------------------------------------------------------------------");

            System.out.println("1. Enqueue (Insert Node at Last).");
            System.out.println("2. Dequeue (Delete Node from First).");
            System.out.println("3. Display All Nodes of Queue.");
            System.out.println("4. Count Number of Nodes in Queue.");
            System.out.println("5. Delete Entire Queue.");
            System.out.println("0. Terminate the Application.");

            System.out.print("Enter your Choice : ");

            if(!sobj.hasNextInt())
            {
                System.out.print("Please Enter a Valid Input : ");
                break;
            }

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1:
                    System.out.print("Enter the data to enqueue : ");
                    int iNo = sobj.nextInt();
                    qobj.enqueue(iNo);
                    break;

                case 2:
                    int removed = qobj.dequeue();
                    if(removed != -1)
                    {
                        System.out.println("Dequeued Element : " + removed);
                    }
                    break;

                case 3:
                    System.out.println("Elements of the queue are :");
                    qobj.Display();
                    break;

                case 4:
                    System.out.println("Total Elements of the Queue : " + qobj.Count());
                    break;

                case 5:
                    qobj.DeleteAll();
                    break;

                case 0:
                    qobj.DeleteAll();
                    System.out.println("Thank You for using Our Application.");
                    sobj.close();
                    System.exit(0);
                    break;

                default:
                    System.out.print("Invalid Choice.\nPlease Enter Valid Input : ");
                    break;
            }
        System.out.println("---------------------------------------------------------------------------------");
        }
    }
}