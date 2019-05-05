/**
*
* emine.cetiner@ogr.sakarya.edu.tr
* @author Emine CETINER
* author Mahmut KAYA
* @since 02/05/2019
* <p>
Birler Basamagi Fonksiyonu
* </p>
*/
package b141210407_odev4;

/**
 *
 * @author CETINER
 */
public class birler implements Runnable{
    private int birler_degeri=0;
    private int[] sayiDizisi;
    private int boyut;
    birler(int[] sayilar, int counter) {
         this.sayiDizisi=sayilar;
         this.boyut=counter;
    }

    public int birler_dondur()
    {
        return birler_degeri;
    }
    
    @Override
    public void run() 
    {
        for (int i=0;i<sayiDizisi.length;i++)
        {
            birler_degeri+=sayiDizisi[i]%10;
            //System.out.println(birler_degeri); 
        }
    }
    
}
