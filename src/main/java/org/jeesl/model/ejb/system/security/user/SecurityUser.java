package org.jeesl.model.ejb.system.security.user;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;

import org.jeesl.interfaces.model.system.security.user.JeeslSecurityUser;
import org.jeesl.interfaces.model.system.security.user.JeeslSimpleUser;

@Entity
@Table(name="SecurityUser",uniqueConstraints=@UniqueConstraint(columnNames={"email"}))
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="system",discriminatorType=DiscriminatorType.STRING,length=32)
@DiscriminatorValue("generic")
@SequenceGenerator(name="SequenceUser",sequenceName="SecurityUser_id_seq",allocationSize=1)
public abstract class SecurityUser implements JeeslSimpleUser,JeeslSecurityUser
{
	public static final long serialVersionUID=1;


	@Id @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SequenceUser")
	protected long id;
	@Override public long getId() {return id;}
	@Override public void setId(long id) {this.id = id;}

	@NotNull @Column(unique=true)
	protected String email;
	@Override public String getEmail() {return email;}
	@Override public void setEmail(String email) {this.email = email;}

	protected String firstName;
	@Override public String getFirstName() {return firstName;}
	@Override public void setFirstName(String firstName) {this.firstName = firstName;}

	protected String lastName;
	@Override public String getLastName() {return lastName;}
	@Override public void setLastName(String lastName) {this.lastName = lastName;}

	protected String pwd;
	public String getPwd() {return pwd;}
	public void setPwd(String pwd) {this.pwd = pwd;}

	private String salt;
	public String getSalt() {return salt;}
	public void setSalt(String salt) {this.salt = salt;}

	private Boolean permitLogin;
	public Boolean getPermitLogin() {return permitLogin;}
	public void setPermitLogin(Boolean permitLogin) {this.permitLogin = permitLogin;}
}