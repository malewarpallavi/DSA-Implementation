import java.util.Scanner;

class Program14
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("  ", " ");

        System.out.println(str);
    }
}