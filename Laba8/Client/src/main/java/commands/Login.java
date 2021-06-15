package commands;

import util.Client;
import util.User;

public class Login {
    public void execute(String login, String password) {
        Client.readyToExchange("login","",null,new User(login,password));
    }
}
