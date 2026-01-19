public class Student {

  private String Name;
  private int Age;
  private String Date;

  public Student(String name, int age, String date) {
    Name = name;
    Age = age;
    this.Date = date;
  }

  public String GetName() {return Name;}
  public int GetAge() {return Age;}
  public String GetData() {return Date;}

  public String ToString() {
      return Name + " " + Age + " " + Date;
  }

  public static Student Parse(String str) {
      if(str == null || str.trim().isEmpty()) {
          return new Student("Parse Error", -1, "");
      }
      String[] data = str.trim().split("\\s+"); //bóg jeden wie dlaczego to działa
      if(data.length != 3) {
          return new Student("Parse Error", -1, "");
      }
      try {
          int age = Integer.parseInt(data[1]); 
          return new Student(data[0], age, data[2]);
      } catch(NumberFormatException e) {
          return new Student("Parse Error", -1, "");
      }
  }

}