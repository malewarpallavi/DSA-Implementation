import java.util.Scanner;

class Program02
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        char Arr[] = str.toCharArray();

        int i = 0 , iCount = 0;
        for(i= 0 ; i < Arr.length ; i++)
        {
            if(Arr[i] == ' ') iCount++;
        }
        System.out.println("Number of white spaces are : " + iCount);
    }
}