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

        return new String(Arr, iStart, iEnd - iStart + 1);
    }
}

class Program11
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        String newstr = StringX.Trim(str);

        System.out.println("Updated String : " + newstr);
        System.out.println("Length of Updated String : " + newstr.length());
    }
}