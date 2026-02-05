/////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                 //
//  File name :     SLLL.c                                                                         //
//  Description :   Implementation of a Singly Linear Linked List (SLL) in C.                      //
//  Author :        Pallavi Omprakash Malewar                                                      //
//  Date :          27/10/2025                                                                     //
//                                                                                                 //
/////////////////////////////////////////////////////////////////////////////////////////////////////

#include<stdio.h>
#include<stdlib.h>

struct node
{
    int data;
    struct node *next;
}; 

typedef struct node NODE;
typedef struct node * PNODE;
typedef struct node ** PPNODE;

int Count(PNODE first)
{
    int iCount = 0;

    while(first != NULL)
    {
        first = first -> next;
        iCount++;
    }
    return iCount;
}

void InsertFirst(PPNODE first, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));

    if(newn == NULL)
    {
        printf("Memory Allocation Failed.\n");
        return;
    }

    newn -> data = iNo;
    newn -> next = NULL;

    if((*first) == NULL)
    {
        *first = newn;
    }
    else
    {
        newn -> next = (*first);
        *first = newn;
    }
}

void InsertLast(PPNODE first, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));

    if(newn == NULL)
    {
        printf("Memory Allocation Failed.\n");
        return;
    }

    newn -> data = iNo;
    newn -> next = NULL;

    if(*first == NULL)
    {
        *first = newn;
    }
    else
    {
        PNODE temp = *first;

        while((temp -> next) != NULL)
        {
            temp = temp -> next;
        }

        temp -> next = newn;
    }
}

void InsertAtPos(PPNODE first, int iNo, int iPos)
{
    int iCount = 0;

    iCount = Count(*first);

    if((iPos <= 0) || (iPos > (iCount + 1)))
    {
        printf("Invalid Position\n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(first, iNo);
    }
    else if(iPos == (iCount + 1))
    {
        InsertLast(first, iNo);
    }
    
    else
    {
        PNODE newn = NULL;

        newn = (PNODE)malloc(sizeof(NODE));

        if(newn == NULL)
        {
            printf("Memory Allocation Failed.\n");
            return;
        }

        newn -> data = iNo;
        newn -> next = NULL; 

        PNODE temp = NULL;

        temp = *first;

        int i = 0;

        for(i = 1 ; i < iPos - 1 ; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp -> next;
        temp -> next = newn;
    }
}

void DeleteFirst(PPNODE first)
{
    if(*first == NULL)
    {
        return;
    }
    else
    {
        PNODE temp = NULL;

        temp = (*first) -> next;

        free(*first);
        *first = temp;
    }
}

void DeleteLast(PPNODE first)
{
    if((*first) == NULL)
    {
        return;
    }
    else if((*first) -> next == NULL)
    {
        free(*first);
        (*first) = NULL; 
    }
    else
    {
        PNODE temp = NULL;

        temp = *first;

        while(temp -> next -> next != NULL)
        {
            temp = temp -> next;
        }
        free(temp -> next);
        temp -> next = NULL;
    }
}

void DeleteAtPos(PPNODE first, int iPos)
{
    int iCount = 0;

    iCount = Count(*first);

    if((iPos <= 0) || (iPos > iCount))
    {
        printf("Invalid Input\n");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(first);
    }
    else if(iPos == iCount)
    {
        DeleteLast(first);
    }
    else
    {
        PNODE temp = NULL;
        PNODE target = NULL;

        temp = (*first);

        for(int i = 1 ; i < iPos - 1 ; i++)
        {
            temp = temp -> next;
        }

        target = temp -> next;
        temp -> next = target -> next;
        free(target);
    }
}

void Display(PNODE first)
{
    while(first != NULL)
    {
        printf("| %d | -> ", first -> data);
        first = first -> next;
    }
    printf("NULL\n");
}

void DeleteAll(PPNODE first)
{
    PNODE temp = NULL;

    while(*first != NULL)
    {
        temp = *first;
        *first = (*first) -> next;
        free(temp);
    }
}

int main()
{
    PNODE head = NULL;

    int iChoice = 0;
    int iValue = 0;
    int iPos = 0;
    int iRet = 0;

    printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("---------------------------------------------------------Singly Linear Linked List-------------------------------------------------------------\n");
    printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");

    while(1)
    {
        printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
        printf("---------------------------------------------------------Please Select the option--------------------------------------------------------------\n");
        printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");

        printf("1. Insert New Node at first Position.\n");
        printf("2. Insert New Node at last Position.\n");
        printf("3. Insert New Node at given Position.\n");
        printf("4. Delete the Node from first Position.\n");
        printf("5. Delete the Node from last Position.\n");
        printf("6. Delete the Node from given Position.\n");
        printf("7. Display all nodes of Linked List.\n");
        printf("8. Count Number of Nodes from Linked List.\n");
        printf("9. Delete Entire Linked List.\n");
        printf("0. Terminate the Application.\n");

        printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");

        scanf("%d", &iChoice);

        if(iChoice == 1)
        {
            printf("Enter the data you want to insert : ");
            scanf("%d",&iValue);

            InsertFirst(&head, iValue);
        }
        else if(iChoice == 2)
        {
            printf("Enter the data you want to insert : ");
            scanf("%d",&iValue);

            InsertLast(&head, iValue);
        }
        else if(iChoice == 3)
        {
            printf("Enter the data you want to insert : ");
            scanf("%d", &iValue);

            printf("Enter the Position where you want to enter data : ");
            scanf("%d", &iPos);

            InsertAtPos(&head, iValue, iPos);
        }
        else if(iChoice == 4)
        {
            printf("Deleting the First element from Linked List.\n");

            DeleteFirst(&head);
        }
        else if(iChoice == 5)
        {
            printf("Deleting the Last element from Linked List.\n");

            DeleteLast(&head);
        }
        else if(iChoice == 6)
        {
            printf("Enter the Position from you which you want to delete the node : \n");
            scanf("%d", &iPos);

            printf("Deleting the node from Position : %d\n", iPos);

            DeleteAtPos(&head, iPos);
        }
        else if(iChoice == 7)
        {
            printf("Elements of the Linked List are :\n");
            Display(head);
        }
        else if(iChoice == 8)
        {
            iRet = Count(head);
            printf("Number of Nodes in the Linked List : %d\n", iRet);
        }
        else if(iChoice == 9)
        {
            DeleteAll(&head);
            printf("Entire Linked List Deleted Successfully.\n");
        }
        else if(iChoice == 0)
        {
            DeleteAll(&head);
            printf("Thank You for using our Application.\n");
            break;
        }
        else
        {
            printf("Invalid Choice\n");
        }
        printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
    }

    return 0;
}