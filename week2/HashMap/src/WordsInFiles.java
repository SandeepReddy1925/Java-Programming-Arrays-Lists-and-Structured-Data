import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {

    private HashMap<String, ArrayList<String>>wordFile;

    public WordsInFiles()
    {
        wordFile=new HashMap<String,ArrayList<String>>();
    }

    public void addWordsFromFile(File f)
    {
        FileResource file=new FileResource(f);

        for(String word:file.words())
        {
            if(wordFile.keySet().contains(word))
            {
                ArrayList<String> existoingList=wordFile.get(word);
                if(!existoingList.contains(f.getName()))
                    existoingList.add(f.getName());

            }
            else
            {
                ArrayList<String> newList=new ArrayList<String>();
                newList.add(f.getName());
                wordFile.put(word,newList);
            }
        }
    }

    public void buildWordFileMap()
    {
        wordFile.clear();

        DirectoryResource groupOfFiles=new DirectoryResource();

        for(File file:groupOfFiles.selectedFiles()) {
            addWordsFromFile(file);
        }
    }

    public int maxNumber()
    {
        int max=0;
        for(String word:wordFile.keySet())
        {
            ArrayList<String> list=wordFile.get(word);
            if(list.size()>max)
                max=list.size();
        }

        return max;
    }

    public ArrayList<String> wordsInNumFiles(int number)
    {
        ArrayList<String>words=new ArrayList<String>();
        for(String word:wordFile.keySet())
        {
            ArrayList<String> list=wordFile.get(word);
            if(list.size()==number)
                words.add(word);
        }

        return words;
    }

    public void printFilesIn(String word)
    {
        System.out.println("filenames are");

        ArrayList<String> filenames=wordFile.get(word);

        for(int i=0;i<filenames.size();i++)
        {
            System.out.println(filenames.get(i));
        }
    }

    public void tester()
    {
        buildWordFileMap();

        int maxfilesOfWord=maxNumber();
        System.out.println("the maximum number of files any word is in  "+maxfilesOfWord);

        ArrayList<String> wordsInFile=wordsInNumFiles(2);
        System.out.println("words that appear in exactly number files are ");
        for (int i=0;i<wordsInFile.size();i++)
            System.out.println(wordsInFile.get(i));

        printFilesIn("cats");
    }

    public static void main(String args[])
    {
        WordsInFiles map=new WordsInFiles();

        map.tester();
    }

}
