import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
    //Atributo que verifica o estado da conexção
    //static - Atributo que é accessado sem criar classe
    private static Connection connection = null;

    public static Connection connect(){
        //forname é o sgbd (é o tipo de sistema gerenciador de banco de dados - SGBD.
        //JDBC - java data base connector.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Endereço do anco para connexão
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3312/consultorio", "root", "");
            return connection;
        }catch (SQLException | ClassNotFoundException e){
            throw new RuntimeException(e);
            //SQLException - é para ver erros de SQL
            //trow(lançar/mostrar) - lança/mostra o tipo de erro encontrado
            //getMessage - mostra mensagem com o erro
            //ClassNotFoundException - erros quanto as classes (classe não foi achada)
            //e.getMessage();

        }
    }
}
