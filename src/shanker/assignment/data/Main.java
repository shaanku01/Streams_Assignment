package shanker.assignment.data;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Main {

    public static void ans1(List<Student> students){
        students.stream().map(s->s.getEngDepartment()).distinct().forEach(s->System.out.println(s));

    }
    public static void ans2(List<Student> students){
      students.stream().filter(s->s.getYearOfEnrollment()>2018).forEach(s->System.out.println(s.getName()));
    }

    public static void ans3(List<Student> students){


        students.stream().filter(s->{
            boolean c1 = s.getGender().equalsIgnoreCase("Male");
            boolean c2 = s.getEngDepartment() == "Computer Science";
            boolean result = c1 && c2;
            return result;
        } ).forEach(s->System.out.println("Id: "+s.getId()+" name: "+s.getName()));

    }

    public static void ans4(List<Student> students){
        Map<String , List<Student>> myMap = students.stream()
             .collect(Collectors.groupingBy(s->s.getGender()));
        for (Map.Entry<String, List<Student>> me :
                myMap.entrySet()) {

            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue().size());
        }

    }

    public static void ans5(List<Student> students){

        Map<String , List<Student>> myMap = students.stream()
                .collect(Collectors.groupingBy(s->s.getGender()));
        for (Map.Entry<String, List<Student>> me :myMap.entrySet()) {
            System.out.print(me.getKey() + ":");
          double p =   me.getValue().stream().map(st->st.getAge()).reduce(0,(ans,i)->{return ans+i;} ) / me.getValue().size();
          System.out.println(p);
        }

    }
    public static void ans6(List<Student> students) {
        students.stream().map(s->s.getPerTillDate()).sorted(Comparator.reverseOrder()).limit(1).forEach(s->System.out.println(s));
    }
    public static void ans7(List<Student> students){
        Map<String , List<Student>> myMap = students.stream()
                .collect(Collectors.groupingBy(s->s.getEngDepartment()));
        for (Map.Entry<String, List<Student>> me :
                myMap.entrySet()) {

            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue().size());
        }

    }

    public static void ans8(List<Student> students){
        Map<String , List<Student>> myMap = students.stream()
                .collect(Collectors.groupingBy(s->s.getEngDepartment()));
        for (Map.Entry<String, List<Student>> me :
                myMap.entrySet()) {

            System.out.print(me.getKey() + ":");
            double p =   me.getValue().stream().map(st->st.getPerTillDate()).reduce(0.0,(ans,i)->{return ans+i;} ) / me.getValue().size();
            System.out.println(p);
        }

    }

    public static void ans9(List<Student> students){
        Optional<Student> obj= students.stream()
                .filter(s->s.getEngDepartment()=="Electronic")
                .collect(Collectors.minBy(
                        Comparator.comparingInt(Student::getAge)));

        System.out.println(obj.get().getName());

    }
    public static void ans10(List<Student> students) {
        Map<String, List<Student>> myMap = students.stream()
                .filter(s->s.getEngDepartment()=="Computer Science")
                .collect(Collectors.groupingBy(s -> s.getGender()));
        for (Map.Entry<String, List<Student>> me :
                myMap.entrySet()) {

            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue().size());
        }
    }



    public static void main(String[] args) {

        List<Student> students = new ArrayList<Student>();
        students.add(  new Student(111, "Jiya Brein", 17, "Female", "Computer Science", 2018, 70.8));
        students.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical", 2016, 50.2));
        students.add(new Student(133, "Martin Theron", 17, "Male", "Electronic", 2017, 90.3));
        students.add(new Student(144, "Murali Gowda", 18, "Male", "Electrical", 2018, 80));
        students.add(new Student(155, "Nima Roy", 19, "Female", "Textile", 2016, 70));
        students.add( new Student(166, "Iqbal Hussain", 18, "Male", "Security", 2016, 70));
        students.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical", 2018, 70));
        students.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science", 2015, 80));
        students.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science", 2016, 85));
        students.add( new Student(200, "Jaden Dough", 18, "Male", "Security", 2015, 82));
        students.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic", 2019, 83));
        students.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile", 2016, 60.4));
        students.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science", 2015, 45.6));
        students.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic", 2017, 95.8));
        students.add(new Student(255, "Ali Baig", 17, "Male", "Electronic", 2018, 88.4));
        students.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric", 2019, 72.4));
        students.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science", 2017, 57.5));

        //Main.ans1(students);
        //Main.ans2(students);
        //Main.ans3(students);
       // Main.ans4(students);
        //Main.ans5(students);
        //Main.ans6(students);
        //Main.ans7(students);
        //Main.ans8(students);
        Main.ans9(students);
        //Main.ans10(students);

    }
}
