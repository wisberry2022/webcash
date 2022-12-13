class Car {
	public int speed;
	public int maxSpeed;
	public String model;

	public Car() {
		this.model = "기본차";
		this.maxSpeed = 150;
	}

	public Car(int maxSpeed) {
		this();
		this.maxSpeed = maxSpeed;
	}

	public Car(int maxSpeed, String model){
		this();
		this.maxSpeed = maxSpeed;
		this.model = model;
		System.out.println("자동차가 출고되었습니다1");
	}	

	public void func01() {
		this(120);
		System.out.println("func01 run!");
	}
}

class Ex08{
	public static void main(String[] args){
		Car myCar = new Car();
		myCar.func01();

	}
}