/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hyperlink.integrity.checker;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hussein
 */
public class MainFrame extends javax.swing.JFrame {

    String url;
    int threshold = 0;
    int threads = 1;
    String[] tableHeaders;
    String[][] tableData;
//    String elapsedTimeOneThread;
//    String elapsedTimeTwoThreads;
//    String elapsedTimeThreeThreads;
//    String elapsedTimeFourThreads;
//    String validLinks;
//    String invalidLinks;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
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

        backgroundPanel = new javax.swing.JPanel();
        cardPanel = new javax.swing.JPanel();
        homePanel = new javax.swing.JPanel();
        javax.swing.JLabel title = new javax.swing.JLabel();
        urlLabel = new javax.swing.JLabel();
        urlTextField = new javax.swing.JTextField();
        checkButton = new javax.swing.JButton();
        errorMessageLabel = new javax.swing.JLabel();
        thresholdLabel = new javax.swing.JLabel();
        thresholdSelect = new javax.swing.JComboBox<>();
        threadsLabel = new javax.swing.JLabel();
        threadsSelect = new javax.swing.JComboBox<>();
        tablePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        viewStatsButton = new javax.swing.JButton();
        checkAgainTableButton = new javax.swing.JButton();
        loadingPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        statsPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        oneThreadLabel = new javax.swing.JLabel();
        twoThreadLabel = new javax.swing.JLabel();
        threeThreadLabel = new javax.swing.JLabel();
        fourThreadLabel = new javax.swing.JLabel();
        validLinksLabel = new javax.swing.JLabel();
        invalidLinksLabel = new javax.swing.JLabel();
        viewLinksButton = new javax.swing.JButton();
        checkAgainStatsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Link Checker");
        setResizable(false);
        setSize(new java.awt.Dimension(640, 383));

        backgroundPanel.setBackground(new java.awt.Color(245, 245, 245));

        cardPanel.setLayout(new java.awt.CardLayout());

        homePanel.setBackground(new java.awt.Color(245, 245, 245));

