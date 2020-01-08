import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class DD {
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
    private  JTextArea plusArea;
    private  JTextArea minusArea;
    private  JTextArea multiplyArea;
    private  JTextArea dividerea;
    private  JTextArea percentArea;
    private  JTextArea andArea;
    private  JTextArea orArea;
    private  JTextArea notArea;
    private  JTextArea setArea;
    private  JTextArea equalArea;
    private  JTextArea notequalArea;
    private  JTextArea lessthanArea;
    private  JTextArea greaterthanArea;
    private  JTextArea lessequalArea;
    private  JTextArea greaterequalArea;
    private  JTextArea ifArea;
    private  JTextArea elseArea;
    private  JTextArea forArea;
    private  JTextArea whileArea;
    private  JTextArea printArea;
    int numClicks = 0;






    private JTextArea a1;

    public DD(ToolWindow toolWindow) {
        //setting up Text areas
        arrayArea=new JTextArea("array");
        listArea=new JTextArea("list");
        //24
        intArea=new JTextArea("int");
        doubleArea=new JTextArea("double");
        booleanArea=new JTextArea("boolean");
        charArea=new JTextArea("char");
        stringArea=new JTextArea("String");
        //19
        plusArea=new JTextArea("+");
        minusArea=new JTextArea("-");
        multiplyArea=new JTextArea("*");
        dividerea=new JTextArea("/");
        percentArea=new JTextArea("%");
        andArea=new JTextArea("&&");
        orArea=new JTextArea("||");
        notArea=new JTextArea("!");
        setArea=new JTextArea("=");
        equalArea=new JTextArea("==");
        notequalArea=new JTextArea("!=");
        lessthanArea=new JTextArea("<");
        greaterthanArea=new JTextArea(">");
        lessequalArea=new JTextArea("<=");
        greaterequalArea=new JTextArea(">=");
        //4
        ifArea=new JTextArea("if()");
        elseArea=new JTextArea("else");
        forArea=new JTextArea("for()");
        whileArea=new JTextArea("while()");
        printArea=new JTextArea("print()");
        ArrayList<JTextArea> h = new ArrayList<>();
        h.add(printArea);h.add(whileArea);h.add(forArea);h.add(elseArea);h.add(ifArea);h.add(greaterequalArea);h.add(lessequalArea);h.add(greaterthanArea);h.add(lessthanArea);h.add(notequalArea);h.add(equalArea);h.add(setArea);h.add(notArea);h.add(andArea);h.add(orArea);
        h.add(percentArea);h.add(dividerea);h.add(multiplyArea);h.add(minusArea);h.add(plusArea);h.add(stringArea);h.add(charArea);h.add(booleanArea);h.add(doubleArea);h.add(intArea);h.add(listArea);h.add(arrayArea);

        //set up sectionSelector drop down box
        ItemListener i = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    switch((String)sectionSelector.getSelectedItem()){
                        case "Data Structures":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(2, 2, 0, 5));
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
                        case "Operators":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(15, 0, 0, 5));
                            dragArea.add(plusArea);
                            dragArea.add(minusArea);
                            dragArea.add(multiplyArea);
                            dragArea.add(dividerea);
                            dragArea.add(percentArea);
                            dragArea.add(andArea);
                            dragArea.add(orArea);
                            dragArea.add(notArea);
                            dragArea.add(setArea);
                            dragArea.add(equalArea);
                            dragArea.add(notequalArea);
                            dragArea.add(lessthanArea);
                            dragArea.add(greaterthanArea);
                            dragArea.add(lessequalArea);
                            dragArea.add(greaterequalArea);
                            dragArea.revalidate();
                            dragArea.repaint();
                            break;
                        case "Methods":
                            dragArea.removeAll();
                            dragArea.setLayout(new GridLayout(5, 0, 0, 5));
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
                System.out.println(name);
                if(numClicks < 2) {
                    if (name.equals("else")) {
                        ((JTextArea) c).setText("else{" + "\n" + "\n" + "}");
                    } else if (name.equals("print()")) {
                        ((JTextArea) c).setText("System.out.println();");
                    } else {
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
        MouseListener operatorListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("test2");
                numClicks++;
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                String name = ((JTextArea) c).getText();
                System.out.println(name);
                if(numClicks < 2) {
                    ((JTextArea) c).setText(name);
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

            if(counter <=4){
                Color yellow = new Color(255, 255, 237);
                j.setBackground(yellow);
                j.addMouseListener(methodListener);
            }
            if(counter>4 && counter <= 19){
                Color green = new Color(152, 251, 152);
                j.setBackground(green);
                j.addMouseListener(operatorListener);
            }
            if(counter>19 && counter <= 24){
                Color blue = new Color(173,216,230);
                j.setBackground(blue);
                j.addMouseListener(typeListener);
            }
            if(counter>24 && counter <= 26){
                Color red = new Color(255,204,203);
                j.setBackground(red);
                j.addMouseListener(structureListener);
            }
            j.setFont(new Font("Times New Roman", Font.BOLD,16));
            Border border = BorderFactory.createLineBorder(Color.BLACK,1);
            j.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
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