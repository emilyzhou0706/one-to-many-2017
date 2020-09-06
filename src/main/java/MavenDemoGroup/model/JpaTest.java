package MavenDemoGroup.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="jpa_test")

public class JpaTest {
	@Id
	private int id;
	private String name;
	private String sex;

	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER,mappedBy="jpaTest",cascade=CascadeType.ALL)
	private Set<JpaSigner> jpaSigner =new HashSet<>();

	public JpaTest(int id, String name, String sex, Set<JpaSigner> jpaSigner) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.jpaSigner = jpaSigner;
	}
	

	public JpaTest(int id, String name, String sex) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
	}


	public JpaTest() {
		super();
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Set<JpaSigner> getJpaSigner() {
		return jpaSigner;
	}

	public void setJpaSigner(Set<JpaSigner> jpaSigner) {
		this.jpaSigner = jpaSigner;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JpaTest other = (JpaTest) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "JpaTest [id=" + id + ", name=" + name + ", sex=" + sex + ", jpaSigner=" + jpaSigner + "]";
	}
	
}
