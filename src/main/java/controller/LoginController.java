package controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import model.Onlineuser;
import service.Login;

import java.util.List;


@Path("/")
public class LoginController extends Controller{

    @Inject
    private Login service;

    public void index(){
        render("index.html");
    }

    @ActionKey("/login")
    public void login(){
        String data = getRawData();
        Onlineuser onlineuser = FastJson.getJson().parse(data, Onlineuser.class);
        List<Onlineuser> user = service.getUser(onlineuser.getId(), onlineuser.getPwd());
        if(!user.isEmpty()){
            setSessionAttr("user",onlineuser);
            renderJson("success");
        }else {
            renderJson("error");
        }
    }
}
