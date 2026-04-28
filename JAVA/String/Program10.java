import java.util.Scanner;

class StringX
{
    public static String Trim(String str)
    {
        char Arr[] = str.toCharArray();
        int i = 0, iStart = 0, iEnd = 0;

        if(Arr[0] == ' ')
        {
            while(Arr[i] == ' ' && i < Arr.length)
            {
                i++;
            }
        }

        iStart = i;
        
        i = Arr.length - 1;
        if(Arr[Arr.length - 1] == ' ')
        {
            while(Arr[i] == ' ' && i > 0)
            {
                i--;
            }
        }

        iEnd = i;

        char Brr[] = new char[iEnd - iStart + 1];

        int j = 0;

        for(i = iStart, j = 0 ; i <= iEnd ; i++, j++)
        {
            Brr[j] = Arr[i];
        }
        return new String(Brr);
    }
}

class Program10
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        char Arr[] = {'a', 'b', 'c', 'd', 'e', 'f'};

        String s = new String(Arr);

        System.out.println(s);

        s = new String(Arr, 1, 4);
        System.out.println(s);
    }
}