package model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings("serial")
public abstract class BaseOnlineuser<M extends BaseOnlineuser<M>> extends Model<M> implements IBean {

	public void setId(java.lang.String id) {
		set("id", id);
	}
	
	public java.lang.String getId() {
		return getStr("id");
	}
	
	public void setPwd(java.lang.String pwd) {
		set("pwd", pwd);
	}
	
	public java.lang.String getPwd() {
		return getStr("pwd");
	}
	
	public void setName(java.lang.String name) {
		set("name", name);
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}
	
	public void setSex(java.lang.String sex) {
		set("sex", sex);
	}
	
	public java.lang.String getSex() {
		return getStr("sex");
	}
	
	public void setAge(java.lang.Integer age) {
		set("age", age);
	}
	
	public java.lang.Integer getAge() {
		return getInt("age");
	}
	
	public void setIdentity(java.lang.String identity) {
		set("identity", identity);
	}
	
	public java.lang.String getIdentity() {
		return getStr("identity");
	}
	
	public void setPhone(java.lang.String phone) {
		set("phone", phone);
	}
	
	public java.lang.String getPhone() {
		return getStr("phone");
	}
	
	public void setCollege(java.lang.String college) {
		set("college", college);
	}
	
	public java.lang.String getCollege() {
		return getStr("college");
	}
	
}

