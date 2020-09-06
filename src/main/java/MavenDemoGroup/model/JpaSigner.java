package MavenDemoGroup.model;
import javax.persistence.*;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="jpa_signer")
public class JpaSigner {
	@Id
	@GeneratedValue
	private int signerID;
	private String role_type;
	private String contact_name;
	private String contact_address;
	private int seNo;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name="seNo",insertable=false,updatable=false)
//	@Fetch(FetchMode.JOIN)
	@JsonIgnore
	private JpaTest jpaTest;

	public int getSignerID() {
		return signerID;
	}

	public void setSignerID(int signerID) {
		this.signerID = signerID;
	}

	public String getRole_type() {
		return role_type;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

	public String getContact_name() {
		return contact_name;
	}

	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}

	public String getContact_address() {
		return contact_address;
	}

	public void setContact_address(String contact_address) {
		this.contact_address = contact_address;
	}

	public int getSeNo() {
		return seNo;
	}

	public void setSeNo(int seNo) {
		this.seNo = seNo;
	}

	public JpaTest getJpaTest() {
		return jpaTest;
	}

	public void setJpaTest(JpaTest jpaTest) {
		this.jpaTest = jpaTest;
	}
	
	

	public JpaSigner() {
		super();
	}

	public JpaSigner(String role_type, String contact_name,
			String contact_address, int seNo, JpaTest jpaTest) {
		super();
		this.role_type = role_type;
		this.contact_name = contact_name;
		this.contact_address = contact_address;
		this.seNo = seNo;
		this.jpaTest = jpaTest;
	}

	@Override
	public String toString() {
		return "JpaSigner [signerID=" + signerID + ", role_type=" + role_type
				+ ", contact_name=" + contact_name + ", contact_address="
				+ contact_address + ", seNo=" + seNo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contact_address == null) ? 0 : contact_address.hashCode());
		result = prime * result
				+ ((contact_name == null) ? 0 : contact_name.hashCode());
		result = prime * result
				+ ((role_type == null) ? 0 : role_type.hashCode());
		result = prime * result + seNo;
		result = prime * result + signerID;
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
		JpaSigner other = (JpaSigner) obj;
		if (contact_address == null) {
			if (other.contact_address != null)
				return false;
		} else if (!contact_address.equals(other.contact_address))
			return false;
		if (contact_name == null) {
			if (other.contact_name != null)
				return false;
		} else if (!contact_name.equals(other.contact_name))
			return false;
		if (role_type == null) {
			if (other.role_type != null)
				return false;
		} else if (!role_type.equals(other.role_type))
			return false;
		if (seNo != other.seNo)
			return false;
		if (signerID != other.signerID)
			return false;
		return true;
	}
	

}
