package presentation;

import java.util.Scanner;
import java.util.Vector;

import service.SHakgwa;
import valueObject.VHakgwa;

public class PHakgwa {

	public PHakgwa() {
	}

	public String show(Scanner scanner,String fileName) {
		System.out.println("������ �ֽʽÿ�");
		SHakgwa sCampus = new SHakgwa();
		Vector<VHakgwa> vData = sCampus.getData(fileName);
		if (vData != null) {
			for (VHakgwa vDatum : vData) {
				System.out.println(vDatum.getId() + " " + vDatum.getText());
			}
			System.out.print("�Է�   : ");
			int selection = scanner.nextInt();

			for (VHakgwa vDatum : vData) {
				if (vDatum.getId() == selection) {
					return vDatum.getFileName();
				}
			}
		}
		return null;
	}

}
