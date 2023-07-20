package entity;

import java.io.Serializable;
import javax.persistence.*;

import constant.NamedStored;

/**
 * The persistent class for the Users database table.
 * 
 */
@Entity
@Table(name = "Users")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = NamedStored.FIND_USERS_LIKED_VIDEO_BY_HREF, 
				procedureName = "sp_selectUsersLikedVideoByVideoHref", 
				resultClasses = {User.class }, 
				parameters = @StoredProcedureParameter(name = "videoHref", type = String.class)) 
})
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;

	private boolean isActive;

	private boolean isAdmin;

	private String password;

	private String username;

//	//bi-directional many-to-one association to History
//	@OneToMany(mappedBy="user")
//	private List<History> historys;

	public User() {
	}

	public User(int id, String email, boolean isActive, boolean isAdmin, String password, String username) {
		super();
		this.id = id;
		this.email = email;
		this.isActive = isActive;
		this.isAdmin = isAdmin;
		this.password = password;
		this.username = username;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean getIsAdmin() {
		return this.isAdmin;
	}

	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

//	public List<History> getHistorys() {
//		return this.historys;
////	}
//
//	public void setHistorys(List<History> historys) {
//		this.historys = historys;
//	}

//	public History addHistory(History history) {
//		getHistorys().add(history);
//		history.setUser(this);
//
//		return history;
//	}
//
//	public History removeHistory(History history) {
//		getHistorys().remove(history);
//		history.setUser(null);
//
//		return history;
//	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", isActive=" + isActive + ", isAdmin=" + isAdmin + ", password="
				+ password + ", username=" + username + "]";
	}

}