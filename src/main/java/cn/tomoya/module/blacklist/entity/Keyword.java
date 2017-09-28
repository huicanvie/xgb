package cn.tomoya.module.blacklist.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 黑名单
 * @author ddppfamily
 *
 */
@Entity
@Table(name = "pybbs_blacklist")
public class Keyword implements Serializable {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(name = "user_id")
	private int user_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

}
