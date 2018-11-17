import org.omg.PortableInterceptor.INACTIVE;

import java.io.*;
import java.lang.String;
import java.util.*;
import java.lang.Comparable;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Grades {

    public static void main(String args[]){
        Integer maxscore = -1;
        Integer maxScore = -1, minScore = 101, avg = 0, cnt =0, sum = 0;
        Vector<Student> vector = new Vector<Student>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Салтанат\\IdeaProjects\\untitled26\\src\\scores"));

            String line = br.readLine();

            while (line != null) {
                String[] data  = line.split(" ");
                maxscore = Math.max(maxscore,Integer.parseInt(data[2]));
                maxScore = Math.max(maxScore,Integer.parseInt(data[2]));
                minScore = Math.min(minScore,Integer.parseInt(data[2]));
                cnt++;
                sum += Integer.parseInt(data[2]);
                Student s = new Student(data[0],data[1],data[2]);
                vector.add(s);
                line = br.readLine();
            }
            avg = sum/cnt;
            br.close();
        } catch(FileNotFoundException fe) {
            System.out.println("File not found: ");
        } catch(IOException ioe) {
            System.out.println("Can’t read from file:");
        }
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter("C:\\Users\\Салтанат\\IdeaProjects\\untitled26\\src\\grades"));
            for(int i = 0; i<vector.size(); i++){
                int score = Integer.parseInt(vector.elementAt(i).getScore());
                if(score>=maxscore-10)
                    vector.elementAt(i).setScore("A");
                else if(score>=maxscore-20)
                    vector.elementAt(i).setScore("B");
                else if(score>=maxscore-30)
                    vector.elementAt(i).setScore("C");
                else if(score>=maxscore-40)
                    vector.elementAt(i).setScore("D");
                else
                    vector.elementAt(i).setScore("F");
                br.write(vector.elementAt(i).toString()+"\n");
            }
            br.write("The max is = "+maxScore+"\n");
            br.write("The min is = "+minScore+"\n");
            br.write("The average is = "+avg);
            br.newLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
class Student {
    String name;
    String sname;
    String score;

    public Student(String value1, String value2, String value3) {
        this.name = value1;
        this.sname = value2;
        this.score = value3;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
    public String getSname(){return sname;}
    public void setScore(String score) {this.score = score;}
    public String getScore(){return score;}
    public String toString(){ return name + ' '+ sname +' '+score;}

}
