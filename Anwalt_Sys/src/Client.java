public class Client {
    public Client(){

    }

    private int clientId;
    private String name;
    private String lastName;
    private char[] tc;
    private String job;
    private char[] gender;
    private char[] telephoneNumber;
    private String address;
    private String emailAddress;

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char[] getGender() {
        return gender;
    }

    public void setGender(char[] gender) {
        this.gender = gender;
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
}
