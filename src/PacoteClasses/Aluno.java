package PacoteClasses;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joan
 */
public class Aluno extends Pessoa{
    private String matricula;
    private ArrayList<Turma> disciplinas;

    public Aluno(String matricula) {
        this.matricula = matricula;
        disciplinas = new ArrayList();
    }

    public Aluno() {
    }
    public void addDisciplinas(Turma d){
        disciplinas.add(d);
    }
    
    public ArrayList<Turma> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Turma> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    

    @Override
    public int getIdade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
