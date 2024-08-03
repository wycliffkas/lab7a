package edu.miu.cs.cs425.studentrecordsmgmtapp;

import edu.miu.cs.cs425.studentrecordsmgmtapp.model.Student;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MyStudentRecordsMgmtApp {
  public static void main(String[] args) {
      Student[] students = {
              new Student(110001, "Dave", LocalDate.of(1951, 11, 18)),
              new Student(110002, "Anna", LocalDate.of(1990, 12, 7)),
              new Student(110003, "Erica", LocalDate.of(1974, 1, 31)),
              new Student(110004, "Carlos", LocalDate.of(2009, 8, 22)),
              new Student(110005, "Bob", LocalDate.of(1994, 8, 5))
      };

      System.out.println("All Students:-------------->");
      printListOfStudents(students);

      System.out.println("Platinum Alumni Students:-------------->");
      List<Student> platinumAlumniStudents = getListOfPlatinumAlumniStudents(students);
      platinumAlumniStudents.forEach(System.out::println);

      System.out.println("Multiples of 5 and 7");
      int[] numbers = {5, 7, 10, 14, 15, 21, 35, 42, 50, 70, 100};
      printHelloWorld(numbers);


      System.out.println("Print the second biggest:-------------->");
      int[] array1 = {1, 2, 3, 4, 5};
      int[] array2 = {19, 9, 11, 0, 12};
      System.out.println(findSecondBiggest(array1));
      System.out.println(findSecondBiggest(array2));
  }

  public static void printListOfStudents(Student[] students) {
      Arrays.stream(students).sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
              .forEach(System.out::println);
  }

  public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
    LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);
    return Arrays.stream(students)
    .filter(student -> student.getDateOfAdmission().isBefore(thirtyYearsAgo))
    .sorted((s1, s2) -> s2.getDateOfAdmission().compareTo(s1.getDateOfAdmission()))
    .collect(Collectors.toList());
  }

  public static void printHelloWorld(int[] numbers) {
    for (int number : numbers) {
        if (number % 5 == 0 && number % 7 == 0) {
            System.out.println("HelloWorld");
        } else if (number % 5 == 0) {
            System.out.println("Hello");
        } else if (number % 7 == 0) {
            System.out.println("World");
        }
    }
  }

  public static int findSecondBiggest(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            throw new IllegalArgumentException("Array must contain at least two elements");
        }

        int firstBiggest = Integer.MIN_VALUE;
        int secondBiggest = Integer.MIN_VALUE;

        for (int number : numbers) {
            if (number > firstBiggest) {
                secondBiggest = firstBiggest;
                firstBiggest = number;
            } else if (number > secondBiggest && number != firstBiggest) {
                secondBiggest = number;
            }
        }

        if (secondBiggest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("No second biggest element found");
        }

        return secondBiggest;
  }

}


