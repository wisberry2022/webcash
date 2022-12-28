package com.priv;

import java.io.*;

class FileHandler {
	private File readFile;
	private File writeFile;
	private InputStream is = null;
	private OutputStream os = null;
	private BufferedInputStream bis = null;
	private BufferedOutputStream bos = null;
	
	public FileHandler() {}
	
	public FileHandler(String readFile) {
		this.readFile = new File(readFile);
	}
	
	public FileHandler(String readFile, String writeFile) {
		this.readFile = new File(readFile);
		this.writeFile = new File(writeFile);
	}
	
	public void setRead(String readFile) {
		this.readFile = new File(readFile);
	}
	
	public void setWrite(String writeFile) {
		this.writeFile = new File(writeFile);
	}
	
	public void setRW(String readFile, String writeFile) {
		this.readFile = new File(readFile);
		this.writeFile = new File(writeFile);
	}
	
	public void settingInput() {
		try {
			is = new FileInputStream(readFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void settingBis() {
		bis = new BufferedInputStream(is);
	}
	
	public void settingBos() {
		bos = new BufferedOutputStream(os);
	}
	
	public void settingOutput() {
		try {
			os = new FileOutputStream(writeFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void read() {
		byte[] bArr = new byte[(int)this.readFile.length()/2];
		try {
			int su;
			while(true) {
				su = is.read(bArr);
				if(su == -1) break;
			}
			String msg = new String(bArr);
			System.out.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void Bufferead() {
		byte[] bArr = new byte[(int)this.readFile.length()/2];
		try {
			int su;
			while(true) {
				su = bis.read(bArr);
				if(su == -1) break;
			}
			String msg = new String(bArr);
			System.out.print(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String msg) {
		try {
			if(!this.writeFile.exists()) this.writeFile.createNewFile();
			byte[] bArr = msg.getBytes();
			os.write(bArr);
			System.out.println("WRITE END");
		}catch (IOException e) {	
			e.printStackTrace();
		} 
	}
	
	public void bufferWrite(String msg) {
		try {
			if(!this.writeFile.exists()) this.writeFile.createNewFile();
			byte[] bArr = msg.getBytes();
			bos.write(bArr);
			System.out.println("WRITE END");
		}catch (IOException e) {	
			e.printStackTrace();
		} 
	}
	
	// io close 메소드
	public void iClose() {
		try {
			if(is != null) is.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void bisClose() {
		if(bis != null)
			try {
				bis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void oClose() {
		try {
			if(os != null) os.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void bosClose() {
		try {
			if(bos != null) bos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void ioClose() {
		try {
			if(is != null) this.is.close();
			if(os != null) this.os.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}	
}


public class Priv03 {
	public static void main(String[] args) {
		
//		FileHandler fh = new FileHandler("target01.txt");
//		fh.settingInput();
//		fh.read();
//		fh.iClose();
		
		String msg = "안녕하세요!";
		FileHandler fh2 = new FileHandler();
		fh2.setWrite("testWrite2.txt");
		fh2.settingOutput();
		fh2.settingBos();
		fh2.bufferWrite(msg);
		fh2.bosClose();
		fh2.oClose();
	}
}
