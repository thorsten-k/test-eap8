package de.kisner.test.eap.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="DemoEntity")
@Entity
public class DemoEntity implements Serializable
{
	public static final long serialVersionUID=1;
	
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	

	private String destination;
	public String getDestination() {return destination;}
	public void setDestination(String destination) {this.destination = destination;}
	
	
	@Override public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("[").append(id).append("]");
		return sb.toString();
	}
	
//	@Override public boolean equals(Object object) {return (object instanceof JeeBooking) ? id == ((JeeBooking) object).getId() : (object == this);}
//	@Override public int hashCode() {return new HashCodeBuilder(23,13).append(id).toHashCode();}
}