        title.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(38, 38, 38));
        title.setText("Hyperlink integrity checker");

        urlLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        urlLabel.setForeground(new java.awt.Color(38, 38, 38));
        urlLabel.setText("Enter a url:");

        urlTextField.setToolTipText("enter a valid url");
        urlTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                urlTextFieldKeyReleased(evt);
            }
        });

        checkButton.setFont(new java.awt.Font("Ubuntu", 1, 13)); // NOI18N
        checkButton.setText("Check");
        checkButton.setEnabled(false);
        checkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkButtonActionPerformed(evt);
            }
        });

        errorMessageLabel.setForeground(new java.awt.Color(239, 68, 68));

        thresholdLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        thresholdLabel.setForeground(new java.awt.Color(38, 38, 38));
        thresholdLabel.setText("Threshold:");

        thresholdSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));
        thresholdSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdSelectActionPerformed(evt);
            }
        });

        threadsLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        threadsLabel.setForeground(new java.awt.Color(38, 38, 38));
        threadsLabel.setText("Threads:");

        threadsSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));
        threadsSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threadsSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(title))
                    .addGroup(homePanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(urlLabel)
                            .addComponent(thresholdLabel)
                            .addComponent(threadsLabel))
                        .addGap(26, 26, 26)
                        .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(thresholdSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(urlTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(threadsSelect, 0, 474, Short.MAX_VALUE)
                            .addComponent(errorMessageLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                        .addGap(201, 201, 201)
                        .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homePanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(urlLabel)
                    .addComponent(urlTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thresholdLabel)
                    .addComponent(thresholdSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threadsLabel)
                    .addComponent(threadsSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );

        cardPanel.add(homePanel, "card2");

        tablePanel.setBackground(new java.awt.Color(245, 245, 245));
        tablePanel.setForeground(new java.awt.Color(38, 38, 38));

        table.setAutoCreateRowSorter(true);
        table.setBackground(new java.awt.Color(245, 245, 245));
        table.setModel(new javax.swing.table.DefaultTableModel(tableData,tableHeaders));
        jScrollPane1.setViewportView(table);

        viewStatsButton.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        viewStatsButton.setText("View Stats");
        viewStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewStatsButtonActionPerformed(evt);
            }
        });

        checkAgainTableButton.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        checkAgainTableButton.setText("Check again");
        checkAgainTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAgainTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(checkAgainTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(viewStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkAgainTableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        cardPanel.add(tablePanel, "card3");

        loadingPanel.setBackground(new java.awt.Color(245, 245, 245));
        loadingPanel.setForeground(new java.awt.Color(38, 38, 38));
        loadingPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                loadingPanelComponentShown(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(38, 38, 38));
        jLabel1.setText("Please wait ...");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(38, 38, 38));
        jLabel2.setText("This might take a while");

        javax.swing.GroupLayout loadingPanelLayout = new javax.swing.GroupLayout(loadingPanel);
        loadingPanel.setLayout(loadingPanelLayout);
        loadingPanelLayout.setHorizontalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPanelLayout.createSequentialGroup()
                .addGroup(loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loadingPanelLayout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel1))
                    .addGroup(loadingPanelLayout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel2)))
                .addContainerGap(270, Short.MAX_VALUE))
        );
        loadingPanelLayout.setVerticalGroup(
            loadingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadingPanelLayout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(211, Short.MAX_VALUE))
        );

        cardPanel.add(loadingPanel, "card4");

        statsPanel.setBackground(new java.awt.Color(245, 248, 248));

        jLabel3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(38, 38, 38));
        jLabel3.setText("Exec. time at 1 thread:");

        jLabel6.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(38, 38, 38));
        jLabel6.setText("Performance");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(38, 38, 38));
        jLabel4.setText("Exec. time at 4 threads:");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(38, 38, 38));
        jLabel5.setText("Exec. time at 3 threads:");

        jLabel7.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(38, 38, 38));
        jLabel7.setText("Exec. time at 2 threads:");

        jLabel8.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(38, 38, 38));
        jLabel8.setText("Number of valid links:");

        jLabel9.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(38, 38, 38));
        jLabel9.setText("Number of invalid links:");

        oneThreadLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        oneThreadLabel.setForeground(new java.awt.Color(38, 38, 38));
        oneThreadLabel.setText("0");

        twoThreadLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        twoThreadLabel.setForeground(new java.awt.Color(38, 38, 38));
        twoThreadLabel.setText("0");

        threeThreadLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        threeThreadLabel.setForeground(new java.awt.Color(38, 38, 38));
        threeThreadLabel.setText("0");

        fourThreadLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        fourThreadLabel.setForeground(new java.awt.Color(38, 38, 38));
        fourThreadLabel.setText("0\n");

        validLinksLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        validLinksLabel.setForeground(new java.awt.Color(38, 38, 38));
        validLinksLabel.setText("0\n");

        invalidLinksLabel.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        invalidLinksLabel.setForeground(new java.awt.Color(38, 38, 38));
        invalidLinksLabel.setText("0");

        viewLinksButton.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        viewLinksButton.setText("View Links");
        viewLinksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewLinksButtonActionPerformed(evt);
            }
        });

        checkAgainStatsButton.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        checkAgainStatsButton.setText("Check again");
        checkAgainStatsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAgainStatsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(checkAgainStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(viewLinksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(29, 29, 29)
                        .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oneThreadLabel)
                            .addComponent(twoThreadLabel)
                            .addComponent(threeThreadLabel)
                            .addComponent(fourThreadLabel)
                            .addComponent(validLinksLabel)
                            .addComponent(invalidLinksLabel)))
                    .addComponent(jLabel6))
                .addContainerGap(328, Short.MAX_VALUE))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(oneThreadLabel)
                        .addGap(18, 18, 18)
                        .addComponent(twoThreadLabel)
                        .addGap(18, 18, 18)
                        .addComponent(threeThreadLabel)
                        .addGap(18, 18, 18)
                        .addComponent(fourThreadLabel)
                        .addGap(18, 18, 18)
                        .addComponent(validLinksLabel)
                        .addGap(18, 18, 18)
                        .addComponent(invalidLinksLabel))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)))
                .addGap(28, 28, 28)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewLinksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkAgainStatsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );

        cardPanel.add(statsPanel, "card5");

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void urlTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlTextFieldKeyReleased
        checkUrl();
    }//GEN-LAST:event_urlTextFieldKeyReleased

    private void checkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkButtonActionPerformed
        cardPanel.removeAll();
        cardPanel.add(loadingPanel);
        repaint();
        revalidate();
    }//GEN-LAST:event_checkButtonActionPerformed

    private void loadingPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_loadingPanelComponentShown
        LinkCheckerOneThread checker1 = new LinkCheckerOneThread(url, threshold);
        String elapsedTimeOneThread = checker1.start();
        oneThreadLabel.setText(elapsedTimeOneThread);
        String validLinks = String.valueOf(checker1.getNumberOfValidLinks());
        String invalidLinks = String.valueOf(checker1.getNumberOfInvalidLinks());
        validLinksLabel.setText(validLinks);
        invalidLinksLabel.setText(invalidLinks);

        tableData = checker1.getLinksData();

        if (threads >= 2) {
            LinkCheckerTwoThreads checker2 = new LinkCheckerTwoThreads(url, threshold);
            String elapsedTimeTwoThreads = checker2.start();
            twoThreadLabel.setText(elapsedTimeTwoThreads);
        }

        if (threads >= 3) {
            LinkCheckerThreeThreads checker3 = new LinkCheckerThreeThreads(url, threshold);
            String elapsedTimeThreeThreads = checker3.start();
            threeThreadLabel.setText(elapsedTimeThreeThreads);
        }

        if (threads == 4) {
            LinkCheckerFourThreads checker4 = new LinkCheckerFourThreads(url, threshold);
            String elapsedTimeFourThreads = checker4.start();
            fourThreadLabel.setText(elapsedTimeFourThreads);
        }

        tableHeaders = Link.ArrayFields();
        table.setModel(new DefaultTableModel(tableData, tableHeaders));
        cardPanel.removeAll();
        cardPanel.add(tablePanel);
        this.setResizable(true);
        repaint();
        revalidate();
    }//GEN-LAST:event_loadingPanelComponentShown

    private void thresholdSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdSelectActionPerformed
        threshold = thresholdSelect.getSelectedIndex();
    }//GEN-LAST:event_thresholdSelectActionPerformed

    private void threadsSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threadsSelectActionPerformed
        threads = threadsSelect.getSelectedIndex() + 1;
    }//GEN-LAST:event_threadsSelectActionPerformed

    private void viewLinksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewLinksButtonActionPerformed
        cardPanel.removeAll();
        cardPanel.add(tablePanel);
        this.setResizable(true);
        repaint();
        revalidate();
    }//GEN-LAST:event_viewLinksButtonActionPerformed

    private void checkAgainStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAgainStatsButtonActionPerformed
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_checkAgainStatsButtonActionPerformed

    private void viewStatsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewStatsButtonActionPerformed
        cardPanel.removeAll();
        cardPanel.add(statsPanel);
        setSize(new java.awt.Dimension(640, 383));
        this.setResizable(false);
        repaint();
        revalidate();
    }//GEN-LAST:event_viewStatsButtonActionPerformed

    private void checkAgainTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAgainTableButtonActionPerformed
        new MainFrame().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_checkAgainTableButtonActionPerformed

    private void checkUrl() {
        url = urlTextField.getText();
        errorMessageLabel.setText("");
        checkButton.setEnabled(false);
        if (!url.isEmpty() && url.length() >= 10) { // checks when the user enters at least 10 characters
            if (Utils.isValidUrlFrontend(url)) { // checks if it is a url
                checkButton.setEnabled(true);
            } else {
                errorMessageLabel.setText("Please enter a url");
            }
        }
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JPanel cardPanel;
    private javax.swing.JButton checkAgainStatsButton;
    private javax.swing.JButton checkAgainTableButton;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel errorMessageLabel;
    private javax.swing.JLabel fourThreadLabel;
    private javax.swing.JPanel homePanel;
    private javax.swing.JLabel invalidLinksLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel loadingPanel;
    private javax.swing.JLabel oneThreadLabel;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JTable table;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JLabel threadsLabel;
    private javax.swing.JComboBox<String> threadsSelect;
    private javax.swing.JLabel threeThreadLabel;
    private javax.swing.JLabel thresholdLabel;
    private javax.swing.JComboBox<String> thresholdSelect;
    private javax.swing.JLabel twoThreadLabel;
    private javax.swing.JLabel urlLabel;
    private javax.swing.JTextField urlTextField;
    private javax.swing.JLabel validLinksLabel;
    private javax.swing.JButton viewLinksButton;
    private javax.swing.JButton viewStatsButton;
    // End of variables declaration//GEN-END:variables
}
