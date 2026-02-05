/////////////////////////////////////////////////////////////////////////////////////////////////////
//                                                                                                 //
//  File name :     SCLL.c                                                                         //
//  Description :   Implementation of a Singly Circular Linked List (SCL) in C.                    //
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

int Count(PNODE first, PNODE last)
{
    int iCount = 0;

    if(first == NULL)
    {
        return iCount;
    }

    do
    {
        iCount++;
        first = first -> next;
    } while(first != last -> next);
    
    return iCount;
}

void InsertFirst(PPNODE first, PPNODE last, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));

    if(newn == NULL)
    {
        printf("Memory Allocation is Failed.\n");
        return;
    }

    newn -> data = iNo;
    newn -> next = NULL;

    if((*first) == NULL && *last == NULL)
    {
        (*first) = newn;
        *last = newn;

        (*last) -> next = (*first);
    }
    else
    {
        newn -> next = (*first);
        (*first) = newn;

        (*last) -> next = *first;
    }
}

void InsertLast(PPNODE first, PPNODE last, int iNo)
{
    PNODE newn = NULL;

    newn = (PNODE)malloc(sizeof(NODE));

    if(newn == NULL)
    {
        printf("Memory Allocation is Failed.\n");
        return;
    }

    newn -> data = iNo;
    newn -> next = NULL;

    if(*first == NULL && *last == NULL)
    {
        *first = newn;
        *last = newn;

        (*last) -> next = (*first);
    }
    else
    {
        (*last) -> next = newn;
        *last = newn;

        (*last) -> next = *first;
    }

}

void InsertAtPos(PPNODE first, PPNODE last, int iNo, int iPos)
{
    int iCount = 0;
    iCount = Count(*first, *last);

    if((iPos <= 0) || (iPos > iCount + 1))
    {
        printf("Invalid Position\nPlease Enter Valid Input.\n");
        return;
    }

    if(iPos == 1)
    {
        InsertFirst(first, last, iNo);
    }
    else if(iPos == iCount+1)
    {
        InsertLast(first, last, iNo);
    }
    else
    {
        PNODE newn = NULL;

        newn = (PNODE)malloc(sizeof(NODE));

        if(newn == NULL)
        {
            printf("Memory Allocation is Failed.\n");
            return;
        }

        newn -> data = iNo;
        newn -> next = NULL;

        PNODE temp = NULL;

        temp = (*first);

        int i = 0;

        for(i = 1 ; i < iPos - 1 ; i++)
        {
            temp = temp -> next;
        }

        newn -> next = temp  -> next;
        temp -> next = newn;
    }

}

void DeleteFirst(PPNODE first, PPNODE last)
{
    if((*first) == NULL && (*last) == NULL)
    {
        printf("Linked List is Empty.\n");
        return;
    }

    else if(*first == *last)
    {
        free(*first);
        (*first) = NULL;
        (*last) = NULL;
    }
    else
    {
        PNODE temp = (*first);
        *first = (*first) -> next;
        free(temp);

        (*last) -> next = *first;
    }
}

void DeleteLast(PPNODE first, PPNODE last)
{
    if(*first == NULL)
    {
        return;
    }
    else if(*first == *last)
    {
        free(*first);
        *first = NULL;
        *last = NULL;
    }
    else
    {
        PNODE temp = NULL;

        temp = (*first);

        while(temp -> next != (*last))
        {
            temp = temp -> next;
        }
        free(temp -> next);
        temp -> next = (*first);
        (*last) = temp;
    }
}

void DeleteAtPos(PPNODE first, PPNODE last, int iPos)
{
    int iCount = 0, i = 0;

    iCount = Count(*first, *last);

    if((iPos <= 0) || (iPos > iCount))
    {
        printf("Invalid Position.\n");
        return;
    }

    if(iPos == 1)
    {
        DeleteFirst(first, last);
    }
    else if(iPos == iCount)
    {
        DeleteLast(first, last);
    }
    else
    {
        PNODE temp = NULL;
        PNODE target = NULL;

        temp = (*first);

        for(i = 1 ; i < iPos -1; i++)
        {
            temp = temp -> next;
        }
        target = temp -> next;

        temp -> next = target -> next;
        free(target);   
    }
}

void Display(PNODE first, PNODE last)
{
    if(first == NULL)
    {
        printf("List is Empty.\n");
        return;
    }

    PNODE temp = first;

    do
    {
        printf("| %d | -> ",temp -> data);
        temp = temp -> next;
    } while (temp != first);
    printf("\n");    
}

void DeleteAll(PPNODE first, PPNODE last)
{
    if(*first == NULL)
    {
        return;
    }    

    PNODE start = *first;
    PNODE temp = *first;

    PNODE nextNode = NULL;

    do
    {
        nextNode = temp -> next;
        free(temp);
        temp = nextNode;
    } while (temp != start);
    
    (*first) = NULL;
    (*last) = NULL;
}

int main()
{
    PNODE head = NULL;
    PNODE tail = NULL;

    int iChoice = 0;
    int iValue = 0;
    int iPos = 0;
    int iRet = 0;

    printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");
    printf("---------------------------------------------------------Singly Circular Linked List-------------------------------------------------------------\n");
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
        printf("9. Delete the Entire Linked List.\n");
        printf("0. Terminate the Application.\n");

        printf("-----------------------------------------------------------------------------------------------------------------------------------------------\n");

        scanf("%d", &iChoice);

        if(iChoice == 1)
        {
            printf("Enter the data you want to insert : ");
            scanf("%d",&iValue);

            InsertFirst(&head, &tail, iValue);
        }
        else if(iChoice == 2)
        {
            printf("Enter the data you want to insert : ");
            scanf("%d",&iValue);

            InsertLast(&head, &tail, iValue);
        }
        else if(iChoice == 3)
        {
            printf("Enter the data you want to insert : ");
            scanf("%d", &iValue);

            printf("Enter the Position where you want to enter data : ");
            scanf("%d", &iPos);

            InsertAtPos(&head, &tail, iValue, iPos);
        }
        else if(iChoice == 4)
        {
            printf("Deleting the First element from Linked List.\n");

            DeleteFirst(&head, &tail);
        }
        else if(iChoice == 5)
        {
            printf("Deleting the Last element from Linked List.\n");

            DeleteLast(&head,  &tail);
        }
        else if(iChoice == 6)
        {
            printf("Enter the Position from which you want to delete the node : \n");
            scanf("%d", &iPos);

            printf("Deleting the node from Position : %d\n", iPos);

            DeleteAtPos(&head, &tail, iPos);
        }
        else if(iChoice == 7)
        {
            printf("Elements of the Linked List are :\n");
            Display(head, tail);
        }
        else if(iChoice == 8)
        {
            iRet = Count(head, tail);
            printf("Number of Nodes in the Linked List : %d\n", iRet);
        }
        else if(iChoice == 9)
        {
            DeleteAll(&head, &tail);
            printf("Entire Linked List is Deleted.\n");
        }
        else if(iChoice == 0)
        {
            DeleteAll(&head, &tail);
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