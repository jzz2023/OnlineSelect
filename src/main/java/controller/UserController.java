package controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import model.Onlineuser;
import service.UserService;

import java.util.List;


@Path("/user")
public class UserController extends Controller {
    @Inject
    private UserService service;

    public void index(){
        render("userPage.html");
    }


    public void teacher(){
        render("teacher.html");
    }

    public void getStudent(){
        LoginController lc=new LoginController();
        Onlineuser user = getSessionAttr("user");
        List<Onlineuser> list = service.getById(user.getId());
        renderJson(list);
    }


    public void updatePwd(){
        String s = getRawData();
        Onlineuser onlineuser = FastJson.getJson().parse(s, Onlineuser.class);
        boolean b = service.updatePwd(onlineuser);
        if(b){
            renderJson("success");
        }
    }
}
