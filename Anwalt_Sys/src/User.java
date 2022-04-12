public class User {
    public User(int userId,String name,String lastName,char[] tc,String role,char[] telephoneNumber,
                String address,String emailAddress,char[] password){
        this.userId = userId;
        this.name = name;
        this.lastName = lastName;
        this.tc = tc;
        this.role = role;
        this.telephoneNumber = telephoneNumber;
        this.address = address;
        this.emailAddress = emailAddress;
        this.password = password;




    }
    private int userId;
    private String name;
    private String lastName;
    private char[] tc;
    private String role;
    private char[] telephoneNumber;
    private String address;
    private String emailAddress;
    private char[] password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char[] getTc() {
        return tc;
    }

    public void setTc(char[] tc) {
        this.tc = tc;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public char[] getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(char[] telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
