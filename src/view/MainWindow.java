/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jaime
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaMonitoramento = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Alarmes = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        PainelGrafico = new javax.swing.JPanel();
        barraEstacaoMain = new javax.swing.JProgressBar();
        barraEstacaoTVU = new javax.swing.JProgressBar();
        barraEstacaoVeraCruz = new javax.swing.JProgressBar();
        barraEstacaoCearaMirim = new javax.swing.JProgressBar();
        barraEstacaoOdonto = new javax.swing.JProgressBar();
        barraEstacaoMuseu = new javax.swing.JProgressBar();
        labelPoP = new javax.swing.JLabel();
        labelTVU = new javax.swing.JLabel();
        labelVeraCruz = new javax.swing.JLabel();
        labelCearaMirim = new javax.swing.JLabel();
        labelOdonto = new javax.swing.JLabel();
        labelMuseu = new javax.swing.JLabel();
        labelCCS = new javax.swing.JLabel();
        barraEstacaoCCS = new javax.swing.JProgressBar();
        labelDEGEPOL = new javax.swing.JLabel();
        barraEstacaoDEGEPOL = new javax.swing.JProgressBar();
        barraGama = new javax.swing.JProgressBar();
        labelGama = new javax.swing.JLabel();
        barraDelta = new javax.swing.JProgressBar();
        labelDelta = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jPanel6 = new javax.swing.JPanel();
        BotaoControle = new javax.swing.JButton();
        BotaoGraficos = new javax.swing.JButton();
        BotaoAgendamento = new javax.swing.JButton();
        BotaoTemperatura = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuAjuda = new javax.swing.JMenuItem();
        menuContato = new javax.swing.JMenuItem();
        menuSobre = new javax.swing.JMenuItem();
        menuSair = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuTeste = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        menuVerGraficos = new javax.swing.JMenuItem();
        menuGraficos = new javax.swing.JMenuItem();
        menuVerDevices = new javax.swing.JMenuItem();
        menuMapa = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menuEditar = new javax.swing.JMenuItem();
        menuControlarEstacoes = new javax.swing.JMenuItem();
        menuTemperatura = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 770));
        setResizable(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        TabelaMonitoramento.setBackground(new java.awt.Color(204, 204, 204));
        TabelaMonitoramento.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        TabelaMonitoramento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, ""},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Estação", "Porta", "Ar"
            }
        ));
        TabelaMonitoramento.setEnabled(false);
        jScrollPane2.setViewportView(TabelaMonitoramento);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Alarmes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        Alarmes.setBackground(new java.awt.Color(204, 204, 204));
        Alarmes.setColumns(20);
        Alarmes.setRows(5);
        Alarmes.setEnabled(false);
        jScrollPane1.setViewportView(Alarmes);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Temperatura", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        PainelGrafico.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout PainelGraficoLayout = new javax.swing.GroupLayout(PainelGrafico);
        PainelGrafico.setLayout(PainelGraficoLayout);
        PainelGraficoLayout.setHorizontalGroup(
            PainelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 877, Short.MAX_VALUE)
        );
        PainelGraficoLayout.setVerticalGroup(
            PainelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        barraEstacaoMain.setMaximum(60);
        barraEstacaoMain.setMinimum(10);
        barraEstacaoMain.setValue(0);
        barraEstacaoMain.setString("");
        barraEstacaoMain.setStringPainted(true);

        barraEstacaoTVU.setString("");
        barraEstacaoTVU.setStringPainted(true);

        labelPoP.setText("Estação PoP");

        labelTVU.setText("Estação TVU");

        labelVeraCruz.setText("Estação Vera Cruz");

        labelCearaMirim.setText("Estação Ceará Mirim");

        labelOdonto.setText("Estação Odonto");

        labelMuseu.setText("Estação Museu");

        labelCCS.setText("Estação CCS");

        labelDEGEPOL.setText("Estação DEGEPOL");

        labelGama.setText("Estação Gama");

        labelDelta.setText("Estação Delta");

        jSeparator1.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator2.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator3.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator4.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator5.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator6.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator7.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator8.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator9.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator10.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        jSeparator11.setForeground(javax.swing.UIManager.getDefaults().getColor("Button.background"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelPoP)
                                    .addComponent(labelTVU)
                                    .addComponent(labelVeraCruz)
                                    .addComponent(labelCearaMirim)
                                    .addComponent(labelOdonto)
                                    .addComponent(labelMuseu)
                                    .addComponent(labelCCS)
                                    .addComponent(labelGama)
                                    .addComponent(labelDelta)
                                    .addComponent(labelDEGEPOL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(barraEstacaoMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraEstacaoTVU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraEstacaoVeraCruz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraEstacaoCearaMirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraEstacaoOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraEstacaoMuseu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraEstacaoCCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraEstacaoDEGEPOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barraDelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PainelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 622, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(labelPoP))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(barraEstacaoMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTVU)
                    .addComponent(barraEstacaoTVU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelVeraCruz)
                    .addComponent(barraEstacaoVeraCruz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCearaMirim)
                    .addComponent(barraEstacaoCearaMirim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelOdonto)
                    .addComponent(barraEstacaoOdonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelMuseu)
                    .addComponent(barraEstacaoMuseu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelCCS)
                    .addComponent(barraEstacaoCCS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDEGEPOL)
                    .addComponent(barraEstacaoDEGEPOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGama)
                    .addComponent(barraGama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDelta)
                    .addComponent(barraDelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PainelGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Menu", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N

        BotaoControle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imegens/control-panel.png"))); // NOI18N
        BotaoControle.setText("Controle");

        BotaoGraficos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imegens/graph.png"))); // NOI18N
        BotaoGraficos.setText("Graficos");

        BotaoAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imegens/calendario.png"))); // NOI18N
        BotaoAgendamento.setText("Agendamento");

        BotaoTemperatura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imegens/temperature-2-xxl.png"))); // NOI18N
        BotaoTemperatura.setText("Temperatura");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BotaoGraficos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotaoAgendamento, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(182, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(BotaoControle, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BotaoTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoControle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoTemperatura, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotaoAgendamento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("DC Control");

        menuAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.META_MASK));
        menuAjuda.setText("Ajuda");
        jMenu1.add(menuAjuda);

        menuContato.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.META_MASK));
        menuContato.setText("Contato");
        jMenu1.add(menuContato);

        menuSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.META_MASK));
        menuSobre.setText("Sobre");
        jMenu1.add(menuSobre);

        menuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.META_MASK));
        menuSair.setText("Sair");
        jMenu1.add(menuSair);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ferramentas");

        menuTeste.setText("Teste de Conexão");
        jMenu2.add(menuTeste);

        jMenuItem5.setText("Relatórios");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("Visualização");

        menuVerGraficos.setText("Ver Gráficos");
        jMenu6.add(menuVerGraficos);

        menuGraficos.setText("Configurações dos Gráficos");
        menuGraficos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuGraficosActionPerformed(evt);
            }
        });
        jMenu6.add(menuGraficos);

        menuVerDevices.setText("Mostrar/Ocutar Dispositivos");
        jMenu6.add(menuVerDevices);

        menuMapa.setText("Mapa Estrutural");
        jMenu6.add(menuMapa);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Opções");

        menuEditar.setText("Consultar Estações");
        jMenu7.add(menuEditar);

        menuControlarEstacoes.setText("Controlar Estações");
        jMenu7.add(menuControlarEstacoes);

        menuTemperatura.setText("Temperatura Padrão");
        jMenu7.add(menuTemperatura);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuGraficosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuGraficosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menuGraficosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JTextArea Alarmes;
    protected javax.swing.JButton BotaoAgendamento;
    protected javax.swing.JButton BotaoControle;
    protected javax.swing.JButton BotaoGraficos;
    protected javax.swing.JButton BotaoTemperatura;
    public javax.swing.JPanel PainelGrafico;
    protected javax.swing.JTable TabelaMonitoramento;
    protected javax.swing.JProgressBar barraDelta;
    protected javax.swing.JProgressBar barraEstacaoCCS;
    protected javax.swing.JProgressBar barraEstacaoCearaMirim;
    protected javax.swing.JProgressBar barraEstacaoDEGEPOL;
    protected javax.swing.JProgressBar barraEstacaoMain;
    protected javax.swing.JProgressBar barraEstacaoMuseu;
    protected javax.swing.JProgressBar barraEstacaoOdonto;
    protected javax.swing.JProgressBar barraEstacaoTVU;
    protected javax.swing.JProgressBar barraEstacaoVeraCruz;
    protected javax.swing.JProgressBar barraGama;
    protected javax.swing.JMenu jMenu1;
    protected javax.swing.JMenu jMenu2;
    protected javax.swing.JMenu jMenu6;
    protected javax.swing.JMenu jMenu7;
    protected javax.swing.JMenuBar jMenuBar1;
    protected javax.swing.JMenuItem jMenuItem5;
    public javax.swing.JPanel jPanel1;
    protected javax.swing.JPanel jPanel2;
    protected javax.swing.JPanel jPanel5;
    protected javax.swing.JPanel jPanel6;
    protected javax.swing.JScrollPane jScrollPane1;
    protected javax.swing.JScrollPane jScrollPane2;
    protected javax.swing.JSeparator jSeparator1;
    protected javax.swing.JSeparator jSeparator10;
    protected javax.swing.JSeparator jSeparator11;
    protected javax.swing.JSeparator jSeparator2;
    protected javax.swing.JSeparator jSeparator3;
    protected javax.swing.JSeparator jSeparator4;
    protected javax.swing.JSeparator jSeparator5;
    protected javax.swing.JSeparator jSeparator6;
    protected javax.swing.JSeparator jSeparator7;
    protected javax.swing.JSeparator jSeparator8;
    protected javax.swing.JSeparator jSeparator9;
    protected javax.swing.JLabel labelCCS;
    protected javax.swing.JLabel labelCearaMirim;
    protected javax.swing.JLabel labelDEGEPOL;
    protected javax.swing.JLabel labelDelta;
    protected javax.swing.JLabel labelGama;
    protected javax.swing.JLabel labelMuseu;
    protected javax.swing.JLabel labelOdonto;
    protected javax.swing.JLabel labelPoP;
    protected javax.swing.JLabel labelTVU;
    protected javax.swing.JLabel labelVeraCruz;
    protected javax.swing.JMenuItem menuAjuda;
    protected javax.swing.JMenuItem menuContato;
    protected javax.swing.JMenuItem menuControlarEstacoes;
    protected javax.swing.JMenuItem menuEditar;
    protected javax.swing.JMenuItem menuGraficos;
    protected javax.swing.JMenuItem menuMapa;
    protected javax.swing.JMenuItem menuSair;
    protected javax.swing.JMenuItem menuSobre;
    protected javax.swing.JMenuItem menuTemperatura;
    protected javax.swing.JMenuItem menuTeste;
    protected javax.swing.JMenuItem menuVerDevices;
    protected javax.swing.JMenuItem menuVerGraficos;
    // End of variables declaration//GEN-END:variables

