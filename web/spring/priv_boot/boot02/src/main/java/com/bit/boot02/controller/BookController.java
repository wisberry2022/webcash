package com.bit.boot02.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.text.ParseException;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.bit.boot02.model.BookDao;
import com.bit.boot02.model.entity.BookVo;

@Controller
@RequestMapping("/book")
public class BookController {

	private String repo = "E:\\java\\priv_spring\\boot02\\upload\\";
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@GetMapping("/add")
	public String add() {
		return "book/add";
	}
	
	@PostMapping("/add")
	public String add(String name, String author, @RequestParam("uploadFile") MultipartFile uploadFile, MultipartHttpServletRequest mreq) throws IllegalStateException, IOException {
//		System.out.println("mreq-getLocalAddr: " + mreq.getLocalAddr());
//		System.out.println("mreq-getRequestUrlr: " + mreq.getRequestURL());
//		System.out.println("mreq-getFile: " + mreq.getFile("uploadFile"));
			
		String filename = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
		String file = repo  + filename;
		File f = new File(file);
		uploadFile.transferTo(f);
		
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			sqlSession.getMapper(BookDao.class).insertOne(name, author, filename);
			return "redirect:/";
		}	
	}
	
	
	@GetMapping("/detail")
	public String detail(int num, Model model) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		){	
			BookVo book = sqlSession.getMapper(BookDao.class).selectOne(num);
			book.setUploadFile(book.getUploadFile().split("_")[1]);
			model.addAttribute("book", book);
			return "book/detail";
		}
	}
	
	@GetMapping("/download")
	public void download(int num, HttpServletResponse resp) throws IOException {
//		String filename = repo + file;
		String filename = null;
		String file = null;
		
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		) {
			BookVo book = sqlSession.getMapper(BookDao.class).selectOne(num);
			file = book.getUploadFile();
			filename = repo + file;
		}
		
		File f = new File(filename);
		int su = -1;
		resp.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(file.split("_")[1], "utf-8"));
		if(f.exists()) {
			try(
					InputStream is = new FileInputStream(f);
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr);
					OutputStream os = resp.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(os);
					BufferedWriter bw = new BufferedWriter(osw);
			){
					while((su = br.read()) != -1) {
						bw.write(su);
					}
			}
		}
	}
	
	@GetMapping("/edit")
	public String edit(int num, Model model) {
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
			){	
				BookVo book = sqlSession.getMapper(BookDao.class).selectOne(num);
				model.addAttribute("book", book);
				return "book/edit";
			}
	}
	
	
	@PutMapping("/edit")
	public String edit(int num, String name, String author, String publish, MultipartFile uploadFile, MultipartHttpServletRequest mreq) throws ParseException, IllegalStateException, IOException {
		String filename = null;
		try(
				SqlSession sqlSession = sqlSessionFactory.openSession();
		){
			System.out.println("put of edit: " + uploadFile.getOriginalFilename());
			if(uploadFile.getOriginalFilename() != null) {
				filename = System.currentTimeMillis() + "_" + uploadFile.getOriginalFilename();
				String file = repo + filename;
				File f = new File(file);
				uploadFile.transferTo(f);
				BookVo book = sqlSession.getMapper(BookDao.class).selectOne(num);
				String before = book.getUploadFile();
				System.out.println("before file: " + before);
				File bf = new File(repo + before);
				if(bf.exists()) {
					bf.delete();
				}
			}
						
			sqlSession.getMapper(BookDao.class).updateOne(new BookVo(num, name, author, publish, filename));
		}
		return "redirect:/";
	}
	
	
	@GetMapping("/delete")
	public String delete(int num) {
		try(
			SqlSession sqlSession = sqlSessionFactory.openSession();
		) {
			BookVo book = sqlSession.getMapper(BookDao.class).selectOne(num);
			String filename = book.getUploadFile();
			
			File f = new File(repo + filename);
			
			if(f.exists()) {
				f.delete();
			}
			
			sqlSession.getMapper(BookDao.class).deleteOne(num);
		}
		return "redirect:/";
	}
}
