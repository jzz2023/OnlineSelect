package service;


import model.Onlineuser;

import java.util.List;

public class Login {
    public static final Onlineuser dao=new Onlineuser().dao();

    public List<Onlineuser> getUser(String id,String pwd){
        return dao.find("select * from onlineuser where id = '"+id+"' and pwd = '"+pwd+"'");
    }
}
