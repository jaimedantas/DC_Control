package view;
import controller.SNMP_server;
import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import view.ConsoleWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.Worker;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.Dataset;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Hour;
import org.jfree.data.time.Minute;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import view.ControlWindow;
import view.LoginWindow;
import view.MainWindow;
import controller.Estacoes;
import java.awt.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import static java.lang.Math.ceil;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author jaime
 */
public class DataCenterControl {
    private static ConsoleWindow JanelaConsole;
    private static AlertWindow JanelaAlerta;
    private static TempWindow JanelaTemperatura;
    private static MainWindow JanelaMonitoramento;
    private static EditStationWindow JanelaEditar;
    private static MapWindow JanelaMapa;
    private static ConnectionTestWindow JanelaTeste;
    private static SNMP_server ArduinoSNMP;
    private static Estacoes ListaEstacoes;
    //private static SNMP_server ArduinoSNMPTVU;
    private static ControlWindow JanelaControle;
    private static LoginWindow JanelaLogin;
    private static SelectDeviceWindow JanelaSelecaoDevices;
    private static DisplayGraphWindow JanelaSelecaoSensores;
    private static ContactWindow JanelaContato;
    private static AboutWindow JanelaSobre;

    private JFrame JanelaGraficos;
    private JTabbedPane tabs;
    DefaultTableModel model;
    DefaultTableCellRenderer centerRenderer;

    //OBS TEM Q MUDAR NO LISTENING TB
    String IP_POP = "192.168.2.2";
    String IP_TVU = "192.168.70.90";
    String IP_MUSEU = "192.168.2.4";
    String IP_ODONTO = "192.168.2.5";
    String IP_CEARAMIRIM = "192.168.2.6";
    String IP_VERACRUZ = "192.168.2.7";
    String IP_CCS = "192.168.2.8";
    String IP_DEGEPOL = "192.168.2.9";

    int Porta_POP = 161;
    int Porta_TVU = 162;
    int Porta_MUSEU = 163;
    int Porta_ODONTO = 164;
    int Porta_CEARAMIRIM = 165;
    int Porta_VERACRUZ = 166;
    int Porta_CCS = 166;
    int Porta_DEGEPOL = 166;
    //setar quem esta on
    boolean POP=false;
    boolean TVU=false;
    boolean MUSEU=false;
    boolean ODONTO=false;
    boolean CEARAMIRIM=false;
    boolean VERACRUZ=false;
    boolean CCS=false;
    boolean DEGEPOL=false;
    
    boolean isSensorEquipamento = true;
    boolean isSensorExterno = true;
    //para grafico
    boolean isCreated = false;

    boolean login = false;
    String Comando;
    String senha = "poprn";
    String usuario = "POP-RN";
    String usuario2 = "pop-rn";
    //tabela

    
    
    //------------ESTAOCAO PoP
    private final XYSeries temperatura_sensor_seriePOP;
    private final XYSeries temperatura_placa_seriePOP;
    private final XYSeries humiadde_dht_seriePOP;
    private final XYSeries estado_porta_seriePOP;
    private final XYSeries estado_ar_seriePOP;
    
    
    float temperaturaSensorPOP;
    float temperaturaPlacaPOP;
    float dht11HumidadePOP;
    int estado_arPOP;
    int estado_portaPOP;
    //resultados anteriores
    float temperaturaSensorPOP_anterior;
    float temperaturaPlacaPOP_anterior;
    float dht11HumidadePOP_anterior;
    int estado_arPOP_anterior;
    int estado_portaPOP_anterior;

    //-------------ESTACAO TVU
    private final XYSeries temperatura_sensor_serieTVU;
    private final XYSeries temperatura_placa_serieTVU;
    private final XYSeries humiadde_dht_serieTVU;
    private final XYSeries estado_porta_serieTVU;
    private final XYSeries estado_ar_serieTVU;
    
    float temperaturaSensorTVU;
    float temperaturaPlacaTVU;
    float dht11HumidadeTVU;
    int estado_arTVU;
    int estado_portaTVU;
    //anteriores
    float temperaturaSensorTVU_anterior;
    float temperaturaPlacaTVU_anterior;
    float dht11HumidadeTVU_anterior;
    int estado_arTVU_anterior;
    int estado_portaTVU_anterior;
    
        //-------------ESTACAO MUSEU
    private final XYSeries temperatura_sensor_serieMUSEU;
    private final XYSeries temperatura_placa_serieMUSEU;
    private final XYSeries humiadde_dht_serieMUSEU;
    private final XYSeries estado_porta_serieMUSEU;
    private final XYSeries estado_ar_serieMUSEU;
    
    float temperaturaSensorMUSEU;
    float temperaturaPlacaMUSEU;
    float dht11HumidadeMUSEU;
    int estado_arMUSEU;
    int estado_portaMUSEU;
    
    public String SaidaPing = null;
    float latenciaPing,perdasPing;


