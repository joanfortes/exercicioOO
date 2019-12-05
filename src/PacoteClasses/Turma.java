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
public class Turma {
    private String sala,codDisciplina;
    private Professor professor;
    private ArrayList<Aluno> turma;

    public Turma() {
    }

    public Turma(String sala, String codDisciplina, Professor professor) {
        this.sala = sala;
        this.codDisciplina = codDisciplina;
        this.professor = professor;
        turma = new ArrayList();
    }

    public Turma(String sala, String codDisciplina) {
        this.sala = sala;
        this.codDisciplina = codDisciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Aluno> getTurma() {
        return turma;
    }

    public void setTurma(ArrayList<Aluno> turma) {
        this.turma = turma;
    }
    

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(String codDisciplina) {
        this.codDisciplina = codDisciplina;
    }
    
    
}
