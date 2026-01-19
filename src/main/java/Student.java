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
    return Name + " " + Integer.toString(Age);
  }

  public static Student Parse(String str) {
    String[] data = str.split(" ");
    if(data.length != 2) 
      return new Student("Parse Error", -1);
    return new Student(data[0], Integer.parseInt(data[1]));
  }
}