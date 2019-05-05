/**
*
* @author Furkan Hasan SAKACI - Emre UYSAL
* @since 01/05/2019
* <p>
Hesaplama işlemlerinin yapıldığı sınıf
* </p>
*/
package g141210402;

/**
 *
 * @author SAKACI
 */
public class Hesap implements Runnable{
    private int[] sayiDizisi;
    private int mod;
    private int bolum;
    private int deger;
    
    Hesap(int[] sayiDizisi,int mod,int bolum)
    {
        this.sayiDizisi=sayiDizisi;
        this.mod=mod;
        this.bolum=bolum;
    }
    
    int Deger_Dondur()
    {
        return deger;
    }
    
    
    @Override
    public void run() {
        deger=0;
        for(int i=0;i<sayiDizisi.length;i++)
        {
            deger+=(sayiDizisi[i]/bolum)%mod;
        }
    }
    
}
