import java.util.*;

class Matrix
{
    public int Arr[][];

    public Matrix(int A, int B)
    {
        Arr = new int[A][B];
    }

    public void Accept()
    {
        System.out.println("Please Enter Elements : ");

        Scanner sobj = new Scanner(System.in);
        int i = 0, j = 0;
        
        for(i = 0 ; i < Arr.length ; i++)
        {
            for(j = 0 ; j < Arr[i].length ; j++)
            {
                Arr[i][j] = sobj.nextInt();
            }
        }
    }

    public void Display()
    {
        System.out.println("Elements of matrix are : ");

        int i = 0 , j = 0;

        for(i = 0 ; i < Arr.length ; i++)
        {
            for(j = 0 ; j < Arr[i].length ; j++)
            {
                System.out.print(Arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public int CountEven()
    {
        int i = 0 , j = 0 , iCount = 0;

        for(i = 0 ; i <  Arr.length ; i++)
        {
            for(j = 0 ; j < Arr[i].length ; j++)
            {
                if(Arr[i][j] % 2 == 0)
                {
                    iCount++;
                }
            }
        }
        return iCount;
    }

    public int Summation()
    {
        int i = 0 , j = 0 , iSum = 0;

        for(i = 0 ; i < Arr.length ; i++)
        {
            for(j = 0 ; j < Arr[i].length ; j++)
            {
                iSum += Arr[i][j];
            }
        }
        return iSum;
    }

    public int Maximum()
    {
        int i = 0 , j = 0 , iMax = Arr[i][j];

        for(i = 0 ; i < Arr.length ; i++)
        {
            for(j = 0 ; j < Arr[i].length ; j++)
            {
                if(iMax < Arr[i][j]) iMax = Arr[i][j];
            }
        }
        return iMax;
    }

    public int Minimum()
    {
        int i = 0, j = 0 , iMin = 0;
        iMin = Arr[i][j];

        for(i = 0 ; i < Arr.length ; i++)
        {
            for(j = 0 ; j < Arr[i].length ; j++)
            {
                if(iMin > Arr[i][j])
                {
                    iMin = Arr[i][j];
                }
            }
        }
        return iMin;
    }

    public float Average()
    {
        int i = 0 , j = 0, iTotal = 0;
        float iAvg = 0.0f;

        for(i = 0 ; i < Arr.length ; i++)
        {
            for(j = 0 ; j < Arr[i].length ; j++)
            {
                iTotal += Arr[i][j];
            }
        }
        return (float)iTotal / (float)(Arr.length * Arr[0].length);
    }
}
class Program35
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter number of Rows : ");
        int iRow = sobj.nextInt();

        System.out.print("Enter number of columns : ");
        int iCol = sobj.nextInt();

        Matrix mobj = new Matrix(iRow, iCol);

        mobj.Accept();
        mobj.Display();

        int iRet = 0, iMax = 0 , iMin = 0;
        float iAvg = 0.0f;

        iRet = mobj.Summation();
        System.out.println("Summation is : " + iRet); 

        iMax = mobj.Maximum();
        System.out.println("Largest Number is : " + iMax);

        iMin = mobj.Minimum();
        System.out.println("Smallest Number is : " + iMin);
        
        iAvg = mobj.Average();
        System.out.println("Average is : " + iAvg);
    }
}