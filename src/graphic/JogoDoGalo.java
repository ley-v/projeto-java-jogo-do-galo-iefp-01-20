/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphic;

import bd.DBworker;
import javax.swing.JOptionPane;
import core.Jogador;
import core.Modalidade;
import java.awt.Dialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author raque
 */
public class JogoDoGalo extends javax.swing.JFrame {

    private Jogador jogador1 = null;
    private Jogador jogador2 = null;

    private Modalidade j1 = new Modalidade();
    private Modalidade j2 = new Modalidade();

    //private int Idjogador1 = jogador1.getId();
    //private int Idjogador2 = jogador2.getId();
    private DBworker bd = new DBworker();

    boolean Jogador1ativo = true;
    boolean Jogador2ativo = false;

//    int contador = 0;
    int VitoriasJogador1 = 0;
    int VitoriasJogador2 = 0;

    int Empates = 0;
    private int NumeroJogos = VitoriasJogador1 + VitoriasJogador2 + Empates;

    //retorna o número de jogos
    public int NumeroJogos() {
        return VitoriasJogador1 + VitoriasJogador2;
    }

    int tipo_jogo = -1;

    //private Jogo Modalidade;
    /**
     *
     */
    public JogoDoGalo() {
        initComponents();
    }

//    
    /**
     *
     * @param jogador
     */
    public void InformacaoJogo(Jogador jogador) {
//        
        //lbNomeJ1.setText("Jogador 1:" +novojogomenu.getTxtNomeJogador1());
        //lbNomeJ1.setText(String.format("%d", novojogomenu.getTxtJogador1()));
        //lbNomeJ1.setText("" + novojogomenu.getTxtJogador1());
        // lbNomeJ2.setText("" + novojogomenu.getTxtJogador2());
        NovoJogoMenu dialog = new NovoJogoMenu(new javax.swing.JFrame(), true);
        dialog.setVisible(true);

        if (dialog.getAcaoTomada() == NovoJogoMenu.OK) {
            lbNomeJ1.setText(dialog.getLbJogador1());
            lbNomeJ2.setText(dialog.getLbJogador2());
            //lbModTipo.setText(dialog.getModoJogo());
        }
    }

    /**
     *
     * @param pontos
     */
//    public void Modalidade(Modalidade pontos) {
//        NovoJogoMenu dialog = new NovoJogoMenu(new javax.swing.JFrame(), true);
//        dialog.setVisible(true);
//
//        if (dialog.getTipoDeJogo() == 3) {
//            Jogo jogo = new Jogo() {
//            };
//
//            jogo.Modalidade3();
//
//            j1.getPontos(jogo.Modalidade3());
//            j2.getPontos(jogo.Modalidade3());
//
//        }
//
//        if (dialog.getTipoDeJogo() == 5) {
//            Jogo jogo = new Jogo() {
//            };
//
//            jogo.Modalidade5();
//
//            j1.getPontos(jogo.Modalidade5());
//            j2.getPontos(jogo.Modalidade5());
//
//        }
//
//    }
    /**
     *
     */
    public void JogadorAtivo() {

        if (Jogador1ativo == true) {
            Jogador1ativo = false;
            Jogador2ativo = true;
        } else {
            Jogador1ativo = true;
            Jogador2ativo = false;
        }

        Vencedor("X");
        Vencedor("O");

    }

