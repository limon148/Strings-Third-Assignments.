/**
 * Write a description of class Part1 here.
 *
 * @author (Mehedi Hasan)
 * @version (11-09-2017)
**/
import java.text.*;

public class Part2
{
    public double cgRatio(String dna){
        int i, c = 0;
        for(i = 0; i < dna.length(); i++){
            if(dna.charAt(i) == 'C' || dna.charAt(i) == 'G'){
                c++;
            }
        }
        return (float)c/dna.length();
    }
    public void test(){
        String dna = "ATGCCATAG";
        NumberFormat formatter = new DecimalFormat("#0.0000");
        System.out.println(formatter.format(cgRatio(dna)));
    }
}
