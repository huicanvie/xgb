package cn.tomoya.module.blacklist.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import cn.tomoya.module.user.entity.User;

/**
 * 黑名单
 * @author ddppfamily
 *
 */
@Entity
@Table(name = "pybbs_blacklist")
public class Blacklist implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	
//	@Column(name = "user_id")
//	private int user_id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getUser_id() {
//		return user_id;
//	}
//
//	public void setUser_id(int user_id) {
//		this.user_id = user_id;
//	}
	
//	@OneToOne(cascade= {CascadeType.REFRESH, CascadeType.PERSIST})  
	@OneToOne(cascade= CascadeType.REFRESH)  
    @JoinColumn(name="user_id")  
    private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
