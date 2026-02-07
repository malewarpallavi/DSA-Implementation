///////////////////////////////////////////////////////////
//                                                       //
//  File name :     SLLL.cpp                             //
//  Description :   Singly Linear Linked List            //
//  Author :        Pallavi Omprakash Malewar            //
//  Date :          05/09/2025                           //
//                                                       //
///////////////////////////////////////////////////////////

 
#include<iostream>
using namespace std;

struct node
{
    int data;
    struct node *next;
};

typedef struct node NODE;
typedef struct node * PNODE;

class SinglyLLL
{
    private:
        PNODE first;
        int iCount;
    
    public:
        SinglyLLL()
        {
            this->first = NULL;
            this->iCount = 0;
        }

        ~SinglyLLL()
        {
            while(first != NULL)
            {
                DeleteFirst();
            }
        }

        void Display()
        {
            PNODE temp = NULL;

            if(first == NULL)
            {
                cout<<"List is Empty.\n";
                return;
            }

            temp = first;

            while(temp != NULL)
            {
                cout<<"| " << temp->data << " | -> ";
                temp = temp -> next;
            }
            cout<<"NULL\n";
        }

        void InsertFirst(int iNo)
        {
            PNODE newn = NULL;

            newn = new NODE;

            newn -> data = iNo;
            newn -> next = NULL;

            if(first == NULL)
            {
                first = newn;
            }
            else
            {
                newn -> next = first;
                first = newn;
            }
            iCount++;
        }

        void InsertLast(int iNo)
        {
            PNODE newn = NULL;
            PNODE temp = NULL;

            newn = new NODE;

            newn -> data = iNo;
            newn -> next = NULL;

            if(first == NULL)
            {
                first = newn;
            }
            else
            {
                temp = first;

                while(temp -> next != NULL)
                {
                    temp = temp -> next;
                }

                temp -> next = newn;
            }
            iCount++;
        }

        void InsertAtPos(int iNo, int iPos)
        {
            int i = 0;
            PNODE newn = NULL;
            PNODE temp = NULL;

            if((iPos < 1) || (iPos > iCount + 1))
            {
                cout<<"Invalid Input.\nPlease Enter Valid Input.\n";
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
                newn = new NODE;

                newn -> data = iNo;
                newn -> next = NULL;

                temp = first;

                i = 1;
                while(i < (iPos - 1))
                {
                    temp = temp -> next;
                    i++;
                }

                newn -> next = temp -> next;
                temp -> next = newn;

                iCount++;
            }
        }

        void DeleteFirst()
        {
            if(first == NULL)
            {
                cout<<"List is Empty.\n";
                return;
            }
            else if(first -> next == NULL)
            {
                delete first;
                first = NULL;
            }
            else
            {
                PNODE temp = NULL;

                temp = first;

                first = first -> next;
                delete(temp);
                temp = NULL;
            }
            iCount--;
        }

        void DeleteLast()
        {
            PNODE temp = NULL;

            if(first == NULL)
            {
                cout<<"List is Empty.\n";
                return;
            }
            else if(first -> next == NULL)
            {
                delete first;
                first = NULL;
            }
            else
            {
                temp = first;

                while(temp -> next -> next != NULL)
                {
                    temp = temp -> next;
                }
                delete(temp -> next);
                temp -> next = NULL;
            }
            iCount--;
        }

        void DeleteAtPos(int iPos)
        {
            int i = 0;
            PNODE temp = NULL;
            PNODE target = NULL;

            if((iPos < 1) || (iPos > iCount))
            {
                cout<<"Invalid Position.\nPlease Enter Valid Position.\n";
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
                temp = first;

                i = 1;
                while(i < (iPos - 1))
                {
                    temp = temp -> next;
                    i++;
                }
                target = temp -> next;

                temp -> next = target -> next;

                delete(target);

                iCount--;
            }
        }

        int Count()
        {
            return iCount;
        }
};

int main()
{
    SinglyLLL sobj;
    
    int iChoice = 0;
    int iValue = 0;
    int iPos = 0;
    int iRet = 0;

    cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";
    cout<<"---------------------------------------------------------Singly Linear Linked List-------------------------------------------------------------\n";
    cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";

    while(1)
    {
        cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";
        cout<<"---------------------------------------------------------Please Select the option--------------------------------------------------------------\n";
        cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";

        cout<<"1. Insert New Node at first Position.\n";
        cout<<"2. Insert New Node at last Position.\n";
        cout<<"3. Insert New Node at given Position.\n";
        cout<<"4. Delete the Node from first Position.\n";
        cout<<"5. Delete the Node from last Position.\n";
        cout<<"6. Delete the Node from given Position.\n";
        cout<<"7. Display all nodes of Linked List.\n";
        cout<<"8. Count Number of Nodes from Linked List.\n";
        cout<<"0. Terminate the Application.\n";

        cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";

        cin>>iChoice;

        if(iChoice == 1)
        {
            cout<<"Enter the data you want to insert : ";
            cin>>iValue;

            sobj.InsertFirst(iValue);
        }
        else if(iChoice == 2)
        {
            cout<<"Enter the data you want to insert : ";
            cin>>iValue;

            sobj.InsertLast(iValue);
        }
        else if(iChoice == 3)
        {
            cout<<"Enter the data you want to insert : ";
            cin>>iValue;

            cout<<"Enter the Position to insert the data : ";
            cin>>iPos;

            sobj.InsertAtPos(iValue, iPos);
        }
        else if(iChoice == 4)
        {
            cout<<"Deleting the First element from Linked List.\n";

            sobj.DeleteFirst();
        }
        else if(iChoice == 5)
        {
            cout<<"Deleting the Last element from Linked List.\n";

            sobj.DeleteLast();
        }
        else if(iChoice == 6)
        {
            cout<<"Enter the Position from you which you want to delete the node : \n";
            cin>>iPos;

            cout<<"Deleting the node from Position : "<<iPos<<endl;

            sobj.DeleteAtPos(iPos);
        }
        else if(iChoice == 7)
        {
            cout<<"Elements of the Linked List are :\n";
            sobj.Display();
        }
        else if(iChoice == 8)
        {
            iRet = sobj.Count();
            cout<<"Number of Nodes in the Linked List : "<<iRet<<endl;
        }
        else if(iChoice == 0)
        {
            cout<<"Thank You for using our Application.\n";
            break;
        }
        else
        {
            cout<<"Invalid Choice\n";
        }
        cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";
    }

    return 0;
}