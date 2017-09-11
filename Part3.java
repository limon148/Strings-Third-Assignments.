
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
    int findStopCodon(String DNA, int startIndex, String stopCodon)
    {
        int endIndex = startIndex;
        while(endIndex != -1)
        {
            endIndex = DNA.indexOf(stopCodon, endIndex + 1);
            if(endIndex != -1 && (endIndex - startIndex) % 3 == 0)
            {
                return endIndex;
            }
        }
        return DNA.length();
    }
    StorageResource getAllGenes(String DNA)
    {
        StorageResource store = new StorageResource();
        String gene = "";
        int count = 1;
        int startIndex = 0;
        int index = -1;
        do
        {
            startIndex = DNA.indexOf("ATG", index + 1);
            if(startIndex == -1)
                break;
            index = findStopCodon(DNA, startIndex, "TAA");
            if(index == DNA.length())
            {
                index = findStopCodon(DNA, startIndex, "TAG");
            }
            if(index == DNA.length())
                break;
            gene = DNA.substring(startIndex, index + 3);
            store.add(gene);
        }while(gene != "");
        return store;
    }
    void testProcessGenes()
    {
        String DNA = "ATGAAACAT";
        StorageResource sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();
        
        DNA = "ATGAGTTAGATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();
        
        DNA = "ATGAGTTAGATGAAACATGATTAAAAAATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        

        DNA = "ATGAGTTAGATGAAACATGATTAAAAAATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        
        
        
        DNA = "ATGAGTTAGATGCCCGCGAAACATGATTAAAAAATGCCCGCGCCCAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        
        
        
        DNA = "ATGAGTTAGATGCCCGCGAAACATGATTAAAAAATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();        
        
        DNA = "ATGAGTTAGATGCCCGCGAAACATGATTAAAAAATGAAACATGATTAA";
        sr = getAllGenes(DNA);
        processGenes(sr);
        sr.clear();
    }
}
