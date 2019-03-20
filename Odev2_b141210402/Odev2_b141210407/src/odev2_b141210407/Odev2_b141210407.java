/**
*
* emine.cetiner@ogr.sakarya.edu.tr
* @author Emine CETINER
* @since 20/03/2019
* <p>
Rastgele karakter kütüphanesi test yazılımı.
* </p>
*/
package odev2_b141210407;
import RastgeleKarakter.RastgeleKarakter;
/**
 *
 * @author CETINER
 */
public class Odev2_b141210407 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       RastgeleKarakter test=new RastgeleKarakter();
       System.out.println("Tek karakter üret: "+test.GenarateChar());
       System.out.println("100 karakter üret: "+test.GenerateVocabulary(100));
       System.out.println("5 kelimeli cümle üret(her kelime 3 ile 13 arasında rastgele): "+test.GenerateSentence(5));
       System.out.println("a ile h arasında 5 karakterli kelime üret: "+test.GenerateBetween('a','h', 5));
       System.out.println("asdczflu karakterlerinden 10 karakterli kelime üret: "+test.GenarateSelect("asdczflu",10));
    }
    
}
