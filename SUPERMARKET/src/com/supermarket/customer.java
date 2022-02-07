package com.supermarket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class customer extends loginPage{

    private static DefaultTableModel tempModel;
    private static DefaultTableModel model = new DefaultTableModel();
    private static DefaultTableModel orderModel = new DefaultTableModel();
    private static DefaultTableModel suggModel = new DefaultTableModel();
    private static DefaultTableModel invModel = new DefaultTableModel();
    private static DefaultTableModel ordHModel = new DefaultTableModel();

        public static void main(String[] args) {

            JFrame frame = new JFrame("Customer Panel");
            frame.setSize(1100, 650);
            frame.setResizable(false);
            frame.setLocationRelativeTo(null);
            frame.setLayout(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel labelPLMSupermarket;
            labelPLMSupermarket = new JLabel("SUPERMARKET");
            labelPLMSupermarket.setBounds(300, 60, 1100 , 50);
            labelPLMSupermarket.setFont(new Font("Arial", java.awt.Font.PLAIN, 50));
            labelPLMSupermarket.setForeground(Color.white);
            frame.add(labelPLMSupermarket);

            labelPLMSupermarket = new JLabel("Welcome, USER!");
            labelPLMSupermarket.setBounds(50, 300, 1100 , 50);
            labelPLMSupermarket.setFont(new Font("Arial", java.awt.Font.BOLD, 50));
            labelPLMSupermarket.setForeground(Color.WHITE);
            frame.add(labelPLMSupermarket);

            labelPLMSupermarket = new JLabel("This is PLM SUPERMARKET");
            labelPLMSupermarket.setBounds(50, 400, 1100 , 50);
            labelPLMSupermarket.setFont(new Font("Arial", java.awt.Font.BOLD, 20));
            labelPLMSupermarket.setForeground(Color.WHITE);
            frame.add(labelPLMSupermarket);

            labelPLMSupermarket = new JLabel("Mobile Number: 091111111111");
            labelPLMSupermarket.setBounds(50, 450, 1100 , 50);
            labelPLMSupermarket.setFont(new Font("Arial", java.awt.Font.ITALIC, 20));
            labelPLMSupermarket.setForeground(Color.WHITE);
            frame.add(labelPLMSupermarket);

            JButton productButton = new JButton("PRODUCTS");
            productButton.setFont(new Font("Arial", java.awt.Font.BOLD,25));
            productButton.setBounds(70, 160, 300 , 100);
            productButton.setBackground(new Color(0x935515));
            productButton.setForeground(Color.WHITE);
            frame.add(productButton);

            JButton suggButton = new JButton("<html>SIMILAR ITEM<br>SUGGESTIONS");
            suggButton.setFont(new Font("Arial", java.awt.Font.BOLD,25));
            suggButton.setBounds(370, 160, 300 , 100);
            suggButton.setBackground(new Color(0xAB901C));
            suggButton.setForeground(Color.WHITE);
            frame.add(suggButton);

            JButton  logoutButton= new JButton("LOG OUT");
            logoutButton.setFont(new Font("Arial", java.awt.Font.BOLD,25));
            logoutButton.setBounds(670, 160, 300 , 100);
            logoutButton.setBackground(new Color(0xD78E1E));
            logoutButton.setForeground(Color.WHITE);
            frame.add(logoutButton);

            JTable orderTable = new JTable();
            JScrollPane orderSp = new JScrollPane();

            Object[] column = {"Category","Name","Price","Quantity", "Subtotal", "Stocks Left"};
            Object[] ordRow = new Object[7];
            orderModel.setColumnIdentifiers(column);
            orderTable.setModel(orderModel);
            orderSp.setViewportView(orderTable);
            orderTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            JScrollPane scroll1 = new JScrollPane();
            JScrollPane scroll2 = new JScrollPane();

            JPanel panel = new JPanel();
            panel.setBounds(0,30,1100,120);
            panel.setBackground(new Color(0xA19F03));
            frame.add(panel);

            panel = new JPanel();
            panel.setBounds(0,180,1100,390);
            panel.setBackground(new Color(0xA19F03));
            frame.add(panel);

            JTable table2 = new JTable();

            productButton.addActionListener(e -> {
                scroll1.setVisible(true);
                scroll2.setVisible(false);
                scroll1.setBounds(0, 300, 1100, 400);
                scroll1.setBorder(new EmptyBorder(15, 100, 10, 5));
                frame.add(scroll1);

                Object[] column1 = {"ID", "Category", "Name", "Brand", "Price", "Quantity", "Description"};

                if(tempModel!=null){
                    model = tempModel;
                }
                else{
                    tempModel=null;
                }

                Object[] row = new Object[7];
                model.setColumnIdentifiers(column1);
                table2.setModel(model);

                int rowNum = model.getRowCount();

                scroll1.setViewportView(table2);
                table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                JButton atcBtn = new JButton("<html><center>ADD TO<br>CART</center></html>");
                atcBtn.setFont(new Font("Arial", java.awt.Font.BOLD,11));
                atcBtn.setBounds(0, 50, 100 , 50);
                atcBtn.setBackground(new Color(0x423016));
                atcBtn.setForeground(Color.WHITE);
                scroll1.add(atcBtn);

                JButton prBtn = new JButton("<html><center>CHECK<br>OUT</center></html>");
                prBtn.setFont(new Font("Arial", java.awt.Font.BOLD,11));
                prBtn.setBounds(0, 100, 100 , 50);
                prBtn.setBackground(new Color(0x756249));
                prBtn.setForeground(Color.WHITE);
                scroll1.add(prBtn);

                atcBtn.addActionListener(actionEvent -> {
                    int selR = table2.getSelectedRow();

                    if (selR < 0) {
                        JOptionPane.showMessageDialog(null, "Select product first.");
                    } else {
                        JFrame atcFrame = new JFrame("Add to Cart");
                        atcFrame.setSize(600, 300);
                        atcFrame.setLayout(null);
                        atcFrame.setVisible(true);
                        atcFrame.setLocationRelativeTo(null);

                        JLabel qty = new JLabel("Quantity", JLabel.RIGHT);
                        qty.setText("Quantity:");
                        qty.setBounds(0, 75, 130, 30);
                        atcFrame.add(qty);

                        JTextField qtyTxt = new JTextField();
                        qtyTxt.setBounds(200, 75, 200, 30);
                        atcFrame.add(qtyTxt);

                        JButton addPd = new JButton("Add");
                        addPd.setBounds(210, 150, 150, 50);
                        addPd.setBackground(new Color(10, 120, 80));
                        addPd.setForeground(Color.WHITE);
                        atcFrame.add(addPd);

                        JButton cnPd = new JButton("Cancel");
                        cnPd.setBounds(400, 150, 150, 50);
                        cnPd.setBackground(new Color(120, 10, 10));
                        cnPd.setForeground(Color.WHITE);
                        atcFrame.add(cnPd);

                        addPd.addActionListener(actionEvent17 -> {
                            int rowNum1, itemQuan, quantity, price;
                            String cat, pName;

                            rowNum1 = table2.getSelectedRow();
                            itemQuan = Integer.parseInt(table2.getModel().getValueAt(rowNum1, 5).toString());
                            price = Integer.parseInt(table2.getModel().getValueAt(rowNum1, 4).toString());

                            cat = table2.getModel().getValueAt(rowNum1, 1).toString();
                            pName = table2.getModel().getValueAt(rowNum1, 2).toString();

                            int iitemQuan, iprice;
                            String icat, ipName;
                            int suggR;
                            if (selR==table2.getRowCount()-1){
                                suggR = -1;
                            }
                            else{
                                suggR=selR+1;
                            }

                            if (qtyTxt.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Enter valid quantity.");
                                qtyTxt.setText("");
                            } else {
                                quantity = Integer.parseInt(qtyTxt.getText());
                                if (quantity <= 0 || quantity > itemQuan) {
                                    JOptionPane.showMessageDialog(null, "Quantity to be purchased should be within the available stocks with 1 at minimum. Please Enter valid quantity to proceed.");
                                    qtyTxt.setText("");
                                } else {
                                    ordRow[2] = price;
                                    price = quantity * price;
                                    model.setValueAt(itemQuan - quantity, rowNum1, 5);
                                    ordRow[0] = cat;
                                    ordRow[1] = pName;
                                    ordRow[3] = quantity;
                                    ordRow[4] = price;
                                    ordRow[5] = model.getValueAt(rowNum1, 5);
                                    orderModel.addRow(ordRow);
                                    JOptionPane.showMessageDialog(null, "Added to cart successfully!");
                                    atcFrame.dispose();

                                    if(suggR!=-1){
                                        iitemQuan = Integer.parseInt(model.getValueAt(suggR, 5).toString());
                                        iprice = Integer.parseInt(model.getValueAt(suggR, 4).toString());

                                        icat = model.getValueAt(suggR, 1).toString();
                                        ipName = model.getValueAt(suggR, 2).toString();

                                        Object[] column11 = {"Category","Name","Quantity","Price"};
                                        Object[] suggRow = new Object[4];

                                        suggModel.setColumnIdentifiers(column11);

                                        suggRow[0] = icat;
                                        suggRow[1] = ipName;
                                        suggRow[2] = iitemQuan;
                                        suggRow[3] = iprice;
                                        suggModel.addRow(suggRow);
                                    }
                                }
                            }
                        });

                        cnPd.addActionListener(actionEvent16 -> atcFrame.dispose());
                    }
                });

                prBtn.addActionListener(actionEvent -> {
                    int tabR = orderTable.getRowCount();

                    if (tabR == 0) {
                        JOptionPane.showMessageDialog(null, "You have not yet added any product in your cart. Add to cart your desired item first.");
                    } else {
                        JFrame purchFrame = new JFrame("Order List");
                        purchFrame.setSize(1100, 500);
                        purchFrame.setResizable(false);
                        purchFrame.setVisible(true);
                        purchFrame.setLayout(null);
                        purchFrame.setLocationRelativeTo(null);
                        purchFrame.getContentPane().setBackground(new Color(0xA19F03))  ;

                        orderSp.setBounds(30, 200, 900, 400);
                        orderSp.setBorder(new EmptyBorder(15, 100, 10, 5));
                        purchFrame.add(orderSp);

                        JButton selBtn = new JButton("<html><center>BUY ANOTHER<br>PRODUCT</html>");
                        selBtn.setBounds(100, 50, 150, 100);
                        selBtn.setBackground(new Color(0x935515));
                        selBtn.setForeground(Color.WHITE);
                        purchFrame.add(selBtn);

                        JButton remBtn = new JButton("<html><center>REMOVE<br>PRODUCT</html>");
                        remBtn.setBounds(350, 50, 150, 100);
                        remBtn.setBackground(new Color(0x935515));
                        remBtn.setForeground(Color.WHITE);
                        purchFrame.add(remBtn);

                        JButton buyBtn = new JButton("<html><center>PRINT<br>RECEIPT</html>");
                        buyBtn.setBounds(550, 50, 150, 100);
                        buyBtn.setBackground(new Color(0x935515));
                        buyBtn.setForeground(Color.WHITE);
                        purchFrame.add(buyBtn);

                        selBtn.addActionListener(actionEvent13 -> purchFrame.dispose());

                        remBtn.addActionListener(actionEvent15 -> {
                            int rowSel = orderTable.getSelectedRow();
                            int quan, row1 =0, quan2=0;

                            if (rowSel < 0) {
                                JOptionPane.showMessageDialog(null, "Select product first.");
                            } else {
                                quan = Integer.parseInt(orderModel.getValueAt(rowSel, 3).toString());
                                for(int i=0; i<model.getRowCount();i++){
                                    if(model.getValueAt(i, 2).equals(orderModel.getValueAt(rowSel, 1))){
                                        quan2 = Integer.parseInt(model.getValueAt(i, 5).toString());
                                        row1 = i;
                                    }
                                }

                                model.setValueAt(quan + quan2, row1, 5);
                                orderModel.removeRow(rowSel);
                            }
                        });

                        buyBtn.addActionListener(actionEvent14 -> {
                            int rowCo = orderTable.getRowCount();

                            if (rowCo < 0) {
                                JOptionPane.showMessageDialog(null, "You don't have any order. Please return shopping.");
                            } else {

                                JFrame atcFrame = new JFrame("Order Code");
                                atcFrame.setSize(600, 600);
                                atcFrame.setLayout(null);
                                atcFrame.setVisible(true);
                                atcFrame.setLocationRelativeTo(null);

                                JLabel qty = new JLabel("Order Code", JLabel.RIGHT);
                                qty.setText("Order Code:");
                                qty.setBounds(0, 75, 130, 30);
                                atcFrame.add(qty);

                                JTextField codeTxt = new JTextField();
                                codeTxt.setBounds(200, 75, 200, 30);
                                atcFrame.add(codeTxt);

                                JButton ocBtn = new JButton("Enter");
                                ocBtn.setBounds(210, 150, 150, 50);
                                ocBtn.setBackground(new Color(10, 120, 80));
                                ocBtn.setForeground(Color.WHITE);
                                atcFrame.add(ocBtn);

                                JButton wcBtn = new JButton("<html><center>Proceed without<br>Order Code</html>");
                                wcBtn.setBounds(400, 150, 150, 50);
                                wcBtn.setBackground(new Color(120, 10, 10));
                                wcBtn.setForeground(Color.WHITE);
                                atcFrame.add(wcBtn);

                                JButton cnBtn = new JButton("Cancel");
                                cnBtn.setBounds(210, 230, 150, 50);
                                cnBtn.setBackground(new Color(120, 10, 10));
                                cnBtn.setForeground(Color.WHITE);
                                atcFrame.add(cnBtn);

                                ocBtn.addActionListener(actionEvent12 -> {
                                    int subtotal = 0, rowCo12 = orderTable.getRowCount();
                                    double discount;

                                    for (int i = 0; i< rowCo12; i++){
                                        subtotal += Integer.parseInt(orderModel.getValueAt(i, 4).toString());
                                    }

                                    if(subtotal>=799 && subtotal<1500){
                                        if(codeTxt.getText().equals("ph0131-o1")){
                                            discount = 70;
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Invalid Code");
                                        }
                                    }else if(subtotal>=1500 && subtotal<2500){
                                        if(codeTxt.getText().equals("ph0131-o2")){
                                            discount = 150;
                                            printRec(subtotal, rowCo12, discount);
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Invalid Code");
                                        }
                                    }else if(subtotal>=2500 && subtotal<4500){
                                        if(codeTxt.getText().equals("ph0131-o3")){
                                            discount = 350;
                                            printRec(subtotal, rowCo12, discount);
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Invalid Code");
                                        }
                                    } else if(subtotal>=4500){
                                        if(codeTxt.getText().equals("ph0131-o4")){
                                            discount = 850;
                                            printRec(subtotal, rowCo12, discount);
                                        }
                                        else{
                                            JOptionPane.showMessageDialog(null, "Invalid Code");
                                        }
                                    }
                                });

                                wcBtn.addActionListener(actionEvent1 -> {
                                    int subtotal = 0, rowCo1 = orderTable.getRowCount();
                                    double discount = 0;

                                    for (int i = 0; i< rowCo1; i++){
                                        subtotal += Integer.parseInt(orderModel.getValueAt(i, 4).toString());
                                    }

                                    printRec(subtotal, rowCo1, discount);
                                });

                                cnBtn.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent14) {
                                        atcFrame.dispose();
                                    }
                                });
                            }
                        });
                    }
                });

            });

            logoutButton.addActionListener(actionEvent -> {
                frame.dispose();
                admin.table(model, invModel, ordHModel);
                loginPage.main(args);
            });

            suggButton.addActionListener(e -> {
                scroll1.setVisible(false);
                scroll2.setVisible(true);
                scroll2.setBounds(0, 300, 1100, 400);
                scroll2.setBorder(new EmptyBorder(15, 100, 10, 5));
                frame.add(scroll2);

                JTable table3 = new JTable();
                Object[] column12 = {"Category","Name","Quantity","Price"};

                suggModel.setColumnIdentifiers(column12);
                table3.setModel(suggModel);
                scroll2.setViewportView(table3);
                table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            });

            frame.setVisible(true);
        }

    public static void printRec(int subtotal, int rowCo, double discount) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        StringBuilder items = new StringBuilder(" ");
        double total, price;

        JFrame recFrame = new JFrame("E-Receipt");
        recFrame.setSize(400, 900);
        recFrame.getContentPane().setBackground(new Color(0x935515));
        recFrame.setResizable(false);
        recFrame.setLayout(null);
        recFrame.setVisible(true);
        recFrame.setLocationRelativeTo(null);

        JLabel receiptLbl;
        receiptLbl = new JLabel("<html><center>SUPERMARKET<br>STORE</center></html>");
        receiptLbl.setBounds(110, 20, 400, 100);
        receiptLbl.setFont(new Font("Arial", java.awt.Font.PLAIN, 30));
        receiptLbl.setForeground(Color.WHITE);
        recFrame.add(receiptLbl);

        JLabel listLbl;
        int yAx = 120;

        Object[] column = {"ID","Category","Name","Brand","Price", "Quantity","Description"};
        Object[] invRow = new Object[7];
        invModel.setColumnIdentifiers(column);

        Object[] col = {"Customer #", "No of Orders", "Items", "Total Price"};
        Object[] ordHrow = new Object[4];
        ordHModel.setColumnIdentifiers(col);

        for (int i = 0; i < rowCo; i++) {
            listLbl = new JLabel(orderModel.getValueAt(i, 1).toString());
            listLbl.setBounds(15, yAx, 400, 50);
            listLbl.setFont(new Font("Arial", java.awt.Font.BOLD, 20));
            listLbl.setForeground(Color.WHITE);
            recFrame.add(listLbl);

            listLbl = new JLabel("x" + orderModel.getValueAt(i, 3).toString());
            listLbl.setBounds(100, yAx, 400, 50);
            listLbl.setFont(new Font("Arial", java.awt.Font.PLAIN, 20));
            listLbl.setForeground(Color.WHITE);
            recFrame.add(listLbl);

            listLbl = new JLabel("Php" + orderModel.getValueAt(i, 2).toString());
            listLbl.setBounds(250, yAx, 400, 50);
            listLbl.setFont(new Font("Arial", java.awt.Font.PLAIN, 20));
            listLbl.setForeground(Color.WHITE);
            recFrame.add(listLbl);

            listLbl = new JLabel(" Total: Php" + orderModel.getValueAt(i, 4).toString());
            listLbl.setBounds(250, yAx+=50, 400, 50);
            listLbl.setFont(new Font("Arial", java.awt.Font.PLAIN, 20));
            listLbl.setForeground(Color.WHITE);
            recFrame.add(listLbl);

            invRow [0] = orderModel.getValueAt(i, 1).toString();
            invRow [1] = Integer.parseInt(orderModel.getValueAt(i,5).toString()) + Integer.parseInt(orderModel.getValueAt(i, 3).toString());
            invRow [2] = orderModel.getValueAt(i, 3).toString();
            invRow [3] = orderModel.getValueAt(i,5).toString();
            invRow [4] = Integer.parseInt(orderModel.getValueAt(i, 4).toString()) / Integer.parseInt(orderModel.getValueAt(i, 3).toString());
            invRow [5] = orderModel.getValueAt(i, 4).toString();
            invRow [6] = date.toString();
            invModel.addRow(invRow);

            items.append(orderModel.getValueAt(i, 1).toString()).append(" ");

            yAx += 50;
        }

        receiptLbl = new JLabel("__________________________________");
        receiptLbl.setBounds(10, yAx += 50, 400, 100);
        receiptLbl.setFont(new Font("Arial", java.awt.Font.BOLD, 20));
        receiptLbl.setForeground(Color.WHITE);
        recFrame.add(receiptLbl);

        if (discount!=0){
            receiptLbl = new JLabel("Subtotal:");
            receiptLbl.setBounds(15, yAx += 50, 400, 100);
            receiptLbl.setFont(new Font("Arial", java.awt.Font.ITALIC, 20));
            receiptLbl.setForeground(Color.WHITE);
            recFrame.add(receiptLbl);

            receiptLbl = new JLabel("Php " + subtotal);
            receiptLbl.setBounds(250, yAx, 400, 100);
            receiptLbl.setFont(new Font("Arial", java.awt.Font.ITALIC, 20));
            receiptLbl.setForeground(Color.WHITE);
            recFrame.add(receiptLbl);

            receiptLbl = new JLabel("Discount :");
            receiptLbl.setBounds(15, yAx += 50, 400, 100);
            receiptLbl.setFont(new Font("Arial", java.awt.Font.ITALIC, 20));
            receiptLbl.setForeground(Color.WHITE);
            recFrame.add(receiptLbl);

            receiptLbl = new JLabel("Php " + discount);
            receiptLbl.setBounds(250, yAx, 400, 100);
            receiptLbl.setFont(new Font("Arial", java.awt.Font.ITALIC, 20));
            receiptLbl.setForeground(Color.WHITE);
            recFrame.add(receiptLbl);

            total = subtotal - discount;
        }
        else{
            total = subtotal;
        }

        receiptLbl = new JLabel("Total:");
        receiptLbl.setBounds(15, yAx += 50, 400, 100);
        receiptLbl.setFont(new Font("Arial", java.awt.Font.BOLD, 20));
        receiptLbl.setForeground(Color.WHITE);
        recFrame.add(receiptLbl);

        receiptLbl = new JLabel("Php " + total);
        receiptLbl.setBounds(250, yAx, 400, 100);
        receiptLbl.setFont(new Font("Arial", java.awt.Font.BOLD, 20));
        receiptLbl.setForeground(Color.WHITE);
        recFrame.add(receiptLbl);

        receiptLbl = new JLabel(date.toString());
        receiptLbl.setBounds(50, yAx + 100, 400, 100);
        receiptLbl.setFont(new Font("Arial", java.awt.Font.ITALIC, 20));
        receiptLbl.setForeground(Color.WHITE);
        recFrame.add(receiptLbl);

        ordHrow[1] = rowCo;
        ordHrow[2] = items.toString();
        ordHrow[3] = total;
        ordHModel.addRow(ordHrow);

        for(int i=0; i<rowCo; i++){
            orderModel.removeRow(0);
        }
    }
    public static void table(DefaultTableModel model, DefaultTableModel invModel, DefaultTableModel ordHModel) {
            customer.tempModel = model;
            customer.invModel = invModel;
            customer.ordHModel = ordHModel;
    }
}
