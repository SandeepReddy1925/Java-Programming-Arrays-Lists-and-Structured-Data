import edu.duke.FileResource;

public class WordLengths {

    public int[] countWordLengths(FileResource resource,int[] counts)
    {

        for(String s:resource.words())
        {

            int length=s.length();

            if(length>0) {
                if (!(Character.isLetter(s.charAt(length - 1))))
                    length--;

                if (!(Character.isLetter(s.charAt(0))))
                    length--;

                if (length >=30)
                    counts[30] += 1;
                else {
                    if(length>0)
                        counts[length] += 1;
                }
            }

        }
        return counts;
    }

    public int indexOfMax(int[] values) {

        int maxValue = Integer.MIN_VALUE;

        int maxIndex = 0;

        for (int i = 0; i < values.length; i++) {

            if (maxIndex < values[i])
            {
                maxIndex=values[i];
                maxIndex = i;

            }
        }

        return maxIndex;
    }



    public void testCountWordLength()
    {
        FileResource fileResource=new FileResource();
        int[] counts=new int[31];

        int lenCounts[]=countWordLengths(fileResource,counts);

        int maxIndex=+indexOfMax(lenCounts);

        System.out.println("most common word length is "+maxIndex);

    }

    public static void main(String args[])
    {
        WordLengths lengths=new WordLengths();
        lengths.testCountWordLength();
    }

}
