package Model;

import java.util.Date;

public class Project {
	
	private int id;
	private String name,description;
	private Date createdAt, updateAt;
	
	public Project(int id, String name, String description, Date cratedAt, Date updateAt) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.createdAt = cratedAt;
		this.updateAt = updateAt;
	}
	
	public Project() {
		this.createdAt = new Date();
        this.updateAt = new Date();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCratedAt() {
		return createdAt;
	}

	public void setCratedAt(Date cratedAt) {
		this.createdAt = cratedAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}


	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", description=" + description + ", cratedAt=" + createdAt
				+ ", updateAt=" + updateAt + "]";
	}
	
	
	
	

}
