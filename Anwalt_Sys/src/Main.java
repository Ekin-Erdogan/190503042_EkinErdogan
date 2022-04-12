public class Main {

    public static void Main(String[] args){

        //User user = new User();
        Client client = new Client();
        Cases cases = new Cases();


        UserManager userManager = new UserManager(new MySqlUserDal());
        ClientManager clientManager = new ClientManager();
        CaseManager caseManager = new CaseManager();










    }


}
