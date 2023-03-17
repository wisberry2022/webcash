package com.bit.book04.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.boot04.model.DeptVo;
import com.bit.boot04.service.DeptService;
	
@CrossOrigin
@RestController
@RequestMapping("/api/")
public class DeptController {

	private DeptService deptService;
	
	public DeptController(DeptService deptService) {
		this.deptService = deptService;
	}
	
	@GetMapping
	public ResponseEntity selectAll() {
		return ResponseEntity.ok(deptService.selectAll());
	}
	
   @PostMapping   
   public ResponseEntity<?> add(@ModelAttribute("bean") DeptVo bean){
      try {
         deptService.insertOne(bean);
      }catch(Exception e) {
         return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok().build();
   }
	   @GetMapping("/{deptno}")
	   public ResponseEntity<?> detail(@PathVariable("deptno") int deptno) {
	      
	      DeptVo bean = deptService.selectOne(deptno);
	      if(bean!=null) return ResponseEntity.ok(bean);
	      
	      else
	         return ResponseEntity.notFound().build();   
	   }
	   @PutMapping("/{deptno}")
	   public ResponseEntity<?> edit(@RequestBody DeptVo bean){
		   System.out.println(bean.toString());
	      if(deptService.updateOne(bean)>0)
	         return ResponseEntity.ok(bean);
	      return ResponseEntity.badRequest().build();
	   }
	   
	   @DeleteMapping("/{deptno}")
	   public ResponseEntity<?> delete(@PathVariable("deptno") int deptno){
	      if(deptService.deleteOne(deptno)>0)
	         return ResponseEntity.ok().build();
	      return ResponseEntity.internalServerError().build();
	      
	   }

}
