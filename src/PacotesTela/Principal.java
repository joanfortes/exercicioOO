package PacotesTela;

import PacoteClasses.Aluno;
import PacoteClasses.Professor;
import PacoteClasses.Turma;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Joan
 */
public class Principal extends javax.swing.JFrame {
    ArrayList<Turma> ListaTur;
    ArrayList<Professor> ListaProf;
    ArrayList<Aluno> ListaAluno;
    String modoTur;
    String modoProf;
    String modoAlun;
    
    public void LoadTurmasBox(){
        cb_prof_turma.removeAllItems();
        cb_prof_turma.addItem("Selecione");
        for(int i=0;i<ListaTur.size();i++){
            cb_prof_turma.addItem(ListaTur.get(i).getCodDisciplina());
        }
    }
    
    public void LoadTurmasBoxAlun(){
        cb_alun_turma.removeAllItems();
        cb_alun_turma.addItem("Selecione");
        for(int i=0;i<ListaTur.size();i++){
            cb_alun_turma.addItem(ListaTur.get(i).getCodDisciplina());
        }
    }
    
    public void LoadTableTur(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Sala","Codigo"},0);
        for(int i=0;i<ListaTur.size();i++){
            Object linha[] = new Object[]{ListaTur.get(i).getSala(),
                                          ListaTur.get(i).getCodDisciplina()};
            modelo.addRow(linha);
        }
        tbl_tur_dpts.setModel(modelo);
        tbl_tur_dpts.getColumnModel().getColumn(0).setPreferredWidth(50);
        tbl_tur_dpts.getColumnModel().getColumn(1).setPreferredWidth(200);
        LoadTurmasBox();
        LoadTurmasBoxAlun();
    }
    
