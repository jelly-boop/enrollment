package presentation;

import java.util.Scanner;

import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class PSugangsincheong {

	public PSugangsincheong() {

	}

	public void show(Scanner scanner, VPersonalInfo vPersonalInfo) {
		System.out.println(vPersonalInfo.name + "��!, �ȳ��ϼ���. ");
		String fileName = "root";

		System.out.println("���� �޴��� ���� �ϼ���");
		boolean finished = false;
		while (!finished) {
			System.out.println("1:�˻�, 2:����");
			System.out.print("�Է�: ");
			int selection = scanner.nextInt();
			if (selection == 3) {
				finished = true;
			} else {
				PHakgwa pCampus = new PHakgwa();
				fileName = pCampus.show(scanner, fileName);

				PHakgwa pCollege = new PHakgwa();
				fileName = pCollege.show(scanner, fileName);

				PHakgwa pHakgwa = new PHakgwa();
				fileName = pHakgwa.show(scanner, fileName);

				PGangjwa pGangjwa = new PGangjwa();
				fileName = pGangjwa.show(scanner, fileName);

				System.out.println("�̸���� 1   ������û 2");
				selection = scanner.nextInt();
				if (selection == 1) {
					PMiridamgi pMiridamgi = new PMiridamgi();
					pMiridamgi.put(pGangjwa.g);

				} else if (selection == 2) {
					PSincheong pSincheong = new PSincheong();
					pSincheong.put(pGangjwa.g);
					
				}
				fileName = "root";

			}
		}
	}
}
