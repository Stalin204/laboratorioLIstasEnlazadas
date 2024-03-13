package clases;

public class Person {
  private String license = "";

  public Person() {
  }

  public Person(String license) {
    this.license = license;
  }

  public String getLicense() {
    return license;
  }

  public void setLicense(String license) {
    this.license = license;
  }
}
