import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Collections;

public class WordFreqencies {

    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFreqencies()
    {
       myWords=new ArrayList<String>();
       myFreqs=new ArrayList<Integer>();
    }

    public void findUnique()
    {
        myWords.clear();
        myFreqs.clear();

        FileResource fileResource=new FileResource();

        for(String word:fileResource.words())
        {
            word=word.toLowerCase();

            int index=myWords.indexOf(word);

            if(index==-1)
            {
                myWords.add(word);
                myFreqs.add(1);
            }

            else
            {
                int value=myFreqs.get(index);
                myFreqs.set(index,value+1);
            }
        }

        System.out.println("Number of unique words "+myWords.size());

        for (int i=0;i<myWords.size();i++)
            System.out.println(myFreqs.get(i)+"\t\t"+myWords.get(i));
    }

    public void tester()
    {
        findUnique();

        int index=findIndexOfMax();

        if(index!=-1)
            System.out.println("The word that occurs most often and its count is\n "+myWords.get(index)+"\t\t"+myFreqs.get(index));

    }

    public int findIndexOfMax()
    {
      int maxValue=Collections.max(myFreqs);

      int index=myFreqs.indexOf(maxValue);

        return index;

    }

    public static void main(String args[])
    {
        WordFreqencies freqencies=new WordFreqencies();

        freqencies.tester();

    }

}
