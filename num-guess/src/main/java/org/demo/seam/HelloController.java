package org.demo.seam;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "hello", eager = true)
public class HelloController {
	public HelloController() {
		System.out.println("HelloWorld started!");
	}

	public String getMessage() {
		return "Hello World!";
	}
}