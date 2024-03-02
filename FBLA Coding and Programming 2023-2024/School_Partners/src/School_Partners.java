import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class School_Partners extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private PartnerTableModel partnerModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Class myClass = Class.forName("School_Partners");
                    InputStream res = myClass.getResourceAsStream("Partners.csv");
                    School_Partners frame = new School_Partners(res);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    //dimensions
    public School_Partners(InputStream res) {
        
        partnerModel = new PartnerTableModel(res);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1400, 800);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        //search bar
        JButton searchButton = new JButton("Search");
        searchButton.setForeground(new Color(255, 0, 0));
        searchButton.setBackground(new Color(255, 255, 255));
        searchButton.setFont(new Font("Sylfaen", Font.BOLD, 72));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Search searchbar = new Search(partnerModel);
                searchbar.setVisible(true);
            }
        });
        searchButton.setBounds(67, 395, 338, 230);
        contentPane.add(searchButton);
        
        //collect button for business partners
        JButton submitButton = new JButton("Submit");
        submitButton.setForeground(new Color(255, 0, 0));
        submitButton.setFont(new Font("Sylfaen", Font.BOLD, 72));
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Collect collectBar = new Collect(partnerModel);
                collectBar.setVisible(true);
            }
        });
        submitButton.setBackground(new Color(255, 255, 255));
        submitButton.setBounds(472, 395, 338, 230);
        contentPane.add(submitButton);
        
        //help button / q&a
        JButton helpButton = new JButton("Help");
        helpButton.setForeground(new Color(255, 0, 0));
        helpButton.setFont(new Font("Sylfaen", Font.BOLD, 72));
        helpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Help helpBar = new Help();
                helpBar.setVisible(true);
            }
        });
        helpButton.setBackground(new Color(255, 255, 255));
        helpButton.setBounds(877, 395, 338, 230);
        contentPane.add(helpButton);
        
        //main label 
        JLabel lblNewLabel = new JLabel("WEHS Business and Community Partners");
        lblNewLabel.setBackground(new Color(255, 0, 0));
        lblNewLabel.setForeground(new Color(255, 0, 0));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 60));
        lblNewLabel.setBounds(67, 59, 1148, 257);
        contentPane.add(lblNewLabel);
    }
}
