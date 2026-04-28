import java.util.Scanner;

class Program13
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();
        str.replaceAll("  ", " ");

        System.out.println(str);
    }
}