import edu.duke.FileResource;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;

public class CharactersInPlay {

    private ArrayList<String> characters;
    private ArrayList<Integer> count;

    public CharactersInPlay()
    {
        characters=new ArrayList<String>();
        count=new ArrayList<Integer>();
    }

    public void  update(String person)
    {
        int index=characters.indexOf(person);

        if(index==-1)
        {
            characters.add(person);

            count.add(1);
        }
        else
        {
            int value=count.get(index);

            count.set(index,value+1);
        }

    }

    public void findAllCharacters()
    {
        characters.clear();

        count.clear();

        FileResource fileResource=new FileResource();

        for(String line:fileResource.lines())
        {
            int periodIndex=line.indexOf('.');

            if(periodIndex!=-1)
            {
                String person=line.substring(0,periodIndex);

                update(person);
            }
        }
    }
    public void tester()
    {
        findAllCharacters();

      /* for(int i=0;i<count.size();i++)
        {
            if(count.get(i)>20){
                System.out.println("main charater and number of speaking parts "+characters.get(i)+"\t\t\t\t"+count.get(i));

            }
        }*/

        charactersWithNumParts(10,15);
    }

    public void charactersWithNumParts(int num1,int num2)
    {
        for(int i=0;i<characters.size();i++)
        {
            if(count.get(i)>=num1 && count.get(i)<=num2)
                System.out.println("main charater and number of speaking parts "+characters.get(i)+"\t\t\t\t"+count.get(i));

        }
    }

    public static void main(String args[])
    {
        CharactersInPlay characters=new CharactersInPlay();

        characters.tester();
    }

}
