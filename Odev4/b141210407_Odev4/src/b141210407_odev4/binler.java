/**
*
* emine.cetiner@ogr.sakarya.edu.tr
* @author Emine CETINER
* author Mahmut KAYA
* @since 02/05/2019
* <p>
Binler Basamagi Fonksiyonu
* </p>
*/
package b141210407_odev4;

/**
 *
 * @author CETINER
 */
public class binler implements Runnable{
    private int binler_degeri=0;
    private int[] sayiDizisi;
    private int boyut;
    binler(int[] sayilar, int counter) {
         this.sayiDizisi=sayilar;
         this.boyut=counter;
    }
    public int binler_dondur()
    {
        return binler_degeri;
    }
    
    @Override
    public void run() 
    {
        for (int i=0;i<sayiDizisi.length;i++)
        {
            binler_degeri+=(sayiDizisi[i]/1000)%10;
        }
    }
}
