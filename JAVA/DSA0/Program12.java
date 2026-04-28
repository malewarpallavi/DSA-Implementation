import java.util.Scanner;

class Program12
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");
        String str = sobj.nextLine();

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
            else if(Arr[i] == ' ')
            {
                if(bFlag == false)
                {
                    Brr[j] = ' ';
                    j++;
                    bFlag = true;
                    iCount++;
                }
            }
        } 
        System.out.println("Number of words are : " + (iCount + 1));
    }
}