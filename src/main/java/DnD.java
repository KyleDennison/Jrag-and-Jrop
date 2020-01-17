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
    private JButton addBtn;
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


    JPanel newItem;



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
        Image add = null;
        try {
            emptyStar = ImageIO.read(getClass().getResource("myToolWindow/emptyStar.png"));
            fullStar = ImageIO.read(getClass().getResource("myToolWindow/filledStar.png"));
            add = ImageIO.read(getClass().getResource("myToolWindow/plus.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ImageIcon emptyIcon = new ImageIcon(emptyStar);
        ImageIcon fullIcon = new ImageIcon(fullStar);
        ImageIcon plusIcon = new ImageIcon(add);

        addBtn.setIcon(plusIcon);
        ActionListener favouriteListener = new ActionListener()
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





        //Setup the DragLabels
        ArrayList<DragLabel> dsList = new ArrayList<>();
        DragLabel arrayDrag = new DragLabel();
        arrayDrag.setLabelName("array");
        arrayDrag.setLabelContent("[] X = new [];");
        DragLabel listDrag = new DragLabel();
        listDrag.setLabelName("list");
        listDrag.setLabelContent("ArrayList<> X = new ArrayList();");
        dsList.add(arrayDrag);
        dsList.add(listDrag);

        ArrayList<DragLabel> dtList = new ArrayList<>();
        DragLabel intDrag = new DragLabel();
        intDrag.setLabelName("int");
        intDrag.setLabelContent("int X = ;");
        DragLabel doubleDrag = new DragLabel();
        doubleDrag.setLabelName("double");
        doubleDrag.setLabelContent("double x = ;");
        DragLabel booleanDrag = new DragLabel();
        booleanDrag.setLabelName("boolean");
        booleanDrag.setLabelContent("boolean x = ;");
        DragLabel charDrag = new DragLabel();
        charDrag.setLabelName("char");
        charDrag.setLabelContent("char x = '';");
        DragLabel stringDrag = new DragLabel();
        stringDrag.setLabelName("String");
        stringDrag.setLabelContent("String X = \"\";");
        dtList.add(intDrag);
        dtList.add(stringDrag);
        dtList.add(booleanDrag);
        dtList.add(doubleDrag);
        dtList.add(charDrag);


        ArrayList<DragLabel> testingList = new ArrayList<>();
        DragLabel descDrag = new DragLabel();
        descDrag.setLabelName("Doc Description");
        descDrag.setLabelContent("/**" + "\n" + "* My method does X" + "\n" + "* @param" + "\n" + "* @return" + "\n" + "*/");
        DragLabel secDrag = new DragLabel();
        secDrag.setLabelName("Doc Section");
        secDrag.setLabelContent("// ******************************" + "\n" + "// My Section" + "\n" + "// ******************************");
        DragLabel methodDrag = new DragLabel();
        methodDrag.setLabelName("Test Method");
        methodDrag.setLabelContent("@Test" + "\n" + "public void myTestMethod() throws Exception{" + "}");
        DragLabel assertDrag = new DragLabel();
        assertDrag.setLabelName("Assert");
        assertDrag.setLabelContent("Assert.assertThat(value,testCase);");
        DragLabel isDrag = new DragLabel();
        isDrag.setLabelName("is()");
        isDrag.setLabelContent("CoreMatchers.is()");
        DragLabel anyDrag = new DragLabel();
        anyDrag.setLabelName("any()");
        anyDrag.setLabelContent("CoreMatchers.any()");
        DragLabel allDrag = new DragLabel();
        allDrag.setLabelName("allOf()");
        allDrag.setLabelContent("CoreMatchers.allOf()");
        DragLabel anyOfDrag = new DragLabel();
        anyOfDrag.setLabelName("anyOf()");
        anyOfDrag.setLabelContent("CoreMatchers.anyOf()");
        DragLabel notDrag = new DragLabel();
        notDrag.setLabelName("not()");
        notDrag.setLabelContent("CoreMatchers.not()");
        DragLabel equalDrag = new DragLabel();
        equalDrag.setLabelName("equalTo()");
        equalDrag.setLabelContent("CoreMatchers.equalTo()");
        DragLabel instanceOfDrag = new DragLabel();
        instanceOfDrag.setLabelName("instanceOf()");
        instanceOfDrag.setLabelContent("CoreMatchers.instanceOf()");
        DragLabel nullDrag = new DragLabel();
        nullDrag.setLabelName("nullValue()");
        nullDrag.setLabelContent("CoreMatchers.nullValue()");
        DragLabel instanceSameDrag = new DragLabel();
        instanceSameDrag.setLabelName("sameInstance()");
        instanceSameDrag.setLabelContent("CoreMatchers.sameInstance()");
        testingList.add(descDrag);
        testingList.add(secDrag);
        testingList.add(methodDrag);
        testingList.add(assertDrag);
        testingList.add(isDrag);
        testingList.add(anyDrag);
        testingList.add(allDrag);
        testingList.add(anyOfDrag);
        testingList.add(notDrag);
        testingList.add(equalDrag);
        testingList.add(nullDrag);
        testingList.add(instanceSameDrag);
        testingList.add(instanceOfDrag);

        ArrayList<DragLabel> methodList = new ArrayList<>();
        DragLabel ifDrag = new DragLabel();
        ifDrag.setLabelName("if()");
        ifDrag.setLabelContent("if()" + "{" + "\n" + "\n" + "}");
        DragLabel elseDrag = new DragLabel();
        elseDrag.setLabelName("else");
        elseDrag.setLabelContent("else{" + "\n" + "\n" + "}");
        DragLabel forDrag = new DragLabel();
        forDrag.setLabelName("for()");
        forDrag.setLabelContent("for" + "{" + "\n" + "\n" + "}");
        DragLabel whileDrag = new DragLabel();
        whileDrag.setLabelName("while()");
        whileDrag.setLabelContent("while()" + "{" + "\n" + "\n" + "}");
        DragLabel printDrag = new DragLabel();
        printDrag.setLabelName("print()");
        printDrag.setLabelContent("System.out.println();");
        DragLabel mainDrag = new DragLabel();
        mainDrag.setLabelName("main()");
        mainDrag.setLabelContent("public static void main(String[] args){" + "\n" + "\n" +  "}");
        DragLabel getDrag = new DragLabel();
        getDrag.setLabelName("get()");
        getDrag.setLabelContent("public datatype getX(){" + "\n"+  "return X;" + "\n" +  "}" );
        DragLabel setDrag = new DragLabel();
        setDrag.setLabelName("set()");
        setDrag.setLabelContent("public void setX(datatype pX){" +  "\n" + "X = pX; " + "\n" +  "}" );
        methodList.add(ifDrag);
        methodList.add(elseDrag);
        methodList.add(printDrag);
        methodList.add(forDrag);
        methodList.add(whileDrag);
        methodList.add(mainDrag);
        methodList.add(getDrag);
        methodList.add(setDrag);



        //add Button
        ActionListener addListener = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JComponent c = (JComponent)e.getSource();
                if(((JButton) c).getIcon() != null) {
                    JTextArea nameArea = new JTextArea("labelName");
                    nameArea.setFont(new Font("Times New Roman", Font.BOLD,16));
                    Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                    nameArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                    nameArea.setForeground(Color.BLACK);
                    JTextArea contentArea = new JTextArea("labelContent");
                    contentArea.setFont(new Font("Times New Roman", Font.BOLD,16));
                    contentArea.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                    contentArea.setForeground(Color.BLACK);
                    JPanel askPanel = new JPanel(new GridLayout(2, 0, 0, 0));
                    askPanel.add(nameArea);
                    askPanel.add(contentArea);
                    newItem = askPanel;
                    ((JButton) c).setIcon(null);
                    ((JButton) c).setText("Confirm");
                    dragArea.setLayout(new GridLayout(dragArea.getComponentCount()+1, 0, 0, 5));
                    dragArea.add(askPanel);
                }
                else{
                    switch((String)sectionSelector.getSelectedItem()){
                        case "Data Structures":
                          JPanel found =  (JPanel)  dragArea.getComponent(dsList.size()) ;
                          JTextArea name = (JTextArea) found.getComponent(0);
                          JTextArea content = (JTextArea) found.getComponent(1);
                          DragLabel newLabel = new DragLabel();
                          newLabel.setLabelName(name.getText());
                          newLabel.setLabelContent(content.getText());
                          dragArea.remove(dsList.size());
                          dsList.add(newLabel);
                          sectionSelector.setSelectedIndex(2);
                          sectionSelector.setSelectedIndex(1);
                            ((JButton) c).setText(null);
                            ((JButton) c).setIcon(plusIcon);
                            break;
                        case "Data Types":
                            JPanel found2 =  (JPanel)  dragArea.getComponent(dtList.size()) ;
                            JTextArea name2 = (JTextArea) found2.getComponent(0);
                            JTextArea content2 = (JTextArea) found2.getComponent(1);
                            DragLabel newLabel2 = new DragLabel();
                            newLabel2.setLabelName(name2.getText());
                            newLabel2.setLabelContent(content2.getText());
                            dragArea.remove(dtList.size());
                            dtList.add(newLabel2);
                            sectionSelector.setSelectedIndex(3);
                            sectionSelector.setSelectedIndex(2);
                            ((JButton) c).setText(null);
                            ((JButton) c).setIcon(plusIcon);
                            break;
                        case "Testing":
                            JPanel found3 =  (JPanel)  dragArea.getComponent(testingList.size()) ;
                            JTextArea name3 = (JTextArea) found3.getComponent(0);
                            JTextArea content3 = (JTextArea) found3.getComponent(1);
                            DragLabel newLabel3 = new DragLabel();
                            newLabel3.setLabelName(name3.getText());
                            newLabel3.setLabelContent(content3.getText());
                            dragArea.remove(testingList.size());
                            testingList.add(newLabel3);
                            sectionSelector.setSelectedIndex(3);
                            sectionSelector.setSelectedIndex(4);
                            ((JButton) c).setText(null);
                            ((JButton) c).setIcon(plusIcon);
                            break;
                        case "Methods":
                            JPanel found4 =  (JPanel)  dragArea.getComponent(methodList.size()) ;
                            JTextArea name4 = (JTextArea) found4.getComponent(0);
                            JTextArea content4 = (JTextArea) found4.getComponent(1);
                            DragLabel newLabel4 = new DragLabel();
                            newLabel4.setLabelName(name4.getText());
                            newLabel4.setLabelContent(content4.getText());
                            dragArea.remove(methodList.size());
                            methodList.add(newLabel4);
                            sectionSelector.setSelectedIndex(4);
                            sectionSelector.setSelectedIndex(3);
                            ((JButton) c).setText(null);
                            ((JButton) c).setIcon(plusIcon);
                            break;
                    }

                }
                /*
                JButton newButton = new JButton(emptyIcon);
                newButton.setUI((ButtonUI) BasicButtonUI.createUI(newButton));
                switch((String)sectionSelector.getSelectedItem()){
                    case "Data Structures":
                        newButton.setBackground(pink);
                        break;
                    case "Data Types":
                        newButton.setBackground(blue);
                    case "Testing":
                        newButton.setBackground(green);
                    case "Methods":
                        newButton.setBackground(yellow);
                }
                newPanel.setLayout(new BorderLayout());
                newPanel.add(newArea, BorderLayout.CENTER);
                newPanel.add(newButton, BorderLayout.EAST);
                //THIS WILL NOT WORK, MAKE SECTIONSELECTOR USE LISTS AND THEN ADD THIS TO THE RIGHT LIST
                dragArea.add(newPanel);
                */
            }
        };
        addBtn.addActionListener(addListener);



        //set up sectionSelector drop down box
        ItemListener i = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    switch((String)sectionSelector.getSelectedItem()){
                        case "Data Structures":
                            addBtn.setVisible(true);
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(dtList.size(), 0, 0, 5));

                            for(DragLabel Label : dsList){

                                //Create the label
                                JTextArea label = new JTextArea(Label.getLabelName());
                                label.setDragEnabled(true);
                                label.setEditable(false);
                                label.setBackground(pink);
                                label.setFont(new Font("Times New Roman", Font.BOLD,16));
                                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                                label.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                label.setForeground(Color.BLACK);
                                MouseListener dtListener = new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        //System.out.println("test2");
                                        numClicks++;
                                        JComponent c = (JComponent)e.getSource();
                                        ((JTextArea) c).setEditable(true);
                                        String name = ((JTextArea) c).getText();
                                        if(numClicks < 2) {
                                            ((JTextArea) c).setText(Label.getLabelContent());
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
                                        ((JTextArea) c).setText(Label.getLabelName());
                                        Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                                        ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                        ((JTextArea) c).setEditable(false);
                                    }

                                };
                                label.addMouseListener(dtListener);

                                //create the star button
                                JButton starbtn =new JButton(emptyIcon);
                                starbtn.addActionListener(favouriteListener);
                                starbtn.setUI((ButtonUI) BasicButtonUI.createUI(starbtn));
                                Border btnBorder = BorderFactory.createLineBorder(Color.BLACK,1);
                                starbtn.setBorder(btnBorder);
                                starbtn.setBackground(pink);
                                //create the holder
                                JPanel holder = new JPanel();
                                holder.setLayout(new BorderLayout());
                                holder.add(label, BorderLayout.CENTER);
                                holder.add(starbtn, BorderLayout.EAST);
                                dragArea.add(holder);

                            }
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Data Types":
                            addBtn.setVisible(true);
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(dtList.size(), 0, 0, 5));



                            for(DragLabel Label : dtList){

                                //Create the label
                                JTextArea label = new JTextArea(Label.getLabelName());
                                label.setDragEnabled(true);
                                label.setEditable(false);
                                label.setBackground(blue);
                                label.setFont(new Font("Times New Roman", Font.BOLD,16));
                                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                                label.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                label.setForeground(Color.BLACK);
                                MouseListener dtListener = new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        //System.out.println("test2");
                                        numClicks++;
                                        JComponent c = (JComponent)e.getSource();
                                        ((JTextArea) c).setEditable(true);
                                        String name = ((JTextArea) c).getText();
                                        if(numClicks < 2) {
                                            ((JTextArea) c).setText(Label.getLabelContent());
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
                                        ((JTextArea) c).setText(Label.getLabelName());
                                        Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                                        ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                        ((JTextArea) c).setEditable(false);
                                    }

                                };
                                label.addMouseListener(dtListener);

                                //create the star button
                                JButton starbtn =new JButton(emptyIcon);
                                starbtn.addActionListener(favouriteListener);
                                starbtn.setUI((ButtonUI) BasicButtonUI.createUI(starbtn));
                                Border btnBorder = BorderFactory.createLineBorder(Color.BLACK,1);
                                starbtn.setBorder(btnBorder);
                                starbtn.setBackground(blue);
                                //create the holder
                                JPanel holder = new JPanel();
                                holder.setLayout(new BorderLayout());
                                holder.add(label, BorderLayout.CENTER);
                                holder.add(starbtn, BorderLayout.EAST);
                                dragArea.add(holder);

                            }

                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Testing":
                            addBtn.setVisible(true);
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(testingList.size(), 0, 0, 5));

                            for(DragLabel Label : testingList){

                                //Create the label
                                JTextArea label = new JTextArea(Label.getLabelName());
                                label.setDragEnabled(true);
                                label.setEditable(false);
                                label.setBackground(green);
                                label.setFont(new Font("Times New Roman", Font.BOLD,16));
                                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                                label.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                label.setForeground(Color.BLACK);
                                MouseListener dtListener = new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        //System.out.println("test2");
                                        numClicks++;
                                        JComponent c = (JComponent)e.getSource();
                                        ((JTextArea) c).setEditable(true);
                                        String name = ((JTextArea) c).getText();
                                        if(numClicks < 2) {
                                            ((JTextArea) c).setText(Label.getLabelContent());
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
                                        ((JTextArea) c).setText(Label.getLabelName());
                                        Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                                        ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                        ((JTextArea) c).setEditable(false);
                                    }

                                };
                                label.addMouseListener(dtListener);

                                //create the star button
                                JButton starbtn =new JButton(emptyIcon);
                                starbtn.addActionListener(favouriteListener);
                                starbtn.setUI((ButtonUI) BasicButtonUI.createUI(starbtn));
                                Border btnBorder = BorderFactory.createLineBorder(Color.BLACK,1);
                                starbtn.setBorder(btnBorder);
                                starbtn.setBackground(green);
                                //create the holder
                                JPanel holder = new JPanel();
                                holder.setLayout(new BorderLayout());
                                holder.add(label, BorderLayout.CENTER);
                                holder.add(starbtn, BorderLayout.EAST);
                                dragArea.add(holder);


                            }
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Methods":
                            addBtn.setVisible(true);
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(methodList.size(), 0, 0, 5));

                            for(DragLabel Label : methodList){

                                //Create the label
                                JTextArea label = new JTextArea(Label.getLabelName());
                                label.setDragEnabled(true);
                                label.setEditable(false);
                                label.setBackground(yellow);
                                label.setFont(new Font("Times New Roman", Font.BOLD,16));
                                Border border = BorderFactory.createLineBorder(Color.BLACK,1);
                                label.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                label.setForeground(Color.BLACK);
                                MouseListener dtListener = new MouseAdapter() {
                                    @Override
                                    public void mousePressed(MouseEvent e) {
                                        //System.out.println("test2");
                                        numClicks++;
                                        JComponent c = (JComponent)e.getSource();
                                        ((JTextArea) c).setEditable(true);
                                        String name = ((JTextArea) c).getText();
                                        if(numClicks < 2) {
                                            ((JTextArea) c).setText(Label.getLabelContent());
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
                                        ((JTextArea) c).setText(Label.getLabelName());
                                        Border b3 = BorderFactory.createLineBorder(Color.BLACK,1);
                                        ((JTextArea) c).setBorder(BorderFactory.createCompoundBorder(b3, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
                                        ((JTextArea) c).setEditable(false);
                                    }

                                };
                                label.addMouseListener(dtListener);

                                //create the star button
                                JButton starbtn =new JButton(emptyIcon);
                                starbtn.addActionListener(favouriteListener);
                                starbtn.setUI((ButtonUI) BasicButtonUI.createUI(starbtn));
                                Border btnBorder = BorderFactory.createLineBorder(Color.BLACK,1);
                                starbtn.setBorder(btnBorder);
                                starbtn.setBackground(yellow);
                                //create the holder
                                JPanel holder = new JPanel();
                                holder.setLayout(new BorderLayout());
                                holder.add(label, BorderLayout.CENTER);
                                holder.add(starbtn, BorderLayout.EAST);
                                dragArea.add(holder);

                            }
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Favourites":
                            addBtn.setVisible(false);
                            dragArea.removeAll();
                            if(favs.size() == 0){
                                dragArea.setLayout(new GridLayout(1, 0, 0, 5));
                            }
                            else {
                                dragArea.setLayout(new GridLayout(favs.size(), 0, 0, 5));
                            }
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