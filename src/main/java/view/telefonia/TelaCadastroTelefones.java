package view.telefonia;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.telefonia.TelefoneController;
import model.telefonia.exceptions.CampoInvalidoException;
import model.telefonia.exceptions.TelefoneJaExiste;
import model.telefonia.vo.Telefone;

public class TelaCadastroTelefones extends JFrame {

	private TelefoneController controller = new TelefoneController();
	private JPanel contentPane;
	private JTextField txtDDD;
	private JTextField txtNumero;
	private JCheckBox cbxMovel = new JCheckBox("Movel");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroTelefones frame = new TelaCadastroTelefones();
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
	public TelaCadastroTelefones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDDD = new JTextField();
		txtDDD.setBounds(49, 52, 86, 20);
		contentPane.add(txtDDD);
		txtDDD.setColumns(10);
		
		JLabel lblDDD = new JLabel("DDD:");
		lblDDD.setBounds(21, 55, 32, 14);
		contentPane.add(lblDDD);
		
		JLabel lblCadastroTelefone = new JLabel("Cadastro de Telefones");
		lblCadastroTelefone.setBounds(155, 11, 137, 14);
		contentPane.add(lblCadastroTelefone);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(155, 55, 64, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(212, 52, 130, 20);
		contentPane.add(txtNumero);
		
		cbxMovel.setBounds(348, 51, 64, 23);
		contentPane.add(cbxMovel);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(166, 103, 86, 29);
		contentPane.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Telefone telefone = new Telefone();
					telefone.setDdd(txtDDD.getText());
					telefone.setMovel(cbxMovel.isSelected());
					telefone.setNumero(txtNumero.getText());
					telefone.setAtivo(false);
					try {
						controller.inserir(telefone);
					} catch (CampoInvalidoException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, e1.getMessage(), 
								"Erro", JOptionPane.ERROR_MESSAGE);
					} catch (TelefoneJaExiste e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage(), 
								"Erro", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
	}
