import com.intellij.openapi.wm.ToolWindow;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class DnD {
    private JPanel panel1;

    private JComboBox sectionSelector;
    private JPanel dragArea;
    private  JTextArea arrayArea;
    private  JTextArea listArea;
    private  JTextArea intArea;
    private  JTextArea doubleArea;
    private  JTextArea booleanArea;
    private  JTextArea charArea;
    private  JTextArea stringArea;
    private  JTextArea ifArea;
    private  JTextArea elseArea;
    private  JTextArea forArea;
    private  JTextArea whileArea;
    private  JTextArea printArea;
    private  JTextArea mainArea;
    private  JTextArea docDescArea;
    private  JTextArea docSecArea;
    private  JTextArea testMethodArea;
    private  JTextArea assertArea;
    private  JTextArea isArea;
    private  JTextArea anyArea;
    private  JTextArea allOfArea;
    private  JTextArea anyOfArea;
    private  JTextArea notMatchArea;
    private  JTextArea equalToArea;
    private  JTextArea instanceOfArea;
    private  JTextArea nullArea;
    private  JTextArea instanceSameArea;
    private JButton b0;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b10;
    private JButton b11;
    private JButton b12;
    private JButton b13;
    private JButton b14;
    private JButton b15;
    private JButton b16;
    private JButton b17;
    private JButton b18;
    private JButton b19;
    private JButton b20;
    private JButton b21;
    private JButton b22;
    private JButton b23;
    private JButton b24;
    private JButton b25;




    int bCounter;
    int numClicks = 0;






    private JTextArea a1;

    public DnD(ToolWindow toolWindow) {
        bCounter = 0;
        ArrayList<JTextArea> favs = new ArrayList<>();
        Color pink = new Color(240,128,190);
        Color blue = new Color(173,216,230);
        Color green = new Color(152, 251, 152);
        Color yellow = new Color(255, 255, 237);

        //set up star buttons
        ArrayList<JButton> bList = new ArrayList<>();
        Image emptyStar = null;
        Image fullStar = null;
        try {
            emptyStar = ImageIO.read(getClass().getResource("myToolWindow/emptyStar.png"));
            fullStar = ImageIO.read(getClass().getResource("myToolWindow/filledStar.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ImageIcon emptyIcon = new ImageIcon(emptyStar);
        ImageIcon fullIcon = new ImageIcon(fullStar);
        b0=new JButton(emptyIcon);
        bList.add(b0);
        b1=new JButton(emptyIcon);
        bList.add(b1);
        b2=new JButton(emptyIcon);
        bList.add(b2);
        b3=new JButton(emptyIcon);
        bList.add(b3);
        b4=new JButton(emptyIcon);
        bList.add(b4);
        b5=new JButton(emptyIcon);
        b5.setUI((ButtonUI) BasicButtonUI.createUI(b5));
        bList.add(b5);
        b6=new JButton(emptyIcon);
        bList.add(b6);
        b7=new JButton(emptyIcon);
        bList.add(b7);
        b8=new JButton(emptyIcon);
        bList.add(b8);
        b9=new JButton(emptyIcon);
        bList.add(b9);
        b10=new JButton(emptyIcon);
        bList.add(b10);
        b11=new JButton(emptyIcon);
        bList.add(b11);
        b12=new JButton(emptyIcon);
        bList.add(b12);
        b13=new JButton(emptyIcon);
        bList.add(b13);
        b14=new JButton(emptyIcon);
        bList.add(b14);
        b15=new JButton(emptyIcon);
        bList.add(b15);
        b16=new JButton(emptyIcon);
        bList.add(b16);
        b17=new JButton(emptyIcon);
        bList.add(b17);
        b18=new JButton(emptyIcon);
        bList.add(b18);
        b19=new JButton(emptyIcon);
        bList.add(b19);
        b20=new JButton(emptyIcon);
        bList.add(b20);
        b21=new JButton(emptyIcon);
        bList.add(b21);
        b22=new JButton(emptyIcon);
        bList.add(b22);
        b23=new JButton(emptyIcon);
        bList.add(b23);
        b24=new JButton(emptyIcon);
        bList.add(b24);
        b25=new JButton(emptyIcon);
        bList.add(b25);
        ActionListener a = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JComponent c = (JComponent)e.getSource();
                if(((JButton) c).getIcon() == emptyIcon) {
                    ((JButton) c).setIcon(fullIcon);
                    JPanel panel = (JPanel) c.getParent();
                    JTextArea a = (JTextArea) panel.getComponent(0);
                    favs.add(a);
                    bCounter++;
                }
                else{
                    ((JButton) c).setIcon(emptyIcon);
                    JPanel panel = (JPanel) c.getParent();
                    JTextArea a = (JTextArea) panel.getComponent(0);
                    favs.remove(a);
                    bCounter--;
                }
            }
        };
        for(JButton button : bList){
            button.addActionListener(a);
            button.setUI((ButtonUI) BasicButtonUI.createUI(button));
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            button.setBorder(border);
        }
        //setting up Text areas
        arrayArea=new JTextArea("array");
        listArea=new JTextArea("list");
        //23
        intArea=new JTextArea("int");
        doubleArea=new JTextArea("double");
        booleanArea=new JTextArea("boolean");
        charArea=new JTextArea("char");
        stringArea=new JTextArea("String");
        //18
        docDescArea=new JTextArea("Doc Description");
        docSecArea=new JTextArea("Doc Section");
        testMethodArea=new JTextArea("Test Method");
        assertArea=new JTextArea("Assert");
        isArea=new JTextArea("is()");
        anyArea=new JTextArea("any()");
        allOfArea=new JTextArea("allOf()");
        anyOfArea=new JTextArea("anyOf()");
        notMatchArea=new JTextArea("not()");
        equalToArea=new JTextArea("equalTo()");
        instanceOfArea=new JTextArea("instanceOf()");
        nullArea=new JTextArea("nullValue()");
        instanceSameArea=new JTextArea("sameInstance()");
        //5
        ifArea=new JTextArea("if()");
        elseArea=new JTextArea("else");
        forArea=new JTextArea("for()");
        whileArea=new JTextArea("while()");
        printArea=new JTextArea("print()");
        mainArea=new JTextArea("main()");

        ArrayList<JTextArea> h = new ArrayList<>();
        h.add(mainArea); h.add(printArea);h.add(whileArea);h.add(forArea);h.add(elseArea);h.add(ifArea);h.add(instanceSameArea);h.add(nullArea);h.add(instanceOfArea);h.add(equalToArea);h.add(notMatchArea);h.add(anyOfArea);h.add(allOfArea);h.add(anyArea);h.add(isArea);h.add(assertArea);
        h.add(testMethodArea);h.add(docDescArea);h.add(docSecArea);h.add(stringArea);h.add(charArea);h.add(booleanArea);h.add(doubleArea);h.add(intArea);h.add(listArea);h.add(arrayArea);

        //set up sectionSelector drop down box
        ItemListener i = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    switch((String)sectionSelector.getSelectedItem()){
                        case "Data Structures":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(2, 0, 0, 5));
                            JPanel t0 = new JPanel();
                            JPanel t1 = new JPanel();

                            b0.setBackground(pink);
                            b1.setBackground(pink);
                            t0.setLayout(new BorderLayout());
                            t0.add(arrayArea, BorderLayout.CENTER);
                            t0.add(b0, BorderLayout.EAST);
                            dragArea.add(t0);
                            t1.setLayout(new BorderLayout());
                            t1.add(listArea, BorderLayout.CENTER);
                            t1.add(b1, BorderLayout.EAST);
                            dragArea.add(t1);
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Data Types":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(5, 0, 0, 5));

                            JPanel t2 = new JPanel();
                            JPanel t3 = new JPanel();
                            JPanel t4 = new JPanel();
                            JPanel t5 = new JPanel();
                            JPanel t6 = new JPanel();

                            b2.setBackground(blue);
                            b3.setBackground(blue);
                            b4.setBackground(blue);
                            b5.setBackground(blue);
                            b6.setBackground(blue);

                            t2.setLayout(new BorderLayout());
                            t2.add(intArea, BorderLayout.CENTER);
                            t2.add(b2, BorderLayout.EAST);
                            dragArea.add(t2);
                            t3.setLayout(new BorderLayout());
                            t3.add(doubleArea, BorderLayout.CENTER);
                            t3.add(b3, BorderLayout.EAST);
                            dragArea.add(t3);
                            t4.setLayout(new BorderLayout());
                            t4.add(booleanArea, BorderLayout.CENTER);
                            t4.add(b4, BorderLayout.EAST);
                            dragArea.add(t4);
                            t5.setLayout(new BorderLayout());
                            t5.add(charArea, BorderLayout.CENTER);
                            t5.add(b5, BorderLayout.EAST);
                            dragArea.add(t5);
                            t6.setLayout(new BorderLayout());
                            t6.add(stringArea, BorderLayout.CENTER);
                            t6.add(b6, BorderLayout.EAST);
                            dragArea.add(t6);

                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Testing":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(13, 0, 0, 5));

                            JPanel t7 = new JPanel();
                            JPanel t8 = new JPanel();
                            JPanel t9 = new JPanel();
                            JPanel t10 = new JPanel();
                            JPanel t11 = new JPanel();
                            JPanel t12 = new JPanel();
                            JPanel t13 = new JPanel();
                            JPanel t14 = new JPanel();
                            JPanel t15 = new JPanel();
                            JPanel t16 = new JPanel();
                            JPanel t17 = new JPanel();
                            JPanel t18 = new JPanel();
                            JPanel t19 = new JPanel();

                            b7.setBackground(green);
                            b8.setBackground(green);
                            b9.setBackground(green);
                            b10.setBackground(green);
                            b11.setBackground(green);
                            b12.setBackground(green);
                            b13.setBackground(green);
                            b14.setBackground(green);
                            b15.setBackground(green);
                            b16.setBackground(green);
                            b17.setBackground(green);
                            b18.setBackground(green);
                            b19.setBackground(green);

                            t7.setLayout(new BorderLayout());
                            t7.add(docDescArea, BorderLayout.CENTER);
                            t7.add(b7, BorderLayout.EAST);
                            dragArea.add(t7);

                            t8.setLayout(new BorderLayout());
                            t8.add(docSecArea, BorderLayout.CENTER);
                            t8.add(b8, BorderLayout.EAST);
                            dragArea.add(t8);

                            t9.setLayout(new BorderLayout());
                            t9.add(testMethodArea, BorderLayout.CENTER);
                            t9.add(b9, BorderLayout.EAST);
                            dragArea.add(t9);

                            t10.setLayout(new BorderLayout());
                            t10.add(assertArea, BorderLayout.CENTER);
                            t10.add(b10, BorderLayout.EAST);
                            dragArea.add(t10);

                            t11.setLayout(new BorderLayout());
                            t11.add(isArea, BorderLayout.CENTER);
                            t11.add(b11, BorderLayout.EAST);
                            dragArea.add(t11);

                            t12.setLayout(new BorderLayout());
                            t12.add(anyArea, BorderLayout.CENTER);
                            t12.add(b12, BorderLayout.EAST);
                            dragArea.add(t12);

                            t13.setLayout(new BorderLayout());
                            t13.add(allOfArea, BorderLayout.CENTER);
                            t13.add(b13, BorderLayout.EAST);
                            dragArea.add(t13);

                            t14.setLayout(new BorderLayout());
                            t14.add(anyOfArea, BorderLayout.CENTER);
                            t14.add(b14, BorderLayout.EAST);
                            dragArea.add(t14);

                            t15.setLayout(new BorderLayout());
                            t15.add(notMatchArea, BorderLayout.CENTER);
                            t15.add(b15, BorderLayout.EAST);
                            dragArea.add(t15);

                            t16.setLayout(new BorderLayout());
                            t16.add(equalToArea, BorderLayout.CENTER);
                            t16.add(b16, BorderLayout.EAST);
                            dragArea.add(t16);

                            t17.setLayout(new BorderLayout());
                            t17.add(instanceOfArea, BorderLayout.CENTER);
                            t17.add(b17, BorderLayout.EAST);
                            dragArea.add(t17);

                            t18.setLayout(new BorderLayout());
                            t18.add(nullArea, BorderLayout.CENTER);
                            t18.add(b18, BorderLayout.EAST);
                            dragArea.add(t18);

                            t19.setLayout(new BorderLayout());
                            t19.add(instanceSameArea, BorderLayout.CENTER);
                            t19.add(b19, BorderLayout.EAST);
                            dragArea.add(t19);

                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Methods":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(6, 0, 0, 5));

                            JPanel t20 = new JPanel();
                            JPanel t21 = new JPanel();
                            JPanel t22 = new JPanel();
                            JPanel t23 = new JPanel();
                            JPanel t24 = new JPanel();
                            JPanel t25 = new JPanel();


                            b20.setBackground(yellow);
                            b21.setBackground(yellow);
                            b22.setBackground(yellow);
                            b23.setBackground(yellow);
                            b24.setBackground(yellow);
                            b25.setBackground(yellow);


                            t20.setLayout(new BorderLayout());
                            t20.add(mainArea, BorderLayout.CENTER);
                            t20.add(b20, BorderLayout.EAST);
                            dragArea.add(t20);
                            t21.setLayout(new BorderLayout());
                            t21.add(ifArea, BorderLayout.CENTER);
                            t21.add(b21, BorderLayout.EAST);
                            dragArea.add(t21);
                            t22.setLayout(new BorderLayout());
                            t22.add(elseArea, BorderLayout.CENTER);
                            t22.add(b22, BorderLayout.EAST);
                            dragArea.add(t22);
                            t23.setLayout(new BorderLayout());
                            t23.add(whileArea, BorderLayout.CENTER);
                            t23.add(b23, BorderLayout.EAST);
                            dragArea.add(t23);
                            t24.setLayout(new BorderLayout());
                            t24.add(forArea, BorderLayout.CENTER);
                            t24.add(b24, BorderLayout.EAST);
                            dragArea.add(t24);
                            t25.setLayout(new BorderLayout());
                            t25.add(printArea, BorderLayout.CENTER);
                            t25.add(b25, BorderLayout.EAST);
                            dragArea.add(t25);
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Favourites":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(favs.size(), 0, 0, 5));
                            for(JTextArea j : favs){
                                dragArea.add(j);
                            }
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;

                    }
                }

            }
        };
        sectionSelector.addItemListener(i);





        //create mouselisteners for each group
        MouseListener methodListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("test2");
                numClicks++;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                if(numClicks < 2) {
                    if (name.equals("else")) {
                        ((JTextArea) c).setText("else{" + "\n" + "\n" + "}");
                    } else if (name.equals("print()")) {
                        ((JTextArea) c).setText("System.out.println();");
                    } else if(name.equals("main()")){
                        ((JTextArea) c).setText("public static void main(String[] args){" + "\n" + "\n" +  "}");
                    }
                    else {
                        ((JTextArea) c).setText(name + "{" + "\n" + "\n" + "}");
                    }
                }
                ((JTextArea) c).selectAll();
                Border b2 = BorderFactory.createLineBorder(Color.BLACK,3);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b2, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                numClicks = 0;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                if(name.equals("else{" + "\n" + "\n" + "}") || name.equals("else")){
                    ((JTextArea) c).setText("else");
                }
                else if(name.equals("System.out.println();")){
                    ((JTextArea) c).setText("print()");
                }
                else if(name.equals("main()") || name.equals("public static void main(String[] args){" + "\n" + "\n" +  "}")){
                    ((JTextArea) c).setText("main()");
                }
                else{
                    int index = name.indexOf(")");
                    ((JTextArea) c).setText(name.substring(0,index+1));
                }
                Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }

        };
        MouseListener structureListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("test2");
                numClicks++;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                //System.out.println(name);
                if(numClicks < 2) {
                    if (name.equals("array")) {
                        ((JTextArea) c).setText("[] X = new [];");
                    } else if (name.equals("list")) {
                        ((JTextArea) c).setText("ArrayList<> X = new ArrayList();");
                    }
                }

                ((JTextArea) c).selectAll();
                Border b2 = BorderFactory.createLineBorder(Color.BLACK,3);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b2, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                numClicks = 0;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                if(name.equals("[] X = new [];") || name.equals("array")){
                    ((JTextArea) c).setText("array");
                }
                else if(name.equals("ArrayList<> X = new ArrayList();") || name.equals("list")){
                    ((JTextArea) c).setText("list");
                }

                Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }

        };
        MouseListener typeListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("test2");
                numClicks++;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                //System.out.println(name);
                if(numClicks < 2) {
                    if (name.equals("char")) {
                        ((JTextArea) c).setText("char X = '';");
                    } else if (name.equals("String")) {
                        ((JTextArea) c).setText("String X = \"\";");
                    }
                    else{
                        ((JTextArea) c).setText(name + " X = ;");
                    }
                }

                ((JTextArea) c).selectAll();
                Border b2 = BorderFactory.createLineBorder(Color.BLACK,3);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b2, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                numClicks = 0;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                if(name.equals("char X = '';") || name.equals("char")){
                    ((JTextArea) c).setText("char");
                }
                else if(name.equals("String X = \"\";") || name.equals("String")){
                    ((JTextArea) c).setText("String");
                }
                else if(name.contains("X")){
                    int index = name.indexOf("X");
                    ((JTextArea) c).setText(name.substring(0,index-1));
                }

                Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }

        };


        MouseListener testingListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("test2");
                numClicks++;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                //System.out.println("press " + name);
                if(numClicks < 2) {
                    if (name.equals("Doc Description")) {
                        ((JTextArea) c).setText("/**" + "\n" + "* My method does X" + "\n" + "* @param" + "\n" + "* @return" + "\n" + "*/");
                    } else if (name.equals("Doc Section")) {
                        ((JTextArea) c).setText("// ******************************" + "\n" + "// My Section" + "\n" + "// ******************************");
                    }
                    else if(name.equals("Test Method")){
                        ((JTextArea) c).setText("@Test" + "\n" + "public void myTestMethod() throws Exception{" + "}");
                    }
                    else if(name.equals("Assert")){
                        ((JTextArea) c).setText("Assert.assertThat(value,testCase);");
                    }else{
                        ((JTextArea) c).setText("CoreMatchers." + name );
                    }
                }

                ((JTextArea) c).selectAll();
                Border b2 = BorderFactory.createLineBorder(Color.BLACK,3);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b2, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                numClicks = 0;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                //System.out.println("left " + name);
                if(name.equals("/**" + "\n" + "* My method does X" + "\n" + "* @param" + "\n" + "* @return" + "\n" + "*/") || name.equals("Doc Description")){
                    ((JTextArea) c).setText("Doc Description");
                }
                else if(name.equals("Doc Section") || name.equals("// ******************************" + "\n" + "// My Section" + "\n" + "// ******************************")){
                    ((JTextArea) c).setText("Doc Section");
                }
                else if(name.equals("Test Method") || name.equals("@Test" + "\n" + "public void myTestMethod() throws Exception{" + "}")){
                    ((JTextArea) c).setText("Test Method");
                }
                else if(name.equals("Assert") || name.equals("Assert.assertThat(value,testCase)")){
                    ((JTextArea) c).setText("Assert");
                }
                else {
                    if(name.contains("Core")) {
                        int index = name.indexOf(")");
                        ((JTextArea) c).setText(name.substring(13, index+1));
                    }
                }
                Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                ((JTextArea) c).setEditable(false);
            }

        };

        //set aesthetic proprties of textareas and their mouseListener
        int counter = 0;
        for(JTextArea j : h){
            j.setDragEnabled(true);
            j.setEditable(false);

            if(counter <=5){
                j.setBackground(yellow);
                j.addMouseListener(methodListener);
            }
            if(counter>5 && counter <= 18){
                j.setBackground(green);
                j.addMouseListener(testingListener);
            }
            if(counter>18 && counter <= 23){
                j.setBackground(blue);
                j.addMouseListener(typeListener);
            }
            if(counter>23 && counter <= 25){
                j.setBackground(pink);
                j.addMouseListener(structureListener);
            }
            j.setFont(new Font("Times New Roman", Font.BOLD,16));
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            j.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
            j.setForeground(Color.BLACK);
            counter++;
        }




    }



    public JPanel getContent() {
        return panel1;
    }


}

