import java.util.Scanner;

class Program13
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        String newstr = str.replaceAll(" ", "");

        System.out.println("Updated String : " + newstr);
        System.out.println("Length of Updated String : " + newstr.length());
    }
}