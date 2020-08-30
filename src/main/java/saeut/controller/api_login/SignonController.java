package saeut.controller.api_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import saeut.domain.Account;
import saeut.domain.LoginInfo;
import saeut.service.facade.MyPageFacade;

@RestController
public class SignonController {  
//	로그인 및 회원가입 컨트롤러 
//	sign in : 로그인 , sign up : 회원가입
//	
	@Autowired
	private MyPageFacade myPageFacade;
	
	
	@PostMapping("/api/members")   
	public ResponseEntity<String> signIn (@RequestBody LoginInfo loginInfo) { 
		//아이디 패스워드만 받는 객체 생성. 
		//근데 의문.. 왜로그인 여부만 판단. 안드에서 그럼 t/f로 다시 어카운트 정보를 리드 하는거야?? 
		ResponseEntity<String>  resEntity = null;
		Account account_result = myPageFacade.getAccountByUserIdAndPassword(loginInfo);
	
		if (account_result == null) { // 로그인 실패 시 false 반환 
			try { 
				//resEntity = new ResponseEntity("false", HttpStatus.OK);
				resEntity = ResponseEntity.status(HttpStatus.OK).body("false");
			}catch(Exception e) {
				resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
			}
		}else {  //로그인 성공하면 true 반환 
			try { 
				resEntity = ResponseEntity.status(HttpStatus.OK).body("true");
			}catch(Exception e) {
				resEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body((e.getMessage()));
			}
		}
		return resEntity;
	}	
	
	

	
	
	
}
	
