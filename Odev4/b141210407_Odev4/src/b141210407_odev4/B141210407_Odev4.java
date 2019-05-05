/**
*
* emine.cetiner@ogr.sakarya.edu.tr
* @author Emine CETINER
* @author Mahmut KAYA
* @since 02/05/2019
* <p>
Main
* </p>
*/
package b141210407_odev4;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 *
 * @author CETINER
 */
public class B141210407_Odev4 {
    
    

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("Sayilar.txt");
        FileReader fileReader = new FileReader(file);
        String line;
        BufferedReader br = new BufferedReader(fileReader);
        int counter=0;
        while ((line = br.readLine()) != null) 
        {
            counter++;
        }

        int sayilar[] = new int[counter];        
        int i=0;
        fileReader = new FileReader(file);
        br = new BufferedReader(fileReader);
        while ((line = br.readLine()) != null) 
        {
            sayilar[i]=Integer.valueOf(line);
            i++;
        }
        br.close();
        
        //////SERI HESAPLAMA//////
        birler Birler=new birler(sayilar,counter);
        onlar Onlar=new onlar(sayilar,counter);
        yuzler Yuzler=new yuzler(sayilar,counter);
        binler Binler=new binler(sayilar,counter);
        
        long baslangic = System.nanoTime(); //hesaplama başlıyor
        ExecutorService havuz = Executors.newFixedThreadPool(1);
        havuz.execute(Birler);
        havuz.execute(Onlar);
        havuz.execute(Yuzler);
        havuz.execute(Binler);
        havuz.shutdown();
        while(!havuz.isTerminated());
        long bitis = System.nanoTime();//hesaplama bitiyo
        System.out.println("Sonuc: "+Binler.binler_dondur()+""+Yuzler.yuzler_dondur()+Onlar.onlar_dondur()+""+Birler.birler_dondur()); 
        double sure = (bitis-baslangic)/1000000.0;
        System.out.println("Seri Hesaplanma Süresi " + String.format("%.2f", sure) + " milisaniye.\n");
        //////SERI HESAPLAMA//////
        
        //////PARALEL HESAPLAMA//////
        birler Birler2=new birler(sayilar,counter);
        onlar Onlar2=new onlar(sayilar,counter);
        yuzler Yuzler2=new yuzler(sayilar,counter);
        binler Binler2=new binler(sayilar,counter);
        
        baslangic = System.nanoTime(); //hesaplama başlıyor
        havuz = Executors.newFixedThreadPool(4);
        havuz.execute(Birler2);
        havuz.execute(Onlar2);
        havuz.execute(Yuzler2);
        havuz.execute(Binler2);
        havuz.shutdown();
        while(!havuz.isTerminated());
        bitis = System.nanoTime();//hesaplama bitiyo
        System.out.println("Sonuc: "+Binler2.binler_dondur()+""+Yuzler2.yuzler_dondur()+Onlar2.onlar_dondur()+""+Birler2.birler_dondur()); 
        sure = (bitis-baslangic)/1000000.0;
        System.out.println("Paralel Hesaplanma Süresi " + String.format("%.2f", sure) + " milisaniye.");
        //////PARALEL HESAPLAMA//////
        }
}
