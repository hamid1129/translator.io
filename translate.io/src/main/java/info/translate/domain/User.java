package info.translate.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((words == null) ? 0 : words.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (emailAddress == null) {
			if (other.emailAddress != null)
				return false;
		} else if (!emailAddress.equals(other.emailAddress))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (words == null) {
			if (other.words != null)
				return false;
		} else if (!words.equals(other.words))
			return false;
		return true;
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

	public static class UserBuilder {
		public User build() {
			return new User();
		}

		public static UserBuilder builder() {
			return new UserBuilder();
		}
	}
}
