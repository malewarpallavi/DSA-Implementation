import java.util.Scanner;

class Program10
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

        str = str.trim();

        char Arr[] = str.toCharArray();
        char Brr[] = new char[Arr.length];

        int iCount = 0 , i = 0 , j = 0;
        boolean bFlag = false;

        for(i = 0 ; i < Arr.length ; i++)
        {
            if(Arr[i] != ' ')
            {
                Brr[j] = Arr[i];
                j++;
                bFlag = false;
            }
            else if(Arr[i] = ' ')
            {
                if(bFlag == false)
                {
                    Brr[j] = ' ';
                    j++;
                    bFlag = true;
                }
            }
        } 

        String output = new String(Brr);

        output = output.trim();

        System.out.println("Updated String : " + output);
        System.out.println("Length is : " + output.length()); 
    }
}