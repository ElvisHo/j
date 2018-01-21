package entity;

import java.io.Serializable;
@entity("TRAIN_RESOURCE")
public class Resource implements Serializable{
	private static final long serialVersionUID = 7334905402645201346L;
@ID
@Ge
private long id;
@Column(name="NAME")
private String name;
@Column(name="URL")
private String url;
@Column(name="CREATE_TIME")
private Date createTime;
@Column(name="CREATE_BY")
private String createBy;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}
public Date getCreateTime() {
	return createTime;
}
public void setCreateTime(Date createTime) {
	this.createTime = createTime;
}
public String getCreateBy() {
	return createBy;
}
public void setCreateBy(String createBy) {
	this.createBy = createBy;
}

}
