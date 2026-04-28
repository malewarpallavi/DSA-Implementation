import java.util.Scanner;

class Program17
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+" , " ");

        String tokens[] = str.split(" ");
        System.out.println("Number of words are : " + tokens.length);
    }
}