/**
 * 
 */
package com.sai.mrb.model;

/**
 * @author sv
 *
 */
public class Login {
	
	private String name;
	private String password;
	
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Login(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [name=" + name + ", password=" + password + "]";
	}
	
}