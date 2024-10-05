import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class inputjdbc extends JFrame {
    private JTextField idField, nameField, addressField;
    private JButton insertButton, prevButton, nextButton;
    private JLabel resultLabel;
    private Connection con;
    private ResultSet rs;

    public inputjdbc() {
        setTitle("JDBC Input Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        idField = new JTextField(10);
        nameField = new JTextField(10);
        addressField = new JTextField(10);

        insertButton = new JButton("Insert");
        prevButton = new JButton("Previous");
        nextButton = new JButton("Next");

        resultLabel = new JLabel("Result: ");

        add(new JLabel("ID:"));
        add(idField);
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Address:"));
        add(addressField);
        add(insertButton);
        add(prevButton);
        add(nextButton);
        add(resultLabel);

        insertButton.addActionListener(new InsertAction());
        prevButton.addActionListener(new PrevAction());
        nextButton.addActionListener(new NextAction());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
            loadFirstRecord();
        } catch (Exception e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    private void loadFirstRecord() {
        try {
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery("SELECT * FROM emp");
            if (rs.next()) {
                displayRecord();
            } else {
                resultLabel.setText("No records found.");
            }
        } catch (SQLException e) {
            resultLabel.setText("Error: " + e.getMessage());
        }
    }

    private void displayRecord() throws SQLException {
        idField.setText(String.valueOf(rs.getInt(1)));
        nameField.setText(rs.getString(2));
        addressField.setText(rs.getString(3));
    }

    private class InsertAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                String address = addressField.getText();

                PreparedStatement psmt = con.prepareStatement("INSERT INTO emp VALUES (?, ?, ?)");
                psmt.setInt(1, id);
                psmt.setString(2, name);
                psmt.setString(3, address);

                psmt.execute();
                psmt.close(); // Close statement after execution

                resultLabel.setText("Inserted record.");
                clearFields();  // Clear fields after insertion
                loadFirstRecord();  // Reload records after insertion

            } catch (SQLIntegrityConstraintViolationException ex) {
                resultLabel.setText("ID must be unique: " + ex.getMessage());
            } catch (Exception ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private class PrevAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (rs.previous()) {
                    displayRecord();
                } else {
                    resultLabel.setText("No previous record.");
                }
            } catch (SQLException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private class NextAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (rs.next()) {
                    displayRecord();
                } else {
                    resultLabel.setText("No next record.");
                }
            } catch (SQLException ex) {
                resultLabel.setText("Error: " + ex.getMessage());
            }
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        addressField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            inputjdbc frame = new inputjdbc();
            frame.setVisible(true);
        });
    }
}
