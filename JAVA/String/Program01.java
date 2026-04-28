import java.util.Scanner;

class Program01
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        int i = 0 , iCount = 0;
        for(i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(i) == ' ') iCount++;
        }
        System.out.println(iCount);
    }
}