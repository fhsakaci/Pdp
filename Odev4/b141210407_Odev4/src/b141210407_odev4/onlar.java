/**
*
* emine.cetiner@ogr.sakarya.edu.tr
* @author Emine CETINER
* author Mahmut KAYA
* @since 02/05/2019
* <p>
Onlar Basamagi Fonksiyonu
* </p>
*/
package b141210407_odev4;

/**
 *
 * @author CETINER
 */
public class onlar implements Runnable{
    private int onlar_degeri=0;
    private int[] sayiDizisi;
    private int boyut;
    onlar(int[] sayilar, int counter) {
         this.sayiDizisi=sayilar;
         this.boyut=counter;
    }
    public int onlar_dondur()
    {
        return onlar_degeri;
    }
    
    @Override
    public void run() 
    {
        for (int i=0;i<sayiDizisi.length;i++)
        {
            onlar_degeri+=(sayiDizisi[i]/10)%10;
        }
    }
}