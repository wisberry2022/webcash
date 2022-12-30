package com.test;

import java.util.*;
import java.io.*;

// 학번, 국어(ml), 영어(eng), 수학(math) 정보를 담고 있는 학생 Class
class Student {
	private int id;
	private int ml;
	private int eng;
	private int math;
	
	public Student(int id, int ml, int eng, int math) {
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
public class test {
	static File DB = new File("studentDB.txt");
	static Map<Integer, Student> DataSet = new TreeMap<>();
	
	// 메인메소드
	public static void main(String[] args) {
		// 학생 DB 읽기
		startRead();
		System.out.println("학생성적관리프로그램(ver 0.5.0)");
		String select;
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.print("1.리스트    2.상세보기    3.입력    4.수정    5.삭제    0.종료  >");
			select = sc.nextLine();
			if(select.equals("0")) {
				endWrite();
				System.out.println("이용해주셔서 감사합니다!");
				return;
			}else if(select.equals("1")) {
				Collection<Student> datas = DataSet.values();
				Iterator<Student> ite = datas.iterator();
				System.out.println("---------------------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				while(ite.hasNext()) {
					Student data = ite.next();
					System.out.println(data.getId() + "\t" + data.getMl() + "\t" + data.getEng() + "\t" + data.getMath() + "\t");
				}
				System.out.println("---------------------------------------------------------");
			}else if(select.equals("2")) {
				boolean isFinish = false;
				int search, selection;
				int tsum = 0;
				double tavg = 0.0;
				Collection<Student> values = DataSet.values();
				Iterator<Student> ite =values.iterator();
				while(ite.hasNext()) {
					Student info = ite.next();
					tsum += info.getAvg();
				}
				tavg = (int)(tsum*100 / (float)(DataSet.size())) * 0.01; 
				
				System.out.println("---------------------------------------------------------");
				System.out.println("학번을 입력하여 해당 학생의 상세한 성적정보를 확인할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					search = sc.nextInt();
					if(DataSet.containsKey(search)) {
						Student std = DataSet.get(search);
						System.out.println("---------------------------------------------------------");
						System.out.println("학번: " + std.getId());
						System.out.println("전체 총점: " + std.getSum());
						System.out.println("개인 평균/전체 평균: " + std.getAvg() + "/" + tavg);
						System.out.println("학점: " + std.getGrade());
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
				int id = 0;
				int ml, eng, math;
				System.out.println("------------------------------------------------");
				System.out.println("학번과 과목별 시험점수를 입력해주세요!");
				
				// 유효성 검사 진행(중복 학번 체크)
				while(true) {
					System.out.print("학번> ");
					int temp = sc.nextInt();
					if(DataSet.containsKey(temp)) {
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
				DataSet.put(id, new Student(id, ml, eng, math));
				System.out.println("------------------------------------------------");
			}else if(select.equals("4")) {
				int id, ml, eng, math, selection;
				boolean isFinish = false;
				System.out.println("------------------------------------------------\n");
				System.out.println("학번을 입력하여 성적을 수정할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					id = sc.nextInt();
					if(DataSet.containsKey(id)) {
						Student std = DataSet.get(id);
						// 유효성 검사 진행(과목 점수 입력)
						while(true) {
							System.out.print("국어> ");
							ml = sc.nextInt();
							if((ml > 100) || (ml < 0)) {
								System.out.println("시험 점수는 0 ~ 100 사이 숫자만 입력받습니다!");
							}else {
								std.setMl(ml);
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
								std.setEng(eng);
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
								std.setMath(math);
								break;
							}
						}
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
					if(DataSet.containsKey(id)) {
						DataSet.remove(id);
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

	// 프로그램 시작 시 DB file(StudentDB.txt) 읽어들인 뒤 자료구조에 담는 메소드
	public static void startRead() {
		InputStream is = null;
		BufferedInputStream bis = null;
		
		try {
			if(!DB.exists()) {
				DB.createNewFile();
				return;
			}
			is = new FileInputStream(DB);
			bis = new BufferedInputStream(is);
			
			byte[] bArr = new byte[(int)DB.length()/5];
			
			int su;
			String msg = "";
			// BufferedInputStream 사용하여 파일 데이터를 바이트 배열에 담아 String으로 변환하는 작업
			while(true) {
				su = bis.read(bArr);
				if(su == -1) break;
				byte[] temp = new byte[su];
				for(int i = 0; i<su; i++) {
					temp[i] = bArr[i];
				}
				msg += new String(temp);
			}
			
			// 파일 데이터에서 읽어들였던 데이터를 String으로 변환하고, string parsing하여 새로운 Student 객체를 생성하고 자료구조에 새롭게 담는 메소드
			String[] rawData = msg.split("\n");
			int id, ml, eng, math;	
		
			for(int i = 1; i<rawData.length; i++) {
				String[] data = rawData[i].split("\t");
				id = Integer.parseInt(data[0]);
				ml = Integer.parseInt(data[1]);
				eng = Integer.parseInt(data[2]);
				math = Integer.parseInt(data[3]);
				DataSet.put(id, new Student(id, ml, eng, math));	
			}
			
			if(bis != null) bis.close();
			if(is != null) is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// 학생 정보 File DB(studentDB.txt)로 출력
	public static void endWrite() {
		OutputStream os = null;
		BufferedOutputStream bos = null;

		try {
			if(!DB.exists()) DB.createNewFile();
			os = new FileOutputStream(DB);
			bos = new BufferedOutputStream(os);
			
			String msg = "학번\t국어\t영어\t수학\n";
			
			Collection<Student> values = DataSet.values();
			Iterator<Student> ite = values.iterator();
			
			// 자료구조를 순회하면서 각 학생 객체들의 정보를 문자열로 저장한 뒤 byte 배열로 변환하여 BufferedOutputStream을 활용하여 지정된 파일(StudentDB.txt)로 출력
			while(ite.hasNext()) {
				Student std = ite.next();
				msg += std.getId() + "\t" + std.getMl() + "\t" + std.getEng() + "\t" + std.getMath() + "\n";
			}
			
			byte[] writeMSG = msg.getBytes();
			
			bos.write(writeMSG);
			
			if(bos != null) bos.close();
			if(os != null) os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
