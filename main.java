/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.derby.iapi.store.raw.Page;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.statistics.HistogramType;

/**
 *
 * @author PC
 */
public class main extends javax.swing.JFrame {

    ArrayList<Double> db = new ArrayList<>();
    int counter = 0;
    double mean = 0.0;
    double median = 0.0;
    double stdDeviation = 0.0;
    double variance = 0.0;
    static DefaultTableModel table = new DefaultTableModel();

    public main() {
        initComponents();
        table.setColumnIdentifiers(new Object[]{"ID", "SepalLengthCm"});
        jTable1.setModel(table);
    }
    private static final String ROW_KEY = "boxplot";

    private void BOX_plot() {
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");

            while (rs.next()) {

                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        JFrame frame = new JFrame("BOXPLOT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
        dataset.add(db, ROW_KEY, "");
        JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
                "SepalLengthCmt", ROW_KEY, "Numbers", dataset, false);
        
        frame.add(new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(350, 520);

            }
        });
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        buttonGroup1 = new javax.swing.ButtonGroup();
        b_viewdata = new javax.swing.JButton();
        b_mean = new javax.swing.JButton();
        b_median = new javax.swing.JButton();
        b_variance = new javax.swing.JButton();
        b_std = new javax.swing.JButton();
        b_shapeofdis = new javax.swing.JButton();
        b_boxplot = new javax.swing.JButton();
        b_steror = new javax.swing.JButton();
        b_histogram = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        b_exit = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextPane6 = new javax.swing.JTextPane();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTextPane7 = new javax.swing.JTextPane();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTextPane8 = new javax.swing.JTextPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTextPane9 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        b_size = new javax.swing.JButton();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextPane10 = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();

