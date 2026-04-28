import java.util.Scanner;

class Program03
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        char Arr[] = str.toCharArray();

        int i = 0;
        for(i = 0 ; i < Arr.length ; i++)
        {
            if(Arr[i] == ' ') 
            {
                Arr[i] = '_';
            }
        }
        String newstr = new String(Arr);
        System.out.println("Updated String : " + newstr);
    }
}