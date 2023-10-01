package de.kisner.test.eap.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.jeesl.interfaces.qualifier.er.EjbErNode;
import org.jeesl.model.ejb.system.security.access.SecurityRole;
import org.jeesl.model.ejb.system.security.user.SecurityUser;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("eap")
@EjbErNode(name="User")
public class EapUser extends SecurityUser implements Serializable
{
	public static final long serialVersionUID=1;
	public static final long devId=1;
	
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="SecurityUserJtRole",joinColumns={@JoinColumn(name="user_id")},inverseJoinColumns={@JoinColumn(name="role_id")},uniqueConstraints=@UniqueConstraint(columnNames={"user_id","role_id"}))
	private List<SecurityRole> roles;
	public List<SecurityRole> getRoles() {if(Objects.isNull(roles)) {roles = new ArrayList<>();} return roles;}
	public void setRoles(List<SecurityRole> roles) {this.roles = roles;}

	
	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(id).append("]");
		sb.append(" ").append(email);
		return sb.toString();
	}
	
	@Override public boolean equals(Object object){return (object instanceof EapUser) ? id == ((EapUser) object).getId() : (object == this);}
	@Override public int hashCode(){return new HashCodeBuilder(23,47).append(id).toHashCode();}
}