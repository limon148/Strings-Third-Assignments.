
/**
 * Write a description of class Part1 here.
 *
 * @author (Mehedi Hasan)
 * @version (11-09-2017)
**/
import edu.duke.*;
public class Part3
{
    float cgRatio(String DNA)
    {
        int count = 0;
        for(int i = 0; i != DNA.length(); ++i)
        {
            if(DNA.charAt(i) == 'G' || DNA.charAt(i) == 'C')
                count++;
        }
        return (float)count/DNA.length();
    }
    void processGenes(StorageResource sr)
    {
        int countGreaterThan9Length = 0;
        int countCGRatio = 0;
        String longest = "";
        boolean printed;
        for(String s : sr.data())
        {
            printed = false;
            if(longest.length() < s.length())
                longest = s;
            if(cgRatio(s) > .35)
            {
                countCGRatio++;
                System.out.println(s);
                if(s.length() > 9)
                    printed = true;
            }
            if(s.length() > 9)
            {
                countGreaterThan9Length++;
                if(!printed)
                    System.out.println(s);
            }
        }
        System.out.println("Greater than 9 length strings: " + countGreaterThan9Length);
        System.out.println("Greater than .35 cgRatio: " + countCGRatio);
    }
}
