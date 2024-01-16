package ejercicioListaTareas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ventanaTareas extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static JTextField textFieldTareas;
	private static JList listTareas;
	private static DefaultListModel taskList = new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanaTareas frame = new ventanaTareas();
					frame.setResizable(false); // Tamaño fijo de la ventana al ejecutarse
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
	public ventanaTareas() {
		setTitle("Lista de tareas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnTareaCompletada = new JButton("Tarea completada");
		btnTareaCompletada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int item = listTareas.getSelectedIndex();
				String tarea = (String) taskList.getElementAt(item);
				String tick = "\u2713";
				if (!tarea.contains(tick)) {
					tarea = tick + tarea;
				} else {
					tarea = tarea;
				}
				taskList.setElementAt(tarea, item);
			}
		}

		);
		btnTareaCompletada.setBounds(0, 227, 217, 34);
		contentPane.add(btnTareaCompletada);

		JButton btnBorrarTarea = new JButton("Borrar tarea");
		btnBorrarTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int tareaSeleccionada = listTareas.getSelectedIndex(); // Definimos variable como item eleccionado en
																		// JList
				if (tareaSeleccionada >= 0)
					taskList.removeElementAt(tareaSeleccionada); // Borra el elemento seleccionado
			}

		});
		btnBorrarTarea.setBounds(217, 227, 217, 34);
		contentPane.add(btnBorrarTarea);

		listTareas = new JList();
		listTareas.setBounds(10, 34, 414, 182);
		contentPane.add(listTareas);

		JButton btnAñadirTarea = new JButton("Añadir tarea");
		btnAñadirTarea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevaTarea();
			}
		});
		btnAñadirTarea.setBounds(307, 1, 127, 22);
		contentPane.add(btnAñadirTarea);

		textFieldTareas = new JTextField();
		textFieldTareas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) { // KeyEvent que al presionar enter
				if (e.getKeyCode() == KeyEvent.VK_ENTER) { // se ejecuta el metodo
					nuevaTarea(); // del boton añadir tarea
				}
			}

		});
		textFieldTareas.setBounds(0, 1, 307, 22);
		contentPane.add(textFieldTareas);
		textFieldTareas.setColumns(10);

		JButton btnLimpiarLista = new JButton("Limpiar lista");
		btnLimpiarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskList.clear(); // Limpia el model
				listTareas.removeAll(); // Borra todos los elementos del JList
			}
		});
		btnLimpiarLista.setBounds(0, 264, 434, 34);
		contentPane.add(btnLimpiarLista);
	}

	private static void nuevaTarea() {
		String añadirTarea = textFieldTareas.getText(); // Variable es igualada al texto que introdujamos
		taskList.addElement(añadirTarea); // se añade dicha variable en el model
		listTareas.setModel(taskList); // aplicamos el model en la JList y por tanto, el texto introducido
		textFieldTareas.setText(""); // limpiamos el texto del cuadro de texto
	}
}
