package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class ejercicio1 extends JFrame implements ActionListener {
	
	double aCobre=0.0, aBronce=0.0,	aSilver=0.0, aGold=0.0;
	
	//Acumulador: Cantidad de licencias vendida
	int alCobre=0, alBronce=0, alSilver=0, alGold=0;
	
	//Contadores: Cantidad de ventas efectuadas.
	int cvCobre=0, cvBronce=0, cvSilver=0, cvGold=0;
	
	
	// Metodos
	
	String LeerTipoLincencia() {
		return cbotipo.getSelectedItem().toString();
	}
	
	double LeerCostoLicencia() {
		String tipo = LeerTipoLincencia();
		double costo = 0.0;
		if (tipo == "Cobre")
			costo = 510.00;
		else if (tipo == "Bronce")
			costo = 1500.00;
		else if (tipo == "Silver")
			costo = 3100.00;
		else
			costo = 4500.00;
		return costo;
	}
	
	int LeerCantidad() {
		return Integer.parseInt(txtcantidad.getText());
	}
	
	double obtenerImporteVenta() {
		return LeerCantidad() * LeerCostoLicencia();
	}
	
	
	// El importe total recaudado de cada tipo de licencia
	void obtenerConteo_Acumulado_PorLicencia() {
		double importe = obtenerImporteVenta();
		String tipo = LeerTipoLincencia();
		if (tipo == "Cobre") {
			aCobre+=importe; alCobre+=LeerCantidad(); cvCobre++;
		}
		else if (tipo == "Bronce") {
			aBronce+=importe; alBronce+=LeerCantidad(); cvBronce++;
		}
		else if (tipo == "Silver") {
			aSilver+=importe; alSilver+=LeerCantidad(); cvSilver++;
		}
		else {
			aGold+=importe; alGold+=LeerCantidad(); cvGold++;
		}
	}

	void Borrar() {
		txtcantidad.setText("");
		txts.setText("");
		cbotipo.requestFocus();
	}
	
	void Imprimir() {
		txts.setText("");
		txts.append("Importe a Pagar    : " + obtenerImporteVenta() + "\n");
		obtenerConteo_Acumulado_PorLicencia();
		txts.append("\n");
		txts.append("Importe total recaudado \n");
		txts.append("- Por licencias de Cobre      : " + aCobre + "\n");
		txts.append("- Por licencias de Bronze     : " + aBronce + "\n");
		txts.append("- Por licencias de Silver     : " + aSilver + "\n");
		txts.append("- Por licencias de Gold       : " + aGold + "\n");
		txts.append("\n");
		txts.append("Cantidad de Licencias vendidas \n");
		txts.append("- Por licencias de Cobre      : " + alCobre + "\n");
		txts.append("- Por licencias de Bronze     : " + alBronce + "\n");
		txts.append("- Por licencias de Silver     : " + alSilver + "\n");
		txts.append("- Por licencias de Gold       : " + alGold + "\n");
		txts.append("\n");
		txts.append("Cantidad de Ventas efectuadas\n");
		txts.append("- Por licencias de Cobre      : " + cvCobre + "\n");
		txts.append("- Por licencias de Bronze     : " + cvBronce + "\n");
		txts.append("- Por licencias de Silver     : " + cvSilver + "\n");
		txts.append("- Por licencias de Gold       : " + cvGold + "\n");
		
	}

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnprocesar;
	private JButton btnborrar;
	private JComboBox cbotipo;
	private JTextField txtcantidad;
	private JTextArea txts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio1 frame = new ejercicio1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ejercicio1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 503, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 139), 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblNewLabel = new JLabel("Tipo");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(41, 31, 45, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 58, 73, 13);
		contentPane.add(lblNewLabel_1);
		
		btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(this);
		btnprocesar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnprocesar.setBounds(302, 27, 103, 21);
		contentPane.add(btnprocesar);
		
		btnborrar = new JButton("Borrar");
		btnborrar.addActionListener(this);
		btnborrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnborrar.setBounds(302, 54, 103, 21);
		contentPane.add(btnborrar);
		
		cbotipo = new JComboBox();
		cbotipo.setFont(new Font("Arial", Font.PLAIN, 13));
		cbotipo.setModel(new DefaultComboBoxModel(new String[] {"Cobre", "Bronce", "Silver", "Gold"}));
		cbotipo.setBounds(114, 28, 70, 21);
		contentPane.add(cbotipo);
		
		txtcantidad = new JTextField();
		txtcantidad.setFont(new Font("Arial", Font.PLAIN, 13));
		txtcantidad.setBounds(124, 56, 45, 19);
		contentPane.add(txtcantidad);
		txtcantidad.setColumns(10);
		
		txts = new JTextArea();
		txts.setFont(new Font("Consolas", Font.PLAIN, 14));
		txts.setBounds(10, 94, 469, 510);
		contentPane.add(txts);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnborrar) {
			actionPerformedBtnborrar(e);
		}
		if (e.getSource() == btnprocesar) {
			actionPerformedBtnprocesar(e);
		}
	}
	protected void actionPerformedBtnprocesar(ActionEvent e) {
		
		Imprimir();
		
	}
	protected void actionPerformedBtnborrar(ActionEvent e) {
		
		Borrar();
		
	}
}
