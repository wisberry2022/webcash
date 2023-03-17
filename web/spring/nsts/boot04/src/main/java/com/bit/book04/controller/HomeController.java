package com.bit.book04.controller;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.bit.boot04.model.DeptVo;
import com.bit.boot04.service.DeptService;

@CrossOrigin
@Controller
public class HomeController {

	private DeptService deptService;
	
	public HomeController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	
	@GetMapping("/")
	public ResponseEntity<?> index() {
//		ResponseEntity resp = new ResponseEntity(, HttpStatus.OK);
		return ResponseEntity.ok(deptService.selectAll());
	}
	
	   @PostMapping   
	   public ResponseEntity add(@ModelAttribute("bean") DeptVo bean){
	      try {
	         deptService.insertOne(bean);
	      }catch(Exception e) {
	         return ResponseEntity.badRequest().build();
	      }
	      return ResponseEntity.ok().build();
	   }
	//   @GetMapping("/{deptno}")
	//   public ResponseEntity<?> detail(@PathVariable("deptno") int deptno) {
//	      
//	      DeptVo bean = deptService.selectOne(deptno);
//	      if(bean!=null)
//	      return ResponseEntity.ok(bean);
//	      else
//	         return ResponseEntity.notFound().build();   
	//   }
	   @PutMapping("/{deptno}")
	//   public ResponseEntity<?> edit(@ModelAttribute DeptVo bean){
	   public ResponseEntity<?> edit(@RequestBody DeptVo bean, HttpServletRequest req) throws URISyntaxException{
	      if(deptService.updateOne(bean)>0) {
	         RestTemplate template = new RestTemplate();
	         URI url = new URI(req.getRequestURL().toString());
//	         String url=req.getRequestURI();
	         RequestEntity param = new RequestEntity(HttpMethod.GET,url);
	         
	         return template.exchange(url, HttpMethod.GET,param,DeptVo.class);
	      }
	      return ResponseEntity.badRequest().build();
	   }
	   
	   @DeleteMapping("/{deptno}")
	   public ResponseEntity<?> delete(@PathVariable("deptno") int deptno){
	      if(deptService.deleteOne(deptno)>0)
	         return ResponseEntity.ok().build();
	      return ResponseEntity.internalServerError().build();
	      
	   }

}