/*
        DropTargetListener d = new DropTargetAdapter() {
            @Override
            public void drop(DropTargetDropEvent dtde) {


            }
        };
        */

/*
        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("test2");
                JComponent c = (JComponent)e.getSource();
                TransferHandler th = c.getTransferHandler();
                th.exportAsDrag(c, e, TransferHandler.COPY);
            }
        };
        */

//ifLabel.setTransferHandler(new TransferHandler("text"));
//ifLabel.addMouseListener(ml);
//elseLabel.addMouseListener(ml);
//textArea1.addMouseListener(ml2);
//DropTarget dt = new DropTarget(textArea1,d);


// MyDragGestureListener dlistener = new MyDragGestureListener();
// DragSource ds1 = new DragSource();
// ds1.createDefaultDragGestureRecognizer(ifLabel, DnDConstants.ACTION_COPY, dlistener);



/*
        //Set up DropArea's textArea for dnd release behaviour
        dropArea.setLayout(new GridLayout(numColumns, 0, 0, 5));
        TransferHandler dnd = new TransferHandler(){
            @Override
            public boolean canImport(TransferSupport support) {
                if (!support.isDrop()) {
                    return false;
                }
                //only Strings
                if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                    return false;
                }
                return true;
            }
            @Override
            public boolean importData(TransferSupport support) {
                if (!canImport(support)) {
                    return false;
                }
                Transferable tansferable = support.getTransferable();
                String line;
                try {
                    line = (String) tansferable.getTransferData(DataFlavor.stringFlavor);
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
                JTextArea.DropLocation dl = (JTextArea.DropLocation) support.getDropLocation();
                JTextArea a = (JTextArea) support.getComponent();
                a.setColumns(2);
                a.setText(line);
                Color yellow = new Color(255, 255, 237);
                a.setBackground(yellow);
                JTextArea newArea = new JTextArea();
                numColumns++;
                dropArea.setLayout(new GridLayout(numColumns, 0, 0, 5));
                dropArea.add(newArea);
                //textArea1.setText(line);
                return true;
            }
        };

        textArea1.setDragEnabled(true);
        textArea1.setTransferHandler(dnd);

         */