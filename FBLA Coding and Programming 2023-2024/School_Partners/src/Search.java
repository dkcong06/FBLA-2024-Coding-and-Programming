 

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;

public class Search extends JDialog {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField searchBar;
    private JTable partnerTable;
    private TableRowSorter<PartnerTableModel> sorter; // this is used for search
    
    /**
     * Create the dialog.
     */
    public Search(PartnerTableModel partnerModel) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(0, 0, 1400, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //main text
        JLabel searchMainText = new JLabel("Search for Partners");
        searchMainText.setHorizontalAlignment(SwingConstants.CENTER);
        searchMainText.setForeground(Color.RED);
        searchMainText.setFont(new Font("Sylfaen", Font.BOLD, 70));
        searchMainText.setBackground(Color.RED);
        searchMainText.setBounds(119, 29, 1148, 149);
        contentPane.add(searchMainText);
        
        //search bar
        searchBar = new JTextField();
        searchBar.setFont(new Font("Sylfaen", Font.PLAIN, 21));
        searchBar.setBackground(new Color(255, 255, 224));
        searchBar.setBounds(218, 178, 430, 59);
        contentPane.add(searchBar);
        searchBar.setColumns(10);
        
        //label for search bar
        JLabel searchLabel = new JLabel("Search:");
        searchLabel.setFont(new Font("Sylfaen", Font.PLAIN, 45));
        searchLabel.setForeground(new Color(255, 0, 0));
        searchLabel.setBounds(73, 189, 137, 54);
        contentPane.add(searchLabel);
        
        //background for table
        JPanel panel = new JPanel();
        panel.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 0, 0)));
        panel.setBackground(new Color(255, 255, 224));
        panel.setBounds(51, 254, 1284, 460);
        contentPane.add(panel);
        panel.setLayout(null);
        
    
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 1264, 438);
        panel.add(scrollPane);
        
        //table for partners
        partnerTable = new JTable();
        partnerTable.setFont(new Font("Sylfaen", Font.PLAIN, 12));
        partnerTable.setModel(partnerModel);
        
        partnerTable.setBackground(new Color(255, 255, 255));
        partnerTable.setForeground(new Color(0, 0, 0));
        scrollPane.setViewportView(partnerTable);
        
        //submit button for search bar
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Sylfaen", Font.PLAIN, 38));
        submitButton.setBounds(667, 178, 181, 59);
        contentPane.add(submitButton);
        
        JButton btnResetButton = new JButton("Reset");
        btnResetButton.setFont(new Font("Sylfaen", Font.PLAIN, 38));
        btnResetButton.setBounds(908, 178, 181, 59);
        contentPane.add(btnResetButton);
        
        sorter = new TableRowSorter<PartnerTableModel>(partnerModel);
        partnerTable.setRowSorter(sorter);
        
        // add event listener
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFilter();
            }
        });
        btnResetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchBar.setText("");
                newFilter();
            }
        });
        
        this.setModal(true);
        
    }
    
    //search function by filter
    private void newFilter(){
        RowFilter<PartnerTableModel, Object> rf = null;
        try{
            rf = RowFilter.regexFilter(searchBar.getText(), 0, 1, 2, 3, 4, 5);
        } catch (java.util.regex.PatternSyntaxException e) {
          return;
        }
        sorter.setRowFilter(rf);
    }
}
