package com.kh.thymeleaf.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.thymeleaf.model.dto.PersonDTO;

import jakarta.servlet.http.HttpSession;

@Controller
public class PracticeController {

	// [GET방식] "/go" 요청을 매핑
	@GetMapping("go")
	public String PracticePage() {
		
		
		/*
		 * *Thymeleaf 사용 시 기본 설정 값
		 * 	=> classpath : src/main/resources/
		 * 	- prefix : classpath:templates/
		 * 	- suffix : .html
		 */
		return "practice/page1";
	}
	
	/*
	 * [POST] / add
	 * 	{name: 이름, age: 나이, birth: 생년월일, hobby: 취미, ...}
	 */
	@PostMapping("add")
	public String resultPage(
							// HttpServletRequest request, 
							// String name, @RequestParam(defaultValue="20") int age, @RequestParam("birth") String birth, String[] hobbies,
							PersonDTO person,
							Model model, HttpSession session) {
		/*
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String birth = request.getParameter("birth");
		
		String[] hobbies = request.getParameterValues("hobby");
		*/
		
		/*
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		System.out.println("birth : " + birth);
		System.out.println("hobbies : " + Arrays.toString(hobbies));
		*/

		System.out.println("name : " + person.getName());
		System.out.println("age : " + person.getAge());
		System.out.println("birth : " + person.getBirth());
		System.out.println("hobbies : " + person.getHobby());
		
		/*
		model.addAttribute(name);
		model.addAttribute(age);
		model.addAttribute(birth);
		model.addAttribute(hobbies);
		*/

		/*
		model.addAttribute(person.getName());
		model.addAttribute(person.getAge());
		model.addAttribute(person.getBirth());
		model.addAttribute(person.getHobby());
		*/
		
		// Model : 스프링에서 제공하는 객체로, request 영역에 데이터 저장
		
		// * request 영역에 전달받은 데이터를 "p" 키값으로 저장
		model.addAttribute("p", person);
		// * session 영역에 전달받은 데이터를 "user" 키값으로 저장
		session.setAttribute("user", person);
		
		// * 임의의 데이터를 리스트에 담아 request 영역에 "personList" 키값으로 저장
		ArrayList<PersonDTO> personList = new ArrayList<>();
		personList.add(new PersonDTO("아이유", 20, "2005-03-27"));
		personList.add(new PersonDTO("공유", 20, "2005-11-17"));
		personList.add(new PersonDTO("이병헌", 20, "2005-10-20"));
		personList.add(new PersonDTO("임한별", 20, "2005-09-05"));
		
		model.addAttribute("personList", personList);
		
		return "practice/page2";
		
	}
	
}
