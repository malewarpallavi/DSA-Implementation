import java.util.Scanner;

class Program07
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        String newstr = str.replaceAll("a", "A");
        System.out.println("Updated String : " + newstr);
    }
}