/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;


public class Score {
    private String pontos;
    private String nome;

    public Score() {
    }

    @Override
    public String toString() {
        return "Score{" + "pontos=" + pontos + ", nome=" + nome + '}';
    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }
  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
