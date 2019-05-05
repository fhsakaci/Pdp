/**
*
* @author Berkan Aydin-Ebru Kara
* @since 04/05/2019
* <p>
Ana Fonksiyon
* </p>
*/
package g141210086_homework4;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author Berkan
 */
public class G141210086_Homework4 {

       
    
    public static void main(String[] args) throws IOException {
        ReadTxt StartFile=new ReadTxt();
        int[] numbers=null;
        numbers=StartFile.Start("Sayilar.txt");
        
       
        long start,stop;
        ExecutorService pool = Executors.newFixedThreadPool(1);
        start = System.nanoTime();
        Digit1 D1=new Digit1(numbers);
        Digit2 D2=new Digit2(numbers);
        Digit3 D3=new Digit3(numbers);
        Digit4 D4=new Digit4(numbers);
        pool.execute(D1);
        pool.execute(D2);
        pool.execute(D3);
        pool.execute(D4);
        pool.shutdown();
        while(!pool.isTerminated());
        stop = System.nanoTime();
        double seriesTime = (stop-start)/1000000.0;
        System.out.println("Seri hesaplama süresi: "+seriesTime+" ms");
        System.out.println(D4.returnValue()+""+D3.returnValue()+""+D2.returnValue()+""+D1.returnValue());
        
        
        pool = Executors.newFixedThreadPool(4);
        start = System.nanoTime();
        Digit1 Parallel_D1=new Digit1(numbers);
        Digit2 Parallel_D2=new Digit2(numbers);
        Digit3 Parallel_D3=new Digit3(numbers);
        Digit4 Parallel_D4=new Digit4(numbers);
        pool.execute(Parallel_D1);
        pool.execute(Parallel_D2);
        pool.execute(Parallel_D3);
        pool.execute(Parallel_D4);
        pool.shutdown();
        while(!pool.isTerminated());
        stop = System.nanoTime();
        seriesTime = (stop-start)/1000000.0;
        System.out.println("Paralel hesaplama süresi: "+seriesTime+" ms");
        System.out.println(Parallel_D4.returnValue()+""+Parallel_D3.returnValue()+""+Parallel_D2.returnValue()+""+Parallel_D1.returnValue());
        
    }
    
}
