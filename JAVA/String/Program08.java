import java.util.Scanner;

class StringX
{
    public static void Trim(String str)
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

        System.out.println("Start is : " + iStart);
        System.out.println("End is : " + iEnd);

        for(i = iStart ; i <= iEnd ; i++)
        {
            System.out.print(Arr[i]);
        }
        System.out.println();
    }
}
class Program08
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        StringX.Trim(str);
    }
}