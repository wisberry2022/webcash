package com.test;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

// 학번, 국어(ml), 영어(eng), 수학(math) 정보를 담고 있는 학생 Class
class Std {
	private int id;
	private int ml;
	private int eng;
	private int math;
	
	public Std(int id, int ml, int eng, int math) {
		this.id = id;
		this.ml = ml;
		this.eng = eng;
		this.math = math;
	}
	
	public int getId() {
		return id;
	}
	
	public int getMl() {
		return ml;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMl(int ml) {
		this.ml = ml;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public void setMath(int math) {
		this.math = math;
	}

	public int getSum() {
		return ml+eng+math;
	}
	
	public double getAvg() {
		return (int)(this.getSum()*100 / 3.0) * 0.01;
	}
	
	public String getGrade() {
		int criteria = getSum();
		if(criteria >= 3*90) {
			return "A";
		}else if(criteria >= 3*80) {
			return "B";
		}else if(criteria >= 3*70) {
			return "C";
		}else if(criteria >= 3*60) {
			return "D";
		}else {
			return "F(재수강 요망)";
		}
	}	
}

// 메인 클래스
public class Ex23_mongo {
	static MongoClient client = null;
	static String[] column = {"_id", "ml", "eng", "math", "avg", "grade"};
	
	// 메인메소드
	public static void main(String[] args) {
		// 이클립스 콘솔에서 발생하는 MONGODB 로그를 지우기 위한 코드
		java.util.logging.Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
		System.out.println("학생성적관리프로그램(ver 0.5.0)");
		String select;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("1.리스트    2.상세보기    3.입력    4.수정    5.삭제    0.종료  >");
			select = sc.nextLine();
			if(select.equals("0")) {
				System.out.println("이용해주셔서 감사합니다!");
				return;
			}else if(select.equals("1")) {
				// 리스트
				ArrayList<String[]> datas = totalShow();
				System.out.println("---------------------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				for(int i = 0; i<datas.size(); i++) {
					String[] data = datas.get(i);
					System.out.println(data[0] + "\t" + data[1] + "\t" + data[2] + "\t" + data[3]);
				}
				System.out.println("---------------------------------------------------------");
			}else if(select.equals("2")) {		
				// 상세보기
				boolean isFinish = false;
				int search, selection;
				System.out.println("---------------------------------------------------------");
				System.out.println("학번을 입력하여 해당 학생의 상세한 성적정보를 확인할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					search = sc.nextInt();
					if(isContain(search)) {
						String[] data = getDetail(search);
						System.out.println("---------------------------------------------------------");
						System.out.println("학번: " + data[0]);
						System.out.println("전체 총점: " + data[1]);
						System.out.println("개인 평균/전체 평균: " + data[2] + "/" + data[3]);
						System.out.println("학점: " + data[4]);
						System.out.println("---------------------------------------------------------");
						isFinish = true;
					}else {
						System.out.print("존재하지 않는 학번입니다! 다시 입력: 1  이전 메뉴: 0  > ");
						selection = sc.nextInt();
						if(selection == 0) {
							isFinish = true;
						}else if(selection == 1) {
							System.out.println("입력을 계속합니다");	
						}
					}
				}
				
			}else if(select.equals("3")) {
				// 입력
				int id = 0;
				int ml, eng, math;
				System.out.println("------------------------------------------------");
				System.out.println("학번과 과목별 시험점수를 입력해주세요!");
				
				// 유효성 검사 진행(중복 학번 체크)
				while(true) {
					System.out.print("학번> ");
					int temp = sc.nextInt();
					if(isContain(temp)) {
						System.out.println("이미 존재하는 학번입니다! 다시 입력하세요!");
					}else {
						id = temp;
						break;
					}
				}
				
				// 유효성 검사 진행(과목 점수 입력)
				while(true) {
					System.out.print("국어> ");
					int temp = sc.nextInt();
					if((temp > 100) || (temp < 0)) {
						System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
					}else {
						ml = temp;
						break;
					}
				}
				
				// 유효성 검사 진행(과목 점수 입력)
				while(true) {
					System.out.print("영어> ");
					int temp = sc.nextInt();
					if((temp > 100) || (temp < 0)) {
						System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
					}else {
						eng = temp;
						break;
					}
				}
				
				// 유효성 검사 진행(과목 점수 입력)
				while(true) {
					System.out.print("수학> ");
					int temp = sc.nextInt();
					if((temp > 100) || (temp < 0)) {
						System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
					}else {
						math = temp;
						break;
					}
				}
				Std Std = new Std(id, ml, eng, math);
				insertOne(Std);
				System.out.println("------------------------------------------------");
			}else if(select.equals("4")) {
				// 수정
				int id, ml, eng, math, selection;
				boolean isFinish = false;
				System.out.println("------------------------------------------------\n");
				System.out.println("학번을 입력하여 성적을 수정할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					id = sc.nextInt();
					if(isContain(id)) {
						// 유효성 검사 진행(과목 점수 입력)
						while(true) {
							System.out.print("국어> ");
							ml = sc.nextInt();
							if((ml > 100) || (ml < 0)) {
								System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
							}else {
								break;
							}
						}
						
						// 유효성 검사 진행(과목 점수 입력)
						while(true) {
							System.out.print("영어> ");
							eng = sc.nextInt();
							if((eng > 100) || (eng < 0)) {
								System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
							}else {
								break;
							}
						}
						
						// 유효성 검사 진행(과목 점수 입력)
						while(true) {
							System.out.print("수학> ");
							math = sc.nextInt();
							if((math > 100) || (math < 0)) {
								System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
							}else {
								break;
							}
						}
						Std Std = new Std(id, ml, eng, math);
						modify(Std);
						System.out.println(id + "번 학생의 성적을 수정하였습니다!\n");
						System.out.println("---------------------------------------------------------");
						isFinish = true;
					}else {
						System.out.print("존재하지 않는 학번입니다! 다시 입력: 1  이전 메뉴: 0  > ");
						selection = sc.nextInt();
						if(selection == 0) {
							isFinish = true;
						}else if(selection == 1) {
							System.out.println("입력을 계속합니다");	
						}
					}	
				}
			}else if(select.equals("5")) {
				boolean isFinish = false;
				int id, selection;
				System.out.println("------------------------------------------------\n");
				System.out.println("학번을 입력하여 학생 정보를 삭제할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					id = sc.nextInt();
					if(isContain(id)) {
						deleteOne(id);
						isFinish = true;
						System.out.println(id + "번 학생의 정보를 삭제하였습니다!\n");
					}else {
						System.out.print("존재하지 않는 학번입니다! 다시 입력: 1  이전 메뉴: 0  > ");
						selection = sc.nextInt();
						if(selection == 0) {
							isFinish = true;
						}else if(selection == 1) {
							System.out.println("입력을 계속합니다");
						}
					}
				}
				System.out.println("------------------------------------------------\n");
			}else {
				System.out.println("잘못된 입력입니다! 0번에서 5번까지만 입력할 수 있습니다!");
			}	
		}
	}

	// 학생 정보 DB에 저장하는 메소드
	public static void insertOne(Std std) {
		while(true) {
			try {
				client = new MongoClient("127.0.0.1");
				MongoDatabase db = client.getDatabase("student");
				MongoCollection<Document> coll = db.getCollection("gradeTable");
				
				Document doc = new Document();
				doc.append("_id", std.getId());
				doc.append("ml", std.getMl());
				doc.append("eng", std.getEng());
				doc.append("math", std.getMath());
				doc.append("avg", std.getAvg());
				doc.append("grade", std.getGrade());
				
				coll.insertOne(doc);
				break;
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}finally {
				client.close();
			}
		}
	}
	
	// 학생 정보 DB에서 꺼내 출력하는 메소드
	public static ArrayList<String[]> totalShow() {
		ArrayList<String[]> result = new ArrayList<>();
		while(true) {
			try{
				client = new MongoClient("127.0.0.1");
				MongoDatabase db = client.getDatabase("student");
				MongoCollection<Document> coll = db.getCollection("gradeTable");
				
				FindIterable<Document> rs = coll.find().sort(new Document().append("_id", 1));
				MongoCursor<Document> ite = rs.iterator();
				
				while(ite.hasNext()) {
					try {
						Document finded = ite.next();
						String[] temp = {String.valueOf(finded.getInteger("_id")), String.valueOf(finded.getInteger("ml")),String.valueOf(finded.getInteger("eng")),String.valueOf(finded.getInteger("math")),String.valueOf(finded.getDouble("avg")),String.valueOf(finded.getString("grade")) };
						result.add(temp);	
					}catch(Exception e) {
						e.printStackTrace();
						continue;
					}
				}
				
				break;
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}finally {
				client.close();
			}
		}
		return result;
	}
	
	// 상세보기를 위한 메소드
	public static String[] getDetail(int id) {
		String[] data = new String[5];
		
		while(true) {
			try {
				client = new MongoClient("127.0.0.1");
				MongoDatabase db = client.getDatabase("student");
				MongoCollection<Document> coll = db.getCollection("gradeTable");
				
				FindIterable<Document> rs = coll.find(new Document().append("_id", id));
				MongoCursor<Document> ite= rs.iterator();
				
				// 전체 학생 평균을 구하기 위해 전체 document 조회
				FindIterable<Document> trs = coll.find();
				MongoCursor<Document> tite= trs.iterator();
				
				Double sum = 0.0;
				Double avg = 0.0;
				int idx = 0;
				
				// 전체 학생 평균을 구하기 위한 코드
				while(tite.hasNext()) {
					Document temp = tite.next();
					sum += temp.getDouble("avg");
					idx++;
				}
				
				avg = (int)((sum / idx)*100)*0.01;
							
				if(ite.hasNext()) {
					Document doc = ite.next();
					Std std = new Std(doc.getInteger("_id"), doc.getInteger("ml"), doc.getInteger("eng"), doc.getInteger("math"));
					data[0] = String.valueOf(doc.getInteger("_id"));
					data[1] = String.valueOf(std.getSum());
					data[2] = String.valueOf(doc.getDouble("avg"));
					data[3] = String.valueOf(avg);
					data[4] = String.valueOf(doc.getString("grade"));
				}
				break;
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}finally {
				client.close();
			}
		}
		return data;
	}
	
	// 중복된 학번 체크를 위한 메소드
	public static boolean isContain(int id) {
		int contained = 0;
		Document result = new Document();
		while(true) {
			try{
				client = new MongoClient("127.0.0.1");
				MongoDatabase db = client.getDatabase("student");
				MongoCollection<Document> coll = db.getCollection("gradeTable");
				
				FindIterable<Document> rs = coll.find(new Document().append("_id", id));
				MongoCursor<Document> ite = rs.iterator();
				if(ite.hasNext()) {
					result = ite.next();
					contained = result.getInteger("_id");
				}
				break;
			}catch(Exception e){
				e.printStackTrace();
				continue;
			}finally {
				client.close();
			}
		}
		if(contained != 0) return true;
		else return false;
	}
	
	// 수정을 위한 메소드
	public static void modify(Std std) {
		Document criteria = new Document();
		Document updateSet = new Document();
		
		while(true) {
			try {
				criteria.append("_id", std.getId());
				Document middle = new Document();
				middle.append("ml", std.getMl());
				middle.append("eng", std.getEng());
				middle.append("math", std.getMath());
				middle.append("avg", std.getAvg());
				middle.append("grade", std.getGrade());
				updateSet.append("$set", middle);
				client = new MongoClient("127.0.0.1");
				MongoDatabase db = client.getDatabase("student");
				MongoCollection<Document> coll = db.getCollection("gradeTable");
				coll.updateOne(criteria, updateSet);
				break;
			}catch(Exception e) {
				e.printStackTrace();
				continue;
			}finally {
				client.close();
			}
		}	
	}
	
	// 삭제를 위한 메소드
	public static void deleteOne(int id) {
		try {
			client = new MongoClient("127.0.0.1");
			MongoDatabase db = client.getDatabase("student");
			MongoCollection<Document> coll = db.getCollection("gradeTable");
			
			coll.deleteOne(new Document().append("_id", id));
		}finally {
			client.close();
		}
	}
}
