package com.supermarket;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class admin extends loginPage{

    private static DefaultTableModel tempModel;
    private static DefaultTableModel tempinvModel;
    private static DefaultTableModel invModel = new DefaultTableModel();
    private static DefaultTableModel ordHModel = new DefaultTableModel();

    public static void main(String[] args) {
        JFrame frame = new JFrame("Manage Products");
        frame.setSize(1320, 750);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel adminHeader;
        adminHeader = new JLabel("ADMIN");
        adminHeader.setBounds(600, 60, 1100 , 50);
        adminHeader.setFont(new Font("Arial", java.awt.Font.PLAIN, 50));
        adminHeader.setForeground(Color.white);
        frame.add(adminHeader);

        JPanel ad = new JPanel();
        ad.setBounds(0,30,1320,120);
        ad.setBackground(new Color(0x9DE893));
        frame.add(ad);

        JButton addButton = new JButton("ADD PRODUCT");
        addButton.setBounds(0, 160, 200 , 100);
        addButton.setFont(new Font("Arial", java.awt.Font.BOLD,20));
        addButton.setBackground(new Color(129, 164, 148));
        addButton.setForeground(Color.WHITE);
        frame.add(addButton);

        JButton editButton = new JButton("EDIT PRODUCT");
        editButton.setBounds(220, 160, 200 , 100);
        editButton.setFont(new Font("Arial", java.awt.Font.BOLD,20));
        editButton.setBackground(new Color(199, 185, 153));
        editButton.setForeground(Color.WHITE);
        frame.add(editButton);

        JButton removeButton = new JButton("REMOVE");
        removeButton.setBounds(440, 160, 200 , 100);
        removeButton.setBackground(new Color(208, 168, 132));
        removeButton.setFont(new Font("Arial", java.awt.Font.BOLD,20));
        removeButton.setForeground(Color.WHITE);
        frame.add(removeButton);

        JButton inventoryButton = new JButton("MY INVENTORY");
        inventoryButton.setBounds(680, 160, 200 , 100);
        inventoryButton.setBackground(new Color(217, 124, 127));
        inventoryButton.setFont(new Font("Arial", java.awt.Font.BOLD,20));
        inventoryButton.setForeground(Color.WHITE);
        frame.add(inventoryButton);

        JButton orderHistoryButton = new JButton("<html><center>ORDER<br>HISTORY</html>");
        orderHistoryButton.setBounds(900, 160, 200 , 100);
        orderHistoryButton.setBackground(new Color(0xB9767E));
        orderHistoryButton.setFont(new Font("Arial", java.awt.Font.BOLD,20));
        orderHistoryButton.setForeground(Color.WHITE);
        frame.add(orderHistoryButton);

        JButton logoutButton = new JButton("LOG OUT");
        logoutButton.setFont(new Font("Arial", java.awt.Font.BOLD,25));
        logoutButton.setBounds(1120, 160, 200 , 100);
        logoutButton.setBackground(new Color(0x64AF12));
        logoutButton.setForeground(Color.WHITE);
        frame.add(logoutButton);

        ad = new JPanel();
        ad.setBounds(0,120,250,600);
        ad.setBackground(new Color(0x252424));
        frame.add(ad);

        JScrollPane sp = new JScrollPane();
        sp.setBounds(250,330,830,400);
        sp.setBorder(new EmptyBorder(15,100,10,5));
        frame.add(sp);

        JTable table1 = new JTable();
        DefaultTableModel model = new DefaultTableModel();

        Object[] column = {"ID","Category","Name","Brand","Price", "Quantity","Description"};
        Object[] row = new Object[7];
        model.setColumnIdentifiers(column);
        table1.setModel(model);
        sp.setViewportView(table1);
        table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        if (tempModel!=null){
            int rowC = tempModel.getRowCount();
            for(int i = 0; i<rowC; i++){
                row[0] = tempModel.getValueAt(i,0);
                row[1] = tempModel.getValueAt(i,1);
                row[2] = tempModel.getValueAt(i,2);
                row[3] = tempModel.getValueAt(i,3);
                row[4] = tempModel.getValueAt(i,4);
                row[5] = tempModel.getValueAt(i,5);
                row[6] = tempModel.getValueAt(i,6);
                model.addRow(row);
            }
        }

        ad = new JPanel();
        ad.setBounds(250,190,850,490);
        ad.setBackground(new Color(0x2C2929));
        frame.add(ad);

        ad = new JPanel();
        ad.setBounds(500,190,850,490);
        ad.setBackground(new Color(0x2C2929));
        frame.add(ad);

        editButton.addActionListener(e -> {
            int rows = table1.getRowCount();
            int selR = table1.getSelectedRow();
            String name, des, brand, price, quant, id, cat;

            if (rows==0){
                JOptionPane.showMessageDialog(null, "No products provided in the table. Add products first.");
            }
            else if(selR<0){
                JOptionPane.showMessageDialog(null, "Select product first.");
            }
            else{
                id = model.getValueAt(selR, 0).toString();
                cat = model.getValueAt(selR, 1).toString();
                name = model.getValueAt(selR, 2).toString();
                brand = model.getValueAt(selR, 3).toString();
                price = model.getValueAt(selR, 4).toString();
                quant = model.getValueAt(selR, 5).toString();
                des = model.getValueAt(selR, 6).toString();

                JFrame frame3 = new JFrame("Edit Product List");
                frame3.setSize(400, 600);
                frame3.setLayout(null);
                frame3.setVisible(true);
                frame3.setLocationRelativeTo(null);

                JLabel idText = new JLabel("ID", JLabel.RIGHT);
                idText.setText("ID:");
                idText.setBounds(-30,25,130,30);
                frame3.add(idText);

                JLabel categoryText = new JLabel("Category", JLabel.RIGHT);
                categoryText.setText("Category:");
                categoryText.setBounds(-50,60,150,50);
                frame3.add(categoryText);

                JLabel nameText = new JLabel("Name", JLabel.RIGHT);
                nameText.setText("Name:");
                nameText.setBounds(-30,120,130,30);
                frame3.add(nameText);

                JLabel brandText = new JLabel("Brand", JLabel.RIGHT);
                brandText.setText("Brand:");
                brandText.setBounds(-30,170,130,30);
                frame3.add(brandText);

                JLabel priceText = new JLabel("Price", JLabel.RIGHT);
                priceText.setText("Price:");
                priceText.setBounds(-30,220,130,30);
                frame3.add(priceText);

                JLabel quantityText = new JLabel("Quantity", JLabel.RIGHT);
                quantityText.setText("Quantity:");
                quantityText.setBounds(-30,268,130,30);
                frame3.add(quantityText);

                JLabel descriptionText = new JLabel("Description", JLabel.RIGHT);
                descriptionText.setText("Description:");
                descriptionText.setBounds(-30,313,130,30);
                frame3.add(descriptionText);

                JTextField textField = new JTextField();
                textField.setBounds(150, 25, 200, 30);
                frame3.add(textField);
                textField.setText(id);

                textField.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();
                        }
                    }
                });

                String languages[]={"BAKING","DRY GOODS","CANNED GOODS","FROZEN FOODS","CLEANING PRODUCTS","PAPER PRODUCTS"};
                final JComboBox cb=new JComboBox(languages);
                cb.setBounds(150, 77,200,20);
                frame3.add(cb);
                cb.setSelectedItem(cat);

                JTextField nametextField = new JTextField();
                nametextField.setBounds(150, 120, 200, 30);
                frame3.add(nametextField);
                nametextField.setText(name);

                JTextField brandAdmin = new JTextField();
                brandAdmin.setBounds(150, 170, 200, 30);
                frame3.add(brandAdmin);
                brandAdmin.setText(brand);

                JTextField priceAdmin = new JTextField();
                priceAdmin.setBounds(150, 220, 200, 30);
                frame3.add(priceAdmin);
                priceAdmin.setText(price);

                priceAdmin.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();
                        }
                    }
                });

                JTextField qtyAdmin = new JTextField();
                qtyAdmin.setBounds(150, 270, 200, 30);
                frame3.add(qtyAdmin);
                qtyAdmin.setText(quant);

                qtyAdmin.addKeyListener(new KeyAdapter() {
                    public void keyTyped(KeyEvent e) {
                        char c = e.getKeyChar();
                        if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                            e.consume();
                        }
                    }
                });

                JTextField descAdmin = new JTextField();
                descAdmin.setBounds(150, 320, 200, 60);
                frame3.add(descAdmin);
                descAdmin.setText(des);

                JButton editBtn = new JButton("SAVE");
                editBtn.setBounds(210, 420, 150 , 50);
                editBtn.setBackground(new Color(10,120,80));
                editBtn.setForeground(Color.WHITE);
                frame3.add(editBtn);

                editBtn.addActionListener(actionEvent -> {
                    if (textField.getText().equals("")||cb.getSelectedItem().equals("")||nametextField.getText().equals("")|| brandAdmin.getText().equals("")|| priceAdmin.getText().equals("")|| qtyAdmin.getText().equals("")|| descAdmin.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Provide all information required.");
                    }
                    else{
                        model.setValueAt(textField.getText(), selR, 0);
                        model.setValueAt(cb.getSelectedItem(), selR, 1);
                        model.setValueAt(nametextField.getText(), selR, 2);
                        model.setValueAt(brandAdmin.getText(), selR, 3);
                        model.setValueAt(priceAdmin.getText(), selR, 4);
                        model.setValueAt(qtyAdmin.getText(), selR, 5);
                        model.setValueAt(descAdmin.getText(), selR, 6);
                    }
                });

                JButton cancelBtn = new JButton("Cancel");
                cancelBtn.setBounds(20, 420, 150 , 50);
                cancelBtn.setBackground(new Color(255,20,30));
                cancelBtn.setForeground(Color.WHITE);
                frame3.add(cancelBtn);

                cancelBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        frame3.dispose();
                    }
                });
            }

        });

        addButton.addActionListener(e -> {

            JFrame frame2 = new JFrame("Add Product");
            frame2.setSize(400, 600);
            frame2.setLayout(null);
            frame2.setVisible(true);
            frame2.setLocationRelativeTo(null);

            JLabel idlabel = new JLabel("ID", JLabel.RIGHT);
            idlabel.setText("ID:");
            idlabel.setBounds(-30,25,130,30);
            frame2.add(idlabel);

            JLabel categorylabel = new JLabel("Category", JLabel.RIGHT);
            categorylabel.setText("Category:");
            categorylabel.setBounds(-50,60,150,50);
            frame2.add(categorylabel);

            JLabel namelabel = new JLabel("Name", JLabel.RIGHT);
            namelabel.setText("Name:");
            namelabel.setBounds(-30,120,130,30);
            frame2.add(namelabel);

            JLabel brandlabel = new JLabel("Brand", JLabel.RIGHT);
            brandlabel.setText("Brand:");
            brandlabel.setBounds(-30,170,130,30);
            frame2.add(brandlabel);

            JLabel pricelabel = new JLabel("Price", JLabel.RIGHT);
            pricelabel.setText("Price:");
            pricelabel.setBounds(-30,220,130,30);
            frame2.add(pricelabel);

            JLabel quantitylabel = new JLabel("Quantity", JLabel.RIGHT);
            quantitylabel.setText("Quantity:");
            quantitylabel.setBounds(-30,268,130,30);
            frame2.add(quantitylabel);

            JLabel descriptionlabel = new JLabel("Description", JLabel.RIGHT);
            descriptionlabel.setText("Description:");
            descriptionlabel.setBounds(-30,313,130,30);
            frame2.add(descriptionlabel);

            JTextField idtextField = new JTextField();
            idtextField.setBounds(150, 25, 200, 30);
            frame2.add(idtextField);

            idtextField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();
                    }
                }
            });

            String languages[]={"BAKING","DRY GOODS","CANNED GOODS","FROZEN FOODS","CLEANING PRODUCTS","PAPER PRODUCTS"};
            final JComboBox cb=new JComboBox(languages);
            cb.setBounds(150, 77,200,20);
            frame2.add(cb);


            JTextField nametextField = new JTextField();
            nametextField.setBounds(150, 120, 200, 30);
            frame2.add(nametextField);


            JTextField brandtextField = new JTextField();
            brandtextField.setBounds(150, 170, 200, 30);
            frame2.add(brandtextField);


            JTextField pricetextField = new JTextField();
            pricetextField.setBounds(150, 220, 200, 30);
            frame2.add(pricetextField);

            pricetextField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();
                    }
                }
            });


            JTextField qntytextField = new JTextField();
            qntytextField.setBounds(150, 270, 200, 30);
            frame2.add(qntytextField);

            qntytextField.addKeyListener(new KeyAdapter() {
                public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                        e.consume();
                    }
                }
            });

            JTextField descriptextField = new JTextField();
            descriptextField.setBounds(150, 320, 200, 60);
            frame2.add(descriptextField);

            JButton addBtn = new JButton("Add");
            addBtn.setBounds(210, 420, 150 , 50);
            addBtn.setBackground(new Color(10,120,80));
            addBtn.setForeground(Color.WHITE);
            frame2.add(addBtn);

            addBtn.addActionListener(e12 -> {
                if (idtextField.getText().equals("")||cb.getSelectedItem().equals("")||nametextField.getText().equals("")||brandtextField.getText().equals("")||pricetextField.getText().equals("")||qntytextField.getText().equals("")||descriptextField.getText().equals(""))
                {
                    JOptionPane.showMessageDialog(null, "Provide all information required.");
                }
                else{
                    int rows = model.getRowCount();
                    String tempID;
                    boolean isTaken = false;

                    for(int i=0; i<rows; i++){
                        tempID = model.getValueAt(i, 0).toString();
                        if(tempID.equals(idtextField.getText())){
                            isTaken = true;
                        }
                    }
                    if(isTaken){
                        JOptionPane.showMessageDialog(null, "Item is already in the table.");
                    }
                    else{
                        row[0] = idtextField.getText();
                        row[1] = cb.getSelectedItem();
                        row[2] = nametextField.getText();
                        row[3] = brandtextField.getText();
                        row[4] = pricetextField.getText();
                        row[5] = qntytextField.getText();
                        row[6] = descriptextField.getText();
                        model.addRow(row);

                        idtextField.setText("");
                        cb.setSelectedItem("");
                        nametextField.setText("");
                        brandtextField.setText("");
                        pricetextField.setText("");
                        qntytextField.setText("");
                        descriptextField.setText("");
                        JOptionPane.showMessageDialog(null, "You have successfully added the product!");
                    }
                }
            });

            JButton cancelBtn = new JButton("Cancel");
            cancelBtn.setBounds(20, 420, 150 , 50);
            cancelBtn.setBackground(new Color(255,20,30));
            cancelBtn.setForeground(Color.WHITE);
            frame2.add(cancelBtn);

            cancelBtn.addActionListener(e1 -> frame2.dispose());

        });

        removeButton.addActionListener(e -> {
            int i = table1.getSelectedRow();
            if(i >= 0){
                model.removeRow(i);
                JOptionPane.showMessageDialog(null, "Item Removed Successfully");
            }
            else{
                JOptionPane.showMessageDialog(null, "Select a product you want to remove.");
            }
        });

        inventoryButton.addActionListener(actionEvent -> {

                JFrame invFrame = new JFrame("INVENTORY LOG");
                invFrame.setSize(1100, 500);
                invFrame.setResizable(false);
                invFrame.setVisible(true);
                invFrame.setLayout(null);
                invFrame.setLocationRelativeTo(null);
                invFrame.getContentPane().setBackground(new Color(0x161642));

                JScrollPane sp1 = new JScrollPane();
                sp1.setBounds(50,50,830,400);
                sp1.setBorder(new EmptyBorder(15,100,10,5));
                invFrame.add(sp1);

                JTable invTable = new JTable();
                Object[] column12 = {"Name", "Quantity Start", "Quantity Sold", "Quantity End", "Product Price", "Cost","Date"};

                invModel.setColumnIdentifiers(column12);
                invTable.setModel(invModel);
                sp1.setViewportView(invTable);
                invTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        });

        orderHistoryButton.addActionListener(actionEvent -> {

            JFrame ordFrame = new JFrame("ORDER HISTORY LOG");
            ordFrame.setSize(1100, 500);
            ordFrame.setResizable(false);
            ordFrame.setVisible(true);
            ordFrame.setLayout(null);
            ordFrame.setLocationRelativeTo(null);
            ordFrame.getContentPane().setBackground(new Color(0x161642));

            JScrollPane sp1 = new JScrollPane();
            sp1.setBounds(50,50,830,400);
            sp1.setBorder(new EmptyBorder(15,100,10,5));
            ordFrame.add(sp1);

            JTable ordhTable = new JTable();
            Object[] column1 = {"Customer #", "No of Orders", "Items", "Total Price"};

            ordHModel.setColumnIdentifiers(column1);
            ordhTable.setModel(ordHModel);
            sp1.setViewportView(ordhTable);
            ordhTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

            if(ordHModel!=null){
                int rowCo = ordhTable.getRowCount();

                for(int i=0; i<rowCo;i++){
                    ordHModel.setValueAt(i+1,i,0);
                }
            }

        });

        logoutButton.addActionListener(actionEvent -> {
            frame.dispose();

            customer.table(model, invModel, ordHModel);
            loginPage.main(args);
        });

        table1.setVisible(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void table(DefaultTableModel model, DefaultTableModel invModel, DefaultTableModel ordHModel) {
        admin.tempModel = model;
        admin.tempinvModel = invModel;
        admin.ordHModel = ordHModel;
    }
}