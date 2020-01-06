import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.*;


public class DD {
    private JPanel panel1;
    private JPanel dropArea;
    private JPanel dragArea;

    private JLabel ifLabel;
    private JTextArea textArea1;
    private JScrollPane sp;
    private JComboBox sectionSelector;
    private JPanel LabelArea;
    private JScrollPane sp2;
    int numColumns = 1;
    private JLabel arrayLabel;
    private  JLabel listLabel;
    private JLabel intLabel;
    private  JLabel doubleLabel;
    private JLabel booleanLabel;
    private  JLabel charLabel;
    private JLabel stringLabel;
    private JLabel plusLabel;
    private  JLabel minusLabel;
    private JLabel multiplyLabel;
    private  JLabel divideLabel;
    private JLabel percentLabel;
    private JLabel andLabel;
    private  JLabel orLabel;
    private JLabel notLabel;
    private  JLabel setLabel;
    private JLabel equalLabel;
    private JLabel notequalLabel;
    private  JLabel lessthanLabel;
    private JLabel greaterthanLabel;
    private  JLabel lessequalLabel;
    private JLabel greaterequalLabel;
    private  JLabel elseLabel;
    private JLabel forLabel;
    private  JLabel whileLabel;
    private JLabel printLabel;

    public DD(ToolWindow toolWindow) {
        //Setting up labels
        arrayLabel = new JLabel("Array");
        listLabel = new JLabel("List");
        intLabel = new JLabel("int");
        doubleLabel = new JLabel("double");
        booleanLabel = new JLabel("boolean");
        charLabel = new JLabel("char");
        stringLabel = new JLabel("string");
        plusLabel = new JLabel("+");
        minusLabel= new JLabel("-");
        multiplyLabel = new JLabel("*");
        divideLabel = new JLabel("/");
        percentLabel= new JLabel("%");
        andLabel = new JLabel("&&");
        orLabel = new JLabel("||");
        notLabel = new JLabel("!");
        setLabel = new JLabel("=");
        equalLabel = new JLabel("==");
        notequalLabel = new JLabel("!=");
        lessthanLabel = new JLabel("<");
        greaterthanLabel = new JLabel(">");
        lessequalLabel = new JLabel("<=");
        greaterequalLabel = new JLabel(">=");
        elseLabel= new JLabel("else");
        forLabel= new JLabel("for");
        whileLabel= new JLabel("while");
        printLabel= new JLabel("print");

        //set up sectionSelector drop down box
        ItemListener i = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
                    System.out.println("Change");
                    switch((String)sectionSelector.getSelectedItem()){
                        case "Data Structures":
                            LabelArea.removeAll();
                            LabelArea.setLayout(new GridLayout(2, 0, 0, 5));
                            LabelArea.add( arrayLabel);
                            LabelArea.add(listLabel);
                            LabelArea.revalidate();
                            LabelArea.repaint();
                            break;
                        case "Data Types":
                            LabelArea.removeAll();
                            LabelArea.setLayout(new GridLayout(5, 0, 0, 5));
                            LabelArea.add(intLabel);
                            LabelArea.add(doubleLabel);
                            LabelArea.add(booleanLabel);
                            LabelArea.add(charLabel);
                            LabelArea.add(stringLabel);
                            LabelArea.revalidate();
                            LabelArea.repaint();
                            break;
                        case "Operators":
                            System.out.println("Op");
                            LabelArea.removeAll();
                            LabelArea.setLayout(new GridLayout(15, 0, 0, 5));
                            LabelArea.add(plusLabel);
                            LabelArea.add(minusLabel);
                            LabelArea.add(multiplyLabel);
                            LabelArea.add(divideLabel);
                            LabelArea.add(percentLabel);
                            LabelArea.add(andLabel);
                            LabelArea.add(orLabel);
                            LabelArea.add(notLabel);
                            LabelArea.add(setLabel);
                            LabelArea.add(equalLabel);
                            LabelArea.add(notequalLabel);
                            LabelArea.add(lessthanLabel);
                            LabelArea.add(greaterthanLabel);
                            LabelArea.add(lessequalLabel);
                            LabelArea.add(greaterequalLabel);
                            LabelArea.revalidate();
                            LabelArea.repaint();
                            break;
                        case "Methods":
                            LabelArea.removeAll();
                            LabelArea.setLayout(new GridLayout(5, 0, 0, 5));
                            LabelArea.add(ifLabel);
                            LabelArea.add(elseLabel );
                            LabelArea.add( forLabel);
                            LabelArea.add(whileLabel);
                            LabelArea.add(printLabel);
                            LabelArea.revalidate();
                            LabelArea.repaint();
                            break;

                    }
                }

            }
        };
        sectionSelector.addItemListener(i);

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


        //Set up label to drag into text area
        MyDragGestureListener dlistener = new MyDragGestureListener();
        DragSource ds1 = new DragSource();
        ds1.createDefaultDragGestureRecognizer(ifLabel, DnDConstants.ACTION_COPY, dlistener);
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

//ifLabel.addMouseListener(ml);
//elseLabel.addMouseListener(ml);
//textArea1.addMouseListener(ml2);
//DropTarget dt = new DropTarget(textArea1,d);