import edu.duke.FileResource;

import java.util.Collections;
import java.util.HashMap;

public class CodonHashMap {

    private HashMap<String,Integer> codonCount;

    public CodonHashMap()
    {
        codonCount=new HashMap<String,Integer>();
    }

    public void buildCodonMap(String dna,int start)
    {
        codonCount.clear();

        for(int i=start;i<dna.length();i+=3) {
            if (i + 3 <= dna.length()) {
                String codon = dna.substring(i, i + 3);

                if (codonCount.keySet().contains(codon)) {
                    codonCount.put(codon, codonCount.get(codon) + 1);
                } else {
                    codonCount.put(codon, 1);
                }
            }
        }

        for(String w:codonCount.keySet())
            System.out.println(codonCount.get(w)+"\t\t"+w);
    }

    public String getMostCommonCodon() {
        String mostcmncodon="";
        int maxValue=0;
        for (String codon : codonCount.keySet())
        {
            if(codonCount.get(codon)>maxValue){

                maxValue=codonCount.get(codon);

                mostcmncodon=codon;
            }
        }

        return mostcmncodon;
    }

    public void printCodonCounts(int start,int end)
    {
        for(String codon:codonCount.keySet())
        {
            if(codonCount.get(codon)>=start && codonCount.get(codon)<=end)
                System.out.println(codonCount.get(codon)+"\t\t"+codon);
        }
    }

    public void tester()
    {
        FileResource codonfile=new FileResource();

        String dna=codonfile.asString().trim();

         buildCodonMap(dna,0);

       String mostCommon=getMostCommonCodon();
       System.out.println("most occured cocon is "+mostCommon);

        printCodonCounts(1,5);

        buildCodonMap(dna,1);

        mostCommon=getMostCommonCodon();
        System.out.println("most occured cocon is "+mostCommon);

        printCodonCounts(1,5);

        buildCodonMap(dna,2);

        mostCommon=getMostCommonCodon();
        System.out.println("most occured cocon is "+mostCommon);

        printCodonCounts(1,5);
    }


    public static void main(String args[])
    {
        CodonHashMap count=new CodonHashMap();

        count.tester();
    }
}
