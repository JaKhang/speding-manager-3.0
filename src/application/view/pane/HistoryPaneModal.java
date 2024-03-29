/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package application.view.pane;

import application.controller.HistoryPaneController;
import application.model.IdGenerator;
import application.model.Spending;
import application.view.color.SystemColor;
import application.view.components.datepicker.SelectedDate;
import application.view.components.notification.ShadowRenderer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class HistoryPaneModal extends JPanel {

    private HistoryPaneController controller;
    public final static int EDIT = 0;
    public final static int ADD = 1;
    private int currentType = 1;

    /**
     * Creates new form ModalPane
     */
    public HistoryPaneModal() {
        initComponents();
        container.add(this);
//        container.setFocusableWindowState(false);
        container.setBackground(new Color(0, 0, 0, 0));
        this.setBounds(0, 0, (int) getPreferredSize().getWidth(), (int) getPreferredSize().getHeight());
        container.add(this);
        container.setSize(getPreferredSize());
        container.setLocationRelativeTo(this);

    }

    public void hide() {
        container.setVisible(false);
    }

    public void show() {
        container.setModal(true);
        container.setVisible(true);

    }

    public void setController(HistoryPaneController controller) {
        this.controller = controller;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dateChooser = new application.view.components.datepicker.DateChooser();
        container = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        submitBtn = new application.view.components.CustomButton();
        closeBtn = new application.view.components.CustomButton();
        purposeInput = new application.view.components.CustomComboBox();
        moneyInput = new application.view.components.CustomTextField();
        commentInput = new application.view.components.CustomTextArea();
        dayInput = new application.view.components.CustomTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        displayCalenderBtb = new application.view.components.CustomButton();
        addPurposeBtn = new application.view.components.CustomButton();

        dateChooser.setForeground(SystemColor.COLOR_3);
        dateChooser.setTextRefernce(dayInput);

        container.setUndecorated(true);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(380, 500));
        java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10);
        flowLayout1.setAlignOnBaseline(true);
        setLayout(flowLayout1);

        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(360, 480));

        submitBtn.setBackground(SystemColor.COLOR_3);
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Thêm");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });

        closeBtn.setBackground(new java.awt.Color(255, 255, 255));
        closeBtn.setForeground(SystemColor.COLOR_5);
        closeBtn.setText("Đóng");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        purposeInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));
        purposeInput.setEditable(true);
        purposeInput.setFont(new java.awt.Font("Oswald", 0, 18)); // NOI18N
        purposeInput.setMinimumSize(new java.awt.Dimension(12, 37));
        purposeInput.setPreferredSize(new java.awt.Dimension(128, 24));

        moneyInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));

        commentInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));
        commentInput.setColumns(20);
        commentInput.setRows(5);

        dayInput.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));

        jLabel1.setText("Chi");

        jLabel2.setText("Mục đích");

        jLabel3.setText("Ngày");

        jLabel4.setText("Chú thích");

        displayCalenderBtb.setBackground(SystemColor.COLOR_3);
        displayCalenderBtb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/view/icon/icons8_calendar_20px.png"))); // NOI18N
        displayCalenderBtb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCalenderBtbActionPerformed(evt);
            }
        });

        addPurposeBtn.setBackground(SystemColor.COLOR_3);
        addPurposeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/application/view/icon/icons8_plus_math_20px_1.png"))); // NOI18N
        addPurposeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPurposeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(dayInput, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(displayCalenderBtb, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(commentInput, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(purposeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 0, Short.MAX_VALUE)
                            .addComponent(addPurposeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(moneyInput, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(moneyInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addPurposeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(purposeInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel3)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dayInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayCalenderBtb, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(3, 3, 3)
                .addComponent(commentInput, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private BufferedImage imageShadow;
    private int shadowSize = 10;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
//        super.paintComponent(g);
    }

    private void createImageShadow() {
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(createShadow(), 0, 0, null);
        g2.dispose();
    }

    private BufferedImage createShadow() {
        BufferedImage img = new BufferedImage(getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        createImageShadow();
    }


    private void displayCalenderBtbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCalenderBtbActionPerformed
        dateChooser.showPopup();
    }//GEN-LAST:event_displayCalenderBtbActionPerformed

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        if(currentType == ADD)
            controller.addNewSpening();
        if(currentType == EDIT){
            controller.saveEdit();
        }
    }//GEN-LAST:event_submitBtnActionPerformed

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        container.setVisible(false);
        clearInput();
    }//GEN-LAST:event_closeBtnActionPerformed

    private void addPurposeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPurposeBtnActionPerformed
    }//GEN-LAST:event_addPurposeBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private application.view.components.CustomButton addPurposeBtn;
    private application.view.components.CustomButton closeBtn;
    private application.view.components.CustomTextArea commentInput;
    private javax.swing.JDialog container;
    private application.view.components.datepicker.DateChooser dateChooser;
    private application.view.components.CustomTextField dayInput;
    private application.view.components.CustomButton displayCalenderBtb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private application.view.components.CustomTextField moneyInput;
    private application.view.components.CustomComboBox purposeInput;
    private application.view.components.CustomButton submitBtn;
    // End of variables declaration//GEN-END:variables

    public Spending createSpending() {
        int money = 0;
        try {
            money = Integer.valueOf(moneyInput.getText());
        } catch (NumberFormatException e) {
            container.setVisible(false);

            return null;

        }
        if (money < 0) {
            return null;
        }
        String purpose = purposeInput.getSelectedItem().toString();
        Date date = dateChooser.getDate();
        int id = IdGenerator.generateUniqueId();
        String comment = commentInput.getText().trim();

        return new Spending(id, date, money, purpose, comment);
    }

    public void clearInput() {
        moneyInput.setText("");
        commentInput.setText("");
    }

    public void setSelectetDate(SelectedDate date) {
        dateChooser.setSelectedDate(date);
    }

    public void setTypeModal(int type) {
        if (type == HistoryPaneModal.EDIT) {
            submitBtn.setText("Lưu");
        }
        if (type == HistoryPaneModal.ADD) {
            submitBtn.setText("thêm");
        }
        currentType = type;

    }

    public void setEditMode(Spending spending) {
        moneyInput.setText(spending.getMoney() + "");
        purposeInput.setSelectedItem(spending.getPupose());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(spending.getDate());
        SelectedDate selectedDate = new SelectedDate(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
        dateChooser.setSelectedDate(selectedDate);
        commentInput.setText(spending.getComment());
    }
    
    public void setPurposeChooser(List<String> purposes){
        if(purposes ==  null)
            return;
        purposes.forEach(purpose -> purposeInput.addItem(purpose));
    }
}
