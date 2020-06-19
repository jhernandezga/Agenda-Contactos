package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import logica.Conexion;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class UI extends JFrame {

	private JPanel contentPane;
	private JTextField buscarField;
	private JTextField nombreField;
	private JTextField apellidoField;
	private JTextField emailField;
	private JTextField direccionField;
	private JTextField ciudadField;
	private JTextField telefonoField;
	private DefaultTableModel model;
	private JTable tabla;
	private int filaSeleccionada = -1;
	private JScrollPane deslizador;
	
	public UI()
	{
		
		iniComponents();
	}

	public void iniComponents() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "name_278216546736500");
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.3, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		JLabel tituloLabel = new JLabel("Agenda de Contactos");
		tituloLabel.setForeground(new Color(30, 144, 255));
		tituloLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 17));
		tituloLabel.setBounds(215, 0, 207, 30);
		panel_1.add(tituloLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 3;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[] {5};
		gbl_panel_3.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel busqueda = new JLabel("Q");
		GridBagConstraints gbc_busqueda = new GridBagConstraints();
		gbc_busqueda.insets = new Insets(0, 0, 0, 5);
		gbc_busqueda.anchor = GridBagConstraints.EAST;
		gbc_busqueda.gridx = 0;
		gbc_busqueda.gridy = 0;
		panel_3.add(busqueda, gbc_busqueda);
		
		buscarField = new JTextField();
		buscarField.setText("");
		GridBagConstraints gbc_buscarField = new GridBagConstraints();
		gbc_buscarField.insets = new Insets(0, 0, 0, 5);
		gbc_buscarField.fill = GridBagConstraints.HORIZONTAL;
		gbc_buscarField.gridx = 1;
		gbc_buscarField.gridy = 0;
		panel_3.add(buscarField, gbc_buscarField);
		buscarField.setColumns(10);
		
		JButton buscarButton = new JButton("Buscar");
		buscarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		GridBagConstraints gbc_buscarButton = new GridBagConstraints();
		gbc_buscarButton.insets = new Insets(0, 0, 0, 5);
		gbc_buscarButton.gridx = 2;
		gbc_buscarButton.gridy = 0;
		panel_3.add(buscarButton, gbc_buscarButton);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 4;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel titulo3Label = new JLabel("Agregar Contactos");
		titulo3Label.setForeground(new Color(30, 144, 255));
		titulo3Label.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		panel_5.add(titulo3Label);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(null);
		
		JLabel nombreLabel = new JLabel("Nombre");
		nombreLabel.setBounds(0, 11, 46, 14);
		panel_6.add(nombreLabel);
		
		nombreField = new JTextField();
		nombreField.setBounds(56, 8, 135, 20);
		panel_6.add(nombreField);
		nombreField.setColumns(10);
		
		JLabel apellidoLable = new JLabel("Apellido");
		apellidoLable.setBounds(0, 36, 46, 14);
		panel_6.add(apellidoLable);
		
		apellidoField = new JTextField();
		apellidoField.setBounds(56, 33, 135, 20);
		panel_6.add(apellidoField);
		apellidoField.setColumns(10);
		
		JLabel emailLable = new JLabel("Email");
		emailLable.setBounds(201, 11, 46, 14);
		panel_6.add(emailLable);
		
		emailField = new JTextField();
		emailField.setBounds(267, 8, 125, 20);
		panel_6.add(emailField);
		emailField.setColumns(10);
		
		JLabel direccionLabel = new JLabel("Direccion");
		direccionLabel.setBounds(201, 36, 46, 14);
		panel_6.add(direccionLabel);
		
		direccionField = new JTextField();
		direccionField.setBounds(267, 33, 125, 20);
		panel_6.add(direccionField);
		direccionField.setColumns(10);
		
		JLabel ciudadLabel = new JLabel("Ciudad");
		ciudadLabel.setBounds(415, 11, 46, 14);
		panel_6.add(ciudadLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds(415, 36, 46, 14);
		panel_6.add(telefonoLabel);
		
		ciudadField = new JTextField();
		ciudadField.setBounds(471, 8, 118, 20);
		panel_6.add(ciudadField);
		ciudadField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(471, 33, 118, 20);
		panel_6.add(telefonoField);
		telefonoField.setColumns(10);
		
		JButton agregarButton = new JButton("Agregar");
		agregarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}

		});
		agregarButton.setBounds(415, 66, 91, 23);
		panel_6.add(agregarButton);
		
		
		model = new DefaultTableModel();
		model.addColumn("#");
		model.addColumn("Nombre");
		model.addColumn("Apellido");
		model.addColumn("Email");
		model.addColumn("Direccion");
		model.addColumn("Ciudad");
		model.addColumn("Telefono");
		tabla = new JTable(model) {

			private static final long serialVersionUID = 1L;
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				if(columnIndex == 0) {
					return false;
				}
				return true;
			}
			
		};
		deslizador = new JScrollPane(tabla);
		deslizador.setBounds(20, 5, 600, 150);
		panel_2.add(deslizador);
		tabla.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				filaSeleccionada = tabla.getSelectedRow();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton eliminarButton = new JButton("Eliminar");
		eliminarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		eliminarButton.setBounds(352, 166, 89, 23);
		panel_2.add(eliminarButton);
		
		
		JButton guardarButton = new JButton("Guardar Edicion");
		guardarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editar();
			}
		});
		guardarButton.setBounds(451, 166, 121, 23);
		panel_2.add(guardarButton);
		
		
		
	
	}
	public void  limpiar()
	{
		nombreField.setText("");
		apellidoField.setText("");
		emailField.setText("");
		direccionField.setText("");
		ciudadField.setText("");
		telefonoField.setText("");

	}
	public void click()
	{
		System.out.println(tabla.getSelectedRow());
	
	}
	
	public void eliminar() {
		
		if(filaSeleccionada!=-1) {
			model.removeRow(filaSeleccionada);
			limpiarTabla();
			Conexion.conexionEliminar(filaSeleccionada);
			filaSeleccionada=-1;
		}
		
		
	}

	public void editar() {
		if(filaSeleccionada != -1) {
			Conexion.conexionEditar(filaSeleccionada, model.getDataVector().elementAt(filaSeleccionada));
			/*Vector data = model.getDataVector().elementAt(filaSeleccionada);
			for(int i = 1; i<=6;i++) {
				System.out.println(data.get(i).getClass());
			}*/
			JOptionPane.showMessageDialog(contentPane, "Se han guardado lo cambios de edición correctamente");
			filaSeleccionada = -1;
		}
		
	}

	public void agregar() {
	
		String captura[] = { ""+(model.getRowCount()+1)+"",nombreField.getText() ,apellidoField.getText(),emailField.getText(),
				direccionField.getText(),ciudadField.getText(),telefonoField.getText()};
		if(Conexion.conexionAgregar(captura[1], captura[2], captura[3], captura[4], captura[5], captura[6]))
		{
			limpiar();
			
			JOptionPane.showMessageDialog(contentPane, "Se ha agregado a "+captura[1] +" " +captura[2]+ " correctamente");
		}
		
	}
	
	
	
	//Este método es para pasarle los datos iniciales  desde el paquete de Lógica
	public void agregar(String matrizDatos[][])
	{
		limpiarTabla();
		for(int i = 0; i < matrizDatos.length; i++)
		{
			model.addRow(matrizDatos[i]);
			
		}
		
	}
	
	public void buscar() {
		
		int aBuscar = Conexion.conexionBuscar(this.buscarField.getText());
		if(aBuscar == -1) {
			JOptionPane.showMessageDialog(contentPane, "Este contacto no Existe");
			
		}else {
			tabla.requestFocus();
			tabla.changeSelection(aBuscar,1,false, false);
			
			
		}
		
	}
	
	
	
	public void limpiarTabla() {
		
		int count = model.getRowCount()-1;
	
		for(int i = count; i>= 0 ;i--) {
			model.removeRow(i);
		}
	}
}
