package presentation;
import java.util.Scanner;

import service.SLogin;
import valueObject.VLoginInfo;
import valueObject.VPersonalInfo;

public class PLogin {

	public PLogin() {
	}

	public VPersonalInfo show(Scanner scanner) {
		System.out.println("�α��� ");
		
		// new valueObject
		VLoginInfo vLoginInfo = new VLoginInfo();
		System.out.print("���̵�: ");
		vLoginInfo.id = scanner.next();
		System.out.print("�н�����: ");
		vLoginInfo.password = scanner.next();

		// service
		SLogin sLogin = new SLogin();
		VPersonalInfo vPersonalInfo = sLogin.validate(vLoginInfo);
		
		return vPersonalInfo;

	}
}
