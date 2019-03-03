/**
*
* @author Furkan Hasan SAKACI
* @since 02/03/2019
* <p>
Regex ve String metotları kullanılarak fonksiyon isimleri, fonksiyon sayısı, operatör sayısı vb. saptanmıştır.
* </p>
*/


package g141210402_homework1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*; 

/**
 *
 * @author SAKACI
 */
public class G141210402_Homework1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        String [] tek = {"+","-", "/", "*", "&",  "=", "<", ">"};
        
        String [] cifttek = {"<=", ">=", "!=", "&&", "||","==","++","--"};
        
        String [] cift = { "+=", "-=", "/=", "*="};
        
        BufferedReader bufferedReader = new BufferedReader(new FileReader("program.c"));
            
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        while((line =bufferedReader.readLine())!=null){

         stringBuffer.append(line).append("\n");
         
        }
        
        String pattern = "(?s)\".*?\"";
        Pattern r = Pattern.compile(pattern);  //Yazilar temizlendi
        Matcher m = r.matcher(stringBuffer);
        while (m.find()) {
            stringBuffer.delete(m.start(), m.end());
            m = r.matcher(stringBuffer);
        }
        
        
        
        pattern = "((?s)/\\*(.)*?\\*/)|([/]+.*)";
        r = Pattern.compile(pattern);  //Yorum satirlari silindi
        m = r.matcher(stringBuffer);
        while (m.find()) {
            stringBuffer.delete(m.start(), m.end());
            m = r.matcher(stringBuffer);
        }
 
        
        int sayac=0;
        int i=0;
        while(cift.length>i)
        {
            while(stringBuffer.indexOf(cift[i])>0)
            {
                //System.out.println(stringBuffer.indexOf(cift[i])+" "+cift[i]);
                stringBuffer.delete(stringBuffer.indexOf(cift[i]),stringBuffer.indexOf(cift[i])+2);
                sayac++;
                sayac++;
            }
            i=i+1;
        }
        
        i=0;
        while(cifttek.length>i)
        {
            while(stringBuffer.indexOf(cifttek[i])>0)
            {
                //System.out.println(stringBuffer.indexOf(cifttek[i])+" "+cifttek[i]);
                stringBuffer.delete(stringBuffer.indexOf(cifttek[i]),stringBuffer.indexOf(cifttek[i])+2);
                sayac++;
            }
            i=i+1;
        }
        
        i=0;
        while(tek.length>i)
        {
            while(stringBuffer.indexOf(tek[i])>0)
            {
                //System.out.println(stringBuffer.indexOf(tek[i])+" "+tek[i]);
                stringBuffer.delete(stringBuffer.indexOf(tek[i]),stringBuffer.indexOf(tek[i])+1);
                sayac++;
            }
            i=i+1;
        }
       
        StringBuffer fonkbul = new StringBuffer();
        int sayac2=0;
        pattern ="([a-zA-Z0-9<>._?,]+) +([a-zA-Z0-9_]+) *\\([a-zA-Z0-9<>\\[\\]._?, \n]*\\) *([a-zA-Z0-9_ ,\n]*) *\\{";
        // "(?s)\\{.*?\\}+";
        r = Pattern.compile(pattern);  //Fonksiyonların adeti saptandı
        m = r.matcher(stringBuffer);
        while (m.find()) {
            fonkbul.append(m.group()).append("\n");
            stringBuffer.delete(m.start(), m.end());
            m = r.matcher(stringBuffer);
            sayac2++;
        }  
 
        StringBuffer parametrebul = new StringBuffer();
        int sayac3=0;
        String gecici,FonkIsimGecici;
        pattern ="\\(([^)]+)\\)";
        
        
        String pattern2 ="([a-zA-Z0-9_]+) *\\(";
        Pattern r2 = Pattern.compile(pattern2);  //Yazilar temizlendi
        Matcher m2 = r2.matcher(fonkbul);
        
        
        
        r = Pattern.compile(pattern);  //Parametreler ve parametrelerin sayısı bulunuyor
        m = r.matcher(fonkbul);
        while (m.find()& m2.find()) {
            FonkIsimGecici=m2.group();
            FonkIsimGecici = FonkIsimGecici.replace(" ", "");
            FonkIsimGecici = FonkIsimGecici.replace("(", "");
            FonkIsimGecici = FonkIsimGecici.replace(")", "");            
            
         
            gecici=m.group();
            gecici = gecici.replace("float", "");
            gecici = gecici.replace("void", "");
            gecici = gecici.replace("int", "");
            gecici = gecici.replace(" ", "");
            gecici = gecici.replace("(", "");
            gecici = gecici.replace(")", "");
            
            
            int gecicisayac=0;
            
            if(gecici.length()>2)
            {
              for(int t=0;t<gecici.length();t++)
              {
                if(gecici.charAt(t)==',')
                {
                    gecicisayac=gecicisayac+1;
                }
              }
              gecicisayac+=1;
              parametrebul.append(FonkIsimGecici).append(": ").append(gecici).append("\n");
            }
            else
            {
                parametrebul.append(FonkIsimGecici).append(": -").append("\n");
            }
            
            sayac3+=gecicisayac;
            
        }  

        System.out.println("Toplam Operatör Sayısı: "+sayac);
        System.out.println("Toplam Fonksiyon Sayısı:"+sayac2);
        System.out.println("Toplam Parametre Sayısı:"+sayac3);
        System.out.println("Fonksiyon ve Parametreler");
        System.out.println(parametrebul);

        
       } 
  } 