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

    private JTextArea textArea1;
    private JScrollPane sp;
    private JComboBox sectionSelector;
    private JPanel LabelArea;
    private JTextArea a2;
    private JTextArea a3;
    private JTextArea a4;
    private JTextArea a5;
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
    private JLabel ifLabel;
    private  JLabel elseLabel;
    private JLabel forLabel;
    private  JLabel whileLabel;
    private JLabel printLabel;
    private JTextArea a1;

    public DD(ToolWindow toolWindow) {
        a1 = new JTextArea("if()");
        a2=new JTextArea("while()");
        a3= new JTextArea("for()");
        a4=new JTextArea("each");
        a5=new JTextArea("print()");




        //Setting up labels
        arrayLabel = new JLabel("Array");
        listLabel = new JLabel("List");
        intLabel = new JLabel("int");
        doubleLabel = new JLabel("double");
        booleanLabel = new JLabel("boolean");
        charLabel = new JLabel("char");
        stringLabel = new JLabel("String");
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
        ifLabel = new JLabel("if()");
        elseLabel= new JLabel("else");
        forLabel= new JLabel("for()");
        whileLabel= new JLabel("while()");
        printLabel= new JLabel("print()");
        //set up sectionSelector drop down box
        ItemListener i = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED) {
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
                            /*
                            LabelArea.add(ifLabel);
                            LabelArea.add(elseLabel );
                            LabelArea.add( forLabel);
                            LabelArea.add(whileLabel);
                            LabelArea.add(printLabel);
                             */
                            LabelArea.add(a1);
                            LabelArea.add(a2);
                            LabelArea.add(a3);
                            LabelArea.add(a4);
                            LabelArea.add(a5);
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

        //Set up labels to drag into text area
        MethodDragGestureListener mlistener = new MethodDragGestureListener();
        DragSource d1 = new DragSource();
        DragSource d2 = new DragSource();
        DragSource d3 = new DragSource();
        DragSource d4 = new DragSource();
        DragSource d5 = new DragSource();
        //d1.createDefaultDragGestureRecognizer(ifLabel, DnDConstants.ACTION_COPY, mlistener);
        d2.createDefaultDragGestureRecognizer(elseLabel, DnDConstants.ACTION_COPY, mlistener);
        d3.createDefaultDragGestureRecognizer(whileLabel, DnDConstants.ACTION_COPY, mlistener);
        d4.createDefaultDragGestureRecognizer(forLabel, DnDConstants.ACTION_COPY, mlistener);
        d5.createDefaultDragGestureRecognizer(printLabel, DnDConstants.ACTION_COPY, mlistener);

        DataStructureDragGestureListener dsListener = new DataStructureDragGestureListener();
        DragSource d6 = new DragSource();
        DragSource d7 = new DragSource();
        d6.createDefaultDragGestureRecognizer(listLabel, DnDConstants.ACTION_COPY, dsListener);
        d7.createDefaultDragGestureRecognizer(arrayLabel, DnDConstants.ACTION_COPY, dsListener);

        DataTypeDragGestureListener dtListener = new DataTypeDragGestureListener();
        DragSource d8 = new DragSource();
        DragSource d9 = new DragSource();
        DragSource d10 = new DragSource();
        DragSource d11 = new DragSource();
        DragSource d12 = new DragSource();
        d8.createDefaultDragGestureRecognizer(intLabel, DnDConstants.ACTION_COPY, dtListener);
        d9.createDefaultDragGestureRecognizer(stringLabel, DnDConstants.ACTION_COPY, dtListener);
        d10.createDefaultDragGestureRecognizer(doubleLabel, DnDConstants.ACTION_COPY, dtListener);
        d11.createDefaultDragGestureRecognizer(booleanLabel, DnDConstants.ACTION_COPY, dtListener);
        d12.createDefaultDragGestureRecognizer(charLabel, DnDConstants.ACTION_COPY, dtListener);

        MouseListener ml = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("test2");
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                ((JTextArea) c).setText("if(){" + "\n" + "\n" +"}");
                ((JTextArea) c).selectAll();
                ((JTextArea) c).setEditable(false);
                //TransferHandler th = c.getTransferHandler();
                //th.exportAsDrag(c, e, TransferHandler.MOVE);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                JComponent c = (JComponent)e.getSource();
                ((JTextArea) c).setEditable(true);
                ((JTextArea) c).setText("if()");
                ((JTextArea) c).setEditable(false);
            }

        };
        a1.setDragEnabled(true);
        a1.setEditable(false);

        //a1.setTransferHandler(new TransferHandler("text"));
        a1.addMouseListener(ml);
        //a1.setEditable(false);
        //ifLabel.setTransferHandler(new TransferHandler("text"));
        //ifLabel.addMouseListener(ml);


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