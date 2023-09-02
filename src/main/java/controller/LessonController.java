package controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.ActionKey;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.json.FastJson;
import model.Course;
import model.Lesson;
import model.Onlineuser;
import service.LessonService;

import java.util.List;

@Path("/lesson")
public class LessonController extends Controller {
    @Inject
    private LessonService service;

    public void getAllLesson(){
        List<Lesson> lessons = service.getAll();
        renderJson("data",lessons);
    }

    //老师获取
    public void getById(){
        Onlineuser user = getSessionAttr("user");
        List<Lesson> list = service.getByUserId(user.getId());
        renderJson(list);
    }

    //学生获取
    public void getStuId(){
        Onlineuser user = getSessionAttr("user");
        List<Course> list = service.getByStuId(user.getId());
        renderJson(list);
    }

    public void addlesson(){
        String s = getRawData();
        Lesson lesson = FastJson.getJson().parse(s, Lesson.class);
        boolean flag = service.add(lesson);
        if(flag){
            renderJson("success");
        }else {
            renderJson("error");
        }
    }

    public void dellesson(){
        String s = get("id");
        boolean b = service.delete(s);
        if(b){
            renderJson("success");
        }
    }

    public void updlesson(){
        String s = getRawData();
        Lesson lesson = FastJson.getJson().parse(s, Lesson.class);
        boolean b = service.update(lesson);
        if(b){
            renderJson("success");
        }
    }

    public void condition(){
        String s = getRawData();
        Lesson lesson = FastJson.getJson().parse(s, Lesson.class);
        Onlineuser user = getSessionAttr("user");
        List<Lesson> lessons = service.selectByCondition(lesson.getLessonname(), lesson.getLessontime(), user.getId());
        if(!lessons.isEmpty()){
            renderJson("data",lessons);
        }else {
            renderJson();
        }
    }

    //学生进行选课
    public void getLesson(){
        String s = getRawData();
        Course course = FastJson.getJson().parse(s, Course.class);

        Onlineuser user = getSessionAttr("user");
        List<Course> list = service.getLesson(course.getCid(),user.getId());
        if(!list.isEmpty()){
            renderJson("error");
        }else {
            int capacity=Integer.parseInt(course.getCapacity());
            if(capacity>0){
                capacity --;
                course.setCapacity(String.valueOf(capacity));
                service.getCourse(course,user.getId());
                renderJson("success");
            }else {
                renderJson("warn");
            }
        }
    }

//    学生进行退课
    public void dropLesson(){
        String s = getRawData();
        Course course = FastJson.getJson().parse(s, Course.class);
        Lesson l = new Lesson();
        int capacity=Integer.parseInt(course.getCapacity());
        capacity ++;
        l.setCapacity(String.valueOf(capacity));
        l.setId(course.getCid());
        boolean b = service.update(l);
        boolean flag = service.dCourse(course.getId());
        if(b && flag){
            renderJson("success");
        }else {
            renderJson("error");
        }
    }

    //学生进行条件查询
    public void search(){
        String s = getRawData();
        Lesson lesson = FastJson.getJson().parse(s, Lesson.class);
        Onlineuser user = getSessionAttr("user");
        List<Lesson> lessons = service.searchByCondition(lesson.getLessonname(), lesson.getCapacity());
        if(!lessons.isEmpty()){
            renderJson(lessons);
        }else {
            renderJson();
        }
    }

//    学生退课时条件查询
    public void dsearch(){
        String s = getRawData();
        Course course = FastJson.getJson().parse(s, Course.class);
        Onlineuser user = getSessionAttr("user");
        List<Course> courses = service.dsearchByCondition(course.getCname(), course.getCapacity(), user.getId());
        if(!courses.isEmpty()){
            renderJson(courses);
        }else {
            renderJson();
        }
    }
}
