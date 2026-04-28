import java.util.Scanner;

class StringX
{
    public String Replace(String str, char A, char B)
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
class Program04
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        StringX sxobj = new StringX();

        String result = sxobj.Replace(str, ' ', '_');
        System.out.println("Updated String : " + result);
    }
}