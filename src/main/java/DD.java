import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;


public class DD {
    private JPanel panel1;
    private JPanel dropArea;
    private JPanel dragArea;

    private JLabel ifLabel;
    private JLabel elseLabel;
    private JTextArea textArea1;
    private JScrollPane sp;
    private JComboBox sectionSelector;
    private JPanel labelArea;
    int numColumns = 1;
    private JLabel arrayLabel;
    private  JLabel listLabel;

    public DD(ToolWindow toolWindow) {
        //Setting up labels
        arrayLabel = new JLabel("Array");
        listLabel = new JLabel("List");
        ArrayList<JLabel> dsList = new ArrayList<>();
        dsList.add(arrayLabel);
        dsList.add(listLabel);

        //set up sectionSelector drop down box
        ItemListener i = new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Change");

                switch((String)sectionSelector.getSelectedItem()){
                    case "Data Structures":
                        System.out.println("DS selected");
                        labelArea.removeAll();
                        labelArea.setLayout(new GridLayout(2, 0, 0, 5));
                        labelArea.add( arrayLabel);
                        labelArea.add(listLabel);
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