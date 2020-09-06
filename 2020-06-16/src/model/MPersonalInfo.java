package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JOptionPane;

import valueObject.VPersonalInfo;

public class MPersonalInfo {

	public MPersonalInfo() {
	}

	public VPersonalInfo read(String id) {
		try {
			File file = new File("data/temp");
			Scanner scanner = new Scanner(file);

			boolean found = false;
			VPersonalInfo vPersonalInfo = new VPersonalInfo();
			while (scanner.hasNext() && !found) {
				vPersonalInfo.No = scanner.next();
				vPersonalInfo.name = scanner.next();
				vPersonalInfo.id = scanner.next();
				vPersonalInfo.password = scanner.next();
				if (vPersonalInfo.id.contentEquals(id)) {
					found = true;
				} else if (vPersonalInfo.No.contentEquals(id)) {
					found = true;
				} else if (vPersonalInfo.name.contentEquals(id)) {
					found = true;
				} else if (vPersonalInfo.No.contentEquals(id)) {
					found = true;
				}
			}
			scanner.close();

			if (found) {
				return vPersonalInfo;
			} else {
				return null;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void write(VPersonalInfo vPersonalInfo) {
		try {
			File file = new File("data/temp");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.println(vPersonalInfo.No);
			printWriter.println(vPersonalInfo.name);
			printWriter.println(vPersonalInfo.id);
			printWriter.println(vPersonalInfo.password);

			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void makeFolder(VPersonalInfo vPersonalInfo) {
		String path = vPersonalInfo.id; //���� ���
		File Folder = new File(path);

		// �ش� ���丮�� ������� ���丮�� �����մϴ�.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //���� �����մϴ�.
			    System.out.println("������ �����Ǿ����ϴ�.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
		}
		makeBasket(vPersonalInfo);
		makeEnrollments(vPersonalInfo);
	}


	public void makeBasket(VPersonalInfo vPersonalInfo) {
		try {
			File file = new File(vPersonalInfo.id+"/basket");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void makeEnrollments(VPersonalInfo vPersonalInfo) {
		try {
			File file = new File(vPersonalInfo.id+"/enrollments");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