        jScrollPane2.setViewportView(jTree1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        b_viewdata.setText("VIEW DATA");
        b_viewdata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_viewdataActionPerformed(evt);
            }
        });

        b_mean.setText("MEAN");
        b_mean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_meanActionPerformed(evt);
            }
        });

        b_median.setText("MEDIAN");
        b_median.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_medianActionPerformed(evt);
            }
        });

        b_variance.setText("VARIANCE");
        b_variance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_varianceActionPerformed(evt);
            }
        });

        b_std.setText("STANDART DEVİATİON");
        b_std.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_stdActionPerformed(evt);
            }
        });

        b_shapeofdis.setText("SHAPE DISTRUBITION");
        b_shapeofdis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_shapeofdisActionPerformed(evt);
            }
        });

        b_boxplot.setText("BOXPLOT");
        b_boxplot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_boxplotActionPerformed(evt);
            }
        });

        b_steror.setText("STANDART EROR");
        b_steror.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sterorActionPerformed(evt);
            }
        });

        b_histogram.setText("HİSTOGRAM");
        b_histogram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_histogramActionPerformed(evt);
            }
        });

        jButton10.setText("CONFIDENCE INTERVAL ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("%25");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("%50");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("%75");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        b_exit.setText("EXIT");
        b_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_exitActionPerformed(evt);
            }
        });

        jLabel10.setText("QUALTİLES");

        jScrollPane4.setViewportView(jTextPane1);

        jScrollPane3.setViewportView(jTextPane2);

        jScrollPane5.setViewportView(jTextPane3);

        jScrollPane6.setViewportView(jTextPane4);

        jScrollPane7.setViewportView(jTextPane5);

        jScrollPane8.setViewportView(jTextPane6);

        jScrollPane9.setViewportView(jTextPane7);

        jScrollPane10.setViewportView(jTextPane8);

        jScrollPane11.setViewportView(jTextPane9);

        jLabel3.setText("            ");

        b_size.setText("HOW LARGE SAMPLE SHOUL BE TAKE?");
        b_size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_sizeActionPerformed(evt);
            }
        });

        jScrollPane12.setViewportView(jTextPane10);

        jButton1.setText("FORM");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(b_mean, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b_shapeofdis, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(b_variance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b_histogram, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(84, 84, 84))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(95, 95, 95))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton2)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_size, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                        .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(b_steror, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(b_median, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(b_std, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane6))
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b_boxplot, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                .addGap(104, 104, 104)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(b_viewdata, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_mean, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_median, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(jScrollPane3))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_shapeofdis, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_std, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(b_variance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_steror, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(b_histogram, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(b_boxplot, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRadioButton2))
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jRadioButton3)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(b_size, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(b_viewdata, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addComponent(b_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_viewdataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_viewdataActionPerformed
        //ORDER THE VALUES FROM SMALLEST TO LARGEST  ON TABLE
        int i = 0;
        if (counter == 0) {
            try {
                Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
                java.sql.Statement st = con.createStatement();
                String sql = ("SELECT * FROM  IRIS order by SepalLengthCm ASC");

                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    double SepalLengthCm = rs.getDouble("SepalLengthCm");
                    i = i + 1;
                    table.addRow(new Object[]{i, SepalLengthCm});
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            counter++;
        }
    }//GEN-LAST:event_b_viewdataActionPerformed

    private void b_meanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_meanActionPerformed
        //MEAN
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {
                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        Arrays.toString(sArr);
        
        double sum = 0;
        for (int i = 0; i < sArr.length; i++) {
            sum = sum + sArr[i];
        }
        mean = sum / size;
        jTextPane1.setText(String.valueOf(mean));
        System.out.println("MEAN = " + mean);
    }//GEN-LAST:event_b_meanActionPerformed

    private void b_medianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_medianActionPerformed
        // MEDIAN HESABI
        
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {
                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        Arrays.sort(sArr);
        
        if (size % 2 == 0) {
            median = ((double) sArr[size / 2] + (double) sArr[size / 2 - 1]) / 2;
        } else if (size % 2 == 1) {
            median = (double) sArr[size / 2];
        }
        jTextPane2.setText(String.valueOf(median));
        System.out.println("MEDİAN = " + median);
        
    }//GEN-LAST:event_b_medianActionPerformed

    private void b_varianceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_varianceActionPerformed
//VARIANCE HESABI
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {
                if (db.size() <= 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        double sum = 0;
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        Arrays.sort(sArr);
        if (mean == 0.0) {
            for (int i = 0; i < sArr.length; i++) {
                sum = sum + sArr[i];
            }
            mean = sum / size;
        }
        double k = 0.0;
        for (int i = 0; i < size; i++) {
            k += Math.pow(sArr[i] - mean, 2);
        }
        variance = k / size;
        System.out.println("VARIANCE= " + variance);
        jTextPane5.setText(String.valueOf(variance));
    }//GEN-LAST:event_b_varianceActionPerformed

    private void b_stdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_stdActionPerformed
//STANDARD DAVITION 
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {
                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        if (stdDeviation == 0) {
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum = sum + sArr[i];
            }
            mean = sum / size;
            for (int i = 0; i < size; i++) {
                sArr[i] = db.get(i);
            }
            double k = 0.0;
            for (int i = 0; i < size; i++) {
                k += Math.pow(sArr[i] - mean, 2);
            }
            stdDeviation = Math.sqrt(k / size);
        }
        jTextPane4.setText(String.valueOf(stdDeviation));
        System.out.println("STANDART DAVIATION = " + stdDeviation);
    }//GEN-LAST:event_b_stdActionPerformed

    private void b_shapeofdisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_shapeofdisActionPerformed
        //SHAPE OF DISTRIBUTION 
        if (mean == 0 || median == 0) {
            JOptionPane.showMessageDialog(null, "Firstly,you have to calculate mean and median to find shape of distribution");
        } else {
            if (mean == median) {
                jTextPane3.setText("SYMMETRIC DISTRIBUTION");
                System.out.println("SYMMETRIC DISTRIBUTION");
            } else if (mean > median) {
                jTextPane3.setText("RIGHT-SKEWED DISTRIBUTION");
                System.out.println("RIGHT-SKEWED DISTRIBUTION");

            } else if (mean < median) {
                jTextPane3.setText("LEFT-SKEWED DISTRIBUTION");
                System.out.println("LEFT-SKEWED DISTRIBUTION");
            }
        }
    }//GEN-LAST:event_b_shapeofdisActionPerformed

    private void b_boxplotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_boxplotActionPerformed
        //QUALTİLS(Q1,Q2,Q3), MAX,MİN IQR , LİMİTS, 
        ArrayList<Double> qualtines = new ArrayList<>();
        double q1, q2, q3 = 0.0;
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {
                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        for (int i = 1; i <= 3; i++) {
            int size1 = sArr.length + 1;
            double q;
            double sizex = (size1 * ((double) (i) * 25 / 100)) - 1;
            Arrays.sort(sArr);
            if (sizex % 2 == 1) {
                q = sArr[(int) (sizex)];
            } else {
                int sizey = (int) (sizex);
                q = (sArr[sizey] + sArr[sizey + 1]) / 2;
            }
            qualtines.add(q);
        }
        int size5 = qualtines.size();
        double[] s = new double[size5];
        for (int i = 0; i < size5; i++) {
            s[i] = qualtines.get(i);
        }
        q1 = s[0];
        q2 = s[1];
        q3 = s[2];
        Arrays.sort(sArr);
        int a = sArr.length;
        double minData = sArr[0];
        double maxData = sArr[a - 1];
        double IQR = q3 - q1;
        double altsinir = q1 - ((1.5) * (IQR));
        double ustsinir = q3 + ((1.5) * (IQR));
        System.out.println("altsinir=" + altsinir + "üstsınır" + ustsinir);
        int syac = 0;
        for (int i = 0; i < a; i++) {
            if (sArr[i] < altsinir || sArr[i] > ustsinir) {
                System.out.println("outliers: " + sArr[i]);
                syac++;
            }
        }
        if (syac == 0) {
            System.out.println("there is no outliers ");
        }
        System.out.println("q1: " + q1);
        System.out.println("q2: " + q1);
        System.out.println("q3: " + q1);
        System.out.println("IQR : " + IQR);
        System.out.println("Sınırlar : [" + altsinir + "," + ustsinir + "]");
        System.out.println("MaxData = " + maxData);
        System.out.println("MinData = " + minData);
        jTextPane7.setText(String.valueOf("IQR : " + IQR));
        jTextPane8.setText(String.valueOf("[" + altsinir + "," + ustsinir + "]"));
        jTextPane9.setText(String.valueOf("MaxData = " + maxData + "MinData = " + minData));
    }//GEN-LAST:event_b_boxplotActionPerformed

    private void b_sterorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sterorActionPerformed
        //STANDART EROR 
        if (stdDeviation == 0.0) {
            try {
                Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
                Statement st = cnn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM IRIS");
                while (rs.next()) {
                    if (db.size() < 150) {
                        db.add(rs.getDouble("SepalLengthCm"));
                    }
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            int size = db.size();
            double[] sArr = new double[size];
            for (int i = 0; i < size; i++) {
                sArr[i] = db.get(i);
            }
            Arrays.sort(sArr);
            if (stdDeviation == 0) {
                double total = 0;
                for (int i = 0; i < sArr.length; i++) {
                    total = total + sArr[i];
                }
                mean = total / size;
                for (int i = 0; i < size; i++) {
                    sArr[i] = db.get(i);
                }
                Arrays.sort(sArr);
                double c = 0.0;
                for (int i = 0; i < size; i++) {
                    c += (sArr[i] - mean) * (sArr[i] - mean);
                }
                stdDeviation = Math.sqrt(c / size);
            }
        }
        double size = db.size();
        double sizesqr = Math.sqrt(size);
        double SE = stdDeviation / sizesqr;
        jTextPane6.setText(String.valueOf(SE));
        System.out.println("STANDART EROR =" + SE);
    }//GEN-LAST:event_b_sterorActionPerformed

    private void b_histogramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_histogramActionPerformed
        try { //HİSTOGRAM
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {
                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        int bin = (int) ((Math.log(size) / Math.log(2)) + 1);
        HistogramDataset dataset = new HistogramDataset();
        dataset.setType(HistogramType.FREQUENCY);
        dataset.addSeries("Histogram", sArr, bin);
        String plotTitle = "Histogram of SepalLengthCm";
        String xeks = "SepalLengthCm's Value";
        String yeks = "Number of How many value";
        PlotOrientation orientation = PlotOrientation.VERTICAL;
        boolean show, urls = false;
        boolean toolTips = true;
        int width, height = 200;
        JFreeChart chart = ChartFactory.createHistogram(plotTitle, xeks, yeks, dataset, orientation, true, true, urls);
        XYPlot plot = chart.getXYPlot();
        plot.getRenderer().setSeriesPaint(0, new Color(50, 128, 24));
        plot.setRangeCrosshairPaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);
        ChartFrame chartfrm = new ChartFrame(" ", chart, true);
        chartfrm.setVisible(true);
        chartfrm.setSize(750, 600);
    }//GEN-LAST:event_b_histogramActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        ArrayList<Double> qualtines = new ArrayList<>();
        double q1 = 0.0;
        double q2 = 0.0;
        double q3 = 0.0;
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");

            while (rs.next()) {

                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }

        for (int i = 1; i <= 3; i++) {
            float size1 = sArr.length + 1;
            double q;
            double sizex = (size1 * ((double) (i) * 25 / 100)) - 1;
            Arrays.sort(sArr);
            if (sizex % 2 == 1) {
                q = sArr[(int) (sizex)];
            } else {
                int sizey = (int) (sizex);
                q = (sArr[sizey] + sArr[sizey + 1]) / 2;
            }
            qualtines.add(q);
        }
        int size5 = qualtines.size();
        double[] s = new double[size5];
        for (int i = 0; i < size5; i++) {
            s[i] = qualtines.get(i);
        }
        for (int i = 0; i < s.length; i++) {

            System.out.println(s[i]);
        }

        jLabel4.setText(String.valueOf(s[0]));


    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        ArrayList<Double> qualtines = new ArrayList<>();
        double q1 = 0.0;
        double q2 = 0.0;
        double q3 = 0.0;

        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");

            while (rs.next()) {

                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }

        for (int i = 1; i <= 3; i++) {
            float size1 = sArr.length + 1;
            double q;
            double sizex = (size1 * ((double) (i) * 25 / 100)) - 1;
            Arrays.sort(sArr);
            if (sizex % 2 == 1) {
                q = sArr[(int) (sizex)];
            } else {
                int sizey = (int) (sizex);
                q = (sArr[sizey] + sArr[sizey + 1]) / 2;
            }

            qualtines.add(q);
        }
        int size5 = qualtines.size();
        double[] s = new double[size5];
        for (int i = 0; i < size5; i++) {
            s[i] = qualtines.get(i);
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        jLabel3.setText(String.valueOf(s[2]));


    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed

        ArrayList<Double> qualtines = new ArrayList<>();
        double q1 = 0.0;
        double q2 = 0.0;
        double q3 = 0.0;
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {

                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }

        for (int i = 1; i <= 3; i++) {
            float size1 = sArr.length + 1;
            double q;
            double sizex = (size1 * ((double) (i) * 25 / 100)) - 1;
            Arrays.sort(sArr);
            if (sizex % 2 == 1) {
                q = sArr[(int) (sizex)];
            } else {
                int sizey = (int) (sizex);
                q = (sArr[sizey] + sArr[sizey + 1]) / 2;
            }

            qualtines.add(q);
        }
        int size5 = qualtines.size();
        double[] s = new double[size5];
        for (int i = 0; i < size5; i++) {
            s[i] = qualtines.get(i);
        }
        for (int i = 0; i < s.length; i++) {
            System.out.println(s[i]);
        }

        jLabel1.setText(String.valueOf(s[1]));


    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new cv().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void b_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_exitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_b_exitActionPerformed

    private void b_sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_sizeActionPerformed
        //How large size unit 0.1
        double std = 0.0, meann = 0.0;
        try {
            Connection cnn = DriverManager.getConnection("jdbc:derby://localhost:1527/MERVE", "MERVE", "123");
            Statement stmt = cnn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM IRIS");
            while (rs.next()) {
                if (db.size() < 150) {
                    db.add(rs.getDouble("SepalLengthCm"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        int size = db.size();
        double[] sArr = new double[size];
        for (int i = 0; i < size; i++) {
            sArr[i] = db.get(i);
        }
        if (std == 0) {
            double sum = 0;
            for (int i = 0; i < size; i++) {
                sum = sum + sArr[i];
            }
            meann = sum / size;
            for (int i = 0; i < size; i++) {
                sArr[i] = db.get(i);
            }
            double k = 0.0;
            for (int i = 0; i < size; i++) {
                k += Math.pow(sArr[i] - meann, 2);
            }
            std = Math.sqrt(k / size);
        }
        System.out.println("STANDART DAVIATION = " + std);
        double EROR = 0.1;
        double Zdis = 1.645;
        int x = (int) (Math.pow(((Zdis * std) / EROR), 2));
        int a = x + 1;
        System.out.println("size=" + a);
        jTextPane10.setText(String.valueOf("it should be minimum = " + a));
    }//GEN-LAST:event_b_sizeActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        EventQueue.invokeLater(new main()::BOX_plot);


    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_boxplot;
    private javax.swing.JButton b_exit;
    private javax.swing.JButton b_histogram;
    private javax.swing.JButton b_mean;
    private javax.swing.JButton b_median;
    private javax.swing.JButton b_shapeofdis;
    private javax.swing.JButton b_size;
    private javax.swing.JButton b_std;
    private javax.swing.JButton b_steror;
    private javax.swing.JButton b_variance;
    private javax.swing.JButton b_viewdata;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane10;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JTextPane jTextPane6;
    private javax.swing.JTextPane jTextPane7;
    private javax.swing.JTextPane jTextPane8;
    private javax.swing.JTextPane jTextPane9;
    private javax.swing.JTree jTree1;
    // End of variables declaration//GEN-END:variables
}
