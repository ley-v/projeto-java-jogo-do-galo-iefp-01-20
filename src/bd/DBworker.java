/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import core.Jogador;
import core.Modalidade;
import core.Score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author raque
 */
public class DBworker {

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    String baseDados = "rr1";
    String servidor = "192.168.56.102";
    String user = "rr";
    String password = "123";

    String url = "jdbc:mysql://" + servidor + ":3306/" + baseDados + "?autoReconnect=true&useSSL=false&serverTimezone=UTC";

    public boolean guardaObjeto(Jogador jogador) {

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === GRAVACAO DE DADOS NA BASE DE DADOS ==========================
            st.executeUpdate("INSERT INTO jogadores(Nome) "
                    + "VALUES('" + jogador.getNome() + "');");

            //st.executeUpdate("INSERT INTO jogadores(Nome) "
            //        + "VALUES('"+ jogador2.getNome()+"');");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Ja Guardei na BD o " + jogador.getNome());
        return true;
    }

    public boolean guardaPontuacao(Modalidade j) {

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === GRAVACAO DE DADOS NA BASE DE DADOS ==========================
            st.executeUpdate("INSERT INTO pontuacao(Pontos, jogadores_Id) "
                    + "VALUES(" + j.getPontos() + ", " + j.getJogadores_Id() + ");");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println("Ja Guardei Pontos ");
        return true;
    }

//                 === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
//   public boolean obterObjeto( Jogador jogador1, Jogador jogador2) {
//
//        try {          
//            String sql = "SELECT * FROM jogadores";
//            rs = st.executeQuery(sql);
//            
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String nome = rs.getString("nome");
//                
//                System.out.println("\n\n\nId Jogador: " + id + "\nNome: " + nome);
//            }
//            System.out.println("Dados carregados com sucesso.");            
//            
////           } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println(ex.getErrorCode());
//
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (st != null) {
//                    st.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
//
//        System.out.println("Ja Guardei na BD o " + jogador1.getId()+ " e o " + jogador2.getNome() );
//        return true;
//    }  
////            
//            
//            
//            
//            // === GRAVACAO DE DADOS NA BASE DE DADOS ==========================
//            st.executeUpdate("INSERT INTO loja(nome) " +
//                             "VALUES('Loja de roupa com cuecas'); ");            
//            
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//            System.out.println(ex.getErrorCode());
//
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (st != null) {
//                    st.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }
//        }
    public Integer buscarIdJogadores(String j) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
            String sql = "SELECT Id FROM jogadores WHERE Nome = '" + j + "'  order by Id desc limit 1;";

            rs = st.executeQuery(sql);
            int r = 0;
            while (rs.next()) {

                r = rs.getInt("Id");

            }
            System.out.println("buscarIdJogadores id --- " + r);

            return r;
//		statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return -1;
    }

//    public int buscarIdJogadores(String lbJogador1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    public boolean buscarScore(ArrayList a) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
            String sql = "select sum(p.Pontos) as highScore, j.Nome from jogadores j inner join "
                    + "pontuacao p on j.Id = p.jogadores_Id group by j.Id order by highScore desc limit 0, 3;";
            rs = st.executeQuery(sql);
            
            while (rs.next()) {
                
                Score s = new Score();
                s.setPontos(rs.getString("highScore"));
                s.setNome(rs.getString("Nome"));
                a.add(s);
                
            }
//		statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return true;
    }
    
    public String buscarNomeJogadores(String j) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
            String sql = "select * from jogadores where Nome = '"+ j +"'";

            rs = st.executeQuery(sql);
            String r = "--1";
            while (rs.next()) {

                r = rs.getString("Nome");

            }
            System.out.println("buscarNOMEJogadores NOME --- " + r);

            return r;
//		statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return "-1";
    }
    
    public Integer buscarIdJogadorAntigo(String j) {
        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();

            // === OBTENCAO DE DADOS A PARTIR DA Base de Dados ==================
            String sql = "SELECT Id FROM jogadores WHERE Nome = '" + j + "'  order by Id asc limit 1;";

            rs = st.executeQuery(sql);
            int r = 0;
            while (rs.next()) {

                r = rs.getInt("Id");

            }
            System.out.println("buscarIdJogadores id --- " + r);

            return r;
//		statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(ex.getErrorCode());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return -1;
    }
}
