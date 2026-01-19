import java.util.Scanner;
import java.util.Collection;

class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    try {
      boolean kontynuuj = true;
      while (kontynuuj) {
        Service s = new Service();
        int number = scanner.nextInt();
        scanner.nextLine();
        switch (number) {
          case 1:
            System.out.println("Podaj imię nowego studenta:");
            String name = scanner.nextLine(); // 4.1 i 5.1
            System.out.println("Podaj wiek:");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Podaj date urodzenia:");
            String date = scanner.nextLine();
            s.addStudent(new Student( name, age, date));

            break;
          case 2:
            var students = s.getStudents();
            for (Student current : students) {
              System.out.println(current.ToString()); // 4.2
            }
            break;
            
          case 3:
          System.out.println("Podaj imię studenta do wyszukania:");
          String searchName = scanner.nextLine();

          Collection<Student> foundStudents = s.findStudentByName(searchName);

          if (!foundStudents.isEmpty()) {
              System.out.println("Znaleziono studentów:");
              for (Student student : foundStudents) {
                  System.out.println(student);
              }

              System.out.println("Czy chcesz zmienić wiek studenta? (t/n)"); //5.1_2 i 5.1_4
              String answer = scanner.nextLine();

              if (answer.equalsIgnoreCase("t")) {

                  
                  System.out.println("Podaj dokładne imię i nazwisko studenta:");
                  String fullName = scanner.nextLine();

                  System.out.println("Podaj nowy wiek:");
                  int newAge = Integer.parseInt(scanner.nextLine());

                  boolean updated = s.updateStudentAge(fullName, newAge);

                  if (updated) {
                      System.out.println("Wiek studenta został zmieniony.");
                  } else {
                      System.out.println("Nie udało się zmienić wieku.");
                  }
              }

          } else {
              System.out.println("Nie znaleziono studenta o podanym imieniu.");
          }
          break;


          case 4:
            System.out.println("Podaj imię studenta do usunięcia:");
            String removeName = scanner.nextLine(); //5.1_3
            boolean removed = s.removeStudent(removeName);
            if (removed)
              System.out.println("Student został usunięty.");
            else
              System.out.println("Nie znaleziono studenta o podanym imieniu.");

           break;

            
          case 5:
            System.out.println("Zakończono program. Do zobaczenia!");
            kontynuuj = false; //wyjscie z petli 
            break;

          default:
            System.out.println("Nieprawidłowa opcja!");
        }

        if (kontynuuj) {
          System.out.println();
          System.out.print("Czy chcesz wykonać kolejne działanie? (t/n): ");
          char odp = scanner.next().toLowerCase().charAt(0);
          if (odp != 't') {
            kontynuuj = false;
            System.out.println("Zakończono program. Do zobaczenia!");
          }
          System.out.println();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      scanner.close();
    }
  }
}
