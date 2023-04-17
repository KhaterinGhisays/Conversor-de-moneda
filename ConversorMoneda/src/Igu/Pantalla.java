package Igu;

import javax.swing.JOptionPane;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;


public class Pantalla extends JFrame {

	private JPanel contentPane;
	private JTextField valor;
	private JTextField resultado;
	private JComboBox comboBox;
	
	public static final String USD = "1- USD (Dolares)";
	public static final String EUR = "2- EUR (Euros)";
	public static final String GBP = "3- GBP (Libras Esterlinas)";
	public static final String JPY = "4- JPY (Yen Japonés)";
	public static final String KRW = "5- KRW (Won Sul-coreano)";


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		String texto = JOptionPane.showInputDialog(null, "seleccione una opción de conversión", "Menú", JOptionPane.PLAIN_MESSAGE, null,
				new Object[] {"conversor de moneda"}, "elegir").toString();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});	
			
	}
	
	private void convertir(Boolean flag) {
		String combo = comboBox.getSelectedItem().toString();
		
		double valorMoneda;
		
		switch (combo) {
	        case USD:
	        	valorMoneda = 0.00021; 
	            break;
	        case EUR:
	        	valorMoneda = 0.00020;
	            break;
	        case GBP:
	        	valorMoneda = 0.00017;
	            break;
	        case JPY:
	        	valorMoneda = 0.028;
	            break;
	        case KRW:
	        	valorMoneda = 0.28;
	            break;
	        default:
	        	valorMoneda = 0;
	            break;
	    }
		
		String valorString = valor.getText();
		
		if(!valorString.isEmpty()) {
			double dolares;
			
			if(flag) {
				dolares = Double.parseDouble(valorString) * valorMoneda;
			}else {
				dolares = Double.parseDouble(valorString) / valorMoneda;
			}
			
			dolares = (double) Math.round(dolares * 100d)/100;
			
			String resultadoString = String.valueOf(dolares);
			resultado.setText(resultadoString);
		}else {
			
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Pantalla() {
		setBackground(new Color(0, 0, 0));
		setFont(new Font("Times New Roman", Font.PLAIN, 18));
		setTitle("CONVERSOR DE MONEDA COLOMBIANA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 309);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 198, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese el valor:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(27, 24, 397, 23);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Convertir");
		btnNewButton.setBackground(new Color(192, 192, 192));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				convertir(true);
			}
		});
		btnNewButton.setBounds(302, 153, 99, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Convertir a Pesos");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				convertir(false);
			}
		});
		
		btnNewButton_1.setBounds(27, 154, 151, 23);
		contentPane.add(btnNewButton_1);
		
		valor = new JTextField();
		double cantidad;
		valor.setBackground(new Color(255, 255, 255));
		valor.setBounds(27, 51, 374, 23);
		contentPane.add(valor);
		valor.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1- USD (Dolares)", "2- EUR (Euros)", "3- GBP (Libras Esterlinas)", "4- JPY (Yen Japonés)", "5- KRW (Won Sul-coreano)"}));
		comboBox.setSelectedIndex(0);
		comboBox.setToolTipText("");
		comboBox.setBounds(50, 119, 331, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Convertir de:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(27, 85, 374, 23);
		contentPane.add(lblNewLabel_1);
		
		
		JLabel lblNewLabel_3 = new JLabel("Resultado:");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(25, 200, 74, 23);
		contentPane.add(lblNewLabel_3);
		
		resultado = new JTextField();
		resultado.setBounds(109, 203, 292, 20);
		contentPane.add(resultado);
		resultado.setColumns(10);
		
		
	}

}