public void addConectarListenerControle(ActionListener listen){
        BotaoControle.addActionListener(listen);
        menuControlarEstacoes.addActionListener(listen);
    }
public void addConectarListenerMenuVerDevices(ActionListener listen){
        menuVerDevices.addActionListener(listen);
    }
public void addConectarListenerMenuGraficos(ActionListener listen){
        menuGraficos.addActionListener(listen);
        menuVerGraficos.addActionListener(listen);
    }
public void addConectarListenerMenuEditar(ActionListener listen){
        menuEditar.addActionListener(listen);
    }
public void addConectarListenerMenuTeste(ActionListener listen){
        menuTeste.addActionListener(listen);
    }
public void addConectarListenerMenuSair(ActionListener listen){
        menuSair.addActionListener(listen);
    }
public void addConectarListenerMenuSobre(ActionListener listen){
        menuSobre.addActionListener(listen);
    }
public void addConectarListenerMenuContato(ActionListener listen){
        menuContato.addActionListener(listen);
    }
public void addConectarListenerMenuAjuda(ActionListener listen){
        menuAjuda.addActionListener(listen);
    }
public void addConectarListenerMenuMapa(ActionListener listen){
        menuMapa.addActionListener(listen);
    }
public void addConectarListenerVerGraficos(ActionListener listen){
        BotaoGraficos.addActionListener(listen);
    }
public void mostrarErro(String erro){
        JOptionPane.showMessageDialog(null, erro, "Erro!", JOptionPane.ERROR_MESSAGE);
    }
public void mostrarAviso(String erro){
        JOptionPane.showMessageDialog(null, erro, "Aviso!", JOptionPane.WARNING_MESSAGE);
    }
public void addConectarListenerMostrarTemperatura(ActionListener listen){
        menuTemperatura.addActionListener(listen);
        BotaoTemperatura.addActionListener(listen);
    }
}
