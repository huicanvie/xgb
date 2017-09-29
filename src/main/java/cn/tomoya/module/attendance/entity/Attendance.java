package cn.tomoya.module.attendance.entity;

import cn.tomoya.module.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * xgb on 17-6-15.
 */
@Entity
@Table(name = "pybbs_attendance")
public class Attendance implements Serializable {

  @Id
  @GeneratedValue
  private int id;

  private int score;

  @ManyToOne
  @JoinColumn(nullable = false, name = "user_id")
  @JsonIgnore
  private User user;

  @Column(name = "in_time")
  private Date inTime;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getInTime() {
    return inTime;
  }

  public void setInTime(Date inTime) {
    this.inTime = inTime;
  }
}
