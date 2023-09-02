package service;

import model.Course;
import model.Lesson;

import java.util.List;

public class LessonService {
    public static final Lesson dao = new Lesson().dao();
    public static final Course coursedao = new Course().dao();

    public List<Lesson> getAll() {
        return dao.findAll();
    }

    public List<Lesson> getByUserId(String userid) {
        return dao.find("select * from lesson where userid = '" + userid + "'");
    }

    public List<Course> getByStuId(String stuid) {
        return coursedao.find("select * from course where stuid = '" + stuid + "'");
    }

    public boolean add(Lesson lesson) {
        return new Lesson().set("id", lesson.getId())
                .set("lessonname", lesson.getLessonname())
                .set("capacity", lesson.getCapacity())
                .set("period", lesson.getPeriod())
                .set("lessontime", lesson.getLessontime())
                .set("teacher", lesson.getTeacher())
                .set("lessonplace", lesson.getLessonplace())
                .set("userid", lesson.getUserid())
                .save();
    }

    public boolean delete(String id) {
        return dao.deleteById(id);
    }

    public boolean update(Lesson lesson) {
        return lesson.update();
    }

    //教师查询
    public List<Lesson> selectByCondition(String name, String time, String userid) {
        if (time.equals("")) {
            return dao.find("select * from lesson where lessonname like '%" + name + "%' and userid = '" + userid + "'");
        } else if (name.equals("")) {
            return dao.find("select * from lesson where lessontime like '%" + time + "%' and userid = '" + userid + "'");
        } else if (!name.equals("") && !time.equals("")) {
            return dao.find("select * from lesson where lessonname like '%" + name + "%' and lessontime like '%" + time + "%' and userid = '" + userid + "'");
        } else {
            return null;
        }
    }

    //    判断学生是否已经选课
    public List<Course> getLesson(String cid,String stuid) {
        return coursedao.find("select * from course where cid = '"+cid+"' and stuid = '" + stuid + "'");
    }

    //学生进行选课
    public boolean getCourse(Course course,String stuid){
        return new Course().set("cname", course.getCname())
                .set("cid",course.getCid())
                .set("capacity", course.getCapacity())
                .set("period", course.getPeriod())
                .set("ctime", course.getCtime())
                .set("teacher", course.getTeacher())
                .set("cplace", course.getCplace())
                .set("stuid",stuid)
                .save();
    }

    //学生进行退课
    public boolean dCourse(int id){
        return coursedao.deleteById(id);
    }

    //    学生选课查询
    public List<Lesson> searchByCondition(String name, String capacity) {
        if (capacity.equals("")) {
            return dao.find("select * from lesson where lessonname like '%" + name + "%'");
        } else if (name.equals("")) {
            return dao.find("select * from lesson where capacity like '%" + capacity + "%'");
        } else if (!name.equals("") && !capacity.equals("")) {
            return dao.find("select * from lesson where lessonname like '%" + name + "%' and capacity like '%" + capacity + "%'");
        } else {
            return null;
        }
    }

//    学生退课查询
    public List<Course> dsearchByCondition(String cname,String capacity,String stuid){
        if (capacity.equals("")) {
            return coursedao.find("select * from course where cname like '%" + cname + "%' and stuid = '"+stuid+"'");
        } else if (cname.equals("")) {
            return coursedao.find("select * from course where capacity like '%" + capacity + "%' and stuid = '"+stuid+"'");
        } else if (!cname.equals("") && !capacity.equals("")) {
            return coursedao.find("select * from course where cname like '%" + cname + "%' and capacity like '%" + capacity + "%' and stuid = '"+stuid+"'");
        } else {
            return null;
        }
    }
}
