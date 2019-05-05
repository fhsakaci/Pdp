/**
*
* emine.cetiner@ogr.sakarya.edu.tr
* @author Emine CETINER
* author Mahmut KAYA
* @since 02/05/2019
* <p>
Yuzler Basamagi Fonksiyonu
* </p>
*/
package b141210407_odev4;

/**
 *
 * @author CETINER
 */
public class yuzler implements Runnable{
    private int yuzler_degeri=0;
    private int[] sayiDizisi;
    private int boyut;
    yuzler(int[] sayilar, int counter) {
         this.sayiDizisi=sayilar;
         this.boyut=counter;
    }
    public int yuzler_dondur()
    {
        return yuzler_degeri;
    }
    
    @Override
    public void run() 
    {
        for (int i=0;i<sayiDizisi.length;i++)
        {
            yuzler_degeri+=(sayiDizisi[i]/100)%10;
        }
    }
}
