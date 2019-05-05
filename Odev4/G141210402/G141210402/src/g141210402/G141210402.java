/**
*
* @author Furkan Hasan SAKACI - Emre UYSAL
* @since 01/05/2019
* <p>
Ana Fonksiyon
* </p>
*/
package g141210402;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author SAKACI
 */
public class G141210402 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("Sayilar.txt");
        FileReader dosyaOku = new FileReader(file);
        BufferedReader satirOku = new BufferedReader(dosyaOku);
        int sayac=0;
        while ((satirOku.readLine()) != null) 
        {
            sayac++;
        }
        String satir;
        int sayiDizisi[] = new int[sayac];
        dosyaOku = new FileReader(file);
        satirOku = new BufferedReader(dosyaOku);
        for(int i=0;i<sayac;i++)
        {
            satir = satirOku.readLine();
            sayiDizisi[i]=Integer.valueOf(satir);
        }
        

        long sureBaslangic = System.nanoTime(); //hesaplama başlıyor
        Hesap seriBasamak1=new Hesap(sayiDizisi,10,1);
        Hesap seriBasamak2=new Hesap(sayiDizisi,10,10);
        Hesap seriBasamak3=new Hesap(sayiDizisi,10,100);
        Hesap seriBasamak4=new Hesap(sayiDizisi,10,1000);
        ExecutorService havuz = Executors.newFixedThreadPool(4);
        havuz.execute(seriBasamak1);
        havuz.execute(seriBasamak2);
        havuz.execute(seriBasamak3);
        havuz.execute(seriBasamak4);
        havuz.shutdown();
        while(!havuz.isTerminated());
        long sureBitis = System.nanoTime();//hesaplama bitiyo
        double sure = (sureBitis-sureBaslangic)/1000000.0;
        System.out.println("Paralel işlem süresi: "+sure+"ms");
        System.out.println("Sonuc: "+String.valueOf(seriBasamak4.Deger_Dondur())+String.valueOf(seriBasamak3.Deger_Dondur())+String.valueOf(seriBasamak2.Deger_Dondur())+String.valueOf(seriBasamak1.Deger_Dondur())); 
    
        sureBaslangic = System.nanoTime(); //hesaplama başlıyor
        Hesap paralelBasamak1=new Hesap(sayiDizisi,10,1);
        Hesap paralelBasamak2=new Hesap(sayiDizisi,10,10);
        Hesap paralelBasamak3=new Hesap(sayiDizisi,10,100);
        Hesap paralelBasamak4=new Hesap(sayiDizisi,10,1000);
        havuz = Executors.newFixedThreadPool(1);
        havuz.execute(paralelBasamak1);
        havuz.execute(paralelBasamak2);
        havuz.execute(paralelBasamak3);
        havuz.execute(paralelBasamak4);
        havuz.shutdown();
        while(!havuz.isTerminated());
        sureBitis = System.nanoTime();//hesaplama bitiyo
        sure = (sureBitis-sureBaslangic)/1000000.0;
        System.out.println("Seri işlem süresi: "+sure+"ms");
        System.out.println("Sonuc: "+String.valueOf(paralelBasamak4.Deger_Dondur())+String.valueOf(paralelBasamak3.Deger_Dondur())+String.valueOf(paralelBasamak2.Deger_Dondur())+String.valueOf(paralelBasamak1.Deger_Dondur())); 
        
        
        
    }
    
}
