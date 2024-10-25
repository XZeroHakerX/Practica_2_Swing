package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.CtrlEmpleado;
import controller.CtrlFramePrincipal;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FrmPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNombre, lblFecha, lblSalario;
    public JTextField txtNombre, txtFecha, txtSalario;
    public JButton btnAnterior, btnSiguiente, btnAlta, btnCancelar;

    private CtrlFramePrincipal ctrlFramePrincipal;
    private CtrlEmpleado ctrlEmpleado;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CtrlEmpleado ctrlEmpleado = new CtrlEmpleado();
                FrmPrincipal frame = new FrmPrincipal();
                CtrlFramePrincipal ctrFrm = new CtrlFramePrincipal(frame, ctrlEmpleado);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public FrmPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 2, 16, 16));

        lblNombre = new JLabel("Nombre:");
        contentPane.add(lblNombre);

        txtNombre = new JTextField();
        contentPane.add(txtNombre);
        txtNombre.setColumns(10);

        lblFecha = new JLabel("Fecha de nacimiento:");
        contentPane.add(lblFecha);

        txtFecha = new JTextField();
        contentPane.add(txtFecha);
        txtFecha.setColumns(10);

        lblSalario = new JLabel("Salario:");
        contentPane.add(lblSalario);

        txtSalario = new JTextField();
        contentPane.add(txtSalario);
        txtSalario.setColumns(10);

        btnAlta = new JButton("Alta");
        contentPane.add(btnAlta);

        btnCancelar = new JButton("Cancelar");
        contentPane.add(btnCancelar);

        btnAnterior = new JButton("Anterior");
        contentPane.add(btnAnterior);

        btnSiguiente = new JButton("Siguiente");
        contentPane.add(btnSiguiente);

        ctrlEmpleado = new CtrlEmpleado();
        ctrlFramePrincipal = new CtrlFramePrincipal(this, ctrlEmpleado);

        setAltaVisible(false);
        setListeners();
    }

    public void setListeners() {
        btnAnterior.addActionListener(e -> {
            ctrlEmpleado.anteriorEmpleado();
            ctrlFramePrincipal.mostrarEmpleadoActual();
        });

        btnSiguiente.addActionListener(e -> {
            ctrlEmpleado.siguienteEmpleado();
            ctrlFramePrincipal.mostrarEmpleadoActual();
        });

        btnAlta.addActionListener(e -> {
            ctrlFramePrincipal.agregarNuevoEmpleado();
        });

        btnCancelar.addActionListener(e -> ctrlFramePrincipal.mostrarEmpleadoActual());
    }

    public void setAltaVisible(boolean isVisible) {
        btnAlta.setVisible(isVisible);
        btnAlta.setEnabled(isVisible);
        btnCancelar.setVisible(isVisible);
        btnCancelar.setEnabled(isVisible);
    }
}