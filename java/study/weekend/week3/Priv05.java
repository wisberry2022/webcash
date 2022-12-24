package week3;

class Parent {
	String name;
}

class Child extends Parent {
	public Child() {
		this.name = "Jiyeong";
	}	
	
	public void show() {
		System.out.println("----------------------------------");
		System.out.println(this.name);
		System.out.println(super.name);
		System.out.println("----------------------------------");
	}
}

public class Priv05 {

	public static void main(String[] args) {
		Child a = new Child();
		a.show();
	}

}
