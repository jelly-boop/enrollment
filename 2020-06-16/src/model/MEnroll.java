package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VGangjwa;
import valueObject.VPersonalInfo;

public class MEnroll {
	String dummy = "";
	String delData="";
	public MEnroll() {

	}

	public Vector<VGangjwa> read(VPersonalInfo vPersonalInfo) {
		Vector<VGangjwa> bGangjwas = null;
		String dummy = "";
		try {
			File file = new File(vPersonalInfo.id + "/enrollments");
			Scanner scanner = new Scanner(file);

			bGangjwas = new Vector<VGangjwa>();
			while (scanner.hasNext()) {
					VGangjwa vGangjwa = new VGangjwa();
					vGangjwa.setId(scanner.nextLine()); 
					vGangjwa.setGangjwaName(scanner.nextLine());
					vGangjwa.setGyosuName(scanner.nextLine());
					vGangjwa.setHakjeom(scanner.nextLine());
					vGangjwa.setTime(scanner.nextLine());

				    bGangjwas.add(vGangjwa);

			}
			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bGangjwas;
	}

	public void write(VGangjwa vData, VPersonalInfo vPersonalInfo) throws IOException {
		try {
			File file = new File(vPersonalInfo.id + "/enrollments");
			FileWriter fileWriter = new FileWriter(file, true);
			PrintWriter printWriter = new PrintWriter(fileWriter);

			printWriter.println(vData.getId());
			printWriter.println(vData.getGangjwaName());
			printWriter.println(vData.getGyosuName());
			printWriter.println(vData.getHakjeom());
			printWriter.println(vData.getTime());

			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public VGangjwa move(VPersonalInfo vPersonalInfo,String target) {
    	VGangjwa vData;
		removeGangjwa(vPersonalInfo,target);
		vData=addEnroll(vPersonalInfo);
		return vData;
	}

    private VGangjwa addEnroll(VPersonalInfo vPersonalInfo) {
    	VGangjwa vData=new VGangjwa();
	try {
		File file = new File(vPersonalInfo.id + "/enrollments");
		FileWriter fileWriter = new FileWriter(file, true);
		PrintWriter printWriter = new PrintWriter(fileWriter);
		String[]s=delData.split(" ");
		
		vData.setId(s[0]);
		vData.setGangjwaName(s[1]);
		vData.setGyosuName(s[2]);
		vData.setHakjeom(s[3]);
		vData.setTime(s[4]);
		
		printWriter.println(s[0]);
		printWriter.println(s[1]);
		printWriter.println(s[2]);
		printWriter.println(s[3]);
		printWriter.println(s[4]);

		fileWriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return vData;
		
	}

	public void removeGangjwa(VPersonalInfo vPersonalInfo, String target) {
		System.out.println(target+"����");
		int position = findPosition(vPersonalInfo, target);
		File file = new File(vPersonalInfo.id + "/enrollments");
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

			// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new
			// FileOutputStream(file)));

			// 1. �����ϰ��� �ϴ� position ���������� �̵��ϸ� dummy�� ����

			String line;

			for (int i = 0; i < position; i++) {

				line = br.readLine(); // ������ �̵�

				dummy += (line + "\r\n");
			}

			// 2. �����ϰ��� �ϴ� �����ʹ� �ǳʶٱ�
			for (int i = 0; i < 5; i++) {
				this.delData += br.readLine()+" ";
				
			}

			// 3. �����ϰ��� �ϴ� position ���ĺ��� dummy�� ����

			while ((line = br.readLine()) != null) {

				dummy += (line + "\r\n");

			}

			// 4. FileWriter�� �̿��ؼ� �����

			FileWriter fw = new FileWriter(vPersonalInfo.id + "/enrollments");

			fw.write(dummy);

			// bw.close();

			fw.close();

			br.close();

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

	private int findPosition(VPersonalInfo vPersonalInfo, String target) {
		File file = new File(vPersonalInfo.id + "/enrollments");
		Scanner scanner;
		boolean find = false;
		int i = 0;
		try {
			scanner = new Scanner(file);

			while (scanner.hasNext() && !find) {
				
				if (scanner.nextLine().equals(target)) {
					find = true;
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(i+"��° ��");

		return i-1;

	}

	public void clear(VPersonalInfo vPersonalInfo) {
		
		FileWriter fw;
		try {
			fw = new FileWriter(vPersonalInfo.id + "/enrollments");
			fw.write("");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}

	

}
