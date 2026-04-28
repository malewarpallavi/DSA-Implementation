import java.util.Scanner;

class Program12
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        String newstr = str.trim();

        System.out.println("Updated String : " + newstr);
        System.out.println("Length of Updated String : " + newstr.length());
    }
}