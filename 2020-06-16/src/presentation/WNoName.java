package presentation;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.MPersonalInfo;

public class WNoName extends JPanel implements ActionListener{
	private JLabel lbNo = new JLabel("�й�");
	private JLabel lbName = new JLabel("�̸�");
	
	private JTextField tfNo = new JTextField(10);
	private JTextField tfName = new JTextField(10);
	
	private JButton btnID;
	private Image img = null;
	private ImageIcon imgIcon;
	
	JPanel p=new JPanel();
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	private Color color = new Color(4, 20, 74);
	private JLabel l;
	
	MPersonalInfo mPersonalInfo=new MPersonalInfo();
	
	public WNoName() {
		l=new JLabel("                    I              D           ã              ��     ");
		l.setBackground(color);
		l.setForeground(Color.white);
		this.add(l);
		this.setBackground(color);
		
		this.btnID = new JButton();
		try {
			File sourceImage = new File("img/search.png");
			img = ImageIO.read(sourceImage);
			imgIcon = new ImageIcon((Image)img);

		} catch (IOException e) {
			System.out.println("�̹��� ������ ����");
		}
		btnID.setBorderPainted(false);
		btnID.setIcon(imgIcon);
		btnID.setBackground(color);
		btnID.addActionListener(this);

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		p1.add(lbNo); p1.add(tfNo);
		p2.add(lbName);p2.add(tfName);
		p3.add(btnID);
		this.add(p1); this.add(p2);this.add(p3);
		
		lbNo.setBackground(Color.white);tfNo.setBackground(Color.white);
		lbName.setBackground(Color.white);tfName.setBackground(Color.white);
		p1.setBackground(Color.white);p2.setBackground(Color.white);
		p3.setBackground(color);
		this.setBackground(color);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(tfNo.getText()+"  "+tfName.getText());
		
		if(e.getSource().equals(btnID)){
			if(mPersonalInfo.read(tfNo.getText())!=null) {
				if(mPersonalInfo.read(tfName.getText())!=null) {
					JOptionPane.showMessageDialog(null,"ID: "+ mPersonalInfo.read(tfName.getText()).id,
							"Success", JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null,"���� �̸� �Դϴ�",
							"Success", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null,"���� �й� �Դϴ�",
						"Success", JOptionPane.WARNING_MESSAGE);
			}
		}
		
	}

}
