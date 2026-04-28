import java.util.Scanner;

class Program17
{
    public static void main(String A[])
    {
        Scanner sobj = new Scanner(System.in);

        System.out.print("Enter String : ");   
        String str = sobj.nextLine();

        int i = 0;
        int Count[] = {0, 0, 0};

        char Arr[] = str.toCharArray();

        for(i = 0 ; i < Arr.length ; i++)
        {
            if(Arr[i] == 'a' || Arr[i] == 'b' || Arr[i] == 'c')
            {
                Count[Arr[i] - 'a']++;
            }
        }

        System.out.println("Frequency of a : " + Count[0]);
        System.out.println("Frequency of b : " + Count[1]);
        System.out.println("Frequency of c : " + Count[2]);
    }
}