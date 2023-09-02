package service;

import model.Onlineuser;

import java.util.List;

public class UserService {
    public static final Onlineuser dao=new Onlineuser().dao();

    public List<Onlineuser> getById(String id){
        return dao.find("select * from onlineuser where id = '"+id+"'");
    }

    public boolean updatePwd(Onlineuser onlineuser){
        return onlineuser.update();
    }
}
