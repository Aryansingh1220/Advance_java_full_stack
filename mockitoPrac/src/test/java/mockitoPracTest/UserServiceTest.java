package mockitoPracTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.basics.User;
import com.basics.UserDao;
import com.basics.UserService;

public class UserServiceTest {
	
	@Test
	public void typeOfUser() {
		UserDao daoMock=mock(UserDao.class);
		 
		// create fake object
		User fackObject=new User();
		fackObject.setId(1);
		fackObject.setBalance(2000); 
		fackObject.setName("Allen");
		
		//mention what object should return 
		when(daoMock.findByID(1)).thenReturn(fackObject);
		
		User user1=new User();
		user1.setId(2);
		user1.setBalance(1000);
		user1.setName("Miller");
		when(daoMock.findByID(2)).thenReturn(user1);
		
		UserService service=new UserService(daoMock);
		
		String res=service.typeOfUser(1);
		assertEquals("regular user",res);
	}

}
