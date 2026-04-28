import java.util.Scanner;

class Program20
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        str = str.replaceAll("\\s+" , " ");

        String tokens[] = str.split(" ");

        int iMax = 0;
        int MaxIndex = 0;

        for(int i = 0 ; i < tokens.length ; i++)
        {
            if(iMax < tokens[i].length())
            {
                iMax = tokens[i].length();
                MaxIndex = i;
            }
        }
        System.out.println("Largest word is " + tokens[MaxIndex] + " having length " + iMax);
    }
}