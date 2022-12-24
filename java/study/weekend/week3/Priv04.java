package week3;

class Book<T extends Genre>{
	T genre;
	String name;
	int page;
	
	public Book(String name, T genre) {
		this.genre = genre;
		this.name = name;
	}
	
	void showInfo() {
		System.out.println("책 제목: " + name + "\t" + genre.name);
	}
	
	T getGenre() {
		return this.genre;
	}	
}

public class Priv04 {

	public static void main(String[] args) {
		Mystery ms = new Mystery();
		Romance rm = new Romance();
		Thriller th = new Thriller();
		Kid kd = new Kid();
		Book<Mystery> MB = new Book<>("셔터 아일랜드", ms);
		Book<Romance> RB = new Book<>("비포선라이즈", rm);
		Book<Thriller> TB = new Book<>("오리엔트 살인사건", th);
		Book<Kid> KB = new Book<>("뽀로로", kd);
		
		MB.showInfo();
		RB.showInfo();
		TB.showInfo();
		KB.showInfo();
		
		Mystery ms1 = MB.getGenre();
		System.out.println(ms1.name);
	}

}
