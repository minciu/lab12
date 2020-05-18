package lab12;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;



public class ProprietiesPanel extends JPanel {
    private final MainFrame frame;
    private final JTable proprietiesTable;

    public ProprietiesPanel(MainFrame frame) {
        this.frame = frame;
        this.proprietiesTable = new JTable(new DefaultTableModel(new String[]{"Type", "Name"}, 100));
        init();
    }

    private void init() {
        setLayout(new BorderLayout());
        proprietiesTable.setFillsViewportHeight(true);
        JScrollPane scrollTable = new JScrollPane(proprietiesTable);
        add(scrollTable, BorderLayout.CENTER);
    }

	public MainFrame getFrame() {
		return frame;
	}

	public JTable getProprietiesTable() {
		return proprietiesTable;
	}

	
}