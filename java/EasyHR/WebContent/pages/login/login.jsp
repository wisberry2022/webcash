<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="wrapper">
        <section id="loginSection">
          <div class="container">
            <div class="loginBox">
              <div>
                <figure class="bg_set"></figure>
                <h3>로그인 하기</h3>
              </div>
              <form action="data/login/login.jsp" method="post">
                <div>
                  <label for="idbox" class="sr_only">아이디</label>
                  <input type="text" id="idbox" name="id" placeholder="아이디를 입력하세요" required />
                  <label for="pwdbox" class="sr_only">아이디</label>
                  <input type="password" id="pwdbox" name="pwd" placeholder="비밀번호를 입력하세요" required />
                </div>
                <button class="bl_btn">로그인하기</button>
              </form>
              <ul>
                <li><a href="#">아이디 찾기</a></li>
                <li><a href="#">비밀번호 찾기</a></li>
              </ul>
            </div>
          </div>
        </section>
      </div>