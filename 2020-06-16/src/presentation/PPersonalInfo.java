package presentation;
import java.util.Scanner;

import service.SPersonalInfo;
import valueObject.VPersonalInfo;

// presentation 
public class PPersonalInfo {

	public PPersonalInfo() {
	}

	public void show(Scanner scanner) {
		System.out.println("�������� �Է� �ϼ���.");
		
		// new valueObject
		VPersonalInfo vPersonalInfo = new VPersonalInfo();
		
		System.out.print("���̵� �Է� �ϼ���: ");
		vPersonalInfo.id = scanner.next();
		
		System.out.print("�н����� �Է� �ϼ���: ");
		vPersonalInfo.password = scanner.next();
		
		System.out.print("�̸� �Է� �ϼ���: ");
		vPersonalInfo.name = scanner.next();

		// service
		SPersonalInfo sPersonalInfo = new SPersonalInfo();
		sPersonalInfo.write(vPersonalInfo);	
	}

}
