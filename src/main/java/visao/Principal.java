package visao;

import dao.*;
import modelo.*;
import conexao.Conexao;
import java.awt.Color;
import java.awt.Cursor;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {

    CandidatoDAO candidatoDAO = new CandidatoDAO();
    EleitorDAO   eleitorDAO   = new EleitorDAO();
    PartidoDAO   partidoDAO   = new PartidoDAO();
    VotoDAO      votoDAO      = new VotoDAO();
    Urna         urna         = new Urna();
    
    public Principal() {
        initComponents();
        this.setTitle("Central");
        this.getContentPane().setBackground(Color.WHITE);       
        this.setExtendedState(MAXIMIZED_BOTH);
        
        /*Iniciando servico*/
        Conexao.service();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuBarraPrincipal = new javax.swing.JMenuBar();
        menuCadastro = new javax.swing.JMenu();
        menuCadastroCandidato = new javax.swing.JMenuItem();
        menuCadastroEleitor = new javax.swing.JMenuItem();
        menuCadastroPartido = new javax.swing.JMenuItem();
        menuUtilitarios = new javax.swing.JMenu();
        computarVotos = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MENU");
        setBackground(new java.awt.Color(216, 43, 48));
        setForeground(java.awt.Color.red);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logotipo - Copia.png"))); // NOI18N

        menuBarraPrincipal.setBackground(new java.awt.Color(1, 1, 1));
        menuBarraPrincipal.setBorder(new javax.swing.border.MatteBorder(null));
        menuBarraPrincipal.setForeground(new java.awt.Color(245, 175, 19));

        menuCadastro.setForeground(new java.awt.Color(234, 168, 19));
        menuCadastro.setText("Cadastro");
        menuCadastro.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        menuCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroMouseEntered(evt);
            }
        });

        menuCadastroCandidato.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroCandidato.setText("Candidato");
        menuCadastroCandidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroCandidatoMouseEntered(evt);
            }
        });
        menuCadastroCandidato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroCandidatoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroCandidato);

        menuCadastroEleitor.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroEleitor.setText("Eleitor");
        menuCadastroEleitor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroEleitorMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroEleitorMouseEntered(evt);
            }
        });
        menuCadastroEleitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroEleitorActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroEleitor);

        menuCadastroPartido.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        menuCadastroPartido.setText("Partido");
        menuCadastroPartido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuCadastroPartidoMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCadastroPartidoMouseEntered(evt);
            }
        });
        menuCadastroPartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCadastroPartidoActionPerformed(evt);
            }
        });
        menuCadastro.add(menuCadastroPartido);

        menuBarraPrincipal.add(menuCadastro);

        menuUtilitarios.setForeground(new java.awt.Color(240, 174, 24));
        menuUtilitarios.setText("Utilitários");
        menuUtilitarios.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        menuUtilitarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                menuUtilitariosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuUtilitariosMouseEntered(evt);
            }
        });

        computarVotos.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        computarVotos.setText("Computar Votos");
        computarVotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                computarVotosMouseExited(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                computarVotosMouseEntered(evt);
            }
        });
        computarVotos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computarVotosActionPerformed(evt);
            }
        });
        menuUtilitarios.add(computarVotos);

        menuBarraPrincipal.add(menuUtilitarios);

        setJMenuBar(menuBarraPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 472, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuCadastroEleitorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroEleitorActionPerformed
        new Eleitor(eleitorDAO).setVisible(true);
    }//GEN-LAST:event_menuCadastroEleitorActionPerformed

    private void menuCadastroCandidatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoActionPerformed
        new Candidato(candidatoDAO, partidoDAO).setVisible(true);
    }//GEN-LAST:event_menuCadastroCandidatoActionPerformed

    private void menuCadastroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroMouseEntered

    private void menuCadastroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroMouseExited

    private void menuCadastroCandidatoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoMouseEntered

    private void menuCadastroEleitorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroEleitorMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroEleitorMouseEntered

    private void menuCadastroCandidatoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroCandidatoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroCandidatoMouseExited

    private void menuCadastroEleitorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroEleitorMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroEleitorMouseExited

    private void menuUtilitariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUtilitariosMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuUtilitariosMouseExited

    private void computarVotosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computarVotosMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_computarVotosMouseExited

    private void menuUtilitariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuUtilitariosMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuUtilitariosMouseEntered

    private void computarVotosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_computarVotosMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_computarVotosMouseEntered

    private void menuCadastroPartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCadastroPartidoActionPerformed
        new Partido(partidoDAO).setVisible(true);
    }//GEN-LAST:event_menuCadastroPartidoActionPerformed

    private void menuCadastroPartidoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroPartidoMouseEntered
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_menuCadastroPartidoMouseEntered

    private void menuCadastroPartidoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCadastroPartidoMouseExited
        this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_menuCadastroPartidoMouseExited

    private void computarVotosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computarVotosActionPerformed
        new TabelaVotos(candidatoDAO).setVisible(true);
    }
    
    public void Teste(){
        
        /*A ideia e criar uma tabela e mostrar o resultado dos votos*/
        Urna urna = new Urna();
        VotoDAO votoDAO = new VotoDAO();
        urna.setVotoDAO(votoDAO);
        
        CadPartido partido = new CadPartido();
        partido.setNome("Partido1");
        partido.setNumero(14);
        partido.setSigla("TES");
        
        CadCandidato candidato = new CadCandidato();
        candidato.setNome("Candidato1");
        candidato.setCpf("137.378.256-02");
        candidato.setNumero(14);
        candidato.setPartido(partido);
        
        CadEleitor eleitor = new CadEleitor();
        eleitor.setNome("Eleitor 1");
        eleitor.setCpf("137.378.256-02");
        eleitor.setSecao(1);
        eleitor.setNumeroTitulo("32156 klj");
        
        Voto voto = new Voto(urna);
        voto.setCandidato(candidato);
        voto.setEleitor(eleitor);
        
        votoDAO.inserir(voto);                     
        
        System.out.println("AAOPA");
        //https://stackoverflow.com/questions/2937991/create-tablemodel-and-populate-jtable-dynamically#
        String nomeColunas [] = {"NOME ELEITOR", "CPF", "NOME CANDIDATO", "CPF", "PARTIDO", "DATA/HORA"};
        
        DefaultTableModel modeloTabela = new DefaultTableModel();//nomeColunas);
                
//        modeloTabela.addColumn("NOME ELEITOR");
//        modeloTabela.addColumn("CPF");
//        modeloTabela.addColumn("NOME CANDIDATO");
//        modeloTabela.addColumn("CPF");
//        modeloTabela.addColumn("PARTIDO");
//        modeloTabela.addColumn("DATA/HORA");
        System.out.println("AAOPA");
        
//        Object []  linhaTabela = (new Object[]{v.getEleitor().getNome(), 
//                                               v.getEleitor().getCpf(),
//                                               v.getCandidato().getNome(),
//                                               v.getCandidato().getCpf(),
//                                               v.getCandidato().getPartido().getSigla(),
//                                               v.getData()});
//            ((default) tabela.getmodel()).addrow(linhatavela);

        JTable tabela = new JTable();
            
        //modeloTabela.addRow(urna.getVotoDAO().getVoto());
//        for (Voto v : urna.getVotoDAO().getVoto()){
//            if (v != null){
//                System.out.println("Entrou");
//                Object []  linhaTabela = (new Object[]{v.getEleitor().getNome(), 
//                                                       v.getEleitor().getCpf(),
//                                                       v.getCandidato().getNome(),
//                                                       v.getCandidato().getCpf(),
//                                                       v.getCandidato().getPartido().getSigla(),
//                                                       v.getData()});
//                ((DefaultTableModel) tabela.getModel()).addRow(linhaTabela);
//            }
//        }
                
        Object []  linhaTabela = (new Object[]{urna.getVotoDAO().getVoto()});
        ((DefaultTableModel) tabela.getModel()).addRow(linhaTabela);
        
        //tabela.setModel(modeloTabela, new String [] = {"NOME ELEITOR", "CPF", "NOME CANDIDATO", "CPF", "PARTIDO", "DATA/HORA"});
        //tabela.setVisible(true);
        JScrollPane painel = new JScrollPane();
        painel.setViewportView(tabela);
        
        System.out.println("AAOPA");
        
        //String [] columnNames =     {"ID", "First Name", "Last Name", "Email Address"};
        //String [][] aux = {votos[0]};
        
//        for (int i = 0; i < votos.length ; i++){
//            if (votos[i] != null){
//                aux += votos[i];
//            }
//        }
//        
//        
//        JTable tabela = new JTable(votos[i], nomeColunas);
//        for (Voto v: votos){
//            tabela.add(v);
//        }
    }//GEN-LAST:event_computarVotosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem computarVotos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBarraPrincipal;
    private javax.swing.JMenu menuCadastro;
    private javax.swing.JMenuItem menuCadastroCandidato;
    private javax.swing.JMenuItem menuCadastroEleitor;
    private javax.swing.JMenuItem menuCadastroPartido;
    private javax.swing.JMenu menuUtilitarios;
    // End of variables declaration//GEN-END:variables
}