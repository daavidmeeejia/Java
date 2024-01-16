package ejercicioCalculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class Calculadora extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnComa;
	@SuppressWarnings("unused")
	private String valor = "";
	private double n1 = 0.0;
	private double n2 = 0.0;
	private double resultado = 0.0;
	private String operacion;
	private JLabel lblPantalla;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Calculadora() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 532, 524);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(10, 90, 496, 384);
		contentPane.add(panelBotones);
		panelBotones.setLayout(new GridLayout(0, 4, 0, 0));
		
		lblPantalla = new JLabel("");
		lblPantalla.setFont(new Font("Century", Font.BOLD, 26));
		lblPantalla.setBounds(10, 11, 496, 66);
		contentPane.add(lblPantalla);
		
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Century", Font.BOLD, 20));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn1.getText();
                lblPantalla.setText(numero);
			}
		});
		panelBotones.add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Century", Font.BOLD, 20));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn2.getText();
                lblPantalla.setText(numero);
			}
		});
		panelBotones.add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Century", Font.BOLD, 20));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn3.getText();
                lblPantalla.setText(numero);
			}
		});
		panelBotones.add(btn3);
		
		JButton btnBorrar = new JButton("C");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblPantalla.getText().isEmpty()) {
					String texto = lblPantalla.getText();
					int largo = texto.length();
					String nuevoTexto = texto.substring(0, largo - 1);
					lblPantalla.setText(nuevoTexto);
					valor = nuevoTexto;
				}
			}
		});
		btnBorrar.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnBorrar);
		
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Century", Font.BOLD, 20));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn4.getText();
                lblPantalla.setText(numero);
			}
		});
		panelBotones.add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Century", Font.BOLD, 20));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn5.getText();
                lblPantalla.setText(numero);
			}
		});
		panelBotones.add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn6.getText();
                lblPantalla.setText(numero);
			}
		});
		btn6.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btn6);
		
		JButton btnSuma = new JButton("+");
		btnSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblPantalla.getText().isEmpty()) {
				  n1 = Double.valueOf(lblPantalla.getText());
			      lblPantalla.setText("");
			      operacion = "+";
				}
			}
		});
		btnSuma.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnSuma);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn7.getText();
                lblPantalla.setText(numero);
			}
		});
		btn7.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn8.getText();
                lblPantalla.setText(numero);
			}
		});
		btn8.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn9.getText();
                lblPantalla.setText(numero);
			}
		});
		btn9.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btn9);
		
		JButton btnResta = new JButton("-");
		btnResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblPantalla.getText().isEmpty()) {  
					n1 = Double.valueOf(lblPantalla.getText());
					lblPantalla.setText("");
					operacion = "-";
				}
			}
		});
		btnResta.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnResta);
		
		btnComa = new JButton(".");
		btnComa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numComa();
			}
		});
		btnComa.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnComa);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String numero = lblPantalla.getText() + btn0.getText();
                lblPantalla.setText(numero);
			}
		});
		btn0.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btn0);
		
		JButton btnIgual = new JButton("=");
		btnIgual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String operacion = null;
				if (operacion != null) {
					switch (operacion) {
						case "+":
								resultado = n1 + n2;
							break;
						case "-":
								resultado = n1 - n2;
							break;
						case "*":
								resultado = n1 * n2;
							break;
						case "/":
								resultado = n1 / n2;
							break;
					}
					operacion = null;
					n1 = Double.valueOf(resultado);
					lblPantalla.setText(operacion);
				}*/
				
				String cambio;
		        n2 = Double.parseDouble(lblPantalla.getText());
		        if (operacion == "+") {
		            resultado = n1 + n2;
		            cambio = String.valueOf(resultado);
		            lblPantalla.setText(cambio);
		        } else if (operacion == "-") {
		            resultado = n1 - n2;
		            cambio = String.valueOf(resultado);
		            lblPantalla.setText(cambio);
		        } else if (operacion == "*") {
		            resultado = n1 * n2;
		            cambio = String.valueOf(resultado);
		            lblPantalla.setText(cambio);
		        } else if (operacion == "/") {
		            resultado = n1 / n2;
		            cambio = String.valueOf(resultado);
		            lblPantalla.setText(cambio);

		        }
			}
		});
		btnIgual.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnIgual);
		
		JButton btnMultiplicar = new JButton("*");
		btnMultiplicar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*distintaOperacion(operacion);*/
				if (!lblPantalla.getText().isEmpty()) {  
					n1 = Double.valueOf(lblPantalla.getText());
					lblPantalla.setText("");
					operacion = "*";
				}
			}
		});
		btnMultiplicar.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnMultiplicar);
		
		JButton btnLimpiar = new JButton("AC");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPantalla.setText("");
				valor = "";
			}
		});
		btnLimpiar.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnLimpiar);
		
		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!lblPantalla.getText().isEmpty()) {  
					n1 = Double.valueOf(lblPantalla.getText());
					lblPantalla.setText("");
					operacion = "/";
				}
			}
		});
		btnDivision.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnDivision);
	
		JButton btnOff = new JButton("OFF");
		btnOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn0.setEnabled(false);
				btn1.setEnabled(false);
				btn2.setEnabled(false);
				btn3.setEnabled(false);
				btn4.setEnabled(false);
				btn5.setEnabled(false);
				btn6.setEnabled(false);
				btn7.setEnabled(false);
				btn8.setEnabled(false);
				btn9.setEnabled(false);
				btnBorrar.setEnabled(false);
				btnIgual.setEnabled(false);
				btnMultiplicar.setEnabled(false);
				btnOff.setEnabled(false);
				btnResta.setEnabled(false);
				btnSuma.setEnabled(false);
				btnComa.setEnabled(false);
				btnLimpiar.setEnabled(false);
				btnDivision.setEnabled(false);
			}
		});
		btnOff.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnOff);
		
		JButton btnOn = new JButton("ON");
		btnOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					btn0.setEnabled(true);
					btn1.setEnabled(true);
					btn2.setEnabled(true);
					btn3.setEnabled(true);
					btn4.setEnabled(true);
					btn5.setEnabled(true);
					btn6.setEnabled(true);
					btn7.setEnabled(true);
					btn8.setEnabled(true);
					btn9.setEnabled(true);
					btnBorrar.setEnabled(true);
					btnIgual.setEnabled(true);
					btnMultiplicar.setEnabled(true);
					btnOff.setEnabled(true);
					btnOn.setEnabled(true);
					btnResta.setEnabled(true);
					btnSuma.setEnabled(true);
					btnComa.setEnabled(true);
					btnLimpiar.setEnabled(true);
					btnDivision.setEnabled(true);
			}
		});
		btnOn.setFont(new Font("Century", Font.BOLD, 20));
		panelBotones.add(btnOn);
	}
	
	private void numComa() {
		if (!lblPantalla.getText().contains(".")) {
			String coma = lblPantalla.getText() + btnComa.getText();
	        lblPantalla.setText(coma);
		}
	}

	/*private void distintaOperacion(String operacion) {
		this.operacion = operacion;
        n1 = Double.valueOf(lblPantalla.getText());
        lblPantalla.setText("0");
	}*/
	
}
