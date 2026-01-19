import java.util.Collection;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class Service {

  public void addStudent(Student student) throws IOException {
    var f = new FileWriter("db.txt", true);
    var b = new BufferedWriter(f);
    b.append(student.ToString());
    b.newLine();
    b.close();
  }

  public Collection<Student> getStudents() throws IOException {
    var ret = new ArrayList<Student>();
    var f = new FileReader("db.txt");
    var reader = new BufferedReader(f);
    String line = "";
    while (true) {
      line = reader.readLine();
      if(line == null)
        break;
      ret.add(Student.Parse(line));
    }
    reader.close();
    return ret;
  }

  public Collection<Student> findStudentByName(String findLine) throws IOException {
    List<Student> students = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader("db.txt"))){
      String line;
      while ((line = reader.readLine()) != null){
        String[] parts = line.split(" ");
        if (parts.length> 0 && parts[0].equalsIgnoreCase(findLine)){
          students.add(Student.Parse(line));
        }
      }
    }
    return students;
  }
}