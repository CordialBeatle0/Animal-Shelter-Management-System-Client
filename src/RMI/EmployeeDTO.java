package RMI;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private int ID;
    private String name;
    private int age;
    private char gender;
    private String email;
    private String phoneNumber;
    private String address;
    //    private AccountDTO account;
    private String username;
    private String password;
    private float salary;
    private String type;
    
    public EmployeeDTO() {
    }
    
    public EmployeeDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address, String username, String password, float salary, String type) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.type = type;
    }
    
    public EmployeeDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                       String username, String password, float salary, String type) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.salary = salary;
        this.type = type;
    }
    
    public EmployeeDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                       String username, String password, float salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.salary = salary;
    }
    
    public EmployeeDTO(String name, int age, char gender, String email, String phoneNumber, String address,
                       float salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        //        this.account = account;
        this.salary = salary;
    }
    
    public EmployeeDTO(int ID, String name, int age, char gender, String email, String phoneNumber, String address,
                       float salary) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.salary = salary;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int ID) {
        this.ID = ID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public char getGender() {
        return gender;
    }
    
    public void setGender(char gender) {
        this.gender = gender;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    //    public AccountDTO getAccount() {
    //        return account;
    //    }
    //
    //    public void setAccount(AccountDTO account) {
    //        this.account = account;
    //    }
    
    public float getSalary() {
        return salary;
    }
    
    public void setSalary(float salary) {
        this.salary = salary;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                ", type='" + type + '\'' +
                '}';
    }
}
