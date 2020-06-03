package ui;

import javax.swing.table.AbstractTableModel;

public class ModeloTabla extends AbstractTableModel {

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 20;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 8;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return "sjakhdkajhsdjkawhdkahwkjdwahjdh";
	}
	
	public String getColumnName(int c)
	{
		return "Columna "+c;
		
	}

}
