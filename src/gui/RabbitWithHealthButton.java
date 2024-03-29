package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class RabbitWithHealthButton extends JButton implements Serializable, ActionListener {

    private ItemTypeRole itemType;
    private int rows;
    private int columns;
    private ParcelFrameRole[][] cell;

    public RabbitWithHealthButton(String name, int otherRows, int otherColumns, ParcelFrameRole[][] otherCell) {
        addActionListener(this);
        this.rows = otherRows;
        this.columns = otherColumns;
        this.cell = otherCell;
        setText(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        itemType = new RabbitWithHealthItem();
        for (int x = 2; x < rows; x++) {
            for (int y = 2; y < columns; y++) {
                ((InnerParcelFrame) cell[x][y]).removeActionActionListener();
                cell[x][columns].setEnable(false);
            }
        }
        for (int x = 1; x <= rows; x++) {
            ((InnerParcelFrame) cell[x][1]).setItemType(itemType);
            ((InnerParcelFrame) cell[x][columns]).setItemType(itemType);
            cell[x][1].setEnable(true);
            cell[x][columns].setEnable(true);
        }
        for (int x = 1; x <= columns; x++) {
            ((InnerParcelFrame) cell[1][x]).setItemType(itemType);
            ((InnerParcelFrame) cell[rows][x]).setItemType(itemType);
            cell[1][x].setEnable(true);
            cell[rows][x].setEnable(true);
        }
    }
}
