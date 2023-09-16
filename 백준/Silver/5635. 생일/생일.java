import java.io.*;
import java.util.*;

public class Main {
    
    static class Person implements Comparable<Person> {
        String name;
        int year, month, day;
        
        public Person(String name, int year, int month, int day) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }
        
        public int compareTo(Person p) {
            int r = Integer.compare(this.year, p.year);
            if(r == 0) r = Integer.compare(this.month, p.month);
            if(r == 0) r = Integer.compare(this.day, p.day);
            return r;
        }
    }
    
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
       int N = Integer.parseInt(br.readLine());
       Person[] persons = new Person[N];
       
       for(int i=0; i<N; i++) {
           String[] person = br.readLine().split(" ");
           int year = Integer.parseInt(person[3]);
           int month = Integer.parseInt(person[2]);
           int day = Integer.parseInt(person[1]);
           persons[i] = new Person(person[0], year, month, day);
        }
       
        Arrays.sort(persons);
        System.out.println(persons[N-1].name);
        System.out.println(persons[0].name);
    }
}