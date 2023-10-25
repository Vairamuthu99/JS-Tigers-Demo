package TestDrive;

import org.testng.annotations.Test;

import BaseDrive.BaseClass;
import PageDrive.SigninPage;

public class SiginPageTest extends BaseClass{

	@Test
	public void Login() {

		SigninPage Login = new SigninPage(driver);
		Login.Login1("msvairam.muthu99@gmail.com", "Vairam@99");

	}
}
