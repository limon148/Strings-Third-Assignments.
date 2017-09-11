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
    public int countCTG(String dna){
        int x = 0, index = 0;
        while(true){
            index = dna.indexOf("CTG", index + 1);
            if(index == -1){
                break;
            }
            x++;
        }
        return x;
    }
    public void test(){
        String dna = "ATGCCTGATAGCTG";
        NumberFormat formatter = new DecimalFormat("#0.0000");
        System.out.println(formatter.format(cgRatio(dna)));
        System.out.println("The number of the codon CTG appears in dna is " + countCTG(dna));
    }
}
