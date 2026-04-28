import java.util.Scanner;

class Program27
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();
        str = str.replaceAll("\\s+", " ");

        String tokens[] = str.split(" ");
        StringBuilder sb =  null;

        for(String s : tokens)
        {
            sb = new StringBuilder(s);
            System.out.println(sb.reverse());
        }
    }
}