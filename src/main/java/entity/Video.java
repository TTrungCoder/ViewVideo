package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Videos database table.
 * 
 */
@Entity
@Table(name="Videos")
@NamedQuery(name="Video.findAll", query="SELECT v FROM Video v")
public class Video implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String description;

	private String href;

	private boolean isActive;

	private String poster;

	private int shares;

	private String title;

	private int views;

//	//bi-directional many-to-one association to History
//	@OneToMany(mappedBy="video")
//	private List<History> historys;

	public Video() {
	}
	
	
	public Video(int id, String description, String href, boolean isActive, String poster, int shares, String title,
			int views) {
		super();
		this.id = id;
		this.description = description;
		this.href = href;
		this.isActive = isActive;
		this.poster = poster;
		this.shares = shares;
		this.title = title;
		this.views = views;
	}


	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getShares() {
		return this.shares;
	}

	public void setShares(int shares) {
		this.shares = shares;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

//	public List<History> getHistorys() {
//		return this.historys;
//	}
//
//	public void setHistorys(List<History> historys) {
//		this.historys = historys;
//	}

//	public History addHistory(History history) {
//		getHistorys().add(history);
//		history.setVideo(this);
//
//		return history;
//	}
//
//	public History removeHistory(History history) {
//		getHistorys().remove(history);
//		history.setVideo(null);
//
//		return history;
//	}


	@Override
	public String toString() {
		return "Video [id=" + id + ", description=" + description + ", href=" + href + ", isActive=" + isActive
				+ ", poster=" + poster + ", shares=" + shares + ", title=" + title + ", views=" + views + "]";
	}
	
}