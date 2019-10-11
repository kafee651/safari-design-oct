package command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

class Student {
  public int getGrade() {return 10;}
}

public class SelectingItems {
// V1 YUK!
//  public static void printSmartStudents(List<Student> ls) {
//    for (Student s : ls) {
//      if (s.getGrade() > 20) System.out.println(s);
//    }
//  }
// V2 printing is unrelated
//  public static List<Student> getSmartStudents(List<Student> ls) {
//    List<Student> res = new...
//    for (Student s : ls) {
//      if (s.getGrade() > 20) res.add(s);
//    }
//    return res;
//  }
// V3 parameterize the "threshold" of smartness
//  public static List<Student> getSmartStudents(List<Student> ls) {
//    List<Student> res = new ArrayList<>();
//    for (Student s : ls) {
//      if (s.getGrade() > 20) res.add(s);
//    }
//    return res;
//  }
// V4 parameterize the selection criterion...
// "pass an object as argument" because of the behavior it contains,
// rather than the data part...
// Command pattern
//  public static List<Student> getStudents(
//        List<Student> ls, Predicate<Student> pred) {
//      List<Student> res = new ArrayList<>();
//      for (Student s : ls) {
//        if (pred.test(s)) res.add(s);
//      }
//      return res;
//  }
  public static <E> List<E> getStudents(
        List<E> ls, Predicate<E> pred) {
      List<E> res = new ArrayList<>();
      for (E s : ls) {
        if (pred.test(s)) res.add(s);
      }
      return res;
  }
  public static void main(String[] args) {
    List<Student> ls = Arrays.asList();
    getStudents(ls, s -> s.getGrade() > 10);

    List<String> lStr = Arrays.asList("Fred", "Jim", "Sheila");
    System.out.println(getStudents(lStr, s -> s.length() > 3));
  }
}
