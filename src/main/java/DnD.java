import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
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


    int numClicks = 0;






    private JTextArea a1;

    public DnD(ToolWindow toolWindow) {
        JTextArea temp = new JTextArea("temp");
        JTextArea temp2 = new JTextArea("temp");
        JTextArea temp3 = new JTextArea("temp");
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
                            dragArea.add( arrayArea);
                            dragArea.add(listArea);
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Data Types":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(5, 0, 0, 5));
                            dragArea.add(intArea);
                            dragArea.add(doubleArea);
                            dragArea.add(booleanArea);
                            dragArea.add(charArea);
                            dragArea.add(stringArea);
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Testing":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(13, 0, 0, 5));
                            dragArea.add(docDescArea);
                            dragArea.add(docSecArea);
                            dragArea.add(testMethodArea);
                            dragArea.add(assertArea);
                            dragArea.add(isArea);
                            dragArea.add(anyArea);
                            dragArea.add(allOfArea);
                            dragArea.add(anyOfArea);
                            dragArea.add(notMatchArea);
                            dragArea.add(equalToArea);
                            dragArea.add(instanceOfArea);
                            dragArea.add(nullArea);
                            dragArea.add(instanceSameArea);
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Methods":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(6, 0, 0, 5));
                            dragArea.add(mainArea);
                            dragArea.add(ifArea);
                            dragArea.add(elseArea);
                            dragArea.add(whileArea);
                            dragArea.add(forArea);
                            dragArea.add(printArea);
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
                System.out.println(name);
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
                System.out.println(name);
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
                System.out.println("press " + name);
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
                System.out.println("left " + name);
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
                Color yellow = new Color(255, 255, 237);
                j.setBackground(yellow);
                j.addMouseListener(methodListener);
            }
            if(counter>5 && counter <= 18){
                Color green = new Color(152, 251, 152);
                j.setBackground(green);
                j.addMouseListener(testingListener);
            }
            if(counter>18 && counter <= 23){
                Color blue = new Color(173,216,230);
                j.setBackground(blue);
                j.addMouseListener(typeListener);
            }
            if(counter>23 && counter <= 25){
                Color red = new Color(255,204,203);
                j.setBackground(red);
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