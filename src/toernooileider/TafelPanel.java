/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toernooileider;

/**
 *
 * @author jannedevos
 */
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class TafelPanel extends javax.swing.JPanel {

    private String voorletter;
    private ToernooiLeiderView toernooi;
    private int setEvenement;
    private String sorteren = "Speler.naam, Speler.voorletters";
    /**
     * Creates new form TafelPanel
     */
    public TafelPanel() {
        initComponents();
        getTafelView();
        
        
    }

    public TafelPanel(ToernooiLeiderView toernooi) {
        initComponents();
        getTafelView();
        this.toernooi = toernooi;
        
    }
    
    public void setEvenementID(int evenementID)
    {
        setEvenement = evenementID;
        getTafelView();
        System.out.println(evenementID);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rondeNummer = new javax.swing.JComboBox();
        positieNummer = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tafelTabel = new javax.swing.JTable();
        sorteerNaam = new javax.swing.JButton();
        sorteerTafel = new javax.swing.JButton();

        rondeNummer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        positieNummer.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tafelTabel.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tafelTabel);

        sorteerNaam.setText("Naam");
        sorteerNaam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sorteerNaamMouseClicked(evt);
            }
        });

        sorteerTafel.setText("Tafel");
        sorteerTafel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sorteerTafelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(sorteerNaam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sorteerTafel, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rondeNummer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(positieNummer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rondeNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sorteerNaam)
                    .addComponent(sorteerTafel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(positieNummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(493, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sorteerNaamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sorteerNaamMouseClicked
        sorteren = "Speler.naam, Speler.voorletters";
        getTafelView();
    }//GEN-LAST:event_sorteerNaamMouseClicked

    private void sorteerTafelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sorteerTafelMouseClicked
        sorteren = "ToernooiInschrijving.tafelNr";
        getTafelView();
    }//GEN-LAST:event_sorteerTafelMouseClicked

    
    
    private void getTafelView() {
        String query = "SELECT Speler.naam, Speler.voorletters, ToernooiInschrijving.tafelNr "
                + "FROM ToernooiInschrijving "
                + "JOIN Speler "
                + "ON ToernooiInschrijving.spelerID = Speler.spelerID "
                + "WHERE ToernooiInschrijving.isUitgeschakeld IS false "
                + "AND ToernooiInschrijving.evenementID = ? "
                + "ORDER BY " + sorteren + " ASC;";
        try {
            Connection conn = SimpleDataSource.getConnection();
            PreparedStatement stat = conn.prepareStatement(query);
            stat.setInt(1, setEvenement);
            ResultSet result = stat.executeQuery();
            fillTable(result);
            result.close();
            stat.close();
        } catch (Exception e) {
            //FullHouse.showDBError(e);
            System.out.println(e);
        }
    }

    private void fillTable(ResultSet result) throws SQLException {
        String[] columnNames = {"Naam", "Voorletters", "Tafel nummer"};
        DefaultTableModel model = new DefaultTableModel();
        model.setDataVector(new Object[][]{}, columnNames);
        while (result.next()) {
            String naam = result.getString("naam");
            voorletter = result.getString("voorletters");
            int ID = result.getInt("tafelNr");
            Object[] rowData = {naam, voorletter, ID};
            model.addRow(rowData);
        }
        tafelTabel.setModel(model);
        result.close();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox positieNummer;
    private javax.swing.JComboBox rondeNummer;
    private javax.swing.JButton sorteerNaam;
    private javax.swing.JButton sorteerTafel;
    private javax.swing.JTable tafelTabel;
    // End of variables declaration//GEN-END:variables
}