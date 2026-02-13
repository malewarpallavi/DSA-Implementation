///////////////////////////////////////////////////////////////////////////
//                                                                       //
//  File name :     MainStack.java                                       //
//  Description :   Implementation of a Stack using LIFO                 //
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

class StackX 
{
    private Node first;
    private int iCount;

    public StackX()
    {
        this.first = null;
        this.iCount = 0;
    }

    // Insert at Top
    public void push(int iNo)
    {
        Node newn = new Node();

        newn.data = iNo;
        newn.next = null;

        newn.next = first;
        first = newn;

        iCount++;
    }

    // Delete from Top
    public int pop()
    {
        Node temp = first;

        if(first.next == null)
        {
            System.out.println("Unable to Pop as Stack is Empty.");
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
        Node temp = null;

        temp = this.first;

        while(temp != null)
        {
            System.out.print("| " + temp.data + " | -> ");
            temp = temp.next;
        }

        System.out.println(" NULL ");
    }

    public int iCount()
    {
        return iCount;
    }

    public void DeleteAll()
    {
        while(first != null)
        {
            first = null;
            iCount = 0;
            System.out.println("Entire Stack is Deleted.");
        }
    }
}

public class MainStack
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);
        StackX stobj = new StackX();

        int iChoice = 0;
        int iValue = 0;
        int iRet = 0;

        do
        {
            System.out.println("\n-----------------------------");
            System.out.println("1 : Push element (Insert At Top)");
            System.out.println("2 : Pop element (Delete From top)");
            System.out.println("3 : Display elements");
            System.out.println("4 : Count elements");
            System.out.println("5 : Delete all elements");
            System.out.println("0 : Exit");
            System.out.println("-----------------------------");
            System.out.print("Enter your choice : ");

            iChoice = sobj.nextInt();

            switch(iChoice)
            {
                case 1:
                    System.out.print("Enter element to push : ");
                    iValue = sobj.nextInt();
                    stobj.push(iValue);
                    break;

                case 2:
                    iRet = stobj.pop();
                    if(iRet != -1)
                    {
                        System.out.println("Popped element : " + iRet);
                    }
                    break;

                case 3:
                    stobj.Display();
                    break;

                case 4:
                    System.out.println("Count is : " + stobj.iCount());
                    break;

                case 5:
                    stobj.DeleteAll();
                    break;

                case 0:
                    stobj.DeleteAll();
                    System.out.println("Thank You for using Our Application.");
                    sobj.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }

        } while(iChoice != 0);

        sobj.close();
    }
}
