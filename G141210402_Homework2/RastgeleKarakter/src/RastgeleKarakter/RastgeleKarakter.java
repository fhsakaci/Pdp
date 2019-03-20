/**
*
* @author Furkan Hasan SAKACI
* @since 20/03/2019
* <p>
Rastgele karakter kütüphanesi. Burada rastgele istenen sayıda karakter ve kelime üretimi yapılmaktadir.
* </p>
*/
package RastgeleKarakter;
import java.util.Random;
import java.sql.Time;
/**
 *
 * @author SAKACI
 */
public class RastgeleKarakter {
    public String AdetKarakterUret(int adet) throws InterruptedException
    {
        String karakterDizi = "";
        for(int i=0;i<adet;i++)
        {
           long sayi=System.nanoTime();
        char karakter;
        if(System.nanoTime()%2==1)
        {
            sayi=sayi%25+97;
            karakter=(char)sayi;
        }
        else
        {
            sayi=sayi%25+65;
            karakter=(char)sayi;
        }
           karakterDizi+=karakter;
           Thread.sleep(2);
        }
        return karakterDizi;
    }
    
    public String CumleUret(int KelimeAdeti) throws InterruptedException
    {
        String Cumle="";
        for(int i=0;i<KelimeAdeti;i++)
        {
            if(i==0)
                Cumle=Cumle+AdetKarakterUret((int)(System.nanoTime()%20));
            else
                Cumle=Cumle+" "+AdetKarakterUret((int)(System.nanoTime()%20));
            Thread.sleep(2);
        }
        return Cumle;
    }
    
    public String KarakterArasiUret(char bas,char son) throws InterruptedException
    {
        String karakterDizi = "";
        int adet=(int) (System.nanoTime()%20);
        for(int i=0;i<adet;i++)
        {
        long sayi=System.nanoTime();
        char karakter;
        sayi=sayi%(son-bas+1)+bas;
        karakter=(char)sayi;
        karakterDizi+=karakter;
        Thread.sleep(2);
        }
        return karakterDizi;
    }
    public String KaraktereGoreUret(char[] GelenKarakterler) throws InterruptedException
    {
        String karakterDizi = "";
        int adet=(int) (System.nanoTime()%20);
        for(int i=0;i<adet;i++)
        {
            int karakterNo=(int) (System.nanoTime()%GelenKarakterler.length);
            karakterDizi=karakterDizi+GelenKarakterler[karakterNo];
            Thread.sleep(2);
        }
        return karakterDizi;
    }
}
