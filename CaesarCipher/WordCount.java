import edu.duke.FileResource;

import java.util.ArrayList;

public class WordCount {
    public void count() {
        ArrayList<String> ar = new ArrayList<String>();
        ArrayList<Integer> freq = new ArrayList<Integer>();
        FileResource fr = new FileResource();


        for (String s : fr.words()) {
            s = s.toLowerCase();
            int index=ar.indexOf(s);
            if(index==-1)
                 ar.add(s);
            // freq.add(1);

        }
          /*  else
            {
                int value=freq.get(index);
                freq.set(index,value+1);
            }*/

        System.out.println(ar.size());
       // for (int i = 0; i < ar.size(); i++)
          //  System.out.println(freq.get(i) + "\t" + ar.get(i));
    }

    public static void main(String args[])
    {
        WordCount a=new WordCount();
        a.count();
    }

}
