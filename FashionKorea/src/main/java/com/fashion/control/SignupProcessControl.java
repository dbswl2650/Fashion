package com.fashion.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fashion.dao.LoginDAO;
import com.fashion.vo.MemberVO;

public class SignupProcessControl implements Control {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 설정
        request.setCharacterEncoding("UTF-8");

        // 폼 데이터 가져오기
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String pw = request.getParameter("pw");
        String confirmPw = request.getParameter("confirm_upw");
        String mail = request.getParameter("mail");
        String phone = request.getParameter("phone");
        String age = request.getParameter("age");
        String address = request.getParameter("add");

        // 서버 측 검증
        if (name == null || name.trim().isEmpty() ||
            id == null || id.trim().isEmpty() ||
            pw == null || pw.trim().isEmpty() ||
            !pw.equals(confirmPw) ||
            mail == null || mail.trim().isEmpty() ||
            phone == null || phone.trim().isEmpty() ||
            age == null || age.trim().isEmpty() ||
            address == null || address.trim().isEmpty()) {
            request.setAttribute("error", "올바르게 입력해주세요.");
            request.getRequestDispatcher("WEB-INF/html/signup.jsp").forward(request, response);
            return;
        }

        // MemberVO 객체 생성
        MemberVO member = new MemberVO();
        member.setMemberName(name);
        member.setMemberId(id);
        member.setMemberPw(pw);
        member.setMemberMail(mail);
        member.setMemberPhone(phone);
        member.setMemberAge(age);
        member.setMemberAdd(address);

        // DAO 호출
        LoginDAO ldao = new LoginDAO();
        boolean isInserted = ldao.insertMember(member);

        // 회원가입 결과에 따라 메인 페이지 이동
        if (isInserted) {
            response.sendRedirect(request.getContextPath() + "/main.ko");
        } else {
            request.setAttribute("error", "회원가입에 실패했습니다.");
            request.getRequestDispatcher("WEB-INF/html/signup.jsp").forward(request, response);
        }
        System.out.println("폼 데이터 확인: ");
        System.out.println("이름: " + name);
        System.out.println("아이디: " + id);
        System.out.println("비밀번호: " + pw);
        System.out.println("비밀번호 확인: " + confirmPw);
        System.out.println("메일: " + mail);
        System.out.println("휴대폰번호: " + phone);
        System.out.println("생년월일: " + age);
        System.out.println("주소: " + address);
    }
}
