///////////////////////////////////////////////////////////
//                                                       //
//  File name :     DCLL.cpp                             //
//  Description :   Doubly Circular Linked List          //
//  Author :        Pallavi Omprakash Malewar            //
//  Date :          05/09/2025                           //
//                                                       //
///////////////////////////////////////////////////////////

#include<iostream>
using namespace std;

struct node
{
    int data;
    struct node * next;
    struct node * prev;
};

typedef struct node NODE;
typedef struct node * PNODE;

class DoublyCLL
{
    private:
        PNODE first;
        PNODE last;
        int iCount;

    public:
        DoublyCLL()
        {
            this->first = NULL;
            this->last = NULL;
            this->iCount = 0;
        }

        ~DoublyCLL()
        {
            while(iCount != 0)
            {
                DeleteFirst();
            }
        }

        int Count()
        {
            return iCount;
        }

        void InsertFirst(int iNo)
        {
            PNODE newn = NULL;

            newn = new NODE;

            newn -> prev = NULL;
            newn -> data = iNo;
            newn -> next = NULL;
            
            if(first == NULL)
            {
                first = newn;
                last = newn;
            }
            else
            {
                newn -> next = first;
                first -> prev = newn;

                first = newn;
            }

            last -> next = first;
            first -> prev = last;

            iCount++;
        }

        void InsertLast(int iNo)
        {
            PNODE newn = NULL;

            newn = new NODE;

            newn -> prev = NULL;
            newn -> data = iNo;
            newn -> next = NULL;
            
            if(first == NULL)
            {
                first = newn;
                last = newn;
            }
            else
            {
                last -> next = newn;
                newn -> prev = last;

                last = newn;
            }

            last -> next = first;
            first -> prev = last;

            iCount++;
        }

        void InsertAtPos(int iNo, int iPos)
        {
            if((iPos < 1) || (iPos > iCount + 1))
            {
                cout<<"Invalid Position.\nPlease Enter Valid Input.\n";
                return;
            }

            int i = 0;
            PNODE newn = NULL;
            PNODE temp = NULL;
            
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

                newn -> next = NULL;
                newn -> prev = NULL;
                newn -> data = iNo;

                temp = first;

                i = 1;
                while(i < (iPos - 1))
                {
                    temp = temp -> next;
                    i++;
                }

                newn -> next = temp -> next;
                temp -> next -> prev = newn;

                temp -> next = newn;
                newn -> prev = temp;
                
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
            else if(first == last)
            {
                delete(first);

                first = NULL;
                last = NULL;
            }
            else
            {
                PNODE temp = NULL;

                temp = first;

                first = first -> next;
                last -> next = first;
                first -> prev = last;

                delete(temp);
                temp = NULL;
            }
            iCount--;
        }

        void DeleteLast()
        {
            if(first == NULL)
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
                PNODE temp = NULL;

                temp = last;

                last = last -> prev;

                last -> next = first;
                first -> prev = last;

                delete(temp);
                temp = NULL;
            }
            iCount--;
        }

        void DeleteAtPos(int iPos)
        {
            if((iPos < 1) || (iPos > iCount))
            {
                cout << "Invalid Position.\nPlease Enter valid Position.\n";
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
                int i = 0;
                PNODE temp = NULL;
                PNODE target = NULL;

                temp = first;
                i = 1;
                while(i < (iPos - 1))
                {
                    temp = temp -> next;
                    i++;
                }

                target = temp -> next;

                temp -> next = target -> next;
                target -> next -> prev = temp;

                delete(target);
                target = NULL;

                iCount--;
            }
        }

        void Display()
        {
            PNODE temp = NULL;

            temp = first;

            if(first == NULL)
            {
                cout<<"List is Empty.\n";
                return;
            }

            do
            {
                cout << "| "<< temp->data << " | <=> ";
                temp = temp -> next;
            } while (temp != first);
            cout<<"...\n";
        }

};

int main()
{
    DoublyCLL dobj;
    
    int iChoice = 0;
    int iValue = 0;
    int iPos = 0;
    int iRet = 0;

    cout<<"-----------------------------------------------------------------------------------------------------------------------------------------------\n";
    cout<<"---------------------------------------------------------Doubly Circular Linked List-----------------------------------------------------------\n";
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

            dobj.InsertFirst(iValue);
        }
        else if(iChoice == 2)
        {
            cout<<"Enter the data you want to insert : ";
            cin>>iValue;

            dobj.InsertLast(iValue);
        }
        else if(iChoice == 3)
        {
            cout<<"Enter the data you want to insert : ";
            cin>>iValue;

            cout<<"Enter the Position to insert the data : ";
            cin>>iPos;

            dobj.InsertAtPos(iValue, iPos);
        }
        else if(iChoice == 4)
        {
            cout<<"Deleting the First element from Linked List.\n";

            dobj.DeleteFirst();
        }
        else if(iChoice == 5)
        {
            cout<<"Deleting the Last element from Linked List.\n";

            dobj.DeleteLast();
        }
        else if(iChoice == 6)
        {
            cout<<"Enter the Position from you which you want to delete the node : \n";
            cin>>iPos;

            cout<<"Deleting the node from Position : "<<iPos<<endl;

            dobj.DeleteAtPos(iPos);
        }
        else if(iChoice == 7)
        {
            cout<<"Elements of the Linked List are :\n";
            dobj.Display();
        }
        else if(iChoice == 8)
        {
            iRet = dobj.Count();
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