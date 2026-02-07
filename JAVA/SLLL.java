///////////////////////////////////////////////////////////
//                                                       //
//  File name :     SLLL.cpp                             //
//  Description :   Singly Linear Linked List            //
//  Author :        Pallavi Omprakash Malewar            //
//  Date :          07/02/2026                           //
//                                                       //
///////////////////////////////////////////////////////////

import java.util.*;

class Node
{
    public int data;
    public Node next;
}

class SinglyLL 
{
    private Node first;
    private int iCount;

    public SinglyLL()
    {
        first = null;
        iCount = 0;
    }

    public void InsertFirst(int iNo)
    {
        Node newn = null;

        newn = new Node();

        newn.data = iNo;
        newn.next = null;

        if(first == null)
        {
            first = newn;
        }
        else
        {
            newn.next = first;
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

        Node temp = null;

        if(first == null)
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

            temp = first;

            for(iCnt = 1 ; iCnt < iPos  -1 ; iCnt++)
            {
                temp = temp.next;
            }
            newn.next = temp.next;
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
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            first = first.next;
        }
        iCount--;
    }

    public void DeleteLast()
    {
        Node temp = null;

        if(first == null)
        {
            return;
        }
        else if(first.next == null)
        {
            first = null;
        }
        else
        {
            temp = first;

            while(temp.next.next != null)
            {
                temp = temp.next;
            }
            temp.next = null;
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
            int iCnt = 0;

            temp = first;

            for(iCnt = 1; iCnt < iPos - 1 ; iCnt++)
            {
                temp = temp.next;
            }

            temp.next = temp.next.next;
            iCount--;
        }
    }

    public void Display()
    {
        Node temp = null;
        temp = first;

        while(temp != null)
        {
            System.out.print("| " + temp.data + " | -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public int Count()
    {
        return iCount;
    }
    
    public void DeleteAll()
    {
        first = null;
        iCount = 0;

        System.out.println("Entire LinkedList Deleted.");
    }

}

class SLLL
{
    public static void main(String A[])
    {
        Scanner scobj = new Scanner(System.in);
        SinglyLL sobj = new SinglyLL();

        int iRet = 0;
        int iPos = 0;
        int iChoice = 0;
        int iValue = 0;


        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------Singly Linear Linked List-------------------------------------------------------------");
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

                sobj.InsertFirst(iValue);
            }
            else if(iChoice == 2)
            {
                System.out.println("Enter the data you want to insert: ");
                iValue = scobj.nextInt();

                sobj.InsertLast(iValue);
            }
            else if(iChoice == 3)
            {
                System.out.println("Enter the data you want to insert: ");
                iValue = scobj.nextInt();

                System.out.println("Enter the position where you want to enter data: ");
                iPos = scobj.nextInt();

                sobj.InsertAtPos(iValue, iPos);
            }
            else if(iChoice == 4)
            {
                System.out.println("Deleting the First Element from Linked List.");
                sobj.DeleteFirst();
            }
            else if(iChoice == 5)
            {
                System.out.println("Deleting the last Element from Linked List.");
                sobj.DeleteLast();
            }
            else if(iChoice == 6)
            {
                System.out.println("Enter the Position to delete data at that position: ");
                iPos = scobj.nextInt();

                System.out.println("Deleting the node from Position " + iPos);

                sobj.DeleteAtPos(iPos);
            }
            else if(iChoice == 7)
            {
                System.out.println("Elements of the Linked List are : ");
                sobj.Display();
            }
            else if(iChoice == 8)
            {
                iRet = sobj.Count();
                System.out.println("Number of Nodes in the Linked List : " + iRet);
            }
            else if(iChoice == 9)
            {
                sobj.DeleteAll();
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