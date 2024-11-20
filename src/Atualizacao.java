import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Atualizacao extends JFrame{
    private JPanel panel;
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtCidade;
    private JTextField txtTelefone;
    private JButton btnAtualizar;
    private int id;

    public Atualizacao(int id){
        this.id = id;
        setContentPane(panel);
        setTitle("Atualizacao");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);

        DAO dao = new DAO();
        Paciente paciente;
        paciente = dao.buscarPorId(id);//carrega os dados do registro selecionado por id
        //exibe os dados do registro selecionado
        txtId.setText(String.valueOf(paciente.getId()));
        txtNome.setText(paciente.getNome());
        txtCidade.setText(paciente.getCidade());
        txtTelefone.setText(String.valueOf(paciente.getTelefone()));

        btnAtualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paciente.setId(Integer.parseInt(txtId.getText()));
                paciente.setNome(txtNome.getText());
                paciente.setCidade(txtCidade.getText());
                paciente.setTelefone(Integer.parseInt(txtTelefone.getText()));
                if (dao.atualizar(paciente)){
                    JOptionPane.showMessageDialog(null, "Dados Cadastrados Com Sucesso!");
                }else{
                    JOptionPane.showMessageDialog(null, "Erro Ao Cadastrar");
                }

            }
        });
    }
}