    /**
     *
     * @param Jogador
     */
    public void Vencedor(String Jogador) {

        /**
         * ************* Linha 1 ************
         */
        if (btn1.getText().equals(Jogador) && btn2.getText().equals(Jogador) && btn3.getText().equals(Jogador)) {
            if (btn1.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Linha 2 ************
         */
        if (btn4.getText().equals(Jogador) && btn5.getText().equals(Jogador) && btn6.getText().equals(Jogador)) {
            if (btn4.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Linha 3 ************
         */
        if (btn7.getText().equals(Jogador) && btn8.getText().equals(Jogador) && btn9.getText().equals(Jogador)) {
            if (btn7.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Coluna 1 ************
         */
        if (btn1.getText().equals(Jogador) && btn4.getText().equals(Jogador) && btn7.getText().equals(Jogador)) {
            if (btn1.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Coluna 2 ************
         */
        if (btn2.getText().equals(Jogador) && btn5.getText().equals(Jogador) && btn8.getText().equals(Jogador)) {
            if (btn2.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Coluna 3 ************
         */
        if (btn3.getText().equals(Jogador) && btn6.getText().equals(Jogador) && btn9.getText().equals(Jogador)) {
            if (btn3.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Diagonal 1 ************
         */
        if (btn1.getText().equals(Jogador) && btn5.getText().equals(Jogador) && btn9.getText().equals(Jogador)) {
            if (btn1.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Diagonal 2 ************
         */
        if (btn3.getText().equals(Jogador) && btn5.getText().equals(Jogador) && btn7.getText().equals(Jogador)) {
            if (btn3.getText().equals("X")) {
                Vitoria("Jogador 1");
            } else {
                Vitoria("Jogador 2");
            }
        }

        /**
         * ************* Empate ************
         */
        if (!btn1.getText().equals("")
                && !btn2.getText().equals("")
                && !btn3.getText().equals("")
                && !btn4.getText().equals("")
                && !btn5.getText().equals("")
                && !btn6.getText().equals("")
                && !btn7.getText().equals("")
                && !btn8.getText().equals("")
                && !btn9.getText().equals("")) {

            Vitoria("Empate");
        }

    }

    /**
     *
     * @param Vencedor
     */
    public void Vitoria(String Vencedor) {

        if (Vencedor.equals("Jogador 1")) {
            //JOptionPane.showMessageDialog(JogoDoGalo.this, " Ganhou Jogador 1");
            VitoriasJogador1++;
            lbVitoriasJ1.setText("Vitórias:  " + VitoriasJogador1);
            if (NumeroJogos() >= tipo_jogo) {
                JOptionPane.showMessageDialog(null, jogador1.getNome().toUpperCase() + " ganhou " + NumeroJogos() + " vezes e portanto venceu o jogo.");
                bd.guardaPontuacao(j1);
                limparPainelInfo();
            } else {
                JOptionPane.showMessageDialog(JogoDoGalo.this, jogador1.getNome().toUpperCase() + " ganhou o jogo.");
            }
            Limpar();
        }
        if (Vencedor.equals("Jogador 2")) {
            //JOptionPane.showMessageDialog(JogoDoGalo.this, " Ganhou Jogador 2");
            VitoriasJogador2++;
            lbVitoriasJ2.setText("Vitórias:  " + VitoriasJogador2);
            if (NumeroJogos() >= tipo_jogo) {
                JOptionPane.showMessageDialog(null, jogador2.getNome().toUpperCase() + " ganhou " + NumeroJogos() + " vezes e portanto venceu o jogo.");
                bd.guardaPontuacao(j2);
                limparPainelInfo();
            } else {
                JOptionPane.showMessageDialog(JogoDoGalo.this, jogador2.getNome().toUpperCase() + " ganhou o jogo.");
            }
            Limpar();
        }
        if (Vencedor.equals("Empate")) {
            JOptionPane.showMessageDialog(JogoDoGalo.this, " Empate");
            Empates++;
            lbEmpate.setText("Empate: " + Empates);
            Limpar();
        }
    }

    /**
     *
     */
    public void Limpar() {

        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPtabuleiro = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        jPInfo = new javax.swing.JPanel();
        lbJogador1 = new javax.swing.JLabel();
        lbNomeJ1 = new javax.swing.JLabel();
        lbVitoriasJ1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lbJogador2 = new javax.swing.JLabel();
        lbNomeJ2 = new javax.swing.JLabel();
        lbVitoriasJ2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lbEmpate = new javax.swing.JLabel();
        lbPontuacao = new javax.swing.JLabel();
        lbModalidade = new javax.swing.JLabel();
        lbModTipo = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPBotoes = new javax.swing.JPanel();
        btnNovoJogo = new javax.swing.JButton();
        btnScore = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jogo do Galo");
        setAutoRequestFocus(false);

        jPtabuleiro.setBackground(new java.awt.Color(0, 153, 204));
        jPtabuleiro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btn1.setBackground(new java.awt.Color(255, 255, 255));
        btn1.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setBackground(new java.awt.Color(255, 255, 255));
        btn2.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setBackground(new java.awt.Color(255, 255, 255));
        btn3.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn4.setBackground(new java.awt.Color(255, 255, 255));
        btn4.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(255, 255, 255));
        btn5.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setBackground(new java.awt.Color(255, 255, 255));
        btn6.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn7.setBackground(new java.awt.Color(255, 255, 255));
        btn7.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setBackground(new java.awt.Color(255, 255, 255));
        btn8.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setBackground(new java.awt.Color(255, 255, 255));
        btn9.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPtabuleiroLayout = new javax.swing.GroupLayout(jPtabuleiro);
        jPtabuleiro.setLayout(jPtabuleiroLayout);
        jPtabuleiroLayout.setHorizontalGroup(
            jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPtabuleiroLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPtabuleiroLayout.createSequentialGroup()
                        .addComponent(btn7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPtabuleiroLayout.createSequentialGroup()
                            .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPtabuleiroLayout.createSequentialGroup()
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPtabuleiroLayout.setVerticalGroup(
            jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPtabuleiroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPtabuleiroLayout.createSequentialGroup()
                        .addGroup(jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPtabuleiroLayout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPtabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPInfo.setBackground(new java.awt.Color(255, 255, 255));

        lbJogador1.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbJogador1.setForeground(new java.awt.Color(204, 0, 0));
        lbJogador1.setText("Jogador 1");

        lbVitoriasJ1.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lbVitoriasJ1.setText("Vitórias: ");

        lbJogador2.setFont(new java.awt.Font("Calibri", 1, 20)); // NOI18N
        lbJogador2.setForeground(new java.awt.Color(0, 153, 51));
        lbJogador2.setText("Jogador 2");

        lbVitoriasJ2.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lbVitoriasJ2.setText("Vitórias:");

        lbEmpate.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lbEmpate.setText("Empates: ");

        lbPontuacao.setText("Pontuação");

        lbModalidade.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        lbModalidade.setText("Modalidade");

        javax.swing.GroupLayout jPInfoLayout = new javax.swing.GroupLayout(jPInfo);
        jPInfo.setLayout(jPInfoLayout);
        jPInfoLayout.setHorizontalGroup(
            jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPInfoLayout.createSequentialGroup()
                        .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPInfoLayout.createSequentialGroup()
                                .addComponent(lbJogador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNomeJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbVitoriasJ2)
                            .addComponent(lbEmpate)
                            .addComponent(lbPontuacao)
                            .addComponent(lbVitoriasJ1))
                        .addGap(85, 85, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPInfoLayout.createSequentialGroup()
                        .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2))
                        .addContainerGap())
                    .addGroup(jPInfoLayout.createSequentialGroup()
                        .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPInfoLayout.createSequentialGroup()
                                .addComponent(lbJogador2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNomeJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPInfoLayout.createSequentialGroup()
                                .addComponent(lbModalidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbModTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPInfoLayout.setVerticalGroup(
            jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbJogador1)
                    .addComponent(lbNomeJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbVitoriasJ1)
                .addGap(34, 34, 34)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbJogador2)
                    .addComponent(lbNomeJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbVitoriasJ2)
                .addGap(39, 39, 39)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbEmpate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPInfoLayout.createSequentialGroup()
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(lbModalidade))
                    .addComponent(lbModTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(256, 256, 256)
                .addComponent(lbPontuacao)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPBotoes.setBackground(new java.awt.Color(255, 255, 255));

        btnNovoJogo.setText("Novo Jogo");
        btnNovoJogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoJogoActionPerformed(evt);
            }
        });

        btnScore.setText("Score");
        btnScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScoreActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPBotoesLayout = new javax.swing.GroupLayout(jPBotoes);
        jPBotoes.setLayout(jPBotoesLayout);
        jPBotoesLayout.setHorizontalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(238, 238, 238))
        );
        jPBotoesLayout.setVerticalGroup(
            jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnScore, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoJogo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(409, 409, 409)
                .addComponent(jPInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(2, 2, 2)
                    .addComponent(jPtabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(252, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPtabuleiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(68, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn1.getText().equals("")) {
                    btn1.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn1.getText().equals("")) {
                    btn1.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn2.getText().equals("")) {
                    btn2.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn2.getText().equals("")) {
                    btn2.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn3.getText().equals("")) {
                    btn3.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn3.getText().equals("")) {
                    btn3.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn4.getText().equals("")) {
                    btn4.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn4.getText().equals("")) {
                    btn4.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn5.getText().equals("")) {
                    btn5.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn5.getText().equals("")) {
                    btn5.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn6.getText().equals("")) {
                    btn6.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn6.getText().equals("")) {
                    btn6.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn7.getText().equals("")) {
                    btn7.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn7.getText().equals("")) {
                    btn7.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn8.getText().equals("")) {
                    btn8.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn8.getText().equals("")) {
                    btn8.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn8ActionPerformed

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        if (verificarJogadorNull()) {
        } else {
            if (Jogador1ativo == true) {
                if (btn9.getText().equals("")) {
                    btn9.setText("X");
                    JogadorAtivo();
                }
            } else {
                if (btn9.getText().equals("")) {
                    btn9.setText("O");
                    JogadorAtivo();
                }
            }
        }
    }//GEN-LAST:event_btn9ActionPerformed

    private void btnNovoJogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoJogoActionPerformed

        Limpar();

        NovoJogoMenu nj = new NovoJogoMenu(new javax.swing.JFrame(), true);
        nj.setVisible(true);

        if (nj.getAcaoTomada() == NovoJogoMenu.OK) {
            if (jogador1 == null) {
                jogador1 = new Jogador(nj.getLbJogador1());
            } else {
                jogador1.setNome(nj.getLbJogador1());
            }
            lbNomeJ1.setText(nj.getLbJogador1());

            if (jogador2 == null) {
                jogador2 = new Jogador(nj.getLbJogador2());
            } else {
                jogador2.setNome(nj.getLbJogador2());
            }
            lbNomeJ2.setText(nj.getLbJogador2());

            bd.guardaObjeto(jogador1);
            bd.guardaObjeto(jogador2);
            if (nj.getLbJogador1().toUpperCase().equals(bd.buscarNomeJogadores(nj.getLbJogador1()).toUpperCase())) {
                j1.setJogadores_Id(bd.buscarIdJogadorAntigo(nj.getLbJogador1()));
            } else {
                j1.setJogadores_Id(bd.buscarIdJogadores(nj.getLbJogador1()));
            }

            if (nj.getLbJogador2().toUpperCase().equals(bd.buscarNomeJogadores(nj.getLbJogador2()).toUpperCase())) {
                j2.setJogadores_Id(bd.buscarIdJogadorAntigo(nj.getLbJogador2()));
//                System.out.println("Já tem esse nome da BD = " + nj.getLbJogador2().toUpperCase() + " - " + bd.buscarNomeJogadores(nj.getLbJogador2()).toUpperCase());
            } else {
//                System.out.println("NÃO tem esse nome da BD = " + nj.getLbJogador2().toUpperCase() + " - " + bd.buscarNomeJogadores(nj.getLbJogador2()).toUpperCase());
                j2.setJogadores_Id(bd.buscarIdJogadores(nj.getLbJogador2()));
            }

            // ############ posição original da BD (após a verificação de nomes iguais)
//            bd.guardaObjeto(jogador1);
//            bd.guardaObjeto(jogador2);
//            System.out.println("ponto  1");
//            System.out.println(nj.getLbJogador1());
//            j1.setJogadores_Id(bd.buscarIdJogadores(nj.getLbJogador1()));
//            System.out.println("ponto  2");
//            j2.setJogadores_Id(bd.buscarIdJogadores(nj.getLbJogador2()));
            tipo_jogo = nj.getTipoDeJogo();

            if (tipo_jogo == 3) {
                lbModTipo.setText(":  melhor de 3");
            } else {
                lbModTipo.setText(":  melhor de 5");
            }
            limparPainelInfo();

        }

    }//GEN-LAST:event_btnNovoJogoActionPerformed


    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        System.exit(0);

    }//GEN-LAST:event_btnSairActionPerformed

    private void btnScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScoreActionPerformed
        JanelaScore s = new JanelaScore(null, true);
        s.setVisible(true);

    }//GEN-LAST:event_btnScoreActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JogoDoGalo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JogoDoGalo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JogoDoGalo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JogoDoGalo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JogoDoGalo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JButton btnNovoJogo;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnScore;
    private javax.swing.JPanel jPBotoes;
    private javax.swing.JPanel jPInfo;
    private javax.swing.JPanel jPtabuleiro;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbEmpate;
    private javax.swing.JLabel lbJogador1;
    private javax.swing.JLabel lbJogador2;
    public javax.swing.JLabel lbModTipo;
    private javax.swing.JLabel lbModalidade;
    public javax.swing.JLabel lbNomeJ1;
    public javax.swing.JLabel lbNomeJ2;
    private javax.swing.JLabel lbPontuacao;
    private javax.swing.JLabel lbVitoriasJ1;
    private javax.swing.JLabel lbVitoriasJ2;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param lbJogador1
     */
    public void setLbJogador1(javax.swing.JLabel lbJogador1) {
        this.lbJogador1 = lbJogador1;

    }

    /**
     *
     * @param lbJogador2
     */
    public void setLbJogador2(javax.swing.JLabel lbJogador2) {
        this.lbJogador2 = lbJogador2;
    }

    /**
     *
     * @return
     */
    public javax.swing.JLabel getLbEmpate() {
        return lbEmpate;
    }

    /**
     *
     * @param lbEmpate
     */
    public void setLbEmpate(javax.swing.JLabel lbEmpate) {
        this.lbEmpate = lbEmpate;
    }

    /**
     *
     * @return
     */
    public javax.swing.JLabel getLbModalidade() {
        return lbModalidade;
    }

    /**
     *
     * @param lbModalidade
     */
    public void setLbModalidade(javax.swing.JLabel lbModalidade) {
        this.lbModalidade = lbModalidade;
    }

    /**
     *
     * @return
     */
    public javax.swing.JLabel getLbNomeJ1() {
        return lbNomeJ1;
    }

    /**
     *
     * @param lbNomeJ1
     */
    public void setLbNomeJ1(javax.swing.JLabel lbNomeJ1) {
        this.lbNomeJ1 = lbNomeJ1;
    }

    /**
     *
     * @return
     */
    public javax.swing.JLabel getLbNomeJ2() {
        return lbNomeJ2;
    }

    /**
     *
     * @param lbNomeJ2
     */
    public void setLbNomeJ2(javax.swing.JLabel lbNomeJ2) {
        this.lbNomeJ2 = lbNomeJ2;
    }

    /**
     *
     * @return
     */
    public javax.swing.JLabel getLbPontuacao() {
        return lbPontuacao;
    }

    /**
     *
     * @param lbPontuacao
     */
    public void setLbPontuacao(javax.swing.JLabel lbPontuacao) {
        this.lbPontuacao = lbPontuacao;
    }

    /**
     *
     * @return
     */
    public javax.swing.JLabel getLbVitoriasJ1() {
        return lbVitoriasJ1;
    }

    /**
     *
     * @param lbVitoriasJ1
     */
    public void setLbVitoriasJ1(javax.swing.JLabel lbVitoriasJ1) {
        this.lbVitoriasJ1 = lbVitoriasJ1;
    }

    /**
     *
     * @return
     */
    public javax.swing.JLabel getLbVitoriasJ2() {
        return lbVitoriasJ2;
    }

    /**
     *
     * @param lbVitoriasJ2
     */
    public void setLbVitoriasJ2(javax.swing.JLabel lbVitoriasJ2) {
        this.lbVitoriasJ2 = lbVitoriasJ2;
    }

    public int getNumeroJogos() {
        return NumeroJogos;
    }

    public void setNumeroJogos(int NumeroJogos) {
        this.NumeroJogos = NumeroJogos;
    }

    public Modalidade getPontosJ1() {
        return j1;
    }

    public void setPontosJ1(Modalidade pontosJ1) {
        this.j1 = pontosJ1;
    }

    public Modalidade getPontosJ2() {
        return j2;
    }

    public void setPontosJ2(Modalidade pontosJ2) {
        this.j2 = pontosJ2;
    }

    public boolean verificarJogadorNull() {
        if (jogador1 == null) {
            JOptionPane.showMessageDialog(null, "Clique em 'Novo Jogo' antes de iniciar a partida", "Atenção",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
    }

    public void limparPainelInfo() {
        VitoriasJogador1 = 0;
        VitoriasJogador2 = 0;
        Empates = 0;

        lbVitoriasJ1.setText("");
        lbVitoriasJ2.setText("");
        lbEmpate.setText("");
    }
}
