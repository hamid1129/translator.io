package info.translate.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractAuditable;

@Entity
@Table(name = "USER")
public class User extends AbstractAuditable<User, Long> {

	private static final long serialVersionUID = -1547433984918828131L;

	private String username;

	private String password;

	private String emailAddress;
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH })
	private Set<Word> words = new HashSet<>();

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	@PrePersist
	public void prePersist() {
		System.out.println("PRE PERSIST");
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Set<Word> getWords() {
		return words;
	}

	public void setWords(Set<Word> words) {
		this.words = words;
	}

	@Override
	public String toString() {
		return "User [getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getEmailAddress()=" + getEmailAddress()
				+ ", getWords()=" + getWords() + ", getId()=" + getId()
				+ ", getCreatedBy()=" + getCreatedBy() + ", getCreatedDate()="
				+ getCreatedDate() + ", getLastModifiedBy()="
				+ getLastModifiedBy() + ", getLastModifiedDate()="
				+ getLastModifiedDate() + ", isNew()=" + isNew() + "]";
	}
}
