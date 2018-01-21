package entity;

import java.io.Serializable;

@entity("TRAIN_USER_ROLE_RE")

public class UserRoleResource implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1287779050563934846L;

@ID
@Grea
private long id;

@Colunm(name="USER_ID")
private long userId;
@Colunm(name="ROLE_ID")
private long roleId;
@Colunm(name="RESOURCE_ID")
private long resourceId;
@Colunm(name="LEVELS_NUM")
private int levelsNum;
@Colunm(name="CREATE_TIME")
private Data createTime;
@Colunm(name="CREATE_BY")
private String createBy;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public long getUserId() {
	return userId;
}
public void setUserId(long userId) {
	this.userId = userId;
}
public long getRoleId() {
	return roleId;
}
public void setRoleId(long roleId) {
	this.roleId = roleId;
}
public long getResourceId() {
	return resourceId;
}
public void setResourceId(long resourceId) {
	this.resourceId = resourceId;
}
public int getLevelsNum() {
	return levelsNum;
}
public void setLevelsNum(int levelsNum) {
	this.levelsNum = levelsNum;
}
public Data getCreateTime() {
	return createTime;
}
public void setCreateTime(Data createTime) {
	this.createTime = createTime;
}
public String getCreateBy() {
	return createBy;
}
public void setCreateBy(String createBy) {
	this.createBy = createBy;
}

}
