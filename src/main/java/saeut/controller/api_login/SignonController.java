package saeut.controller.api_login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import saeut.domain.Account;
import saeut.service.facade.MyPageFacade;

@RestController
@RequestMapping("/signon")
public class SignonController {

	@Autowired
	private MyPageFacade myPageFacade;
	
	
	@RequestMapping(value = "/signon.do", method = RequestMethod.POST)
	public ResponseEntity<String> signOn (@RequestBody Account account) {
		
		ResponseEntity<String>  resEntity = null;
		Account account_result = myPageFacade.getAccountByUserIdAndPassword(account);
	
		if (account_result == null) { // 로그인 실패 시 false 반환 
			try {
				resEntity =new ResponseEntity("false", HttpStatus.OK);
			}catch(Exception e) {
				resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}else {  //로그인 성공하면 true 반환 
			try {
				resEntity = new ResponseEntity("true", HttpStatus.OK);
			}catch(Exception e) {
				resEntity = new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
			}
		}
		return resEntity;
	}	
}
	
