import java.util.Scanner;

class Program15
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.replaceAll("\\s+" , " ");
        System.out.println(str);
    }
}