package controller;
import model.Empleado;
import view.FrmPrincipal;

public class CtrlFramePrincipal {

    private FrmPrincipal frmPrincipal;
    private CtrlEmpleado ctrlEmpleado;

    public CtrlFramePrincipal(FrmPrincipal frmPrincipal, CtrlEmpleado ctrlEmpleado) {
        this.frmPrincipal = frmPrincipal;
        this.ctrlEmpleado = ctrlEmpleado;
        mostrarEmpleadoActual();
    }

    public void setEmpleadoData(String nombre, String fechaNacimiento, double salario) {
        frmPrincipal.txtNombre.setText(nombre);
        frmPrincipal.txtFecha.setText(fechaNacimiento);
        frmPrincipal.txtSalario.setText(String.valueOf(salario));
    }

    public Empleado recogerEmpleado() {
        String nombre = frmPrincipal.txtNombre.getText();
        String fecha = frmPrincipal.txtFecha.getText();
        Double salario = Double.parseDouble(frmPrincipal.txtSalario.getText());

        return new Empleado(nombre, fecha, salario);
    }

    public void mostrarEmpleadoActual() {
        if (ctrlEmpleado.esUltimoEmpleado()) {
            setEmpleadoData("", "", 0);
            frmPrincipal.setAltaVisible(true);
        } else {
            Empleado empleado = ctrlEmpleado.getEmpleadoActual();
            setEmpleadoData(empleado.getNombre(), empleado.getFechaNacimiento(), empleado.getSalario());
            frmPrincipal.setAltaVisible(false);
        }

        frmPrincipal.btnAnterior.setEnabled(!ctrlEmpleado.esPrimerEmpleado());
        frmPrincipal.btnSiguiente.setEnabled(!ctrlEmpleado.esUltimoEmpleado());
    }

    public void agregarNuevoEmpleado() {
        Empleado nuevoEmpleado = recogerEmpleado();
        ctrlEmpleado.agregarEmpleado(nuevoEmpleado);
        mostrarEmpleadoActual();
    }
}