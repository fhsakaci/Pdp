/**
*
* @author Berkan Aydin-Ebru Kara
* @since 04/05/2019
* <p>
Basamak 3
* </p>
*/
package g141210086_homework4;

/**
 *
 * @author Berkan
 */
public class Digit3 implements Runnable {

    private int[] numberArray;
    private int value=0;
    
    Digit3(int[] numberArray)
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
            value+=(numberArray[i]/100)%10;
        }
        
    }
    
}
