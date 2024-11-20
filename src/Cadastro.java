import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cadastro extends JFrame{
    private JPanel panel;
    private JTextField txtCidade;
    private JTextField txtNome;
    private JTextField txtTelefone;
    private JButton btnCadastrar;

    public Cadastro(){
        //metodos para montar a tela
        setContentPane(panel);
        setTitle("Cadastro");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        btnCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Validacao dos campos vazios
                if (txtNome.getText().isEmpty() || txtCidade.getText().isEmpty() || txtTelefone.getText().isEmpty()){
                    JOptionPane.showMessageDialog(null, "Existem Campos Vazios");

                }else{
                    try{
                        int n = Integer.parseInt(txtTelefone.getText()); //Tenta converter para int e guardar o valor em n
                        Integer.parseInt(txtTelefone.getText());
                        DAO dao = new DAO();
                        Paciente paciente = new Paciente();
                        paciente.setNome(txtNome.getText());
                        paciente.setCidade(txtCidade.getText());
                        paciente.setTelefone(n);

                        if(dao.cadastrar(paciente)){
                            JOptionPane.showMessageDialog(null, "Sucesso Ao Cadastrar");
                            txtNome.setText("");
                            txtCidade.setText("");
                            txtTelefone.setText("");
                        }else{
                            JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar");
                        }

                    }catch(NumberFormatException exception){
                        JOptionPane.showMessageDialog(null, "No Campo Telefone Digite So Numeros");
                    }
                }
            }
        });
    }
}
