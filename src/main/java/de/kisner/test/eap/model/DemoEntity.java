package de.kisner.test.eap.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.HashCodeBuilder;

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
	
	
	@Override public boolean equals(Object object){return (object instanceof DemoEntity) ? id == ((DemoEntity) object).getId() : (object == this);}
	@Override public int hashCode() {return new HashCodeBuilder(17, 53).append(id).toHashCode();}

	@Override public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("[").append(id).append("]");
		return sb.toString();
	}
}