package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

public class ejercicio2_Sueldos extends JFrame implements ActionListener {
	
	double sbruto0=0.0, sbruto1=0.0, sbruto2=0.0, sbruto3=0.0;
	int tothor0=0, tothor1=0, tothor2=0, tothor3=0;
	int canemp0=0, canemp1=0, canemp2=0, canemp3=0;
	
	String LeerCategoria() {
		return cbocat.getSelectedItem().toString();
	}
	
	int LeerCantidadHoras() {
		return Integer.parseInt(txthoras.getText());
	}
	
	double EstablecerTarifa() {
		String cat=LeerCategoria();
		double tarifa=0.0;
		if (cat=="A")
			tarifa=45.0;
		else if (cat=="B")
			tarifa=42.5;
		else if (cat=="C")
			tarifa=40.0;
		else
			tarifa=37.5;
		
		return tarifa;
	}
	
	double ObtenerSueldoBruto() {
		return LeerCantidadHoras()*EstablecerTarifa();
	}
	
	void ObtenerSueldos_Horas_CatnEmpleados() {
		
		String cat=LeerCategoria();
		double totsueldos=ObtenerSueldoBruto();
		int tothor=LeerCantidadHoras();
		
		if (cat=="A") {
			sbruto0+=totsueldos; tothor0+=tothor; canemp0++;
		}
		
		else if (cat=="B") {
			sbruto1+=totsueldos; tothor1+=tothor; canemp1++;
		}
		
		else if (cat=="C") {
			sbruto2+=totsueldos; tothor2+=tothor; canemp2++;
		}
		
		else {
			sbruto3+=totsueldos; tothor3+=tothor; canemp3++;
		}
	}
	
	void Borrar() {
		txthoras.setText("");
		txts.setText("");
		cbocat.requestFocus();
	}
	
	void Imprimir() {
		txts.setText("");
		txts.append("Sueldo Bruto......: "+ObtenerSueldoBruto()+"\n");
		ObtenerSueldos_Horas_CatnEmpleados();
		txts.append("\n");
		txts.append("Suma de sueldos brutos\n");
		txts.append("-De categoría A...: "+ sbruto0 +"\n");
		txts.append("-De categoría B...: "+ sbruto1 +"\n");
		txts.append("-De categoría C...: "+ sbruto2 +"\n");
		txts.append("-De categoría D...: "+ sbruto3 +"\n");
		txts.append("\n");
		txts.append("Suma total de horas trabajadas\n");
		txts.append("-De categoría A...: "+ tothor0 +"\n");
		txts.append("-De categoría B...: "+ tothor1 +"\n");
		txts.append("-De categoría C...: "+ tothor2 +"\n");
		txts.append("-De categoría D...: "+ tothor3 +"\n");
		txts.append("\n");
		txts.append("Cantidad total de empleados\n");
		txts.append("-De categpría A...: " +canemp0 +"\n");
		txts.append("-De categpría B...: " +canemp1 +"\n");
		txts.append("-De categpría C...: " +canemp2 +"\n");
		txts.append("-De categpría D...: " +canemp3 +"\n");
	}

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JComboBox cbocat;
	private JTextField txthoras;
	private JButton btnprocesar;
	private JButton btnborrar;
	private JTextArea txts;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ejercicio2_Sueldos frame = new ejercicio2_Sueldos();
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
	public ejercicio2_Sueldos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 627);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 128));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		lblNewLabel = new JLabel("Categor\u00EDa");
		lblNewLabel.setFont(new Font("Dubai", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 30, 65, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Horas");
		lblNewLabel_1.setFont(new Font("Dubai", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(34, 60, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		cbocat = new JComboBox();
		cbocat.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D"}));
		cbocat.setFont(new Font("Dubai", Font.PLAIN, 12));
		cbocat.setBounds(109, 26, 37, 21);
		contentPane.add(cbocat);
		
		txthoras = new JTextField();
		txthoras.setHorizontalAlignment(SwingConstants.CENTER);
		txthoras.setFont(new Font("Dubai", Font.PLAIN, 12));
		txthoras.setBounds(95, 57, 72, 19);
		contentPane.add(txthoras);
		txthoras.setColumns(10);
		
		btnprocesar = new JButton("Procesar");
		btnprocesar.addActionListener(this);
		btnprocesar.setFont(new Font("Dubai", Font.PLAIN, 14));
		btnprocesar.setBounds(261, 26, 100, 21);
		contentPane.add(btnprocesar);
		
		btnborrar = new JButton("Borrar");
		btnborrar.addActionListener(this);
		btnborrar.setFont(new Font("Dubai", Font.PLAIN, 14));
		btnborrar.setBounds(261, 56, 100, 21);
		contentPane.add(btnborrar);
		
		txts = new JTextArea();
		txts.setBorder(new LineBorder(new Color(0, 0, 0)));
		txts.setFont(new Font("DialogInput", Font.BOLD, 14));
		txts.setBounds(10, 90, 399, 490);
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
