import java.util.Scanner;

class Program18
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+" , " ");

        String tokens[] = str.split(" ");

        for(int i = 0 ; i < tokens.length ; i++)
        {
            System.out.println(tokens[i]);
        }
    }
}