import java.util.Scanner;

class Program29
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

        StringBuilder newstr = new StringBuilder();

        for(String s : tokens)
        {
            sb = new StringBuilder(s);
            newstr.append(sb.reverse());
            newstr.append(" ");
        }

        String finalstr = new String(newstr);

        System.out.println(finalstr.trim());
    }
}