/**
*
* emine.cetiner@ogr.sakarya.edu.tr
* @author Emine CETINER
* @since 20/03/2019
* <p>
Rastgele karakter kütüphanesi
* </p>
*/
package RastgeleKarakter;

/**
 *
 * @author CETINER
 */
public class RastgeleKarakter {
    public char GenarateChar() throws InterruptedException
    {
        long RandomNumber=System.nanoTime();
        char RandomChar;
                
        RandomNumber=RandomNumber%50;
        if(RandomNumber<25) RandomChar=(char) (RandomNumber+65);
        else RandomChar=(char) ((RandomNumber-25)+97);
        Thread.sleep(2); 
        return RandomChar;
    }
    
    public String GenerateVocabulary(int count) throws InterruptedException
    {
        String out="";
        for(int i=0;i<count;i++)
        {
            out+=GenarateChar();
            Thread.sleep(2); 
        }
        return out;
    }
    
    public String GenerateSentence(int count) throws InterruptedException
    {
        String out="";
        for(int i=0;i<count;i++)
        {
            out+=GenerateVocabulary((int) (System.nanoTime()%10+3))+" ";
            Thread.sleep(2); 
        }
        return out;
    }
    
    public String GenerateBetween(char start,char end, int count) throws InterruptedException
    {
        String out = "";
        for(int i=0;i<count;i++)
        {
            long RandomNumber=System.nanoTime();
            char RandomChar;
            RandomNumber=RandomNumber%(end-start+1)+start;
            RandomChar=(char)RandomNumber;
            out+=RandomChar;
            Thread.sleep(2);
        }
        return out;
    }
    
    public String GenarateSelect(String Characters, int count) throws InterruptedException
    {
        String out = "";
        char[] charArray=Characters.toCharArray();
        for(int i=0;i<count;i++)
        {
            int RandomNumber=(int) (System.nanoTime()%charArray.length);
            out+=charArray[RandomNumber];
            Thread.sleep(2);
        }
        return out;
    }

    
}
