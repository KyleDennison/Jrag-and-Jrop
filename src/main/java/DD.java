import com.intellij.openapi.wm.ToolWindow;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class DD {
    private JPanel panel1;
    private JPanel dropArea;
    private JPanel dragArea;
    private JLabel ifLabel;
    private JButton btn;



    public DD(ToolWindow toolWindow) {
        ifLabel.setTransferHandler(new TransferHandler("text"));
        MouseListener ml = new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                JComponent c = (JComponent)e.getSource();
                TransferHandler th = c.getTransferHandler();
                th.exportAsDrag(c, e, TransferHandler.COPY);
            }
        };
        ifLabel.addMouseListener(ml);
           btn.setTransferHandler(new TransferHandler("text"));
    }

    public JPanel getContent() {
        return panel1;
    }
}
