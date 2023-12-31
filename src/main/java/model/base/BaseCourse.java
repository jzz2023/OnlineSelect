package model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseCourse<M extends BaseCourse<M>> extends Model<M> implements IBean {

	public void setId(java.lang.Integer id) {
		set("id", id);
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	public void setCid(java.lang.String cid) {
		set("cid", cid);
	}
	
	public java.lang.String getCid() {
		return getStr("cid");
	}
	
	public void setCname(java.lang.String cname) {
		set("cname", cname);
	}
	
	public java.lang.String getCname() {
		return getStr("cname");
	}
	
	public void setCapacity(java.lang.String capacity) {
		set("capacity", capacity);
	}
	
	public java.lang.String getCapacity() {
		return getStr("capacity");
	}
	
	public void setPeriod(java.lang.String period) {
		set("period", period);
	}
	
	public java.lang.String getPeriod() {
		return getStr("period");
	}
	
	public void setTeacher(java.lang.String teacher) {
		set("teacher", teacher);
	}
	
	public java.lang.String getTeacher() {
		return getStr("teacher");
	}
	
	public void setCtime(java.lang.String ctime) {
		set("ctime", ctime);
	}
	
	public java.lang.String getCtime() {
		return getStr("ctime");
	}
	
	public void setCplace(java.lang.String cplace) {
		set("cplace", cplace);
	}
	
	public java.lang.String getCplace() {
		return getStr("cplace");
	}
	
	public void setStuid(java.lang.String stuid) {
		set("stuid", stuid);
	}
	
	public java.lang.String getStuid() {
		return getStr("stuid");
	}
	
}

