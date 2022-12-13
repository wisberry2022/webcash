class Car {
	public String model;
	public String color;
	public int speed;
	public int brakeSpeed = 30;
	public int maxSpeed;

	public void speedUp() {
		if(speed+10 < maxSpeed){
			speed+=10;
		}else {
			speed = maxSpeed;
			System.out.println("현재 내 차는 최대시속으로 달리고 있습니다!");
		}
	}

	public void speedDown() {
		/*if(speed - brakeSpeed > 0){
			speed -= brakeSpeed;
		}else {
			speed = 0;
			System.out.println("내 차는 정지하였습니다!");
		} */
		if(speed > brakeSpeed) {
			speed -= brakeSpeed;
		}else {
			speed = 0;
			System.out.println("내 차는 정지하였습니다!");
		}
	}
}

class Ex02 {
	public static void main(String[] args){
		Car myCar = new Car();
		myCar.model = "스파크";
		myCar.color = "핑크";
		myCar.maxSpeed = 100;
		System.out.println(myCar.color + "색 내 차 " + myCar.model + "의 현재 속도는 " + myCar.speed + "km");
		for(int i = 0; i<9; i++){
			myCar.speedUp();
			System.out.println(myCar.color + "색 내 차 " + myCar.model + "의 현재 속도는 " + myCar.speed + "km");
		}
		System.out.println("하차함");
		myCar = new Car();
		myCar.model = "아반떼";
		myCar.maxSpeed = 150;
		myCar.color = "흰";
		System.out.println(myCar.color + "색 내 차 " + myCar.model + "의 현재 속도는 " + myCar.speed + "km");
		for(int i = 0; i<30; i++){
			myCar.speedUp();
			System.out.println(myCar.color + "색 내 차 " + myCar.model + "의 현재 속도는 " + myCar.speed + "km");
		}
		for(int i = 0; i<16; i++){
			myCar.speedDown();
			System.out.println(myCar.color + "색 내 차 " + myCar.model + "의 현재 속도는 " + myCar.speed + "km");
		}			
	}
}