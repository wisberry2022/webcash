package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 학번, 국어(ml), 영어(eng), 수학(math) 정보를 담고 있는 학생 Class
class Student implements Serializable, Comparable<Object> {
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

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return this.id - ((Student)o).id;
	}
}

// 메인 클래스
public class Ex23 {
	static Set<Student> DataSet = new TreeSet<>();
	
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
				Iterator<Student> ite = DataSet.iterator();
				System.out.println("---------------------------------------------------------");
				System.out.println("학번\t국어\t영어\t수학");
				while(ite.hasNext()) {
					Student data = ite.next();
					System.out.println(data.getId() + "\t" + data.getMl() + "\t" + data.getEng() + "\t" + data.getMath() + "\t");
				}
				System.out.println("---------------------------------------------------------");
			}else if(select.equals("2")) {
				boolean isFinish = false;
				int search;
				int tsum = 0;
				double tavg = 0.0;
				Iterator<Student> ite =DataSet.iterator();
				while(ite.hasNext()) {
					Student info = ite.next();
					tsum += info.getAvg();
				}
				tavg = (int)(tsum*100 / (float)(DataSet.size())) * 0.01; 
				
				System.out.println("---------------------------------------------------------");
				System.out.println("학번을 입력하여 해당 학생의 상세한 성적정보를 확인할 수 있습니다!");
				System.out.print("학번> ");
				search = sc.nextInt();
				Iterator<Student> vite = DataSet.iterator();
				while(vite.hasNext()) {
					Student std = vite.next();
					if(std.getId() == search) {
						System.out.println("---------------------------------------------------------");
						System.out.println("학번: " + std.getId());
						System.out.println("전체 총점: " + std.getSum());
						System.out.println("개인 평균/전체 평균: " + std.getAvg() + "/" + tavg);
						System.out.println("학점: " + std.getGrade());
						isFinish = true;
					}
				}
				if(!isFinish) {
					System.out.println("일치하는 학번이 없습니다!");
				}
				System.out.println("---------------------------------------------------------");
			}else if(select.equals("3")) {
				boolean isFinish = false;
				boolean isDup = false;
				int id = 0;
				int ml, eng, math;
				System.out.println("------------------------------------------------");
				System.out.println("학번과 과목별 시험점수를 입력해주세요!");
				
				// 유효성 검사 진행(중복 학번 체크)
				while(!isFinish) {
					isDup = false;
					System.out.print("학번> ");
					int temp = sc.nextInt();
					Iterator<Student> checker = DataSet.iterator();
					while(checker.hasNext()) {
						Student std = checker.next();
						if(std.getId() == temp) {
							System.out.println("이미 존재하는 학번입니다! 다시 입력하세요!");
							isDup = true;
						}
					}
					if(!isDup) {
						id = temp;
						isFinish = true;
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
				DataSet.add(new Student(id, ml, eng, math));
				System.out.println("------------------------------------------------");
			}else if(select.equals("4")) {
				boolean isFinish = false;
				int id, ml, eng, math, selection;
				System.out.println("------------------------------------------------\n");
				System.out.println("학번을 입력하여 성적을 수정할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					id = sc.nextInt();
					Iterator<Student> modifier = DataSet.iterator();
					while(modifier.hasNext()) {
						Student std = modifier.next();
						if(id == std.getId()) {
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
							isFinish = true;
							System.out.println("---------------------------------------------------------");
						}
					}
					if(!isFinish) {
						System.out.println("일치하는 학번이 없습니다!");
						System.out.println("---------------------------------------------------------");
						break;
						
					}
				}
			}else if(select.equals("5")) {
				boolean isFinish = false;
				int id;
				Student temp = null;
				System.out.println("------------------------------------------------\n");
				System.out.println("학번을 입력하여 학생 정보를 삭제할 수 있습니다!");
				while(!isFinish) {
					System.out.print("학번> ");
					id = sc.nextInt();
					Iterator<Student> remover = DataSet.iterator();
					while(remover.hasNext()) {
						Student std = remover.next();
						if(std.getId() == id) {
							temp = std;				
							System.out.println(id + "번 학생의 정보를 삭제하였습니다!\n");
							isFinish = true;
						}
					}
					DataSet.remove(temp);
					if(!isFinish) {
						System.out.println("학생 정보가 없습니다!");
						isFinish = true;
					}
				}
				System.out.println("\n------------------------------------------------\n");
			}else {
				System.out.println("잘못된 입력입니다! 0번에서 5번까지만 입력할 수 있습니다!");
			}	
		}
	}

	// 프로그램 시작 시 DB file(StudentDB.txt) 읽어들인 뒤 자료구조에 담는 메소드
	public static void startRead() {
		InputStream is = null;
		ObjectInputStream ois = null;
		
		try {
			is = new FileInputStream("student.bin");
			ois = new ObjectInputStream(is);
			
			while(true) {
				Student std = (Student) ois.readObject();
				DataSet.add(std);
			}
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		} catch (ClassNotFoundException e) {
		}catch(Exception e) {
			return;
		}
		finally {
			try {
				if(ois != null) ois.close();
				if(is != null) is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 학생 정보 File DB(studentDB.txt)로 출력
	public static void endWrite() {
		OutputStream os = null;
		ObjectOutputStream oos = null;
		
		try {
			os = new FileOutputStream("student.bin");
			oos = new ObjectOutputStream(os);
			
			Iterator<Student> write = DataSet.iterator();
			while(write.hasNext()) {
				Student data = write.next();
				oos.writeObject(data);
			}
			
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}finally {
			try {
				if(oos != null) oos.close();
				if(os != null) os.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