    public void LoadTableProf(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Siap","Nome"},0);
        for(int i=0;i<ListaProf.size();i++){
            Object linha[] = new Object[]{ListaProf.get(i).getSiape(),
                                          ListaProf.get(i).getNome()};
            modelo.addRow(linha);
        }
        tbl_prof_funcs.setModel(modelo);
        tbl_prof_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_prof_funcs.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    public void LoadTableAlun(){
        DefaultTableModel modelo = new DefaultTableModel(new Object[]{"Matricula","Nome"},0);
        for(int i=0;i<ListaAluno.size();i++){
            Object linha[] = new Object[]{ListaAluno.get(i).getMatricula(),
                                          ListaAluno.get(i).getNome()};
            modelo.addRow(linha);
        }
        tbl_Alun_funcs.setModel(modelo);
        tbl_Alun_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_Alun_funcs.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        ListaTur = new ArrayList();
        ListaProf = new ArrayList();
        ListaAluno = new ArrayList();
        modoTur = "Navegar";
        modoProf = "Navegar";
        modoAlun = "Navegar";
        ManipulaInterfaceTur();
        ManipulaInterfaceProf();
        ManipulaInterfaceAlun();
    }
    
    public void ManipulaInterfaceTur(){
        switch(modoTur){
            case "Navegar":
                btn_tur_salvar.setEnabled(false);
                btn_tur_cancelar.setEnabled(false);
                c_tur_sala.setEnabled(false);
                c_tur_cod.setEnabled(false);
                btn_Tur_novo.setEnabled(true);
                btn_tur_excluir.setEnabled(true);
                
                break;
            
            case "Novo":
                btn_tur_salvar.setEnabled(true);
                btn_tur_cancelar.setEnabled(true);
                c_tur_sala.setEnabled(true);
                c_tur_cod.setEnabled(true);
                btn_Tur_novo.setEnabled(false);
                btn_tur_excluir.setEnabled(false);
                break;
                
            case "Excluir":
                btn_tur_salvar.setEnabled(false);
                btn_tur_cancelar.setEnabled(false);
                c_tur_sala.setEnabled(false);
                c_tur_cod.setEnabled(false);
                btn_Tur_novo.setEnabled(true);
                btn_tur_excluir.setEnabled(false);
                
                break;
                
            case "Selecao":
                btn_tur_salvar.setEnabled(false);
                btn_tur_cancelar.setEnabled(false);
                c_tur_sala.setEnabled(false);
                c_tur_cod.setEnabled(false);
                btn_Tur_novo.setEnabled(true);
                btn_tur_excluir.setEnabled(true);
                
                break;
            default: System.out.println("Modo inválido");
        }
    }
    public void ManipulaInterfaceProf(){
        switch(modoProf){
            case "Navegar":
                btn_prof_salvar.setEnabled(false);
                btn_prof_cancelar.setEnabled(false);
                c_prof_mat.setEnabled(false);
                c_prof_nome.setEnabled(false);
                btn_prof_novo.setEnabled(true);
                btn_prof_excluir.setEnabled(true);
                cb_prof_turma.setEnabled(true);
                break;
            
            case "Novo":
                btn_prof_salvar.setEnabled(true);
                btn_prof_cancelar.setEnabled(true);
                c_prof_mat.setEnabled(true);
                c_prof_nome.setEnabled(true);
                btn_prof_novo.setEnabled(false);
                btn_prof_excluir.setEnabled(false);
                cb_prof_turma.setEnabled(true);
                break;
                
            case "Excluir":
                btn_prof_salvar.setEnabled(true);
                btn_prof_cancelar.setEnabled(true);
                c_prof_mat.setEnabled(true);
                c_prof_nome.setEnabled(false);
                btn_prof_novo.setEnabled(false);
                btn_prof_excluir.setEnabled(true);
                cb_prof_turma.setEnabled(true);
                break;
                
            case "Selecao":
                btn_prof_salvar.setEnabled(false);
                btn_prof_cancelar.setEnabled(false);
                c_prof_mat.setEnabled(false);
                c_prof_nome.setEnabled(false);
                btn_prof_novo.setEnabled(true);
                btn_prof_excluir.setEnabled(true);
                cb_prof_turma.setEnabled(false);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    
    public void ManipulaInterfaceAlun(){
        switch(modoAlun){
            case "Navegar":
                btn_alun_salvar.setEnabled(false);
                btn_alun_cancelar.setEnabled(false);
                c_alun_mat.setEnabled(false);
                c_alun_nome.setEnabled(false);
                btn_Alun_novo.setEnabled(true);
                btn_Alun_excluir.setEnabled(true);
                cb_alun_turma.setEnabled(true);
                break;
            
            case "Novo":
                btn_alun_salvar.setEnabled(true);
                btn_alun_cancelar.setEnabled(true);
                c_alun_mat.setEnabled(true);
                c_alun_nome.setEnabled(true);
                btn_Alun_novo.setEnabled(false);
                btn_Alun_excluir.setEnabled(false);
                cb_alun_turma.setEnabled(true);
                break;
                
            case "Excluir":
                btn_alun_salvar.setEnabled(true);
                btn_alun_cancelar.setEnabled(true);
                c_alun_mat.setEnabled(true);
                c_alun_nome.setEnabled(false);
                btn_Alun_novo.setEnabled(false);
                btn_Alun_excluir.setEnabled(true);
                cb_alun_turma.setEnabled(true);
                break;
                
            case "Selecao":
                btn_alun_salvar.setEnabled(false);
                btn_alun_cancelar.setEnabled(false);
                c_alun_mat.setEnabled(false);
                c_alun_nome.setEnabled(false);
                btn_Alun_novo.setEnabled(true);
                btn_Alun_excluir.setEnabled(true);
                cb_alun_turma.setEnabled(false);
                break;
            default: System.out.println("Modo inválido");
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_tur_dpts = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        c_tur_sala = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        c_tur_cod = new javax.swing.JTextField();
        btn_tur_salvar = new javax.swing.JButton();
        btn_tur_cancelar = new javax.swing.JButton();
        btn_Tur_novo = new javax.swing.JButton();
        btn_tur_excluir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_prof_funcs = new javax.swing.JTable();
        btn_prof_excluir = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        c_prof_mat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        c_prof_nome = new javax.swing.JTextField();
        btn_prof_salvar = new javax.swing.JButton();
        btn_prof_cancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cb_prof_turma = new javax.swing.JComboBox();
        btn_prof_novo = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_Alun_funcs = new javax.swing.JTable();
        btn_Alun_novo = new javax.swing.JButton();
        btn_Alun_excluir = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        c_alun_mat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        c_alun_nome = new javax.swing.JTextField();
        btn_alun_salvar = new javax.swing.JButton();
        btn_alun_cancelar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        cb_alun_turma = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl_tur_dpts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sala", "Codigo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tur_dpts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tur_dptsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_tur_dpts);
        if (tbl_tur_dpts.getColumnModel().getColumnCount() > 0) {
            tbl_tur_dpts.getColumnModel().getColumn(0).setResizable(false);
            tbl_tur_dpts.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_tur_dpts.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Turma"));

        jLabel1.setText("Sala:");

        jLabel2.setText("CodDis:");

        btn_tur_salvar.setText("Salvar");
        btn_tur_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tur_salvarActionPerformed(evt);
            }
        });

        btn_tur_cancelar.setText("Cancelar");
        btn_tur_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tur_cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(c_tur_sala, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(c_tur_cod))
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_tur_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_tur_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(c_tur_sala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(c_tur_cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tur_salvar)
                    .addComponent(btn_tur_cancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btn_Tur_novo.setText("Novo");
        btn_Tur_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Tur_novoActionPerformed(evt);
            }
        });

        btn_tur_excluir.setText("Excluir");
        btn_tur_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tur_excluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Tur_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(btn_tur_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Tur_novo)
                    .addComponent(btn_tur_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Turmas", jPanel1);

        tbl_prof_funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SIAP", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_prof_funcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_prof_funcsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_prof_funcs);
        if (tbl_prof_funcs.getColumnModel().getColumnCount() > 0) {
            tbl_prof_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_prof_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        btn_prof_excluir.setText("Excluir");
        btn_prof_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prof_excluirActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Professor"));

        jLabel3.setText("SIAP:");

        jLabel4.setText("Nome:");

        btn_prof_salvar.setText("Salvar");
        btn_prof_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prof_salvarActionPerformed(evt);
            }
        });

