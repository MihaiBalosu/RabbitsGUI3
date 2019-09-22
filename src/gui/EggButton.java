package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class EggButton extends JButton implements ActionListener, Serializable {

    private int rows;
    private int columns;
    private ParcelFrameRole[][] cell;

    public EggButton(String name, ParcelFrameRole[][] otherCell, int otherRows, int otherColumns) {
        addActionListener(this);
        setText(name);
        this.rows = otherRows;
        this.columns = otherColumns;
        this.cell = otherCell;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ItemTypeRole itemType = new EggItem();
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                ((InnerParcelFrame) cell[x][y]).removeActionActionListener();
            }
        }
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                ((InnerParcelFrame) cell[x][y]).addActionActionListener();
                ((InnerParcelFrame) cell[x][y]).setItemType(itemType);
            }
        }
    }

}