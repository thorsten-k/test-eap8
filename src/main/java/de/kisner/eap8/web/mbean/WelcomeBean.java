package de.kisner.eap8.web.mbean;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named @ViewScoped
public class WelcomeBean implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String greeting;
	public String getGreeting() {return greeting;}
	public void setGreeting(String greeting) {this.greeting = greeting;}

	public WelcomeBean()
	{
		greeting = LocalDateTime.now().toString();
		
		System.out.println(this.getClass().getSimpleName()+" "+greeting);
	}
	
}