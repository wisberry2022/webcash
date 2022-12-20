package com.bit;

public class Ex07 {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Object obj = new Object();
		// 클래스에 대한 정보를 가지는 객체(Class)
		Class cls = obj.getClass();
		Class cls2 = Object.class;
		System.out.println(cls2);
		
		Ex07 me = new Ex07();
		Class cls3 = me.getClass();
		Class cls4 = Ex07.class;
		
		System.out.println(cls3 + " " + cls4);
		
		Class cls5 = Class.forName("com.bit.Priv01");
		System.out.println(cls5);
		
		Object obj2 = cls5.newInstance();
		System.out.println(obj2);
		com.bit.Priv01 priv = (com.bit.Priv01)obj2;
		priv.funcPriv();
		

	}

}
