package test.test2;

public class Person {
	private Integer age;
	private String name;
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void init() {
		System.out.println("init: name: " + name + "; age: " + age);
	}
	public void destroy() {
		System.out.println("destroy: name: " + name + "; age: " + age);
	}
}