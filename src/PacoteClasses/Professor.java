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
public class Professor extends Pessoa{
    private String siape;
    private ArrayList<Turma> disciplinas;

    public Professor() {
    }

    public Professor(String siape) {
        this.siape = siape;
        disciplinas = new ArrayList<>();
    }
    public void addDisciplina(Turma d){
        disciplinas.add(d);
    }
    public ArrayList<Turma> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Turma> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    
    
    public void addDisciplinas(Turma d){
        disciplinas.add(d);
    }
    
    public String getSiape() {
        return siape;
    }

    public void setSiape(String siape) {
        this.siape = siape;
    }

    @Override
    public int getIdade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
