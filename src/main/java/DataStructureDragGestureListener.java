import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.io.IOException;

public class DataStructureDragGestureListener implements DragGestureListener {
    @Override
    public void dragGestureRecognized(DragGestureEvent event) {
        JLabel label = (JLabel) event.getComponent();
        String text;
        if(label.getText() == "List"){
            text = "ArrayL" + label.getText().substring(1) + "<> X = new ArrayList(); ";
        }
        else{
            text = "[] X = new []; ";
        }

        Transferable transferable = new Transferable() {

            @Override
            public DataFlavor[] getTransferDataFlavors() {
                return new DataFlavor[]{DataFlavor.stringFlavor};
            }

            @Override
            public boolean isDataFlavorSupported(DataFlavor flavor) {
                if (!isDataFlavorSupported(flavor)) {
                    return false;
                }
                return true;
            }

            @Override
            public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
                return text;
            }
        };
        event.startDrag(null, transferable);
    }
}
