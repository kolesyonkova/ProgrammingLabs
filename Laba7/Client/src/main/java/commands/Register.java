package commands;

import util.Client;
import util.User;

public class Register{
    public void execute(String login,String password){
        Client.readyToExchange("register","",null,new User(login,password));
    }
}
