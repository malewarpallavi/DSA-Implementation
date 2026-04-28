import java.util.Scanner;

class StringX
{
    public static String Replace(String str, char A, char B)
    {
        char Arr[] = str.toCharArray();

        int i = 0;
        for(i = 0 ; i < Arr.length ; i++)
        {
            if(Arr[i] == A)
            {
                Arr[i] = B;
            }
        }
        String newstr = new String(Arr);
        return newstr;
    }
}
class Program06
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        String result = StringX.Replace(str, 'a', 'A');
        System.out.println("Updated String : " + result);
    }
}