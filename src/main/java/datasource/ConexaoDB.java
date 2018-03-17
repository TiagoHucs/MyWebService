package datasource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.Server;
import org.hsqldb.server.ServerAcl.AclFormatException;
        
public class ConexaoDB {
    
    public Statement stm; // resposavel por realizar a pesquisa
    public ResultSet rs; // resposavel por resultados da pesquisa
    private String driver = "org.hsqldb.jdbcDriver";
    private String caminho = "jdbc:hsqldb:hsql://localhost/myWebSeviceDB";
    //private String caminho = "jdbc:postgresql://localhost:5432/postgres";
    private String usuario = "sa";
    private String senha = "";
    public Connection con;
    
    public void iniciaServidor(){	
		//Database [index=0, id=0, db=file:myServerDB, alias=myserverdb]
    	HsqlProperties p = new HsqlProperties();
    	 p.setProperty("server.database.0","file:myWebSeviceDB");
    	 try {
    	 p.setProperty("server.dbname.0","mywebsevicedb");
    	 } catch (Exception e) {
    		 JOptionPane.showMessageDialog(null, "Erro:\n"+e.getMessage());
    	 }
    	 // set up the rest of properties

    	 // alternative to the above is
    	 Server server = new Server();
    	 try {
			server.setProperties(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AclFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 server.start();
    }
    

    public void conectar(){
         
        try {
            System.setProperty("jdbc.Drivers",driver);
            con=DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Banco conectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na conexao:\n"+ex.getMessage());
        }
    }
    
    public void desconectar(){
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "desconectado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na desconexao:\n"+ex.getMessage());
        }
    }
    
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            //JOptionPane.showMessageDialog(null, "Query executada:\n"+sql);
            //JOptionPane.showMessageDialog(null, "Resultado:\n"+rs.first());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na consulta:\n"+ex.getMessage());
        }
        
    }
    
    public void preparaTabelas(){
    	
    	try{
    			conectar();
    			// DROP TABLE USADO PARA O DESENVOLVIMENTO
    			//this.executaSql("drop table tb_clientes;");
        		this.executaSql("create table if not exists pessoa(cpf varchar(14),nome varchar(60);");
        		//this.executaSql("insert into tb_clientes(nome,cpf,telefone,email,apolice,vencimento) values('Mel Hucs','093.747.097-08','(81) 9 8700-3640','tiagohucs@gmail.com','123456789',sysdate);");
        					
        		desconectar();
    			}catch(Exception e){
    			JOptionPane.showMessageDialog(null, "Erro na criação das tabelas:\n"+e.getMessage());
    		}
    	

    	}
    
}
