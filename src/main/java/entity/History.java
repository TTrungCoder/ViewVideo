package entity;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@Entity
@Table(name = "Historys")
@NamedQuery(name = "History.findAll", query = "SELECT h FROM History h")
public class History implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private boolean isLiked;

	private Timestamp likedDate;
	@CreationTimestamp
	private Timestamp viewedDate;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private User user;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "videoId", referencedColumnName = "id")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	private Video video;

	public History() {
	}

	public History(int id, boolean isLiked, Timestamp likedDate, Timestamp viewedDate, User user, Video video) {
		super();
		this.id = id;
		this.isLiked = isLiked;
		this.likedDate = likedDate;
		this.viewedDate = viewedDate;
		this.user = user;
		this.video = video;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getIsLiked() {
		return this.isLiked;
	}

	public void setIsLiked(boolean isLiked) {
		this.isLiked = isLiked;
	}

	public Timestamp getLikeDate() {
		return this.likedDate;
	}

	public void setLikedDate(Timestamp likedDate) {
		this.likedDate = likedDate;
	}

	public Timestamp getViewsDate() {
		return this.viewedDate;
	}

	public void setViewsDate(Timestamp viewsDate) {
		this.viewedDate = viewsDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "History [id=" + id + ", isLiked=" + isLiked + ", likeDate=" + likedDate + ", viewsDate=" + viewedDate
				+ ", user=" + user + ", video=" + video + "]";
	}

}