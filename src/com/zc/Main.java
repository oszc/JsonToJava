package com.zc;

import com.jsontojava.JsonToJava;
import com.jsontojava.OutputOption;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 1/7/15  4:39 PM
 * Created by JustinZhang.
 */
public class Main extends JFrame implements ActionListener {
    String urlLabelName = "URL：";
    String packageLabelName = "包名：";
    String classNameName = "类名：";
    String pathLabelName = "输出（可选）：";

    public Main() {

        JLabel urlLabel; // privates can only be uses within a class
        final JTextField urlInput;
        final JButton button;

        final JLabel packageLabel;
        final JTextField packageInput;

        final JLabel classNameLabel;
        final JTextField classNameInput;

        final JLabel pathLabel;
        final JTextField pathNameInput;

        final JLabel errorLabel;

        //   JLabel img;
        //  Icon icons;

        //   icons = new ImageIcon(getClass().getResource("lunch.jpg"));
        //   img = new JLabel(icons);
        //    img.setBounds(80, 10, 300, 233);

        urlLabel = new JLabel(urlLabelName);
        urlLabel.setBounds(30, 30, 70, 30);

        packageLabel = new JLabel(packageLabelName);
        packageLabel.setBounds(30, 90, 70, 30);

        classNameLabel = new JLabel(classNameName);
        classNameLabel.setBounds(30, 150, 70, 30);

        pathLabel = new JLabel(pathLabelName);
        pathLabel.setBounds(30,210,110,30);

        errorLabel = new JLabel("");
        errorLabel.setBounds(30,270,400,30);

        urlInput = new JTextField();
        urlInput.setBounds(130, 30, 250, 30);
        urlInput.addActionListener(this);// fiedlds have addactionlisteners when user press enter

        packageInput = new JTextField();
        packageInput.setText("com.amiee");
        packageInput.setBounds(130, 90, 250, 30);
        packageInput.addActionListener(this);// fiedlds have addactionlisteners when user press enter

        classNameInput = new JTextField();
        classNameInput.setBounds(130, 150, 250, 30);
        classNameInput.addActionListener(this);// fiedlds have addactionlisteners when user press enter

        pathNameInput = new JTextField();
        pathNameInput.setBounds(130,210,250,30);
        pathNameInput.addActionListener(this);

        button = new JButton("转换");
        button.setBounds(170, 350, 100, 30);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = urlInput.getText();

                if(StringUtils.isEmpty(url)){
                   errorLabel.setText("url 不能为空！！！");
                    errorLabel.setForeground(Color.red);
                    return;
                }

                String pkage = packageInput.getText();

                if(StringUtils.isEmpty(pkage)){
                    errorLabel.setText("包名不能为空！！！");
                    errorLabel.setForeground(Color.red);
                    return;
                }

                String className = classNameInput.getText();
                if(StringUtils.isEmpty(className)){
                    errorLabel.setText("类名不能为空！！！");
                    errorLabel.setForeground(Color.red);
                    return;
                }

                String output = pathNameInput.getText();


                errorLabel.setText("正在转换，请稍后...");
                String result = convert(url.trim(),pkage.trim(),className.trim(),output.trim());
                if(SUCCESS.equals(result)) {
                    errorLabel.setText("创建成功！");
                    errorLabel.setForeground(Color.green);
                }else{
                    errorLabel.setText(result);
                    errorLabel.setForeground(Color.red);
                }
            }
        });

        //      add(img);
        add(urlLabel);
        add(urlInput);

        add(packageLabel);
        add(packageInput);

        add(classNameLabel);
        add(classNameInput);
        add(button);

        add(pathLabel);
        add(pathNameInput);

        add(errorLabel);

        setSize(460, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        setTitle("Json 2 Java");
    }


    public void actionPerformed(ActionEvent e) { // all methods in an interface is public
        //content = "You said something!";
    }

    public static void main(String[] args) {
        new Main();
    }

    private static final String  SUCCESS ="SUCCESS";
    private static String convert(String url ,String packageName, String baseClassName, String path) {
        JsonToJava jsonToJava = new JsonToJava();
        jsonToJava.setUrl(url);
        jsonToJava.setPackage(packageName);
        jsonToJava.setBaseType(baseClassName);
        jsonToJava.addOutputOption(OutputOption.GSON);

        jsonToJava.fetchJson();


        if(StringUtils.isEmpty(path)){
            path = System.getProperty("user.dir");
        }

        File zipFile = new File(path,jsonToJava.getPackage()+"."+baseClassName +".zip");
        try {
            OutputStream out = new FileOutputStream(zipFile);
            jsonToJava.outputZipFile(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return e.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return e.toString();
        }
        return SUCCESS;
    }
}
