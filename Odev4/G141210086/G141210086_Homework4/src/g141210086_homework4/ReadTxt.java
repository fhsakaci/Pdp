/**
*
* @author Berkan Aydin-Ebru Kara
* @since 04/05/2019
* <p>
Dosya okuma
* </p>
*/
package g141210086_homework4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Berkan
 */
public class ReadTxt {
    public int[] Start(String FileName) throws FileNotFoundException, IOException
    {
        int satirAdeti=lineLength(FileName);
        int[] dizi = new int[satirAdeti];
        File file = new File(FileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        for(int i=0;i<satirAdeti;i++)
        {
            line = bufferedReader.readLine();
            dizi[i]=Integer.valueOf(line);
        }
        return dizi;
    }
    
    public int lineLength(String FileName) throws IOException
    {
        int satirAdeti=0;
        File file = new File(FileName);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        while((line = bufferedReader.readLine())!=null)
        {
            satirAdeti++;
        }
        return satirAdeti;
    }
    
    
}
