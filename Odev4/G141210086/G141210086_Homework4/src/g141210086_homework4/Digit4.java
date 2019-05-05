/**
*
* @author Berkan Aydin-Ebru Kara
* @since 04/05/2019
* <p>
Basamak 4
* </p>
*/
package g141210086_homework4;

/**
 *
 * @author Berkan
 */
public class Digit4 implements Runnable {

    private int[] numberArray;
    private int value=0;
    
    Digit4(int[] numberArray)
    {
        this.numberArray=numberArray;
    }
    
    int returnValue()
    {
        return value;
    }
    
    @Override
    public void run() {
        
        for(int i=0;i<numberArray.length;i++)
        {
            value+=(numberArray[i]/1000)%10;
        }
        
    }
}
