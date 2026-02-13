///////////////////////////////////////////////////////////
//                                                       //
//  File name :     DoublyCircularLL.java                //
//  Description :   Doubly Circular Linked List          //
//  Author :        Pallavi Omprakash Malewar            //
//  Date :          07/02/2026                           //
//                                                       //
///////////////////////////////////////////////////////////

import java.util.*;

class Node
{
    public int data;
    public Node next;
    public Node prev;
}

class DoublyCLL 
{
    private Node first;
    private Node last;
    private int iCount;

    public DoublyCLL()
    {
        first = null;
        last = null;
        iCount = 0;
    }

    public void InsertFirst(int iNo)
    {
        Node newn = null;

        newn = new Node();

        newn.data = iNo;
        newn.next = null;
        newn.prev = null; 

        if(first == null)
        {
            first = newn;
            last = newn;

            first.next = first;
            first.prev = first;
        }
        else
        {
            newn.next = first;
            newn.prev = last;

            last.next = newn;
            first.prev = newn;

            first = newn;
        }
        iCount++;
    }

    public void InsertLast(int iNo)
    {
        Node newn = null;
        newn = new Node();

        newn.data = iNo;
        newn.next = null;
        newn.prev = null;

        if(first == null)
        {
            first = newn;
            last = newn;

            first.next = first;
            first.prev = first;
        }
        else
        {
            newn.next = first;
            newn.prev = last;

            first.prev = newn;
            last.next = newn;

            last = newn;
        }
        iCount++;
    }

    public void InsertAtPos(int iNo, int iPos)
    {
        if(iPos < 1 || iPos > iCount+1)
        {
            System.out.println("Invalid Position.");
            return;
        }
        if(iPos == 1)
        {
            InsertFirst(iNo);
        }
        else if(iPos == iCount+1)
        {
            InsertLast(iNo);
        }
        else
        {
            Node temp = null;
            Node newn = null;

            int iCnt = 0;

            newn = new Node();

            newn.data = iNo;
            newn.next = null;
            newn.prev = null;

            temp = first;

            for(iCnt = 1 ; iCnt < iPos - 1 ; iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
            newn.prev = temp;

            temp.next.prev = newn;
            temp.next = newn;

            iCount++;
        }
    }

    public void DeleteFirst()
    {
        if(first == null)
        {
            return;
        }
        else if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {
            first = first.next;

            first.prev = last;
            last.next = first;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        if(first == null)
        {
            return;
        }
        else if(first == last)
        {
            first = null;
            last = null;
        }
        else
        {   
            last = last.prev;

            last.next = first;
            first.prev = last;
        }
        iCount--;
    }

    public void DeleteAtPos(int iPos)
    {
        if(iPos < 1 || iPos > iCount)
        {
            System.out.println("Invalid Position!");
            return;
        }

        if(iPos == 1)
        {
            DeleteFirst(); 
        }
        else if(iPos == iCount)
        {
            DeleteLast();
        }
        else
        {
            Node temp = null;
            Node target = null;
            int iCnt = 0;

            temp = first;

            for(iCnt = 1; iCnt < iPos - 1 ; iCnt++)
            {
                temp = temp.next;
            }
            target = temp.next;
            
            target.next.prev = temp;
            temp.next = target.next;

            target.prev = null;
            target.next = null;
            target = null;
            
            iCount--;
        }
    }

    public void Display()
    {
        if(first == null) return;

        Node temp = null;
        temp = first;

        do
        {
            System.out.print("| " + temp.data + " | <=> ");
            temp = temp.next;
        }
        while(temp != first);

        System.out.println("..Back to first..");
    }

    public int Count()
    {
        return iCount;
    }
    
    public void DeleteAll()
    {
        if(first == null) return;

        first = null;
        last = null;
        iCount = 0;

        System.out.println("Entire LinkedList Deleted.");
    }

}

class DCLL
{
    public static void main(String A[])
    {
        Scanner scobj = new Scanner(System.in);
        DoublyCLL dobj = new DoublyCLL();

        int iRet = 0;
        int iPos = 0;
        int iChoice = 0;
        int iValue = 0;


        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------Doubly Circular Linked List-----------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

        while(true)
        {
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("---------------------------------------------------------Please Select the option--------------------------------------------------------------");
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
           
            System.out.println("1. Insert New Node at first Position.");
            System.out.println("2. Insert New Node at last Position.");
            System.out.println("3. Insert New Node at given Position.");
            System.out.println("4. Delete the Node from first Position.");
            System.out.println("5. Delete the Node from last Position.");
            System.out.println("6. Delete the Node from given Position.");
            System.out.println("7. Display all nodes of Linked List.");
            System.out.println("8. Count Number of Nodes from Linked List.");
            System.out.println("9. Delete Entire Linked List.");
            System.out.println("0. Terminate the Application.");

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");

            iChoice = scobj.nextInt();

            if(iChoice == 1)
            {
                System.out.println("Enter the data you want to insert: ");
                iValue = scobj.nextInt();

                dobj.InsertFirst(iValue);
            }
            else if(iChoice == 2)
            {
                System.out.println("Enter the data you want to insert: ");
                iValue = scobj.nextInt();

                dobj.InsertLast(iValue);
            }
            else if(iChoice == 3)
            {
                System.out.println("Enter the data you want to insert: ");
                iValue = scobj.nextInt();

                System.out.println("Enter the position where you want to enter data: ");
                iPos = scobj.nextInt();

                dobj.InsertAtPos(iValue, iPos);
            }
            else if(iChoice == 4)
            {
                System.out.println("Deleting the First Element from Linked List.");
                dobj.DeleteFirst();
            }
            else if(iChoice == 5)
            {
                System.out.println("Deleting the last Element from Linked List.");
                dobj.DeleteLast();
            }
            else if(iChoice == 6)
            {
                System.out.println("Enter the Position to delete data at that position: ");
                iPos = scobj.nextInt();

                System.out.println("Deleting the node from Position " + iPos);

                dobj.DeleteAtPos(iPos);
            }
            else if(iChoice == 7)
            {
                System.out.println("Elements of the Linked List are : ");
                dobj.Display();
            }
            else if(iChoice == 8)
            {
                iRet = dobj.Count();
                System.out.println("Number of Nodes in the Linked List : " + iRet);
            }
            else if(iChoice == 9)
            {
                dobj.DeleteAll();
            }
            else if(iChoice == 0)
            {
                System.out.println("Thank You for using our Appliaction.");
                break;
            }
            else
            {
                System.out.println("Invalid Choice.");
            }
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        }

        scobj.close();
    }
}