        btn_prof_cancelar.setText("Cancelar");
        btn_prof_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prof_cancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Turma:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_prof_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_prof_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_prof_nome)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(c_prof_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 156, Short.MAX_VALUE))
                    .addComponent(cb_prof_turma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_prof_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_prof_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cb_prof_turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_prof_salvar)
                    .addComponent(btn_prof_cancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        btn_prof_novo.setText("Novo");
        btn_prof_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prof_novoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btn_prof_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(btn_prof_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_prof_novo)
                    .addComponent(btn_prof_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Professores", jPanel2);

        tbl_Alun_funcs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matricula", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Alun_funcs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_Alun_funcsMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_Alun_funcs);
        if (tbl_Alun_funcs.getColumnModel().getColumnCount() > 0) {
            tbl_Alun_funcs.getColumnModel().getColumn(0).setPreferredWidth(100);
            tbl_Alun_funcs.getColumnModel().getColumn(1).setPreferredWidth(150);
        }

        btn_Alun_novo.setText("Novo");
        btn_Alun_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Alun_novoActionPerformed(evt);
            }
        });

        btn_Alun_excluir.setText("Excluir");
        btn_Alun_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Alun_excluirActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Aluno"));

        jLabel8.setText("Mat:");

        jLabel9.setText("Nome:");

        btn_alun_salvar.setText("Salvar");
        btn_alun_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alun_salvarActionPerformed(evt);
            }
        });

        btn_alun_cancelar.setText("Cancelar");
        btn_alun_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_alun_cancelarActionPerformed(evt);
            }
        });

        jLabel10.setText("Turma:");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(btn_alun_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_alun_cancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(c_alun_nome)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(c_alun_mat, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 159, Short.MAX_VALUE))
                    .addComponent(cb_alun_turma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(c_alun_mat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(c_alun_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cb_alun_turma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_alun_salvar)
                    .addComponent(btn_alun_cancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btn_Alun_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(130, 130, 130)
                        .addComponent(btn_Alun_excluir, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Alun_novo)
                    .addComponent(btn_Alun_excluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Alunos", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Tur_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Tur_novoActionPerformed
        c_tur_sala.setText("");
        c_tur_cod.setText("");
        
        modoTur = "Novo";
        ManipulaInterfaceTur();
    }//GEN-LAST:event_btn_Tur_novoActionPerformed

    private void btn_tur_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tur_cancelarActionPerformed
        c_tur_sala.setText("");
        c_tur_cod.setText("");
        modoTur = "Navegar";
        ManipulaInterfaceTur();
    }//GEN-LAST:event_btn_tur_cancelarActionPerformed

    private void btn_tur_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tur_salvarActionPerformed

            Turma T = new Turma();
            T.setSala(c_tur_sala.getText());
            T.setCodDisciplina(c_tur_cod.getText());
            ListaTur.add(T);
        
        LoadTableTur();
        c_tur_sala.setText("");
        c_tur_cod.setText("");
        modoTur = "Navegar";
        ManipulaInterfaceTur();
    }//GEN-LAST:event_btn_tur_salvarActionPerformed

    private void tbl_tur_dptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tur_dptsMouseClicked
       int index = tbl_tur_dpts.getSelectedRow();
        if(index>=0 && index<ListaTur.size()){
            Turma T = ListaTur.get(index);
            c_tur_sala.setText(String.valueOf(T.getSala()));
            c_tur_cod.setText(T.getCodDisciplina());
        modoTur = "Selecao";
        ManipulaInterfaceTur();
        }
    }//GEN-LAST:event_tbl_tur_dptsMouseClicked

    private void btn_tur_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tur_excluirActionPerformed
        int index = tbl_tur_dpts.getSelectedRow();
        if(index>=0 && index<ListaTur.size()){
            Turma T = ListaTur.remove(index);
        
        }
        LoadTableTur();
        modoTur = "Navegar";
        ManipulaInterfaceTur();
    }//GEN-LAST:event_btn_tur_excluirActionPerformed

    private void tbl_prof_funcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_prof_funcsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_prof_funcsMouseClicked

    private void btn_prof_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prof_excluirActionPerformed
        int index = tbl_prof_funcs.getSelectedRow();
        if(index>=0 && index<ListaProf.size()){
            Professor f = ListaProf.remove(index);
        
        }
        modoProf = "Navegar";
        ManipulaInterfaceProf();
    }//GEN-LAST:event_btn_prof_excluirActionPerformed

    private void btn_prof_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prof_salvarActionPerformed
       int index = cb_prof_turma.getSelectedIndex();
        if(index==0){
            JOptionPane.showMessageDialog(this,"Você deve selecionar uma turma");
        }else{
            Professor p = new Professor();
            p.setSiape(c_prof_mat.getText());
            p.setNome(c_prof_nome.getText());
            p.addDisciplina(ListaTur.get(index-1));
            
            ListaProf.add(p);
            ListaTur.get(index-1).setProfessor(p);
        }
        LoadTableProf();
        modoProf = "Navegar";
        ManipulaInterfaceProf();
    }//GEN-LAST:event_btn_prof_salvarActionPerformed

    private void btn_prof_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prof_cancelarActionPerformed
   
    }//GEN-LAST:event_btn_prof_cancelarActionPerformed

    private void btn_prof_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prof_novoActionPerformed
        modoProf = "Novo";
        ManipulaInterfaceProf();
    }//GEN-LAST:event_btn_prof_novoActionPerformed

    private void tbl_Alun_funcsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_Alun_funcsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_Alun_funcsMouseClicked

    private void btn_Alun_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Alun_novoActionPerformed
        modoAlun = "Novo";
        ManipulaInterfaceAlun();
    }//GEN-LAST:event_btn_Alun_novoActionPerformed

    private void btn_Alun_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Alun_excluirActionPerformed
        int index = tbl_Alun_funcs.getSelectedRow();
        if(index>=0 && index<ListaAluno.size()){
            Aluno a = ListaAluno.remove(index);
        
        }
        modoAlun = "Navegar";
        ManipulaInterfaceAlun();
    }//GEN-LAST:event_btn_Alun_excluirActionPerformed

    private void btn_alun_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alun_salvarActionPerformed
        int index = cb_alun_turma.getSelectedIndex();
        if(index==0){
            JOptionPane.showMessageDialog(this,"Você deve selecionar uma Turma");
        }else{
            Aluno a = new Aluno();
            a.setMatricula(c_alun_mat.getText());
            a.setNome(c_prof_nome.getText());
            a.addDisciplinas(ListaTur.get(index-1));
            
            ListaAluno.add(a);
            ListaTur.get(index-1).setTurma(ListaAluno);
        }
        LoadTableAlun();
        modoAlun = "Navegar";
        ManipulaInterfaceAlun();
    }//GEN-LAST:event_btn_alun_salvarActionPerformed

    private void btn_alun_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_alun_cancelarActionPerformed
        
    }//GEN-LAST:event_btn_alun_cancelarActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Alun_excluir;
    private javax.swing.JButton btn_Alun_novo;
    private javax.swing.JButton btn_Tur_novo;
    private javax.swing.JButton btn_alun_cancelar;
    private javax.swing.JButton btn_alun_salvar;
    private javax.swing.JButton btn_prof_cancelar;
    private javax.swing.JButton btn_prof_excluir;
    private javax.swing.JButton btn_prof_novo;
    private javax.swing.JButton btn_prof_salvar;
    private javax.swing.JButton btn_tur_cancelar;
    private javax.swing.JButton btn_tur_excluir;
    private javax.swing.JButton btn_tur_salvar;
    private javax.swing.JTextField c_alun_mat;
    private javax.swing.JTextField c_alun_nome;
    private javax.swing.JTextField c_prof_mat;
    private javax.swing.JTextField c_prof_nome;
    private javax.swing.JTextField c_tur_cod;
    private javax.swing.JTextField c_tur_sala;
    private javax.swing.JComboBox cb_alun_turma;
    private javax.swing.JComboBox cb_prof_turma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_Alun_funcs;
    private javax.swing.JTable tbl_prof_funcs;
    private javax.swing.JTable tbl_tur_dpts;
    // End of variables declaration//GEN-END:variables
}



