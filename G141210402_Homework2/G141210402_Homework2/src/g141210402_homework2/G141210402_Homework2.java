/**
*
* @author Furkan Hasan SAKACI
* @since 20/03/2019
* <p>
Rastgele karakter kütüphanesinin testi için kullanılmaktadır.
* </p>
*/
package g141210402_homework2;
import RastgeleKarakter.RastgeleKarakter;
/**
 *
 * @author SAKACI
 */
public class G141210402_Homework2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        RastgeleKarakter deneme=new RastgeleKarakter();
        System.out.println("Rastgele "+100+" karakter: "+deneme.AdetKarakterUret(100));
        System.out.println("Rastgele cümle: "+deneme.CumleUret(5));
        System.out.println("a ve h karakterleri arası: "+deneme.KarakterArasiUret('a','h'));
        char[] Dizi={'a','b','f','h','s','c','t'};
        System.out.println("a, b, f, h, t, c ve s karakterlerinden kelime: "+deneme.KaraktereGoreUret(Dizi));
    }
    
}
