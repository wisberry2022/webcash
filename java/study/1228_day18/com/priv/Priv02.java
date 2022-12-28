package com.priv;

import java.io.*;

public class Priv02 {

	public static void main(String[] args) {
		File fdb = new File("부산광역시.txt");
		File target = new File("target01.txt");
		
		byte[] arr = new byte[(int)fdb.length()];
		InputStream is = null;
		OutputStream os = null;
		BufferedInputStream bis;
		BufferedOutputStream bos;
		
		try {
			if(fdb.exists()) {
				is = new FileInputStream(fdb);
				bis = new BufferedInputStream(is);
				os = new FileOutputStream(target);
				bos = new BufferedOutputStream(os);
				
				int su;
				while(true) {
					su = bis.read(arr);
					if(su == -1) break;
				}
				
				String msg = new String(arr);
				
				String[] msgSet = msg.split("\n");
				String num = "46706";
				int[] idxSet = new int[] {0,1,3,5,7,8,16,17,19};
				
				String writeMsg = "";
				
				for(int i = 0; i<msgSet.length; i++) {
					String[] data = msgSet[i].split("\\|");
					if(data[0].equals(num)) {
						for(int j = 0; j < idxSet.length; j++) {
							if(j == idxSet.length-1) {
								writeMsg += data[idxSet[j]] + "\n";	
							}else {
								writeMsg += data[idxSet[j]] + "\t";	
							}
							System.out.print(data[idxSet[j]] + " ");
						}
						System.out.println();
					}
				}
				
				byte[] bArr = writeMsg.getBytes();
				
				bos.write(bArr);
				
				if(bos != null) bos.close();
				if(os != null) os.close();
				if(bis != null) bis.close();
				if(is != null) is.close();
				System.out.println("END!");
			}else {
				System.out.println("파일 없음");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
