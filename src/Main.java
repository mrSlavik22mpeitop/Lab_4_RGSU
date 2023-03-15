import javax.swing.*;
import java.io.*;
import java.io.IOException;


class Main
{
    public static void main(String[] args) throws IOException {

       BufferedReader br = null;
       BufferedWriter bw = null;


       try {
           br = new BufferedReader(new InputStreamReader(new FileInputStream("anime_1.txt")));

           bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("anime_2.txt")));

           int lineCount = 0;
           String s;
           int count = 0;
           boolean imsb = false;





           while((s = br.readLine().toLowerCase()) != null)
           {
               String [] word = s.split(" ");
               lineCount +=1;
               count = 0;

               for (String jojo: word )
               {

                     if(imsb)
                     {
                         count +=1;
                         imsb = false;
                     }

                      if ( jojo.charAt(0) == 'a' || jojo.charAt(0) == 'о' || jojo.charAt(0) == 'y' ||
                        jojo.charAt(0) == 'ы' || jojo.charAt(0) == 'э' || jojo.charAt(0) == 'е'
                       || jojo.charAt(0) == 'и' || jojo.charAt(0) == 'ю' || jojo.charAt(0) == 'я')
                   {

                       imsb = true;
                       bw.write(lineCount + ":" + jojo);
                       bw.newLine();

                   }


               }
               bw.write("количество слов в строке " + lineCount + " = " + count);
               bw.newLine();


           }
       }
       catch (IOException e)
       {
        System.out.println("Ошибка!!!!!");
       }
       finally {
           br.close();
           bw.flush();
           bw.close();
       }


    }
}