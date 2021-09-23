import com.zxx.AesUtils;
import org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI;
import org.jasypt.intf.service.JasyptStatelessService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.zxx.SwingConsole.*;
public class FirstApplet extends JFrame {
    private static String password="datd!@#123";
    private static String  algorithm="PBEWithMD5AndDES";
    private JButton b1=new JButton("明文转换为密文");
    private JButton b2=new JButton("密文转换为明文");
    private JButton b3=new JButton("数据库明文转换密文");
    private JButton b4=new JButton("数据库密文转换为明文");
    private JLabel b5=new JLabel("无用无用无用");
    private JLabel b6=new JLabel("无用无用无用");
    private JLabel emptytext=new JLabel("");
    private JLabel inputtext=new JLabel("明文");
    private JLabel outputtext=new JLabel("密文");
    private JLabel dbinputtext=new JLabel("数据库明文");
    private JLabel dboutputtext=new JLabel("数据库密文");
    private JTextField inputtxtField =new JTextField(40);
    private JTextField outtxtField =new JTextField(40);
    private JTextField dbouttxtField =new JTextField(35);
    private JTextField dbinputtxtField =new JTextField(35);
    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            String plaintext=inputtxtField.getText();
            String ciphertext=encrypt(plaintext);
            outtxtField.setText(ciphertext);
        }
    }
    class ButtonListener2 implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            String ciphertext=outtxtField.getText();
            String plaintext=decrypt(ciphertext);
            inputtxtField.setText(plaintext);
        }
    }
    class ButtonListener3 implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            String plaintext=dbinputtxtField.getText();
            String ciphertext= AesUtils.encrypt(plaintext);
            dbouttxtField.setText(ciphertext);
        }
    }
    class ButtonListener4 implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent){
            String ciphertext=dbouttxtField.getText();
            String plaintext=AesUtils.decrypt(ciphertext);
            dbinputtxtField.setText(plaintext);
        }
    }
    private ButtonListener b1istener=new ButtonListener();
    private ButtonListener2 b1istener2=new ButtonListener2();
    private ButtonListener3 b1istener3=new ButtonListener3();
    private ButtonListener4 b1istener4=new ButtonListener4();
    public FirstApplet(){

//        b2.addActionListener(b1istener);
        b1.addActionListener(b1istener);
        b2.addActionListener(b1istener2);
        b3.addActionListener(b1istener3);
        b4.addActionListener(b1istener4);
        setLayout(new FlowLayout());

//        add(b2);
        add(inputtext);
        add(inputtxtField);
        add(outputtext);
        add(outtxtField);
        add(b6);
        add(b1);
        add(b2);
        add(b5);
        add(dbinputtext);
        add(dbinputtxtField);
        add(dboutputtext);
        add(dbouttxtField);
        add(b3);
        add(b4);
    }
    public static void main(String[]args){
        System.out.println(System.getProperty("os.name"));
        run(new FirstApplet(),500,500);
//        encrypt();
    }

    private static String encrypt(String input){
        JasyptStatelessService service = new JasyptStatelessService();
        String result = service.encrypt(input, password, (String)null, (String)null,algorithm, (String)null, (String)null,(String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null);
        return result;
    }
    private static String decrypt(String input){
        JasyptStatelessService service = new JasyptStatelessService();
        String result = service.decrypt(input, password, (String)null, (String)null,algorithm, (String)null, (String)null,(String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null);
        return result;
    }
}

