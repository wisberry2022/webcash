package com.bit.boot11;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.boot11.model.DeptVo;
import com.bit.boot11.utils.JwtUtil;

@RestController
@RequestMapping("/")
public class ApiController {

	@Autowired
	private JwtUtil jwtUtil;
	
	@GetMapping("/token")
	public String getToken() {
		return jwtUtil.createJwt("james", 1000*60*60);
	}
	
	@GetMapping("/api/dept")
	public ResponseEntity<?> getList() {
		return ResponseEntity.ok().body(
				List.of(
						DeptVo.builder().deptno(10).dname("test").loc("test").build(),
						DeptVo.builder().deptno(20).dname("test").loc("test").build(),
						DeptVo.builder().deptno(30).dname("test").loc("test").build()
				)
			);
	}
	
}