    public ImageIcon arLigado = new ImageIcon(DataCenterControl.class.getResource("/imegens/ar_ligado.png"));
    public ImageIcon arDesligado = new ImageIcon(DataCenterControl.class.getResource("/imegens/ar_desligado.png"));
    public ImageIcon PortaAberta = new ImageIcon(DataCenterControl.class.getResource("/imegens/rack_aberto.png"));
    public ImageIcon PortaFechada = new ImageIcon(DataCenterControl.class.getResource("/imegens/rack_fechado.png"));
    DataCenterControl(){
        JanelaConsole = new ConsoleWindow();
        JanelaConsole.addConectarListener(new ConnectListener());
        JanelaConsole.addConectarListenerAbrirPorta(new ConnectListenerAbrirPorta());
        JanelaConsole.addConectarListenerFecharPorta(new ConnectListenerFecharPorta());
        JanelaConsole.addConectarListenerLigarAr(new ConnectListenerLigarAr());
        JanelaConsole.addConectarListenerDesligarAr(new ConnectListenerDesligarAr());
        JanelaConsole.addConectarListenerTemp1(new ConnectListenerTemp1());
        JanelaConsole.addConectarListenerTemp2(new ConnectListenerTemp2());
        JanelaConsole.addConectarListenerHumidade(new ConnectListenerHumidade());
        JanelaConsole.pack();
        JanelaConsole.setLocationRelativeTo(null);
        JanelaConsole.setTitle("Arduino");
        //JanelaConsole.setVisible(true);
        
        
        JanelaMonitoramento = new MainWindow();
        JanelaMonitoramento.addConectarListenerVerGraficos(new ConnectListenerVerGrafico());
        JanelaMonitoramento.addConectarListenerControle(new ConnectListenerBotaoControle());
        JanelaMonitoramento.addConectarListenerMenuVerDevices(new ConnectListenerMostrarTelaDevices());
        JanelaMonitoramento.addConectarListenerMenuGraficos(new ConnectListenerAtualizarGraficosCurvas());
        JanelaMonitoramento.addConectarListenerMenuEditar(new ConnectListenerEditarEstacao());
        JanelaMonitoramento.addConectarListenerMenuMapa(new ConnectListenerMenuMapa());
        JanelaMonitoramento.addConectarListenerMenuTeste(new ConnectListenerMenuTeste());
        JanelaMonitoramento.addConectarListenerMostrarTemperatura(new ConnectListenerMostrarTemp());
        JanelaMonitoramento.addConectarListenerMenuSair(new ConnectListenerMenuSair());
        JanelaMonitoramento.addConectarListenerMenuContato(new ConnectListenerMenuContato());
        JanelaMonitoramento.addConectarListenerMenuAjuda(new ConnectListenerMenuAjuda());
        JanelaMonitoramento.addConectarListenerMenuSobre(new ConnectListenerMenuSobre());

        JanelaMonitoramento.pack();
        JanelaMonitoramento.setLocationRelativeTo(null);
        JanelaMonitoramento.setTitle("DC Control - Data Center Environmental Control System");
        //JanelaMinitoramento.setVisible(true);
        //---------opaga os lablels
        JanelaMonitoramento.labelPoP.setVisible(false);
        JanelaMonitoramento.labelTVU.setVisible(false);
        JanelaMonitoramento.labelCearaMirim.setVisible(false);
        JanelaMonitoramento.labelVeraCruz.setVisible(false);
        JanelaMonitoramento.labelMuseu.setVisible(false);
        JanelaMonitoramento.labelOdonto.setVisible(false);
        JanelaMonitoramento.labelCCS.setVisible(false);
        JanelaMonitoramento.labelDEGEPOL.setVisible(false);
        JanelaMonitoramento.labelGama.setVisible(false);
        JanelaMonitoramento.labelDelta.setVisible(false);
        //seta barra para false
        JanelaMonitoramento.barraEstacaoMain.setVisible(false);
        JanelaMonitoramento.barraEstacaoTVU.setVisible(false);
        JanelaMonitoramento.barraEstacaoCearaMirim.setVisible(false);
        JanelaMonitoramento.barraEstacaoVeraCruz.setVisible(false);
        JanelaMonitoramento.barraEstacaoMuseu.setVisible(false);
        JanelaMonitoramento.barraEstacaoOdonto.setVisible(false);
        JanelaMonitoramento.barraEstacaoCCS.setVisible(false);
        JanelaMonitoramento.barraEstacaoDEGEPOL.setVisible(false);
        JanelaMonitoramento.barraGama.setVisible(false);
        JanelaMonitoramento.barraDelta.setVisible(false);
        JanelaMonitoramento.setDefaultCloseOperation(JanelaMonitoramento.EXIT_ON_CLOSE);



        
        
        JanelaControle = new ControlWindow();
        JanelaControle.addConectarListenerEnviarComando(new ConnectListenerControle());
        JanelaControle.pack();
        JanelaControle.setLocationRelativeTo(null);
        JanelaControle.setDefaultCloseOperation(JanelaControle.DISPOSE_ON_CLOSE);
        JanelaControle.setTitle("Controle");
        //JanelaControle.EstacaoBox.remove(0);
        JanelaControle.EstacaoBox.removeAllItems();
        //JanelaControle.EstacaoBox.remove(9);
        //JanelaControle.setVisible(true);
        
        
        
        JanelaSobre = new AboutWindow();
        JanelaSobre.pack();
        JanelaSobre.setLocationRelativeTo(null);
        JanelaSobre.setDefaultCloseOperation(JanelaSobre.DISPOSE_ON_CLOSE);
        JanelaSobre.setTitle("Sobre");
        
        JanelaContato = new ContactWindow();
        JanelaContato.pack();
        JanelaContato.setLocationRelativeTo(null);
        JanelaContato.setDefaultCloseOperation(JanelaContato.DISPOSE_ON_CLOSE);
        JanelaContato.setTitle("Contato");
        //janela temperatura
        
        JanelaTemperatura = new TempWindow();
        JanelaTemperatura.addConectarListenerSalvar(new ConnectListenerFecharTemperatura());
        JanelaTemperatura.pack();
        JanelaTemperatura.setLocationRelativeTo(null);
        JanelaTemperatura.setDefaultCloseOperation(JanelaTemperatura.DISPOSE_ON_CLOSE);
        JanelaTemperatura.setTitle("Controle de Temperatura");
        //setar a temperatura padrao
        int temperaturaPadrao = 40;
        int tempoPadrao = 30;
        //seta a temperatura para o acionamento
        JanelaTemperatura.temperaturaPOP.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaTVU.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaDEGIPOL.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaMUSEU.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaGAMA.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaVERACRUZ.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaCEARAMIRIM.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaODONTO.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaCCS.setValue(temperaturaPadrao);
        JanelaTemperatura.temperaturaDELTA.setValue(temperaturaPadrao);
        //seta o tempo para acionamento
        JanelaTemperatura.tempoPOP.setValue(tempoPadrao);
        JanelaTemperatura.tempoTVU.setValue(tempoPadrao);
        JanelaTemperatura.tempoDEGEPOL.setValue(tempoPadrao);
        JanelaTemperatura.tempoMUSEU.setValue(tempoPadrao);
        JanelaTemperatura.tempoGAMA.setValue(tempoPadrao);
        JanelaTemperatura.tempoVERACRUZ.setValue(tempoPadrao);
        JanelaTemperatura.tempoCEARAMIRIM.setValue(tempoPadrao);
        JanelaTemperatura.tempoODONTO.setValue(tempoPadrao);
        JanelaTemperatura.tempoCCS.setValue(tempoPadrao);
        JanelaTemperatura.tempoDELTA.setValue(tempoPadrao);

        //JanelaTemperatura.setVisible(true);
        
        
        JanelaAlerta = new AlertWindow();
        JanelaAlerta.addConectarListenerFechar(new ConnectListenerfFecharAlerta());
        JanelaAlerta.pack();
        JanelaAlerta.setLocationRelativeTo(null);
        JanelaAlerta.setDefaultCloseOperation(JanelaAlerta.DISPOSE_ON_CLOSE);
        JanelaAlerta.setTitle("Alerta");
        //JanelaControle.EstacaoBox.remove(0);
        //JanelaControle.EstacaoBox.remove(9);
        //JanelaControle.setVisible(true);
        
        
        
        ////CRIA A JANELA DOS GRAFICOS
        JanelaGraficos = new JFrame("Gráficos");
        //configurações da janela
        JanelaGraficos.setSize(1200,720);
        JanelaGraficos.setLayout(new BorderLayout());
        WindowListener listener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent w) {
                JanelaGraficos.setVisible(false);
            }
        };
        JanelaGraficos.addWindowListener(listener);
        JanelaGraficos.setLocationRelativeTo(null);
        tabs = new JTabbedPane();
        
        JanelaLogin = new LoginWindow();
        JanelaLogin.addConectarListenerEntrar(new ConnectListenerEntrar());
        JanelaLogin.pack();
        JanelaLogin.setLocationRelativeTo(null);
        JanelaLogin.setTitle("Login");
        JanelaLogin.setVisible(true);
        
        JanelaSelecaoDevices = new SelectDeviceWindow();
        JanelaSelecaoDevices.addConectarListenerAtualizar(new ConnectListenerAtualizaListaON());
        JanelaSelecaoDevices.pack();
        JanelaSelecaoDevices.setLocationRelativeTo(null);
        JanelaSelecaoDevices.setTitle("Estações");
        JanelaSelecaoDevices.setDefaultCloseOperation(JanelaSelecaoDevices.DISPOSE_ON_CLOSE);
        //JanelaSelecaoDevices.setVisible(true);
        
        
        JanelaMapa = new MapWindow();
        //JanelaMapa.addConectarListenerMenuMapa(new ConnectListenerMenuMapa());
        JanelaMapa.pack();
        JanelaMapa.setLocationRelativeTo(null);
        JanelaMapa.setTitle("Mapa da Rede");
        JanelaMapa.setDefaultCloseOperation(JanelaMapa.DISPOSE_ON_CLOSE);
        //JanelaSelecaoDevices.setVisible(true);
        
        
        JanelaTeste = new ConnectionTestWindow();
        JanelaTeste.addConectarListenerTestarSNMP(new ConnectListenerTesteSNMP());
        JanelaTeste.addConectarListenerTestarPing(new ConnectListenerTestePing());
        JanelaTeste.addConectarListenerFecharTeste(new ConnectListenerFecharTeste());
        JanelaTeste.pack();
        JanelaTeste.setLocationRelativeTo(null);
        JanelaTeste.setTitle("Teste de Dispositivos");
        JanelaTeste.setDefaultCloseOperation(JanelaTeste.DISPOSE_ON_CLOSE);
        JanelaTeste.output.setAutoscrolls(true);
        //JanelaSelecaoDevices.setVisible(true);
        
        JanelaEditar = new EditStationWindow();
        JanelaEditar.addConectarListeneFechar (new ConnectListenerFecharEditar());
        JanelaEditar.pack();
        JanelaEditar.setLocationRelativeTo(null);
        JanelaEditar.setTitle("Edição de Estações");
        JanelaEditar.setDefaultCloseOperation(JanelaEditar.DISPOSE_ON_CLOSE);
        
        
        //janela de selecao dos sensores
        JanelaSelecaoSensores = new DisplayGraphWindow();
        JanelaSelecaoSensores.addConectarListenerAtualizarGraphSensor(new ConnectListenerSensorGrapGlobal());
        JanelaSelecaoSensores.pack();
        JanelaSelecaoSensores.setLocationRelativeTo(null);
        JanelaSelecaoSensores.setTitle("Sensores");
        JanelaSelecaoSensores.setDefaultCloseOperation(JanelaSelecaoSensores.DISPOSE_ON_CLOSE);
        ArduinoSNMP = new SNMP_server();
        ListaEstacoes = new Estacoes();
       // ArduinoSNMPTVU = new SNMP_server();

        
        //----------ESTACAO MAIN
        this.temperaturaPlacaPOP = 30;
        this.temperaturaSensorPOP = 29;
        this.temperatura_placa_seriePOP = new XYSeries("Sensor do Equipamento PoP");        
        this.temperatura_sensor_seriePOP = new XYSeries("Sensor do Rack PoP");
        this.humiadde_dht_seriePOP = new XYSeries("Humidade PoP");
        this.estado_porta_seriePOP = new XYSeries("Porta PoP");
        this.estado_ar_seriePOP = new XYSeries("Ar PoP");
        
        
        //-----------ESTACAO TVU
        this.temperaturaPlacaTVU = 30;
        this.temperaturaSensorTVU = 29;
        this.temperatura_placa_serieTVU = new XYSeries("Sensor do Equipamento TVU");        
        this.temperatura_sensor_serieTVU = new XYSeries("Sensor do Rack TVU");
        this.humiadde_dht_serieTVU = new XYSeries("Humidade TVU");
        this.estado_porta_serieTVU = new XYSeries("Porta TVU");
        this.estado_ar_serieTVU = new XYSeries("Ar TVU");
        
        //-----------ESTACAO MUSEU
        this.temperaturaPlacaMUSEU = 30;
        this.temperaturaSensorMUSEU = 29;
        this.temperatura_placa_serieMUSEU = new XYSeries("Sensor do Equipamento TVU");        
        this.temperatura_sensor_serieMUSEU = new XYSeries("Sensor do Rack TVU");
        this.humiadde_dht_serieMUSEU = new XYSeries("Humidade TVU");
        this.estado_porta_serieMUSEU = new XYSeries("Porta TVU");
        this.estado_ar_serieMUSEU = new XYSeries("Ar TVU");
        //--------do grafico-------
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
        model = new DefaultTableModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();



    }
    public static void main(String[] args) {
        DataCenterControl Tela = new DataCenterControl();

        
    }
    
    
    //------Janela Console
    class ConnectListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                //Recebe nome e last boot
                JanelaConsole.AddText("Nome da estacao: "+ArduinoSNMP.getName(IP_TVU, Porta_POP));
                JanelaConsole.AddText("Last Boot: "+ArduinoSNMP.getLastBoot(IP_TVU, Porta_POP));
                JanelaConsole.AddText("Saidas: "+ArduinoSNMP.getSaidas(IP_TVU, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ConnectListenerAbrirPorta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){   
            try {
                JanelaConsole.AddText("Porta Aberta! Retorno: "+ArduinoSNMP.OpenDoor(IP_POP, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ConnectListenerFecharPorta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                JanelaConsole.AddText("Porta Fechada! Retorno: "+ArduinoSNMP.CloseDoor(IP_POP, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ConnectListenerLigarAr implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                JanelaConsole.AddText("Ar Ligado! Retorno: "+ArduinoSNMP.LigaAr(IP_POP, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ConnectListenerDesligarAr implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                JanelaConsole.AddText("Ar Deslidado! Retorno: "+ArduinoSNMP.DesligaAr(IP_POP, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ConnectListenerTemp1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                JanelaConsole.AddText("Temperatura 1: "+ArduinoSNMP.getTemp1(IP_POP, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ConnectListenerTemp2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                JanelaConsole.AddText("Temperatura 2: "+ArduinoSNMP.getTemp2(IP_POP, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    class ConnectListenerHumidade implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                JanelaConsole.AddText("Humidade: "+ArduinoSNMP.getHumidade(IP_POP, Porta_POP));
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //---Janela Devices
    class ConnectListenerAtualizaListaON implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //Primeiro temos q setar quem ta on
            if(!login){
                model.addColumn("Estação");
                model.addColumn("Porta");
                model.addColumn("Ar Condicionado");
                //model.addRow(new Object[]{});
                JanelaMonitoramento.TabelaMonitoramento.setModel(model);
            }
            //centralizar valores
//            centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
//            JanelaMonitoramento.TabelaMonitoramento.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
            if(JanelaSelecaoDevices.pop.isSelected()){
                AtivaEstacoes(0);
                JanelaMonitoramento.labelPoP.setVisible(true);
                JanelaMonitoramento.barraEstacaoMain.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação PoP");
                //this.tabelaDetalhes.setValueAt(value, this.tabelaDetalhes.getRowCount()-1, column);
                if(!login){
                    model.addRow(new Object[]{});
                JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação PoP", 
                        JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.tvu.isSelected()){
                AtivaEstacoes(1);
                JanelaMonitoramento.labelTVU.setVisible(true);
                JanelaMonitoramento.barraEstacaoTVU.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação TVU");
                if(!login){
                model.addRow(new Object[]{});
                JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação TVU", 
                        JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.veracruz.isSelected()){
                AtivaEstacoes(2);
                JanelaMonitoramento.labelVeraCruz.setVisible(true);
                JanelaMonitoramento.barraEstacaoVeraCruz.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação Vera Cruz");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação Vera Cruz", 
                            JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.cearamirim.isSelected()){
                AtivaEstacoes(3);
                JanelaMonitoramento.labelCearaMirim.setVisible(true);
                JanelaMonitoramento.barraEstacaoCearaMirim.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação Ceará Mirim");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação Ceará Mirim", 
                        JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }    
            if(JanelaSelecaoDevices.odonto.isSelected()){
                AtivaEstacoes(4);
                JanelaMonitoramento.labelOdonto.setVisible(true);
                JanelaMonitoramento.barraEstacaoOdonto.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação Odonto");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação Odonto", 
                            JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.museu.isSelected()){
                AtivaEstacoes(5);
                JanelaMonitoramento.labelMuseu.setVisible(true);
                JanelaMonitoramento.barraEstacaoMuseu.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação Museu");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação Museu", 
                        JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.ccs.isSelected()){
                DesativaEstacoes(6);
                JanelaMonitoramento.labelCCS.setVisible(true);
                JanelaMonitoramento.barraEstacaoCCS.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação CCS");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação CCS", 
                        JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.degepol.isSelected()){
                DesativaEstacoes(7);
                JanelaMonitoramento.labelDEGEPOL.setVisible(true);
                JanelaMonitoramento.barraEstacaoDEGEPOL.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação DEGEPOL");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação DEGEPOL", 
                            JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.gama.isSelected()){
                DesativaEstacoes(6);
                JanelaMonitoramento.labelGama.setVisible(true);
                JanelaMonitoramento.barraGama.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação Gama");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação Gama", 
                        JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            if(JanelaSelecaoDevices.delta.isSelected()){
                DesativaEstacoes(7);
                JanelaMonitoramento.labelDelta.setVisible(true);
                JanelaMonitoramento.barraDelta.setVisible(true);
                JanelaControle.EstacaoBox.addItem("Estação Delta");
                if(!login){
                    model.addRow(new Object[]{});
                    JanelaMonitoramento.TabelaMonitoramento.setValueAt("Estação Delta", 
                        JanelaMonitoramento.TabelaMonitoramento.getRowCount()-1, 0);
                }
            }
            
            //PARA DESATIVAR
            if(!JanelaSelecaoDevices.pop.isSelected()){
                DesativaEstacoes(0);
                JanelaMonitoramento.labelPoP.setVisible(false);
                JanelaMonitoramento.barraEstacaoMain.setVisible(false);
            }
            if(!JanelaSelecaoDevices.tvu.isSelected()){
                DesativaEstacoes(1);
                JanelaMonitoramento.labelTVU.setVisible(false);
                JanelaMonitoramento.barraEstacaoTVU.setVisible(false);
            }
            if(!JanelaSelecaoDevices.veracruz.isSelected()){
                DesativaEstacoes(2);
                JanelaMonitoramento.labelVeraCruz.setVisible(false);
                JanelaMonitoramento.barraEstacaoVeraCruz.setVisible(false);
            }
            if(!JanelaSelecaoDevices.cearamirim.isSelected()){
                DesativaEstacoes(3);
                JanelaMonitoramento.labelCearaMirim.setVisible(false);
                JanelaMonitoramento.barraEstacaoCearaMirim.setVisible(false);
            }
            if(!JanelaSelecaoDevices.odonto.isSelected()){
                DesativaEstacoes(4);
                JanelaMonitoramento.labelOdonto.setVisible(false);
                JanelaMonitoramento.barraEstacaoOdonto.setVisible(false);
            }
            if(!JanelaSelecaoDevices.museu.isSelected()){
                DesativaEstacoes(5);
                JanelaMonitoramento.labelMuseu.setVisible(false);
                JanelaMonitoramento.barraEstacaoMuseu.setVisible(false);
            }
            if(!JanelaSelecaoDevices.ccs.isSelected()){
                DesativaEstacoes(6);
                JanelaMonitoramento.labelCCS.setVisible(false);
                JanelaMonitoramento.barraEstacaoCCS.setVisible(false);
            }
            if(!JanelaSelecaoDevices.degepol.isSelected()){
                DesativaEstacoes(7);
                JanelaMonitoramento.labelDEGEPOL.setVisible(false);
                JanelaMonitoramento.barraEstacaoDEGEPOL.setVisible(false);
            }
            if(!JanelaSelecaoDevices.gama.isSelected()){
                DesativaEstacoes(6);
                JanelaMonitoramento.labelGama.setVisible(false);
                JanelaMonitoramento.barraGama.setVisible(false);
            }
            if(!JanelaSelecaoDevices.delta.isSelected()){
                DesativaEstacoes(7);
                JanelaMonitoramento.labelDelta.setVisible(false);
                JanelaMonitoramento.barraDelta.setVisible(false);
            }
            if(!login){
                JanelaMonitoramento.setVisible(true);
                FuncaoThreadsGraficos();
            }
            if(login) GerarNovosGraficos();
            JanelaSelecaoDevices.setVisible(false);
            JanelaMonitoramento.mostrarAviso("Apenas as estações selecionadas estarão disponíveis para controle!");

            
            
        }
    }
    public void AtivaEstacoes(int estacao){
        switch (estacao){
            case 0:
                this.POP = true;
                break;
            case 1:
                this.TVU = true;
                break;
            case 2:
                this.VERACRUZ = true;
                break;
            case 3:
                this.CEARAMIRIM = true;
                break;
            case 4:
                this.ODONTO = true;
                break;
            case 5:
                this.MUSEU = true;
                break;
            case 6:
                this.CCS = true;
                break;
            case 7:
                this.DEGEPOL = true;
                break;
            default:
                break;
        }
    }
    public void DesativaEstacoes(int estacao){
        switch (estacao){
            case 0:
                this.POP = false;
                break;
            case 1:
                this.TVU = false;
                break;
            case 2:
                this.VERACRUZ = false;
                break;
            case 3:
                this.CEARAMIRIM = false;
                break;
            case 4:
                this.ODONTO = false;
                break;
            case 5:
                this.MUSEU = false;
                break;
            case 6:
                this.CCS = false;
                break;
            case 7:
                this.DEGEPOL = false;
                break;
            default:
                break;
        }
    }
    
    //---Janela Sensores Grafico
    class ConnectListenerSensorGrapGlobal implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            atualizaSensoresGlobal(JanelaSelecaoSensores.equipamento.isSelected(), JanelaSelecaoSensores.rack.isSelected());
            JanelaSelecaoSensores.setVisible(false);
            GerarNovosGraficos();
        }
        
    }
    
    //---Janela de Alertas
    class ConnectListenerfFecharAlerta implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaAlerta.setVisible(false);
        }
        
    }
    
    //---Janela Temperatura
    class ConnectListenerFecharTemperatura implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaTemperatura.setVisible(false);
        }
        
    }
  
    //---Janela Mapa
    class ConnectListenerMenuMapa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaMapa.setVisible(true);      
        }
        
    }
    
    //-----Janela Teste de conexao
    class ConnectListenerMenuTeste implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaTeste.setVisible(true);      
        }
        
    }
    
    public void atualizaSensoresGlobal(boolean equi, boolean rack){
        this.isSensorEquipamento = equi;
        this.isSensorExterno = rack;
    }
    
    //Janela Controle
    class ConnectListenerControle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                new Thread(new AtualizaBarraControle(4)).start();
                //descobre controle
                int TipoControle, PortaControle=1;
                String int_ipControle;
                String IPControle="";
                TipoControle = JanelaControle.TipoControleBox.getSelectedIndex();
                //1 = Ar e 2 = Porta
                int_ipControle = JanelaControle.EstacaoBox.getSelectedItem().toString();
                //TEM QUE MUDAR AQUI QUANDO MODIFICAR O NOME
                switch(int_ipControle){
                    case "Estação PoP":
                        IPControle = "192.168.2.2";
                        PortaControle = 161;
                        break;
                    case "Estação TVU":
                        IPControle = "192.168.70.90";
                        PortaControle = 162;
                        break;
                    case "Estação Museu":
                        IPControle = "192.168.2.4";
                        PortaControle = 163;
                        break;
                    case "Estação Odonto":
                        IPControle = "192.168.2.5";
                        PortaControle = 164;
                        break;
                    case "Estação Ceará Mirim":
                        IPControle = "192.168.2.6";
                        PortaControle = 165;
                        break;
                    case "Estação Vera Cruz":
                        IPControle = "192.168.2.7";
                        PortaControle = 166;
                        break;
                    case "Estação CCS":
                        IPControle = "192.168.2.8";
                        PortaControle = 167;
                        break;
                    case "Estação DEGEPOL":
                        IPControle = "192.168.2.9";
                        PortaControle = 168;
                        break;
                    case "Estação Alfa":
                        IPControle = "192.168.2.10";
                        PortaControle = 169;
                        break;
                    case "Estação Gama":
                        IPControle = "192.168.2.11";
                        PortaControle = 170;
                        break;
                    default:
                        break;
                }
                //controle em si
                if(TipoControle==0){//controle de ar
                    if(JanelaControle.EstadoBox.getSelectedIndex()==0){
                        ArduinoSNMP.LigaAr(IPControle, PortaControle);
                    }
                    else if(JanelaControle.EstadoBox.getSelectedIndex()==1){
                        ArduinoSNMP.DesligaAr(IPControle, PortaControle);
                    }
                }
                else if(TipoControle==1){//controle da porta
                    if(JanelaControle.EstadoBox.getSelectedIndex()==0){
                        ArduinoSNMP.OpenDoor(IPControle, PortaControle);
                    }
                    else if(JanelaControle.EstadoBox.getSelectedIndex()==1){
                        ArduinoSNMP.CloseDoor(IPControle, PortaControle);
                    }
                }
                //checagem
                int [] saidas;
                saidas = pegarSaidas(IPControle, PortaControle);
                if(TipoControle==1 && saidas[0]==0){
                    JanelaControle.labelStatus.setText("0");
                    JanelaControle.LabelPorta.setIcon(PortaFechada);
                }
                if(TipoControle==1 && saidas[0]==1){
                    JanelaControle.labelStatus.setText("1");
                    JanelaControle.LabelPorta.setIcon(PortaAberta);

                }
                if(TipoControle==0 && saidas[1]==0){
                    JanelaControle.labelStatus.setText("0");
                    JanelaControle.LabelAr.setIcon(arDesligado);

                }
                if(TipoControle==0 && saidas[1]==1){
                    JanelaControle.labelStatus.setText("1");
                    JanelaControle.LabelAr.setIcon(arLigado);
                }
                
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("excecao da janela controle listenning");
                JanelaMonitoramento.mostrarErro("Erro ao na thread ConnectListenerControle!\n"
                        + "Exceção: "+ex);

            }
        }
    }
    
    //janela editar estacao
    class ConnectListenerEditarEstacao implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaEditar.setVisible(true);
        }
    }
    class ConnectListenerFecharEditar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaEditar.setVisible(false);
        }
        
    }

    //Janela Login
    class ConnectListenerEntrar implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
                if((JanelaLogin.getUsuario().equals(usuario) || JanelaLogin.getUsuario().equals(usuario2))
                        && JanelaLogin.checkSenha()){
                    JanelaLogin.setVisible(false);
                    JanelaSelecaoDevices.setVisible(true);//vai abrir o janela de divices
                


                }
                else{
                    JanelaMonitoramento.mostrarErro("Usuário e/ou senha inválida!");
            }
        }
    }
    
    //Janela de teste de conexao
    class ConnectListenerTesteSNMP implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //VAI MANDAR UM COMANDO SNMP
            //pegar o ip selecionado
            String IP_local;
            int Porta_local;
            int horas=0, minutos=0, dias=0, segundos=0;
            int boot;
            IP_local =  ListaEstacoes.getIPEstacao(JanelaTeste.estacaoSNMP.getSelectedIndex());
            Porta_local = ListaEstacoes.getPortaEstacao(JanelaTeste.estacaoSNMP.getSelectedIndex());
            try {
                //Recebe nome e last boot
                JanelaTeste.output.append("Nome da estacao: "+ArduinoSNMP.getName(IP_local, Porta_local)+"\n");
                boot = Integer.valueOf(ArduinoSNMP.getLastBoot(IP_local, Porta_local));
                if (boot>=86400) {
                    dias = (int) ceil(boot/86400);
                    boot = boot - (dias*86400);
                }
                if (boot>=3600) {
                    horas = (int) ceil(boot/3600);
                    boot = boot - (horas*3600);
                }
                if (boot>=60) {
                minutos = (int) ceil(boot/60);
                boot = boot - (minutos*60);
                }
                segundos = boot;
                JanelaTeste.output.append("Last Boot: "+dias+" dias, "+horas+" horas, "+minutos+" minutos, "+segundos+" segundos\n");
                JanelaTeste.output.append("Saidas: "+ArduinoSNMP.getSaidas(IP_local, Porta_local)+"\n\n");
            } catch (IOException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                JanelaMonitoramento.mostrarErro("Erro na conexão!");
            }
        }
    }
    class ConnectListenerFecharTeste implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaTeste.setVisible(false);
        }
    }
    class ConnectListenerTestePing implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            //chama thread
            new Thread(new AtualizarTelaPing()).start();  
            new Thread(new AtualizaBarraPing(
                    Integer.valueOf(JanelaTeste.PingCount.getValue().toString()))).start();    
        }
    }

    
    //=======================COMANDO PING===================
    public String doCommandPing(java.util.List<String> command) throws IOException{
    int n=0;
    int k;
    String retorno=null;
    String impresao=null;
    k=100/Integer.parseInt(JanelaTeste.PingCount.getValue().toString());
    ProcessBuilder pb = new ProcessBuilder(command);
    Process process = pb.start();

    BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
    BufferedReader stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

    // read the output from the command
    //System.out.println("Saida Ping:\n");
    //TelaPrincipal.addTextOutput("Teste de Ping:\n");
    while ((impresao = stdInput.readLine()) != null)
    {
      JanelaTeste.output.append(impresao);
      JanelaTeste.output.append("\n");
      //TelaPrincipal.UpdatePing(n);
      retorno+=impresao;
      //n+=k;
    }

    // read any errors from the attempted command
    //System.out.println("Erro no Ping!");
    while ((impresao = stdError.readLine()) != null)
    {
      //System.out.println(SaidaPing);
    }
    return retorno;
  }
    
    public class AtualizarTelaPing implements Runnable {

    private volatile boolean running = true;

    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            String IP_local;
            java.util.List<String> commands = new ArrayList<String>();
            commands.add("ping");
            commands.add("-c");
            commands.add(JanelaTeste.PingCount.getValue().toString());
            IP_local =  ListaEstacoes.getIPEstacao(JanelaTeste.estacaoPing.getSelectedIndex());
            commands.add(IP_local);
            JanelaTeste.output.append("\nTeste de Ping: \n");
            try {
                SaidaPing = doCommandPing(commands);
            } catch (IOException ex) {
                JanelaMonitoramento.mostrarErro("Erro ao tentar realizar o Ping");
            }
//            Tratamento.setSaidaPing(SaidaPing);
//            Tratamento.setTamanhoPing((int) TelaPrincipal.PingCount.getValue());
//            if(SaidaPing.contains("limite")){
                int retorno = TratarPingString();
//            }
//            else {
//                int sucesso = Tratamento.TratarPingString();
//            }
//            TelaRelatorio.latenciaBOX.setText(String.valueOf(Tratamento.getLatencia()));
//            TelaRelatorio.perdasBOX.setText(String.valueOf(Tratamento.getPerdas()));
            terminate();
        }

    }
}
    
    public class AtualizaBarraPing implements Runnable {

    private volatile boolean running = true;
       private int to, barra;
      public AtualizaBarraPing(int to) {
          this.to = to;
      }
    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        int n=0;
        int k = (int) ceil((double)100/to);
        float k2 = (float)100/to;
        int dormir;
            if(k2<1){
                 dormir =(int) ceil((double)1000/k2);
            }
            else{
                dormir = 1000;
            }
        while (running) {
            while (n <= 100){

                        JanelaTeste.barraPing.setValue(n);

                try {
                    Thread.sleep(dormir);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                }
                n+=k;
            }
            terminate();
        }

    }
}
    //funcao para quando nao tem limite de perda
    public int TratarPingString(){
        String linha ="";
        String Valor ="";
        String Valor2="";
        int retorno=0;
        char numero;
        int tamanhoLinha;
        //determina perdas
        String[] partePerdas = this.SaidaPing.split("%");
        for(int j=1;j<7;j++){
                numero = partePerdas[0].charAt(partePerdas[0].length()-j);
                Valor = numero+Valor;
        }
        if(Valor.contains(",")){
                Valor = Valor.replace(',', ' ');
            }
        if(Valor.contains("d")){
                Valor = Valor.replace('d', ' ');
            }
        //System.out.println("perdas ping: "+Valor);
        this.perdasPing = Float.parseFloat(Valor.trim());
        JanelaTeste.PerdasPing.setText(String.valueOf(perdasPing));
        
        //determina latencia
        String[] partelatencia = this.SaidaPing.split("/");
        for(int j=1;j<6;j++){
                numero = partelatencia[4].charAt(partelatencia[5].length()-j);
                Valor2 = numero+Valor2;
        }
        if(Valor2.contains("/")){
                Valor2 = Valor2.replace('/', ' ');
            }
        //System.out.println("latencia ping: "+Valor2);
        this.latenciaPing = Float.parseFloat(Valor2.trim());
        JanelaTeste.LatenciaPing.setText(String.valueOf(latenciaPing));
        
        
        return retorno;
    }
    
    //----------------------FIM PING--------------------------------
    
    
    
    //Janela Monitoramento
    class ConnectListenerVerGrafico implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaGraficos.setVisible(true);
        }
    }
    class ConnectListenerBotaoControle implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){   
            JanelaControle.setVisible(true);
        }
    }
    class ConnectListenerMostrarTelaDevices implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){   
            JanelaSelecaoDevices.setVisible(true);
        }
    }
    class ConnectListenerAtualizarGraficosCurvas implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){  
            JanelaSelecaoSensores.setVisible(true);
        }
    }
    class ConnectListenerMostrarTemp implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaTemperatura.setVisible(true);
        }
        
    }
    class ConnectListenerMenuContato implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaContato.setVisible(true);
        }
        
    }
    class ConnectListenerMenuSobre implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaSobre.setVisible(true);
        } 
    }
    class ConnectListenerMenuAjuda implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JanelaMonitoramento.mostrarAviso("Entre em contanto com Jaime!");
        }
    }
    class ConnectListenerMenuSair implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    }
    //-------------------------------Funcoes do Grafico-------------------------
    public void GerarNovosGraficos(){
            createChart();
            createChartTempGraphWindow();
            //JanelaGraficos.getContentPane().add(tabs);//jogo as tabs para a janela
            try{
                new Thread(new atualizarGraficos()).start();    
            }catch (Exception e){
                //System.out.println("Erro no start da thread de atualizar gráficos.");
                JanelaMonitoramento.mostrarErro("Erro ao na thread GerarNovosGraficos!\n"
                        + "Exceção: "+e);
            }


    } 
    public void FuncaoThreadsGraficos(){
            try{
               if(this.POP) {
                   new Thread(new ExecutaThreadTempPOP(Porta_POP,IP_POP)).start();
                   new Thread(new ThreadCheckTempRackPOP(Porta_POP,IP_POP)).start();
               }  
               if(this.TVU) {
                   new Thread(new ExecutaThreadTempTVU(Porta_TVU,IP_TVU)).start();
                   new Thread(new ThreadCheckTempRackTVU(Porta_TVU,IP_TVU)).start();
               }
            } catch (Exception e){
                System.out.println("Erro no start da thread de pegar temperatura.");
            }
            createChart();
            createChartHumidade();
            createChartPorta();
            createChartAr();
            createChartTempGraphWindow();
            JanelaGraficos.getContentPane().add(tabs);//jogo as tabs para a janela
            try{
                new Thread(new atualizarGraficos()).start();    
            }catch (Exception e){
                System.out.println("Erro no start da thread de atualizar gráficos.");
                JanelaMonitoramento.mostrarErro("Erro ao na thread FuncaoThreadsGraficos!\n"
                        + "Exceção: "+e);
            }


    }
    class ExecutaThreadTempPOP implements Runnable{
        private String IP;
        private int porta;
        private int[] arrayEstados2 = new int[2];
        private volatile boolean running = true;
        //construtor
        public ExecutaThreadTempPOP(int porta, String IP) {
          this.porta = porta;
          this.IP = IP;
        }
        public void terminate() {
            running = false;
        }
        @Override
        public void run(){
            while(running){
                try {
                    //              try {
                    setTempRackPOP(pegarSensor1(IP, porta));
                    setTempPlacaPOP(pegarSensor2(IP, porta));
                    setHumidadePOP(pegarHumidade(IP, porta));
                    arrayEstados2 = pegarSaidas(IP,porta);
                    setEstadosSaidasPOP(getNomeEstacao(IP), arrayEstados2[0], arrayEstados2[1]);
                    //setTempPlacaTVU(pegarSensor2TVU(IP_TVU,Porta_TVU));
                } catch (IOException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                    JanelaMonitoramento.mostrarErro("Erro ao na thread ExecutaThreadTemp!\n"
                        + "Exceção: "+ex);
                }
                try{
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                    
                }
            }
        }
    }
    //=========================CHECAGEM DE TEMPERATURA
    //---------------thread de checagem das temperaturas das estacoes
    class ThreadCheckTempRackPOP implements Runnable{
    private String IP;
    private int porta;
    int contadorInterno=0;
    int temperaturaUsuario;
    float temperaturaAtual;
    int tempoUsuario;
    int limite;
    boolean noThread = true;
    private int[] arrayEstados2 = new int[2];
    private volatile boolean running = true;
    //construtor vai passar o IP e Porta para cada estacao
    public ThreadCheckTempRackPOP(int porta, String IP) {
      this.porta = porta;
      this.IP = IP;
    }
    public void terminate() {
        running = false;
    }
    @Override
    public void run(){
        while(running){
            temperaturaUsuario = Integer.valueOf(JanelaTemperatura.temperaturaPOP.getValue().toString());
            tempoUsuario = Integer.valueOf(JanelaTemperatura.tempoPOP.getValue().toString());
            limite = tempoUsuario/3;
            temperaturaAtual = getTempRackPOP();
            if(temperaturaAtual>=temperaturaUsuario && JanelaTemperatura.isON_POP.isSelected()){
                //vai comecar a contar o tempo e mostrar o aviso
                JanelaAlerta.NomeEstacao.setText("Estacao PoP");
                JanelaAlerta.Temperatura.setText(String.valueOf(temperaturaAtual));
                contadorInterno++;
                //tem q chamar a tread de atualizacao da barra de progresso
                JanelaAlerta.setVisible(true);
                //System.out.println("temp maior...");
               if(noThread) {
                    new Thread(new AtualizaBarraAlerta(tempoUsuario)).start();
                    noThread = false;
                }
            }
            //System.out.println("ta executando...");
            //checa se a tela esta on e a temperatura caiu
            if(getTempRackPOP()<temperaturaUsuario && JanelaAlerta.isVisible()){
                 //alarme temporario
                 JanelaAlerta.setVisible(false);
            }
                
            //checagem de estouro de tempo
            if(contadorInterno >= limite && JanelaAlerta.isVisible() ){
                try {
                    //tem q ligar o ar condicionado
                    if(getArPOP()==0) ArduinoSNMP.LigaAr(IP, porta);
                    //System.out.println("vai ligar...");

                    terminate(); 
                } catch (IOException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                    JanelaMonitoramento.mostrarErro("Erro ao na thread checkTempRackPoP!\n"
                        + "Exceção: "+ex);
                }

            }
            //tempo de checagem
            try{
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    class ThreadCheckTempRackTVU implements Runnable{
    private String IP;
    private int porta;
    int contadorInterno=0;
    int temperaturaUsuario;
    float temperaturaAtual;
    int tempoUsuario;
    int limite;
    boolean noThread = true;
    private int[] arrayEstados2 = new int[2];
    private volatile boolean running = true;
    //construtor vai passar o IP e Porta para cada estacao
    public ThreadCheckTempRackTVU(int porta, String IP) {
      this.porta = porta;
      this.IP = IP;
    }
    public void terminate() {
        running = false;
    }
    @Override
    public void run(){
        while(running){
            temperaturaUsuario = Integer.valueOf(JanelaTemperatura.temperaturaTVU.getValue().toString());
            tempoUsuario = Integer.valueOf(JanelaTemperatura.tempoTVU.getValue().toString());
            limite = tempoUsuario/3;
            temperaturaAtual = getTempRackTVU();
            if(temperaturaAtual>=temperaturaUsuario && JanelaTemperatura.isON_TVU.isSelected()){
                //vai comecar a contar o tempo e mostrar o aviso
                JanelaAlerta.NomeEstacao.setText("Estacao TVU");
                JanelaAlerta.Temperatura.setText(String.valueOf(temperaturaAtual));
                contadorInterno++;
                //tem q chamar a tread de atualizacao da barra de progresso
                JanelaAlerta.setVisible(true);
                if(noThread) {
                    new Thread(new AtualizaBarraAlerta(tempoUsuario)).start();
                    noThread = false;
                } 
            }
            //checa se a tela esta on e a temperatura caiu
            if(getTempRackTVU()<temperaturaUsuario && JanelaAlerta.isVisible()){
                 //alarme temporario
                 JanelaAlerta.setVisible(false);
            }
                
            //checagem de estouro de tempo
            if(contadorInterno >= limite && JanelaAlerta.isVisible() ){
                try {
                    //tem q ligar o ar condicionado
                    if(getArTVU()==0) ArduinoSNMP.LigaAr(IP, porta);

                    terminate(); 
                } catch (IOException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                    JanelaMonitoramento.mostrarErro("Erro ao na thread checkTempRackPoP!\n"
                        + "Exceção: "+ex);
                }

            }
            //tempo de checagem
            try{
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    }
    //-------------ATUALIZA A BARRA DE TEMPO DA JANELA DE ALERTA
    public class AtualizaBarraAlerta implements Runnable {

    private volatile boolean running = true;
       private int to, barra;
    public AtualizaBarraAlerta(int to) {
          this.to = to;//eh o valor q passa para dormir
      }
    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        int n=0;
        int k = (int) ceil((double)100/to);
        float k2 = (float)100/to;
        int dormir;
            if(k2<1){
                 dormir =(int) ceil((double)100/k2);
            }
            else{
                dormir = 1000;
            }
        while (running) {
            while (n <= 100){


                 JanelaAlerta.BarraProgresso.setValue(n);

                try {
                    Thread.sleep(dormir);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                    JanelaMonitoramento.mostrarErro("Erro na atualização da barra de alerta!\n"
                            + "Exceção: "+ex);

                }
                n+=k;
            }
            terminate();
        }

    }
}
    //------------------------------------
    
    
    
    class ExecutaThreadTempTVU implements Runnable{
        private String IP;
        private int porta;
        private int[] arrayEstados2 = new int[2];
        private volatile boolean running = true;
        //construtor
        public ExecutaThreadTempTVU(int porta, String IP) {
          this.porta = porta;
          this.IP = IP;
        }
        public void terminate() {
            running = false;
        }
        @Override
        public void run(){
            while(running){
                try {
                    //              try {
                    setTempRackTVU(pegarSensor1(IP, porta));
                    setTempPlacaTVU(pegarSensor2(IP, porta));
                    setHumidadeTVU(pegarHumidade(IP, porta));
                    arrayEstados2 = pegarSaidas(IP,porta);
                    setEstadosSaidasTVU(getNomeEstacao(IP), arrayEstados2[0], arrayEstados2[1]);
                    //setTempPlacaTVU(pegarSensor2TVU(IP_TVU,Porta_TVU));
                } catch (IOException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                    JanelaMonitoramento.mostrarErro("Erro ao se conectar com "+IP+ "na porta "+porta+" !\n"
                        + "Exceção: "+ex);
                }
                try{
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public float pegarSensor1(String IP, int Porta) throws IOException{
        float retorno = 0;
        String auxiliar;
        try{
            auxiliar = ArduinoSNMP.getTemp1(IP, Porta);
            if (!auxiliar.isEmpty()) retorno = Float.parseFloat(auxiliar);
        }catch (IOException ex) {
            Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("EXCECAO DE PEGAR SENSOR 1");
            JanelaMonitoramento.mostrarErro("Erro ao na função pegarSensor1 IP "+IP);
        }
        return retorno;
    }
    public float pegarSensor2(String IP, int Porta) throws IOException{
        float retorno = 0;
        String auxiliar;
        try{
        auxiliar = ArduinoSNMP.getTemp2(IP, Porta);
        if (!auxiliar.isEmpty()) retorno = Float.parseFloat(auxiliar);
        }catch (IOException ex) {
            Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("EXCECAO DE PEGAR SENSOR 2");
            JanelaMonitoramento.mostrarErro("Erro ao na função pegarSensor2 IP "+IP);
        }
        return retorno;
    }   
    public float pegarHumidade(String IP, int Porta) throws IOException{
        float retorno = 0;
        String auxiliar;
        try{
        auxiliar = ArduinoSNMP.getHumidade(IP, Porta);
        if (!auxiliar.isEmpty()) retorno = Float.parseFloat(auxiliar);
        }catch (IOException ex) {
            Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("EXCECAO DE PEGAR HUMIDADE");
            JanelaMonitoramento.mostrarErro("Erro ao na função pegarHumidade IP "+IP);
        }
        return retorno;
    }
    public int[] pegarSaidas(String IP, int Porta) throws IOException{
        int[] arrayEstados = new int[2];//0-porta     and    1-ar
        String auxiliar="";
        try{
            auxiliar = ArduinoSNMP.getSaidas(IP, Porta);
            if(!auxiliar.isEmpty()){
            String[] parts = auxiliar.split("\\|");
            String _porta = parts[1];
            String _ar = parts[0];
            _porta = _porta.replace("PORTA", "");
            _ar = _ar.replace("AR", "");
            if (!_porta.isEmpty()) arrayEstados[0] = Integer.parseInt(_porta.trim());
            if (!_ar.isEmpty()) arrayEstados[1] = Integer.parseInt(_ar.trim());
            }
        }catch (IOException ex) {
            Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
            JanelaMonitoramento.mostrarErro("Erro ao na separação da String retorno IP "+IP);
        }
        return arrayEstados;
    }
    
    class atualizarGraficos implements Runnable{
        //@Override
        public void run(){
            while(true){
                try{
                    //createChart();
                    JanelaMonitoramento.PainelGrafico.repaint();
                    JanelaGraficos.getContentPane().repaint();
                    if(POP){
                        JanelaMonitoramento.barraEstacaoMain.setValue((int) getTempRackPOP());
                        JanelaMonitoramento.barraEstacaoMain.setString(getTempRackPOP() + "°C");
                    }
                    if(TVU){
                        JanelaMonitoramento.barraEstacaoTVU.setValue((int) getTempRackTVU());
                        JanelaMonitoramento.barraEstacaoTVU.setString(getTempRackTVU() + "°C");
                    }      
                    Thread.sleep(3000);
                } catch (Exception e){
                    System.out.println("Erro na thread de atualizar gráficos.");
                    JanelaMonitoramento.mostrarErro("Erro na atualização dos gráficos!\n"
                            + "Exceção: "+e);

                }
            }
        }
    }
    
    
    //atualiza a barra da tela de controle
    public class AtualizaBarraControle implements Runnable {

    private volatile boolean running = true;
       private int to, barra;
    public AtualizaBarraControle(int to) {
          this.to = to;
      }
    public void terminate() {
        running = false;
    }

    @Override
    public void run() {
        int n=0;
        int k = (int) ceil((double)100/to);
        float k2 = (float)100/to;
        int dormir;
            if(k2<1){
                 dormir =(int) ceil((double)100/k2);
            }
            else{
                dormir = 100;
            }
        while (running) {
            while (n <= 100){

                        JanelaControle.barraProgresso.setValue(n);

                try {
                    Thread.sleep(dormir);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DataCenterControl.class.getName()).log(Level.SEVERE, null, ex);
                    JanelaMonitoramento.mostrarErro("Erro na atualização da barra de controle!\n"
                            + "Exceção: "+ex);

                }
                n+=k;
            }
            terminate();
        }

    }
}

 //---------------FUNCOES DE PEGAR 
    
    public void setTempPlacaPOP(float valor){
        double d;
        //DecimalFormat twoDForm = new DecimalFormat("#.#");
        //d = Double.valueOf(twoDForm.format(valor));  
        d = Math.round(valor * 2) / 2.0f;
        this.temperaturaPlacaPOP = (float) d;
        this.temperatura_placa_seriePOP.add(System.currentTimeMillis(), (float) d);

    }
        
    public void setTempPlacaTVU(float valor){
        double d;
        //DecimalFormat twoDForm = new DecimalFormat("#.#");
        //d = Double.valueOf(twoDForm.format(valor));  
        d = Math.round(valor * 2) / 2.0f;
        this.temperaturaPlacaTVU = (float) d;
        this.temperatura_placa_serieTVU.add(System.currentTimeMillis(), (float) d);

    }
    //todos os geters and seters
    public int getArPOP(){
        return this.estado_arPOP;
    }
    public int getArTVU(){
        return this.estado_arTVU;
    }
    public float getTempPlacaPOP(){
        return this.temperaturaPlacaPOP;
    }
    public float getTempRackPOP(){
        return this.temperaturaSensorPOP;
    }
    public float getTempPlacaTVU(){
        return this.temperaturaPlacaTVU;
    }
    public float getTempRackTVU(){
        return this.temperaturaSensorTVU;
    }
    
    public void setTempRackPOP(float valor){
        if(valor >0) {
            this.temperaturaSensorPOP = valor;
            this.temperatura_sensor_seriePOP.add(System.currentTimeMillis(), valor);
        }
    }
    public void setTempRackTVU(float valor){
        if(valor > 0) {
            this.temperaturaSensorTVU = valor;
            this.temperatura_sensor_serieTVU.add(System.currentTimeMillis(), valor);
        }
    }
    public void setHumidadePOP(float valor){
        if(valor > 0) {
            this.dht11HumidadePOP = valor;
            this.humiadde_dht_seriePOP.add(System.currentTimeMillis(), valor);
        }
    }
    public void setHumidadeTVU(float valor){
        if(valor > 0) {
            this.dht11HumidadeTVU = valor;
            this.humiadde_dht_serieTVU.add(System.currentTimeMillis(), valor);
        }
    }
    public void setEstadosSaidasPOP(String Estacao, int valor_porta,int valor_ar){
        int indice;
        indice = returnRowIndexForValue("Estação PoP");
        if(!login){
            this.login=true;
            if(valor_ar ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Ligado", indice, 2);
            if(valor_ar ==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Desligado", indice, 2);
            if(valor_porta ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Aberta", indice, 1);
            if(valor_porta==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Fechada", indice, 1);
        }
        if(this.estado_arPOP != valor_ar){
            this.estado_arPOP = valor_ar;
            if(valor_ar ==1 ) {
                JanelaMonitoramento.mostrarAviso("Ar Condicionado Ligado!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Ar Condicionado "+Estacao+" Ligado!\n");
                if(valor_ar ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Ligado", indice, 2);
            }
            if(valor_ar ==0 ) {
                JanelaMonitoramento.mostrarAviso("Ar Condicionado Desligado!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Ar Condicionado "+Estacao+" Desligado!\n");
                if(valor_ar ==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Desligado", indice, 2);

            }
        }
        if(this.estado_portaPOP != valor_porta){
            this.estado_portaPOP = valor_porta;
            if(valor_porta ==1 ) {
                JanelaMonitoramento.mostrarAviso("Porta Aberta!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Porta "+Estacao+" Aberta!\n");
                if(valor_porta ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Aberta", indice, 1);
            }
            if(valor_porta ==0 ) {
                JanelaMonitoramento.mostrarAviso("Porta Fechada!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Porta "+Estacao+" Fechada!\n");
                if(valor_porta==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Fechada", indice, 1);
            }
        }
        this.estado_ar_seriePOP.add(System.currentTimeMillis(), valor_ar);
        this.estado_porta_seriePOP.add(System.currentTimeMillis(), valor_porta);
    }
    public void setEstadosSaidasTVU(String Estacao, int valor_porta, int valor_ar){
        int indice;
        indice = returnRowIndexForValue("Estação TVU");
        if(!login){
            this.login=true;
            if(valor_ar ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Ligado", indice, 2);
            if(valor_ar ==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Desligado", indice, 2);
            if(valor_porta ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Aberta", indice, 1);
            if(valor_porta==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Fechada", indice, 1);
        }

        if(this.estado_arTVU != valor_ar){
            this.estado_arTVU = valor_ar;
            if(valor_ar ==1 ) {
                JanelaMonitoramento.mostrarAviso("Ar Condicionado Ligado!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Ar Condicionado "+Estacao+" Ligado!\n");
                if(valor_ar ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Ligado", indice, 2);


            }
            if(valor_ar ==0 ) {
                JanelaMonitoramento.mostrarAviso("Ar Condicionado Desligado!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Ar Condicionado "+Estacao+" Desligado!\n");
                if(valor_ar ==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Desligado", indice, 2);

            }
        }
        if(this.estado_portaTVU != valor_porta){
            this.estado_portaTVU = valor_porta;
            if(valor_porta ==1 ) {
                JanelaMonitoramento.mostrarAviso("Porta Aberta!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Porta "+Estacao+" Aberta!\n");
                if(valor_porta ==1) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Aberta", indice, 1);

            }
            if(valor_porta ==0 ) {
                JanelaMonitoramento.mostrarAviso("Porta Fechada!\n"+Estacao);
                JanelaMonitoramento.Alarmes.append("Porta "+Estacao+" Fechada!\n");
                if(valor_porta==0) JanelaMonitoramento.TabelaMonitoramento.setValueAt("Fechada", indice, 1);

            }
        }
        this.estado_ar_serieTVU.add(System.currentTimeMillis(), valor_ar);
        this.estado_porta_serieTVU.add(System.currentTimeMillis(), valor_porta);

    }
    
 
    
    public String getNomeEstacao(String IP){
        return ListaEstacoes.getNomeEstacao(IP);
    }
    
    
    
    private void createChart() {

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "",
            "Tempo", 
            "Temperatura (°C)",
            createDataset(),
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(false);
        
        final XYItemRenderer renderer = plot.getRenderer();
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setShapesFilled(true);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
           }
        
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
        axis.setFixedAutoRange(1000000);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chart.setBackgroundPaint(Color.getHSBColor(0, 0, (float) 0.9333));//seta a cor do grafico
         JanelaMonitoramento.PainelGrafico.setLayout(null);
         JanelaMonitoramento.PainelGrafico.removeAll();
         JanelaMonitoramento.PainelGrafico.add(chartPanel);
         chartPanel.setBounds(JanelaMonitoramento.PainelGrafico.getVisibleRect());     
    }
    
    private void createChartTempGraphWindow() {

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Sensores de Temperatura",
            "Tempo", 
            "Temperatura (°C)",
            createDataset(),
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(false);
        
        final XYItemRenderer renderer = plot.getRenderer();
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setShapesFilled(true);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
           }
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
        axis.setFixedAutoRange(1000000);
        final ChartPanel chartPanel = new ChartPanel(chart);
         //COLOCA NA JANELA DOS GRAFICOS
        
        if(!isCreated){
            tabs.addTab("Temperatura", chartPanel);
            isCreated = true;
        } 
        if(isCreated) {
            tabs.remove(3);
            tabs.addTab("Temperatura", chartPanel);
        }
    }
    //para achar o valor da tabela
    private int returnRowIndexForValue(final String value) { 
        int retorno=1;
      for (int i = 0; i < JanelaMonitoramento.TabelaMonitoramento.getRowCount(); i++){
                if (JanelaMonitoramento.TabelaMonitoramento.getValueAt(i, 0).equals(value)){
                     retorno = i;
//                     System.out.println("retorno = "+retorno);
//                     System.out.println("row: "+i);       
                }
           }
      return retorno;
    }
    
    private void createChartHumidade() {

        

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Sensores de Humidade",
            "Tempo", 
            "Humidade (%)",
            createDatasetHumidade(),
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(false);
        
        final XYItemRenderer renderer = plot.getRenderer();
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setShapesFilled(true);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
           }
        
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        final ValueAxis axisY = plot.getRangeAxis();
        axisY.setRange(0.0,100.0);

        axis.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
        axis.setFixedAutoRange(1000000);
        final ChartPanel chartPanel = new ChartPanel(chart);
        tabs.addTab("Humidade", chartPanel);
    }
    private void createChartPorta(){
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Estado das Portas dos Racks",
            "Tempo", 
            "Estado (1-Aberta | 0-Fechada)",
            createDatasetPorta(),
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(false);
        
        final XYItemRenderer renderer = plot.getRenderer();
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setShapesFilled(true);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
           }
        
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        final ValueAxis axisY = plot.getRangeAxis();
        axisY.setRange(-0.03,1.03);
        axis.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
        axis.setFixedAutoRange(1000000);
        final ChartPanel chartPanel = new ChartPanel(chart);
        tabs.addTab("Porta Rack", chartPanel);      
    }
    private void createChartAr(){
        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Estado dos Ar Condicionados",
            "Tempo", 
            "Estado (1-Ligado | 0-Desligado)",
            createDatasetAr(),
            true,
            true,
            false
        );

        chart.setBackgroundPaint(Color.white);
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(false);
        
        final XYItemRenderer renderer = plot.getRenderer();
        if (renderer instanceof StandardXYItemRenderer) {
            final StandardXYItemRenderer rr = (StandardXYItemRenderer) renderer;
            rr.setShapesFilled(true);
            renderer.setSeriesStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesStroke(1, new BasicStroke(2.0f));
           }
        
        final DateAxis axis = (DateAxis) plot.getDomainAxis();
        final ValueAxis axisY = plot.getRangeAxis();
        axisY.setRange(-0.03,1.03);
        axis.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
        axis.setFixedAutoRange(1000000);
        final ChartPanel chartPanel = new ChartPanel(chart);
        tabs.addTab("Ar Condicionado", chartPanel);      
    }
    private XYDataset createDatasetHumidade() {   
        final XYSeriesCollection dataset3 = new XYSeriesCollection( );          
        if(POP) dataset3.addSeries(this.humiadde_dht_seriePOP);
        if(TVU) dataset3.addSeries(this.humiadde_dht_serieTVU);
        return dataset3;
    } 
    private XYDataset createDatasetPorta() {   
        final XYSeriesCollection dataset4 = new XYSeriesCollection( );          
        if(POP) dataset4.addSeries(this.estado_porta_seriePOP);
        if(TVU) dataset4.addSeries(this.estado_porta_serieTVU);
        return dataset4;
    }
    private XYDataset createDatasetAr() {   
        final XYSeriesCollection dataset5 = new XYSeriesCollection( );          
        if(POP) dataset5.addSeries(this.estado_ar_seriePOP);
        if(TVU) dataset5.addSeries(this.estado_ar_serieTVU);
        return dataset5;
    }
    
    private XYDataset createDataset() {

        
//        final XYSeries placa_ = new XYSeries( "Placa" ); 
//        placa_.add(System.currentTimeMillis() , this.temperaturaPlacaPOP);  
        
        final XYSeriesCollection dataset2 = new XYSeriesCollection( );          
        if(POP){
            if(this.isSensorEquipamento) dataset2.addSeries(this.temperatura_placa_seriePOP);
            if(this.isSensorExterno) dataset2.addSeries(this.temperatura_sensor_seriePOP);
        }
        if(TVU){
            if(this.isSensorEquipamento) dataset2.addSeries(this.temperatura_placa_serieTVU);
            if(this.isSensorExterno) dataset2.addSeries(this.temperatura_sensor_serieTVU);
        }
        return dataset2;
    } 
    //===========fim
}
