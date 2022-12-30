package com.test;

import javax.swing.*;    
import java.awt.event.*;    
import java.io.*;

public class JavaNote1 implements ActionListener{    
    JFrame f;    
    JMenuBar mb;    
    JMenu file,edit;    
    JMenuItem cut,copy,paste,selectAll;    
    JTextArea ta;    
    JMenuItem i_save, i_load;

    JavaNote1(){    
        f=new JFrame("자바메모장");    
        cut=new JMenuItem("잘라내기");    
        copy=new JMenuItem("복사");    
        paste=new JMenuItem("붙이기");    
        selectAll=new JMenuItem("모두선택");    
        i_save = new JMenuItem("새로만들기");
        i_load = new JMenuItem("열기");
        cut.addActionListener(this);    
        copy.addActionListener(this);    
        paste.addActionListener(this);    
        selectAll.addActionListener(this); 
        i_save.addActionListener(this);
        i_load.addActionListener(this);
           
      
        mb=new JMenuBar();    
        file=new JMenu("파일");    
        edit=new JMenu("도움말");    
        
        edit.add(cut);edit.add(copy);edit.add(paste);edit.add(selectAll);
        file.add(i_save); file.add(i_load);
            
        mb.add(file);mb.add(edit);
        ta=new JTextArea();    
        ta.setBounds(5,5,360,320);    
        f.add(mb);f.add(ta);    
        f.setJMenuBar(mb);  
        f.setLayout(null);    
        f.setSize(400,400);    
        f.setVisible(true);    
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
}     

public void actionPerformed(ActionEvent e) {    
       if(e.getSource()==cut)    
           ta.cut();    

        if(e.getSource()==paste)    
           ta.paste();    

         if(e.getSource()==copy)    
            ta.copy();    

         if(e.getSource()==selectAll)    
             ta.selectAll();    
}     

public static void main(String[] args) {    
    new JavaNote1();    
  }    
}    