///////////////////////////////////////////////////////////
//                                                       //
//  File name :     SCLL.cpp                             //
//  Description :   Singly Circular Linked List          //
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

class SinglyCLL
{
    private:
        PNODE first;
        PNODE last;
        int iCount;

    public:  
        SinglyCLL()
        {
            this->first = NULL;
            this->last = NULL;
            this->iCount = 0;
        }

        ~SinglyCLL()
        {
            while(iCount != 0)
            {
                DeleteFirst();
            }
        }

        void InsertFirst(int iNo)
        {
            PNODE newn = NULL;

            newn = new NODE;

            newn -> data = iNo;
            newn -> next = NULL;
            
            if(first == NULL && last == NULL)
            {
                first = newn;
                last = newn;

                first -> next = last;
                last -> next = first;
            }
            else
            {
                newn -> next = first;
                last -> next = newn;

                first = newn;
            }

            iCount++;
        }

        void InsertLast(int iNo)
        {
            PNODE newn = NULL;

            newn = new NODE;

            newn -> data = iNo;
            newn -> next = NULL;

            if(first == NULL && last == NULL)
            {
                first = newn;
                last = newn;

                last -> next = first;
            }
            else
            {
                last -> next = newn;
                newn -> next = first;

                last = newn;
            }

            iCount++;
        }

        void InsertAtPos(int iNo, int iPos)
        {
            int i = 0;
            PNODE newn = NULL;
            PNODE temp = NULL;

            if((iPos <= 0) || (iPos > iCount + 1))
            {
                cout<<"Invalid Position.\nPlease Enter Valid Position.\n";
                return;
            }

            if(iPos == 1)
            {
                InsertFirst(iNo);
            }
            else if(iPos == iCount + 1)
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
            if(first == NULL && last == NULL)
            {
                cout<<"List is Empty.\n";
                return;
            }
            else if(first == last)
            {
                delete(first);

                first = NULL;
                last = NULL;
            }
            else
            {
                first = first -> next;

                delete(last -> next);
                last -> next = first;
            }
            iCount--;
        }

        void DeleteLast()
        {
            PNODE temp = NULL;

            if(first == NULL && last == NULL)
            {
                cout<<"List is Empty.\n";
                return;
            }
            else if(first == last)
            {
                delete first;

                first = NULL;
                last = NULL;
            }
            else
            {
                temp = first;

                while(temp -> next != last)
                {
                    temp = temp -> next;
                }

                temp -> next = first;

                delete(last);
                last = temp;
            }

            iCount--;
        }

        void DeleteAtPos(int iPos)
        {
            int i = 0;
            PNODE temp = NULL;
            PNODE target = NULL;

            if((iPos <= 0) || (iPos > iCount))
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

        void Display()
        {
            PNODE temp = NULL;

            if(first == NULL && last == NULL)
            {
                cout<<"Empty Linked List.\n";
                return;
            }
            else
            {
                temp = first;

                do
                {
                    cout<< "| "<< temp -> data << " | -> ";
                    temp = temp -> next;
                } while (temp != last -> next);
                
                cout<<"...\n";
            }
        }

        int Count()
        {
            return iCount;
        }
};

int main()
{
    SinglyCLL sobj;
    
    int iChoice = 0;
    int iValue = 0;
    int iPos = 0;
    int iRet = 0;

    cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";
    cout<<"---------------------------------------------------------Singly Circular Linked List-----------------------------------------------------------\n";
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