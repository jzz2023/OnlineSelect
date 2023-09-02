package config;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import model.Course;
import model.Lesson;
import model.Onlineuser;

public class DBConfig extends JFinalConfig {
    public static void main(String[] args) {
        UndertowServer.start(DBConfig.class,8080,false);
    }
    @Override
    public void configConstant(Constants constants) {
        constants.setDevMode(false);
        constants.setInjectDependency(true);
        constants.setResolveJsonRequest(true);
    }

    @Override
    public void configRoute(Routes routes) {
        routes.scan("controller.");
    }

    @Override
    public void configEngine(Engine engine) {

    }

    @Override
    public void configPlugin(Plugins plugins) {
        String jdbcUrlString="jdbc:mysql://localhost:3306/db3?useSSL=false";

        DruidPlugin druidPlugin = new DruidPlugin(jdbcUrlString,"root","jia237106-");
        ActiveRecordPlugin activeRecordPlugin = new ActiveRecordPlugin(druidPlugin);

        activeRecordPlugin.setDevMode(true);
        activeRecordPlugin.setShowSql(true);

        //映射表
        activeRecordPlugin.addMapping("lesson", Lesson.class);
        activeRecordPlugin.addMapping("onlineuser", Onlineuser.class);
        activeRecordPlugin.addMapping("course", Course.class);

        plugins.add(druidPlugin);
        plugins.add(activeRecordPlugin);
    }

    @Override
    public void configInterceptor(Interceptors interceptors) {

    }

    @Override
    public void configHandler(Handlers handlers) {

    }
}
