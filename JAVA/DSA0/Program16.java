import java.util.Scanner;

class Program16
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+" , " ");

        char Arr[] = str.toCharArray();

        int iCount = 0;

        for(int i = 0 ; i < Arr.length ; i++)
        {
            if(Arr[i] == ' ')
            {
                iCount++;
            }
        }
        System.out.println("Number of words are : " + (iCount + 1));
    }
}