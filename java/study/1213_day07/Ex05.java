class Car {
	public final String model;
	public int speed;
	public final int maxSpeed;

	public Car() {
		this("부가티", 400);
	}

	public Car(int b) {
		maxSpeed = b;
		if(b<=120) {model = "모닝";}
		else if(b<=150) {model = "아반떼";}
		else if(b<=180) {model = "소나타";}
		else if(b<=200) {model = "그랜저";}
		else { model = "부가티"; }
		showSpeed();
	}

	public Car(String a, int b){
		model = a;
		maxSpeed = b;
	}

	public void speedUp() {
		if(speed+10<=maxSpeed) {
			speed+=10;
		}else {
			speed=maxSpeed;
		}
		showSpeed();
	}

	public void speedDown() {
		if(speed-17<=0){
			speed-=17;
		}else {
			speed=0;
		}
		showSpeed();
	}

	public void showSpeed() {
		System.out.println(model + " 내 차 속도는 " + speed + "km");
	}
}

class Ex05 {
	public static void main(String[] args){
		Car myCar;
		myCar = new Car(120);
		for(int i = 0; i<20; i++){
			myCar.speedUp();
		}
		myCar = new Car();
		for(int i = 0; i<20; i++){
			myCar.speedUp();
		}
		
	}	
}