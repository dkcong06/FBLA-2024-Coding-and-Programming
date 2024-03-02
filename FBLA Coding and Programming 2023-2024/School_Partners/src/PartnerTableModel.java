 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.table.AbstractTableModel;

public class PartnerTableModel extends AbstractTableModel {
    private static final long serialVersionUID = 1L;
    private File file;
    private ArrayList<Object[]> data;
    
    private String[] columnNames = new String[] { 
            "Name",  "Type of Organization", "Resources Avaliable",
            "Amount Donated",   "Contact Information",  "Date"
    }; 
    private Class[] columnClasses = new Class[] { 
        String.class, String.class, String.class,  
        Float.class, String.class, LocalDate.class
    };
    
    /*
     * Constructor using stream
     */
    
    public PartnerTableModel(InputStream reader) {
        //file = file;
        data = new ArrayList<Object[]>();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(reader));
            String line;
            while ((line = br.readLine()) != null) {
                String[] tmp = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                //System.out.println(tmp.length);
                Object[] value = new Object[this.columnNames.length];
                for( int i = 0; i < tmp.length; i++) {
                    tmp[i] = tmp[i].trim(); // remove trailing space
                    tmp[i] = tmp[i].substring(1, tmp[i].length() - 1 ); // remove " at start and end of string
                    switch(i) {
                        case 5: // convert string to date
                        	//System.out.println(tmp[i]);
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy", Locale.ENGLISH);
                            value[i] = LocalDate.parse(tmp[i], formatter);
                            break;
                        case 3: // convert money to float
                            value[i] = Float.parseFloat(tmp[i]);
                            break;
                        default:
                            value[i] = tmp[i];
                    } 
                }
                data.add(value);  
            }
            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
    /*
    @Override
    
    public Class getColumnClass(int col) {
        return columnClasses[col];
    }
    */
    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return data.get(rowIndex)[columnIndex];
    }
    
    public void addPartner(Object[] newPartner) {
        data.add(newPartner);
    }

}
